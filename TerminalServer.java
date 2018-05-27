
package javadz.DZ5;

import java.util.HashMap;

class TerminalServer implements ITerminal{
    HashMap<Integer, Account> accounts = null;
    //Integer pinHash = null;
     
//    private void accessAccount(int request, int pinHash) {
//        ;
//    }
    
    protected void checkPin(Integer pinHash) {
        ;
    }
    
//    private Account getAccount(Integer pinHash) {
//        return new Account();
//    }

    @Override
    public int checkBalance() //throws NoConnection
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deposit(int amount) //throws NoConnection
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean withdraw(int amount) //throws NoConnection, InsufficientFundsException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
