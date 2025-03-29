public class Player {
    private int idPlayer;
    private String name;
    private int password;
    private int balance;
    // TODO Fila encadeada de Personagens ( cada jogador pode ter varios)
    
    
    public Player () {

    }
    
    public Player(int idPlayer, String name, int password, int balance) {
        this.idPlayer = idPlayer;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    
    //TODO METODO PARA CADASTRAR
    
    
    // TODO METODO PARA AUTENTICAR()

    
    // TODO METODO PARA CRIAR PERSONAGEM

    // TODO METODO PARA SELECIONAR PERSONAGEM
    

    
}