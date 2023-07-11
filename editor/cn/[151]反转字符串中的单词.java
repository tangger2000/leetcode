
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        // firstly, reverse each char
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length-1);

        int slow = 0, fast=0;
        while (fast < arr.length){
            if(arr[fast]==' '){
                reverse(arr, slow, fast-1);
                slow = fast+1;
            }
            fast++;
        }
        reverse(arr, slow, fast-1);

        return cleanSpaces(arr);
    }

    private void reverse(char[] arr, int left, int right){
        while (left < right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            right--;
            left++;
        }
    }

    private String cleanSpaces(char[] arr) {
        int n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            // Skip leading spaces
            while (j < n && arr[j] == ' ')
                j++;

            // Keep non-space characters
            while (j < n && arr[j] != ' ')
                arr[i++] = arr[j++];

            // Skip extra spaces between words
            while (j < n && arr[j] == ' ')
                j++;

            // Add a single space after each word
            if (j < n)
                arr[i++] = ' ';
        }

        // Return the final string after trimming the trailing spaces
        return new String(arr).substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
