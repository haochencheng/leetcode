package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-06 17:37
 **/
public class Codec1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        TreeNode treeNode = SearchTree.buildSearchTree(list);
        Codec1 codec1 = new Codec1();
        String serialize = codec1.serialize(treeNode);
        System.out.println(serialize);
        System.out.println(codec1.deserialize(serialize));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        String s = serialize(root, new StringBuilder()).toString();
        return s.substring(0, s.length() - 1);
    }

    public StringBuilder serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        StringBuilder append = sb.append(root.val).append(",");
        serialize(root.left, append);
        serialize(root.right, append);
        return append;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] split = data.split(",");
        if (split.length < 1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(split[0]));
        TreeNode tmp = treeNode;
        for (int i = 1; i < split.length; i++) {
            Integer val = Integer.valueOf(split[i]);
            TreeNode t = tmp;
            while (t != null) {
                if (val > t.val) {
                    if (t.right==null){
                        t.right=new TreeNode(val);
                        break;
                    }else {
                        t = t.right;
                    }
                } else {
                    if (t.left==null){
                        t.left=new TreeNode(val);
                        break;
                    }else {
                        t = t.left;
                    }
                }
            }
        }
        return tmp;
    }

}
