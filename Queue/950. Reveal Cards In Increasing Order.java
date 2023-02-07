class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] res = new int[n];
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<Integer>();
        for(int x=0; x<n; x++) q.add(x);
        int i=0;
        while(!q.isEmpty()) {
            res[q.remove()] = deck[i++];
            if(!q.isEmpty()) q.add(q.remove());
        }
        return res;
    }
}