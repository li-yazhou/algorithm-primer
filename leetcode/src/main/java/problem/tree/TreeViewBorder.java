package problem.tree;

import util.TreeUtil.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liyazhou1
 * @date 2020/3/26
 */
public class TreeViewBorder {


    public List<TreeNode> solution(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<TreeNode> right  = new LinkedList<>();
        LinkedList<TreeNode> left  = new LinkedList<>();

        LinkedList<TreeNode> quque  = new LinkedList<>();
        quque.offer(root);
        int currLevel = 1;
        int nextLevel = 0;
        while (!quque.isEmpty()) {

            for (int i = 0; i < currLevel; i ++) {

            }

        }

        return null;

    }

}
