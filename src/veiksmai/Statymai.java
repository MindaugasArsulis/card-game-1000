package veiksmai;

import pagrindinis.ZaidimoPagrindinis;
import pirminiaiduomenys.Zaidejai;

import java.util.*;

public class Statymai extends ZaidimoPagrindinis {

    Scanner myScan = new Scanner(System.in);
    Scanner manoSkaneris = new Scanner(System.in);

    public Integer[] statymas(String pirmas, String antras) {


        Scanner myScan = new Scanner(System.in);
        Scanner manoSkaneris = new Scanner(System.in);

        Zaidejai p1 = new Zaidejai();
        Zaidejai p2 = new Zaidejai();

        System.out.println(pirmas + " do you want to place bet? (true/false)");
        boolean sutikimas = myScan.nextBoolean();
        if (sutikimas) {
            System.out.println(pirmas + " place your bet:");
            while (!myScan.hasNextInt()) {
                System.out.println("int, please!");
                myScan.nextLine();
            }
            int p1NewBet = myScan.nextInt();
            while (p1NewBet < 100) {
                System.out.println("Bet must be larger or equal to 100, your bet is " + p1NewBet + ". Place bet again");
                p1NewBet = myScan.nextInt();
            }
            p1.setBet(p1NewBet);

            while (sutikimas) {
                // P2 place bet
                System.out.println(antras + ", first player bet is " + p1.getBet() + ". Do you want to make your bet? (true/false)");
                sutikimas = manoSkaneris.nextBoolean();
                if (!sutikimas) {
                    break;
                }
                if (sutikimas) {
                    System.out.println(antras + " place your bet:");
                    while (!manoSkaneris.hasNextInt()) {
                        System.out.println("int, please!");
                        myScan.nextLine();
                    }
                    int p2NewBet = manoSkaneris.nextInt();
                    while (p2NewBet < p1.getBet() + 1) {
                        System.out.println("Bet must be larger than " + p1.getBet() + " your bet is " + p2NewBet + ". Place bet again");
                        p2NewBet = myScan.nextInt();
                    }
                    p2.setBet(p2NewBet);
                }
                // p1 place bet
                System.out.println(pirmas + ", second player bet is " + p2.getBet() + ". Do you want to make your bet? (true/false)");
                sutikimas = myScan.nextBoolean();
                if (!sutikimas) {
                    break;
                }
                if (sutikimas) {
                    System.out.println(pirmas + " place your bet:");
                    while (!myScan.hasNextInt()) {
                        System.out.println("int, please!");
                        myScan.nextLine();
                    }
                    p1NewBet = myScan.nextInt();
                    while (p2.getBet() + 1 > p1NewBet) {
                        System.out.println("Bet must be larger than " + p2.getBet() + " your bet is " + p1NewBet + ". Place bet again");
                        p1NewBet = myScan.nextInt();
                    }
                    p1.setBet(p1NewBet);
                }
            }

        } else {
            System.out.println(antras + " place your bet:");
            int p2NewBet = manoSkaneris.nextInt();
            while (p2NewBet < 100) {
                System.out.println("Bet must be larger or equal to 100, your bet is " + p2NewBet + ". Place bet again");
                p2NewBet = manoSkaneris.nextInt();
            }
            p2.setBet(p2NewBet);
        }

        // laimetojas gauna SetBet kiek nustate, pralaimetojas SetBet 0
        if (p1.getBet() > p2.getBet()) {
            p2.setBet(0);
        } else {
            p1.setBet(0);
        }

        Integer[] atsakymas = {p1.getBet(), p2.getBet()};
        return atsakymas;
    }

    public String[] zaidejuVardai() {

        Zaidejai player = new Zaidejai();

        Scanner myScan = new Scanner(System.in);
        Scanner manoSkaneris = new Scanner(System.in);


        System.out.println("Player one set your name: ");
        String p1Name = myScan.nextLine();
//        p1.setName((p1Name));

//        System.out.println(p1Name + " your cards are:");
//        System.out.println(l1);

        System.out.println("Player two set your name: ");
        String p2Name = manoSkaneris.nextLine();
//        p2.setName((p2Name));
//        System.out.println(p2Name + " your cards are:");
//        System.out.println(l2);

        String [] du = {p1Name, p2Name};
        return du;
    }

}

