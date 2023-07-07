class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int maxPro = 0, tmp = 0;
        for (int i = 1; i < prices.size(); ++i) {
            tmp = prices[i] - prices[i - 1];
            if (tmp > 0)
                maxPro += tmp;
        }
        return maxPro;
    }
};
