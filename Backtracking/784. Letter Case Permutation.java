class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        helper(s.toCharArray(), 0);
        return ans;
    }
    
    public void helper(char[] str, int start){
        ans.add(new String(str));
        for(int i=start; i<str.length; i++){
            if((str[i]>='a' && str[i]<='z') || (str[i]>='A' && str[i]<='Z')){
                char ch = str[i];
                if(ch>='A' && ch<='Z'){
                    str[i] = Character.toLowerCase(ch);
                    helper(str, i+1);
                    str[i] = ch;
                }
                else{
                    str[i] = Character.toUpperCase(ch);
                    helper(str, i+1);
                    str[i] = ch;
                }
            }
        }
        return;
    }
}