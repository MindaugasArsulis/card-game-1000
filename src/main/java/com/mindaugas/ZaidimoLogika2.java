package main.java.com.mindaugas;

import java.util.List;
import java.util.Scanner;

public class ZaidimoLogika2 {
    Scanner myScan = new Scanner(System.in);
    Scanner manoSkaneris = new Scanner(System.in);

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
        int count;
        int [] stikline = new int[3];
        count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(statymas1 -1).getSpalva() == p2.get(i).getSpalva()) {
                count++;
            }
        }
        if (count > 0) {
            while (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
                System.out.println(player2 + " please place appropriate card type!");
                statymas2 = manoSkaneris.nextInt();
            }
            if (p1.get(statymas1 - 1).getVerte() > p2.get(statymas2 - 1).getVerte()) {
                System.out.println(player1 + " takes the cards");
                pirmoscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
                stikline[0] = pirmoscore; stikline[1] = antroscore; stikline[2] = 2;
                return stikline;
                // pirmas laimi 1 partija
                // kartojasi

            } else { // jei antras laimi 1 partija
                System.out.println(player2 + " takes the cards");
                antroscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
                stikline[0] = pirmoscore; stikline[1] = antroscore; stikline[2] = 1;
                return stikline;
                // antras laimi partija
                //kartojasi
            }

//                    String du = p1.getSetOfCards().get(0).getSpalva().name();
        } else { // pirmas paima jei antras tokios neturi
            System.out.println(player1 + " takes the cards");
            pirmoscore += p1.get(statymas1 - 1).getVerte() + p2.get(statymas2 - 1).getVerte();
            stikline[0] = pirmoscore; stikline[1] = antroscore; stikline[2] = 2;
            return stikline;
            // pirmas laimi 1 partija
            // kartojasi
        }
    }

    public int [] formuleKaraliusPiku(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2) {
        int pirmoscore = 0;
        int antroscore = 0;
        int count;
        count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).equals(KortuVertes.DAMA_P)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Player shouts 40");
            pirmoscore += 40;

            // reikai dar vieno if patikrint ar ta pati reiksme
            if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
                return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);

                // jeigu deda kitos rusies
            } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
                return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            }
            //////// jei deda kezerine korta, bet kozerio neturi
        } else if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            // jeigu deda kitos rusies
        } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
        }
        return null;
    }

    public int [] formuleKaraliusKryziu(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2) {
        int pirmoscore = 0;
        int antroscore = 0;
        int count;
        count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).equals(KortuVertes.DAMA_K)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Player shouts 60");
            pirmoscore += 60;

            // reikai dar vieno if patikrint ar ta pati reiksme
            if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
                return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);

                // jeigu deda kitos rusies
            } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
                return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            }
            //////// jei deda kezerine korta, bet kozerio neturi
        } else if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            // jeigu deda kitos rusies
        } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
        }
        return null;
    }

    public int [] formuleKaraliusBugnu(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2) {
        int pirmoscore = 0;
        int antroscore = 0;
        int count;
        count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).equals(KortuVertes.DAMA_B)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Player shouts 80");
            pirmoscore += 80;

            // reikai dar vieno if patikrint ar ta pati reiksme
            if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
                return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);

                // jeigu deda kitos rusies
            } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
                return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            }
            //////// jei deda kezerine korta, bet kozerio neturi
        } else if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            // jeigu deda kitos rusies
        } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
        }
        return null;
    }

    public int [] formuleKaraliusCyrvu(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2) {
        int pirmoscore = 0;
        int antroscore = 0;
        int count;
        count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).equals(KortuVertes.DAMA_C)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Player shouts 100");
            pirmoscore += 100;

            // reikai dar vieno if patikrint ar ta pati reiksme
            if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
                return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);

                // jeigu deda kitos rusies
            } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
                return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            }
            //////// jei deda kezerine korta, bet kozerio neturi
        } else if (p1.get(statymas1 - 1).getSpalva() == p2.get(statymas2 - 1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            // jeigu deda kitos rusies
        } else if (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
        }
        return null;
    }

    public int [] antrasDeda (String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2) {

        int pirmoscore = 0;
        int antroscore = 0;
        int count;

        int [] stikline = new int[3];


        if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_P)) {
            return formuleKaraliusPiku(player1, player2, p1, p2, statymas1, statymas2);
        }// su pikais baigta

        else  if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_K)) {
            return formuleKaraliusKryziu(player1, player2, p1, p2, statymas1, statymas2);
        } // su kryziais baigta

        else  if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_B)) {
            return formuleKaraliusBugnu(player1, player2, p1, p2, statymas1, statymas2);
        } // su bugnais baigta

        else  if (p1.get(statymas1-1).equals(KortuVertes.KARALIUS_C)) {
            return formuleKaraliusCyrvu(player1, player2, p1, p2, statymas1, statymas2);
        } // su cirvais baigta

        // kartojasi//////////////////////////////////////
        // jei deda tokios pat rusies
        else if (p1.get(statymas1-1).getSpalva() == p2.get(statymas2-1).getSpalva()) {
            return formule1(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
            // jeigu deda kitos rusies
        } else if (p1.get(statymas1-1).getSpalva() != p2.get(statymas2-1).getSpalva()) {
            return formule2(player1, player2, p1, p2, statymas1, statymas2, pirmoscore);
        }

        System.out.println("TAIP NETUREJO BUTI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return null;

    }

}
