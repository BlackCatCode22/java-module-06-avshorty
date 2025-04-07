public class Hyena extends animalTraits{
    static int numOfHyena=0;
    public Hyena(){
        super();
        numOfHyena++;
    }
    public Hyena(int age, int weight, String name, String birthday, String species, String color, String sex, String arrivalDate, String idNumber){
        super(age, weight, name, birthday, species, color, sex, arrivalDate,idNumber);
        numOfHyena++;
    }
}
