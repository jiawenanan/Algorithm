class Solution {
    public int scoreOfParentheses(String s) {
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        char[] sc = s.toCharArray();
        for(int i = 0; i < sc.length; i++){
            if(sc[i] == '('){
                stack.push(curr);
                curr = 0;
            }
            else{
                curr = stack.pop() + Math.max(curr * 2, 1);
            }
        }
        return curr;
    }
}