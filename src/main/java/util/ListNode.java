package util;

import java.util.Objects;

public class ListNode {
    public ListNode next = null;
    public int value;

    public ListNode() { }

    public ListNode(int value) {
        this.value = value;
    }

    public void append(int element){
        ListNode end = new ListNode(element);
        ListNode current = this;
        while(current.next != null){
            current = current.next;
        }
        current.next = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode secondNode = (ListNode) o;
        ListNode firstNode = this;
        while(firstNode.next != null){
            if(firstNode.value != secondNode.value){
                return false;
            } else{
               firstNode = firstNode.next;
               secondNode = secondNode.next;
            }
        }
        if(secondNode.next != null){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }
}
