package com.kellyqi.question.string;

/**
 * Created by zhaoqi1 on 2017/5/15.
 */

/**
 * 583. Delete Operation for Two Strings
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.
 */

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        System.out.println(minDistance("sea","ate"));
        System.out.println(otherAnswer("sea","ate"));
    }

    /**
     * error
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {


        String miniLenth = word1.length() - word2.length() > 0 ? word2:word1;
        String maxLenth = word1.length() - word2.length() > 0 ? word1:word2;

        int sameCharSize = 0;

        char[] chars = miniLenth.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (maxLenth.indexOf(c)!= -1){
                sameCharSize ++;
            }
        }
        return (miniLenth.length() - sameCharSize)+(maxLenth.length() - sameCharSize);
    }

    /**
     *  sea  ate
     * J        a   t   e
     *  I
     *    s     0   0   0
     *    e     0   0   1
     *    a     0   0   1
     * @param word1
     * @param word2
     * @return
     */
    public static int otherAnswer(String word1, String word2){
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
                        : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int val =  dp[word1.length()][word2.length()];
        return word1.length() - val + word2.length() - val;
    }
}
