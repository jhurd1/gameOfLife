import java.awt.*;

public class Zombie extends Creature implements Movable, Aggressor
{
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
        health = 1;
    }

    /******************************************
     * ATTACK
     *****************************************/
    @Override
    public void attack(Creature target)
    {
        if (target != null && !(target instanceof Plant))
        {
            target.takeDamage(10);
        }
    }

    @Override
    Shape getShape()
    {
        return Shape.Square;
    }

    @Override
    public Color getColor()
    {
        return new Color(0, 0, 255);
    }

    @Override
    Boolean isAlive()
    {
        return health > 0;
    }

    @Override
    public void move()
    {
        location.x++;
    }
}
