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
    public ListNode rotateRight(ListNode head, int k) {
        
      if(head==null || head.next==null || k==0)  return head;

      ListNode curr = head;  int len=1;
      while(curr.next!=null){
          len++;  curr = curr.next;     //counting the length of list.
      }
      curr.next = head;                 // joining last node to first making it a circular list.
      k = len-(k%len);                  // doing K%len as any rotation in multiple of len will give same list.Ex- k=12 and len is 5 then we need
                                        // to rotate 2 times.  len-(k%len) is to go till node from start to node where we have to break list.
                                      
      while(k>0){
          curr = curr.next;
          k--;
      }
      head = curr.next;                  // making new head which will be the node after the breaking point;
      curr.next = null;                  // now curr is the last node with its next value as null.
      return head;

    }
}
