class Solution {
public:

    string encode(vector<string>& strs) {
        string ans = "";
        for(string s : strs){
            ans += s;
            ans += "§";
        }

        return ans;
    }

    vector<string> decode(string s) {
        string delimiter = "§";
        vector <string> ans ;
        int n = s.size();
        int last =0;
        for(int i=0;i<n;i++){
            if(s.compare(i, delimiter.size(), delimiter) == 0){
                ans.push_back(s.substr(last , i-last));
                last = i+2;
            }
        }

        return ans;
    }
};
