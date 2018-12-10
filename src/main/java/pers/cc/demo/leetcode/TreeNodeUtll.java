package pers.cc.demo.leetcode;

import java.util.*;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:37
 **/
public class TreeNodeUtll {


    public static TreeNode fillTreeNode(List<Integer> list) {
        final int length = list.size();
        int mLen = Double.valueOf(length * 1.5).intValue();
        Map<Integer, TreeNode> map = new HashMap<>(mLen);
        for (int i = 0; i < length; i++) {
            Integer integer = list.get(i);
            if (Objects.isNull(integer)){
                map.put(i + 1, null);
            }else {
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

}
