/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturaDeDados;

import player.Entity;
import player.Player;

/**
 *
 * @author Ramon Souza
 */
public class Queue {

    private Node head;
    private Node tail;

    private int qtd = 0;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.qtd = 0;
    }

    public void add(Entity entity) {
        Node newNode = new Node(entity);

        if (isEmpty()) {

            this.head = newNode;
            this.tail = newNode;
        } else {

            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        qtd++;
    }

    public void remove() {
        Node temp = head;

        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }

        head = head.getNext();
        temp.setNext(null);
        qtd--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Não há nós na fila.");
            return;
        }

        System.out.println("O seu primeiro elemento é: " + head.getData());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void size() {
        System.out.println("O números de elementos que você tem é: " + qtd);
    }

    // getter and setters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
