package Pracownik;

public class PracownikEtatowy extends Pracownik {

    public PracownikEtatowy(double wynagrodzenie){
        super(wynagrodzenie);
    }

    @Override
    public double wynagrodzenie_netto() {
        return 0;
    }
}
