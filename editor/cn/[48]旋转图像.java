
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotateMainDiagonal(int[][] matrix){
        for(int i =0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }

    public void rowReverse(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            int left = 0, right=matrix[i].length-1;
            while (left < right){
                matrix[i][left] ^= matrix[i][right];
                matrix[i][right] ^= matrix[i][left];
                matrix[i][left] ^= matrix[i][right];

                right--;
                left++;
            }
        }
    }

    public void rotate(int[][] matrix) {
        rotateMainDiagonal(matrix);
        rowReverse(matrix);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
