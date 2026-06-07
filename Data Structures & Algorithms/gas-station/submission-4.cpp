class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        int sumgas=0;
        int sumcost=0;
        for(int i=0;i<n;i++){
            sumgas+= gas[i];
            sumcost+= cost[i];
        }
        if(sumcost > sumgas) return -1;
        for(int i=0;i<n;i++){
            int motorina =0 ;
            for(int j = i ; j < n;j++ ){
                motorina+= gas[j]-cost[j];
                if(motorina<0){ 
                    
                    i=j;
                    break;
                }
                if(j==n-1) return i;
                
            }
        }

    }
};
