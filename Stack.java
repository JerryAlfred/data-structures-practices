import java.util.EmptyStackException;

// This is an int stack

// implement stack with arrays
class Stack {
    static final int MAX = 1000;
    // index of the "top" element in stack
    int top;
    int[] s = new int[MAX];
    // constructor
    Stack() {
        top = -1;
    }

    // isEmpty
    public boolean isEmpty() {
        return (top < 0);
    }

    // push
    public boolean push(Stack stack, int n) {
        // insert element to the last position in the array
        // increment top to point the position
        if (stack.top >= MAX - 1) {
            System.out.println("stack overflow!");
            return false;
        } else {
            stack.s[++stack.top] = n;
            return true;
        }
    }

    // pop
    public int pop(Stack stack) throws EmptyStackException {
        // return element at top then decrementing top
        if (stack.top >= 0) {
            return stack.s[stack.top--];
        } else {
            throw new EmptyStackException("empty stack, nothing to pop");
        }
    }

    // peek
    public int peek() throws EmptyStackException{
        // same as pop, just don't decrement top
        if (stack.top >= 0) {
            return stack.s[stack.top];
        } else {
            throw new EmptyStackException("empty stack, nothing to peek");
        }
    }
}


// implement stack using linked list
class LLStack {
    // a linked list stack contains a head node
    StackNode head;
    class StackNode {
        int val;
        StackNode next = null;
    }
    StackNode(int d) {
        this.val = d;
    }

    // isEmpty checks if head node is null
    public boolean isEmpty() {
        return (head == null);
    }

    // push add a new node as the new head
    public void push(int d) {
        if (head == null) {
            head = new StackNode(d);
        } else {
            StackNode newHead = new StackNode(d);
            newHead.next = head;
            head = newHead;
        }
    }

    // pop returns the head node and deletes it
    public int pop() throws EmptyStackException{
        if (head == null) {
            throw new EmptyStackException("empty stack");
        } else {
            int value = head.val;
            head = head.next;
            return value;
        }
    }
    public int peek() throws EmptyStackException {
        if (head == null) {
            throw new EmptyStackException("empty stack");
        } else {
            return head.val;
        }
    }
}