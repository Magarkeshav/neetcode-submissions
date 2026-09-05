class Solution {
    public int majorityElement(int[] nums) {
        nums = sort(nums);
        int n = nums.length/2 ;
        int i = 0 ;
        int j = 0 ;
        while(j < nums.length ){
            if(nums[i]==nums[j]){
                j++;
            }else {
                if(j-i > n){
                    return nums[i];
                }else{
                    i = j;
                    
                }
            }
        }
        if(j - i > n){
            return nums[i];

        }else{
            return -1;
        }
        
        
    }
    public int[] sort(int[] nums){
        if(nums.length<=1){
            return nums;
        }

        int mid = nums.length / 2 ;
        int [] left  = sort(Arrays.copyOfRange(nums,0,mid));
        int [] right = sort(Arrays.copyOfRange(nums,mid,nums.length));

        return marge(left , right);

    }
    public  int[] marge(int[] first , int[] second){
        int i = 0 ;
        int j = 0 ;
        int k= 0;
        int [] ans = new int[first.length+second.length];


        while (i < first.length && j < second.length){
            if(first[i] < second[j]){
                ans[k] = first[i] ;
                i++;

            }else {
                ans[k] =second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            ans[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            ans[k] = second[j];
            j++;
            k++;
        }
        return ans ;

    }
}