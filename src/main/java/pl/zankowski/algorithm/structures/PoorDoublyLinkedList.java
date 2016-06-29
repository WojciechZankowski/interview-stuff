package pl.zankowski.algorithm.structures;

/**
 * @author Wojciech Zankowski
 */
public class PoorDoublyLinkedList<T> {

    private class Node {

        private final T value;
        Node next;
        Node previous;

        private Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

    }

    private Node lastNode;
    private Node firstNode;

    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        final Node first = firstNode;
        final Node newNode = new Node(value);
        newNode.next = first;
        firstNode = newNode;
        if (first == null) {
            lastNode = newNode;
        } else {
            first.previous = newNode;
        }
    }

    public void addLast(T value) {
        final Node last = lastNode;
        final Node newNode = new Node(value);
        newNode.previous = last;
        lastNode = newNode;
        if (last == null)
            firstNode = newNode;
        else
            last.next = newNode;
    }

    public T getLast() {
        return lastNode != null ? lastNode.getValue() : null;
    }

    public T getFirst() {
        return firstNode != null ? firstNode.getValue() : null;
    }

}
