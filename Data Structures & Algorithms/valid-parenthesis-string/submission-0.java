class Solution {
    public boolean checkValidString(String s) {
        int minCount =0;
        int maxCount =0;
        int n = s.length();

        for(char c: s.toCharArray()){
            if(c == '('){
                minCount++;
                maxCount++;
            }
            else if(c ==')'){
                minCount = Math.max( 0 , --minCount);
                maxCount--;
            }
            else{
                maxCount++;
                minCount = Math.max( 0 , --minCount);
            }
            if(maxCount<0) return false;
        }

        if(minCount==0) return true;
        return false;
    }
}
