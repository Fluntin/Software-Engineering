# Fifteen Puzzle Game

This Java code represents a simple implementation of the Fifteen Puzzle game. The code is organized into several classes:

1. **Boardgame Interface (`Boardgame.java`)**: Defines the contract for a board game with move functionality and status tracking.

2. **FifteenModel Class (`FifteenModel.java`)**: Implements the `Boardgame` interface and provides the core logic for the Fifteen Puzzle game.

3. **Square Class (`Square.java`)**: Represents individual squares (buttons) on the game board with graphical properties.

4. **ViewControl Class (`ViewControl.java`)**: Handles the graphical user interface (GUI) for the game using Swing, including creating the game board and updating the game's status and messages.

## Fifteen Puzzle Game

### Description

The Fifteen Puzzle game is a classic sliding puzzle game where the objective is to arrange the numbers in ascending order by sliding the tiles into the empty square.

### Usage

1. Compile and run the `ViewControl` class to start the game GUI.
2. The game board consists of a grid of squares with numbers (represented as buttons).
3. Click on a numbered square adjacent to the empty square to move it.
4. Continue moving tiles to arrange them in ascending order.
5. The game displays messages to provide feedback and instructions.

## Class Overview

- `Boardgame` Interface: Defines methods for moving, getting status, and getting messages.
- `FifteenModel` Class: Implements the game logic and board management.
- `Square` Class: Represents graphical squares/buttons on the game board.
- `ViewControl` Class: Manages the GUI and user interactions.
---