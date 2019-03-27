public class Person implements Comparable {

    String name;
    String condition;
    String priority;

    public Person(String name, String condition, String priority){
        this.name = name;
        this.condition = condition;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        return this.priority.compareTo(((Person) o).priority);
    }
}
