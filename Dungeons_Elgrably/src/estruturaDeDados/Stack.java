package estruturaDeDados;

public class Stack {
    
        private Node head;  // O topo da pilha
        private int size, qtd;   // Tamanho máximo e quantidade de elementos
        
        public Stack(int size){
            this.head = null;      // No começo, a pilha está vazia
            this.size = size;
            this.qtd = 0; // Nenhum elemento ainda
        }
    
        public void push(Object data){
            Node temp = new Node(data); // Cria um novo nó com o número
    
    
            if(qtd >= size){     // Se a pilha estiver cheia, não adiciona
                System.out.println("A pilha está cheia ");
            }else{
                temp.setNext(head);   // O novo nó aponta para o antigo topo
                head = temp;        // Agora o novo nó vira o topo da pilha
                qtd ++;             // Aumenta a quantidade de elementos
            }
    
        }
    
        public void peek(){
            Node current = head;
            if (head == null){
                System.out.println("Não há elementos na pilha");
            }else{
                System.out.println("Elemento do nó: "+ current.getData());
                System.out.println("Posição de Memória: " + current);
                System.out.println("Memória encadeada: "+ current.getNext());
            }
        }
        public void peekAll(){
            Node current = head;
            if (head == null){
                System.out.println("Não há elementos na pilha");
            }else{
                while (current != null) {
                    System.out.println(current.getData());
                    current =  current.getNext();
                }
            }
        }
    
        public void pop(){
            if(head == null){       // Se a pilha estiver vazia, não tem o que remover
                return;
            }
    
            Node temp = head;
            head = head.getNext();       // O topo agora passa a ser o próximo nó
            temp.setNext(null);
            qtd --;                 // Diminui a quantidade de elementos
        }
    
        public void isEmpty(){
            if (head == null){
                System.out.println("A pilha está vazia");
            }else{
                System.out.println("A pilha não está vazia");
            }
        }
    
        public void isFull(){
            if (size == qtd){
                System.out.println("A pilha está cheia");
            }else{
                System.out.println("A pilha não está cheia");
            }
        }
        
    }
