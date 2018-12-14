import pirminiaiduomenys.KortuVertes;
import veiksmai.OperacijosSuKortomis;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class GroupCards {

    private OperacijosSuKortomis operacijosSuKortomis;

    @Before
    public void init() {
        operacijosSuKortomis = new OperacijosSuKortomis();
    }

    @Test
    public void successCases0() {

        List<KortuVertes> pirmaVerte = new ArrayList<>();
        pirmaVerte.add(KortuVertes.DAMA_B);
        pirmaVerte.add(KortuVertes.DESIMTKE_P);
        pirmaVerte.add(KortuVertes.KARALIUS_C);
        pirmaVerte.add(KortuVertes.KARALIUS_P);
        pirmaVerte.add(KortuVertes.KARALIUS_K);
        pirmaVerte.add(KortuVertes.BORTUKAS_B);
        pirmaVerte.add(KortuVertes.DAMA_K);
        pirmaVerte.add(KortuVertes.DEVYNKE_B);
        pirmaVerte.add(KortuVertes.TUZAS_P);

        List<KortuVertes> antraVerte = new ArrayList<>();
        antraVerte.add(KortuVertes.KARALIUS_P);
        antraVerte.add(KortuVertes.DESIMTKE_P);
        antraVerte.add(KortuVertes.TUZAS_P);
        antraVerte.add(KortuVertes.DAMA_K);
        antraVerte.add(KortuVertes.KARALIUS_K);
        antraVerte.add(KortuVertes.DEVYNKE_B);
        antraVerte.add(KortuVertes.BORTUKAS_B);
        antraVerte.add(KortuVertes.DAMA_B);
        antraVerte.add(KortuVertes.KARALIUS_C);


        assertEquals((operacijosSuKortomis.grupuoti(pirmaVerte)), (antraVerte));

    }
}
