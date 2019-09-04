package pers.cc.demo.leetcode.common;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:38
 **/
@ToString
public class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){

        }

        public TreeNode(int x) {
            val = x;
        }

        public static TreeNode EMPTY_TREENODE=new TreeNode();

        public TreeNode findByVal(int val){
                return findByVal(val, this);
        }

        private TreeNode findByVal(int val,TreeNode treeNode){
                if (treeNode==null){
                        return null;
                }
                if (treeNode.val==val){
                        return treeNode;
                }
                TreeNode left= findByVal(val, treeNode.left);
                if (left!=null){
                        return left;
                }
                TreeNode right = findByVal(val, treeNode.right);
                if (right!=null){
                        return right;
                }
                return null;
        }
}
