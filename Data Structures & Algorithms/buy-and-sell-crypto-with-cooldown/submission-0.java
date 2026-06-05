class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        // Inițializarea stărilor pentru prima zi (index 0)
        int hold = -prices[0]; // Cumpărăm acțiunea în prima zi
        int sold = 0;          // Nu putem avea profit din vânzare în prima zi
        int rest = 0;          // Starea inițială de repaus
        
        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;
            
            // Aplicăm ecuațiile de recurență pentru ziua curentă
            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }
        
        // La final, profitul maxim va fi fie în starea 'sold' (tocmai am vândut),
        // fie în starea 'rest' (suntem în cooldown sau am stat degeaba).
        return Math.max(sold, rest);
    }
}
