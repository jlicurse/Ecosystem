# Ecosystem
#This project contains 4 classes: 
# Animal.java, Bear.java, Fish.java, and EcosystemApp.java 
The Animal class is the parent class for Bear and Fish, with the latter two inherting certain default features from Animal. 
EcoSystemApp is the main method where the array the represents the "ecosystem" is shuffled and the animal objects within the array are moved to different locations. 
For Bears and Fish: 
  - When moved, if there is another bear/fish at the new spot in the array, the program checks the gender of the two bears/fish by checking      the "gender" class variable.
      - if both Male or both Female, the program checks which bear is stronger by checking the "strength" class variable. The stronger bear           stays put while the other "dies", or is deleted from the array
      - if the two are different, the two bears/fish mate and a new bear/fish object is created at an empty spot in the array
      - if there is an animal of a different "species" at the new spot of the array,
      - if the moving animal is a bear and the new spot is filled with a fish, the bear eats the fish and replaces it in the array.
      - if the moving animal is a fish and the new spot is filled with a bear, the fish gets eaten and deleted, the bear stays put.


Whoever comes across this project by any chance, feel free to look into upgrading the project in any way you see fit. 
