package WeekEleven;

/**
 * Simple Binary Search Tree class
 */
public class BinaryTree {

  /**
   * The only field needed in this object is the root node of the tree.
   */
  public Node root;

  /**
  Keeps track of the amount of nodes in a tree*/
  private int amountOfNodes;
  
  /**
   * Initiate the insertion of a string in the tree. The method ensures that
   * the string is not null or empty, then launches a recursive method to
   * perform the actual insertion
   */
  public void insert(String string) {
    if (string == null || string.length() == 0) {
      return; // guard statement
    }
    // Launch recursive insertion beginning from the root of the tree
    this.root = insert(this.root, string);
    
  } // helper method insert

  /**
   * In-order traversal
   */
  public void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.word);
      inOrder(node.right);
    }
  } // method inOrder

  /*accessor for amountofNodes*/
public int getAmountOfNodes() {
  return this.amountOfNodes;
//according to my testcode, I should have 13 nodes in the tree.
}//method getAmountOfNodes
  
/*
accessor for the inOrder method*/
  public String Order() {
    inOrder(this.root);
    return root.word;
  
  } // method Order
  /**
   * Recursive method to insert a string (packaged in a Node object) to the
   * tree. The method slides down to the next child (left or right) until it
   * finds an empty (null) node to place the data. Method returns the node
   * it uses as an insertion point. Recursively this leads to the first method
   * call, that eventually returns the root node of the tree. 
   */
  private Node insert(Node node, String string) {
    if (node == null) {
      // Base case; node we are looking at is available; take it.
      node = new Node(string);
     
    } else {
      // Oops! node is not available; go left or right?
      if (string.compareTo(node.word) < 0) {
        // go left
        node.left = insert(node.left, string);
      } else if (string.compareTo(node.word) > 0) {
        // go right
        node.right = insert(node.right, string);
      }
    }
    return node;
  } // method insert

  /**
   * Iterative insertion. The method traverses the tree seeking a node (called
   * parent) that has a null child in the desired direction (left or right).
   * One we find the parent, we add the data as a node that becomes the
   * parent's left or right child.
   */
  public void insertIterative(String string) {
    // Validate the input data
    if (string == null || string.length() == 0) {
      return; // guard statement
    }
    // Input is validated; let's wrap it into a node object that will be
    // inserted to the tree.
    Node newNode = new Node(string);
    if (this.root == null) { 
      // Tree is empty; what a lucky day
      this.root = newNode;
      
        } 
    else { 
      // Tree not empty; must traverse. Initialize two node points: A cursor
      // that traverses the tree and a parent which is the node we seek to 
      // find. The parent is the node who's left or right child is null and 
      // where we'll be placing the string we are inserting to the tree.

      /*
      STUDENT ADDITION: This is the best I could come up with. Utilizing thestring.compareTo(cursor.word), you can make the loop compare the two strings.  
      If they are equivilant in size, then the while loop won't run. This avoids the need for a break and functions the same way as the original code*/
      Node cursor = this.root;
      Node parent = null;
      //addition
      while (cursor != null && cursor.word.compareTo(cursor.word) != 0) {
        parent = cursor; 
        if (string.compareTo(cursor.word) < 0) {
          cursor = cursor.left;
        } else if (string.compareTo(cursor.word) > 0) {
          cursor = cursor.right;
        }

      } 
      // Loop ends when cursor==null; parent tells us which node is 
      // above that null node. If the string we are trying to insert
      // is already in the tree, no action will be taken.
      if (string.compareTo(parent.word) < 0) {
        parent.left = newNode;
        
      } else if (string.compareTo(parent.word) > 0) {
        parent.right = newNode;
      }
      //updates amount of nodes
      this.amountOfNodes++;
    }
  } // method insertIterative
} // class BinaryTree