/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dungeons_elgrably;

import view.Home;

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
        // Cria a lista encadeada de participantes
        LinkedList participants = new LinkedList();

        // Cria personagens de exemplo com agilidade e atributos variados
        PlayerCharacter yasmin = new PlayerCharacter(1, "Yasmin", 5, 100, 100, 50, 50, 18);
        PlayerCharacter caio = new PlayerCharacter(2, "Caio", 4, 100, 100, 30, 30, 14);
        PlayerCharacter dandan = new PlayerCharacter(3, "DanDan", 3, 80, 80, 60, 60, 20);
        PlayerCharacter muriel = new PlayerCharacter(4, "Muriel", 2, 90, 90, 40, 40, 12);

        // Adiciona os personagens na lista
        participants.addNode(yasmin);
        participants.addNode(caio);
        participants.addNode(dandan);
        participants.addNode(muriel);

        // Cria a Arena com os personagens e inicia a batalha
        Arena arena = new Arena(1, participants);
        arena.startBattle();
    }

}
