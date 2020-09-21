package DataStructures;

import util.ListNode;

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
}
