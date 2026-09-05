class Solution {

    public String encode(List<String> strs) {

        String ans = "";

        for (String str : strs) {
            ans = ans + str.length() + "#" + str;
        }

        return ans;
    }

    public List<String> decode(String str) {

        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find #
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(str.substring(i, j));

            // Get actual string
            String word = str.substring(j + 1, j + 1 + len);

            list.add(word);

            // Move to next encoded string
            i = j + 1 + len;
        }

        return list;
    }
}