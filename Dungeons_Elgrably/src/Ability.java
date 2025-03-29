public class Ability {
    private int id;
    private String name;
    private int manaCost;
    private int effect;             // dano ou heal (habilidade pode ser de dano ou cura)
    
    public Ability(int id, String name, int manaCost, int value) {
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
        this.effect = value;
    }

    public void useAbility (PlayerCharacter user, PlayerCharacter target) {
        if (user.getCurrentMana() >= this.manaCost) {
            user.setCurrentMana(user.getCurrentMana() - this.manaCost);
        }
        if (this.effect < 0){
            target.takeDamage(-this.effect);
        } else {
            target.heal(this.effect);
        }
    }

    

    
}
