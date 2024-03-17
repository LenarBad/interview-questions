    //    [1 2 3 4].         [1 2 3 4 9]
    //    [5 6 7 4]      ->. [5 6 7 4 9].  -> prefixlength++.  (2)
    // prefixlength = 1.      9 = 9 
    //
    //  if we check all combinations of pairs of nums1 and nums2 subarrays then we can notice
    //  prefixlength(i,j) =  nums1[i-1][j-1] == nums1[i-1][j-1] 
    //                                ? prefixlength(i-1,j-1) + 1 
    //                                : 0
    //  where i and j are lengths of the subarrays
    //  so if find the maximum prefixlength then we find the max length of repeated subarray

    // base case prefixlength(0,j) = 0 and prefixlength(i,0) = 0;


    public int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        int[][] pl = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                pl[i][j] = nums1[i - 1] == nums2[j - 1] ? pl[i - 1][j - 1] + 1 : 0;
                maxLength = Math.max(pl[i][j], maxLength);
            }
        }
        return maxLength;
    }
