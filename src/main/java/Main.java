import actions.Actions;
import array.MyArrayList;

import java.util.Comparator;

import sort.QuickSort;

public class Main {

    public static void main(String[] args) {
        // Создаем список с начальной емкостью 5
        MyArrayList<Integer> list = new MyArrayList<>(5);

        // Добавляем элементы в конец списка
        Actions.add(list, 10);
        Actions.add(list, 20);
        Actions.add(list, 30);
        Actions.add(list, 40);
        Actions.add(list, 50);

        // Выводим список
        System.out.println(list);

        // Добавляем элемент по индексу
        Actions.add(list, 2, 25);
        System.out.println("Добавил под индексом 2 число 25" + list);

        // Удаляем элемент по индексу
        Actions.remove(list, 3);
        System.out.println("Удалился эл-т 3" +list);

        // Заменяем элемент по индексу
        Actions.set(list, 1, 15);
        System.out.println("Замена эл-та 1 на число 15" + list);

        // Сортируем список
        QuickSort.sort(list, Comparator.naturalOrder());
        System.out.println("сортировка вып. " + list);

        // Очищаем список
        Actions.clear(list);
        System.out.println("очистил ->" + list);

        // Пример работы с пустым списком
        MyArrayList<Integer> emptyList = new MyArrayList<>();
        System.out.println("пустой список" + emptyList);
    }
}
