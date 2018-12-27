import java.util.ArrayList;
import java.util.Arrays;

public class IntArrayList implements IntList {
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int count = 0;
    private static final double EXTENSION_COEF = 1.5;

    public IntArrayList() {
        elements = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int e) {
        for (int i:elements) {
            if(i == e)
                return true;
        }
        return false;
    }

    @Override
    public void add(int e) {
        if (capacity == count) {
            grow();
        }
        elements[count++] = e;
    }

    private void grow() {
        int newCapacity = (int) (capacity * EXTENSION_COEF);
        int[] newElements = new int[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        capacity = newCapacity;
        elements = newElements;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("No such index");
        }
        return elements[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("No such index");
        }
        for (int i = index; i < count-1; i++) {
        elements[i] = elements[i+1];
        }
        count--;
    }

    @Override
    public void sort() {
        Arrays.sort(elements);
    }


    @Override
    public void addAll(IntList intList) {
        for (int i = 0; i < intList.size(); i++) {
            add(intList.get(i));
        }
    }

    @Override
    public void addAll(IntList intList, int startPosition) {
        if (startPosition < 0 || startPosition >= intList.size()) {
            throw new IllegalArgumentException("No such index");
        }
        for (int i = startPosition; i < intList.size(); i++) {
            add(intList.get(i));
        }
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(elements, count);
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (value == elements[i])
                return i;
        }
        return -1;
    }
}
