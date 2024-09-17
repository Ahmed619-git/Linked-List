
public class SinglyLinkedList {

    private int size;

    SinglyLinkedList() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
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
        head = newNode;
    }

    // Add at last position.
    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    // Add at Index position.
    public void addAtIndex(int index, String data) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bound exception.");
            return;
        }

        Node newNode = new Node(data);

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node prev = null;
        Node current = head;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = newNode;
        newNode.next = current;
    }

    // Delete first.
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        head = head.next;
        size--;
    }

    // Delete Last.
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node currentNode = head;
        Node secondLastNode = null;

        while (currentNode.next != null) {
            secondLastNode = currentNode;
            currentNode = currentNode.next;
        }

        secondLastNode.next = null;
        size--;
    }

    // Delete at Index.
    public void deleteAtIndex(int index) {
        if (index < 0 || index > (size - 1)) {
            System.out.println("Index out of bound.");
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

        Node prev = null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        size--;
    }

    // Print list.
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("NULL.");
    }

    // Display size of linked list.
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst("a");
        list.addFirst("is");
        list.addLast("list");
        list.addAtIndex(2, "linked");
        list.addAtIndex(4, "in");
        list.addLast("java");

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
    }
}