import java.awt.HeadlessException;
import java.util.LinkedList;

class ListNode {
    ListNode next;
    int val;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedListCycleII{
    //This problem is to find the entry point of the linkedlist cycle if any
   /** 
    * o-o-o-o
         /   \
        o     o
         \   /
           o
    * nodes moved k steps
    * slow node moved k   \
    * fast node moved 2k   => 2k - k = n * r => k = nr
    * circle length r     /
    * distance between start of the list <=> start of circle is s      \
    * distance between start of the list <=> first meeting point is k   => k = m + s => s = (n - 1)r + (r - m) 
    * distance between start of circle <=> first meeting point is m    /                ^                 ^
                                                                                       head              slow
   */

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
               while(head != slow) {
                   head = head.next;
                   slow = slow.next;
               }
               return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cur = head;
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(7);
        ListNode five = new ListNode(8); 
        cur.next = two;
        cur = cur.next;
        cur.next = three;
        cur = cur.next;
        cur.next = four;
        cur = cur.next;
        cur.next = five;
        cur = cur.next;
        cur.next = three;
        System.out.println(detectCycle(head).val);
    }
}