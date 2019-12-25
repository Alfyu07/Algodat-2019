package Modul3;
import java.util.Stack;

public class find132 {
    static public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n<3) return false;
        if(n>15000) return false;
        int min = 0;
        for(int i = 0; i<nums.length; i++){
            int sign = 0;
            Stack<Integer> cek = new Stack<Integer>();
            cek.push(nums[i]);
            min = nums[i];
            sign++;
            for(int j = i+1; j<nums.length; j++){
                if(sign < 2){
                    if(cek.isEmpty()){
                        cek.push(nums[j]);
                        min = nums[j];
                        sign++;
                    }else if(cek.peek() > nums[j]){
                        cek.pop();
                        cek.push(nums[j]);
                        min = nums[j];
                    }else{
                        cek.push(nums[j]);
                        sign++;
                    }
                }else{
                    if(cek.peek() <= nums[j]){
                        cek.pop();
                        cek.push(nums[j]);
                    }else {
                        if(min < nums[j]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
//        int [] nums = {1,0,1,-4,-3};
//        int [] nums = {3,5,0,3,4};
        int [] nums = {3,1,4,2,3,4};
//        int [] nums = {4,2,3,4,1,2};
//        int [] nums = {8,10,4,6,5};
//        int [] nums = {1,4,2};
//        int [] nums = { 5, 3, 7, 0, 2, 1};
//        int [] nums = {-2,1,1};



        System.out.println(find132pattern(nums));
    }
}
