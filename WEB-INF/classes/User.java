public class User {
    public int id;
    public String accNo;
    public String name;
    public String password;
    public Double balance;
    public String phone;
    public String aadharNo;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accNo='" + accNo + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + password + '\'' +
                ", balance='" + balance + '\'' +
                ", phone='" + phone + '\'' +
                ", aadhar=" + aadharNo +
                '}';
    }
    public int getId(){
        return id;
    }
    public String getAccNo(){
        return accNo;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public Double getBalance(){
        return balance;
    }
    public String getPhone(){
        return phone;
    }
    public String getAadharNo(){
        return aadharNo;
    }

    public User(int id,String accNo,String name,String password,Double balance,String phone,String aadharNo) {
        this.id=id;
        this.accNo=accNo;
        this.name=name;
        this.password=password;
        this.balance = balance;
        this.phone = phone;
        this.aadharNo = aadharNo;
    }
}