package app.data;

import app.character.Character;
import app.character.Characters;
import app.character.Identity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static app.data.GameAreaView.BOAT_AREA;
import static app.data.GameAreaView.END_AREA;
import static app.data.GameAreaView.START_AREA;
import static app.data.GameAreaView.values;

/**
 * @author harrison
 */
public class GameState {
    private static final int BOAT_CAPACITY = 2;
    private static final int TOTAL_PEOPLE = 8;

    private static Map<GameAreaView, GameArea> initialGameArea() {
        return Map.of(
                START_AREA, new GameArea(Characters.getDefaultCharacters()),
                BOAT_AREA, new GameArea(new ArrayList<>(BOAT_CAPACITY)),
                END_AREA, new GameArea(new ArrayList<>(TOTAL_PEOPLE))
        );
    }

    private final boolean isEnded;
    private final int operations;

    final Map<GameAreaView, GameArea> gameArea;

    public GameState() {
        this(initialGameArea(), 0);
    }

    public GameState(Map<GameAreaView, GameArea> gameArea, int operations) {
        this.gameArea = gameArea;
        this.isEnded = gameArea.get(START_AREA).characters().isEmpty() && gameArea.get(BOAT_AREA).characters().isEmpty() && gameArea.get(END_AREA).characters().size() == TOTAL_PEOPLE;
        this.operations = operations;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public List<Character> getCharacters(GameAreaView area) {
        return gameArea.get(area).characters();
    }

    public Set<Identity> getStartGameCharacterIdentity(GameState state, GameAreaView gameArea) {
        return state.getCharacters(gameArea).stream().map(Character::identity).collect(Collectors.toUnmodifiableSet());
    }

    public GameState move(Character firstCharacter, Character secondCharacter, GameAreaView fromArea, GameAreaView toArea) {
        GameArea from = gameArea.get(fromArea);
        GameArea to = gameArea.get(toArea);

        List<Character> mutatedFrom = getMutatedFrom(firstCharacter, secondCharacter, from);
        List<Character> mutatedTo = getMutatedTo(firstCharacter, secondCharacter, to);

        Map<GameAreaView, GameArea> newGameArea = new EnumMap<>(GameAreaView.class);
        newGameArea.put(fromArea, new GameArea(mutatedFrom));
        newGameArea.put(toArea, new GameArea(mutatedTo));
        Arrays.stream(values()).filter(area -> area != fromArea && area != toArea).forEach(area -> newGameArea.put(area, gameArea.get(area)));

        return new GameState(newGameArea, this.operations + 1);
    }

    private List<Character> getMutatedTo(Character firstCharacter, Character secondCharacter, GameArea to) {
        List<Character> mutableTo = new ArrayList<>(to.characters());
        if (firstCharacter != null) mutableTo.add(firstCharacter);
        if (secondCharacter != null) mutableTo.add(secondCharacter);
        return mutableTo;
    }

    private List<Character> getMutatedFrom(Character firstCharacter, Character secondCharacter, GameArea from) {
        List<Character> mutableFrom = new ArrayList<>(from.characters());

        if (firstCharacter != null && !mutableFrom.remove(firstCharacter) || secondCharacter != null && !mutableFrom.remove(secondCharacter)) {
            throw new IllegalArgumentException();
        }

        return mutableFrom;
    }

    public void print() {
        System.out.println();
        System.out.println("START_AREA: " + gameArea.get(START_AREA).characters());
        System.out.println("BOAT_AREA: " + gameArea.get(BOAT_AREA).characters());
        System.out.println("END_AREA: " + gameArea.get(END_AREA).characters());
        System.out.println("operations: " + operations);
        System.out.println();
    }
}
