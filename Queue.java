// integer queue
// implement queue using array
class Queue {
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