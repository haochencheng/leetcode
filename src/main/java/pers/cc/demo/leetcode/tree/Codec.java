package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-05 17:06
 **/
public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
//        String str = "[1,2,3,null,null,4,5]";
//        String str = "[]";
//        String str = "[1,null,2]";
//        String str = "[3,2,4,1]";
        String str = "[1,2,3,1,3,2,4]";
        TreeNode treeNode = codec.deserialize(str);
        System.out.println(treeNode);
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            if (node == null) {
                list.add(null);
            } else {
                list.add(String.valueOf(node.val));
                queue.push(node.left);
                queue.push(node.right);
            }
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.length() <= 2) {
            return null;
        }
        String s = data.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] split = s.split(",");
        if (split.length == 0) {
            return null;
        }
        TreeNode treeNode = null;
        LinkedList<String> linkedList = new LinkedList();
        LinkedList<TreeNode> nodeLinkedList = new LinkedList();
        for (String val : split) {
            linkedList.add(val);
        }
        TreeNode head = null;
        while (!linkedList.isEmpty()) {
            String val = linkedList.pop();
            if (treeNode == null) {
                treeNode = new TreeNode(Integer.valueOf(val));
                nodeLinkedList.push(treeNode);
                head = treeNode;
            } else {
                if (!nodeLinkedList.isEmpty()) {
                    TreeNode node = nodeLinkedList.peekLast();
                    node.left = val.trim().equals("null") ? null : new TreeNode(Integer.valueOf(val.trim()));
                    val = linkedList.pop();
                    node.right = val.trim().equals("null") ? null : new TreeNode(Integer.valueOf(val.trim()));
                    nodeLinkedList.pollLast();
                    if (node.left != null) {
                        nodeLinkedList.push(node.left);
                    }
                    if (node.right != null) {
                        nodeLinkedList.push(node.right);
                    }

                }
            }
        }
        return head;
    }

}
