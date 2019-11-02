// Construction of Binary Tree
class Node {
    int val;
    Node l, r;

    Node(int d) {
        val = d;
        l = r = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }
    BinaryTree(int d) {
        root = new Node(d);
    }

    // add for completeness; this is NOT a binary search tree
    public void add(int d) {
        // if empty tree, new node is root
        if (root == null) {
            root = new Node(d);
        }
        // if non-empty tree, insert for completeness
        else {
            // go down the left branch of tree until a leaf is reached
            
            // check if leaf has a right sibling, if not, add to right, else go back one node and see if the node's right sibling has children
            // if right sibling 
            
            // add to its left child

        }
    }

    // remove


    // Depth First Traversal to print out node values
    // Pre-Order: M, L, R
    public void preTraverse() {
        // ensure not an empty tree
        while (root != null) {
            
        }
    }


    // In-Order: L, M, R

    // Post-Order: L, R, M


    // Breath First Traversal

}