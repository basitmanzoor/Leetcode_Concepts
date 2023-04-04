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

    public ListNode getAt(ListNode head, int index){
        ListNode current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }

        return current;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        int i = left-1;
        int j = right-1;

        while(i<j){
            ListNode NodeAti = getAt(head, i); //getting address of Node at i index
            ListNode NodeAtj = getAt(head, j); //getting address of Node at j index

            //swap the values present at i and j indexes
            int temp = NodeAti.val;
            NodeAti.val = NodeAtj.val;
            NodeAtj.val = temp;

            i++;
            j--;
        }

        return head;
    }
}