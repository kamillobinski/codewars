public class Dinglemouse {

  public static int[] shakeTree(final char[][] tree) {
    int[] nuts = new int[tree[0].length];
        for(int i = 0, j = i; i < tree[0].length; i++, j = i) {
            if(tree[0][i] != 'o') {
                continue;
            }
            for(char[] chars : tree) {
                if(chars[j] == '_') {
                    // Nut will get stuck in the tree
                    j = -1;
                    break;
                } else if(chars[j] == '\\') {
                    // Nut will fall right;
                    j++;
                } else if(chars[j] == '/') {
                    // Nut will falll left
                    j--;
                } else if(chars[j] == '.' || chars[j] == '|' || chars[j] == '=') {
                    // Has no impact on falling nuts
                    continue;
                }
            }
            if(j >= 0) {
                nuts[j]++;
            }
        }
        return nuts;
    }
}