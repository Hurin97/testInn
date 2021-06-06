import java.math.BigDecimal;
import java.util.Date;

public class AccountingEntry {
    public Date dateOfTransactions;
    public String sendersAccount;
    public String recipientAccount;
    public BigDecimal summOperation;

    public AccountingEntry(Date dateOfTransactions, String sendersAccount, String recipientAccount, BigDecimal summOperation) {
        this.dateOfTransactions = dateOfTransactions;
        this.sendersAccount = sendersAccount;
        this.recipientAccount = recipientAccount;
        this.summOperation = summOperation;
    }

    public Date getDateOfTransactions() {
        return dateOfTransactions;
    }

    public void setDateOfTransactions(Date dateOfTransactions) {
        this.dateOfTransactions = dateOfTransactions;
    }

    public String getSendersAccount() {
        return sendersAccount;
    }

    public void setSendersAccount(String sendersAccount) {
        this.sendersAccount = sendersAccount;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public BigDecimal getSummOperation() {
        return summOperation;
    }

    public void setSummOperation(BigDecimal summOperation) {
        this.summOperation = summOperation;
    }
}
