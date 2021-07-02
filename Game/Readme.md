## Prerequisite
- jdk 16
- gradle 7.0

## How to use
- compile the project and run Main.class

## Characters
- Dad
- Mom
- Son
- Daughter
- Criminal
- Police

## Rules
- Boat must be operated by an adult
- Criminal cannot be alone with Dad, Mom, Son or Daughter if there is no Police
- Dad cannot be alone with Daughter if there is no Mom
- Mom cannot be alone with Son if there is no Dad

## Available Commands
- help: show all available commands
- move: to move one or two character from one area to another (you can't move from start to end directly)
- undo: undo the previous action
- redo: redo the action that has been undo
- restart: clear undo, redo actions and restart the game

## How to add new functionality 
- Character: implements the Character interface and add it to CHARACTERS and DEFAULT_CHARACTERS Map in Characters class
- Command: implements the Command interface and add it to COMMANDS Map of Commands class with command alias 
- Reversible Command: extends the ReversibleCommand class and add it to REVERSIBLE_COMMANDS Map of Commands class with command alias
- Rule: implements the GameRule interface and add it to RULES set of GameRules class
## Note 
In this project, comment is seldomly used since if I think the code is clear enough and comment can be too verbose for most of the cases.

In normal case, tests should be split by cases, but for simplicity, I put them together in rule tests.
