class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int index= -1;
        int n = gas.size();
        int dp[gas.size()];
        for(int i=0;i<gas.size();i++){

            dp[i] = gas[i] - cost[i];
            if(dp[i]>= 0 ) index = i;
        }
        if(index ==-1) return -1;
        index=-1;
        for(int i=0;i<n;i++){
            int motorina = dp[i];
            for(int j=(i+1)%n; j!=i ; j = (j+1)%n){
                if(motorina<0) break;
                motorina+= dp[j];
                //cout<<motorina<<" ";
            }
            //cout<<""<<endl;
            if(motorina>=0) index = i; 
        }
        if(index ==-1) return -1;
        return index;


        
    }
};
