
package javadz.DZ5;

import java.util.HashMap;

class TerminalServer implements ITerminal{
    HashMap<Integer, Account> accounts = null;
    //Integer pinHash = null;
     
//    private void AccessAccount(int request, int pinHash) {
//        ;
//    }
    
    protected void CheckPin(Integer pinHash) {
        ;
    }
    
//    private Account GetAccount(Integer pinHash) {
//        return new Account();
//    }

    @Override
    public int CheckBalance() //throws NoConnection
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Deposit(int amount) //throws NoConnection
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Withdraw(int amount) //throws NoConnection, InsufficientFundsException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
