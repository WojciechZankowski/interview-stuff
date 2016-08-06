package pl.zankowski.algorithm.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wojciech Zankowski
 */
public class PoorBinaryTree {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node tempNode = root;
            Node parent;
            while (true) {
                parent = tempNode;
                if (key < parent.key) {
                    tempNode = parent.leftChild;
                    if (tempNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else if (key > parent.key) {
                    tempNode = parent.rightChild;
                    if (tempNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                } else {
                    parent.key = newNode.key;
                    parent.name = newNode.name;
                    return;
                }
            }
        }
    }

    public Node findNode(int key) {
        Node tempNode = root;

        while (key != tempNode.key) {
            if (key < tempNode.key) {
                tempNode = tempNode.leftChild;
            } else {
                tempNode = tempNode.rightChild;
            }

            if (tempNode == null) {
                return null;
            }
        }

        return tempNode;
    }

    public boolean removeNode(int key) {
        Node tempNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while (tempNode.key != key) {
            parent = tempNode;
            if (key < tempNode.key) {
                isItALeftChild = true;
                tempNode = tempNode.leftChild;
            } else {
                isItALeftChild = false;
                tempNode = tempNode.rightChild;
            }

            if (tempNode == null) {
                return false;
            }
        }

        if (tempNode.leftChild == null && tempNode.rightChild == null) {
            if (tempNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (tempNode.rightChild == null) {
            if (tempNode == root) {
                root = tempNode.leftChild;
            } else if (isItALeftChild) {
                parent.leftChild = tempNode.leftChild;
            } else {
                parent.rightChild = tempNode.leftChild;
            }
        } else if (tempNode.leftChild == null) {
            if (tempNode == root) {
                root = tempNode.rightChild;
            } else if (isItALeftChild) {
                parent.leftChild = tempNode.rightChild;
            } else {
                parent.rightChild = tempNode.rightChild;
            }
        } else {
            Node replacementNode = getReplacementNode(tempNode);

            if (tempNode == root) {
                root = replacementNode;
            } else if (isItALeftChild) {
                parent.leftChild = replacementNode;
            } else {
                parent.rightChild = replacementNode;
            }

            replacementNode.leftChild = tempNode.leftChild;
        }

        return true;
    }

    private Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node tempNode = replacedNode.rightChild;

        while (tempNode != null) {
            replacementParent = replacement;
            replacement = tempNode;
            tempNode = tempNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public void traverseInOrderTree(Node focusNode) {
        if (focusNode != null) {
            traverseInOrderTree(focusNode.leftChild);

            System.out.println(focusNode);

            traverseInOrderTree(focusNode.rightChild);
        }
    }

    public void traversePreorderTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);

            traversePreorderTree(focusNode.leftChild);

            traversePreorderTree(focusNode.rightChild);
        }
    }

    public void traversePostorderTree(Node focusNode) {
        if (focusNode != null) {
            traversePostorderTree(focusNode.leftChild);

            traversePostorderTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public List<Node> getAllVisibleNodesMinVersion(Node root) {
        List<Node> visibleNodes = new ArrayList<>();

        helper(visibleNodes, root, Integer.MAX_VALUE);

        return visibleNodes;
    }

    private void helper(List<Node> nodes, Node node, int value) {
        if (node == null) {
            return;
        }
        System.out.println(node + ": " + value);
        if (node.key < value) {
            value = node.key;
            nodes.add(node);
        }

        helper(nodes, node.leftChild, value);
        helper(nodes, node.rightChild, value);
    }

    public List<Node> getAllVisibleNodesMaxVersion(Node root) {
        List<Node> visibleNodes = new ArrayList<>();

        maxHelper(visibleNodes, root, Integer.MIN_VALUE);

        return visibleNodes;
    }

    private void maxHelper(List<Node> nodes, Node node, int value) {
        if (node == null) {
            return;
        }
        System.out.println(node + ": " + value);
        if (node.key > value) {
            value = node.key;
            nodes.add(node);
        }

        maxHelper(nodes, node.leftChild, value);
        maxHelper(nodes, node.rightChild, value);
    }

    public static void main(String[] args) {
        PoorBinaryTree poorBinaryTree = new PoorBinaryTree();
        poorBinaryTree.addNode(100, "Node1");
        poorBinaryTree.addNode(60, "Node2");
        poorBinaryTree.addNode(75, "Node3");
        poorBinaryTree.addNode(101, "Node4");
        poorBinaryTree.addNode(125, "Node5");
        poorBinaryTree.addNode(99, "Node6");
        poorBinaryTree.addNode(50, "Node7");

        System.out.println("IN ORDER =====");
        poorBinaryTree.traverseInOrderTree(poorBinaryTree.root);

        System.out.println("PRE ORDER =====");
        poorBinaryTree.traversePreorderTree(poorBinaryTree.root);

        System.out.println("POST ORDER ====");
        poorBinaryTree.traversePostorderTree(poorBinaryTree.root);

        System.out.println("FIND NODE ====");
        System.out.println(poorBinaryTree.findNode(125));

        System.out.println("MIN VISIBLE NODES ====");
        List<Node> nodes = poorBinaryTree.getAllVisibleNodesMinVersion(poorBinaryTree.root);
        System.out.println(nodes);

        System.out.println("MAX VISIBLE NODES ====");
        nodes = poorBinaryTree.getAllVisibleNodesMaxVersion(poorBinaryTree.root);
        System.out.println(nodes);

        System.out.println("FAKE VISIBLE NODES ====");
        System.out.println("MIN " + poorBinaryTree.getAllVisibleNodesMinVersion(poorBinaryTree.createFakeTree()));
        System.out.println("MAX " + poorBinaryTree.getAllVisibleNodesMaxVersion(poorBinaryTree.createFakeTree()));

        System.out.println("REMOVE NODE ====");
        poorBinaryTree.removeNode(60);
        poorBinaryTree.traversePreorderTree(poorBinaryTree.root);
    }

    private Node createFakeTree() {
        Node node1 = new Node(20, "Node1");
        Node node2 = new Node(21, "Node2");
        Node node3 = new Node(3, "Node3");
        node3.leftChild = node1;
        node3.rightChild = node2;

        Node node4 = new Node(1, "Node4");
        Node node5 = new Node(10, "Node5");
        node5.leftChild = node4;

        Node node6 = new Node(5, "Node6");
        node6.leftChild = node3;
        node6.rightChild = node5;

        return node6;
    }

    class Node {

        int key;
        String name;

        Node leftChild;
        Node rightChild;

        public Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", name='" + name + '\'' +
                    '}';
        }

    }

}
