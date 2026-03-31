class Solution {
    public int trap(int[] height) {
        int i = 0;
        int n = height.length;
        int s = 0;

        while (i < n - 1) {
            int stalpstart = height[i];
            int j = i + 1;

            // Cauta primul perete >= stalpstart
            while (j < n - 1 && height[j] < stalpstart) {
                j++;
            }

            if (height[j] < stalpstart) {
                // NU am gasit perete destul de inalt → gasim maximul din dreapta
                int maxPos = i + 1;
                for (int k = i + 2; k < n; k++) {
                    if (height[k] > height[maxPos]) maxPos = k;
                }
                int nivel = height[maxPos];
                // Umplem doar pana la maxPos (nu si dincolo)
                for (int k = i + 1; k < maxPos; k++) {
                    s += Math.max(0, nivel - height[k]);
                }
                i = maxPos; // continuam de la peretele maxim gasit
            } else {
                // Am gasit un perete >= stalpstart la j → logica ta originala
                while (i < j) {
                    s += Math.max(0, stalpstart - height[i]);
                    i++;
                }
            }
        }
        return s;
    }
}