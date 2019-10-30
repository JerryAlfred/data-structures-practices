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
    public static boolean isEmpty() {
        return (top < 0);
    }

    // push
    public static boolean push(Stack stack, int n) {
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
    public static int pop(Stack stack) throws EmptyStackException {
        // return element at top then decrementing top
        if (stack.top >= 0) {
            return stack.s[stack.top--];
        } else {
            throw new EmptyStackException("empty stack, nothing to pop");
        }
    }

    // peek
    public static int peek() throws EmptyStackException{
        // same as pop, just don't decrement top
        if (stack.top >= 0) {
            return stack.s[stack.top];
        } else {
            throw new EmptyStackException("empty stack, nothing to peek");
        }
    }
}