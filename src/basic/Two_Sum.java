package basic;
import java.util.*;

public class Two_Sum {
    public static int[] two_Sum(int[] nums ,int target){
        int limits = nums.length;
        for(int i = 0; i < limits; i++){
            for(int j = limits - 1; j > i; j--){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an array split by ','");
        String nums = scanner.nextLine();
        String[] numsResult = nums.split(",");
        int[] result = new int[numsResult.length];
        int j = 0;
        for(String i : numsResult){
            try{
                result[j] = Integer.parseInt(i.trim());
                j++;
            }catch(NumberFormatException e){
                System.out.println("Input format error");
            }
        }

        System.out.println("Please input an target");
        int target;
        while(true){
            if(scanner.hasNextInt()){
                target = scanner.nextInt();
                break;
            }
            else{
                System.out.println("Please input right number");
            }
        }
        int[] a = two_Sum(result,target);
        try{
            System.out.println(a[0] +"," + a[1]);
        }catch(NullPointerException e){
            System.out.println("No result");
        }
    }
}


