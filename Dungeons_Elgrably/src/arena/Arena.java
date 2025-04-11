/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arena;

import estruturaDeDados.Queue;
import estruturaDeDados.Stack;
import estruturaDeDados.LinkedList;
import estruturaDeDados.Node;
import player.Entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author yasmi
 */
public class Arena {
    private int battleId;
    private Queue turnQueue;// fila de turnos
    // registrar a ordem em que os personagens foram derrotados
    private Stack finalRanking;
    private int currentTurn;
    private boolean battleInProgress;

    public Arena(int battleId, LinkedList participants) {
        this.battleId = battleId;
        this.turnQueue = new Queue();
        this.finalRanking = new Stack(getParticipantCount(participants));
        this.currentTurn = 0;
        this.battleInProgress = false;

        // Converte LinkedList para ArrayList temporária -- mais facil de manipular pela
        // arraylist usando o metodo collections
        // e depois adiciona na fila de turnos
        ArrayList<Entity> agilityList = new ArrayList<>();
        Node current = participants.getHead();
        while (current != null) {
            Entity entity = (Entity) current.getData();

            if (entity != null && entity.isALive()) {
                agilityList.add(entity);
            }

            current = current.getNext();
        }

        // Ordena por agilidade (do mais rápido para o mais lento)
        Collections.sort(agilityList, new Comparator<Entity>() {
            @Override
            public int compare(Entity e1, Entity e2) {
                return Integer.compare(e2.getAgility(), e1.getAgility()); // ordem decrescente
            }
        });

        // Adiciona à fila
        for (Entity entity : agilityList) {
            this.turnQueue.add(entity);
        }

    }

    // Conta o número de nós na lista (criar tamanho da pilha).
    private int getParticipantCount(LinkedList participants) {
        int count = 0;
        Node current = participants.getHead();
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // executa enquanto houver mais de um personagem vivo.

    public void startBattle() {
        this.battleInProgress = true;
        System.out.println("Batalha iniciada");
        while (battleInProgress) {
            executeTurn(); // Executa o turno do personagem atual
            checkWinner(); // Verifica se existe vencedor
        }
        displayFinalRanking(); // Exibe o resultado final após o fim da batalha
    }

    /**
     * Executa o turno de um personagem:
     * - Remove da fila
     * - Executa ação
     * - Volta para a fila (se estiver vivo)
     * - Se morrer, vai para a pilha
     */
    public void executeTurn() {
        Node currentNode = turnQueue.getHead();
        if (currentNode == null || currentNode.getData() == null) {
            return;
        }

        Entity currentEntity = (Entity) currentNode.getData();
        turnQueue.remove();

        if (!currentEntity.isALive()) {
            finalRanking.push(currentEntity); // Já tá morto, vai pro ranking
            return;
        }

        System.out.println(currentEntity.getName() + " Vai agir");

        // Procura um inimigo vivo -- alvo
        Entity target = findTarget(currentEntity);
        if (target != null) {
            // Aplica dano fixo de 10 ---- verificar isso depois
            // pode ser que personagens tenham habilidades especificas
            System.out.println(currentEntity.getName() + " Atacou " + target.getName());
            target.takeDamage(10);

            // Se o alvo morrer, entra no ranking
            if (!target.isALive()) {
                System.out.println(target.getName() + " foi derrotado.");
                finalRanking.push(target);
            }
        }

        // Se o personagem atual ainda está vivo, volta pro final da fila
        if (currentEntity.isALive()) {
            turnQueue.add(currentEntity);
        }

        currentTurn++;
    }

    /*
     * Procura um alvo válido para o personagem atual:
     * - Não pode ser ele mesmo
     * - Precisa estar vivo
     */
    private Entity findTarget(Entity current) {
        Node temp = turnQueue.getHead();
        while (temp != null) {
            Entity candidate = (Entity) temp.getData();
            if (!candidate.equals(current) && candidate.isALive()) {
                return candidate;
            }
            temp = temp.getNext();
        }
        return null; // Se não encontrou ninguém
    }

    /*
     * Verifica se restou apenas um personagem vivo (ou nenhum).
     * Se sim, encerra a batalha e adiciona o vencedor à pilha.
     */
    public void checkWinner() {
        int aliveCount = 0;
        Entity lastAlive = null;

        Node temp = turnQueue.getHead();
        while (temp != null) {
            Entity entity = (Entity) temp.getData();

            if (entity.isALive()) {
                aliveCount++;
                lastAlive = entity;
            }
            temp = temp.getNext();
        }

        // Se só restar um personagem, ele venceu
        if (aliveCount <= 1) {
            battleInProgress = false;
            if (lastAlive != null) {
                finalRanking.push(lastAlive);
                System.out.println(lastAlive.getName() + "venceu a batalha!");
            } else {
                System.out.println("Todos os personagens foram derrotados.");
            }
        }
    }

    // Exibe o ranking final com a ordem dos eliminados.

    public void displayFinalRanking() {
        System.out.println("\nFinal Ranking:");
        finalRanking.peekAll(); // A pilha tem os derrotados em ordem (último no topo = vencedor)
    }
}
