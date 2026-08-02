class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         //HashMap<Integer, String> map = new HashMap<>();
         List<List<String>> ans = new ArrayList<>();
        // for(int i = 0 ; i < strs.lenght;i++){
        //     String str = sort(strs[i]) ;
        //     List<String> list = new List<>();
        //     int j = 0 ;
        //     while(j < strs.length){
        //         if(i==j){
        //             j++
        //         }
        //         if()

                

        //     }

        // for(int i = 0 ; i < strs.length ; i++){
        //     map.put(i , sort(strs[i]));
        // }
        boolean [] visited = new boolean[strs.length];

        for(int i = 0 ; i < strs.length ; i++){

            List<String> list = new ArrayList<>();
            if(visited[i]){
                continue;
            }
            list.add(strs[i]);
            visited[i] = true;
            String str = sort(strs[i]);
            for(int j = i +1 ; j < strs.length ; j++){
                if(visited[j]){
                    continue;
                }
                if(str.equals(sort(strs[j]))){
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(list);
            
        }
        return ans;


            
        
        
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
