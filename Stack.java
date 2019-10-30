import java.util.EmptyStackException;

// This is an int stack

// implement stack with arrays
class ArrStack {
    static final int MAX = 1000;
    // index of the "top" element in stack
    int top;
    int[] s = new int[MAX];
    // constructor
    ArrStack() {
        top = -1;
    }

    // isEmpty
    public boolean isEmpty() {
        return (top < 0);
    }

    // push
    public boolean push(int n) {
        // insert element to the last position in the array
        // increment top to point the position
        if (top >= MAX - 1) {
            System.out.println("stack overflow!");
            return false;
        } else {
            s[++top] = n;
            return true;
        }
    }

    // pop
    public int pop() throws EmptyStackException {
        // return element at top then decrementing top
        if (top >= 0) {
            return s[top--];
        } else {
            throw new EmptyStackException("empty stack, nothing to pop");
        }
    }

    // peek
    public int peek() throws EmptyStackException{
        // same as pop, just don't decrement top
        if (top >= 0) {
            return s[top];
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


// Stack exercises on Leetcode
class LeetCodeExercises {
    // 20. Valid Parentheses
    // this is O(n)
    public boolean validParentheses(String s) {
        // for string of both left & right parentheses:
        // push if left parenthesis, pop if right parenthesis
        // when pop, check if it's the correct correspondent parenthesis
        // start by go thru the string char by char
        // for string with only left parentheses:
        // check at the end whether stack is empty
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));                
            }
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                try {
                    char c = stk.pop().charValue();
                    if (s.charAt(i) == ')' && c != '(') {
                        return false;
                    }
                    if (s.charAt(i) == '}' && c != '{') {
                        return false;
                    }
                    if (s.charAt(i) == ']' && c != '[') {
                        return false;
                    }
                }
                catch (Exception e) {
                    return false;
                }
            }
            else {
                // for empty strings and strings of not all parentheses: return false
                return false;
            }
        }
        return stk.isEmpty();
    }
}