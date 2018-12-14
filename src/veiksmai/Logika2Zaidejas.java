package veiksmai;

import pirminiaiduomenys.KortuVertes;

import java.util.List;

public class Logika2Zaidejas implements FormuleKortuMacui {

    public int [] formule1 (String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2, int pirmoscore) {

        int antroscore = 0;

        int [] stikline = new int[3];

        if (p1.get(statymas1 - 1).getVerte() > p2.get(statymas2 - 1).getVerte()) {
            System.out.println(player1 + " takes the cards");
            pirmoscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
            stikline[0] = pirmoscore; stikline[1] = antroscore; stikline[2] = 2;
            return stikline;
            //
            // p1 takes cards
            // kartojasi
        } else {
            System.out.println(player2 + " takes the cards");
            antroscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
            stikline[0] = pirmoscore; stikline[1] = antroscore; stikline[2] = 1;
            return stikline;
            // p2 takes cards
            //kartojasi
        }
    }

    public int [] formule2 (String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2, int pirmoscore){

        int antroscore = 0;
        int [] stikline = new int[3];
            System.out.println(player1 + " takes the cards");
            pirmoscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
            stikline[0] = pirmoscore; stikline[1] = antroscore; stikline[2] = 2;
            return stikline;
            // pirmas laimi 1 partija
            // kartojasi
    }

    @Override
    public int[] formuleKortai(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2) {

        KortuVertes kortosverte = null;
        int rezultatas = 0;

        if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_P)) {
           kortosverte = KortuVertes.DAMA_P;
           rezultatas = 40;
        } else if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_K)) {
            kortosverte = KortuVertes.DAMA_K;
            rezultatas = 60;
        } else if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_B)) {
            kortosverte = KortuVertes.DAMA_B;
            rezultatas = 80;
        } else if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_C)) {
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
                return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);

            //////// jei deda kezerine korta, bet kozerio neturi
        } else if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            // jeigu deda kitos rusies
        } else{
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
        }
    }
}