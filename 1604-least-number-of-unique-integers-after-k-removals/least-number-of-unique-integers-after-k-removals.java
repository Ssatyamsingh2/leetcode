class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] frequencies = new int[map.size()];
        int i = 0;

        for (int freq : map.values()) {
            frequencies[i++] = freq;
        }

        Arrays.sort(frequencies);

        int elementsRemoved = 0;

        for (i = 0; i < frequencies.length; i++) {
            elementsRemoved += frequencies[i];

            if (elementsRemoved > k) {
                return frequencies.length - i;
            }
        }

        return 0;
    }
}