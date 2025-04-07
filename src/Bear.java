public class Bear extends animalTraits {
   static int numOfBear=0;
    public Bear(){
        super();
        numOfBear++;
    }
    public Bear(int age, int weight, String name, String birthday, String species, String color, String sex, String arrivalDate,
                String idNumber){
    super(age, weight, name, birthday, species, color, sex, arrivalDate,idNumber);
    numOfBear++;
    }
}
