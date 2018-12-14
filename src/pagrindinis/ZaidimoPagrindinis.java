package pagrindinis;

import pirminiaiduomenys.Dalintojas;
import pirminiaiduomenys.KortuVertes;
import pirminiaiduomenys.Zaidejai;
import veiksmai.*;

import java.util.*;


public class ZaidimoPagrindinis {

    public void zaidimas() {
        System.out.println("Welcome to 1000 Card Game");

        // skaneriai
        Scanner myScan = new Scanner(System.in);
        Scanner manoSkaneris = new Scanner(System.in);

        // klasiu pavertimas i objektus
        OperacijosSuKortomis d = new OperacijosSuKortomis();
        Statymai st = new Statymai();
        Logika1Zaidejas zl1 = new Logika1Zaidejas();
        Logika2Zaidejas zl2 = new Logika2Zaidejas();
        ArTeisingaKorta cg = new ArTeisingaKorta();

        // zaideju priskirimas
        Zaidejai p1 = new Zaidejai();
        Zaidejai p2 = new Zaidejai();
        Dalintojas c1 = new Dalintojas();
        Dalintojas c2 = new Dalintojas();

        p1.setPower(0);
        p2.setPower(0);

        // zaideju vardai
        String[] vardai = st.zaidejuVardai();
        p1.setName(vardai[0]);
        p2.setName(vardai[1]);

        // do/while ciklas kol vienas iš žaidėjų surenka 1000
        do  {
            // paimam kortas
            List<KortuVertes> ismaisytos = d.maisyti();

            // priskiriam dviems zaidejams ir dviems neturalioms kaladems kortos
            p1.setSetOfCards(d.priskirtiIsmaisytas(ismaisytos, 0, 9));
            p2.setSetOfCards(d.priskirtiIsmaisytas(ismaisytos, 9, 18));
            c1.setSetOfCards(d.priskirtiIsmaisytas(ismaisytos, 18, 21));
            c2.setSetOfCards(d.priskirtiIsmaisytas(ismaisytos, 21, 24));

            // surusiuoti kortas
            p1.setSetOfCards(d.grupuoti(p1.getSetOfCards()));
            p2.setSetOfCards(d.grupuoti(p2.getSetOfCards()));

            //
            System.out.println(p1.getName() + " your cards are:");
            System.out.println(p1.getSetOfCards());
            System.out.println(p2.getName() + " your cards are:");
            System.out.println(p2.getSetOfCards());


            // statymai
            Integer[] ats = st.statymas(p1.getName(), p2.getName());
            p1.setBet(ats[0]);
            p2.setBet(ats[1]);

            System.out.println();

            if (p1.getBet() > p2.getBet()) {
                p1.setSetOfCards(d.priskirtiKortosPirmam(p1.getName(), p1.getSetOfCards(), c1.getSetOfCards(), c2.getSetOfCards()));

            } else if (p2.getBet() > p1.getBet()) {
                p2.setSetOfCards(d.priskirtiKortasAntram(p2.getName(), p2.getSetOfCards(), c1.getSetOfCards(), c2.getSetOfCards()));
            } else {
                System.out.println("THERE WAS AN ERROR!!");
            }


            System.out.println();
            System.out.println("Lets start the game!");
            System.out.println();

            int pirmoscore = 0;
            int antroscore = 0;
            int pirmoPower;
            int antroPower;
            int count = 0;
            int[] glass = new int[3];

            // zaidimas su turimom kortom, kol jos baigiasi
            if (p1.getBet() > p2.getBet()) {
                count = 1;} else {
                count = 2;}
                do {
                    while (count == 1 && p1.getSetOfCards().size() > 0){
                        System.out.println(p1.getName() + " your cards are " + p1.getSetOfCards());
                        System.out.println(p2.getName() + " your cards are " + p2.getSetOfCards());
                        System.out.println(p1.getName() + " place your card");
                        int firstplcard = myScan.nextInt();
                        System.out.println(p1.getSetOfCards().get(firstplcard - 1));
                        System.out.println(p2.getName() + " place your card");
                        int secondplcard = myScan.nextInt();
                        secondplcard = cg.arTeisingasStatymas(p2.getName(), p1.getSetOfCards(), p2.getSetOfCards(), firstplcard, secondplcard);
                        System.out.println(p2.getSetOfCards().get(secondplcard - 1));
                        glass = zl1.formuleKortai(p1.getName(), p2.getName(), p1.getSetOfCards(), p2.getSetOfCards(), firstplcard, secondplcard);
                        p1.getSetOfCards().remove(firstplcard - 1);
                        p2.getSetOfCards().remove(secondplcard - 1);
                        pirmoscore += glass[0];
                        antroscore += glass[1];
                        count = glass[2];
                    }

                    while (count == 2 && p2.getSetOfCards().size() > 0) {
                        System.out.println(p1.getName() + " your cards are " + p1.getSetOfCards());
                        System.out.println(p2.getName() + " your cards are " + p2.getSetOfCards());
                        System.out.println(p2.getName() + " place your card");
                        int firstplcard = myScan.nextInt();
                        System.out.println(p2.getSetOfCards().get(firstplcard - 1));
                        System.out.println(p1.getName() + " place your card");
                        int secondplcard = myScan.nextInt();
                        secondplcard = cg.arTeisingasStatymas(p1.getName(), p2.getSetOfCards(), p1.getSetOfCards(), firstplcard, secondplcard);
                        System.out.println(p1.getSetOfCards().get(secondplcard - 1));
                        glass = zl2.formuleKortai(p2.getName(), p1.getName(), p2.getSetOfCards(), p1.getSetOfCards(), firstplcard, secondplcard);
                        p1.getSetOfCards().remove(secondplcard - 1);
                        p2.getSetOfCards().remove(firstplcard - 1);
                        pirmoscore += glass[1];
                        antroscore += glass[0];
                        count = glass[2];
                    }
                } while (p1.getSetOfCards().size() >= 1);

            pirmoPower = p1.getPower();
            antroPower = p2.getPower();

            if (p1.getBet() > p2.getBet()) {
                p2.setPower(antroPower + antroscore);
                if (pirmoscore >= p1.getBet()) {
                    p1.setPower(pirmoPower + p1.getBet());
                    System.out.println(p1.getName() + " won the match. His score " + p1.getPower());
                    System.out.println(p2.getName() + " score " + p2.getPower());
                } else {
                    p1.setPower(pirmoPower - p1.getBet());
                    System.out.println(p1.getName() + " lost the match. His score " + p1.getPower());
                    System.out.println(p2.getName() + " score " + p2.getPower());
                }
            } else {
                p1.setPower(pirmoPower + pirmoscore);
                if (antroscore >= p2.getBet()) {
                    p2.setPower(antroPower + p2.getBet());
                    System.out.println(p2.getName() + " won the match. His score " + p2.getPower());
                    System.out.println(p1.getName() + " score " + p1.getPower());
                } else {
                    p2.setPower(antroPower - p2.getBet());
                    System.out.println(p2.getName() + " lost the match. His score " + p2.getPower());
                    System.out.println(p1.getName() + " score " + p1.getPower());
                }
            }
        } while (p1.getPower() <= 1000 || p2.getPower() <= 1000);

        if (p1.getPower() >= 1000) {
            System.out.println(p1.getName() + " won the game! Congratulations!");
        } else {
            System.out.println(p2.getName() + " won the game! Congratulations!");
        }

    }
}




