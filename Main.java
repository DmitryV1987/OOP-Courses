// Пример класса-одиночки (Singleton) с использованием наследования

public class Animal {
    public String sounds() {
        return "Животное издает звук";
    }
}

class Cat extends Animal {
    @Override
    public String sounds() {
        return "Мяу!";
    }
}

class Dog extends Animal {
    @Override
    public String sounds() {
        return "Гав!";
    }
}

class AnimalFactory {
    private static AnimalFactory instance;

    private AnimalFactory() {}

    public static AnimalFactory getInstance() {
        if (instance == null) {
            instance = new AnimalFactory();
        }
        return instance;
    }

    public Animal createAnimal(String type) {
        if ("cat".equals(type)) {
            return new Cat();
        } else if ("dog".equals(type)) {
            return new Dog();
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        AnimalFactory factory = AnimalFactory.getInstance();
        Animal cat = factory.createAnimal("cat");
        Animal dog = factory.createAnimal("dog");
        System.out.println(cat.sounds());
        System.out.println(dog.sounds());
    }
}


// В данном примере создается фабрика объектов AnimalFactory, которая является классом-одиночкой (Singleton).
// Фабрика создает объекты cat (кот) и dog (собака), наследованные от класса Animal.
// В основном классе (Main) создается экземпляр фабрики и создаются объекты cat и dog.
// Затем выводятся звуки этих животыных с помощью метода sounds(), переопределенного в классах-наследниках.