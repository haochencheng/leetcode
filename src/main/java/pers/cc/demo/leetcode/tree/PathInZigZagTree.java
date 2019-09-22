package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * <p>
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * <p>
 * 提示：
 * <p>
 * 1 <= label <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-22 14:48
 **/
public class PathInZigZagTree {

    public static void main(String[] args) {
        int val = 14;
//        int val = 26;
        PathInZigZagTree pathInZigZagTree = new PathInZigZagTree();
        System.out.println(Arrays.toString(pathInZigZagTree.pathInZigZagTree(val).toArray()));
    }

    public List<Integer> pathInZigZagTree(int label) {
        int deep = 0;
        while (label > Math.pow(2, deep) - 1) {
            deep++;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (deep > 0) {
            int max = (int) Math.pow(2, deep) - 1;
            int lastMax = (int) Math.pow(2, deep - 1) - 1;
            int v = deep % 2 != 0 ? label - lastMax + 1 : max - label;
            int preIndex = v / 2;
            int preVal;
            if (lastMax == 1) {
                preVal = 1;
            } else {
                preVal = deep % 2 != 0 ? lastMax + 1 - preIndex : lastMax - (int) Math.pow(2, deep - 2) + 1 + preIndex;
            }
            linkedList.addFirst(label);
            label = preVal;
            deep--;
        }
        return linkedList;
    }


}
