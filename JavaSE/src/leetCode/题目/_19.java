package leetCode.题目;

public class _19 {
    /*
    无法解决  [1] 1 的情况，抛出NullPointException
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head.next;
        int step = 0;
        while(true){
            if(step != n){
                q = q.next;
                step++;
            }
            if(step == n){
                if(q == null){
                    p.next = p.next.next;
                    break;
                }
                q = q.next;
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {


    }

}
