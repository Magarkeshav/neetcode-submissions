class Solution {
    public int maxArea(int[] heights) {
        int maxwater = 0 ;
        
        int i = 0 ;
        int j = heights.length -1 ;
        while(i < j){
            int minheight = Math.min(heights[i] , heights[j]);
            int len = j-i ;
            int cw = len * minheight ;
            maxwater = Math.max(maxwater , cw);
            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxwater;
        
    }
}
