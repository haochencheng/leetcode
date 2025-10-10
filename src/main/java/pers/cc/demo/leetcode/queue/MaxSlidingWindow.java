package pers.cc.demo.leetcode.queue;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxQueue deque = new MaxQueue();
        for (int i = 0; i < k; i++) {
            deque.add(nums[i]);
        }
        int num = 0;
        int[] res = new int[nums.length - k + 1];
        res[num++] = deque.peek();
        for (int i = k; i < nums.length; i++) {
            deque.poll(nums[i-k]);
            deque.add(nums[i]);
            res[num++] = deque.peek();
        }
        return res;
    }

    class MaxQueue {

        Deque<Integer> deque=new ArrayDeque<>();

        void poll(int val){
            if(deque.isEmpty() || deque.peek()==val)  {
                deque.poll();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        int peek() {
            return deque.peek();
        }

    }

    public static void main(String[] args) {
        MaxSlidingWindow slidingWindow = new MaxSlidingWindow();
        int[] ints = slidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }


}
