package com.company;

public class Stringlist {


    class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    public Stringlist() {
        this.head = null;
        this.tail = null;
    }

    public String first() {
        if (head == null)
            throw new IndexOutOfBoundsException();
        return head.value;
    }

    public void prepend(String s) {
        Node node = new Node(s, head);
        if (head == null)
            tail = node;
        head = node;
    }

    public void removeFirst() {
        if (head == null)
            throw new IndexOutOfBoundsException();
        if (head == tail)
            tail = null;
        head = head.next;
    }

    public String last() {
        if (tail == null)
            throw new IndexOutOfBoundsException();
        return tail.value;
    }

    public void append(String s) {
        if (head == null)
            prepend(s);
        else {
            Node node = new Node(s, null);
            tail.next = node;
            tail = node;
        }

    }

    public void removeLast() {
        if (head == tail)
            removeFirst();
        else {
            Node tmp = head;
            while (tmp.next != tail) {
                tmp = tmp.next;
            }
            tail = tmp;
            tail.next = null;
        }
    }

    public String get(int i) {
        Node tmp = getNode(i);

        if (tmp != null) {
            return tmp.value;
        } else {
            throw new IndexOutOfBoundsException();

        }


    }

    public Node getNode(int i) {
        Node tmp = head;
        int n = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            if (i == ++n) {
                break;
            }

        }
        if (i!=n)
            throw new IndexOutOfBoundsException();

        return tmp;
    }

    public void insert(String s, int i) {
        Node tm = getNode(i - 1);
        Node tmp = tm.next;

        if (tmp == null)
            append(s);
        else {
            Node node = new Node(s, tmp);
            tm.next = node;
        }

    }

    public void remove(int i) {
        Node tm=null;
        if (head == tail)
            removeLast();
        tm=getNode(i);
        tm=tm.next;

    }
}
