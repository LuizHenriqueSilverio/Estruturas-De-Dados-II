/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bplustree;

/**
 *
 * @author luizh
 */
public class BPlusTree {
    
    Node root = new Node();
    
    public void insert(int key) {
        Node rootNode = root;
        if (rootNode == null) {
            rootNode = new Node();
            rootNode.keys[0] = key;
            rootNode.numberOfKeys++;
            root = rootNode;
        } else {
            if (rootNode.numberOfKeys == 3) {
                Node tempNode = new Node();
                root = tempNode;
                tempNode.children[0] = rootNode;
                split(rootNode, 0, tempNode);
                insertIntoNonFullNode(tempNode, key);
            } else {
                insertIntoNonFullNode(rootNode, key);
            }
        }
    }
    
    private void split(Node nodeToSplit, int index, Node newNode) {
        Node newNodeToInsert = new Node();
        newNodeToInsert.isLeaf = nodeToSplit.isLeaf;
        newNodeToInsert.numberOfKeys = 1;
        newNodeToInsert.keys[0] = nodeToSplit.keys[2]; // Move the last key of nodeToSplit to the new node
        nodeToSplit.keys[2] = 0; // Remove the moved key from nodeToSplit

        if (!nodeToSplit.isLeaf) {
            newNodeToInsert.children[0] = nodeToSplit.children[2];
            newNodeToInsert.children[1] = nodeToSplit.children[3];
            nodeToSplit.children[2] = null;
            nodeToSplit.children[3] = null;
        } else {
            newNodeToInsert.next = nodeToSplit.next;
            nodeToSplit.next = newNodeToInsert;
        }

        for (int i = newNode.numberOfKeys; i > index; i--) {
            newNode.children[i + 1] = newNode.children[i];
            newNode.keys[i] = newNode.keys[i - 1];
        }

        newNode.children[index + 1] = newNodeToInsert;
        newNode.keys[index] = nodeToSplit.keys[1];
        newNode.numberOfKeys++;
        nodeToSplit.numberOfKeys = 1;
    }

    private void insertIntoNonFullNode(Node node, int key) {
        int i = node.numberOfKeys - 1;
        if (node.isLeaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numberOfKeys++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++; // Move to the correct child
            if (node.children[i].numberOfKeys == 3) {
                split(node.children[i], i, node);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            insertIntoNonFullNode(node.children[i], key);
        }
    }

    public boolean search(int key) {
        return searchKeyInNode(root, key);
    }

    private boolean searchKeyInNode(Node node, int key) {
        int i = 0;
        while (i < node.numberOfKeys && key > node.keys[i]) {
            i++;
        }
        if (!node.isLeaf) {
            return searchKeyInNode(node.children[i], key);
        } else {
            while (node != null) {
                for (i = 0; i < node.numberOfKeys; i++) {
                    if (node.keys[i] == key) {
                        return true;
                    }
                }
                node = node.next;
            }
            return false;
        }
    }
    
    public void print() {
        Node node = root;
        while (node != null && !node.isLeaf) {
            node = node.children[0];
        }

        while (node != null) {
            printNode(node);
            node = node.next;
        }
    }

    private void printNode(Node node) {
        System.out.print("[");
        for (int i = 0; i < node.numberOfKeys; i++) {
            System.out.print(node.keys[i]);
            if (i < node.numberOfKeys - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
