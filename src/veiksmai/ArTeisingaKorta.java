package veiksmai;

import pirminiaiduomenys.KortuVertes;

import java.util.List;
import java.util.Scanner;

public class ArTeisingaKorta {

    Scanner manoSkaneris = new Scanner(System.in);

    public int arTeisingasStatymas(String player2, List<KortuVertes> p1, List<KortuVertes>p2, int statymas1, int statymas2) {
        int count = 0;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(statymas1 - 1).getSpalva() == p2.get(i).getSpalva()) {
                count++;
            }
        }
        if (count > 0) {
            while (p1.get(statymas1 - 1).getSpalva() != p2.get(statymas2 - 1).getSpalva()) {
                System.out.println(player2 + " please place appropriate card type! " + p2.get(statymas2 - 1) + " does not fit! You need to place " + p1.get(statymas1 - 1).getSpalva());
                statymas2 = manoSkaneris.nextInt();
            }
            return statymas2;
        }
        return statymas2;
    }

}

