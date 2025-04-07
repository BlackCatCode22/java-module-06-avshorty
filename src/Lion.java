public class Lion extends animalTraits {
    static int numOfLion=0;
    public Lion(){
        super();
        numOfLion++;
    }
    public Lion(int age, int weight, String name, String birthday, String species, String color, String sex, String arrivalDate, String idNumber){
        super(age, weight, name, birthday, species, color, sex, arrivalDate,idNumber);
        numOfLion++;
    }
}
