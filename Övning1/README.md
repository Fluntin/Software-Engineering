## Simple Calculator GUI in Java

This Java code represents a simple calculator application with a graphical user interface (GUI). It consists of several classes:

### Display Class
- The `Display` class extends `JLabel` and represents the display area of the calculator.
- It initializes the display with "0", sets its size, and applies a font.

### Knapp Class
- The `Knapp` class extends `JButton` and represents the calculator's buttons.

### Knappsats Class
- The `Knappsats` class extends `JPanel` and represents the panel containing the calculator's buttons.
- It sets up a grid layout and populates it with buttons for digits, operators, and special symbols.

### Raknare Class
- The `Raknare` class extends `JFrame` and is the main class representing the calculator application.
- It creates the main application window with a display at the top and the button panel in the center.
- The calculator supports basic addition (`+`) and numeric input.
- Button clicks are handled using the `actionPerformed` method, allowing users to input numbers and perform addition operations.
- The calculator's state is maintained, including the current display value, memory, and operator.

### Main Method
- The `main` method initializes the calculator's main frame using the `Raknare` class and runs it within the Swing event dispatch thread.

This code creates a functional GUI calculator that allows users to input numbers and perform addition operations. It demonstrates Java Swing components for building a graphical user interface.

---

You can use this code as a starting point to create a simple calculator application in Java.
