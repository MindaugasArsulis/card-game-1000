import org.junit.Before;
import org.junit.Test;
import com.mindaugas.cardgame1000.veiksmai.Logika1Zaidejas;

public class LogicTest2 {

    private Logika1Zaidejas zaidimoLogika;

    @Before
    public void init() {
        zaidimoLogika = new Logika1Zaidejas();
    }

    @Test
    public void successCases1() {
////
//        List<KortuVertes> stikline = new ArrayList<>();
//        stikline.add(KortuVertes.DAMA_B);
//        stikline.add(KortuVertes.KARALIUS_B);
//        stikline.add(KortuVertes.KARALIUS_P);
//        stikline.add(KortuVertes.KARALIUS_K);
//        stikline.add(KortuVertes.DAMA_K);
//        stikline.add(KortuVertes.DEVYNKE_B);
//
//        List<KortuVertes> stikline1 = new ArrayList<>();
//        stikline1.add(KortuVertes.DESIMTKE_B);
//        stikline1.add(KortuVertes.TUZAS_C);
//        stikline1.add(KortuVertes.BORTUKAS_K);
//        stikline1.add(KortuVertes.DESIMTKE_P);
//        stikline1.add(KortuVertes.DEVYNKE_K);
//        stikline1.add(KortuVertes.KARALIUS_C);
//
//
//        int[] reiksme = new int[3];
//        reiksme[0] = 80;
//        reiksme[1] = 14;
//        reiksme[2] = 1;
//        assertArrayEquals((zaidimoLogika.formuleKortai2("vardas", "kitasvardas", stikline, stikline1, 2, 1)), (reiksme));
//
//        reiksme[0] = 0;
//        reiksme[1] = 13;
//        reiksme[2] = 1;
//        assertArrayEquals((zaidimoLogika.formuleKortai2("vardas", "kitasvardas", stikline, stikline1, 1, 1)), (reiksme));
//
//        reiksme[0] = 0;
//        reiksme[1] = 14;
//        reiksme[2] = 1;
//        assertArrayEquals((zaidimoLogika.formuleKortai2("vardas", "kitasvardas", stikline, stikline1, 3, 4)), (reiksme));
//
//        reiksme[0] = 14;
//        reiksme[1] = 0;
//        reiksme[2] = 2;
//        assertArrayEquals((zaidimoLogika.formuleKortai2("vardas", "kitasvardas", stikline1, stikline, 2, 1)), (reiksme));
//
//        reiksme[0] = 64;
//        reiksme[1] = 0;
//        reiksme[2] = 2;
//        assertArrayEquals((zaidimoLogika.formuleKortai2("vardas", "kitasvardas", stikline, stikline1, 4, 5)), (reiksme));
//
//        reiksme[0] = 4;
//        reiksme[1] = 0;
//        reiksme[2] = 2;
//        assertArrayEquals((zaidimoLogika.formuleKortai2("vardas", "kitasvardas", stikline1, stikline, 6, 6)), (reiksme));
    }
}
