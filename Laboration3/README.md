## Rock, Paper, Scissors Client Application

### Overview
This repository contains the implementation of a client-server application for the game of Rock, Paper, Scissors. The primary goal is to demonstrate the ability to create a multi-client server program in Java and develop both text-based and graphical clients that interact seamlessly with the server.

### Features

#### Server-Client Architecture
- The server program is capable of playing Rock, Paper, Scissors with multiple clients simultaneously. It is designed for a Java environment and showcases effective client-server communication.

#### Text Client
- A basic text client is implemented to establish a connection with the server. This client sends a predetermined name to the server and displays the server's response. The connection is established using standard Java socket programming techniques.

#### Graphical Client
- The repository includes a graphical client that allows users to play Rock, Paper, Scissors against the server. The client features an interactive interface with buttons for each move and displays the game's progress and results.

### Components

#### Gameboard Class
- The application features a gameboard that displays the player's name, the latest move made, and the current score. The gameboard updates in real-time to reflect the ongoing game status. It includes buttons for Rock, Paper, Scissors, and an area to show the game's outcome (win, lose, draw).

#### Main Class
- The main class orchestrates the game's logic and user interface. It connects to the server, processes user inputs, and updates the gameboard accordingly.

### Gameplay Mechanics
- The game is played by pressing the Rock, Paper, or Scissors buttons. The user's third consecutive button press triggers the game to register the move and compare it against the server's move to determine the outcome.

### Technical Details
- The server needs to be running for the clients to connect. It can run on the same machine as the client or on a different one, provided the server's IP address is accessible to the client.
- The text client serves as a foundational example of simple client-server interaction, while the graphical client provides a more engaging user experience.

---