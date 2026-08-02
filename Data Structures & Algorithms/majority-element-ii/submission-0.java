class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        sort(nums , 0 ,nums.length);
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                if(j-i > nums.length / 3){
                    ans.add(nums[i]);
                    

                }
                i = j ;
            }
            j++;
        }

        if(j - i > nums.length /3){
            ans.add(nums[i]);
        }
        return ans;

         
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