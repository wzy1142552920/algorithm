package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/3/30 22:52
 */
public class LevelTravel {

    public void levelTravel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
