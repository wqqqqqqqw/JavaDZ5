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

    private void connect(Integer cardNumber) {
        if (!isAccountLocked(currAccountNumber)) {
            this.currAccountNumber = cardNumber;
            accessAccount();
        }
    }

    private boolean isAccountLocked(Integer cardNumber) {
        if (cardNumber != null) {
            if (this.currAccountNumber == cardNumber && this.blockTimer != null && isLocked) {
                return true;
            }
        }
        return false;
    }

    private Integer askUserPin() {
        //Введите пин
        //Чтение пин
        //Возврат пинхэш
        Integer pin = null;
        getPinHash(pin, currAccountNumber);
        Integer pinHash = null;
        return pinHash;
    }

    private int getPinHash(int pin, int cardNumber) {
        return 1;
    }

    private void accessAccount() {

        //Если failedAttempts < 2
        //Иначе Блокировка
        Integer pinHash = askUserPin();
        if (failedAttempts < 2) {
            try {
                pv.checkPin(pinHash);
            } catch (Exception e) { //IncorrectPinException
                ++failedAttempts;
                // println("Введен неправильный пин-код, повторите попытку");
            }
        } else {
            lockAccount();
        }
    }

    private boolean isDivisible(Integer amount, Integer by) {
        return amount % by == 0;
    }

    private void lockAccount() {
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

    private void giveOutCash() {
        ;
    }

    private void depositSuccessful() {
        ;
    }

    @Override
    public int checkBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deposit(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean withdraw(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
