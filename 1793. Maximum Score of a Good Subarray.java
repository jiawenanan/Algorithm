 public int maximumScore(int[] nums, int k) {
         int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(stack.size() > 0 && nums[stack.peekLast()] >= nums[i]) {
                stack.pollLast();
            }
            if (stack.size() == 0) {
                left[i] = -1;
            } else {
                left[i] = stack.peekLast();
            }
            stack.addLast(i);
        }
        while(stack.size() > 0) {
            stack.pollLast();
        }
        for (int i = n - 1; i >= 0; i--) {
            while(stack.size() > 0 && nums[stack.peekLast()] >= nums[i]) {
                stack.pollLast();
            }
            if (stack.size() == 0) {
                right[i] = n;
            } else {
                right[i] = stack.peekLast();
            }
            stack.addLast(i);
        }

        for (int i = 0; i < n; i++) {
            if (left[i] + 1 <= k && right[i] - 1 >= k) {
                res = Math.max(res, nums[i] * (right[i] - left[i] - 1));
            }
        }
        return res;
    }