## Lab 1 - A Simple Button Component

This title indicates that this is the first lab, focused on creating a basic button component.

### Objective
- Gain a basic understanding of Java's graphical components, standalone graphical programs, events, and listeners.

### Content

- Create and run simple standalone graphical programs.
- Use graphic libraries.
- Develop a custom graphic component by extending a component from a graphics library.
- Implement button pressing, ensuring "something happens" when a button is pressed.

**Note**: Students must present the programs from Task 4 onwards. Ensure you can answer questions about all the sub-tasks.

### Task 1 - Create a Standalone Java Program

- Write a program that opens a standalone window with a frame on the computer screen. Create a class named `MyFrame`.
- Requirements:
  - `MyFrame` should inherit from the library class `JFrame`.
  - Ensure code is placed appropriately in the constructor.
  - The program should close when the window's close button is clicked.
  - The authors' names should appear in the frame title, and the window should have your favorite color as the background.

### Task 2 - Create an Extended Button Component with Two States

- Create a `MyButton` class that inherits from `JButton`. The button should have two states, represented by the button's background color and text.
- Define a `toggleState()` method in `MyButton`. This method should switch the button's state, changing both its color and text.

### Task 3 - Button in the Window

- Extend the program from Task 1 to include multiple buttons (at least two) from Task 2 in the window. Run the program.
  - Are the buttons visible?
  - What happens when you click the buttons?

### Task 4 - Button Pressing

To make a button press effective, there should be a listener object that listens to the button's actions. The listener object should belong to a class that implements the `ActionListener` interface.

- **Part A**: Translate the given UML diagram into Java code by making `MyFrame` implement `ActionListener`. Ensure the `actionPerformed()` method calls `toggleState()`. Remember to connect the listener object to the buttons. Test it out.
- **Part B**: Translate another UML diagram into Java code by first removing all listener properties from the code. Let `MyButton` implement `ActionListener` and call `toggleState()` from its `actionPerformed` method. Ensure each button's state changes independently.
- **Part C**: Translate yet another UML diagram into Java code. Create a class named `Ear` that implements `ActionListener`. Ensure `toggleState` is called from `actionPerformed`.

### Presentation for Basic Task
- Demonstrate the button component.
- Display at least two instances of the component in a standalone window. Group members' names should be visible in the window.
- Explain the UML diagram translation into code.
- Discuss the placement of specific methods and calls in the code.
- Show how button presses change the button states.

### Additional Task for Higher Grades

**Objective**:
- Gain a deeper understanding of events and listeners and how a button press can influence the "environment".
- Learn to provide input to a standalone program via the command line.

**Task**:
- Create a program resembling the basic task but allow a variable number of buttons defined via command-line input. For example, `java lab1X 6` should generate six buttons. All buttons should display in the window, but pressing one should change the appearance of all other buttons.

### Presentation for Additional Task
- Present and explain the program according to the specifications above.

The format provided is very systematic and well-structured, ensuring students are clear on objectives, tasks, and expectations.