package array;

import sort.QuickSort;

import java.util.Comparator;

/**
 * Класс для реализации динамического списка.
 * Он позволяет хранить элементы в массиве и поддерживает операции добавления, удаления,
 * изменения и получения элементов.
 *
 * @param <T> тип элементов, которые будет хранить список
 */
public class MyArrayList<T> {
    private Object[] elements;
    private int size;
    private final int DEFAULT_SIZE = 10;

    /**
     * Конструктор по умолчанию. Создает список с начальной вместимостью 10.
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    /**
     * Конструктор, позволяющий задать начальную вместимость списка.
     *
     * @param initialCapacity начальная вместимость списка
     * @throws IllegalArgumentException если начальная вместимость меньше 0
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity <=0");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Возвращает элемент на указанном индексе.
     *
     * @param index индекс элемента
     * @return элемент на указанном индексе
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    /**
     * Возвращает текущий размер списка (количество элементов).
     *
     * @return текущий размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает внутренний массив, который хранит элементы.
     *
     * @return внутренний массив
     */
    public Object[] getRawArray() {
        return elements;
    }

    /**
     * Устанавливает элемент на указанном индексе.
     *
     * @param index индекс элемента
     * @param element элемент для установки
     */
    public void setInternal(int index, T element) {
        elements[index] = element;
    }



    /**
     * Добавляет элемент в конец списка.
     *
     * Вызывает методы {@link MyArrayList#resize()} для увеличения вместимости
     * и {@link MyArrayList#upSize()} для обновления размера списка.
     *
     * @param list список, в который добавляется элемент
     * @param element элемент, который нужно добавить
     * @param <T> тип элементов списка
     */
    public static <T> void add(MyArrayList<T> list, T element) {
        if (list.size() == list.getRawArray().length) {
            list.resize();
        }
        list.setInternal(list.size(), element);
        list.upSize();
    }

    /**
     * Добавляет элемент в список на указанную позицию.
     * <p>
     * Вызывает методы {@link MyArrayList#resize()} для увеличения вместимости
     * и {@link MyArrayList#upSize()} для обновления размера списка.
     *
     * @param list список, в который добавляется элемент
     * @param index индекс, на который добавляется элемент
     * @param element элемент, который нужно добавить
     * @param <T> тип элементов списка
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public static <T> void add(MyArrayList<T> list, int index, T element) {
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] elements = list.getRawArray();
        if (list.size() == elements.length) {
            list.resize();
        }
        System.arraycopy(elements, index, elements, index + 1, list.size() - index);
        list.upSize();
        elements[index] = element;

    }

    /**
     * Удаляет элемент из списка по указанному индексу.
     * <p>
     * Вызывает метод {@link MyArrayList#downSize()} для обновления размера списка.
     *
     * @param list список, из которого нужно удалить элемент
     * @param index индекс элемента, который нужно удалить
     * @param <T> тип элементов списка
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public static <T> void remove(MyArrayList<T> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] elements = list.getRawArray();
        System.arraycopy(elements, index + 1, elements, index, list.size() - index - 1);
        elements[list.size() - 1] = null;
        list.downSize();
    }

    /**
     * Очищает список, удаляя все элементы.
     * <p>
     * Использует метод {@link MyArrayList#downSize()} для обнуления размера списка.
     *
     * @param list список, который нужно очистить
     * @param <T> тип элементов списка
     */
    public static <T> void clear(MyArrayList<T> list) {
        Object[] elements = list.getRawArray();
        for (int i = 0; i < list.size(); i++) {
            elements[i] = null;
        }
        while (list.size() > 0) {
            list.downSize();
        }
    }

    /**
     * Изменяет элемент на указанной позиции.
     * <p>
     * Использует метод {@link MyArrayList#setInternal(int, Object)} для изменения значения.
     *
     * @param list список, в котором нужно изменить элемент
     * @param index индекс элемента, который нужно изменить
     * @param element новый элемент
     * @param <T> тип элементов списка
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public static <T> void set(MyArrayList<T> list, int index, T element) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        list.setInternal(index, element);
    }

    /**
     * Сортирует список с использованием алгоритма QuickSort.
     * <p>
     * Вызывает метод {@link QuickSort#sort(MyArrayList, Comparator)} для сортировки.
     *
     * @param list список, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов
     * @param <T> тип элементов списка
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<? super T> comparator) {
        QuickSort.sort(list, comparator);
    }




    /**
     * Увеличивает вместимость массива, если он полностью заполнен.
     * Новый массив будет в два раза больше текущего.
     * <p>
     * Используется в методах {@link MyArrayList(MyArrayList, Object)} и {@link actions.Actions#add(MyArrayList, int, Object)}.
     */
    public void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * Увеличивает размер списка на 1 (увеличивает количество элементов).
     * <p>
     * Используется в методах {@link MyArrayList#add(MyArrayList, Object)} и {@link actions.Actions#add(MyArrayList, int, Object)}.
     */
    public void upSize() {
        size++;
    }

    /**
     * Уменьшает размер списка на 1 (уменьшает количество элементов).
     * <p>
     * Используется в методе {@link MyArrayList#remove(MyArrayList, int)}.
     */
    public void downSize() {
        size--;
    }

    /**
     * Возвращает строковое представление списка.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}