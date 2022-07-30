import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("aabaabaafa","aabaaf"));
            
    }


    public int strStr(String haystack, String needle) {
        haystack.indexOf(str)
        if (null == needle || needle.length() == 0) {
            return 0;
        }
        int nl = needle.length();
        int[] next = new int[nl];
        next[0] = 0;

        if (j == nl) {
            return i - nl + 1;
        } else {
            return -1;
        }
    }

    public static String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        ff(arr, 0, arr.length);
        ff(arr, 0, arr.length - n);
        ff(arr, arr.length - n, arr.length);
        return new String(arr);
    }

    // 左闭右开
    public static void ff(char[] arr, int start, int end) {
        char temp;
        for (int i = start, j = end - 1; i <= j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        int slowIndex, fastIndex;
        for (slowIndex = 0, fastIndex = 0; fastIndex < arr.length; fastIndex++) {
            if (arr[fastIndex] != ' ' || arr[fastIndex + 1] != ' ') {
                arr[slowIndex++] = arr[fastIndex];
            }
        }
        int arrLength = slowIndex;
        swap(arr, 0, slowIndex - 1);
        for (int i = 0, j = 0; i < arrLength; i++) {
            if (arr[i] == ' ') {
                swap(arr, j, i - 1);
                j = i + 1;
            }
        }
        return new String(arr).substring(0, arrLength);
    }
    // 闭区间
    public static void swap(char[] arr, int begin, int end) {
        for (int i = begin, j = end; i <= j; i++, j--) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

        // s = s.trim();
        // StringBuilder sb = new StringBuilder();
        // int j = s.length();
        // for (int i = j - 1; i >= 0; i--) {
        //     if (s.charAt(i) == ' ') {
        //         sb.append(s.substring(i + 1, j));
        //         while (i >= 0 && s.charAt(i) == ' ') {
        //             i--;
        //         }
        //         j = ++i;
        //         sb.append(' ');
        //     } 
        // }
        // sb.append(s.substring(0, j));
        // return sb.toString();
    // }
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            if (len - i < k) {
                f(arr, i, len);
                new String(arr);
            } else {
                f(arr, i, i + k);
            }
        }
        return new String(arr);
    }
    // 左闭右开
    public static void f(char[] arr, int begin, int end) {
        for (int i = begin, j = end - 1; i <= j; i++, j--) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }



    public static void reverseString(char[] s) {
        char temp;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (null == nums || nums.length <= 3) {
            return ans;
        }
        Arrays.sort(nums);
        long sum;
        long ltarget = (long) target;
        int nums_length = nums.length;
        for (int i = 0; i < nums_length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if ((long) nums[i]+ nums[i+1] + nums[i+2] + nums[i+3] > ltarget) {
                break;
            }
            if ((long) nums[i]+ nums[nums_length-1] + nums[nums_length-2] + nums[nums_length-3] < ltarget) {
                continue;
            }
            for (int j = i + 1; j < nums_length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                } 
                if ((long) nums[i]+ nums[j] + nums[j+1] + nums[j+2] > ltarget) {
                    break;
                }
                if ((long) nums[i]+ nums[j] + nums[nums_length-1] + nums[nums_length-2] < ltarget) {
                    continue;
                }
                for (int left = j + 1, right = nums_length - 1; left < right; ) {
                    sum = (long) nums[left] + nums[right] + nums[i] + nums[j];
                    
                    if (sum == ltarget) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } 
                    else if (sum < ltarget) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
    

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j > 1 && j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (k < nums.length-1 && j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
