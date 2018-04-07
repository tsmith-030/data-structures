package structures;

/**
 * Singly-linked list
 * Created by tmackSickles on 4/4/18.
 */
public class MyLinkedList<T> {
    private Node head;
    private Node tail;

    public MyLinkedList(T initialData) {
        this.head = this.tail = new Node(initialData, null);
    }

    // O(1)
    public void addFirst(T newData) {
        head = new Node(newData, head);
    }

    // O(1)
    public void addLast(T newData) {
        tail.next = new Node(newData, null);
        tail = tail.next;
    }

    // O(1)
    public void chopHead() {
        head = head.next;
    }

    // O(n)
    public void chopTail() {
        if(tail == head) {
            chopHead();
            return;
        }

        Node nodeBeforeTarget = head;

        while(nodeBeforeTarget.next.next != null) {
            nodeBeforeTarget = nodeBeforeTarget.next;
        }

        tail = nodeBeforeTarget;
        tail.next = null;
    }

    // O(n)
    public void addAt(T newData, int index) {
        if(index == 0) {
            addFirst(newData);
            return;
        }

        int i = 0;
        Node nodeBeforeTarget = head;

        while(i < index - 1) {
            nodeBeforeTarget = nodeBeforeTarget.next;
            i++;
        }
        nodeBeforeTarget.next = new Node(newData, nodeBeforeTarget.next);
    }

    // O(n)
    public void deleteAt(int index) {
        if(index == 0) {
            chopHead();
            return;
        }

        int i = 0;
        Node nodeBeforeTarget = head;

        while(i < index - 1) {
            nodeBeforeTarget = nodeBeforeTarget.next;
            i++;
        }
        nodeBeforeTarget.next = nodeBeforeTarget.next.next;
    }

    // O(n)
    public void printList() {
        Node nextNode = head;
        while (nextNode != null) {
            System.out.print(nextNode.data + " ");
            nextNode = nextNode.next;
        }
        System.out.println("\n");
    }

    // O(n)
    public void printList(String description) {
        System.out.println(description + ":");

        Node nextNode = head;
        while (nextNode != null) {
            System.out.print(nextNode.data + " ");
            nextNode = nextNode.next;
        }
        System.out.println("\n");
    }

    private static class Node<T> {
        private T data;
        private Node next = null;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
