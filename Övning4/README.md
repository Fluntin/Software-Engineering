# Övning 4

This repository contains Java programs that demonstrate various concepts related to file reading, sorting, and user interaction. Below, you'll find details about each program and how to run them.

## Test.java - Understanding Static

This program is designed to test your understanding of static methods in Java. It includes a class with methods, and one of these methods cannot be compiled. Your task is to identify which method it is and why it cannot be compiled.

## LitenFilInlasning.java - Reading from a File

This program demonstrates reading from a file in Java. It prompts the user for a file name until a valid name (the name of an existing file) is provided. Then, it reads the contents of the file and prints them to the terminal window.

To run the program, execute the `LitenFilInlasning` class.

## Huvudprogram - File Dialog and Sorting

This program uses a file dialog to find a file, reads the file, and prints all the words from the file in Swedish alphabetical order. It can handle files where each word is on a separate line or where words are separated by specified delimiters. The sorting part of the program is loosely coupled with the file reading part.

To run the program, execute the `HP` class.

## Dialog Boxes and Regular Expressions

This program utilizes dialog boxes for user input and regular expressions to specify conditions for text parsing. Dialog boxes in Java are used for both text-based and graphical input. Regular expressions are used to define conditions for splitting text into smaller parts.

Here are some useful resources for dialog boxes and regular expressions in Java:
- [Java Dialog Boxes Tutorial](http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html)
- [Java Regular Expressions API](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)

## Class Descriptions

- `Filläsare.java`: A class responsible for reading a file, splitting it into words using regular expressions, and notifying the `Sorterare` class.
- `HP.java`: The main program that initiates file reading and sorting processes.
- `Sorterare.java`: A class that counts word occurrences and sorts them alphabetically.

Feel free to explore and modify the code to understand Java concepts better or apply them to your own projects.

Please note that the code provided is for educational purposes and may require modifications to suit specific environments or use cases.
