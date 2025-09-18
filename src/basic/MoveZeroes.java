package basic;

public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int nextPosition = 0;
        int nonZerosTop = 0;
        for(; nonZerosTop < nums.length; nonZerosTop++){
            if (nums[nonZerosTop] != 0) {
                if(nonZerosTop != nextPosition){
                    nums[nonZerosTop] = nums[nonZerosTop] ^ nums[nextPosition];
                    nums[nextPosition] = nums[nonZerosTop] ^ nums[nextPosition];
                    nums[nonZerosTop] = nums[nonZerosTop] ^ nums[nextPosition];
                }
                nextPosition++;
            }
        }
    }
}
