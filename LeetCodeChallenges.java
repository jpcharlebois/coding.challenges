import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 26;
    int[] value = twoSum(nums, target);
    System.out.println("" + value[0] + value[1]);
    
    // (2 -> 4 -> 3) + (5 -> 6 -> 4)
    ListNode l1 = new ListNode(3);
    l1.add(new ListNode(4));
    l1.add(new ListNode(2));
    l1.printList();
    ListNode l2 = new ListNode(0);
//    l2.add(new ListNode(6));
//    l2.add(new ListNode(5));
    l2.printList();
    
    ListNode l3 = addTwoNumbers(l1, l2);
    l3.printList();
    
    
  }
  
  public static int[] twoSum(int[] nums, int target) {
    // map to store the index of num by the delta of num to the target 
    Map<Integer, Integer> deltadex = new HashMap<Integer, Integer>();
      
    // loop throught nums
    for (int i = 0; i < nums.length; i++) {
      // check deltadex.comtaints(num[i])
      Integer value = deltadex.get(nums[i]);
      if (value != null) {
        return new int[]{value.intValue(), i};
      }
      // compute delta of target to nums[i] 
      int delta = target - nums[i];
      // save delta to deltadex
      deltadex.put(delta, i);
    }
    return new int[]{-1, -1};
  }
  
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // make a new link list for return value;
        ListNode ln = new ListNode(-1);
        ln.next = new ListNode(-1);
        ln.next.next = new ListNode(-1);

        
        // remainder
        int r = 0;

        // traverse the two ListNodes simultaneously
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a+b+r;
            r = sum/10;

            // storing the the sum of the current nodes in the local ln node
            ListNode newNode = new ListNode(sum-(r*10));

            if (ln.val == -1) {
                ln = newNode;
                continue;
            }
            add(ln, newNode);
        }
        return ln;
    }
    
    public static void add(ListNode list, ListNode newNode) {
        if (list.next == null) {
            list.next = newNode;
            return;
        }
        ListNode trav = list.next;
        while (trav.next != null) {
            trav = trav.next;
        }
        trav.next = newNode;
    }
}
/**
 * Definition for singly-linked list.
 */
 class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
   
   void printList() {
     System.out.print("( " + val);
     ListNode trav = next;
     while (trav != null) {
      System.out.print(" -> " + trav.val);
       trav = trav.next;
     }
     System.out.println(" )");
   }
   
   void add(ListNode newNode) {
     if (next == null) {
       next = newNode;
       return;
     }
     ListNode trav = next;
     while (trav.next != null) {
       trav = trav.next;
     }
     trav.next = newNode;
   }
 }
