package leetCode.题目;

/**
 * 2. 两数相加
 * <p>
 * 2021/6/16
 */
public class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    /*
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean carry = false;
            ListNode result = new ListNode();
            do {
                if (carry) {
                    if (l1.val + l2.val > 10) {
                        carry = true;
                        ListNode tem = new ListNode((l1.val + l2.val) % 10 + 1);
                        result.next = tem;
                        result = result.next;
                    } else {
                        carry = false;
                        ListNode tem = new ListNode(l1.val + l2.val);
                        result.next = tem;
                        result = result.next;
                    }
                } else {
                    if (l1.val + l2.val > 10) {
                        carry = true;
                        ListNode tem = new ListNode((l1.val + l2.val) % 10);
                        result.next = tem;
                        result = result.next;
                    } else {
                        carry = false;
                        ListNode tem = new ListNode(l1.val + l2.val);
                        result.next = tem;
                        result = result.next;
                    }
                }
            } while (l1.next != null && l2.next != null);
            l1 = l1.next;
            l2 = l2.next;
            return result;
        }
    */
    public static void main(String[] args) {

    }
}

