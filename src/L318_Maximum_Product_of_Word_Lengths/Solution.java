package L318_Maximum_Product_of_Word_Lengths;

class Solution {
    public int maxProduct(String[] words) {
        int maxNum = 0;
        int tmpNum = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++){
                boolean flag = true;
                for (int k = 0; k < words[i].length(); k++) {
                    if(words[j].indexOf(words[i].charAt(k)) != -1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    tmpNum = words[i].length() * words[j].length();
                    if (tmpNum > maxNum){
                        maxNum = tmpNum;
                    }
                }

            }
        }
        return maxNum;
    }
    public static void main(String[] args) {
        String[] strs = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(strs));
    }
}
