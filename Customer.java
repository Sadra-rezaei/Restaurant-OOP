public class Customer {
    private String name;
//    private String cellphone;
    private int wallet;
    private int bill;
    private int group;
    private int sitNumber;
    private Table table;

    public Customer(String name, int group, int money){
        this.name = name;
        this.group = group;
        this.wallet = money;
        this.bill = 0;
        this.sitNumber = 0;
    }

    public String getNameCustomer(){
        return this.name;
    }

    public int getGroupOfCustomer(){
        return this.group;
    }

    public int  getSitNumber(){
        return this.sitNumber;
    }

    public void setSitNumber(int sitNumber){
        this.sitNumber = sitNumber;
    }

    public int getBill(){
        return this.bill;
    }

    public void setBill(int cost){
        if (cost == 0){
            this.bill = 0;
        }
        this.bill = this.bill + cost;
    }

    public int getWallet(){
        return this.wallet;
    }

    public void setWallet(int cost){
        this.wallet = this.wallet - cost;
    }

    public Table getTable(){
        return this.table;
    }

    public void setTable(Table table){
        this.table = table;
    }

}
