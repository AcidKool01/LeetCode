// BRUTE FORCE APPROACH :')

class Solution {
    public int calPoints(String[] str) {
        int n = str.length, ans = 0;
        List<Integer> scores = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            if(str[i].equals("+") || str[i].equals("D") || str[i].equals("C")) {
                if(str[i].equals("+")) {
                    int f = scores.get(scores.size()-1) + scores.get(scores.size()-2);
                    scores.add(f);
                } else if (str[i].equals("C")) {
                    scores.remove(scores.size()-1);
                } else {
                    int f = scores.get(scores.size()-1);
                    f = f*2;
                    scores.add(f);
                }
            } else {
                System.out.println(str[i]);
                scores.add(Integer.parseInt(str[i]));
            }
        }
        
        for (int i=0; i<scores.size(); i++) {
            ans += scores.get(i);
        }
        
        return ans;
    }
}

// Optimal Solution :)

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String s: ops) {
            if (s.equals("D")) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else if (s.equals("C")) {
                sum -= stack.pop();
            } else if (s.equals("+")) {
                int sec = stack.peek();
                stack.pop();
                int fir = stack.peek();
                int cur = fir + sec;
                stack.push(sec);
                stack.push(cur);
                sum += cur;
            } else {
                stack.push(Integer.parseInt(s));
                sum += stack.peek();
            }
        }
        return sum;
    }
}