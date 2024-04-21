public class StringConversion {
    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
    
        // initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j; // deletion
                } else if (j == 0) {
                    dp[i][j] = i; // insertion
                }
            }
        }
    
        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1] + 1; // insertion
                    int del = dp[i - 1][j] + 1; // deletion
                    dp[i][j] = Math.min(add, del);
                }
            }
        }
        int delOperation = n - dp[n][m];
        int insOperation = m - dp[n][m];
        System.out.println("Insertion operation is: " + insOperation);
        System.out.println("Deletion operation is: " + delOperation);
        return dp[n][m];
    }
     
    public static void main(String args[]){
        String word1 = "abcdef";
        String word2 = "aceg";

        System.out.println(editDistance(word1, word2));
    }
}
