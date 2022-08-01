package com.zipcodewilmington.singlylinkedlist;

import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    private int size = 0;
    private Node head = null;
    private Node lastNode = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void append(String data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            lastNode.setNext(node);
            lastNode = node;
        }
        size++;
    }

    public String get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    private class Node {
        private final String data;
        private Node next;

        private Node(String data) {
            this.data = data;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private Node getNext() {
            return next;
        }

        private String getData() {
            return data;
        }
    }
}
