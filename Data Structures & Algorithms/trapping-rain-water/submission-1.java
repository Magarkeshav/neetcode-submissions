class Solution {
    public  int trap(int[] height) {
        if(height.length==0) return 0;
        int[] prifix =  new int[height.length];
        prifix[0] = height[0];
        for(int i = 1 ; i < prifix.length ; i++){
            prifix[i] = Math.max(prifix[i-1] , height[i]) ;
        }

        int[] safix =  new int[height.length];
        safix[safix.length -1 ] = height[safix.length -1];

        for(int i = safix.length - 2 ; i >= 0 ; i--){
            safix[i] = Math.max(safix[i+1] , height[i]) ;
        }
        int water = 0 ;

        for(int i = 1 ; i < height.length ; i++){
            int min = Math.min(prifix[i] , safix[i]) ;
            int cr = min - height[i] ;
            water += cr ;

        }
       return water ;


    }
}
