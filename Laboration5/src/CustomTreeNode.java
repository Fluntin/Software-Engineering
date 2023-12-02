import javax.swing.tree.*;

//----------------------------------------------------------------------
// The Purpose of is to Exted DefaultMutableTreeNode used in Swing to create tree nodes
// Adds add functionality to store the node level and node text to the standard node
// This is allowing us more detailed information storage in the tree
//----------------------------------------------------------------------
class CustomTreeNode extends DefaultMutableTreeNode {

  String nodeLevel;
  String nodeText;

  public CustomTreeNode(String name, String nodeLevel, String nodeText) {
    super(name);
    this.nodeLevel = nodeLevel;
    this.nodeText = nodeText;
  }

  public String getNodeText() {
    return nodeText;
  }

  public String getNodeLevel() {
    return nodeLevel;
  }
}

