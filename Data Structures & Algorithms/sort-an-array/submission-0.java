class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums);
        
    }
    public static int[] sort(int[] arr){
        if(arr.length==1){
            return  arr;
        }

        int mid = arr.length / 2 ;
        int[] first = sort(Arrays.copyOfRange(arr,0,mid));
        int[] second = sort(Arrays.copyOfRange(arr,mid,arr.length));

        return marge(first,second);

    }
    public static int[] marge(int[] first , int[] second){
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