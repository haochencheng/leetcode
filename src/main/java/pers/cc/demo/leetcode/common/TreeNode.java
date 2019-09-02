package pers.cc.demo.leetcode.common;

import lombok.Data;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:38
 **/
@Data
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

}
