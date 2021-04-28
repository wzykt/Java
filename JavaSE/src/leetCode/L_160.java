package leetCode;

import java.util.*;
import java.util.LinkedList;

public class L_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode l1 = headA, l2 = headB;
//        while (l1 != null) {
//            while (l2.next != null) {
//                if (l2 != l1) {
//                    l2 = l2.next;
//                } else {
//                    return l1;
//                }
//            }
//            l2.next = headB;
//            l1 = l1.next;
//        }
//        return null;
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
    }
}

class ListNode {
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