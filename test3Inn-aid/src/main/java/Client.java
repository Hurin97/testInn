import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public String name;
    public String code;

    public List<Account> accounts;


    public String accountStatement(String accountNumber,Bank bank) {
        if(accountNumber.equals("")){
            throw new NullPointerException("Не передан номер счета");
        }
        if(!accounts.stream().anyMatch(account -> account.getAccountNumber().equals(accountNumber))){
            throw new IllegalArgumentException("Такого счета у клиента нет");
        }
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        StringBuilder sb=new StringBuilder();
        sb.append("Дата | Тип операции | Коресподентский счет | Сумма операции \n");
        bank.getAccountingEntries().stream()
                .filter(accountingEntry -> accountingEntry.getRecipientAccount().equals(accountNumber) || accountingEntry.getSendersAccount().equals(accountNumber))
                .forEach(accountingEntry -> {
                    if(accountingEntry.getRecipientAccount().equals(accountNumber)){
                        sb.append(dateFormat.format(accountingEntry.getDateOfTransactions())+"|Зачисление|"+accountingEntry.getSendersAccount()+"|"+accountingEntry.getSummOperation()+"\n");
                    } else {
                        sb.append(dateFormat.format(accountingEntry.getDateOfTransactions())+"|Списание|"+accountingEntry.getRecipientAccount()+"|"+accountingEntry.getSummOperation()+"\n");
                    }
                });

        return sb.toString();
    }

    public Client(String name, String code, List<Account> accounts) {
        this.name = name;
        this.code = code;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
