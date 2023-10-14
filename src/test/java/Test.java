import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/10/14 10:57
 * Test类
 */
public class Test {


    public static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(char val) {
            this.val = val;
        }

        public TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode insert(TreeNode root, char val) {
            if (root == null) {
                TreeNode newNode = new TreeNode(val);
                return newNode;
            }
            if (root.val > val) {
                root.left = insert(root.left, val);
            } else if (root.val < val) {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraverse(root.left);
            inorderTraverse(root.right);
            System.out.print(root.val);
        }
    }


        public static void sortByFrequency(String input) {
            // 使用HashMap来统计字符出现的次数
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : input.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }

            // 将字符和出现次数存储到一个List中，然后根据出现次数降序排序
            List<Map.Entry<Character, Integer>> charList = new ArrayList<>(charCount.entrySet());
            charList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println(charList);

        }

        public static void main(String[] args) {
            String input = "abbcccddddeeeee";
            sortByFrequency(input);
        }


}

