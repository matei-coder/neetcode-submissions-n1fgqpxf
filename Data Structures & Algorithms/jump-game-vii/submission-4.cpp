class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {

        int n = s.length();
        if(s[n-1] == '1') return false;
        vector<int> ajuns(n, 0);
        ajuns[0]= 1;
        bool rasp = false;

        for(int i=0;i<n;i++){
            char c = s[i];
            if(c == '0' &&ajuns[i]==1){
                for(int j=i+minJump ; j<=min(i+maxJump , n-1); j++){
                    ajuns[j] =1; 
                }

            }
            if(ajuns[n-1]==1) rasp = true;


        }


        //for(const auto& x : ajuns) cout<<x<<" ";


        return rasp;
    }
};