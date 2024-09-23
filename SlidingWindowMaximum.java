package queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Result array to store the max of each window
        Deque<Integer> deque = new LinkedList<>();  // Deque to store indices of useful elements

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the deque that are smaller than the current element
            // because they are not useful anymore
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // The first index where a valid window starts is i >= k - 1
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];  // The max of the current window
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Maximum of each sliding window:");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}

