/*
 * Animal Class 
 * Jonathan Licurse 
 * Java Practice 
 */

public class Animal {

    public int gender;
    public int strength; 
    public String species; 


    public int getStrength(){ //--> works
        return strength; 
    }

    public int getGender(){ //--> works 
        return gender; //--> 0 is female, 1 is male 
    }

    public String getSpecies(){ //--> test when bear and fish classes are set up
        return species;
    }

    public int compareGender(Animal animal){ // --> works 
        if (this.getGender() == animal.gender)
            return 1; //--> SAME, check this for fighting in move method 
        else    
            return 0; //--> DIFFERENT, check this for mating in move method  
    }

    public void setGender(int newGender){//--> works 
        this.gender = newGender;
    }

    public void setStrength(int newStrength){ //--> works
        this.strength = newStrength;
    }

    public int compareStrength(Animal animal){ // --> works
        if (this.getSpecies() == animal.getSpecies()){ //--> if this results in -1, the bear eats the fish (replaces the fish in the array)
            if (this.getStrength() > animal.getStrength())
                return 1;
            else if (this.getStrength() < animal.getStrength())
                return -1; //--> check sign when doing move function in bear and fish 
            else 
                return 0;
        }
        else 
            return -1;
       
    }

}
