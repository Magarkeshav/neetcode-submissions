class Solution {
    public void sortColors(int[] nums) {
        sort(nums , 0 , nums.length);
        
    }
    
    public  void  sort(int[] arr , int s , int e ){
        if(e - s == 1 ){
            return  ;
        }

        int mid = (s+e)/ 2 ;
        sort(arr,s,mid);
        sort(arr,mid,e);

         marge(arr,s, mid,e);

    }
    public  void marge(int[] arr , int s , int mid , int e ){
        int i = s ;
        int j = mid;
        int k= 0;
        int [] ans = new int[ e - s ] ;



        while (i < mid && j < e){
            if(arr[i] < arr[j]){
                ans[k] = arr[i] ;
                i++;

            }else {
                ans[k] =arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while (j < e){
            ans[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0 ; l < ans.length;l++){
            arr[l+s ] = ans[l];
        }

    }
}