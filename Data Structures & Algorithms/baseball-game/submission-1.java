class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < operations.length; i++){

            String str = operations[i];

            if(str.equals("+")){
                int top = st.pop();
                int top2 = st.pop();

                int sum = top2 + top;
               
                st.push(top2);
                 st.push(top);
                st.push(sum);
            }else if(str.equals("C")){
                st.pop();
            }else if(str.equals("D")){
                int top = st.pop();

                int product = top * 2 ;

                st.push(top);
                st.push(product);
            }else{
                int num = Integer.parseInt(str);
                st.push(num);
            }



        }
        
        int sum = 0 ;

        while(!st.isEmpty()){
            sum+= st.pop();
        }
        return sum;
        
    }
}