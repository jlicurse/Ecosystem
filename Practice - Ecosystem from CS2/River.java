import java.util.Random;

/* 
 * The River Class 
 * part of the Ecosystem project
 * @author Jonathan Licurse 
 * 
 * 
 */
public class River {

   /*
    * Interactions: 
    if bear meets bear/fish meets fish:
        - check genders 
            -SAME: fight
                - check strengths 
                    -SAME: animal 1 wins 
                        - replace animal 2 with animal 1 in array
                    -DIFFERENT: stronger 
                        - animal 1 wins 
                            - replace animal 2 with animal 1 in array
                        - animal 2 wins 
                            - animal 1 is removed from array, 2 stays put 

            -DIFFERENT: mate
                - new Fish/Bear object is created
                - array expands 
            



    
    */
    Animal river[];


    public River(){
        river = new Animal[20];
       //use random to generate a random number between 0 and 19
        Random rnd = new Random();
        int place = rnd.nextInt(20);
        for (int i = 0; i < (river.length - 5); i++){
           //populate the array with bears and fish randomly 
           if (place % 2 == 0){
               river[place] = new Bear();
           } else {
               river[place] = new Fish();
           }
           place = rnd.nextInt(20); 
        }
    }

    public void move(){
        Random rnd = new Random();
        int move = rnd.nextInt(20); 
        System.out.println("First stop: " + move);
        for (int i = 0; i < river.length; i++){
            if (river[i] == null){
                System.out.print("No animal at " + i + "\n");
                continue;
            }
            if (i == move){
                move = rnd.nextInt(20);
                continue;
            }
            if (river[i] != null){ //if there is an animal at river[i]
                if (river[i].getSpecies() == "Bear" || river[i].getSpecies() == "Fish"){ //if their is an animal at river[i]
                        if (river[move] == null){ //if the new place is empty 
                            river[move] = river[i]; //move the bear to the new empty place
                            String animal = river[i].getSpecies();
                            river[i] = null; //old spot is now empty 
                            System.out.println("The " + animal  + " from " + i + " moved to: " + move);
                            move = rnd.nextInt(20); //generate a new random number
                            System.out.println("New place: " + move);

                        } else if (river[move].getSpecies() == "Fish" && river[i].getSpecies() == "Bear") {
                            river[move] = river[i]; //the bear eats the fish, takes its place
                            System.out.println("The bear at " + i + " ate the fish at " + move);
                        } else if (river[move].getSpecies() == "Bear" && river[i].getSpecies() == "Fish"){
                            river[i] = null; //the fish dies and the old spot is empty
                            System.out.println("The fish at " + i + " was eaten by the bear at " + move);
                        } else if (river[i].getSpecies() == "Bear" && river[move].getSpecies() == "Bear"){
                            if (river[i].compareGender(river[move]) == 1){
                                if (river[i].compareStrength(river[move]) == 1){
                                    river[move] = river[i]; //the original bear wins the fight and takes its place
                                    System.out.println("The bear at " + i + " killed the bear at " + move);
                                } else if (river[i].compareStrength(river[move]) == -1){
                                    river[i] = null; // the original bear dies and the old spot is empty
                                    System.out.println("The bear at " + i + " was killed by the bear at " + move);
                                }

                            } else if (river[i].compareGender(river[move]) == 0) {
                                for (int j = move + 1; j < river.length; j++){
                                    if(river[j] == null){  //find an empty spot to make a new animal 
                                       if(river[i].getSpecies() == "Bear" ){//make a new bear
                                        river[j] = new Bear();
                                        System.out.println("A new bear was born at " + j + " via the Bear from " + i + " and the bear from " + move);
                                        break;
                                    } else if (river[i].getSpecies() == "Fish"){ //make a new fish
                                        river[j] = new Fish();
                                        System.out.println("A new fish was born at " + j + " via the Fish from " + i + " and the Fish from " + move);
                                        break;
                                    }
                                }
                            }

                        }
                        

                            }
                            /*
                            System.out.println(river[move].getSpecies() + " in the way at place " + move + "!");
                            move = rnd.nextInt(20);
                            System.out.println("Trying again at: " + move);
                                                }
                        
                        else if (river[place].getSpecies() == "Fish"){ //if the new slot is not empty and it is occupied by a fish 
                            if (river[i].compareStrength(river[place]) == 1){ //if the bear is stronger than the fish
                                river[place] = river[i]; //the bear eats the fish, takes its place 
                                river[i] = null; //original spot is empty
                            } else if (river[i].compareStrength(river[place]) == -1){ //if the bear is weaker than the fish
                                river[i] = null; // the bear dies and the old spot is empty 
                            }
                        } else if (river[place].getSpecies() == "Bear"){ //if the new spot is not empty and it is a bear...
                            if (river[i].compareGender(river[place]) == 1){//if the genders are the same, check the strength comparison
                                if (river[i].compareStrength(river[place]) == 1){ //if the original bear is stronger than the bear in the new spot...
                                    river[place] = river[i]; //the original bear wins the fight and takes its place 
                                    river[i] = null; //leaves its old spot empty 
                                } else if (river[i].compareStrength(river[place]) == -1){//if the new bear is stronger...
                                    river[i] = null; // the original bear dies and the old spot is empty 
                                }
                            } else if (river[i].compareGender(river[place]) == 0){ //if the genders are different...
                               for (int j = place + 1; j < river.length; j++){
                                    if(river[j] == null){  //find an empty spot to make a new animal 
                                       if(river[i].getSpecies() == "Bear" ){//make a new bear
                                        river[j] = new Bear();

                                    }


                               }
                            }
                        }
                    }
                } else if (river[i].getSpecies() == "Fish"){
                    if (place % 2 == 1){
                        if (river[place] == null){
                            river[place] = river[i];
                            river[i] = null;
                        } else if (river[place].getSpecies() == "Bear"){
                            if (river[i].compareStrength(river[place]) == 1){
                                river[place] = river[i];
                                river[i] = null;
                            } else if (river[i].compareStrength(river[place]) == -1){
                                river[i] = null;
                            }
                        } else if (river[place].getSpecies() == "Fish"){
                            if (river[i].compareGender(river[place]) == 0){
                                if (river[i].compareStrength(river[place]) == 1){
                                    river[place] = river[i];
                                    river[i] = null;
                                } else if (river[i].compareStrength(river[place]) == -1){
                                    river[i] = null;
                                }
                            } else if (river[i].compareGender(river[place]) == 1){
                                if (river[i].compareStrength(river[place]) == 1){
                                    river[place] = river[i];
                                    river[i] = null;
                                } else if (river[i].compareStrength(river[place]) == -1){
                                    river[i] = null;
                                }
                            }
        }
       
    }
    */
}
}}
            }
        
    



    public String toString(){
        String riverString = "";
        for (int i = 0; i < river.length; i++){
            if (river[i] == null){
                riverString += i + ": " + " " + "\n";
            } else{
            riverString += i + ": " + river[i].getSpecies() + " " + "\n";
            }
        }
        return riverString;
    }
    
}
