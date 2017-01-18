package bookstore;

public class User {
    private static int id=1;
    private String name,surname,psswd;
    private double wallet;

    public User(String _name, String _psswd){
        this.name=_name;
        this.wallet=0;
        this.psswd=_psswd;
        this.id+=1;
    }

    public void upgradeWallet(String amount){
        double amount_d=Double.parseDouble(amount);
        this.wallet=amount_d;
    }

    public double getMoney(){
        return this.wallet;
    }
}
