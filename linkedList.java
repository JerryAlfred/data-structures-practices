// Construction
// Say it's an singly int linked list
public class LinkedList {
    Node head;

    class Node {
        Node next;
        int data;
    
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    // Insert
    public static void Insertion(Linkedlist lst, int d) {
        // construct a new node off the input
        Node new = new Node(d);
        Node n = lst.head;
        // if list is empty, make new node head
        if (lst.head == null) {
            lst.head = new;
        }
        // traverse to the end of list, insert new to end node
        while (n.next != null) {
            n = n.next;
        }
        n.next = new;
    }
    
    // Deletion by key
    public static void Deletion(LinkedList lst, int key) {
        // empty list
        if (lst.head == null) {
            System.out.println("this is an empty list");
        }
        // found at head
        else if (lst.head.data == key && lst.head.next != null) {
            lst.head = lst.head.next;
        }
        else {
            // found in middle/last
            // traverse thru list, compare each node's value with the key
            Node n = lst.head;
            while (n.next != null && n.next.data != key) {
                n = n.next;
            }
            if (n.next.data == key) {
                n.next = n.next.next;
            }
            // not found
            // now n stops at second to last node in the list, and the next node doesn't contain the key
            else {
                System.out.println("node value not found");
            }
        }
    }

    // Deletion by index
    public static void DeletionByIndex(LinkedList lst, int index) {
        if (index >= 0) {
            // index is 0, delete head
            if (index = 0) {
                if (lst.head == null) {
                    lst.head = null;
                } else {
                    lst.head = lst.head.next;
                }
            }
            // index is a positive number
            int i = 1;
            Node n = lst.head;
            // i is always 1 index later than n's position
            // so that n can be the node before the target node
            while (i != index) {
                // handles index out of bound
                if (n.next == null) {
                    break;
                }
                n = n.next;
                i++;
            }
            // only perform action when index is within bound
            if (i == index) {
                // now n is the node before the target node
                n.next = n.next.next;
            }
        }
        // index is negative, do nothing
        else {
            System.out.println("negative index, try again");
        }
    }
    
    // Traversal
    public static int TraverseCount(LinkedList lst) {
        // traverses and counts nodes in lst
        Node n = lst.head;
        if (n == null) {
            return 0;
        }

        int counter = 1;
        while (n.next != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }
    
    // Searching
    public static boolean Search(LinkedList lst, int d) {
        // traverse the list and compare each node's data with input
        Node n = lst.head;
        while (n != null) {
            if (n.data == d) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
    
    // Sorting


    // merging two singly linked lists
    // This is O(lst1.length + lst2.length) = O(n)
    public static LinkedList MergeSorted(LinkedList lst1, LinkedList lst2) {
        // both or either list is empty
        if (lst1.head == null) {
            return lst2;
        }
        if (lst2.head == null) {
            return lst1;
        }
        // iterate through both linked lists
        // iterate thru both lists at the same time
        // compare the elements at those two positions of the two lists, if one is smaller, move onto next position of that list
        // when next node is null, insert all remaining nodes from the other list
        LinkedList newLst = new LinkedList();
        Node curr1 = lst1.head;
        Node curr2 = lst2.head;
        // sets head for the new list
        if (curr1.val <= curr2.val) {
            newLst.head = curr1;
            curr1 = curr1.next;
        } else {
            newLst.head = curr2;
            curr2 = curr2.next;
        }
        Node currLst = newLst.head;
        // start adding elements to new list
        while (curr1 != null && curr2 != null) {
            // add the smaller element to new list
            // move to the next node on the list with the smaller element
            if (curr1.val <= curr2.val) {
                currLst.next = curr1;
                curr1 = curr1.next;
                currLst = currLst.next;
            } else {
                currLst.next = curr2;
                curr2 = curr2.next;
                currLst = currLst.next;
            }
        }
        // when one list is over, simply point to remaining nodes of the other list
        Node rem = (curr1 == null) ? curr2 : curr1;
        currLst.next = rem;
        return newLst;
    }

    // Other Leetcode exercises: 
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // remove duplicates in a sorted linked list
    // this is O(n)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // keep comparing with next until next is not the same
            // when next is not the same, move the current node to next
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                // if curr == curr.next, delete the next node but don't move on; else move on
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
        }
    }

    // linked list cycle
    // hint: use Hashset
    // this is O(n)

    public class Solution {
        public boolean hasCycle(ListNode head) {
            // traverse thru the linked list
            Set<ListNode> S = new HashSet<>();
            ListNode curr = head;
            // hash each node's value, check if hashtable contains key
            while (curr != null) {
                if (S.contains(curr)) {
                    return true;
                } else {
                    S.add(curr);
                }
                curr = curr.next;
            }
            // if not then put in <K, V> & continue, else return true
            // return false if hasn't found cycle at the end
            return false;
        }
    }

}