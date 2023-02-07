// lul solution
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        char []ans=new char[n];
        for(int i=0;i<n;i++){
            ans[i]=nums[i].charAt(i)=='0'?'1':'0';
        }
        return String.valueOf(ans);
    }
}

// practiced backtrack :)

class Solution {
    private String res;
    private List<String> list;
    
    private void solve(String[] nums, int i, String temp) {
        if(i==nums.length) {
            if(!list.contains(temp)) {
                res = temp;
                return;
            }
            return;
        }
        
        temp +='1';
        solve(nums, i+1, temp);
        temp = temp.substring(0, temp.length()-1);
        
        temp +='0';
        solve(nums, i+1, temp);
        temp = temp.substring(0, temp.length()-1);    
    }
    
    public String findDifferentBinaryString(String[] nums) {
        res = "";
        list = new ArrayList<String>();
        Collections.addAll(list, nums);
        
        solve(nums, 0, "");
        return res;
    }
}