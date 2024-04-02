package zoosim;
import java.lang.Math;
/**
 *
 * @author Zeyad Abd El Aziz
 */
// Image class
/**
 * Represents an image with width and height.
 */
class Image {
    int width;
    int height;
    /**
     * Constructs an Image object with the given width and height.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

// IObject Interface
/**
 * Represents an object in the zoo that can be turned and placed.
 */
interface IObject {
     /**
     * Turns the object by the specified degrees.
     * @param degrees The degrees to turn the object.
     */
    void turn(int degrees);
     /**
     * Places the object at the specified position.
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */
    void place(int x, int y);
}

// IEntity Interface
/**
 * Represents an entity in the zoo that can move, make sounds, eat, and sleep.
 */
interface IEntity extends IObject {
     /**
     * Moves the entity.
     */
    void move();
    
    /**
     * Makes a sound.
     */
    void makeSound();
     /**
     * Feeds the entity.
     */
    void eat();
     /**
     * Makes the entity sleep.
     */
    void sleep();
}

// Animal Class
/**
 * Represents an animal in the zoo.
 */
class Animal implements IEntity {
    int id;
    String name;
    String species;
    char sex;
    int age;
    int positionX;
    int positionY;
    int size;
    int speed;
    int direction;
    int hunger;
    int fatigue;
    Image image;
    String sound;
    /**
     * Constructs an Animal object with the specified attributes.
     * @param id The ID of the animal.
     * @param name The name of the animal.
     * @param species The species of the animal.
     * @param sex The sex of the animal.
     * @param age The age of the animal.
     * @param positionX The x-coordinate position of the animal.
     * @param positionY The y-coordinate position of the animal.
     * @param size The size of the animal.
     * @param speed The speed of the animal.
     * @param direction The direction of the animal.
     * @param hunger The hunger level of the animal.
     * @param fatigue The fatigue level of the animal.
     * @param image The image of the animal.
     * @param sound The sound made by the animal.
     */
    public Animal(int id, String name, String species, char sex, int age, int positionX, int positionY, int size, int speed, int direction, int hunger, int fatigue, Image image, String sound) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.speed = speed;
        this.direction = direction;
        this.hunger = hunger;
        this.fatigue = fatigue;
        this.image = image;
        this.sound = sound;
    }
        public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public char getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public int getSize() {
        return size;
    }
    public int getSpeed() {
        return speed;
    }
    public int getDirection() {
        return direction;
    }
    public int getHunger() {
        return hunger;
    }
    public int getFatigue() {
        return fatigue;
    }
    public Image getImage() {
        return image;
    }
    public String getSound() {
        return sound;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public void turn(int degrees) {
        direction += degrees;
    }

    @Override
    public void place(int x, int y) {
        positionX = x;
        positionY = y;
    }
    @Override
    public void move() {
        double radAngle = Math.toRadians(direction);
        double difX = Math.cos(radAngle) * speed;
        double difY = Math.sin(radAngle) * speed;
        positionX += difX;
        positionY += difY;
        System.out.println(name + " moved to (" + positionX + ", " + positionY + ").");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes a sound: " + sound);
    }

    @Override
    public void eat() {
        hunger = 0;
        System.out.println(name + " eats.");
    }

    @Override
    public void sleep() {
        fatigue = 0;
        System.out.println(name + " sleeps.");
    }
}

// Behavior Interfaces
/**
 * Represents an animal that can swim.
 */
interface IFlyable {
    void fly();
     /**
     * Makes the animal fly.
     */
    void land();
     /**
     * Makes the animal land.
     */
    boolean isFlying();
     /**
     * Checks if the animal is flying.
     * @return True if the animal is flying, otherwise false.
     */
}

interface ISwimmable {
     /**
     * Checks if the animal can surface.
     * @return True if the animal can surface, otherwise false.
     */
    boolean canSurface();
}

// LandAnim Class
/**
 * Represents a land animal in the zoo.
 */
class LandAnim extends Animal {
    /**
    * Constructs a LandAnim object with the specified attributes.
    */
    public LandAnim(int id, String name, String species, char sex, int age, int positionX, int positionY, int size, int speed, int direction,int fatigue, int hunger, Image image, String sound) {
        super(id, name, species, sex, age, positionX, positionY, size, speed, direction,fatigue, hunger, image, sound);
    }
}


// BirdAnim Class
/**
 * Represents a bird in the zoo.
 */
class BirdAnim extends Animal implements IFlyable {
    boolean canFly;
    /**
     * Constructs a BirdAnim object with the specified attributes.
     */
    public BirdAnim(int id, String name, String species, char sex, int age, int positionX, int positionY, int size, int speed, int direction,int fatigue, int hunger, Image image, String sound, boolean canFly) {
        super(id, name, species, sex, age, positionX, positionY, size, speed, direction,fatigue, hunger, image, sound);
        this.canFly = canFly;
    }

    @Override
    public void fly() {
        System.out.println(name + " flies.");
    }

    @Override
    public void land() {
        System.out.println(name + " lands.");
    }

    @Override
    public boolean isFlying() {
        return canFly;
    }
}


// WaterAnim Class
/**
 * Represents a water animal in the zoo.
 */
class WaterAnim extends Animal implements ISwimmable {
    boolean canBreathe;
    /**
     * Constructs a WaterAnim object with the specified attributes.
     */
    public WaterAnim(int id, String name, String species, char sex, int age, int positionX, int positionY, int size, int speed, int direction,int fatigue, int hunger, Image image, String sound, boolean canBreathe) {
        super(id, name, species, sex, age, positionX, positionY, size, speed, direction,fatigue, hunger, image, sound);
        this.canBreathe = canBreathe;
    }

    @Override
    public boolean canSurface() {
        return canBreathe;
    }
}

// Zoo Class
/**
 * Represents a simulation of a zoo.
 */
class ZooSim {
    ArrayList<Animal> animals = new ArrayList<>();
    /**
     * Adds an animal to the zoo.
     * @param animal The animal to add.
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.name + " added to the zoo.");
    }
    /**
     * Displays statistics about the zoo.
     */
    public void displayStatistics() {
        System.out.println("Zoo Statistics:");
        System.out.println("Total number of animals: " + animals.size());
        for (Animal animal : animals) {
            System.out.println("");
            System.out.println("Animal: " + animal.getName());
            System.out.println("Species: " + animal.getSpecies());
            System.out.println("Age: " + animal.getAge());
            System.out.println("Position: (" + animal.getPositionX() + ", " + animal.getPositionY() + ")");
            System.out.println("Hunger: " + animal.getHunger());
            System.out.println("Fatigue: " + animal.getFatigue());
        }
    }
    /**
     * Feeds all hungry animals in the zoo.
     */
    public void feedAllHungryAnimals() {
        System.out.println("Feeding all hungry animals:");
        for (Animal animal : animals) {
            if (animal.getHunger() > 0) {
                // Feed the hungry animal
                animal.eat();
            }
        }
    }
    /**
     * Makes all tired animals sleep in the zoo.
     */
    public void makeAllTiredAnimalsSleep() {
        System.out.println("Making all tired animals sleep:");
        for (Animal animal : animals) {
            if (animal.getFatigue() > 0) {
                // Make the tired animal sleep
                animal.sleep();
            }
        }
    }
    /**
     * Moves all animals in the zoo.
     */
    public void moveAllAnimals() {
        System.out.println("Moving all animals:");
        for (Animal animal : animals) {
            animal.move();
        }
    }
}
/**
 * Represents other objects in the zoo such as food, rocks, and trees.
 */
class ZooObject implements IObject {
    String type;
    int positionX;
    int positionY;
    int size;
    /**
     * Constructs a ZooObject with the specified attributes.
     */
    public ZooObject(String type, int positionX, int positionY, int size) {
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
    }
    public String getType() {
        return type;
    }
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    public int getSize() {
        return size;
    }
    @Override
    public void place(int x, int y) {
        positionX = x;
        positionY = y;
    }
}

//How I would modify it
//ArrayList<Animal> predators = new ArrayList<>();
//ArrayList<Animal> herbivores = new ArrayList<>();
//ArrayList<Animal> omnivores = new ArrayList<>();
//
//// Categorize animals based on diet when adding to the zoo
//if (animal instanceof Carnivore) {
//    predators.add(animal);
//} else if (animal instanceof Omnivore) {
//    omnivores.add(animal);
//} else {
//    herbivores.add(animal);
//}
//Implement simulatePredatorPreyInteractions method
//simulatePredatorPreyInteractions() {
//    for each predator in predators {
//        for each prey in animals {
//            // Implement predator-prey interaction logic
//        }
//    }
//}