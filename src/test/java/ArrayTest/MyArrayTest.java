package ArrayTest;

import array.MyArrayList;
import org.junit.jupiter.api.Test;

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
}
