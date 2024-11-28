package array;

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
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative.");
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
     * Увеличивает вместимость массива, если он полностью заполнен.
     * Новый массив будет в два раза больше текущего.
     * <p>
     * Используется в методах {@link actions.Actions#add(MyArrayList, Object)} и {@link actions.Actions#add(MyArrayList, int, Object)}.
     */
    public void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * Увеличивает размер списка на 1 (увеличивает количество элементов).
     * <p>
     * Используется в методах {@link actions.Actions#add(MyArrayList, Object)} и {@link actions.Actions#add(MyArrayList, int, Object)}.
     */
    public void upSize() {
        size++;
    }

    /**
     * Уменьшает размер списка на 1 (уменьшает количество элементов).
     * <p>
     * Используется в методе {@link actions.Actions#remove(MyArrayList, int)}.
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