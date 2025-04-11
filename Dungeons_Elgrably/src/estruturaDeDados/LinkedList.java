package estruturaDeDados;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void removeNode(Object data) {
        if (head == null) {
            System.out.println("Não há nós nessa lista");
            return;
        }
        if (head.getData() == null ? data == null : head.getData().equals(data)) {
            head = head.getNext();
            System.out.println("O primeiro elemento foi removido");
            return;
        }

        Node temp = head;
        while (temp.getNext() != null
                && (temp.getNext().getData() == null ? data != null : !temp.getNext().getData().equals(data))) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            System.out.println("O elemento buscado não consta na lista");
        } else {
            System.out.println("O elemento removido foi: " + temp.getNext().getData());
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println("O elemento do nó é:" + temp.getData());
            temp = temp.getNext();
        }
    }

    public Node getHead() {
        return head;
    }

}
