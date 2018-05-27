package javadz.DZ5;

class Account {

    private Integer balance = null;
    private final Integer cardNumber;
    private final Integer pin;

    public Account(Integer cardNumber, Integer pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    private Integer getBallance() {
        return this.balance;
    }

    private void setBallance(Integer amount) {
        this.balance = amount;
    }

    private String getPinHash() {
        return this.cardNumber.toString() + this.pin.toString();
    }

}
