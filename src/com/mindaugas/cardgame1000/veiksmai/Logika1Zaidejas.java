package com.mindaugas.cardgame1000.veiksmai;

import com.mindaugas.cardgame1000.pirminiaiduomenys.KortuVertes;

import java.util.List;

public class Logika1Zaidejas {

    public int[] formuleKortai1(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2,
                                int statymas1, int statymas2) {
        return formuleKortai(player1, player2, p1, p2, statymas1, statymas2, true);
    }

    public int[] formuleKortai2(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2,
                                int statymas1, int statymas2) {
        return formuleKortai(player1, player2, p1, p2, statymas1, statymas2, false);
    }

    private int[] formuleKortai(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2,
                                int statymas1, int statymas2, boolean formule) {

        KortuVertes kortosverte = null;
        int rezultatas = 0;

        if (p1.get(statymas1 - 1).equals(KortuVertes.KARALIUS_P)) {
            kortosverte = KortuVertes.DAMA_P;
            rezultatas = 40;
        } else if (p1.get(statymas1 - 1).equals(KortuVertes.KARALIUS_K)) {
            kortosverte = KortuVertes.DAMA_K;
            rezultatas = 60;
        } else if (p1.get(statymas1 - 1).equals(KortuVertes.KARALIUS_B)) {
            kortosverte = KortuVertes.DAMA_B;
            rezultatas = 80;
        } else if (p1.get(statymas1 - 1).equals(KortuVertes.KARALIUS_C)) {
            kortosverte = KortuVertes.DAMA_C;
            rezultatas = 100;
        }

        int pirmoscore = 0;
        int count;
        count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).equals(kortosverte)) {
                count++;
            }
        }
        if (count > 0 && kortosverte != null) {
            System.out.println("Player shouts " + rezultatas);
            pirmoscore += rezultatas;
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore, formule);

            //////// jei deda kezerine korta, bet kozerio neturi
        } else if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore, formule);
            // jeigu deda kitos rusies
        } else {
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore, formule);
        }
    }

    private int[] formule1(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1,
                           int statymas2, int pirmoscore, boolean formule) {

        int antroscore = 0;

        int[] laikinas = new int[3];

        if (p1.get(statymas1 - 1).getVerte() > p2.get(statymas2 - 1).getVerte()) {
            System.out.println(player1 + " takes the cards");
            pirmoscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
            laikinas[0] = pirmoscore;
            laikinas[1] = antroscore;
            laikinas[2] = (formule ? 1 : 2);
            return laikinas;
            //
            // p1 takes cards
            // kartojasi
        } else {
            System.out.println(player2 + " takes the cards");
            antroscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
            laikinas[0] = pirmoscore;
            laikinas[1] = antroscore;
            laikinas[2] = (formule ? 2 : 1);
            return laikinas;
            // p2 takes cards
            // kartojasi
        }
    }

    private int[] formule2(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1,
                           int statymas2, int pirmoscore, boolean formule) {

        int antroscore = 0;
        int[] laikinas = new int[3];
        System.out.println(player1 + " takes the cards");
        pirmoscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
        laikinas[0] = pirmoscore;
        laikinas[1] = antroscore;
        laikinas[2] = (formule ? 1 : 2);
        return laikinas;
        // pirmas laimi 1 partija
        // kartojasi
    }
}