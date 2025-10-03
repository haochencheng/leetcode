package pers.cc.demo.leetcode.common;

import java.util.*;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:38
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode EMPTY_TREENODE = new TreeNode();

    public TreeNode findByVal(int val) {
        return findByVal(val, this);
    }

    private TreeNode findByVal(int val, TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == val) {
            return treeNode;
        }
        TreeNode left = findByVal(val, treeNode.left);
        if (left != null) {
            return left;
        }
        TreeNode right = findByVal(val, treeNode.right);
        if (right != null) {
            return right;
        }
        return null;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }else {
            if(p != null && q != null && p.val == q.val){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else {
                return false;
            }
        }
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        boolean offer = queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            // 构建左子树
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            // 构建右子树
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 测试：前序遍历
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, 4, 5, 6};
        TreeNode root = buildTree(arr);
        preorder(root); // 输出: 1 2 4 3 5 6
    }



    public static TreeNode fillTreeNode(List<Integer> list) {
        final int length = list.size();
        int mLen = Double.valueOf(length * 1.5).intValue();
        Map<Integer, TreeNode> map = new HashMap<>(mLen);
        for (int i = 0; i < length; i++) {
            Integer integer = list.get(i);
            if (Objects.isNull(integer)) {
                map.put(i + 1, null);
            } else {
                TreeNode tmp = new TreeNode(integer);
                map.put(i + 1, tmp);
            }
        }
        final Set<Map.Entry<Integer, TreeNode>> entries = map.entrySet();
        for (Map.Entry<Integer, TreeNode> entry : entries) {
            final Integer key = entry.getKey();
            final TreeNode value = entry.getValue();
            final TreeNode lNode = map.get(key * 2);
            if (lNode == null) {
                continue;
            }
            value.left = new TreeNode(lNode.val);
            if (key % 2 == 0) {
                final TreeNode treeNode = map.get(key / 2);
                if (treeNode != null) {
                    treeNode.left = value;
                }
            }

            final TreeNode rNode = map.get(key * 2 + 1);
            if (rNode == null) {
                continue;
            }
            value.right = new TreeNode(rNode.val);
            if (key % 2 != 0) {
                final TreeNode treeNode1 = map.get((key - 1) / 2);
                if (treeNode1 != null) {
                    treeNode1.right = value;
                }
            }
            map.put(key, value);
        }
        return map.get(1);
    }


    public static TreeNode fillTreeNodeWidth(List<Integer> list) {
        LinkedList<Integer> linkedList = new LinkedList(list);
        TreeNode treeNode = null;
        LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            Integer val = linkedList.pop();
            TreeNode node = treeNodeQueue.poll();
            if (Objects.isNull(treeNode)) {
                if (Objects.isNull(val)) {
                    throw new RuntimeException("root node not be null");
                }
                treeNode = new TreeNode(val);
                treeNodeQueue.add(treeNode);
                continue;
            }
            if (Objects.nonNull(val)) {
                node.left = new TreeNode(val);
                treeNodeQueue.add(node.left);
            }
            val = linkedList.poll();
            if (Objects.nonNull(val)) {
                node.right = new TreeNode(val);
                treeNodeQueue.add(node.right);
            }
        }
        return treeNode;
    }


}
