package DataStructures;

import util.ListNode;
import util.NodeWrapper;

import java.util.HashSet;

public class LinkedLists {
    //1.1
    public static void removeDuplicatesInLinkedList(ListNode input) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        ListNode previous = null;
        while (input != null) {
            if (uniqueElements.contains(input.value)) {
                previous.next = input.next;
            } else {
                uniqueElements.add(input.value);
                previous = input;
            }
            input = input.next;
        }
    }

    public static void removeDuplicatesInLinkedListNoBuffer(ListNode input) {
        if (input == null) return;
        ListNode current = input;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //1.2
    public static ListNode findNLastElementRecurrence(ListNode head, int elementNumber, NodeWrapper counter) {
        if (head == null) return null;
        ListNode node = findNLastElementRecurrence(head.next, elementNumber, counter);
        counter.setIndex(counter.getIndex() + 1);
        if (counter.getIndex() == elementNumber) {
            return head;
        }
        return node;
    }

    public static ListNode findNLastElement(ListNode head, int elementNumber) {
        if (elementNumber <= 0) return null;
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < elementNumber - 1; i++) {
            if (p2 == null) return null;
            p2 = p2.next;
        }

        if (p2 == null) return null;

        while ((p2.next != null)) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //1.3
    public static boolean deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode next = node.next;
        node.value = next.value;
        node.next = next.next;
        return true;
    }

    //1.4
    public static ListNode listPartition(ListNode node, int x) {
        ListNode before = null;
        ListNode after = null;

        while (node != null) {
            ListNode next = node.next;
            if (node.value < x) {
                node.next = before;
                before = node;
            } else {
                node.next = after;
                after = node;
            }
            node = next;
        }
        if (before == null) {
            return after;
        }

        ListNode head = before;
        while (before.next != null) {
            before = before.next;
        }
        before.next = after;

        return head;
    }

    //1.5
    public static ListNode addListsInverted(ListNode list1, ListNode list2, int carry) {
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;
        if (list1 != null) {
            value += list1.value;
        }
        if (list2 != null) {
            value += list2.value;
        }

        result.value = value % 10;

        if (list1 != null || list2 != null) {
            ListNode next = addListsInverted(list1 == null ? null : list1.next,
                    list2 == null ? null : list2.next,
                    value >= 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }
}
