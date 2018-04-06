package QuestionPacket;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 多重背包问题，即某个商品的数量不确定有多少个
 * @author andan
 *
 */
public class MultiplePack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		while (scanner.hasNext()) {
//			int num = scanner.nextInt();		//商品数量
////			int allMoney = scanner.nextInt();	//总钱数、总重量
//			int allMoney = 0;
//			int[] price = new int[num];
//			int[] values = new int[num];
//			int[] goodsNum = new int[num];
//			for (int i = 0; i < num; i++) {
//				price[i] = scanner.nextInt();	//单个商品价格，重量
//				values[i] = 1;	//单个商品的价值
//				goodsNum[i] = scanner.nextInt();
//				allMoney = allMoney + goodsNum[i] * values[i];
//			}
//			getMax(price, values, num, allMoney);
			int[] price = {0,5,4,3,2,1};
			int[] values = {0,1,2,3,4,5};
			int[] goodsNum = {0,1,2,1,2,1};
			getMaxMultiplePack(price, values, price.length, goodsNum, 10);			
		}
	public static void getMaxMultiplePack(int[] price,int[] values,int num,int[] goodsNum,int allMoney) {
		int[] dp = new int[allMoney+1];
		int[][] path = new int[num][allMoney+1];
		for (int i = 1; i <= num-1; i++) {
			for (int k = 1; k <= goodsNum[i]; k++) {
				for (int j = allMoney; j >= price[i]; j--) {
					if (dp[j] < dp[j-price[i]]+values[i]) {
						dp[j] = dp[j-price[i]]+values[i];
						path[i][j] = 1;
					}
				}
			}
		}
		
		int i = num-1;
		int j = allMoney;
		while (i>0 && j>0) {
			if (path[i][j] == 1&&goodsNum[i]>0) {
				System.out.print(i+" ");
				j -= price[i];
				goodsNum[i]--;
			}else {
				i--;
			}
		}
		System.out.println();
		System.out.println(dp[dp.length-1]);
	}
}
