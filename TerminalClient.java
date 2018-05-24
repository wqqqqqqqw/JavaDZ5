package javadz.DZ5;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

public class TerminalClient implements ITerminal {

    private PinValidator pv = null;
    private TerminalServer ts = null;

    private Integer currAccountNumber = null;
    private Timer blockTimer = null;
    private Integer failedAttempts = null;
    private boolean isLocked = false;

    private void Connect(Integer cardNumber) {
        if (!IsAccountLocked(currAccountNumber)) {
            this.currAccountNumber = cardNumber;
            AccessAccount();
        }
    }

    private boolean IsAccountLocked(Integer cardNumber) {
        if (cardNumber != null) {
            if (this.currAccountNumber == cardNumber && this.blockTimer != null && isLocked) {
                return true;
            }
        }
        return false;
    }

    private Integer AskUserPin() {
        //Введите пин
        //Чтение пин
        //Возврат пинхэш
        Integer pin = null;
        GetPinHash(pin, currAccountNumber);
        Integer pinHash = null;
        return pinHash;
    }

    private int GetPinHash(int pin, int cardNumber) {
        return 1;
    }

    private void AccessAccount() {

        //Если failedAttempts < 2
        //Иначе Блокировка
        Integer pinHash = AskUserPin();
        if (failedAttempts < 2) {
            try {
                pv.CheckPin(pinHash);
            } catch (Exception e) { //IncorrectPinException
                ++failedAttempts;
                // println("Введен неправильный пин-код, повторите попытку");
            }
        } else {
            LockAccount();
        }
    }

    private boolean IsDivisible(Integer amount, Integer by) {
        return amount % by == 0;
    }

    private void LockAccount() {
        //blockTimer = new Timer(Long.parseLong((new Date().getTime() + 5000)));
        isLocked = true;

        blockTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(() -> {
                    failedAttempts = 0;
                    isLocked = false;
                    //blockTimer = null;
                });
            }
        }, 5000);
    }

    private void GiveOutCash() {
        ;
    }

    private void DepositSuccessful() {
        ;
    }

    @Override
    public int CheckBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Deposit(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Withdraw(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
