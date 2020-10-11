package DataStructures;

import util.ListNode;
import util.NodeWrapper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class LinkedLists {
    //2.1
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

    //2.2
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

    //2.3
    public static boolean deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode next = node.next;
        node.value = next.value;
        node.next = next.next;
        return true;
    }

    //2.4
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

    //2.5
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

    //2.6
    public static ListNode findStartOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //find meeting place
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    //2.7
    public static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        Deque<Integer> stack = new ArrayDeque<>();

        //find half of the list and add first half to stack
        while(fast != null && fast.next != null){
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        //if size is odd skip element in the middle
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            int top = stack.pop().intValue();

            if(top != slow.value){
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
