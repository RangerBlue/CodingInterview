import DataStructures.LinkedLists;
import org.junit.Test;
import util.ListNode;


import static org.junit.Assert.*;

public class LinkedListsTests {

    //1.1
    @Test
    public void testRemoveDuplicatesSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);

        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(3);
        expectedList.append(4);
        LinkedLists.removeDuplicatesInLinkedList(list);
        assertLinkedListAreEqual(expectedList, list);
    }

    @Test
    public void testRemoveTwoDuplicatesSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);

        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(3);
        LinkedLists.removeDuplicatesInLinkedList(list);
        assertLinkedListAreEqual(expectedList, list);
    }

    @Test(expected = AssertionError.class)
    public void testRemoveTwoDuplicatesFail() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);

        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(4);
        LinkedLists.removeDuplicatesInLinkedList(list);
        assertLinkedListAreEqual(expectedList, list);
    }

    @Test
    public void testRemoveDuplicatesNoBufferSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);
        list.append(3);
        list.append(6);

        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(3);
        expectedList.append(4);
        expectedList.append(6);
        LinkedLists.removeDuplicatesInLinkedListNoBuffer(list);
        assertLinkedListAreEqual(expectedList, list);
    }

    @Test
    public void testRemoveTwoDuplicatesNoBufferSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);

        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(3);
        LinkedLists.removeDuplicatesInLinkedListNoBuffer(list);
        assertLinkedListAreEqual(expectedList, list);
    }

    @Test(expected = AssertionError.class)
    public void testRemoveTwoDuplicatesNoBufferFail() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);

        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(4);
        LinkedLists.removeDuplicatesInLinkedListNoBuffer(list);
        assertLinkedListAreEqual(expectedList, list);
    }

    public void assertLinkedListAreEqual(ListNode expected, ListNode actual) {
        while (expected != null) {
            assertEquals(expected.value, actual.value);
            expected = expected.next;
            actual = actual.next;
        }
    }

}
