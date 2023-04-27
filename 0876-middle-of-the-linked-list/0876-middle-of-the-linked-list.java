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
    public int getSize(ListNode head){
        int length = 0;
        ListNode current = head;

        while(current != null){
            current = current.next;
            length++;
        }
        return length;
    } 

    public ListNode getAt(ListNode head, int index){
        ListNode current = head;

        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current;
    }
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        ListNode ans = getAt(head, size/2);

        return ans;
    }
}