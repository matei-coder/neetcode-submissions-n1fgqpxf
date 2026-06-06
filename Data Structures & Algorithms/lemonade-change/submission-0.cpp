class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int nrof5 = 0;
        int nrof10 = 0;
        for (const auto& x : bills) {
            if (x == 5) {
                nrof5++;
            } 
            else if (x == 10) {
                if (nrof5 == 0) return false;
                nrof5--;
                nrof10++;
            } 
            else { 
                if (nrof10 > 0 && nrof5 > 0) {
                    nrof10--;
                    nrof5--;
                } 
                else if (nrof5 >= 3) {
                    nrof5 -= 3;
                } 
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
};