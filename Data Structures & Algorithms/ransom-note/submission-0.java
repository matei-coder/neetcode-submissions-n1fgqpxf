class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       int[] arr1 = new int[26];
       for(char c: magazine.toCharArray()){
            arr1[c -'a']++;
       }

       for(char c: ransomNote.toCharArray()){
            if(arr1[c-'a']==0) return false;
            else{
                arr1[c-'a']--;
            }
       }

       return true;

    }
}