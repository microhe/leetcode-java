package L28_Implement_strStr;

/**
 * Created by he on 17-5-29.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("asdf", "d"));
    }
}
