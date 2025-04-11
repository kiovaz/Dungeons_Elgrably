/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player;

/**
 *
 * @author Ramon Souza
 */
public class PlayerCharacter extends Entity {

    public PlayerCharacter(int id, String name, int agility, int maxHp, int currentHp,
            int maxMana, int currentMana, int strength) {
        super(id, name, agility, maxHp, currentHp, maxMana, currentMana, strength);
    }

    @Override
    public void takeDamage(int value) {
        int newHp = Math.max(0, this.getCurrentHealth() - value);
        this.setCurrentHealth(newHp);
        System.out.println(this.getName() + " agora tem " + newHp + " de HP.");
    }

    @Override
    public void useAbility(int abilityId, Entity target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int heal(int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
