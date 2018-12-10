package pers.cc.demo.leetcode;

import lombok.Data;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:38
 **/
@Data
public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }

        TreeNode(int x) {
            val = x;
        }

}
