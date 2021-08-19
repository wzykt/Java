package 牛客.Offer;

import java.util.*;
import java.util.ArrayList;

/**
 * JZ14 链表中倒数最后k个结点
 * <p>
 * 2021/8/1
 *
 * 完成
 * 差点当成第k大的数
 */
public class JZ14 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here

        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
        }
        if (k > stack.size()) {
            return null;
        }
        ListNode result = null;
        int i = 1;
        while (i <= k) {
            result = stack.pop();
            i++;
        }
        return result;
    }
}
