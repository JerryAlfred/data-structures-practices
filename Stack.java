import java.util.EmptyStackException;
import java.util.Queue;

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
        Stack<Character> stk = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                stk.push(s.charAt(i));       
            }
            else if (map.containsKey(s.charAt(i))) {
                try {
                    if (stk.pop() != map.get(s.charAt(i))) {
                        return false;
                    }
                }
                catch (Exception e) {
                    return false;
                }
            }
            else {
                // for empty string or string of not all parentheses, return false
                return false;
            }
        }
        return stk.isEmpty();
    }


    // 155. Min Stack
    // all operations in this class, including getMin, is O(1)
    class MinStack {

        /** initialize your data structure here. */
        // keeps the min value and a stack
        int min = Integer.MAX_VALUE;
        Stack<Integer> s = new Stack<>();
    
        public void push(int x) {
            // push min
            s.push(min);
            // push x
            s.push(x);
            // if x < min, update min
            // now for every value we have a copy of the min before this value is added
            if (x < min) {
                min = x;
            }
        }
        
        public void pop() {
            // pop the top value of stack
            // pop the second time to get the min value before the top was pushed
            s.pop();
            min = s.pop();
        }
        
        public int top() {
            return s.peek();
        }
        
        public int getMin() {
            return min;
        }
    }

    // 225. Implement stack using queues
    // General strategy: use two queues

    // 1. by making push costly (O(n))
    // Idea: to push x to q1, we want x to be at the beginning of the queue so that it can be easily popped by dequeuing.
    // enqueue x to q2, dequeue all other elements in q1 to q2, then swap the names of q1 and q2.
    class MyStack {
        // initialize two queues with infinite capacity
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        /** Push element x onto stack. */
        public void push(int x) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            // swap names so that we can always dequeue from q1
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        /** Removes the element on top of the stack and returns that element. */
        public int pop() throws EmptyQueueException{
            if (q1.peek() == null) {
                throw new EmptyQueueException();
            }
            return q1.poll();
        }
        
        /** Get the top element. */
        public int top() {
            return q1.peek();
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    // 2. by making pop costly (O(n))
    // Idea: enqueue new elements to q1; when pop, dequeue every element except for the last in q1 to q2;
    // dequeue and return the last element in q1, then swap names for q1 and q2

    class MyStack {
        // initialize two queues with infinite capacity
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        // see comment above top() to know why I need to have this variable
        int top;
        
        /** Push element x onto stack. */
        public void push(int x) {
                q1.offer(x);
                top = x;
        }

        
        /** Removes the element on top of the stack and returns that element. */
        public int pop() throws EmptyQueueException{
            int last = Integer.MIN_VALUE;
            // here I use isEmpty() & some trick inside to keep things going, but can also use size() - 1
            while (!q1.isEmpty()) {
                // assign the top to the element before the last one
                top = last;
                last = q1.poll();
                // enqueue only the elements before the last one
                if (!q1.isEmpty()) {
                    q2.offer(last);
                }
            }
            if (last == Integer.MIN_VALUE) {
                throw new EmptyQueueException();
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return last;
        }
        
        /** Get the top element. */
        // since in this implementation we are only changing pop(), the elements in queue are not in stack order
        // so we needed to keep track of the top to easily return it for top()
        // but the other solution of changing push() doesn't need the int top because elements in queue are in stack order for that
        public int top() {
            return top;
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}