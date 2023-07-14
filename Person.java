import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }
}

class Tree {
    private Person root;

    public Tree(Person root) {
        this.root = root;
    }

    public Person getRoot() {
        return root;
    }
}

public class GenealogyResearchApp {
    public static void main(String[] args) {
        // Создание человеков и связей между ними
        Person person1 = new Person("Иван");
        Person person2 = new Person("Мария");
        Person person3 = new Person("Алексей");
        Person person4 = new Person("Ольга");

        person1.addChild(person2);
        person1.addChild(person3);
        person2.addChild(person4);

        // Создание дерева с корневым узлом
        Tree tree = new Tree(person1);

        // Исследование генеалогического древа
        Person selectedPerson = person1;
        List<Person> children = selectedPerson.getChildren();

        if (children.isEmpty()) {
            System.out.println("Выбранный человек не имеет детей.");
        } else {
            System.out.println("Дети выбранного человека:");

            for (Person child : children) {
                System.out.println(child.getName());
            }
        }
    }
}