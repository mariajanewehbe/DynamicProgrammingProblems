package question2;

public class Subsequence {
	
	    public static int findMaxSumSubsequence(int[] array, boolean[] included)
	    {
	        int n = array.length;

	        if (n == 1) {
	        	included[0] = true;
	            return array[0];
	        }
	 
	        int[] dp = new int[n];

	        dp[0] = array[0];
	        dp[1] = Math.max(array[0], array[1]);
	        
	        if(array[0] > array[1])
	        {
	        	included[0] = true;
	        	included[1] = false;
	        }
	        else
	        {
	        	included[0] = false;
	        	included[1] = true;
	        }
	 
	        for (int i = 2; i < n; i++)
	        {
	        	if(dp[i - 1] > dp[i - 2] + array[i])
	        		included[i] = false;
	        	else
	        		included[i] = true;
	        	
		            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + array[i]); 
	        }  
	        return dp[n - 1];
	    }
	 
	    public static void main(String[] args)
	    {
	        int[] array = {1, 2, 1, 9, 4, 5, 0, 4, 10, 1};
	        boolean[] included = new boolean[array.length];
	        System.out.println("The maximum sum is " + findMaxSumSubsequence(array, included));

	        System.out.print("The mmaximum sum subsequence is: ");
	        for(int i=included.length-1; i>=0; i--)
	        {
	        	if(included[i] == true)
	        	{
	        		System.out.print(array[i] + " ");
	        		i--;	        		
	        	}
	        }
	    }
}
