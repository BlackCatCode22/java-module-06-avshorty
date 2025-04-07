public class Sloth extends animalTraits{
    static int numOfSloth=0;
    public Sloth(){
        super();
        numOfSloth++;
    }
    public Sloth(int age, int weight, String name, String birthday, String species, String color, String sex, String arrivalDate, String idNumber){
        super(age, weight, name, birthday, species, color, sex, arrivalDate,idNumber);
        numOfSloth++;
    }
}
