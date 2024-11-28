package actions;

import array.MyArrayList;
import sort.QuickSort;
import java.util.Comparator;

/**
 * Класс содержит вспомогательные методы для работы с MyArrayList:
 * добавление, удаление, изменение элементов, сортировку списка.
 */
public class Actions {

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
}