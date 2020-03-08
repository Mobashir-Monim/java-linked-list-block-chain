package tester;

import blockchain.Chain;
import java.util.Scanner;

public class Tester {
	public static Chain chain = new Chain();
	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many blocks do you want to make?");
		int testTimes = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < testTimes; i++) {
			chain.addBlock(RandomString.genString(200));
		}
		
		chain.print();
	}
}
