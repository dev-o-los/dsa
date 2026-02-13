class MergeSorted {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m)
            arr[k++] = nums1[i++];
        while (j < n)
            arr[k++] = nums2[j++];

        for (int l = 0; l < arr.length; l++) {
            nums1[l] = arr[l];
        }
    }
}