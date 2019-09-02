package pers.cc.demo.leetcode.util;

import pers.cc.demo.leetcode.common.Node;
import pers.cc.demo.leetcode.common.TreeNode;

import java.util.*;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:37
 **/
public class NodeUtil {


    public static Node fillTreeNode(List<Integer> list) {
        final int length = list.size();
        int mLen = Double.valueOf(length * 1.5).intValue();
        Map<Integer, Node> map = new HashMap<>(mLen);
        for (int i = 0; i < length; i++) {
            Integer integer = list.get(i);
            if (Objects.isNull(integer)) {
                map.put(i + 1, null);
            } else {
                Node tmp = new Node(integer);
                map.put(i + 1, tmp);
            }
        }
        final Set<Map.Entry<Integer, Node>> entries = map.entrySet();
        for (Map.Entry<Integer, Node> entry : entries) {
            final Integer key = entry.getKey();
            final Node value = entry.getValue();
            final Node lNode = map.get(key * 2);
            if (lNode == null) {
                continue;
            }
            value.left = new Node(lNode.val);
            if (key % 2 == 0) {
                final Node treeNode = map.get(key / 2);
                if (treeNode != null) {
                    treeNode.left = value;
                }
            }

            final Node rNode = map.get(key * 2 + 1);
            if (rNode == null) {
                continue;
            }
            value.right = new Node(rNode.val);
            if (key % 2 != 0) {
                final Node treeNode1 = map.get((key - 1) / 2);
                if (treeNode1 != null) {
                    treeNode1.right = value;
                }
            }
            map.put(key, value);
        }
        return map.get(1);
    }


    public static Node fillNodeWidth(List<Integer> list) {
        LinkedList<Integer> linkedList = new LinkedList(list);
        Node node = null;
        LinkedList<Node> treeNodeQueue = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            Integer val = linkedList.pop();
            Node tmpNode = treeNodeQueue.poll();
            if (Objects.isNull(node)) {
                if (Objects.isNull(val)) {
                    throw new RuntimeException("root tmpNode not be null");
                }
                node = new Node(val);
                treeNodeQueue.add(node);
                continue;
            }
            if (Objects.nonNull(val)) {
                tmpNode.left = new Node(val);
                treeNodeQueue.add(tmpNode.left);
            }
            val = linkedList.poll();
            if (Objects.nonNull(val)) {
                tmpNode.right = new Node(val);
                treeNodeQueue.add(tmpNode.right);
            }
        }
        return node;
    }
}
