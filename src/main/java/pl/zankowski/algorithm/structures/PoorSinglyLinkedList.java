package pl.zankowski.algorithm.structures;

/**
 * @author Wojciech Zankowski
 */
public class PoorSinglyLinkedList<T> {

    private class Node {

        private final T value;
        Node next;

        private Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }
    }

    private Node lastNode;

    public void add(T value) {
        Node node = new Node(value);
        node.next = lastNode;
        lastNode = node;
    }

    public T getLast() {
        return lastNode != null ? lastNode.getValue() : null;
    }

    public T getFirst() {
        Node node = lastNode;
        while (node != null) {
            Node nextNode = node.next;
            if (nextNode == null) {
                return node.getValue();
            }
            node = nextNode;
        }
        return null;
    }

    public void remove(T value) {
        Node node = lastNode;
        Node previousNode = null;
        while (node != null) {
            if (value.equals(node.getValue())) {
                if (previousNode != null) {
                    previousNode.next = lastNode.next;
                } else {
                    lastNode = null;
                }
            }
            previousNode = node;
            node = node.next;
        }
    }

}
