import java.sql.Timestamp;

public class Transaction {
    public int id;
    public String fromAccNo, toAccNo;
    public double amount;
    public Timestamp time;
    public String mode;

    public Transaction(int id, String recAcc, String sendAcc, double amount, Timestamp time, String mode) {
        this.id = id;
        this.fromAccNo = recAcc;
        this.toAccNo = sendAcc;
        this.amount = amount;
        this.time = time;
        this.mode = mode;
    }
    public int getId() {
        return id;
    }
    public String getFromAccNo() {
        return fromAccNo;
    }
    public String getToAccNo() {
        return toAccNo;
    }
    public Double getAmount() {
        return amount;
    }
    public Timestamp getTime() {
        return time;
    }
    public String getMode() {
        return mode;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", recAcc='" + fromAccNo + '\'' + ", sendAcc='" + toAccNo + '\''
                + ", amount=" + amount + ", mode=" + mode + ", time=" + time + '}';
    }
}