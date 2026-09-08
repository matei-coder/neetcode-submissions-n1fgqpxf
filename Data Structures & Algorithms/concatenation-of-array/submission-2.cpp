class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        vector<int> ans;
        int n = nums.size();
        ans.reserve(2 * n);
        for(int j=0;j<2;j++)
        for(int i=0;i<n;i++){
            ans.push_back(nums[i]);
        }



        return ans;
    }
};