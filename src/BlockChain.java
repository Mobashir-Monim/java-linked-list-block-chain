import java.util.Scanner;
import blockchain.Chain;

public class BlockChain {
    public static Scanner sc = new Scanner(System.in);
    public static Chain chain = new Chain();
    
    public static void main(String[] args) {
        System.out.println("Genesis Block Created");
        chain.print();

        while (true) {
            addTransaction();
            chain.print();
        }
    }

    public static void addTransaction () {
        System.out.println("Please enter transaction data: ");
        chain.addBlock(sc.nextLine());
    }
}