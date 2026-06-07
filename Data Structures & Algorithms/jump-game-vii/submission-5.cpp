class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {


        int n = s.size();
        if(s[n-1]=='1') return false;
        vector<int> ajuns( n , 0);
        ajuns[0] = 1;
        int pre = 0;
        for(int i=1;i<n;i++){
            if(i>= minJump) {
                pre += ajuns[i-minJump];
            }
            if(i > maxJump){
                pre-= ajuns[i-maxJump-1];
            }
            
            //cout<< pre << " "<< endl;
            ajuns[i] = (pre> 0 && s[i] == '0')? 1: 0;

        }

        
        if(ajuns[n-1] == 1) return true;
        return false;



    }
};