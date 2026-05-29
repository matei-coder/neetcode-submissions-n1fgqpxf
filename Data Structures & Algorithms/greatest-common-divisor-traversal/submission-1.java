class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        
        //List<List<Integer>> adj = new ArrayList<>()
        
        int n=nums.length;

        int[][] adi =new int[n][n];
        //for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(gcd(nums[i] , nums[j])>1) {
                    adi[i][j] =1;
                    adi[j][i] =1;

                    }
            }
        }

for(int j=0;j<n;j++){
        for(int i=0;i<n;i++){
            
                for(int k=0;k<n;k++){
                    if(adi[i][j]==1&&adi[j][k]==1) adi[i][k]=1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                if(adi[i][j]!=1 &&i!=j) return false;
            }
            System.out.println("");
        }

        return true;
    }

    public int gcd(int a, int b) {
    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
        }   
        return a;
    }
}