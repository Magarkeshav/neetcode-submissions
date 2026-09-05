class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] prifix = new int[nums.length];

        prifix[0] = nums[0] ;

        for(int i = 1 ; i < nums.length ; i++){
            prifix[i] = prifix[i -1] * nums[i];
        }

        int[] sufix = new int [nums.length];

        sufix[nums.length -1] = nums[nums.length-1];

        for(int i = nums.length - 2 ; i !=0 ; i--){
            sufix[i] = nums[i] * sufix[i+1];
        }

        int ans[] = new int[nums.length];
        ans[0] = sufix[1] ;
        ans[nums.length -1] = prifix[nums.length -2];


        for(int i = 1 ; i < nums.length - 1 ; i++){
            ans[i] = prifix[i-1] * sufix[i+1];
        }

        return ans;
        
    }
}  
