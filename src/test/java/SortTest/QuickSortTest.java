package SortTest;

import array.MyArrayList;
import sort.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link QuickSort}, проверяющие корректность сортировки.
 */
class QuickSortTest {

    /**
     * Тест на сортировку списка с несколькими элементами.
     */
    @Test
    void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.getRawArray()[0] = 30;
        list.getRawArray()[1] = 10;
        list.getRawArray()[2] = 20;
        list.upSize();
        list.upSize();
        list.upSize();

        QuickSort.sort(list, Comparator.naturalOrder());
        assertEquals("[10, 20, 30]", list.toString());
    }

    /**
     * Тест на сортировку пустого списка.
     */
    @Test
    void testSortEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        QuickSort.sort(list, Comparator.naturalOrder());
        assertEquals("[]", list.toString());
    }

    /**
     * Тест на сортировку списка с одним элементом.
     */
    @Test
    void testSortSingleElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.getRawArray()[0] = 10;
        list.upSize();

        QuickSort.sort(list, Comparator.naturalOrder());
        assertEquals("[10]", list.toString());
    }
}
