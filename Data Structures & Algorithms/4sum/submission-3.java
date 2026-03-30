class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lista = new ArrayList<>();

        for(int i=0;i<=nums.length-4;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<=nums.length-3;j++){
                if(j>0&&nums[j]==nums[j-1]&&i<j-1)continue;
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    long sum = (long)nums[i]+nums[j]+nums[right]+nums[left];
                    System.out.println(nums[i]+" "+nums[j]+" "+nums[left]+" "+nums[right]);
                    System.out.println(sum);

                    if(sum==target){
                        lista.add(List.of(nums[i],nums[j],nums[right],nums[left]));
                        while(left<right&&nums[left]==nums[left+1])left++;
                        while(left<right&&nums[right]==nums[right-1])right--;
                        left++;
                        right--;

                    }
                    else if(sum<target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return lista;
    }
}