class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size() -1;
        int blue = n;
        int red = 0;
        for(int white=0;white<=blue;white++){
            while (white < blue && nums[white] == 2) {
                swap(nums[blue--], nums[white]);
            }
            if (nums[white] == 2) {
                // white == blue aici: elementul e deja la marginea zonei "blue"
                blue--;
                continue; // sarim peste verificarea de 0
            }
            if (nums[white] == 0) {
                swap(nums[red++], nums[white]);
            }
            
        }
    }


    
};