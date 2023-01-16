package com.bridgelabz.playingcards;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Card Game");
        DeckOfCards d1 = new DeckOfCards();
        for(int i = 0;i < 36;i++) {
            d1.cardSelection();
        }
        d1.print();
    }
}
