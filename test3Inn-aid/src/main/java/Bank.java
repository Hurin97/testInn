import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bank {
    public String name;
    public List<Client> clients;
    public List<Account> accounts;
    public List<AccountingEntry> accountingEntries;


    public BigDecimal sumOpForClient(String codeClient, Date date) {
        if (codeClient.equals("")){
            throw new NullPointerException("Отсутствует код клиента");
        }
        if (date==null) {
            throw new NullPointerException("Отсутствует дата");
        }
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        BigDecimal sum= clients.stream()
                .filter(client -> client.getCode().equals(codeClient))
                .findFirst()
                .get()
                .getAccounts()
                .stream()
                .map(account -> accountingEntries.stream()
                        .filter(accountingEntry -> accountingEntry.getRecipientAccount().equals(account.getAccountNumber()))
                        .filter(accountingEntry -> dateFormat.format(accountingEntry.getDateOfTransactions()).equals(dateFormat.format(date)))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .map(AccountingEntry::getSummOperation)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<AccountingEntry> getAccountingEntries() {
        return accountingEntries;
    }

    public void setAccountingEntries(List<AccountingEntry> accountingEntries) {
        this.accountingEntries = accountingEntries;
    }

    public Bank(String name, List<Client> clients, List<Account> accounts, List<AccountingEntry> accountingEntries) {
        this.name = name;
        this.clients = clients;
        this.accounts = accounts;
        this.accountingEntries = accountingEntries;
    }
}
