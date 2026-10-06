class Solution {
    public int lastStoneWeight(int[] stones) {
        // create max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : stones){
            pq.add(w);
        }
        // atmost one stone left
        while (pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();
            if (f > s){
                pq.add(f-s);
            }
        }
        // return the last remaining weight of the stone
        if (pq.size()>0){
            return pq.poll();
        }
        return 0;
    }
}
