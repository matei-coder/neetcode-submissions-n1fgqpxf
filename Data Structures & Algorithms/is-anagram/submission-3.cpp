class Solution {
public:
    bool isAnagram(string s, string t) {
        int freqS[26];
        int freqT[26];
        for(char c : s){
            freqS[c-'a']++;
        }
        for(char c : t){
            freqT[c-'a']++;
        }
        for(int i=0;i<26;i++){
            cout<<freqS[i]<<" "<<freqT[i]<<endl;
            if(freqS[i]!=freqT[i]) return false;
        }return true;

    }
};
