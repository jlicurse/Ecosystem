/*
 * Bear Class 
 */
import java.util.Random;



public class Bear extends Animal{

    public Bear(){
        this.species = "Bear";
        Random rand = new Random();
        this.strength = rand.nextInt(100);
        this.gender = rand.nextInt(2); 
    }

}
