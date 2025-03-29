public abstract class Entity {
    protected int idCharacter;
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected int maxMana;
    protected int currentMana;
    // TODO Lista Encadeada para Habilidades

    public Entity() {
    }

    public Entity(int idCharacter, String name, int level, int maxHealth, int currentHealth, int maxMana,
            int currentMana) {
        this.idCharacter = idCharacter;
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxMana = maxMana;
        this.currentMana = currentMana;
        //TODO this.abilities = new LinkedList() (???)
    }

    public abstract void takeDamage (int value);
    public abstract void useAbility (int abilityId, Entity target);  // TODO vai percorrer pela lista encadeada procurando a habilidade;
    public abstract int heal(int value);
    
    public boolean isALive() {
        return this.currentHealth > 0;
    }

    public void levelUp () {                // TODO Verificar se vai ser necessário o metodo levelUp ser abstrato para cada entidade ou se sera igual para todos
        this.level++;
        this.maxHealth += 10;
        this.currentHealth = this.maxHealth;
        this.maxMana += 5;
        this.currentMana = this.maxMana;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    

    
    //TODO INSERIR UM CHEAT POSTERIORMENTE
}