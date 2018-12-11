package main.java.com.mindaugas;

// Kortu klase
public enum KortuVertes {
    DEVYNKE_C (0, KortuSpalva.CYRVAI),
    DEVYNKE_B (0, KortuSpalva.BUGNAI),
    DEVYNKE_K (0, KortuSpalva.KRYZIAI),
    DEVYNKE_P (0, KortuSpalva.PIKAI),
    DESIMTKE_C (10, KortuSpalva.CYRVAI),
    DESIMTKE_B (10, KortuSpalva.BUGNAI),
    DESIMTKE_K (10, KortuSpalva.KRYZIAI),
    DESIMTKE_P (10, KortuSpalva.PIKAI),
    BORTUKAS_C (2, KortuSpalva.CYRVAI),
    BORTUKAS_B (2, KortuSpalva.BUGNAI),
    BORTUKAS_K (2, KortuSpalva.KRYZIAI),
    BORTUKAS_P (2, KortuSpalva.PIKAI),
    DAMA_C (3, KortuSpalva.CYRVAI),
    DAMA_B (3, KortuSpalva.BUGNAI),
    DAMA_K (3, KortuSpalva.KRYZIAI),
    DAMA_P (3, KortuSpalva.PIKAI),
    KARALIUS_C (4, KortuSpalva.CYRVAI),
    KARALIUS_B (4, KortuSpalva.BUGNAI),
    KARALIUS_K (4, KortuSpalva.KRYZIAI),
    KARALIUS_P (4, KortuSpalva.PIKAI),
    TUZAS_C (11, KortuSpalva.CYRVAI),
    TUZAS_B (11, KortuSpalva.BUGNAI),
    TUZAS_K (11, KortuSpalva.KRYZIAI),
    TUZAS_P (11, KortuSpalva.PIKAI);

    private int verte;
    private KortuSpalva spalva;

    public KortuSpalva getSpalva() {
        return spalva;
    }


    KortuVertes(int verte, KortuSpalva spalva) {
        this.spalva = spalva;
        this.verte = verte;
    }


    public int getVerte() {
        return verte;
    }
    public void setVerte(int verte) {
        this.verte = verte;
    }
}
