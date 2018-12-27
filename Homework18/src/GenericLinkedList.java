import java.util.Iterator;

public class GenericLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int count = 0;

    public int size() {
        return count;
    }

    //добавление в конец
    public void add(T e) {
        Node<T> nod = new Node<>();
        nod.setValue(e);
        nod.setNext(null);
        if (head != null) {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nod);
        } else {
            head = nod;
        }
        count++;
    }

    public boolean contains(T value) {
        if (head == null) {
            return false;
        }
        Node<T> param = head;
        while (param != null) {
            if (param.getValue() == value) {
                return true;
            }
            param = param.getNext();
        }
        return false;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[count];
        Node<T> param = head;
        for (int i = 0; i < count; i++) {
            arr[i] = param.getValue();
            param = param.getNext();
        }
        return arr;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("No index: " + index);
        }
        Node<T> param = head;
        for (int i = 0; i < index; i++) {
            param = param.getNext();
        }
        return param.getValue();
    }

    public void addAll(GenericLinkedList<T> myLinkedList) {
        T[] arr = myLinkedList.toArray();
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + " вне границ");
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> beforeRemovable = head;
            for (int i = 0; i < index - 1; i++) {
                beforeRemovable = beforeRemovable.getNext();
            }
            Node<T> nodeToRemove = beforeRemovable.getNext();
            beforeRemovable.setNext(nodeToRemove.getNext());
        }
        count--;
    }
    public Iterator<T> iterator() {
        return new MyIter();
    }

    public class MyIter implements Iterator<T> {
        private Node<T> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode.getNext() != null;
        }

        @Override
        public T next() {
            T next = currentNode.getNext().getValue();
            currentNode = currentNode.getNext();
            return next;
        }
    }
}
