class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<=9) return new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int i=0, j=0;
        StringBuffer temp = new StringBuffer();
        for(j=0; j<=9; j++) temp=temp.append(s.charAt(j));
        while(j<s.length()+1) {
            map.put(temp.toString(), map.getOrDefault(temp.toString(), 0) + 1);
            if(j==s.length()) break;
            temp.deleteCharAt(0);
            temp.append(s.charAt(j));
            i++; j++;
        }
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() >=2 ) list.add(entry.getKey());
        }
        return list;
    }
}