package L600_Non_negative_Integers_without_Consecutive_Ones;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by he on 17-5-31.
 */
public class Solution {
    private int arrangeNum(int n, int m){
        if(n == 0) return 1;
        int num = 1;
        if(n > m - n)
            n = m - n;
        for(int i = n, j = m; i > 0; i--, j--){
            num *= j / i;
        }
        return num;
    }
    public int findIntegers(int num) {
        if(num == 0) return 1;
        int result = 0;
        String numBin = Integer.toBinaryString(num);
        int numBinLen = numBin.length();
        int oneNum;
        if((numBinLen - 1) % 2 == 0)
            oneNum = (numBinLen -1) / 2;
        else oneNum = (numBinLen -1) / 2 + 1;
        for(int i = 0; i <= oneNum; i++){
            result += this.arrangeNum(i, numBinLen - i);
        }
        boolean one = true;
        for(int i = 1; i < numBinLen; i++){
            if(!one) continue;
            if(numBin.charAt(i) == '1'){
                if(i == 1) one = false;
                int len = numBinLen - i;
                if((len - 1) % 2 == 0)
                    oneNum = (len -1) / 2;
                else oneNum = (len -1) / 2 + 1;
                for(int j = 0; j <= oneNum; j++){
                    result += this.arrangeNum(j, len - j);
                }
            } else {
                one = true;
            }
        }
        if(num > 7 && numBin.charAt(1) == '1' && numBin.charAt(numBinLen - 1) == '1') result--;
        if(!numBin.contains("11")) result ++;
        return result;
    }

    public static void main(String[] args) {
        Integer a = 11;
        for(int i = 0; i <= a; i++){
            System.out.println(Integer.toBinaryString(i));
        }
        Solution solution = new Solution();
        System.out.println(solution.findIntegers(a));
    }
}
