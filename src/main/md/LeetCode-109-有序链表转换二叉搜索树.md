## LeetCode-109-有序链表转换二叉搜索树
和将有序数组转换二叉搜索树思路一样，区别在于，有序数组中间位置可以直接得到，有序链表的中间位置，可以通过快慢指针得到
```java
public TreeNode sortedListToBST(ListNode head) {
    return build1(head, null);
}

private TreeNode build1(ListNode head, ListNode tail) {
    if (head == tail) {
        return null;
    }
    ListNode mid = getMid(head, tail);
    TreeNode root = new TreeNode(mid.val);
    root.left = build1(head, mid);
    root.right = build1(mid.next, tail);
    return root;
}

private ListNode getMid(ListNode head, ListNode tail) {
    ListNode fast = head;
    ListNode slow = head;
//查找中间位置的节点，快慢指针注意终止条件
    while (fast != tail && fast.next != tail) {
        fast = fast.next;
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}
```