class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // Pointer pentru 'word'
        int j = 0; // Pointer pentru 'abbr'
        
        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            
            // Verificăm dacă este o literă
            if (!isNumber(c)) {
                if (word.charAt(i) != c) {
                    return false; // Literele nu se potrivesc
                }
                i++;
                j++;
            } 
            // Dacă este cifră
            else {
                // Un număr valid nu poate începe cu '0'
                if (c == '0') {
                    return false;
                }
                
                int steps = 0;
                // Parsăm tot numărul, având grijă să nu ieșim din limitele lui 'abbr'
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    steps = steps * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                
                // Avansăm pointerul i cu numărul calculat
                i += steps;
            }
        }
        
        // Ambele string-uri trebuie să fie parcurse complet în același timp
        return i == word.length() && j == abbr.length();
    }
    public boolean isNumber(char c){
        if(c-'0'>=0&&c-'9'<=0) return true;
        return false;
    }
}