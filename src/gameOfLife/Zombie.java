package gameOfLife;
import java.awt.*;

public abstract class Zombie extends Creature implements Movable, Aggressor {
    /******************************************
     * MEMBERS
     *****************************************/
    // Use Java native class
    // or use Creature point?
    Creature p;
    Point location;
    int health;

    /******************************************
     * CONSTRUCTOR
     *****************************************/
    public Zombie()
    {
        this.p = p;
        this.location = location;
        this.health = health;
    }

    /******************************************
     * ATTACK
     *****************************************/
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Plant)
        {
            target.takeDamage(0);
            //_health++;
        } else
            {
            target.takeDamage(10);
            health++;
            }
    }
    /******************************************
     * MOVE
     *****************************************/
    @Override
    public void move()
    {
        location.x++;
    }

    @Override
    public Color getColor()
    {
        return new Color(0, 0, 255);
    }
}
