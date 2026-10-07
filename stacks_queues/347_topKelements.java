class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int num : nums){
        map.put(num, map.getOrDefault(num, 0)+1);
       }
       // we need elements with most frequency, so we save it according to it by using comparator
       PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> map.get(b)-map.get(a));
       for (int num : map.keySet()){
            pq.offer(num);
       }
       int[] result = new int[k];
       for (int i=0; i<k; i++){
        result[i] = pq.poll();
       }
       return result;
    }
}
