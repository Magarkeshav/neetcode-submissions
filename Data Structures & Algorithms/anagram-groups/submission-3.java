class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {



        HashMap<String , List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            String str = strs[i];

            String key = sort(str);

            if(!map.containsKey(key)){
                map.put(key ,new  ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
        
    }
    public String sort(String str){
        if(str.length() <= 1){
            return str ;
        }
        

        String left = sort(str.substring(0 , str.length() / 2));
        String right = sort(str.substring(str.length() /2));
        return merge(left , right);
    }

    public String merge(String left , String right){
        StringBuilder sb = new StringBuilder();

        int i = 0 ;
        int j = 0 ;
        while(i < left.length() && j < right.length()){
            if(left.charAt(i) < right.charAt(j)){
                sb.append(left.charAt(i));
                i++;
            }else{
                sb.append(right.charAt(j));
                j++;
            }
        }

        while(i < left.length()){
            sb.append(left.charAt(i));
            i++;
        }

        
        while(j < right.length()){
            sb.append(right.charAt(j));
            j++;
        }

        return new String(sb);

        
    }
}
