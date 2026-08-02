class Solution {
    public String longestCommonPrefix(String[] strs) {
        strs = sort(strs);

        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        String ans = "";

        int i = 0 ;
        int j = 0 ;
        while (i < str1.length() && j < str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                ans+=str1.charAt(i);
                i++;
                j++;

            }else{
                return ans ;

            }

            
        }
        return ans ;
       
        
    }
    
    public static String[] sort(String [] str){
        if(str.length == 1){
            return str;
        }
        int mid = str.length / 2 ;
        String [] letf = sort(Arrays.copyOfRange(str , 0,mid ));
        String [] right = sort(Arrays.copyOfRange(str ,mid,str.length ));
        return merge(letf,right);







    }
    public  static String[]  merge(String[] left , String[] right){
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        
        String[] ans = new String[left.length+right.length];
        
        while (i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) < 0){
                ans[k] = left[i];
                i++;
                k++;
            } else  {
                ans[k] = right[j];
                j++;
                k++;
                
            }
        }
        while (i < left.length){
            ans[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            ans[k] = right[j];
            j++;
            k++;
        }
        return ans;

    }
}