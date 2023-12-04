package Jail;
import javax.swing.*;
import javax.swing.tree.*;

import TreeFrame;

import java.io.*;        
class DirTree2 extends TreeFrame {
	//-----------------------------------------------------
	// Satic variable for the directory to be displayed
    static String directory=".";

	//-----------------------------------------------------
    // Overrides method in TreeFrame
    void initTree() {
	// Initialize the root node with the directory path
	root = new DefaultMutableTreeNode(directory);
	// Set up the tree model with the root node
	treeModel = new DefaultTreeModel( root );
	// Create the tree with using the tree model
	tree = new JTree( treeModel );
	// Build the tree from the directory
	buildTree();
    }

    //-----------------------------------------------------
	// Method to start building the tree from the current directory
    private void buildTree() {
	File f=new File(directory);
	String[] list = f.list(); 
	for (int i=0; i<list.length; i++ )
		// Recursively build the tree for each item in the directory
	    buildTree(new File(f,list[ i ]), root); 
    }

	//-----------------------------------------------------
    // Overloaded method to build the tree recursively
    private void buildTree( File f, DefaultMutableTreeNode parent) {  
	// Create a tree node for each file/directory
	DefaultMutableTreeNode child = 
	    new DefaultMutableTreeNode( f.toString() );
	parent.add(child);
	if ( f.isDirectory() ) {
		// If it's a directory, recurse into it and build its tree
	    String list[] = f.list();
	    for ( int i = 0; i < list.length; i++ )
		buildTree( new File(f,list[i]), child);            
	}        
    }  

	//-----------------------------------------------------
    // Overrides method in TreeFrame
    void showDetails(TreePath p){
	if ( p == null )
	    return;
	// Get the file from the selected node
	File f = new File( p.getLastPathComponent().toString() );
	// Display a message dialog with file details
	JOptionPane.showMessageDialog( this, f.getPath() + 
				       "\n   " + 
				       getAttributes( f ) );
    }

	//-----------------------------------------------------
    // Method to get attributes of a file or directory
    private String getAttributes( File f ) {
	String t = "";
	if ( f.isDirectory() )
	    t += "Directory";
	else
	    t += "Nondirectory file";
	t += "\n   ";
	if ( !f.canRead() )
	    t += "not ";
	t += "Readable\n   ";
	if ( !f.canWrite() )
	    t += "not ";
	t += "Writeable\n  ";
	if ( !f.isDirectory() )
	    t += "Size in bytes: " + f.length() + "\n   ";
	else {
	    t += "Contains files: \n     ";
	    String[ ] contents = f.list();
	    for ( int i = 0; i < contents.length; i++ )
		t += contents[ i ] + ", ";
	    t += "\n";
	} 
	return t;
    }
	
	//-----------------------------------------------------
	// Main method to run the application
    public static void main(String[] args) {
	if(args.length>0) directory=args[0];
	// Create an instance of DirTree2, initiating the GUI
	new DirTree2();
    }

}
