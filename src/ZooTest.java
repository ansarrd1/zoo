import java.util.ArrayList; // importing the module to implement ArrayList
class Animal { // creating Animal class
    // declaring variables of the Animal
    protected String name;
    protected int weight;
    protected String food;
    protected int foodQuantity;
    protected String environment;
    protected int area;

    // implementing GETTERS and SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) { // if incorrect values are given, setter method will give default values
        if(weight <= 0) {
            this.weight = 50;
        } else {
            this.weight = weight;
        }
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        if(foodQuantity <= 0) {
            this.foodQuantity = 20;
        } else {
            this.foodQuantity = foodQuantity;
        }
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        if(area <= 0) {
            this.area = 500;
        } else {
            this.area = area;
        }
    }

    // default constructor
    Animal() {
        this.name = "Lion";
        this.weight = 200;
        this.food = "meat";
        this.foodQuantity = 250;
        this.environment = "grassland";
        this.area = 1000;
    }

    // parametrized constructor
    Animal(String name, int weight, String food, int foodQuantity, String environment, int area) {
        this.name = name;
        this.weight = weight;
        this.food = food;
        this.foodQuantity = foodQuantity;
        this.environment = environment;
        this.area = area;
    }

    // toString method that returns string that explains characteristics of each animal
    public String toString() {
        return getName() + " weights " + getWeight() + "kg, eats " + getFoodQuantity() + " units of " + getFood() + " and lives in the " + getArea() + "m^2 " + getEnvironment() + ".\n";
    }
}

class Zoo {
    ArrayList<Animal> listOfAnimals = new ArrayList<Animal>(); // declaring ArrayList

    // addAnimal(Animal) adds animals to the arraylist
    public void addAnimal(Animal a) {
        listOfAnimals.add(a);
    }

    // numOfAnimals returns the number of all animals in the arrayList
    public int numOfAnimals() {
        return listOfAnimals.size();
    }

    public String toString() {
        String lst = "";
        for (Animal listOfAnimal : listOfAnimals) {
            lst += listOfAnimal.toString();
        }
        return lst;
    }

    // totalFoodNeeded returns number of animals that eats passed string(meat/fish/leaves)
    public int totalFoodNeeded(String str) {
        int totalFood = 0;
        for (Animal listOfAnimal : listOfAnimals) {
            if (listOfAnimal.food.equals(str)) {
                totalFood += listOfAnimal.foodQuantity;
            }
        }
        return totalFood;
    }

    public int totalSqMetersNeeded(String str) {
        int totalArea = 0;
        for(Animal listOfAnimal : listOfAnimals) {
            if(listOfAnimal.environment.equals(str)) {
                totalArea += listOfAnimal.area;
            }
        }
        return totalArea;
    }
}

class Giraffe extends Animal {
    Giraffe() {
        name = "Giraffe";
        weight = 1900;
        foodQuantity = 300;
        food = "leaves";
        area = 1500;
        environment = "grassland";
    }
}

class Tiger extends Animal {
    Tiger() {
        name = "Tiger";
        weight = 150;
        foodQuantity = 200;
        food = "meat";
        area = 1000;
        environment = "grassland";
    }
}

class Penguin extends Animal {
    Penguin() {
        name = "Penguin";
        weight = 35;
        foodQuantity = 15;
        food = "fishes";
        area = 20;
        environment = "water";
    }
}

class Wolf extends Animal {
    Wolf() {
        name = "Wolf";
        weight = 50;
        foodQuantity = 10;
        food = "meat";
        area = 700;
        environment = "grassland";
    }
}



public class ZooTest {
    public static void main(String[] args) {

        // 1. declaring all animals(objects) using the non-parametrized constructors of child classes
        Penguin pen = new Penguin();
        Penguin pen1 = new Penguin();

        Tiger tiger = new Tiger();
        Tiger tiger1 = new Tiger();
        Tiger tiger2 = new Tiger();

        Giraffe giraffe = new Giraffe();
        Giraffe giraffe1 = new Giraffe();

        Wolf wolf = new Wolf();


        // 2. declaring an animal using the default constructor of super class
        Animal lion = new Animal();
        // default constructor gives the name 'Lion' and its characteristics


        // 3. declaring an animal using the parametrized constructor of super class
        Animal fox = new Animal("Fox", 500, "leaves", 1000, "water", 5);
        // I created Fox animal(object) with its characteristics


        // let's change the characteristics of the fox using SETTERS because I gave the inappropriate characteristics
        fox.setName("Foxiffy"); // gave the fox a name
        fox.setArea(500);
        fox.setFood("meat");
        fox.setWeight(-500); // I gave incorrect value, but setWeight(int) method gives default value[50]
        fox.setEnvironment("grassland");
        fox.setFoodQuantity(100);

        System.out.println("Wight of the fox: " + fox.getWeight()); // to show the effect of setWeight method
        // should print 50

        // creating Zoo class object which is an arraylist that will contain all animals and their characteristics
        Zoo arrayAnimals = new Zoo();
        arrayAnimals.addAnimal(tiger);
        arrayAnimals.addAnimal(tiger1);
        tiger1.setName("Tiger1");
        arrayAnimals.addAnimal(tiger2);
        tiger2.setName("Tiger2");
        arrayAnimals.addAnimal(pen);
        arrayAnimals.addAnimal(pen1);
        pen1.setName("Penguin1");
        arrayAnimals.addAnimal(giraffe);
        arrayAnimals.addAnimal(giraffe1);
        giraffe1.setName("Giraffe1");
        arrayAnimals.addAnimal(wolf);
        arrayAnimals.addAnimal(fox);
        arrayAnimals.addAnimal(lion);


        // print all animals and their characteristics
        System.out.println(arrayAnimals.toString());


        // let's test the number of all animals(should be 10)
        System.out.println("The number of all animals is: " + arrayAnimals.numOfAnimals());

        int meatAmount = (int) (arrayAnimals.totalFoodNeeded("meat"));
        int fishAmount = (int) (arrayAnimals.totalFoodNeeded("fishes"));
        int leavesAmount = (int) (arrayAnimals.totalFoodNeeded("leaves"));
        System.out.println("You need " + fishAmount + " fish units today."); // should print 30
        System.out.println("You need " + meatAmount + " meat units today."); // should print 960
        System.out.println("You need " + leavesAmount + " leaves units today."); // should print 600
        int grasslandAmount = (arrayAnimals.totalSqMetersNeeded("grassland"));
        int waterAmount = arrayAnimals.totalSqMetersNeeded("water");
        System.out.println("You need " + grasslandAmount + "m^2 grassland for your zoo."); // should print 8200
        System.out.println("You need " + waterAmount + "m^2 water for your zoo."); // should print 40
    }
}