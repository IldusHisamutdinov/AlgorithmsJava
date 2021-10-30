package lesson3;

import java.util.Arrays;
//класс для реализации дека
public class HomeworkDeque<T> {
    /*
     *Дек (deque) представляет собой двустороннюю очередь. И вставка,
     * и удаление элементов могут производиться с обоих концов.
     * Соответствующие методы могут называться insertLeft()/insertRight() и removeLeft()/removeRight().
     * Если ограничиться только методами insertLeft() и removeLeft()
     * (или их эквивалентами для правого конца), дек работает как стек.
     * Если же ограничиться методами insertLeft() и removeRight()
     * (или противоположной парой), он работает как очередь

      результат

     [1, 2, 3, 4, 5, null, 14, 13, 12, 11]
*/
    private T[] list;
    private int size;
    private int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;
    private int r;
    private int l;
    private int n;

    public HomeworkDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public HomeworkDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertLeft(T item) {
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(T item) {
        size++;
        r = nextIndexRight();
        list[r] = item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int nextIndexRight() {
        r = DEFAULT_CAPACITY - l - 1;
        l++;
        if (end == r) {
            reCapacity(15); //увеличивает массив
        }
        return r;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = begin, j = 0; j < list.length; i = nextIndex(i), j++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, 10);
        list = tempArr;
        DEFAULT_CAPACITY = newCapacity ;
    }
}
