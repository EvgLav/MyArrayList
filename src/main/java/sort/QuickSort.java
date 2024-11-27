package sort;

import array.MyArrayList;
import java.util.Comparator;

/**
 * Класс для сортировки списка с использованием алгоритма быстрой сортировки (QuickSort).
 */
public class QuickSort {

    /**
     * Сортирует переданный список с использованием алгоритма QuickSort.
     * <p>
     * Вызывает метод {@link #quickSort(MyArrayList, Comparator, int, int)} для выполнения сортировки.
     *
     * @param list список, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов
     * @param <T> тип элементов списка
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<? super T> comparator) {
        quickSort(list, comparator, 0, list.size() - 1);
    }

    /**
     * Рекурсивный метод для сортировки с использованием быстрой сортировки.
     * <p>
     * Вызывает метод {@link #partition(MyArrayList, Comparator, int, int)} для разделения списка.
     *
     * @param list список, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов
     * @param low индекс начала сортируемого подмассива
     * @param high индекс конца сортируемого подмассива
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
     * Разделяет массив на две части: одну с элементами меньше опорного, другую — с большими.
     * <p>
     * Вызывает метод {@link #swap(MyArrayList, int, int)} для обмена элементов.
     *
     * @param list список, который нужно разделить
     * @param comparator компаратор для сравнения элементов
     * @param low индекс начала раздела
     * @param high индекс конца раздела
     * @param <T> тип элементов списка
     * @return индекс опорного элемента после раздела
     */
    private static <T> int partition(MyArrayList<T> list, Comparator<? super T> comparator, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами элементы на указанных индексах.
     *
     * @param list список, в котором нужно обменять элементы
     * @param i первый индекс
     * @param j второй индекс
     * @param <T> тип элементов списка
     */
    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.setInternal(i, list.get(j));
        list.setInternal(j, temp);
    }
}