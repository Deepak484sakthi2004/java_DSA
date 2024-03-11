import java.util.HashMap;
import java.util.Map;

class str {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode return_node = new ListNode();
            ListNode temp = return_node;

            HashMap<Integer, Integer> map = new HashMap<>();

            while (list1.next != null && list2.next != null) {
                if (list1.val > list2.val) {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                    temp = temp.next;
                } else {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                    temp = temp.next;
                }
            }
            if (list1 == null)
                temp = list2;
            if (list2 == null)
                temp = list2;
            return return_node.next;

        }


    }
}
