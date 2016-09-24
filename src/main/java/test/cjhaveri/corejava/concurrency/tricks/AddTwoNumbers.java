package test.cjhaveri.corejava.concurrency.tricks;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Created by chetanjhaveri on 9/24/16.
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = null;

        if (l1 == null && l2 == null) {
            return sum;
        } else if (l1 == null && l2 != null) {
            sum = new ListNode(l2.val);
            ListNode next = addTwoNumbers(null, l2.next);
            sum.next = next;
        } else if (l1 != null && l2 == null) {
            sum = new ListNode(l1.val);
            ListNode next = addTwoNumbers(l1.next, null);
            sum.next = next;
        } else {
            sum = new ListNode(l1.val + l2.val);
            ListNode next = addTwoNumbers(l1.next, l2.next);
            sum.next = next;
        }

        return sum;

    }


}
