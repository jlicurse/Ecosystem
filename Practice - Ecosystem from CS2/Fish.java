import java.util.Random; 

/*
 * Fish Class
 * 
 */

public class Fish extends Animal {

    public Fish(){
        this.species = "Fish";
        Random rand = new Random();
        this.strength = rand.nextInt(100); 
        this.gender = rand.nextInt(2);
    }
    
}
