package offer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author: 张锦标
 * @date: 2023/7/16 10:32
 * MaxLayerSum类
 */
public class MaxLayerSum {
    public int maxLevelSum(TreeNode root) {
        int res = 1;
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        int maxSum = root.val;
        for(int level=1;!q.isEmpty();level++){
            ArrayList<TreeNode> nextQ = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : q) {
                sum+=node.val;
                if (node.left!=null){
                    nextQ.add(node.left);
                }
                if (node.right!=null){
                    nextQ.add(node.right);
                }
            }
            if (sum>maxSum){
                maxSum = sum;
                res = level;
            }
            q = nextQ;
        }
        return res;
    }
}
