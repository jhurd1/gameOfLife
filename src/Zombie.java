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
        this.p = p;
        this.location = location;
        health = 1;
    }

    /******************************************
     * ATTACK
     *****************************************/
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Animal)
        {
            target.takeDamage(10);
        }
    }
    /******************************************
     * MOVE
     ****************************************
     * @return*/
 /*   @Override
    public int move()
    {
        location.x++;
        return 0;
    }*/

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
    public void move() {

    }
}
