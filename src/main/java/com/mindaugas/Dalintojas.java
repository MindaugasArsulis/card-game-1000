package main.java.com.mindaugas;

import java.util.List;

// Dalintojo klase
public class Dalintojas {
    private List<KortuVertes> setOfCards;

    public void setSetOfCards(List<KortuVertes> setOfCards) {
        this.setOfCards = setOfCards;
    }

    public List<KortuVertes> getSetOfCards() {
        return setOfCards;
    }
}
