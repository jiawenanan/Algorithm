class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> result=new ArrayList<>();
    if(expression==null||expression.length()==0)  return result;
    List<String> ops=new ArrayList<>();
    for(int i=0; i<expression.length(); i++){
        int j=i;
        while(j<expression.length()&&Character.isDigit(expression.charAt(j)))
            j++;
        ops.add(expression.substring(i, j));
        if(j!=expression.length())   ops.add(expression.substring(j, j+1));
        i=j;
    }
    int N=(ops.size()+1)/2; //num of integers
    ArrayList<Integer>[][] dp=(ArrayList<Integer>[][]) new ArrayList[N][N];
    for(int d=0; d<N; d++){
        if(d==0){
            for(int i=0; i<N; i++){
                dp[i][i]=new ArrayList<>();
                dp[i][i].add(Integer.valueOf(ops.get(i*2)));
            }
            continue;
        }
        for(int i=0; i<N-d; i++){
            dp[i][i+d]=new ArrayList<>();
            for(int j=i; j<i+d; j++){
                ArrayList<Integer> left=dp[i][j], right=dp[j+1][i+d];
                String operator=ops.get(j*2+1);
                for(int leftNum:left)
                    for(int rightNum:right){
                        if(operator.equals("+"))
                            dp[i][i+d].add(leftNum+rightNum);
                        else if(operator.equals("-"))
                            dp[i][i+d].add(leftNum-rightNum);
                        else
                            dp[i][i+d].add(leftNum*rightNum);
                    }
            }
        }
    }
    return dp[0][N-1];
    }
}