package com.mindaugas.cardgame1000.veiksmai;

import com.mindaugas.cardgame1000.pirminiaiduomenys.KortuVertes;

import java.util.List;

public interface FormuleKortuMacui {
    int[] formuleKortai(String player1, String player2, List<KortuVertes> p1, List<KortuVertes> p2, int statymas1, int statymas2);
}
