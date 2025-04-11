/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dungeons_elgrably;

import javax.swing.JOptionPane;
import view.player.Home;
import view.playerCharacter.HomeCharacter;
import view.Loading;
import view.MusicPlayer;

import java.util.Queue;

import arena.Arena;
import estruturaDeDados.LinkedList;
import estruturaDeDados.Node;
import player.PlayerCharacter;

/**
 *
 * @author Ramon Souza
 */
public class Dungeons_Elgrably {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Loading loading = new Loading();
        loading.setVisible(true);
        loading.pack();
        loading.setLocationRelativeTo(null);

        MusicPlayer player = new MusicPlayer();
        player.play("src/view/musica.wav");

        try {
            for (int i = 0; i <= 100; i += 99) {
                Thread.sleep(70);
                loading.getProgresso().setValue(i);
                loading.getPorcentagem().setText(Integer.toString(i) + "%");
            }
            loading.dispose();

            player.stop();

            Home LoginFrame = new Home();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
        } catch (InterruptedException e) {
            JOptionPane.showConfirmDialog(null, "Erro!");
        }
    }

}
