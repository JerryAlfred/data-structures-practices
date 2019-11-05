// Binary Search Tree characteristics:
// all left children < root < all right children

// Binary Search Tree Implementation
class Node {
    int val;
    Node l;
    Node r;

    Node(int d) {
        val = d;
        l = r = null;
    }
}

class BinarySearchTree {
    Node root;
    int size;

    BinarySearchTree() {
        root = null;
        size = 0;
    }
    BinarySearchTree(int d) {
        root = new Node(d);
        size = 1;
    }

    // Insert
    // compare down until it reaches the end, then insert at the end
    public boolean insert(Node root, int n) {
        // empty tree
        if (root == null) root = new Node(n);
        // duplicate
        if (root.val == n) return false;
        // when reach a a leaf node or node with one child, insert
        if (root.l == null) {
            if (n < root.val) {
                root.l = new Node(n);
                return true;
            }
        }
        if (root.r == null) {
            if (n > root.val) {
                root.r = new Node(n);
                return true;
            }
        }
        // go to left or right tree
        if (n < root.val) return insert(root.l, n);
        else return insert(root.r, n);
    }

    // Remove
    public boolean remove(Node root, int n) {
        // empty tree or node n not found
        if (root == null) {
            return false;
        }
        // found node n's parent
        if (root.val == n) {
            // Node n is a leaf
            if (root.l == null && root.r == null) {
                root = null;
            }
            // Node n has 1 child
            else if (root.l == null || root.r == null) {
                if (root.l == null) root = root.r;
                else root = root.l;
            }
            // Node n has 2 children
            // inorder predecessor is the rightmost node of the left subtree
            // inorder successor is the leftmost node of the right subtree
            // let's do inorder predecessor here
            else {
                Node pred = root.l;
                while (pred.r != null) pred = pred.r;
                root.val = pred.val;
                pred = null;
            }
        }
        if (n < root.val) return remove(root.l, n);
        else return remove(root.r, n);
    }

    // Search
    // compare key with root then travel down
    public boolean search(Node root, int n) {
        if (root.val == n) {
            return true;
        }
        if (n > root.val) search(root.r, n);
        if (n < root.val) search(root.l, n);
        return false;
    }

}