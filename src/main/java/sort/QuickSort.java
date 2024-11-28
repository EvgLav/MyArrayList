package sort;

import array.MyArrayList;
import java.util.Comparator;

/**
 * Реализация алгоритма быстрой сортировки QuickSort для списка MyArrayList.
 */
public class QuickSort {

    /**
     * Сортирует список с использованием алгоритма QuickSort.
     *
     * @param list список, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов
     * @param <T> тип элементов списка
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<? super T> comparator) {
        quickSort(list, comparator, 0, list.size() - 1);
    }

    /**
     * Выполняет быструю сортировку на заданном массиве.
     *
     * @param list список, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов
     * @param low индекс начала подмассива
     * @param high индекс конца подмассива
     * @param <T> тип элементов списка
     */
    private static <T> void quickSort(MyArrayList<T> list, Comparator<? super T> comparator, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, comparator, low, high);
            quickSort(list, comparator, low, pivotIndex - 1);
            quickSort(list, comparator, pivotIndex + 1, high);
        }
    }

    /**
     * Разделяет подмассив на элементы меньше и больше опорного.
     * Определяет индекс опорного элемента.
     * @param list список, который нужно разделить
     * @param comparator компаратор для сравнения элементов
     * @param low индекс начала подмассива
     * @param high индекс конца подмассива
     * @param <T> тип элементов списка
     * @return индекс опорного элемента после разделения
     */
    private static <T> int partition(MyArrayList<T> list, Comparator<? super T> comparator, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                swap(list, ++i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами два элемента списка.
     *
     * @param list список, в котором нужно обменять элементы
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     * @param <T> тип элементов списка
     */
    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.setInternal(i, list.get(j));
        list.setInternal(j, temp);
    }
}