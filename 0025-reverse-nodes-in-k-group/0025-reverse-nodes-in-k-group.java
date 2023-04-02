/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;

        while(pointer != null){
            ListNode node = pointer;
            //condition for checking if the nodes are statisfying the range
            for(int i =0 ; i<k && node != null;i++){
                node = node.next;
            }
            if(node == null){
                break;
            }
            //if the range satisfies
            ListNode prev = null;
            ListNode current = pointer.next;
            //now we reverse the nodes lying in the range
            for(int i =0; i<k; i++){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            ListNode tail = pointer.next;
            tail.next = current;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}