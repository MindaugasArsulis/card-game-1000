package main.java.com.mindaugas;

import java.util.*;

public class OperacijosSuKortomis {

    Scanner myScan = new Scanner(System.in);
    Scanner manoSkaneris = new Scanner(System.in);

    // ismaisyti kortas
    public List<KortuVertes> maisyti() {
        List<KortuVertes> strList = Arrays.asList(KortuVertes.values());
        Collections.shuffle(strList);
        return strList;
    }

        // priskirti zaidejams ismaisytas kortas
    public List<KortuVertes> priskirtiIsmaisytas(List<KortuVertes> ismaisytos, int vienas, int du) {
        List<KortuVertes> strList = ismaisytos;
        strList = strList.subList(vienas, du);
        return strList;
    }

        // sugrupuoti kortas. Pilnai
    public List<KortuVertes> grupuoti(List<KortuVertes> ivestis) {

        ivestis = surikiuotiPagalGalia(ivestis);
        List<KortuVertes> stikline = new ArrayList<>();

        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(a.length() - 1, a.length()).equals("P")) {
                stikline.add(ivestis.get(z));
            }
        }

        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(a.length() - 1, a.length()).equals("K")) {
                stikline.add(ivestis.get(z));
            }


        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(a.length() - 1, a.length()).equals("B")) {
                stikline.add(ivestis.get(z));
            }
        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(a.length() - 1, a.length()).equals("C")) {
                stikline.add(ivestis.get(z));
            }
        }
        return stikline;
    }

        // surikiuoti
    public List<KortuVertes> surikiuotiPagalGalia(List<KortuVertes> ivestis) {

        List<KortuVertes> stikline = new ArrayList<>();

        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(0, 3).equals("DEV")) {
                stikline.add(ivestis.get(z));
            }
        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(0, 3).equals("BOR")) {
                stikline.add(ivestis.get(z));
            }
        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(0, 2).equals("DA")) {
                stikline.add(ivestis.get(z));
            }
        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(0, 2).equals("KA")) {
                stikline.add(ivestis.get(z));
            }
        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(0, 3).equals("DES")) {
                stikline.add(ivestis.get(z));
            }
        }
        for (int z = 0; z < ivestis.size(); z++) {
            String a = ivestis.get(z).name();
            if (a.substring(0, 2).equals("TU")) {
                stikline.add(ivestis.get(z));
            }
        }
        return stikline;
    }

        // kortu prisikirimas pirmam zaidejui, jei jis laimi /bet/
    public List<KortuVertes> priskirtiKortosPirmam(String name, List<KortuVertes> p1, List<KortuVertes> c1, List<KortuVertes> c2) {

        System.out.println(name + " you are the highest bidder. Please choose one pack of cards on the table");
        boolean chooseCards = true;
        chooseCards = myScan.nextBoolean();
        // jei pasirenka pirma (comp1) papildoma kalade
        if (chooseCards) {
            System.out.println(name + " you have got these cards: " + c1);
            p1.addAll(c1);
            p1 = (grupuoti(p1));
            System.out.println("Your cards are now:");
            System.out.println(p1);
            System.out.println("Please choose three cards to discard");
            System.out.println("Choose first card:");
            int removes = myScan.nextInt();
            p1.remove(removes - 1);
            System.out.println("Choose second card:");
            System.out.println(p1);
            removes = myScan.nextInt();
            p1.remove(removes - 1);
            System.out.println("Choose third card:");
            System.out.println(p1);
            removes = myScan.nextInt();
            p1.remove(removes - 1);
            System.out.println(name + " your cards are now:");
            System.out.println(p1);
        } else {
            System.out.println(name + " you have got these cards: " + c2);
            p1.addAll(c2);
            p1 = (grupuoti(p1));
            System.out.println("Your cards are now:");
            System.out.println(p1);
            System.out.println("Please choose three cards to discard");
            System.out.println("Choose first card:");
            int removes = myScan.nextInt();
            p1.remove(removes - 1);
            System.out.println("Choose second card:");
            System.out.println(p1);
            removes = myScan.nextInt();
            p1.remove(removes - 1);
            System.out.println("Choose third card:");
            System.out.println(p1);
            removes = myScan.nextInt();
            p1.remove(removes - 1);
//            System.out.println(name + " your cards are now:");
//            System.out.println(p1);
        }

        return p1;

    }

        // kortu priskirimas antram zaidejui jei jis laimi /bet/
    public List<KortuVertes> priskirtiKortasAntram(String name, List<KortuVertes> p2, List<KortuVertes> c1, List<KortuVertes> c2) {

        // antras laimi
        System.out.println(name + " you are the highest bidder. Please choose one pack of cards on the table");
        boolean chooseCards = true;
        chooseCards = manoSkaneris.nextBoolean();
        // jei pasirenka pirma papildoma kalade
        if (chooseCards) {
            System.out.println(name + " you have got these cards: " + c1);
            p2.addAll(c1);
            p2 = (grupuoti(p2));
            System.out.println(name + " your cards are now:");
            System.out.println(p2);
            System.out.println("Please choose three cards to discard");
            System.out.println("Choose first card:");
            int removes = manoSkaneris.nextInt();
            p2.remove(removes - 1);
            System.out.println("Choose second card:");
            System.out.println(p2);
            removes = manoSkaneris.nextInt();
            p2.remove(removes - 1);
            System.out.println("Choose third card:");
            System.out.println(p2);
            removes = manoSkaneris.nextInt();
            p2.remove(removes - 1);
            System.out.println(name + " your cards are now:");
            System.out.println(p2);
        } else {
            System.out.println(name + " you have got these cards: " + c2);
            p2.addAll(c2);
            p2 = (grupuoti(p2));
            System.out.println(name + " your cards are now:");
            System.out.println(p2);
            System.out.println("Please choose three cards to discard");
            System.out.println("Choose first card:");
            int removes = manoSkaneris.nextInt();
            p2.remove(removes - 1);
            System.out.println("Choose second card:");
            System.out.println(p2);
            removes = manoSkaneris.nextInt();
            p2.remove(removes - 1);
            System.out.println("Choose third card:");
            System.out.println(p2);
            removes = manoSkaneris.nextInt();
            p2.remove(removes - 1);
//            System.out.println(name + " your cards are now:");
//            System.out.println(p2);
        }

        return p2;
    }




}
