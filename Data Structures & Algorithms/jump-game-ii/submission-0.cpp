class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        vector<int> arr(n, INT_MAX);
        arr[0]=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=i+nums[i]&&j<n;j++){
                arr[j] = min(arr[j], arr[i]+1);
            }
        }

        // for(const auto& x: arr){
        //     std:: cout<<x<<" ";
        // }


        return arr[n-1];

    }
};
