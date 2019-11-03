// Binary Search Tree characteristics:
// all left children < root < all right children

// Binary Search Tree Implementation
class Node {
    int val;
    Node l;
    Node r;

    Node(int d) {
        val = d;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = l = r = null;
    }
    BinarySearchTree(int d) {
        root = new Node(d);
        l = r = null;
    }

    // Insert

    // Remove

    // Search
    // compare key with root then travel down
    public Node search(Node root, int n) {
        if (root == null || root.val == n) {
            return root;
        }
        if (n > root.val) search(root.l, n);
        if (n < root.val) search(root.r, n);
    }

}