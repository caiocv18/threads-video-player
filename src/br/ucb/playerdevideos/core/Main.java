package br.ucb.playerdevideos.core;

import java.util.ArrayList;
import java.util.List;

import br.ucb.playerdevideos.models.Filme;
import br.ucb.playerdevideos.models.PlayerDeVideo;

public class Main {
    public static void main(String[] args) {
        Filme mulan = new Filme("Mulan", 10);
        Filme interestelar = new Filme("Interestelar", 20);
        List<Thread> threads = new ArrayList<Thread>();

        threads.add(new PlayerDeVideo(mulan, 5, 5));
        threads.add(new PlayerDeVideo(interestelar, 10, 3));

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}