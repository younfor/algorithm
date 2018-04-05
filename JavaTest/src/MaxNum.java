import java.util.*;

/**
 * 题目描述
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * 输入描述:
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * 输出描述:
 * 每组数据输出一个表示最大的整数。
 */
public class MaxNum
{
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < num; i++) {
                list.add(scan.nextInt());
            }

            Collections.sort(list, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    String a1 = String.valueOf(o1);
                    String a2 = String.valueOf(o2);
                    return (a2 + a1).compareTo(a1 + a2);
                }
            });

            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}