class Solution {
    public int maxResult(int[] nums, int k) {
		Deque<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int max = queue.isEmpty() ? 0 : nums[queue.peekFirst()];
			nums[i] = nums[i] + max;
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			queue.add(i);
			while (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) {
				queue.pollFirst();
			}
		}
		return nums[nums.length - 1];
    }
}