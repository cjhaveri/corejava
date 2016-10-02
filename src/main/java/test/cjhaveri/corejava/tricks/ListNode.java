package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 9/24/16.
 */ // Definition for singly-linked list.
public class ListNode  {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null) {
            sb.append(next.toString());
        }

        return sb.toString();
    }


}
