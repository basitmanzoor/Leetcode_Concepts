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

    public ListNode reverseList(ListNode head) {
        int size = getSize(head); //getting size of linked list

        int i = 0;
        int j = size - 1;

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