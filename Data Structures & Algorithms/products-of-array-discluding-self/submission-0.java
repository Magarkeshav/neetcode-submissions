class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int[] ans = new int[nums.length];
        for(int i = 1 ; i < nums.length ; i++){
            prefix[i] = (prefix[i-1]) * (nums[i]);

        }

        int[] sefix = new int[nums.length];
        sefix[nums.length -1] = nums[nums.length -1];
        for(int i = nums.length -2; i >= 0 ; i--){
            sefix[i] = sefix[i+1] * nums[i];

        }
        ans[0] = sefix[1];
        ans[nums.length-1] = prefix[nums.length-2];
        for(int i = 1 ; i < nums.length -1 ; i++){
            ans[i] = (prefix[i-1]) * (sefix[i+1]);
        }
        return ans;
    }
}  
