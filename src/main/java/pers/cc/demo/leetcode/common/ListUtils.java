package pers.cc.demo.leetcode.common;

import java.util.*;
import java.util.stream.Collectors;

public class ListUtils {

    /**
     * 将二维 int 数组转换为 List<List<Integer>>
     */
    public static List<List<Integer>> toList(int[][] arr) {
        if (arr == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> temp = new ArrayList<>();
            for (int val : row) {
                temp.add(val);
            }
            result.add(temp);
        }
        return result;
    }

    /**
     * 将 List<List<Integer>> 转回 int[][]
     */
    public static int[][] toArray(List<List<Integer>> list) {
        if (list == null) return new int[0][0];
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            arr[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }
        return arr;
    }

    /**
     * 一行 lambda 版本，将二维 int 数组转 List<List<Integer>>
     */
    public static List<List<Integer>> toListLambda(int[][] arr) {
        return Arrays.stream(arr)
                .map(r -> Arrays.stream(r).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    /**
     * 打印 List<List<Integer>> 内容
     */
    public static void printList(List<List<Integer>> list) {
        for (List<Integer> row : list) {
            System.out.println(row);
        }
    }

    // 测试
    public static void main(String[] args) {
        int[][] arr = {{3}, {9, 20}, {15, 7}};

        List<List<Integer>> list = toList(arr);
        System.out.println("二维数组转 List<List<Integer>>:");
        printList(list);

        int[][] back = toArray(list);
        System.out.println("List<List<Integer>> 转回二维数组:");
        for (int[] row : back) {
            System.out.println(Arrays.toString(row));
        }
    }
}
