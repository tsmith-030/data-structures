import structures.*;

/**
 * Created by tsmj2 on 4/3/18.
 */
public class DataStructureApplication {
    public static void main(String[] args) {
        linkedListTest();
//        binarySearchTreeTest();
    }

    private static void binarySearchTreeTest() {
        MyBinarySearchTree tree = new MyBinarySearchTree(8);
        tree.insert(10);
        tree.insert(4);

        tree.printTree();
    }

    private static void linkedListTest() {
        MyLinkedList list = new MyLinkedList<String>("Linked List");

        list.addFirst("This");
        list.addLast("is");
        list.addLast("dope");
        list.addLast("af");
        list.addLast("yo");
        list.printList("Original list");

        list.chopHead();
        list.printList("Chop Head");

        list.deleteAt(3);
        list.printList("Delete at index 3");

        list.addFirst("My");
        list.printList("Add first");

        list.addAt("as fuck", 4);
        list.printList("Add at 4");

        list.chopTail();
        list.printList("Chop Tail");

        System.out.println("The list has a length of: " + list.length());
    }

}
