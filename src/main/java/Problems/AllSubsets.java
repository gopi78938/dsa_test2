package Problems;

import java.util.*;

public class AllSubsets {

    public static void main(String [] args){
        List<List<Integer>> res= subsetSum(new int[]{2,3,5},8);
        System.out.println(res);
    }



        public static List<List<Integer>> subsetSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>(), 0, target, result);
            return result;
        }

        private static void backtrack(int[] nums, int index, List<Integer> curr,
                                      int sum, int target, List<List<Integer>> result) {

            if (sum == target) {
                result.add(new ArrayList<>(curr));
                // continue searching for more combinations
            }

            for (int i = index; i < nums.length; i++) {
                curr.add(nums[i]);
                backtrack(nums, i + 1, curr, sum + nums[i], target, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

