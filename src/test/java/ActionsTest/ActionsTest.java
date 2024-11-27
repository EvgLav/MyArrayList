package ActionsTest;

import array.MyArrayList;
import actions.Actions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link Actions}, проверяющие его функциональность.
 */
class ActionsTest {

    /**
     * Тест на добавление элементов в конец списка.
     */
    @Test
    void testAddToEnd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);
        Actions.add(list, 20);
        Actions.add(list, 30);

        assertEquals(3, list.size());
        assertEquals("[10, 20, 30]", list.toString());
    }

    /**
     * Тест на добавление элемента по индексу.
     */
    @Test
    void testAddByIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);
        Actions.add(list, 20);
        Actions.add(list, 30);

        Actions.add(list, 1, 15);
        assertEquals(4, list.size());
        assertEquals("[10, 15, 20, 30]", list.toString());
    }

    /**
     * Тест на ошибку при добавлении элемента по некорректному индексу.
     */
    @Test
    void testAddByIndexOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);

        assertThrows(IndexOutOfBoundsException.class, () -> Actions.add(list, 2, 20));
    }

    /**
     * Тест на удаление элемента по индексу.
     */
    @Test
    void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);
        Actions.add(list, 20);
        Actions.add(list, 30);

        Actions.remove(list, 1);
        assertEquals(2, list.size());
        assertEquals("[10, 30]", list.toString());
    }

    /**
     * Тест на ошибку при удалении элемента по некорректному индексу.
     */
    @Test
    void testRemoveOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);

        assertThrows(IndexOutOfBoundsException.class, () -> Actions.remove(list, 1));
    }

    /**
     * Тест на замену элемента по индексу.
     */
    @Test
    void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);
        Actions.add(list, 20);

        Actions.set(list, 1, 30);
        assertEquals(2, list.size());
        assertEquals("[10, 30]", list.toString());
    }

    /**
     * Тест на ошибку при замене элемента по некорректному индексу.
     */
    @Test
    void testSetOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);

        assertThrows(IndexOutOfBoundsException.class, () -> Actions.set(list, 1, 20));
    }

    /**
     * Тест на очистку списка.
     */
    @Test
    void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 10);
        Actions.add(list, 20);
        Actions.add(list, 30);

        Actions.clear(list);
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    /**
     * Тест на сортировку списка в естественном порядке.
     */
    @Test
    void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 30);
        Actions.add(list, 10);
        Actions.add(list, 20);

        Actions.sort(list, Comparator.naturalOrder());
        assertEquals("[10, 20, 30]", list.toString());
    }

    /**
     * Тест на сортировку списка с использованием пользовательского компаратора.
     */
    @Test
    void testSortWithCustomComparator() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Actions.add(list, 30);
        Actions.add(list, 10);
        Actions.add(list, 20);

        Actions.sort(list, Comparator.reverseOrder());
        assertEquals("[30, 20, 10]", list.toString());
    }
}