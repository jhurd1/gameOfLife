import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aware, Aggressor
{
    /******************************************
     * MEMBERS
     *****************************************/
    Creature p;
    Point location;
    int health;
    Random r;
    Creature c;
    CreatureHandler ch;
    Direction preferredDirection;

    /******************************************
     * CONSTRUCTOR
     *****************************************/
    public Wolf()
    {
        /*this.p = p;
        this.location = location;
        this.health = health;*/
        r = new Random();
        health = 1;
        preferredDirection = getRandomDirection();
    }

    private Direction getRandomDirection()
    {
        switch (r.nextInt(4))
        {
            case 0:
                return Direction.Right;
            case 1:
                return Direction.Left;
            case 2:
                return Direction.Up;
            case 3:
                return Direction.Down;
            default:
                return Direction.Up;
        }
    }
    /******************************************
     * ATTACK
     *****************************************/
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Animal)
        {
            target.takeDamage(5);
        }
    }
    /******************************************
     * MOVE
     ****************************************
     * @return*/
    @Override
    public void move()
    {
        /*if (c instanceof Animal)
        {
            //senseNeighbors(c.getLocation());
        } else
            {*/
            switch (preferredDirection)
            {
                case Right:
                    location.x++;
                    break;
                case Left:
                    location.x--;
                    break;
                case Down:
                    location.y--;
                    break;
                case Up:
                    location.y++;
                    break;
                default:
                    location.y++;
                    break;
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
        return new Color(72, 72, 72);
    }

    @Override
    Boolean isAlive()
    {
        return health > 0;
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right)
    {
        if (preferredDirection == Direction.Up)
        {
            if (above instanceof Animal)
            {
                return;
            } else if (right instanceof Animal)
            {
                preferredDirection = Direction.Right;
            } else if (below instanceof Animal)
            {
                preferredDirection = Direction.Down;
            } else if (left instanceof Animal)
            {
                preferredDirection = Direction.Left;
            }
        } else if (preferredDirection == Direction.Right)
        {
            if (right instanceof Animal)
            {
                return;
            } else if (below instanceof Animal)
            {
                preferredDirection = Direction.Down;
            } else if (above instanceof Animal)
            {
                preferredDirection = Direction.Up;
            } else if (left instanceof Animal)
            {
                preferredDirection = Direction.Left;
            }
        } else if (preferredDirection == Direction.Left)
        {
            if (left instanceof Animal)
            {
                return;
            } else if (above instanceof Animal) {
                preferredDirection = Direction.Up;
            } else if (below instanceof Animal) {
                preferredDirection = Direction.Down;
            } else if (right instanceof Animal) {
                preferredDirection = Direction.Right;
            }
        } else if (preferredDirection == Direction.Down)
        {
            if (below instanceof Animal)
            {
                return;
            } else if (left instanceof Animal)
            {
                preferredDirection = Direction.Left;
            } else if (right instanceof Animal)
            {
                preferredDirection = Direction.Right;
            } else if (above instanceof Animal)
            {
                preferredDirection = Direction.Up;
            }
        }
    }
}
