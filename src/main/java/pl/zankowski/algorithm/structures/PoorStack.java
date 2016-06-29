package pl.zankowski.algorithm.structures;

/**
 * @author Wojciech Zankowski
 */
public class PoorStack<T> {

    private class Node {

        private final T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

    }

    private Node head;

    public void push(T object) {
        Node node = new Node(object);
        node.next = head;
        head = node;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    public T pop() {
        if (head != null) {
            final T object = head.value;
            head = head.next;
            return object;
        }
        return null;
    }

}
