class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int totalTime = 0, count = 0;

		for (int[] course : courses) {
			int time = course[0], end = course[1];
			pq.offer(time); 
			totalTime += time;
			count++;
			while (totalTime > end) {
				totalTime -= pq.poll(); 
				count--; 
			}
		}
		return count;
    }
}