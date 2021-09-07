class Solution{
    public static String solve(String s){
        String output = "";
        char[] revExpression = new StringBuilder(s).reverse().toString().toCharArray();
        for(char c: revExpression) {
            if(Character.isDigit(c)) {
                output = output.repeat(Integer.parseInt(String.valueOf(c)));
            }
            if(Character.isLetter(c)) {
                output = c + output;
            }
        }
        return output;
    }
}