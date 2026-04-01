class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;

        Map<Character , Integer> set1 = new HashMap<>();
        Map<Character , Integer> viz = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            set1.put(s1.charAt(i) , set1.getOrDefault(s1.charAt(i) , 0)+1);
            viz.put(s2.charAt(i) , viz.getOrDefault(s2.charAt(i) , 0)+1);

        }
        if(set1.equals(viz)) return true;

        
       
        for(int i=s1.length();i<s2.length();i++){
            if(set1.equals(viz)) return true;
            char c = s2.charAt(i);
            char remove = s2.charAt(i-s1.length());
            viz.put(c , viz.getOrDefault(c , 0)+1);
            viz.put(remove , viz.getOrDefault(remove , 0)-1);
            if(viz.get(remove)<=0) viz.remove(remove);
            for(char x: viz.keySet()){
                System.out.print(x+" ");
            }
            System.out.println("");
           
               
           

           if(set1.equals(viz)) return true;

        }
        return false;
    }
}
