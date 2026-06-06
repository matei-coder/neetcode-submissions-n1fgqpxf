class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int n = nums.size();
        int maxim = 0 ;
        int maximg = INT_MIN;

        int minim = 0;
        int minimg = INT_MAX;

        int suma=0;
        for(int i=0;i<n;i++){
            suma+=nums[i];
            maxim = max(nums[i] , nums[i] + maxim);
            maximg = max(maximg  , maxim );

            minim = min( nums[i]  , nums[i] + minim);
            minimg = min(minim , minimg);
        }

        if(maximg < 0 ) return maximg;



        return max(suma - minimg , maximg);
    }
};