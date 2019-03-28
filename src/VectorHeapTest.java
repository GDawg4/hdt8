import org.junit.Assert;
import org.junit.Test;


class VectorHeapTest {

    @Test
    void add() {
        VectorHeap<Person> testVector = new VectorHeap<>();
        Assert.assertEquals(testVector.size(), 0);
        testVector.add(new Person("Test", "Catarro", "A"));
        Assert.assertEquals(testVector.size(), 1);
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
        VectorHeap<Person> testVector = new VectorHeap<>();
        Assert.assertEquals(testVector.size(), 0);
        testVector.add(new Person("Test1", "Catarro", "A"));
        Assert.assertEquals(testVector.size(), 1);
        testVector.add(new Person("Test2", "Tos", "B"));
        Assert.assertEquals(testVector.size(), 2);
        testVector.add(new Person("Test3", "Dolor general", "C"));
        Assert.assertEquals(testVector.size(), 3);
    }

    @Test
    void clear() {
        VectorHeap<Person> testVector = new VectorHeap<>();
        testVector.add(new Person("Test1", "Catarro", "A"));
        testVector.add(new Person("Test2", "Tos", "B"));
        testVector.add(new Person("Test3", "Dolor general", "C"));
        Assert.assertEquals(testVector.size(), 3);
        testVector.clear();
        Assert.assertEquals(testVector.size(), 0);
    }

    @Test
    void getFirst() {
        VectorHeap<Person> testVector = new VectorHeap<>();
        testVector.add(new Person("Test3", "Dolor general", "C"));
        testVector.add(new Person("Test2", "Tos", "B"));
        testVector.add(new Person("Test1", "Catarro", "A"));
        testVector.add(new Person("Test4", "Dolor general", "D"));
        Assert.assertEquals(testVector.size(), 4);
        Assert.assertEquals(testVector.getFirst().name, "test1");
    }

    @Test
    void remove() {
        VectorHeap<Person> testVector = new VectorHeap<>();
        testVector.add(new Person("Test3", "Dolor general", "C"));
        testVector.add(new Person("Test2", "Tos", "B"));
        testVector.add(new Person("Test1", "Catarro", "A"));
        testVector.add(new Person("Test4", "Dolor general", "D"));
        Assert.assertEquals(testVector.size(), 4);
        Assert.assertEquals(testVector.getFirst().name, "test1");
        testVector.remove();
        Assert.assertEquals(testVector.getFirst().name, "test2");
    }
}