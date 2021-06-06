import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.mm.yyyy");
        simpleDateFormat.setLenient(false);
        Account a1cl1=new Account("00055500",new BigDecimal("345.00"));
        Account a2cl1=new Account("00055501",new BigDecimal("345.00"));
        Client cl1=new Client("Carl","cxl1", List.of(a1cl1,a2cl1));
        Account a1cl2=new Account("00055591",new BigDecimal("345.00"));
        Client cl2=new Client("John","cxl2", List.of(a1cl2));

        Bank b1=new Bank("b1",List.of(cl1,cl2),List.of(a1cl1,a1cl2,a1cl2),List.of(new AccountingEntry(simpleDateFormat.parse("12.4.2021"),"00055500","00055591",new BigDecimal("350.00")),
                new AccountingEntry(simpleDateFormat.parse("13.4.2021"),"00055591","00055500",new BigDecimal("450.00"))));


        BigDecimal res1=b1.sumOpForClient("cxl1",simpleDateFormat.parse("13.4.2021"));
        System.out.println(res1);


        String res2=cl1.accountStatement("00055500",b1);
        System.out.println(res2);
    }
}
