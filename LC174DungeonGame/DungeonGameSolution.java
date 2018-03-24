class DungeonGameSolution {
  /*
  use DP to find the smallest negative number of each route
  use Math.max to find the max of them
  abs of the number + 1 is the result
  */
  public static int calculateMinimumHP(int[][] dungeon) {
    //corner case
    if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

    int m = dungeon.length;
    int n = dungeon[0].length;
    int[][] health = new int[m][n];
    //initialization
    health[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
    for(int i = m - 2; i >= 0; i--) {
      health[i][n - 1] = Math.max(1, health[i + 1][n - 1] - dungeon[i][n - 1]);
    }
    for(int i = n - 2; i >= 0; i--) {
      health[m - 1][i] = Math.max(1, health[m - 1][i + 1] - dungeon[m - 1][i]);
    }

    //dp main function
    for(int i = m - 2; i >= 0; i--) {
      for(int j = n - 2; j >= 0; j--) {
        int down = Math.max(1, health[i + 1][j] - dungeon[i][j]);
        int right = Math.max(1, health[i][j + 1] - dungeon[i][j]);
        health[i][j] = Math.min(down, right);
      }
    }

    return health[0][0];
  }

  public static void main(String[] args) {
    int[][] test = {{-2, -3, 3, 3}, {-5, -10, 1, 10}, {10, 30, -5, 2}};
    System.out.println(calculateMinimumHP(test));
  }
}
