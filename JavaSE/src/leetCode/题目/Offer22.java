package leetCode.题目;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 2021/6/15  未完成
 *
 * 2021/6/16  完成
 */
public class Offer22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        /*
        栈实现，未能通过[1] , 1
         */
//        Stack<ListNode> stack = new Stack<>();
//        while (head.next != null) {
//            stack.push(head.next);
//            System.out.println(head.next.val);
//            head.next = head.next.next;
//        }
//        ListNode result = null;
//        int i = 1;
//        while (!stack.isEmpty()) {
//            if (k == i) {
//                result = stack.peek();
//                break;
//            }
//            i++;
//            stack.pop();
//        }
//        return result;

        /*
        双指针实现
         */
        ListNode p = head;
        ListNode q = head;
        int i = 1;
        while(p.next != null){
            if(i == k){
                q = q.next;
                p = p.next;
            }else {
                i++;
                p = p.next;
            }
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = new ListNode(0, listNode);
        ListNode kthFromEnd = getKthFromEnd(head, 1);
        System.out.println(kthFromEnd.val);
    }
}
