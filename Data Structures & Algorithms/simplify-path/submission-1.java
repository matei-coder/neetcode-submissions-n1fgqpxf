class Solution {
    public String simplifyPath(String path) {



        Stack<String> stack =new Stack<>();
        //stack.push('/');
        
        for (String part : path.split("/")){
            if(part.equals("")||part.equals(".")) continue;
            else if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(part);
            }
        } 

        StringBuilder sb =new StringBuilder();
        for(String dir:stack){
            sb.append("/").append(dir);
        }
        if(sb.toString().equals("")) return "/";
        return sb.toString();
    }
}