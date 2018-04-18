//Practice two types of DP 
//Recursive and Iterative
class CoinChange {
    //Recursive 
    public static int CoinChangeRecursiveSolution(int [] coins, int amount) {
        if(amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }
    private static int helper(int[] coins, int remains, int[] count) {
        //stop condition
        if(remains == 0) return 0; //completed
        if(remains < 0) return -1; //not valid
        if(count[remains - 1] != 0) return count[remains - 1]; //already computed

        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int res = helper(coins, remains - coin, count);
            if(res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[remains - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remains - 1];
    }

    //Iterative
    public static int CoinChangeIterativeSolution(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] count = new int[amount + 1];
        int sum = 0;
        while(++sum <= amount) {
            int min =- 1;
            for(int coin: coins) {
                if(sum - coin >= 0 && count[sum - coin] != -1) {
                    int temp = count[sum - coin] + 1;
                    min = (min < 0) ? temp : (temp < min ? temp : min);
                }
            }
            count[sum] = min;
        }
        return count[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(CoinChangeRecursiveSolution(coins, amount));
        System.out.println(CoinChangeIterativeSolution(coins, amount));
    }
}