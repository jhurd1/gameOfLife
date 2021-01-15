package gameOfLife;

import java.awt.*;
import java.util.Random;

public abstract class Wolf extends Creature implements Movable, Aware, Aggressor
{
    /******************************************
     * MEMBERS
     *****************************************/
    Creature p;
    Point location;
    int health;
    Random r;

    /******************************************
     * CONSTRUCTOR
     *****************************************/
    public Wolf()
    {
        this.p = p;
        this.location = location;
        this.health = health;
        r = new Random();
    }

    /******************************************
     * ATTACK
     *****************************************/
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Plant) {
            target.takeDamage(0);
            //_health++;
        } else {
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
        switch(r.nextInt(4))
        {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }
    }

    @Override
    public Color getColor()
    {
        return new Color(0, 0, 255);
    }

}
