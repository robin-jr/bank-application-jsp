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