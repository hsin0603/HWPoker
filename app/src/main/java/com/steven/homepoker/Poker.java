package com.steven.homepoker;

import java.util.Random;

public class Poker {
    int[] cards = new int[52];
    char[] suits = {'s', 'c', 'h', 'd'};

    public Poker() {
        for (int i = 0; i < 52; i++) {
            cards[i] = i;
        }
    }

    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            int r = new Random().nextInt(52);
            int temp = cards[i];
            cards[i] = cards[r];
            cards[r] = temp;
        }
    }

    public void print() {
        for (int i = 0; i < 52; i++) {
            System.out.print(suits[cards[i] / 13] + " " + (cards[i] % 13 + 1));
            if (i % 13 == 12) {
                System.out.println();
            }
        }
    }
}
