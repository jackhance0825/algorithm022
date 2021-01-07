class Solution {
    /**
    * greedy 贪心，优先找大面值10元，如果把5元都找零了，再有10元账单就无法处理了
    * Time Complexuty: O(n), n为账单长度
    * Space Complexuty: O(1)
    */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills) {
            if(bill == 5) {
                five++;
            } else if(bill == 10) {
                if(--five < 0) return false;
                ten++;
            } else {
                if(ten == 0 ? (five -= 3) < 0 : --ten < 0 || --five < 0) return false;
            }
        }
        return true;
    }
}