import java.util.NoSuchElementException;
import java.util.Iterator;
/**
* MinionList class.
* @author Heather
* @version 1
*/
public class MinionList implements Iterable<Minion>, MinionQueue, MinionStack {
    private Node head;

    /**
     * Node class.
     */
    private class Node {
        private Minion data;
        private Node next;

        public Node(Minion data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Checks if list is empty.
     * @return true if this list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

/**
     * Creates an iterator
     *
     * @return a MinionIterator
     */
    public Iterator<Minion> iterator() {
        return new MinionIterator();
    }

    /**
     * @author cmuse7
     */
    private class MinionIterator implements Iterator<Minion> {
        private int current = 0;  // the current element we are looking at

        /**
         * Check to see if there is a next element
         *
         * @return whether or not there are more elements in the array that
         * have not been iterated over.
         */
        public boolean hasNext() {
            return (current < MinionList.this.size());
        }

        /**
         * return the next element of the iteration and move the current
         * index to the element after that.
         *
         * @return next element of the iteration
         */
        public Minion next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return MinionList.this.get(current++);
        }
    }

    /**
     * Add a Minion to the back of the queue.
     *
     * @param m the Minion to add.
     * @throws IllegalArgumentException if Minion is null
     */
    public void enqueue(Minion m) {
        if (m == null) {
            throw new IllegalArgumentException("Cannot enqueue a null"
                + " element!");
        } else {
            Node current = head;
            if (current == null) {
                head = new Node(m, null);
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(m, null);
            }
        }
    }

    /**
     * Remove a Minion from the queue.
     *
     * @return the Minion from the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public Minion dequeue() {
        if (head == null) {
            throw new NoSuchElementException("No elements to dequeue");
        }
        Node temp = new Node(head.data, head.next);
        head = head.next;
        return temp.data;
    }

    /**
     * Push a Minion on to the stack.
     *
     * @param m the Minion to push.
     * @throws IllegalArgumentException if data is null.
     */
    public void push(Minion m) {
        if (m == null) {
            throw new IllegalArgumentException("Cannot add a null"
                + " element to the stack!");
        } else {
            Node current = head;
            if (current == null) {
                head = new Node(m, null);
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(m, null);
            }
            // if (head == null) {
            //     head = new Node(m, null);
            // } else {
            //     Node oldHead = new Node(head.data, head.next);
            //     Node add = new Node(m, oldHead);
            //     head = add;
            // }
        }

    }

    /**
     * Pop from the stack.
     *
     * @return the Minion from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty.
     */
    public Minion pop() {
        if (head == null) {
            throw new NoSuchElementException("Cannot pop an empty stack!");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node currentTwo = head;
        while (currentTwo.next != current) {
            currentTwo = currentTwo.next;
        }
        Node temp = new Node(current.data, null);
        currentTwo.next = null;
        return temp.data;
    }

    //Recursive Functions
    /**
     * Get from list
     * @param i - the index to retrieve from
     * @return the Minion from the specified index
     * @throws IndexOutOfBoundsException if if i is < 0 or >= size.
     */
    public Minion get(int i) {
        // Finds and returns the minion at specified index i.
        // Throws IndexOutOfBoundsException if i is < 0 or >= size.
        if (i < 0 || i >= this.size()) {
            throw new IndexOutOfBoundsException("Cannot get a minion at"
                + " an Index not in List");
        }
        return getter(head, i);
    }

    private Minion getter(Node check, int i) {
        if (i == 0) {
            return check.data;
        } else {
            i--;
            return getter(check.next, i);
        }
    }

    /**
     * String representation of list
     *
     * @return String in the format "[minion1,minion2,minion3,]"
     */
    public String toString() {
        String res = "[";
        if (head == null) {
            return "[]";
        }
        return stringer(res, head);
    }

    private String stringer(String rep, Node info) {
        rep += info.data + ",";
        if (info.next == null) {
            rep += "]";
            return rep;
        } else {
            return stringer(rep, info.next);
        }
    }

    /**
     * Size of list
     *
     * @return number of elements in the MinionList
     */
    public int size() {
        if (head == null) {
            return 0;
        } else {
            return sizer(head, 1);
        }
    }

    private int sizer(Node current, int size) {
        if (current.next == null) {
            return size;
        } else {
            size++;
            return sizer(current.next, size);
        }
    }

    /**
     * Reverses list
     *
     * @return MinionList with elements in reverse
     */
    public MinionList reverse() {
        //Returns a new MinionList with the same elements
        //as this MinionList but whose elements are in reverse order from
        //this MinionList.
        //For example for the list [minion1, minion2, minion3] this method
        //would return [minion3, minion2, minion1].
        MinionList reverse = new MinionList();
        if (head == null) {
            return reverse;
        }

        return reverser(head, reverse);
    }

    private MinionList reverser(Node current, MinionList flip) {
        if (current.next == null) {
            flip.enqueue(current.data);
        } else {
            reverser(current.next, flip);
            flip.enqueue(current.data);
        }
        return flip;
    }
}