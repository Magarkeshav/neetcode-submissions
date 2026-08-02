class Solution {
    public boolean isAnagram(String s, String t) {

        return sort(s).equals(sort(t));
       


    }
    public String sort(String str){
       if(str.length() <= 1){
        return str;
    }
        
        int mid = str.length()/2;
       String left = sort(str.substring(0,mid));
        String right = sort(str.substring(mid));
       return  merge(left , right);





    }
    public String merge(String left , String right){
       
        int i = 0 ;
        int j = 0 ;
        String ans = "";
        while(i < left.length() && j < right.length()){
            if(left.charAt(i) < right.charAt(j)){
                ans = ans+left.charAt(i);
                i++;
            }else{
                 ans = ans+right.charAt(j);
                 j++;
            }
            
        }
        while( i < left.length()){
            ans = ans+left.charAt(i);
            i++;
        }

         while( j < right.length()){
            ans = ans+right.charAt(j);
            j++;
        }
        return ans ;
    }
}
