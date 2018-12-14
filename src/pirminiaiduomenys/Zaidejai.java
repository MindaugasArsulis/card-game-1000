package pirminiaiduomenys;

public class Zaidejai extends Dalintojas {
    private String name;
    private int power;
    private int bet;

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getPower() {
        return power;
    }

}
