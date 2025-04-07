public abstract class animalTraits {
  static int numOfAnimal = 0;
  public animalTraits(){
   numOfAnimal++;
  }

   //Set up string and int for other classes.
    private int age;
    private int weight;
    private String name;
    private String birthday;
    private String species;
    private String color;
    private String sex;
    private String arrivalDate;
    private String idNumber;
 //set up constructor
    public animalTraits(int age, int weight,String name,String birthday,String species,String color,String sex,
                        String arrivalDate, String idNumber){
   numOfAnimal++;
     this.age = age;
   this.arrivalDate= arrivalDate;
   this.name = name;
   this.birthday = birthday;
   this.sex = sex;
   this.color = color;
   this.weight = weight;
   this.species = species;
   this.idNumber = idNumber;
 }
//creates the setter and getter for animals

 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getBirthday() {
  return birthday;
 }
 public void setBirthday(String birthday) {
  this.birthday = birthday;
 }
 public String getSex() {
  return sex;
 }
 public void setSex(String sex) {
  this.sex = sex;
 }

 public String getArrivalDate() {
  return arrivalDate;
 }

 public void setArrivalDate(String arrivalDate) {
  this.arrivalDate = arrivalDate;
 }

 public String getColor() {
  return color;
 }

 public void setColor(String color) {
  this.color = color;
 }

 public int getWeight() {
  return weight;
 }

 public void setWeight(int weight) {
  this.weight = weight;
 }

 public String getSpecies() {
  return species;
 }

 public void setSpecies(String origin) {
  this.species = species;
 }

 public int getAge() {
  return age;
 }

 public void setAge(int age) {
  this.age = age;
    }
    public String getIdNumber(){
     return idNumber;
    }

 public void setIdNumber(String idNumber) {
  this.idNumber = idNumber;
 }
}
