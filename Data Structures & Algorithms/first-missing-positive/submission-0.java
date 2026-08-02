class Solution {
    public int firstMissingPositive(int[] nums) {
         nums = sort(nums);   // Store the sorted array

        // If 1 is missing, return 1
        boolean hasOne = false;
        for (int x : nums) {
            if (x == 1) {
                hasOne = true;
                break;
            }
        }

        if (!hasOne) {
            return 1;
        }

        int prev = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= 0) {
                continue;
            }

            // Ignore duplicates
            if (nums[i] == prev) {
                continue;
            }

            if (nums[i] == prev + 1) {
                prev = nums[i];
            } else if (nums[i] > prev + 1) {
                return prev + 1;
            }
        }

        return prev + 1;
      
    }
    public  int[] sort(int[] arr){
        if(arr.length==1){
            return  arr;
        }

        int mid = arr.length / 2 ;
        int[] first = sort(Arrays.copyOfRange(arr,0,mid));
        int[] second = sort(Arrays.copyOfRange(arr,mid,arr.length));

        return marge(first,second);

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