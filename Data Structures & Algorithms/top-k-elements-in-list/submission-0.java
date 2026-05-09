class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.merge(n, 1, Integer::sum);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (var e : count.entrySet()) {
            freq[e.getValue()].add(e.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i > 0 && idx < k; i--) {
            for (int n : freq[i]) {
                if (idx < k) {
                    res[idx++] = n;
                }
            }
        }
        return res;
    }
}
