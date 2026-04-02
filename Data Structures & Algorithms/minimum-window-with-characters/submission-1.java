class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        Map<Character ,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char x = t.charAt(i);
            map.put(x , map.getOrDefault(x,0)+1);
        }
        Map<Character ,Integer> viz = new HashMap<>();
        int ibun=0,jbun=0;
        int mindist = 999999;
        int j=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                viz.put(c , viz.getOrDefault(c,0)+1);
            }
            while(contains(viz , map)){               
                if(mindist>i-j+1){
                    mindist=i-j+1;
                    ibun=i;
                    jbun=j;
                }
                char remove = s.charAt(j++);
                if (viz.containsKey(remove)) {
                    viz.put(remove, viz.get(remove) - 1);
                    if (viz.get(remove) == 0) viz.remove(remove);
                }
               
            }

            System.out.println(viz);

        }
        if (mindist == 999999) return ""; 
        return s.substring(jbun, ibun + 1);
    }
    private boolean contains(Map<Character,Integer> viz, Map<Character,Integer> map) {
    for (Map.Entry<Character,Integer> e : map.entrySet()) {
        if (viz.getOrDefault(e.getKey(), 0) < e.getValue()) return false;
    }
    return true;
}


}
