Sure, here's the entire text formatted as a `README.md` for better readability:

---

# Lab 5 - Tree of Life

## Objectives
- Interpret given source code and apply it in a new application.
- Construct a tree structure from a text file containing XML code.
- Use any XML parser is allowed, but the instructions are tailored for you to program the file decoding yourself.
- Utilize the advanced graphical library component JTree to visualize a tree.
- Understand JTree's utility classes and manage extended information in tree nodes.

## Introduction
In the book "Object-oriented programming in Java" by Martin Kalin, which was used as a course textbook for DD2385 (the earlier version of DD1385), there is a program that visually presents file directory trees using an advanced Swing component, JTree.

The task in this lab is to visually present a different tree structure. JTree will be used, as well as the framing approach used in Kalin's program.

Kalin's code has been modified and split into two classes. First, we have `TreeFrame`, which defines the tree and its framing. A `TreeFrame` is a `JFrame` that contains a button, a small check box, and the clickable tree. While `TreeFrame` is a runnable program, the tree it creates has only one root node and no branches.

The second class, `DirTree2`, inherits from `TreeFrame` and redefines the methods in `TreeFrame` that create the actual tree structure, ensuring it displays a file directory tree. Some new helper methods and variables are also defined in `DirTree2`.

Please save both of these classes. You can test them if you wish. Ensure that you have a general understanding of their construction, at least in broad strokes.

- `java TreeFrame`: Displays a tree with only a single node, the root.
- `java DirTree2`: Shows the tree for the file directory you are currently in.
- `java DirTree2 ~`: Displays the tree for your home directory under Linux/Unix (this may take some time if it's large).
- `java DirTree2 ../../recept`: Shows the "recept" directory assumed to be two levels up in the directory tree.

You can click on directory nodes to show/hide their contents. If "Show details" is checked, a single click will provide detailed information about the selected file or directory.

# Lab Assignment: New Subclass for TreeFrame

The program for this lab assignment should have a structure similar to DirTree2, i.e., it should inherit from TreeFrame and redefine the methods needed to describe a new tree. Methods related to file directory trees should not be included in the lab assignment. Therefore, copy DirTree2, give it a suitable name for the lab, and remove anything related to file directories.

## Preparatory Task: A Minimal Tree of Life
Feel free to read about JTree in the API documentation, for example, [here](JTree API). However, you should be able to complete the task by studying the examples provided in the lab text and the given program files. JTree has many constructors, but we will use the one that requires a tree model as a parameter. The tree model is a DefaultTreeModel, which is a tree built up of nodes of the DefaultMutableTreeNode class.

This preparatory task does not need to be submitted but is useful to get started. Create a tree with a root and three children, all of which are leaves. The root of the tree should be labeled "Life," and the three children should be "Plants," "Animals," and "Fungi." Later, they should be able to contain orders, suborders, families, genera, and species. Create a new subclass of TreeFrame and define `initTree()` to do the following:

1. Create a root node with the label "Life."
2. Create a tree model.
3. Create a child node in the same way as the root node, but with the text "Plants."
4. Add it to the tree model with the root as its parent, i.e., `root.add(child);`
5. Repeat the same steps for "Animals" and "Fungi," i.e., add them as children of "Life."
6. Create the tree, the JTree object (this can be done right after the model is created).
7. Compile, run, and check that it looks good.

It is possible to create model objects and tree objects from a single root node and then expand with more nodes.

## A Recursive Tree of Life
Instead of creating nodes "by hand," read the tree of life from the file "Liv.xml" and build a tree. The program must be able to handle an arbitrary number of children at each level. A small test version of the file looks like the example below. The file is also available as "LillaLiv.txt."

```xml
<Biosphere name="Life">is everything that reproduces
  <Kingdom name="Plants">cannot move
  </Kingdom>
  <Kingdom name="Animals">can move
  </Kingdom>
  <Kingdom name="Fungi">are neither animals nor plants
  </Kingdom>
</Biosphere>
```

In addition to the node's name, the files also contain a level (e.g., "Biosphere," "Kingdom") and an explanatory text. In DefaultMutableTreeNode, only a single attribute (of type Object) about the node can be stored. In this task, you need to store the level, name, and text for each node. Solve this by creating a subclass of DefaultMutableTreeNode that has more attributes and methods.

Tree structures are recursive. You can create a tree with a recursive method or use a stack to build the tree without recursion, in a simple loop. Both approaches are excellent programming exercises.

As in DirTree2, you should be able to specify the file name in the execution command:

```shell
java LifeTree livfile
```

If no name is provided, the program should use a file with a hardcoded name, e.g., "Liv.xml."

## Details about Life
In the original program, you get information about the selected file if "Show details" is selected. In your program, instead, you should display the explanatory text, for example:

"Species: Seagull likes sailboats."

Make sure that `showDetails(TreePath p)` displays this text in its JOptionPane.

The green color is obtained by setting the background color of the tree object to green, not the background of the JFrame, as one might think.

## Reading from a Text File
This can be done most easily with the Scanner class:

```java
static Scanner sc = new Scanner(new File("inputfile.txt"));
```

`new File(...)` can generate a FileNotFoundException that needs to be handled with try...catch. If the file is found, you can then read line by line with `sc.nextLine()`. Make the Scanner variable static so that it can be created in the main method. You can use `sc.hasNextLine()` to check if there are more lines to read in the file. Only the file opening needs to be in a try...catch block. The file processing can be done outside of it.

## Requirements for the Program
The program must handle input files of arbitrary size. It should not assume that nodes have a fixed number of children or that the tree has a specific depth.

 The program should check that the opening and closing tags match; otherwise, it should print an error message and exit. Other types of errors in the input file do not need to be identified.

## File Format, etc.
The program can assume that the input file is formatted like the examples, with one "tag" per line, similar to the example files, and that there is exactly one space between the level and the word "name," with no other spaces except in the explanatory text at the end of the lines. Here is an example line:

```xml
<Biosphere name="Life">is everything that reproduces
```

It is allowed and good practice to handle input that is not well-formatted, such as having multiple spaces between words, spaces before and after the "=", "<," and ">" signs, or extra line breaks or missing line breaks. Identifying other syntax errors beyond mismatched closing tags is not required!

## Presentation
Run the program with the larger input file and demonstrate all functions. Show the UML diagram.

## Extra Assignment for a Higher Grade (Small)
Arrange it so that, in addition to the basic information like "Species: Seagull likes sailboats," you also get the full chain of names displayed as follows:

"But everything that is Seagull is Birds is Animals is Life."

Use the `getLastPathComponent()` method in TreePath and the `getParent()` method in DefaultMutableTreeNode (and therefore in your subclass) to achieve this.

---
