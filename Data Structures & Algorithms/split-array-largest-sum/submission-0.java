class Solution {
    public int splitArray(int[] nums, int k) {
        int maxim=0;
        int sum=0;
        for(int x:nums) {
            maxim=Math.max(maxim, x);
            sum+=x;
        }
        int l=maxim , r=sum;
        while(l<=r){
            int m=(r-l)/2+l;
            boolean t = isSplitfesaible(nums , k , m);
            System.out.println(m +" " +t);
            if(t==true){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }

    public boolean isSplitfesaible(int[] nums , int k , int maxVal){
        int splits=1;
        int sum=0;
        for(int num:nums){
            if(num+sum<=maxVal){
                sum=sum+num;
            }
            else if(num<=maxVal&&num+sum>maxVal&&splits<k){
                sum=num;
                splits++;
            }
            else{
                return false;
            }
        }
        return true;
    }


}