package Sheet_Problems.LinkedList;

public class rotateList {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int d)
        {
            this.val = d;
        }
    }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            ListNode temp=head;
            int n= length(head);
             k=k%n;
             while(k-->0)
             {

             }
            return temp;
        }
        public static int length(ListNode head)
        {
            int len=0;
            ListNode temp=head;
            while(temp.next!=null)
            {
               len++;
               temp=temp.next;
            }
            return len;
        }
    }
    public static void main(String[] args) {

    }
}
