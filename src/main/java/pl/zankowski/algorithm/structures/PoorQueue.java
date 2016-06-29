package pl.zankowski.algorithm.structures;

/**
 * @author Wojciech Zankowski
 */
public class PoorQueue<T> {

    private class Node {

        private final T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

    }

    private Node first;
    private Node last;

    public void push(T object) {
        Node oldLast = last;
        last = new Node(object);

        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public T peek() {
        return first != null ? first.value : null;
    }

    public T pop() {
        if (first != null) {
            final T object = first.value;
            first = first.next;
            return object;
        }
        return null;
    }

}
