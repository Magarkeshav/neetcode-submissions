class Solution {
    public int subarraySum(int[] nums, int k) {
        int ct = 0 ;
        int[] prifix = new int[nums.length];
        prifix[0] = nums[0] ; 
        for(int i = 1 ; i < prifix.length; i++)
        {
           prifix[i] = prifix[i - 1] + nums[i]; 
        }
        for(int i = 0 ; i < nums.length ; i++ )
        {
            int start = i ;
            for(int j = i ; j < nums.length ; j++)
            {
                int end = j ;
                int  cursum = start == 0 ? prifix[end] : prifix[end] - prifix[start - 1] ;
                 if(cursum == k)
                {
                    ct++;
                }
            }
           
        }
        return ct;
        
        
    }
}