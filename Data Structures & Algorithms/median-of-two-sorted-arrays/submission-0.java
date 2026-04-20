class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length>nums1.length){
            return findMedianSortedArrays(nums2 , nums1);
        }
        boolean iseven=false;
        int inf = Integer.MAX_VALUE/4;
        if((nums1.length+nums2.length)%2==0) iseven=true;


        int l=0,r=nums2.length;
        int m=nums1.length , n=nums2.length;
        while(l<=r){
            int i=(l+r)/2;
            int j=(m+n+1)/2-i;
            System.out.println(i+ " "+ j);

            int maxStangaA = (i == 0) ? Integer.MIN_VALUE : nums2[i - 1];
            int maxStangaB = (j == 0) ? Integer.MIN_VALUE : nums1[j - 1];
            int minDreaptaA = (i == n) ? Integer.MAX_VALUE : nums2[i];
            int minDreaptaB = (j == m) ? Integer.MAX_VALUE : nums1[j];

            if(maxStangaA<=minDreaptaB && maxStangaB<=minDreaptaA){
                if(iseven) return (Math.max(maxStangaA ,maxStangaB)+
                Math.min(minDreaptaA , minDreaptaB))/2.0;
                else return Math.max(maxStangaA , maxStangaB);
            }
            else if(maxStangaA>minDreaptaB) r=i-1;
            else l=i+1;
        }
        return 0;
    }
}
