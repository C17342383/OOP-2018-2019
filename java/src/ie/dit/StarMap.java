package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
//<<<<<<< HEAD
    int selected1 = -1;
    int selected2 = -1;
//=======

//>>>>>>> d85640236ecd5b7cc0c4b1632cfc8cc97e76eb0c
    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        //loadData();
        printStars();
        border = width * 0.05f;

        //Testing the map
        System.out.println(map(25, 20, 30, 30, 40)
        );
        System.out.println(Map1(25, 20, 30, 30, 40)
        );
        System.out.println(map(0, -100, 200, 100, 500)
        );
        System.out.println(Map1(0, -100, 200, 100, 500)
        );

        Star s = new Star();
        s.setDisplayName("DIT");
        stars.add(s);

        Star s1 = stars.get(0);

        s1.setDisplayName("TU Dublin");

        System.out.println(s);
        System.out.println(stars.get(0));
        System.out.println(s1);
    }

    public void loadData()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        
        /*
        for(int i = 0 ; i < table.getRowCount() ; i ++)
        {
            TableRow row = table.getRow(i);
            System.out.println(row.getString("Display Name"));
            System.out.println(row.getString("Hab?"));            
        }
        */

        for(TableRow row:table.rows())
        {
            Star star = new Star(row);
            stars.add(star);     
        }
    }

    public void printStars()
    {
        for(Star star:stars)
        {
            System.out.println(star);
        }
    }

    float border;

    private void drawGrid()
    {
        textAlign(CENTER, CENTER);
        for(int i = -5 ; i <= 5 ; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            stroke(0, 0, 255);
            line(x, border, x, height - border);
            fill(255);
            text(i, x, border / 2);
            stroke(0, 0, 255);
            line(border, x, width - border, x);
            fill(255);            
            text(i, border / 2, x);
        }
    }

    public void drawStars()
    {
        textAlign(LEFT, CENTER);
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            stroke(255, 255, 0);
            noFill();
            ellipse(x, y, s.getAbsMag(), s.getAbsMag());

            stroke(0, 255, 255);
            line(x, y - 5, x, y + 5);
            line(x - 5, y, x + 5, y);
            fill(255);
            text(s.getDisplayName(), x + 20, y);
            
            

        }
    } 

    public void mouseClicked()
    {
//<<<<<<< HEAD
        //mouseX, mouseY;    
        //dist(mouseX, mouseY , mouseX, mouseY);
        for(int i= 0; i<stars.size();i++)
        {
            Star s = stars.get(1);
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            //means you havev cliked over a star
            if(dist(mouseX, mouseY, x, y)<s.getAbsMag()/2)
            //if(dist(muouseX, mouseY, star.screenPos.x, star.screenPos.y)
            {
                if(selected1 == -1)
                {
                    selected1 = i;
                    break;
                }
                if(selected2==-1)
                {
                    selected2 = i;
                }
            }
        }
//=======
            
//>>>>>>> d85640236ecd5b7cc0c4b1632cfc8cc97e76eb0c
    }

    public float Map1(float a, float b, float c, float d, float e)
    {
        //map(a, b, c, d, e)
        // a = what we are mapping
        //b = first range
        //c last range
        //d where it starts
        //e where it ends
        float x  = (b + c) /2;
        float y = (d + e) /2;

        //System.out.println("it is "+ y);
        //return y;
        
//5, 0, 10, 10, 20 - answer 15
        float range1 = c - b; // answer is 10
        float howFar = a - b; // answer is 5

        float range2 = e-d;


        return d + (howFar/ range1)*range2;
        
    }

    public void draw()
    {
        background(0);
        drawGrid();
        drawStars();
        mouseClicked();
        Map1(5, 0, 10, 10, 20);
    }

    private ArrayList<Star> stars = new ArrayList<Star>();

}