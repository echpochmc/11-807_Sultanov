public interface IntList {
    //возвращает количество элементов
    int size();

    //возвращает true, если такой элемент есть в списк
    boolean contains(int e);

    //добавляет новый элемент в конец списка
    void add(int e);

    //возвращает элемент по индексу
    int get(int index);

    //удаляет элемент по индексу
    void remove(int index);

    //сортирует элементы по возрастанию
    void sort();

    //добавляет в конец все элементы из данного списка
    void addAll(IntList intList);

    //добавляет в данный список все элементы из данного списка
    //начиная со startPosition
    void addAll(IntList intList, int startPosition);

    //возвращает содержимое списка в виде массива
    int[] toArray();

    //возвращает индекс первого вхождения элемента с данным значением
    int indexOf(int value);
}
