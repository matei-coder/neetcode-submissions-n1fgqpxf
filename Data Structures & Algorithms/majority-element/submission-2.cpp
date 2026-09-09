class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int ans = nums[0];
        int count=1;
        for(int i=1;i<nums.size();i++){
            int x = nums[i];
            if(x == ans){
                count++;
            }else{
                count--;
                if(count<=0) ans = x;
            }
            cout<<count<<endl;
        }

        return ans;
        
    }
};