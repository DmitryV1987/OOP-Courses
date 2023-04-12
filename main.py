class Animal:
    def sounds(self):
        return "Животное издает звук"


class Cat(Animal):
    def sounds(self):
        return "Мяу!"


class Dog(Animal):
    def sounds(self):
        return "Гав!"


class AnimalFactory:
    _instance = None

    def __init__(self):
        if self._instance is not None:
            raise ValueError("Ошибка: Экземпляр класса уже существует")
        self._instance = self

    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = AnimalFactory()
        return cls._instance

    def create_animal(self, animal_type):
        if animal_type == "cat":
            return Cat()
        elif animal_type == "dog":
            return Dog()
        return None


if __name__ == "__main__":
    factory = AnimalFactory.get_instance()
    cat = factory.create_animal("cat")
    dog = factory.create_animal("dog")
    print(cat.sounds())
    print(dog.sounds())
