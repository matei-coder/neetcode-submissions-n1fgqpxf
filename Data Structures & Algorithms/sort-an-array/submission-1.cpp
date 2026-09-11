class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums , 0 , nums.size()-1);

        return nums;
    }

    void mergeSort(vector<int>& nums , int left , int right){
        if(left>=right) return;
        int mid = (left+right)/2;

        mergeSort(nums , left , mid);
        mergeSort(nums , mid+1 , right);
        merge(nums , left , right , mid );


    }
    void merge(vector<int>& arr , int left , int right , int mid){
        int i = left;
        int j = mid+1;
        vector<int> temp;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp.push_back(arr[i++]);
            } else {
                temp.push_back(arr[j++]);
            }
        }

        while (i <= mid) temp.push_back(arr[i++]);
        while (j <= right) temp.push_back(arr[j++]);

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }


        
    

};