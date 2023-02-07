
// Not Clean ...

class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack();
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i=0; i<n; i++) {
            if(st.isEmpty()) {
                st.push(i);
                left[i] = 0;
            } else {
                while(!st.empty() && arr[st.peek()]>=arr[i]) {
                    st.pop();
                }
                left[i] = st.empty() ? 0 : st.peek()+1;
                st.push(i);
            }
        }
        
        st.clear();
        
        for(int i=n-1; i>=0; i--) {
            if(st.isEmpty()) {
                st.push(i);
                right[i] = n-1;
            } else {
                while(!st.empty() && arr[st.peek()]>=arr[i]) {
                    st.pop();
                }
                right[i] = st.empty() ? n-1 : st.peek()-1;
                st.push(i);
            }
        }
        
        int ans=0;
        
        for(int i=0; i<n; i++) {
            ans = Math.max((right[i]-left[i]+1)*(arr[i]), ans);
        }
        
        return ans;
    }
}

// Clean and Sexy aff

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, heights[prev] * i);
                } else {
                    ans = Math.max(ans, heights[prev] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
