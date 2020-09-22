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

    public static ListNode findNLastElementRecurrence(ListNode head, int elementNumber, NodeWrapper counter) {
        if (head == null) return null;
        ListNode node = findNLastElementRecurrence(head.next, elementNumber, counter);
        counter.setIndex(counter.getIndex()+1);
        if(counter.getIndex() == elementNumber){
            return head;
        }
        return node;
    }

    public static ListNode findNLastElement(ListNode head, int elementNumber) {
        if (elementNumber<=0) return null;
        ListNode p1 = head;
        ListNode p2 = head;

        for(int i=0; i < elementNumber-1 ; i++){
            if(p2 == null) return null;
            p2 = p2.next;
        }

        if(p2 == null) return null;

        while ((p2.next != null)){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
