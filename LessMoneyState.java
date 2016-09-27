

public class LessMoneyState implements State {
    GumballMachine gumballMachine;
 
    public LessMoneyState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setTotalInsertedMoney(gumballMachine.getTotalInsertedMoney()+25);
        checkforEnoughMoney();
    }
    
    public void insertDime(){
        System.out.println("You have Inserted Dime");
        gumballMachine.setTotalInsertedMoney(gumballMachine.getTotalInsertedMoney()+10);
         checkforEnoughMoney();
    }
    
    public void insertNickle(){
        System.out.println("You have Inserted Nickle");
        gumballMachine.setTotalInsertedMoney(gumballMachine.getTotalInsertedMoney()+5);
        checkforEnoughMoney();
    }
    
    public void checkforEnoughMoney(){
        if(gumballMachine.getTotalInsertedMoney() >=50){
            gumballMachine.setState(gumballMachine.getEnoughMoneyState());
        }
    }
 
    public void ejectMoney() {
        if(gumballMachine.getTotalInsertedMoney() >0){
            System.out.println(gumballMachine.getTotalInsertedMoney() + " Money has been ejected");
            gumballMachine.setTotalInsertedMoney(0);
         }
         else{
            System.out.println("You haven't inserted any Money");
        }
    }
 
    public void turnCrank() {
        System.out.println("You turned, but dont have enough money , Need to pay " + (50 -gumballMachine.getTotalInsertedMoney()) +" more money" );
     }
 
    public void takeGumballFromSlot() {
        System.out.println("You need to pay "+ (50 -gumballMachine.getTotalInsertedMoney()) + "first");
    } 
 
    public String toString() {
        return "Waiting for Money";
    }
}
