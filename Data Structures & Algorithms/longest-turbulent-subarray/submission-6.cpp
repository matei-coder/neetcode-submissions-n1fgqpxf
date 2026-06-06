class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
       int n = arr.size();
        if (n < 2) return n;
        int micmare = 0;
        int last = 0;
        int maximglobal = INT_MIN;
        int lung =1;

        for(int i=1;i<arr.size();i++){
            int x = arr[i];
            if(x > arr[i-1]){       
                if(micmare !=-1) {
                    lung++;
                    
                }
                else{
                   
                    lung =2;
                }
                micmare = -1;
                
            }else if(x < arr[i-1]){              
                if(micmare!=1){
                    lung++;
                    
                }
                else{
                    
                    lung = 2;
                }
                micmare =1;
                
            }
            else{
                lung = 1;
                micmare = 0;
            }
            maximglobal  = max(maximglobal , lung);
        }


        return maximglobal;
    }
};