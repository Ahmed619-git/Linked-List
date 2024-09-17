
public class CircularLinkedList {

    private int size;

    CircularLinkedList() {
        this.size = 0;
    }

    class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
            prev = null;
            next = null;
            size++;
        }
    }

    Node head = null;

    // Add at First position.
    public void addFirst(String data) {
        Node newNode = new Node(data);

        // when list is empty.
        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
            return;
        }

        // when more than one node in list.
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at Last position.
    public void addLast(String data) {
        // when list is empty.
        if (head == null) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);

        // when more than one node in list.
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = head;
        head.prev = newNode;
    }

    // Add at Index Position.
    public void addAtIndex(int index, String data) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bonud exception.");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = newNode;
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev = newNode;
    }

    // Delete at first position.
    public void deleteFirst() {
        // when list is empty.
        if (head == null) {
            System.out.println("list is empty.");
            return;
        }
        // when only one node in list.
        if (head.next == head) {
            head = null;
        }
        // when only two nodes in list.
        else if (head.next.next == head) {
            head = head.next;
            head.prev = head;
            head.next = head;
        }
        // when more than two nodes in list.
        else {
            Node temp = head.prev;
            head = head.next;
            head.prev = temp;
            temp.next = head;
        }

        size--;
    }

    // Delete at last position.
    public void deleteLast() {
        if (head == null) {
            System.out.println("Index out of bound exception.");
            return;
        }
        // when only one node in list.
        if (head.next == head) {
            head = null;
        }
        // when only two nodes in list.
        else if (head.next.next == head) {
            head.next = head;
            head.prev = head;
        }
        // when more than two nodes in list.
        else {
            Node temp = head.prev.prev;
            temp.next = head;
            head.prev = temp;
        }

        size--;
    }

    // Delete at Index position.
    public void deleteAtIndex(int index) {
        if (index < 0 || index > (size - 1)) {
            System.out.println("Index out of bound exception.");
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == (size - 1)) {
            deleteLast();
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
    }

    // Print List.
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD.");
    }

    // Display size of the linked list.
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        list.addFirst("ABC");
        list.addLast("DEF");
        list.addFirst(" GHI ");
        list.addLast(" JKL ");
        list.addFirst("MNO");
        list.addLast("PQR");
        list.addAtIndex(2, "STU");

        list.printList();
        System.out.println("size: " + list.getSize());

        list.deleteFirst();
        list.printList();
        System.out.println("size: " + list.getSize());

        list.deleteLast();
        list.printList();
        System.out.println("size: " + list.getSize());

        list.deleteAtIndex(1);
        list.printList();
        System.out.println("size: " + list.getSize());
    }
}