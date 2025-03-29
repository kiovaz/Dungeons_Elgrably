public class Player {
    private int idPlayer;
    private String name;
    private String password;
    private int balance;
    // TODO Fila encadeada de Personagens ( cada jogador pode ter varios)

    public Player() {

    }

    public Player(int idPlayer, String name, String password, int balance) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    // TODO METODO PARA CADASTRAR
    public Player newPlayer(int idPlayer, String name, String password, int balance) {

        if (idPlayer <= 0) {
            System.out.println("error: invalid Player ID.");
            return null;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("error: invalid Name");
            return null;
        }

        if (password == null || name.trim().isEmpty()) {
            System.out.println("error: invalid Password.");
            return null;
        }

        if ( balance < 0) {
            System.out.println("error : invalid balance");
            return null;
        }

        Player newPlayer = new Player(idPlayer, name, password, balance);
        System.out.println("Player" + name + "registered.");
        return newPlayer;
    }

    // TODO METODO PARA AUTENTICAR()

    // TODO METODO PARA CRIAR PERSONAGEM

    // TODO METODO PARA SELECIONAR PERSONAGEM

}