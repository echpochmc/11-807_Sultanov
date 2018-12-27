import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private T[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int count = 0;
    private int capacity; // вместимость
    private static final double EXTENSION_COEF = 1.5;

    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    //@Override
    public int size() {
        int length = 0;
        for (int i = 0; i < count; i++) {
            length++;
        }
        return length;
    }

    //@Override
    public boolean contains(T index) {
        boolean output = false;
        for (T i : elements) {
            if (i == index) {
                output = true;
                break;
            } else {
                output = false;
            }
        }
        return output;
    }

    //@Override
    public void add(T e) {
        if (capacity == count) {
            grow();
        }
        elements[count++] = e;
    }

    private void grow() {
        int newCapacity = (int) (capacity * EXTENSION_COEF);
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        capacity = newCapacity;
        elements = newElements;
    }

    //@Override
    public T get(int index) throws IllegalAccessException {
        if (index < 0 || index >= count) {
            throw new IllegalAccessException("No index");
        }
        return elements[index];
    }

    //@Override
    public void remove(int index) throws IllegalAccessException {
        if (index < 0 || index >= count) {
            throw new IllegalAccessException("No index");
        }
        T[] numArr = (T[]) new Object[elements.length - 1];
        for (int i = 0; i < elements.length; i++) {
            if (i == index) {
                System.arraycopy(elements, index, numArr, 0, index);
                System.arraycopy(elements, index + 1, numArr, index, elements.length - index - 1);
            }
        }
        elements = numArr;
        //elements[index] = 0;
        /*for (int i = index; i < count-1; i++) {
            elements[i] = elements[i+1];
            count--;
        }*/
        /*for (int i = 0; i < count; i++) {
            System.out.println(elements[i]);
        }*/
    }

    //@Override
    public void addAll(MyArrayList<T> intList, int startPosition) throws IllegalAccessException {
        for (int i = 0; i < intList.size(); i++) {
            if (startPosition >= count || capacity == count) {
                grow();
            }
            elements[startPosition] = (T) intList.get(i);
            startPosition++;
        }
    }

    //@Override
    public T[] toArray() {
        //int numArr[] = new int[count];
        //System.arraycopy(elements, 0, numArr, 0, count);
        return Arrays.copyOf(elements,count);
    }

    public Iterator<T> iterator() {
        return new MyIter();
    }

    public class MyIter implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public T next() {
            return elements[currentIndex++];
        }
    }
}