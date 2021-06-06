import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleFunc {
    public SimpleFunc() {
    }
    // 1.	Есть список занятых ip адресов в определенном диапазоне.
    // Необходимо возвратить список свободных ip-адресов в этом диапазоне
    public List<InetAddress> getFreeIPv4Address (List<InetAddress> inetAddresses,String leftBorder,String rightBorder ) throws UnknownHostException {
        if(inetAddresses==null) {
            throw new NullPointerException("Список занятых IP пустой");
        }
        if(leftBorder.equals("")){
            throw new NullPointerException("Нет левой границы диапазона");
        }
        if(rightBorder.equals("")){
            throw new NullPointerException("Нет правой границы диапазона");
        }
        int leftBorder_=ByteBuffer.wrap(Inet4Address.getByName(leftBorder).getAddress()).getInt();
        int rightBorder_=ByteBuffer.wrap(Inet4Address.getByName(rightBorder).getAddress()).getInt();
        List<InetAddress> freeIP = Stream.iterate(leftBorder_,ip->ip<rightBorder_,ip->ip+1)
                .map(ip-> {
                    try {
                        return Inet4Address.getByName(String.valueOf(ip));
                    } catch (UnknownHostException e) {
                        throw new RuntimeException("Convert failed",e);
                    }
                })
                .filter(ip->!inetAddresses.contains(ip))
                .collect(Collectors.toList());
        return freeIP;
    }
    //2.Написать функцию, которая принимает на вход строку и возвращает наиболее часто встречающееся в этой строке слово
    public String mostCommonNWord (String str) {
        if(str==null) {
            throw new NullPointerException("Слов нет");
        }
        String word=Arrays.asList(str.replaceAll("\\W+",",").split(","))
                .stream()
                .filter(d->!d.equals(""))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();;
        return word;
    }
    //3.Написать функцию, которая принимает на вход строку и формат даты, и возвращает список найденных дат в заданной строке, соответствующих заданному формату
    public List<Date> correctDate (String strWithDate,String format) {
        if(strWithDate==null) {
            throw new NullPointerException("Нет дат");
        }
        if(format==null) {
            throw new NullPointerException("Нет формата");
        }
        String delim=format.replaceAll("\\w","");
        StringBuilder regex=new StringBuilder();
        SimpleDateFormat sDF= new SimpleDateFormat(format);
        if (delim.charAt(0)==format.charAt(2) || delim.charAt(0)==format.charAt(1)) {
             regex.append("\\d{1,2}"+delim.charAt(0)+"\\d{1,2}"+delim.charAt(0)+"\\d{4}");
        } else {
            regex.append("\\b\\d{4}\\"+delim.charAt(0)+"\\d{1,2}\\"+delim.charAt(0)+"\\d{1,2}\\b");
        }
        List<Date> correctDate = Arrays.asList(strWithDate.replaceAll("[^"+regex +"]",",").split(","))
                .stream()
                .filter(d->!d.equals(""))
                .map(d->{
                    try {
                        return sDF.parse(d);
                    } catch (final ParseException e) {
                        throw new RuntimeException("Parse failed", e);
                    }
                })
                .collect(Collectors.toList());
        return correctDate;
    }
    //4.Написать функцию, которая принимает на вход строку, и возвращает сумму всех найденных в этой строке чисел
    public int sum (String strNumb) {
        if(strNumb==null) {
            throw new NullPointerException("Строка пустая");
        }
        int sum=Arrays.asList(strNumb.replaceAll("\\D+",",").split(","))
                .stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return sum;
    }
    //5.Данные хранятся в структуре в виде дерева. Напишите метод, подсчитывающий количество «листьев» (конечных элементов) в дереве
    public int countLeafOfTree (Tree someTree) {
        return someTree.countLeaf(someTree.getRoot());
    }

}
