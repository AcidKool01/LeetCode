class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        SortedSet<String> set = new TreeSet<String>();
        
        for(List<String> order: orders) {
            String name = order.get(0);
            int tableNo = Integer.parseInt(order.get(1));
            String dish = order.get(2);
            
            set.add(dish);
            if(!map.containsKey(tableNo)) {
                map.put(tableNo, new HashMap<String, Integer>());
            }
            
            Map<String, Integer> temp = map.get(tableNo);
            temp.put(dish, temp.getOrDefault(dish, 0)+1);
            map.put(tableNo, temp);
        }
        
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(set);
        res.add(firstRow);
        
        for(Map.Entry<Integer, Map<String, Integer>> entry: map.entrySet()) {
            List<String> currRow = new ArrayList<>();
            currRow.add(String.valueOf(entry.getKey()));
            for(String x: set) {
                Map<String, Integer> temp = entry.getValue();
                int q = temp.getOrDefault(x, 0);
                currRow.add(String.valueOf(q));
            }
            res.add(currRow);
        }
        
        
        return res;
    }
}