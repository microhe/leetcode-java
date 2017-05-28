package L10_Regular_Expression_Matching;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by he on 17-2-6.
 */
public class Solution {
//    public boolean isMatch(String s, String p) {
//        int p_size = p.length();
//        int s_size = s.length();
//        if(s_size==0)return true;
//        int [] s_matchTab = new int[s_size];
//        s_matchTab[0]=0;
//        for(int i=1;i<s_size;i++){
//            if(s.charAt(i)==s.charAt(s_matchTab[i-1]))
//                s_matchTab[i]=s_matchTab[i-1]+1;
//            else s_matchTab[i]=0;
//        }
//
//        int j=0,i=0;
//        while(i<p_size&&j<s_size){
//            if(p.charAt(i)=='.'||s.charAt(j)==p.charAt(i)){
//                j++;
//                i++;
//            }else if(p.charAt(i)=='*'&&((p.charAt(i-1)=='.'&&s.charAt(j)==s.charAt(j-1))||s.charAt(j)==p.charAt(i-1))) {
//                j++;
//            } else{
//                if(p.charAt(i+1)=='*'){
//                    i+=2;
//                }else if(j==0){
//                    i++;
//                }else{
//                    j=s_matchTab[j-1];
//                }
//            }
//        }
//        if(j==s_size) return true;
//        else return false;
//    }


    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return s==p;
        if(s.length() == 0 && p.length() == 0) return true;

        boolean[][] mat = new boolean[s.length() +1][p.length() + 1];
        mat[0][0] = true;
        for (int i=1;i<=s.length();i++) mat[i][0] = false;

        for (int j = 1; j <= p.length(); j++){
            if(p.charAt(j-1) == '*'){
                mat[0][j] = mat[0][j-2];
            }else{
                mat[0][j] = false;
            }
        }

        for (int i = 1; i <= s.length(); i++){
            for (int j =1; j <= p.length(); j++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.'){
                    mat[i][j] = mat[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                        mat[i][j] = mat[i-1][j] || mat[i][j-2] || mat[i][j-1];
                    } else {
                        mat[i][j] = mat[i][j-2];
                    }
                }else {
                    mat[i][j] = false;
                }
                System.out.println("i: " + i + " j: " + j + " " + mat[i][j]);
            }
        }
        return mat[s.length()][p.length()];
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isMatch("ab","abc"));
    }
}
