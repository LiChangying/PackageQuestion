package QuestionPacket;
/**
 * 每种物品有无限件,并非只取1件或者不取
 * @author andan
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
 
//完全背包问题
//特点是：每种物品无数件
public class Packet02 {
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
		int[] price = {77,22,29,12,50,99};
		int[] values = {92,22,87,12,46,90};
		getMaxComplete(price, values, price.length, 100);
	}
	public static void getMaxComplete(int[] price,int[] values,int num,int allMoney) {
		int[] dp = new int[allMoney+1];
		int[][] path = new int[num+1][allMoney+1];
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[i].length; j++) {
				path[i][j] = 0;
			}
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 0;
		}
		for (int i = 0; i < values.length; i++) {
			for (int j = price[i]; j < dp.length; j++) {
//					dp[j] = Math.max(dp[j], dp[j-price[i]]+values[i]);
				if (dp[j] < dp[j-price[i]]+values[i]) {
					dp[j] = dp[j-price[i]]+values[i];
					path[i][j] = 1;
				}
			}
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
			}else
			i--;
		}
		Collections.sort(list);
		//输出背包路径
		for (int k = 0; k < list.size(); k++) {
			System.out.print(list.get(k)+" ");
		}
		//可以考虑增加一段程序用于实现每种商品的数量输出
		System.out.println();
		int[] arr = new int[list.size()];
		for (int k = 0; k < arr.length; k++) {
			arr[k] = list.get(k);
		}
		countSameNumber3(arr);
		System.out.println(dp[allMoney]);
	}
	public static void countSameNumber1(int[] number){  
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();  
        for(int i =0;i < number.length;i++){  
            if(!hm.containsKey(number[i])){  
                hm.put(number[i],1);  
            }  
            else{  
                hm.put(number[i],(hm.get(number[i]))+1);  
            }  
        }  
        for(Entry<Integer, Integer> entry:hm.entrySet()){  
            System.out.println(entry.getKey() + "出现了" + entry.getValue() + "次");  
        }  
    }
	public static void countSameNumber2(int[] number){  
        Arrays.sort(number);  
        //若数组内为1 2 3 4 1 2 ,则创建一个大小为5的数组，下标为0-4.  
        int[] numbers = new int[number[number.length -1] + 1];  
        for(int i =0;i< numbers.length;i++){  
            numbers[i] = 0;  
        }  
        //i即为原数组中数字，numbers[i]存放重复的次数  
        for(int i =0; i<number.length;i++){  
            int temp = number[i];  
            numbers[temp]++;  
        }  
        //打印  
        for(int i =0;i < numbers.length;i++){  
            if(numbers[i] == 0){  
                continue;  
            }  
            System.out.println(i + "出现了" + numbers[i] + "次");  
        }  
    }
	public static void countSameNumber3(int[] number){  
	       ArrayList<Integer> al = new ArrayList<Integer>();  
	       ArrayList<Integer> all = new ArrayList<Integer>();  
	       for(int i =0;i<number.length;i++){  
	           if(!al.contains(number[i])){  
	               al.add(number[i]);  
	           }  
	       }  
	       for(int i=0;i<number.length;i++){  
	           all.add(number[i]);  
	       }  
	       for(int i=0;i<al.size();i++){  
	           int result = Collections.frequency(all,al.get(i));  
	           System.out.println(al.get(i) + "出现了" + result + "次");  
	       }  
	   } 
}

