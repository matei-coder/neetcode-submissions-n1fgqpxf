public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder(); // fix 1: capital B
        dfs(root, st);
        return st.toString();
    }

    public void dfs(TreeNode root, StringBuilder st) {
        if (root == null) {
            st.append("N,"); // fix 2: append() not add(), add delimiter
            return;
        } else {
            st.append(root.val + ","); // fix 2: append() not add(), add delimiter
            dfs(root.left, st);  
            dfs(root.right, st); // fix 3: pass st argument
        }
    }

    int i = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(","); // fix 4: split into tokens first
        return decode(tokens);            // fix 5: call decode() not dfs()
    }

    public TreeNode decode(String[] tokens) { // fix 6: correct signature + return type
        if (i >= tokens.length || tokens[i].equals("N")) { // fix 7: correct null check
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tokens[i++])); // fix 8: parse int, increment i
        node.left = decode(tokens);  // fix 9: recursive calls in sequence
        node.right = decode(tokens);
        return node;
    }
}