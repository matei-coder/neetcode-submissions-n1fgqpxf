class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxglobal =INT_MIN;
        int maxim = 0;
        for(const auto& x : nums){
            maxim = max(x , maxim + x);

            maxglobal = max(maxim , maxglobal);
        }

        return maxglobal;

    }
};
