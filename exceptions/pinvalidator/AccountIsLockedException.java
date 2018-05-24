package javadz.DZ5.exceptions.pinvalidator;

public class AccountIsLockedException extends PinValidatorException {

    public AccountIsLockedException(String message) {
        super(message);
    }
}
