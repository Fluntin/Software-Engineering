import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;


class TreeFrame extends JFrame implements ActionListener {
	// GUI components for the tree view
    JCheckBox box;
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;
    JPanel controls;
    static final String closeString = " Close ";
    static final String showString = " Show Details ";

    TreeFrame() {
		// Get the content pane of the JFrame to add components
    	Container c = getContentPane();

    	// Initialize the tree structure
    	initTree();

		// Add a mouse listener to the tree
		tree.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
				// Show details of the node where the mouse is clicked if the checkbox is selected
    		    if (box.isSelected())
        			showDetails(tree.getPathForLocation(e.getX(),
        							    e.getY()));
    		      }
    	    });

		// Initialize the control panel
    	controls = new JPanel();
    	box = new JCheckBox(showString);
    	initGUI();
		// Add controls and tree to the content pane
    	c.add(controls, BorderLayout.NORTH);
    	c.add(tree, BorderLayout.CENTER);
		// Make the frame visible
    	setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
		// Handle action events (e.g., button clicks)
    	String cmd = e.getActionCommand();
    	if (cmd.equals(closeString))
    	    dispose(); // Close the frame if the close button is clicked
    }

    void initGUI() {
		// Set properties for the tree and control panel
    	tree.setFont(new Font("Dialog", Font.BOLD, 12));
    	controls.add(box);
    	addButton(closeString);
    	controls.setBackground(Color.lightGray);
    	controls.setLayout(new FlowLayout());
    	setSize(400, 400);
    }

    void addButton(String n) {
		// Create and add a button to the control panel
    	JButton b = new JButton(n);
    	b.setFont(new Font("Dialog", Font.BOLD, 12));
    	b.addActionListener(this);
    	controls.add(b);
    }

	//-----------------------------------------------------
    // Override initTree in subclass
    // Create root, treeModel and tree in the new initTree
	// Method to initialize the tree structure, meant to be overridden in subclasses
	//-----------------------------------------------------
    void initTree(){
    	root = new DefaultMutableTreeNode("TestString"); // Create the root node
    	treeModel = new DefaultTreeModel(root); // Create the tree model based on the root
    	tree = new JTree(treeModel); // Create the tree view based on the model
    }

    //-----------------------------------------------------
	// Method to show details of a selected node, meant to be overridden in subclasses
	// showDetails can also be overridden in a subclass to show more details
	//-----------------------------------------------------
    void showDetails(TreePath path){
    	if (path == null)
    	    return;
		// Get info from the selected node and show it in a dialog box
    	String info = path.getLastPathComponent().toString();
    	JOptionPane.showMessageDialog(this, info);
    }

    public static void main(String[] u) {
		// Create an instance of TreeFrame, initiating the GUI
    	new TreeFrame();
    }
}
