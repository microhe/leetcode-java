package L600_Non_negative_Integers_without_Consecutive_Ones;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by he on 17-5-31.
 */
public class Solution {
    private long arrangeNum(int n, int m){
        if(n == 0) return 1;
        long num1 = 1;
        long num2 = 1;
        if(n > m - n)
            n = m - n;
        for(int i = n, j = m; i > 0; i--, j--){
            num1 *= i;
            num2 *= j;
        }
        return num2 / num1;
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
        for(int i = 1; i < numBinLen; i++){
            if(i > 1 && numBin.charAt(i - 1) == '1' && numBin.charAt(i - 2) == '1') break;
            if(numBin.charAt(i) == '1'){
                int len = numBinLen - i;
                if((len - 1) % 2 == 0)
                    oneNum = (len -1) / 2;
                else oneNum = (len -1) / 2 + 1;
                for(int j = 0; j <= oneNum; j++){
                    result += this.arrangeNum(j, len - j);
                }
                if(i == 1) break;
            }
        }
        if(!numBin.contains("11")) result ++;
        return result;
    }

    public static void main(String[] args) {
        Integer a = 100000000;
        int num1 = 0;
        int num2 = 0;
        int lenA = Integer.toBinaryString(a).length();
//        for(int i = 0; i <= a; i++){
//            String tmpstr = Integer.toBinaryString(i);
//            if(!tmpstr.contains("11")) {
//                if(tmpstr.length() == lenA)
//                    num2++;
//                else num1++;
//            }
//        }
        System.out.println(num1);
        System.out.println(num2);

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a).length());
        Solution solution = new Solution();
        System.out.println(solution.findIntegers(a));
    }
}
