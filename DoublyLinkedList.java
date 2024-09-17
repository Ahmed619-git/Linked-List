
public class DoublyLinkedList {

    private int size;

    DoublyLinkedList() {
        size = 0;
    }

    class Node {
        String data;
        Node prev;
        Node next;

        public Node(String data) {
            this.data = data;
            prev = null;
            next = null;
            size++;
        }
    }

    Node head = null;

    // Add at first position.
    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at last position.
    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Add at Index position.
    public void addAtIndex(int index, String data) {
        if (index < 0 || index > size) {
            System.out.println("index out of bound exception.");
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
        if (head == null) {
            System.out.println("list is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    // Delete at last position.
    public void deleteLast() {
        if (head == null) {
            System.out.println("list is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
        size--;
    }

    // Delete at index position.
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

    // Print list.
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL.");
    }

    // Display size of the linked list.
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("ABC");
        list.addLast("DEF");
        list.addLast("GHI");
        list.addFirst("JKL");
        list.addLast("MNO");
        list.addAtIndex(0, "PQR");

        list.printList();
        System.out.println("size: " + list.getSize());

        list.deleteFirst();
        list.printList();
        System.out.println("size: " + list.getSize());

        list.deleteLast();
        list.printList();
        System.out.println("size: " + list.getSize());

        list.deleteAtIndex(2);
        list.printList();
        System.out.println("size: " + list.getSize());
    }
}