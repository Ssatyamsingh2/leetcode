class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;

        if (required > bloomDay.length) {
            return -1;
        }

        int low = 1;
        int high = 1000000000;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int bouquets = 0;
            int flowers = 0;

            for (int day : bloomDay) {
                if (day <= mid) {
                    flowers++;

                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}