# Mock Game Application

This Java code represents a mock game application with a graphical user interface (GUI). The code is organized into several classes:

1. **Boardgame Interface (`Boardgame.java`)**: Defines the contract for a board game with move functionality and status tracking.

2. **NewMockGame Class (`NewMockGame.java`)**: Implements the `Boardgame` interface and provides a mock game logic. This class represents the core of the game.

3. **Square Class (`Square.java`)**: Represents individual squares (buttons) on the game board with graphical properties.

4. **ViewControl Class (`ViewControl.java`)**: Handles the graphical user interface (GUI) for the game using Swing, including creating the game board and updating the game's status and messages.

## Mock Game Application

### Description

The Mock Game Application serves as an example of a simple board game interface with a mock game logic. The primary purpose of this code is to demonstrate the structure of a board game application with GUI elements.

### Usage

1. Compile and run the `ViewControl` class to start the mock game GUI.
2. The game board consists of a grid of squares with labels (represented as buttons).
3. Click on the squares to interact with the mock game (no actual game logic is implemented).
4. The game displays messages to provide feedback and instructions.

## Class Overview

- `Boardgame` Interface: Defines methods for moving, getting status, and getting messages.
- `NewMockGame` Class: Implements a mock game logic with default messages and an empty game board.
- `Square` Class: Represents graphical squares/buttons on the game board.
- `ViewControl` Class: Manages the GUI and user interactions for the mock game.

---