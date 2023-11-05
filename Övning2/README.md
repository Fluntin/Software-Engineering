# Simple Button Component and Display Application

This Java application consists of two main components: a custom button component and a graphical user interface (GUI) display that updates based on button clicks. The project is divided into three Java classes:

1. **Component2.java**: Represents a custom component containing buttons.
2. **ButtonDisplay.java**: Creates a GUI interface with the custom button component and a text field to display button clicks.
3. **Button.java**: Represents a custom JButton class (used by the custom button component).

## Features

- The `Component2` class provides a panel with buttons for digits (1-9), mathematical operators (*), a digit zero (0), and special characters (#). It allows users to input and clear digits.
- The `ButtonDisplay` class creates a JFrame that displays the custom button component and a text field below it.
- The text field in the display updates dynamically as buttons in the custom component are clicked.
- The `Button.java` class represents a custom JButton used by the custom button component.

## Usage

1. Compile and run the `ButtonDisplay` class to launch the application.
2. Click on the buttons in the custom component to input digits and observe the dynamic display of the clicked buttons' text.
3. Click the '*' button to clear the displayed text.
4. Click the '#' button to delete the last entered character.

## Example

```bash
# Compile the ButtonDisplay class
javac ButtonDisplay.java

# Run the application
java ButtonDisplay
