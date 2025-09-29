package basic;

public class SortedSquares {
    public int[] sortedSquares(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int[] temp = new int[nums.length];
        int next = right;
        int leftSquare;
        int rightSquare;
        while(left <= right){
            leftSquare = nums[left] * nums[left];
            rightSquare = nums[right] * nums[right];
            if(leftSquare < rightSquare){
                temp[next] = rightSquare;
                right--;
            }else{
                temp[next] = leftSquare;
                left++;
            }
            next--;
        }
        return temp;
    }
}
