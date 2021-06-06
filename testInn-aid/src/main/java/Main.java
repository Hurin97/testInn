import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;

public class Main {



    public static void main(String[] args)   {
        SimpleFunc sF= new SimpleFunc();

        try {
            InetAddress ip4=Inet4Address.getByName("8.8.8.8");
            byte[] ipp4 = ip4.getAddress();
            System.out.println(ipp4[2]);

            int leftBorder_=ByteBuffer.wrap(Inet4Address.getByName("8.8.8.8").getAddress()).getInt();
            InetAddress ipp=Inet4Address.getByName(String.valueOf(leftBorder_));

            System.out.println(ipp);
            System.out.println(String.valueOf(leftBorder_));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }



        String res2=sF.mostCommonNWord("Krya krkrkrk krkr krya, hre. Hree / Gr Krya");
        System.out.println(res2);
        List<Date> res3= sF.correctDate("Невская битва произошла 12.07.1240 года на реке Неве 6.6.2021","DD.MM.YYYY");
        res3.stream().forEach(b->
        {
            System.out.println(b.toString());
        });
        int res4=sF.sum("2 4 5 6 12 423 232 123 231 123");
        System.out.println(res4);


        Tree tr=createTestTree();

        int res5=sF.countLeafOfTree(tr);

        System.out.println(res5);

        System.out.println("wtf");


    }

    private static Tree createTestTree() {
        Tree tree=new Tree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.add(126);
        tree.add(124);
        tree.add(128);
        tree.add(123);
        tree.add(125);
        tree.add(127);
        tree.add(129);
        tree.add(1292);
        return tree;
    }
}
