class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
           HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            String key = sort(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());


            
        
        
    }
    public String sort(String str){
        if(str.length()<=1){

            return str;

        }

        int mid = str.length() / 2 ;
        String left = sort(str.substring(0 , mid));
        String right = sort(str.substring(mid));

        return merge(left , right);

        
    }
     public String merge(String left, String right) {

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < left.length() && j < right.length()) {
            if (left.charAt(i) <= right.charAt(j)) {
                ans.append(left.charAt(i++));
            } else {
                ans.append(right.charAt(j++));
            }
        }

        while (i < left.length()) {
            ans.append(left.charAt(i++));
        }

        while (j < right.length()) {
            ans.append(right.charAt(j++));
        }

        return ans.toString();
    }



    
}
