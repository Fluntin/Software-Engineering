import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;

class LifeTree extends TreeFrame {

  // CustomTreeNode for the root of the tree
  CustomTreeNode root;
  // Scanner for reading from the input file
  static Scanner scanner;
  // Default input file name
  static String inputFileName = "Life.txt";

  // Overrides the initTree method from the superclass TreeFrame
  @Override
  void initTree() {
    // Skip the first line, usually an XML tag
    scanner.nextLine(); 
    String nextLine = scanner.nextLine();
    // Create the root node from the next line of the file
    root = createNode(nextLine); 
    // Set up the tree model with this root node
    treeModel = new DefaultTreeModel(root);
    // Create the tree view based on this model
    tree = new JTree(treeModel);
    // Build the rest of the tree from the file
    buildTree(scanner.nextLine(), root); 
  }

  // Method to create a CustomTreeNode from a line of text
  CustomTreeNode createNode(String line) {
    // Extract node level, name, and text from the line
    String openingLevel = line.substring(line.indexOf("<") + 1, line.indexOf(" namn"));
    String name = line.substring(line.indexOf("=\"") + 2, line.indexOf(">") - 1);
    String text = line.substring(line.indexOf("> ") + 2, line.length());

    // Return a new CustomTreeNode with extracted data
    return new CustomTreeNode(name, openingLevel, text);
  }

  // Method to recursively build the tree from the file lines
  void buildTree(String line, CustomTreeNode parent) {
    // Check for end tag to stop recursion
    if (line.substring(0, 2).equals("</")) {
      if (line.substring(line.indexOf("/") + 1, line.indexOf(">")).equals(parent.getNodeLevel())) {
        if (scanner.hasNextLine()) {
          // Move up to the parent node and continue building
          CustomTreeNode p = (CustomTreeNode) parent.getParent();
          buildTree(scanner.nextLine(), p);
        }
        return;
      } else {
        // Error handling for mismatched tags
        System.err.println("Invalid file format: mismatched start and end tags");
        System.exit(1);
      }
    } else {
      // Create a child node and add it to the parent
      CustomTreeNode child = createNode(line);
      parent.add(child);
      // Continue building the tree if there are more lines
      if (scanner.hasNextLine()) {
        buildTree(scanner.nextLine(), child);
      }
    }
  }

  // Method to show details of the selected node
  void showDetails(TreePath path) {
    if (path == null) return;

    // Retrieve the selected node
    CustomTreeNode node = (CustomTreeNode) path.getLastPathComponent();
    // Build the information string for the node
    String info = "Level: " + node.getNodeLevel() + "\nName: " + node.toString() + "\nText: " + node.getNodeText();
    // Build the hierarchy information
    String extraInfo = "Hierarchy: " + node.toString();
    while (node.getParent() != null) {
      node = (CustomTreeNode) node.getParent();
      extraInfo = extraInfo + " <- " + node.toString();
    }
    info += "\n" + extraInfo;
    // Show the information in a dialog box
    JOptionPane.showMessageDialog(this, info);
  }

  // Main method to run the application
  public static void main(String[] args) {
    // Set the input file name from arguments if provided
    if (args.length > 0) {
      inputFileName = args[0];
    }

    // Initialize the scanner for reading the file
    try {
      scanner = new Scanner(new File(inputFileName));
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + inputFileName);
      System.exit(1);
    }

    // Create an instance of LifeTree, initiating the GUI
    new LifeTree();
  }
}

