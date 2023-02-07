class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i=0; i<n; i++) {
            workers[i] = new double[]{(double) wage[i]/quality[i], (double) quality[i]};
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> pq = new PriorityQueue<Double>();
        double ans = Double.MAX_VALUE, qSum = 0;  
        
        for (double[] worker : workers) {
            qSum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qSum += pq.poll();
            if (pq.size() == K) ans = Math.min(ans, qSum * worker[0]);
        }
        
        return ans;
    }
}