package com.bridgelabz.playingcards;

public class DeckOfCards {

    int randomSuitIndex;
    int randomRankIndex;
    Card[][] distributedCards = new Card[4][9];
    boolean[][] previouslyDistributedCard = new boolean[4][13];

    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    int[] faceValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    void print()
    {
        for(int i=0;i < distributedCards.length;i++)
        {
            System.out.println("Player " + i);
            for(int j=0;j <distributedCards[i].length;j++)
            {
                Card card = distributedCards[i][j];
                System.out.print(card + "\t");
            }
            System.out.println();
        }
    }
    int[] lastPlayerToCardIndex = new int[]{0,0};

    void cardSelection() {
        int playerIndex = lastPlayerToCardIndex[0];
        int cardIndex = lastPlayerToCardIndex[1];

        // Exit because every player has received 9 cards
        if(playerIndex == 3 && cardIndex == 9) {
            return;
        }

        // Generate a random index of suit and rank to choose from
        randomSuitIndex = (int) (Math.random() * 4);
        randomRankIndex = (int) (Math.random() * 13);

        // Check if this random suit and rank is already distributed to another player
        while(previouslyDistributedCard[randomSuitIndex][randomRankIndex]) {
            randomSuitIndex = (int) (Math.random() * 4);
            randomRankIndex = (int) (Math.random() * 13);
        }



        // Assign that random card to player at some card index out of 9 places
        distributedCards[playerIndex][cardIndex] = new Card(suits[randomSuitIndex],ranks[randomRankIndex]);
        // Mark this rank and suit as already distributed one
        previouslyDistributedCard[randomSuitIndex][randomRankIndex] = true;


        if(cardIndex == 8) {
            // Next player should receive first card
            lastPlayerToCardIndex[0] = playerIndex+1;
            lastPlayerToCardIndex[1] = 0;
        } else {
            // Existing player receives next card
            lastPlayerToCardIndex[0] = playerIndex;
            lastPlayerToCardIndex[1] = cardIndex+1;
        }
    }
}
