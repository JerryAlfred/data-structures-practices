import java.util.EmptyStackException;

// Useful post about time complexity of different implementations of queue & stack:
// https://stackoverflow.com/questions/7477181/array-based-vs-list-based-stacks-and-queues

// integer queue
// implement queue using array
class ArrQueue {
    private static final int MAX = 1000;
    // indices of head & tail element in queue
    int head = -1, tail = -1;
    int size = 0;
    int[] arr = new int[MAX];

    // isEmpty
    // when head < 0, queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // enqueue
    public void enqueue(int n) {
        if (size == MAX) {
            System.out.println("queue is full");
        } 
        else if (size == 0) {
            // queue is empty, add element to arr[0]; update head & tail
            arr[++head] = n;
            tail++;
        }
        else {
            // queue is not empty, add element to arr[tail + 1]; update tail only
            arr[tail + 1] = n;
            size++;
            tail++;
        }
    }

    // dequeue
    public int dequeue() throws EmptyQueueException {
        // queue is empty, throw exception
        if (size == 0) throw new EmptyQueueException();
        // queue is not empty
        // retrieve arr[head], head++; if head meets tail, retrieve arr[head] then set head, tail = -1
        if (head == tail) {
            int lastElement = arr[head];
            head = tail = -1;
            return lastElement;
        } else {
            return arr[head++];
        }
        size--;
    }
    
    // peekFront
    public int peekFront() throws EmptyQueueException {
        if (head < 0) throw new EmptyQueueException();
        return arr[head];
    }

    // peekRear
    public int peekRear() throws EmptyQueueException {
        if (tail < 0) throw new EmptyQueueException();
        return arr[tail];
    }
}


// implement queue using linked list
class LLQueue {
    // queue wrapper class contains a head and rear node
    QNode head, tail;

    class QNode {
        int val;
        QNode next;
    }

    QNode(int d) {
        val = d;
        next = null;
    }

    LLQueue() {
        head = tail = null;
    }

    // isEmpty
    public boolean isEmpty() {
        return (head == null);
    }

    // enqueue
    public void enqueue(int n) {
        QNode newNode = new QNode(n);
        // empty queue
        if (head == null) {
            head = tail = newNode;
        }
        // queue with 1 and more elements
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // dequeue
    public int dequeue() throws EmptyQueueException {
        // empty queue
        if (head == null) {
            throw new EmptyQueueException();
        }
        // queue with 1 element
        if (head == tail) {
            int target = head.val;
            head = tail = null;
            return target;
        }
        // queue with more than 1 elements
        else {
            int target = head.val;
            head = head.next;
            return target;
        }
    }

    // peekFront
    public int peekFront() throws EmptyQueueException {
        if (head == null) {
            throw new EmptyQueueException();
        }
        return head.val;
    }

    // peekRear
    public int peekRear() throws EmptyQueueException {
        if (tail == null) {
            throw new EmptyQueueException();
        }
        return tail.val;
    }
}


// Leetcode Exercises

// 232. Implement queues using stacks
// 1) by making push costly
// when push, 
class MyQueue {

    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
    }
    
    /** Get the front element. */
    public int peek() {
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */