package QuestionPacket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
	
//特点是：每种物品仅有一件，可以选择放或不放
public class PacketZero_One {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt();		//商品数量
//		int allMoney = scanner.nextInt();	//总钱数、总重量
//		int[] price = new int[num];
//		int[] values = new int[num];
//		for (int i = 0; i < num; i++) {
//			price[i] = scanner.nextInt();	//单个商品价格，重量
//			values[i] = scanner.nextInt();	//单个商品的价值
//		}
//		getMax(price, values, num, allMoney);
		int[] price = {77,22,29,50,99};
		int[] values = {92,22,87,46,90};
		getMaxZeroOnePack(price, values, price.length, 100);
	}
	public static void getMaxZeroOnePack(int[] price,int[] values,int num,int allMoney) {
//		int max=0;
//		int[][] dp = new int[num+1][allMoney+1];//f[i][j]代表前i个物品装入容量为j的背包中的最大价值
//		int[][] path = new int[num+1][allMoney+1];//背包中的物品顺序
//		for (int i = 0; i < num+1; i++) {
//			dp[i][0] = 0;
//		}
//		for(int i = 0;i < allMoney + 1;i++){
//			dp[0][i] = 0;
//		}
//		for (int i = 1; i < dp.length; i++) {
//			for (int j = 1; j < dp[i].length; j++) {//为什么是dp[0],而不使dp[i]
//				if (price[i-1]>j) {
//					dp[i][j] = dp[i-1][j];
//				}else {
////					if (dp[i-1][j]<dp[i-1][j-price[i-1]]+values[i-1]) {
////						dp[i][j] = dp[i-1][j-price[i-1]]+values[i-1];
////						path[i][j] = 1;
////					}else{
////						dp[i][j] = dp[i-1][j];
////					}
//					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-price[i-1]]+values[i-1]);
//					if (dp[i-1][j]<dp[i-1][j-price[i-1]]+values[i-1]) {
//						path[i][j] = 1;
//					}
//				}
//			}
//		}
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++) {//为什么是dp[0],而不使dp[i]
//				if (dp[i][j]>max) {
//					max = dp[i][j];
//				}
//			}
//		}
//		System.out.println(max);
//		//path output
//		int i = dp.length - 1;
//		int j = dp[0].length - 1;
//		while (i>0 && j>0) {
//			if (path[i][j] == 1) {
//				System.out.print(i+" ");
//				j = j - price[i-1];
//			}
//			i--;
//		}
//-------------------无需装满&&必须装满---------------------------//		
		int[] dp = new int[allMoney+1];
		int[][] path = new int[num+1][allMoney+1];
		for (int i = 0; i < dp.length; i++) {//不必装满初始化为0
			dp[i] = 0;
		}
//		for (int i = 1; i < dp.length; i++) {//必须装满则dp[0]=0,dp[1,...,m]都初始化为无穷小
//			dp[i] = Integer.MIN_VALUE;
//		}
		for(int i=0;i<num;i++)
		   for(int j=allMoney;j>=price[i];j--)
//			   dp[j] = Math.max(dp[j], dp[j-price[i]]+values[i]);
		      if(dp[j]<dp[j-price[i]]+values[i]){
		    	  dp[j]=dp[j-price[i]]+values[i];
		    	  path[i][j] = 1;
		      }
		//path output
		int i = num;
		int j = allMoney;
		List<Integer> list = new ArrayList<Integer>();
		while (i>=0 && j>=0) {
			if (path[i][j] == 1) {
				list.add(i);
//				System.out.print(i+" ");
				j = j - price[i];
			}
			i--;
		}
		Collections.sort(list);
		//输出背包路径
		for (int k = 0; k < list.size(); k++) {
			System.out.print(list.get(k)+" ");
		}
		System.out.println();
		//输出最大价值
		System.out.println(dp[dp.length-1]);//或者遍历dp数组取最大值
	}
}
