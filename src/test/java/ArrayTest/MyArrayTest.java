package ArrayTest;

import array.MyArrayList;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link MyArrayList}, проверяющие его методы и логику работы.
 */
class MyArrayListTest {

    /**
     * Тест на создание списка с конструктором по умолчанию.
     */
    @Test
    void testDefaultConstructor() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    /**
     * Тест на создание списка с заданной начальной емкостью.
     */
    @Test
    void testConstructorWithCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    /**
     * Тест на ошибку при создании списка с отрицательной емкостью.
     */
    @Test
    void testConstructorWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new MyArrayList<>(-5));
    }

    /**
     * Тест на получение элемента по индексу.
     */
    @Test
    void testGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.getRawArray()[0] = 10;
        list.upSize();

        assertEquals(10, list.get(0));
    }

    /**
     * Тест на ошибку при получении элемента по некорректному индексу.
     */
    @Test
    void testGetOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    /**
     * Тест на увеличение и уменьшение емкости массива.
     */
    @Test
    void testResize() {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        list.getRawArray()[0] = 10;
        list.getRawArray()[1] = 20;
        list.upSize();
        list.upSize();

        list.resize();
        assertEquals(2, list.size());
        assertEquals(4, list.getRawArray().length); // Проверяем удвоение размера массива
    }



    /**
     * Тест на добавление элементов в конец списка.
     */
    @Test
    void testAddToEnd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);
        list.add(list, 20);
        list.add(list, 30);

        assertEquals(3, list.size());
        assertEquals("[10, 20, 30]", list.toString());
    }


    /**
     * Тест на добавление 1_000_000 значений.
     */
    @Test
    void testAddMillion() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i <1_000_000; i ++) {
            int element = i;
            list.add(list, element);
        }

        assertEquals(1_000_000, list.size());
    }

    /**
     * Тест на добавление элемента по индексу.
     */
    @Test
    void testAddByIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);
        list.add(list, 20);
        list.add(list, 30);

        list.add(list, 1, 15);
        assertEquals(4, list.size());
        assertEquals("[10, 15, 20, 30]", list.toString());
    }

    /**
     * Тест на ошибку при добавлении элемента по некорректному индексу.
     */
    @Test
    void testAddByIndexOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list, 2, 20));
    }

    /**
     * Тест на удаление элемента по индексу.
     */
    @Test
    void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);
        list.add(list, 20);
        list.add(list, 30);

        list.remove(list, 1);
        assertEquals(2, list.size());
        assertEquals("[10, 30]", list.toString());
    }

    /**
     * Тест на ошибку при удалении элемента по некорректному индексу.
     */
    @Test
    void testRemoveOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list, 1));
    }

    /**
     * Тест на замену элемента по индексу.
     */
    @Test
    void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);
        list.add(list, 20);

        list.set(list, 1, 30);
        assertEquals(2, list.size());
        assertEquals("[10, 30]", list.toString());
    }

    /**
     * Тест на ошибку при замене элемента по некорректному индексу.
     */
    @Test
    void testSetOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.set(list, 1, 20));
    }

    /**
     * Тест на очистку списка.
     */
    @Test
    void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 10);
        list.add(list, 20);
        list.add(list, 30);

        list.clear(list);
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    /**
     * Тест на сортировку списка в естественном порядке.
     */
    @Test
    void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 30);
        list.add(list, 10);
        list.add(list, 20);

        list.sort(list, Comparator.naturalOrder());
        assertEquals("[10, 20, 30]", list.toString());
    }

    /**
     * Тест на сортировку списка с использованием пользовательского компаратора.
     */
    @Test
    void testSortWithCustomComparator() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(list, 30);
        list.add(list, 10);
        list.add(list, 20);

        list.sort(list, Comparator.reverseOrder());
        assertEquals("[30, 20, 10]", list.toString());
    }
}
