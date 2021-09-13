package question3;

public class Partition {
	
	public static int minPartition(int[] A)
    {
        int sum = 0;
        for(int i=0; i<A.length; i++)
        	sum += A[i];

        boolean dp[][] = new boolean[A.length + 1][sum + 1];
        
        for(int i=0; i <= A.length; i++)
        	dp[i][0] = true;
        
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        
        for (int i = 1; i <= A.length; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                dp[i][j] = dp[i - 1][j];
 
                if (A[i - 1] <= j) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - A[i - 1]];
                }
            }
        }

        int j = sum / 2;
        while (j >= 0 && !dp[A.length][j])
            j--;
        return sum - 2*j;
    }
	
	public static void main (String[] args)
    {
        int[] A = {1, 2, 3, 5, 13};
 
        System.out.println("The minimum difference is " + minPartition(A));
    }

}
