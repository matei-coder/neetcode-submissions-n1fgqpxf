class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n = strs.size();
        int m = 1e9;
        for(int i=0;i<n;i++){
            m = min(m , (int)strs[i].size());
        }
        string s = "";
        for(int j=0;j<m;j++){
            bool ok = true;
            for(int i=1;i<n;i++){
                
                if(strs[i].substr(0 , j+1) != strs[0].substr(0 , j+1)) {
                    
                    ok = false;
                    break;
                    }
            }

            if(!ok) break;
            s = strs[0].substr(0 , j+1);
        }

        return s;
    }
};