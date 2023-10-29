package com.example.algorithms2;

import com.example.algorithms2.Interface.IntegerList;
import com.example.algorithms2.Service.IntegerListImp;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringListTest {

    private IntegerList integerList;

    @Before
    public void setUp() {
        // Создаем экземпляр класса, реализующего интерфейс StringList
        // с использованием массива в качестве хранилища.
        // Задаем размер массива в конструкторе.
        integerList = new IntegerListImp(10);
    }

    @Test
    public void testAdd() {
        // Добавляем элемент в список.
        Integer item = 5;
        Integer result = integerList.add(item);

        // Проверяем, что элемент был успешно добавлен.
        assertEquals(item, result);
    }

    @Test
    public void testAddAtIndex() {
        // Добавляем элемент на определенную позицию списка.
        setupInit();
        Integer item = 1;
        int index = 1;
        Integer result = integerList.add(index, item);

        // Проверяем, что элемент был успешно добавлен на указанную позицию.
        assertEquals(item, result);
    }
    @Test
    public void addByIndex_IndexOutOfBoundsException() {

        setupInit();

        Integer add = integerList.add(1, 8);

        assertThrows(IndexOutOfBoundsException.class, () -> integerList.add(7, 8));

    }
    @Test
    public void testSet() {
        // Устанавливаем элемент на определенную позицию списка.
        setupInit();
        Integer item = 10;
        int index = 2;
        Integer result = integerList.set(index, item);

        // Проверяем, что элемент был успешно установлен на указанную позицию.
        assertEquals(item, result);
    }

    @Test
    public void testRemove() {
        // Удаляем элемент из списка.
        setupInit();
        Integer item = 4;
        Integer result = integerList.remove(item);

        // Проверяем, что элемент был успешно удален.

        assertEquals(result, item);

    }

    @Test
    public void testRemoveAtIndex() {
        // Удаляем элемент по индексу из списка.
        setupInit();
        int index = 1;
        Integer expect = 2;

        // Проверяем, что элемент был успешно удален.
        assertEquals(integerList.remove(index), expect);
    }

    @Test
    public void testContains() {
        // Проверяем, содержит ли список определенный элемент.
        setupInit();
        Integer item = 1;
        boolean result = integerList.contains(item);

        // Проверяем, что список содержит указанный элемент.
        assertTrue(result);
    }

    @Test
    public void testIndexOf() {
        // Ищем индекс элемента в списке.
        setupInit();
        Integer item = 9;
        int result = integerList.indexOf(item);

        // Проверяем, что индекс элемента найден.
        assertTrue(result >= 0);
        assertEquals(integerList.indexOf(5), 4);
    }

    @Test
    public void testLastIndexOf() {
        // Ищем индекс элемента с конца списка.
        setupInit();
        Integer item = 2;
        int result = integerList.lastIndexOf(item);

        // Проверяем, что индекс элемента найден.
        assertTrue(result >= 0);
        assertEquals(integerList.indexOf(9), 8);
    }

    @Test
    public void testGet() {
        // Получаем элемент по индексу из списка.
        setupInit();
        int index = 0;
        Integer item = 1;
        Integer result = integerList.get(index);

        // Проверяем, что элемент получен.
        assertNotNull(result);
        assertEquals(result, item);
    }

    @Test
    public void testEquals() {
        // Создаем другой список для сравнения.
        IntegerListImp otherList = new IntegerListImp(10);

        // Сравниваем текущий список с другим.
        boolean result = integerList.equals(otherList);

        // Проверяем, что списки равны.
        assertTrue(result);
    }

    @Test
    public void testSize() {
        // Получаем фактическое количество элементов в списке.
        int result = integerList.size();

        // Проверяем, что количество элементов равно ожидаемому.
        assertEquals(0, result);
    }

    @Test
    public void testIsEmpty() {
        // Проверяем, пуст ли список.
        boolean result = integerList.isEmpty();

        // Проверяем, что список пуст.
        assertTrue(result);
    }

    @Test
    public void testClear() {
        // Очищаем список.
        integerList.clear();

        // Проверяем, что список пуст.
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void testToArray() {
        // Создаем новый массив из элементов списка.
        Integer[] result = integerList.toArray();

        // Проверяем, что массив создан.
        assertNotNull(result);
    }

    private void setupInit() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
    }
}