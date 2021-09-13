package question1;

import java.io.*;

public class Knapsack {
	
	public static int knapsack(int[] price, int[] weights, int item, int weight)
	{
		if (item <= 0 || weight <= 0) {
	        return 0;
	    }

	    int[][] dp = new int[item + 1][weight + 1];
	    for (int i = 0; i <= weight; i++) 
	    {
	        dp[0][i] = 0;
	    }
	    
	    for (int i = 0; i <= item; i++)
	    {
	    	dp[i][0] = 0;
	    }
	    
	    for (int i = 1; i <= item; i++) 
	    {
	        for (int j = 1; j <= weight; j++) 
	        { 
	            if (weights[i - 1] > j) 
	            {
	                dp[i][j] = dp[i - 1][j];
	            } else 
	            {
	                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + price[i - 1]);
	            }
	        }
	    }
	    return dp[item][weight];
	}
	
	public static void main (String[] args)
	{
		int[] price_list = new int[20];
		int[] weight_list = new int[20];
		int count = 0;
		
		try {
			File f = new File("knapsack.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String readLine = br.readLine();
			readLine = br.readLine();
            while(readLine != null && !readLine.equals("") )
            {
            	String splitLine[] = readLine.split(", ");
            	if(splitLine.length != 3){
                    System.out.println("The file format is incorrect "+splitLine.length);
                    readLine = null;
                } else
                {
                	try {
                		int weight = Integer.parseInt(splitLine[1]);
                		String pr = splitLine[2];
                		int price = Integer.parseInt(pr.substring(1)); //taking the number without the dollar sign
                		price_list[count] = price;
                		weight_list[count] = weight;
                		count++;
                		readLine = br.readLine();
                	} catch(NumberFormatException e) {
                		System.out.println("Number format exception found.");
                	}
                }
            }
            int p = knapsack(price_list, weight_list, count, 600);
			System.out.println(p);
		}catch(FileNotFoundException e)
		{
			System.out.println("The file is not found.");
		}catch(IOException e)
		{
			System.out.println("An unkown error occured.");
		}
	}

}
