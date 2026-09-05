class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String str = strs[0] ; 
        String str1 = strs[strs.length -1];

        int i = 0 ;
        StringBuilder sb = new StringBuilder() ;
        while(i < str.length() &&  i < str1.length()){
            if(str.charAt(i) == str1.charAt(i)){
                sb.append(str.charAt(i));
            }else{
                break;
            }
            i++;


        }
        return new String(sb);
    }
}