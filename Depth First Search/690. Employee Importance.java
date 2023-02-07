/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int ans = 0;
    private HashMap<Integer, Employee> hash;
    
    private void dfs(List<Employee> employees, int id) {
        Employee e = hash.get(id);
        ans += e.importance;
        
        for (Integer v: e.subordinates) {
            dfs(employees, v);
        }
    }
    
    public int getImportance(List<Employee> employees, int id) {
        int n = employees.size();
        hash = new HashMap<Integer, Employee>();
        for (Employee e: employees) {
            hash.put(e.id, e);
        }     
        dfs(employees, id);    
        return ans;
    }
}