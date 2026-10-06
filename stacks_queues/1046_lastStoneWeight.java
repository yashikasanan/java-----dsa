class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : stones){
            pq.add(w);
        }
        while (pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();
            if (f > s){
                pq.add(f-s);
            }
        }
        if (pq.size()>0){
            return pq.poll();
        }
        return 0;
    }
}
