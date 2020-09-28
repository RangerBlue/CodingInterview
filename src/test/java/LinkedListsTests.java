import DataStructures.LinkedLists;
import org.junit.Test;
import util.ListNode;
import util.NodeWrapper;


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

    //1.2
    @Test
    public void testFindLast3ElementRecurrenceSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertEquals(5, LinkedLists.findNLastElementRecurrence(list, 3, new NodeWrapper()).value);
    }

    @Test
    public void testFindLast1ElementRecurrenceSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertEquals(7, LinkedLists.findNLastElementRecurrence(list, 1, new NodeWrapper()).value);
    }

    @Test
    public void testFindLastOutOfTheBoundElementRecurrenceReturnsNull() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertNull(LinkedLists.findNLastElementRecurrence(list, 10, new NodeWrapper()));
    }

    @Test
    public void testFindLast3ElementSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertEquals(5, LinkedLists.findNLastElement(list, 3).value);
    }

    @Test
    public void testFindLast1ElementSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertEquals(7, LinkedLists.findNLastElement(list, 1).value);
    }

    @Test
    public void testFindLastOutOfTheBoundElementReturnsNull() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertNull(LinkedLists.findNLastElement(list, 10));
    }

    //1.3
    @Test
    public void testDeleteNodeSuccess() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        assertTrue(LinkedLists.deleteNode(list.next.next));
        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(4);
        expectedList.append(5);
        expectedList.append(6);
        expectedList.append(7);

        assertLinkedListAreEqual(expectedList, list);
    }

    @Test
    public void testDeleteLastElement() {
        ListNode list = new ListNode(1);
        list.append(2);
        list.append(3);

        assertFalse(LinkedLists.deleteNode(list.next.next));
        ListNode expectedList = new ListNode(1);
        expectedList.append(2);
        expectedList.append(3);

        assertLinkedListAreEqual(expectedList, list);
    }

    @Test
    public void testListPartitionSuccess() {
        ListNode list = new ListNode(1);
        list.append(3);
        list.append(6);
        list.append(4);
        list.append(2);
        list.append(7);
        list.append(5);

        ListNode expectedList = new ListNode(2);
        expectedList.append(3);
        expectedList.append(1);
        expectedList.append(5);
        expectedList.append(7);
        expectedList.append(4);
        expectedList.append(6);

        assertLinkedListAreEqual(expectedList, LinkedLists.listPartition(list, 4));
    }

    @Test
    public void testListPartitionOnlyLesserSuccess() {
        ListNode list = new ListNode(1);
        list.append(3);
        list.append(6);
        list.append(4);
        list.append(2);
        list.append(7);
        list.append(5);

        ListNode expectedList = new ListNode(5);
        expectedList.append(7);
        expectedList.append(2);
        expectedList.append(4);
        expectedList.append(6);
        expectedList.append(3);
        expectedList.append(1);

        assertLinkedListAreEqual(expectedList, LinkedLists.listPartition(list, 10));
    }

    @Test
    public void testListPartitionOnlyGreaterSuccess() {
        ListNode list = new ListNode(1);
        list.append(3);
        list.append(6);
        list.append(4);
        list.append(2);
        list.append(7);
        list.append(5);

        ListNode expectedList = new ListNode(5);
        expectedList.append(7);
        expectedList.append(2);
        expectedList.append(4);
        expectedList.append(6);
        expectedList.append(3);
        expectedList.append(1);

        assertLinkedListAreEqual(expectedList, LinkedLists.listPartition(list, 0));
    }
}
