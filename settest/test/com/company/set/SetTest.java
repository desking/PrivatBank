package com.company.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dima on 15.05.17.
 */
class SetTest {
    MySet set;

    @BeforeEach
    void setUp() {
        set = new MySet();
    }

    @Test
    void TestAddOneValue() {
        String value = "test";
        assertTrue(set.add(value), "Добавление одного элемента. Должно вернуть true");

    }

    @Test
    void TestAddTwoValues() {
        String value = "test";
        set.add(value);
        assertFalse(set.add(value), "Добавление нескольких элементов. Должно вернуть true");
    }

    @Test
    void TestContains1() {
        String value = "test";
        set.add(value);
        assertTrue(set.contains(value), "Проверка содержит ли дерево значение. Должно вернуть true");
    }

    @Test
    void TestContains2() {
        String value = "test";
        set.add(value);
        assertFalse(set.contains("a"), "Проверка содержит ли дерево значение. Должно вернуть true");
    }

    @Test
    void TestIsEmpty1() {
        assertTrue(set.isEmpty(), "Проверка на пустоту. Должно вернуть true");
    }

    @Test
    void TestIsEmpty2() {

        String value = "test";
        set.add(value);
        assertFalse(set.isEmpty(), "Проверка на пустоту. Должно вернуть true");
    }

    @Test
    void TestSize1() {

        String value = "test";
        set.add(value);

        assertEquals(1, set.size(), "Проверка размера дерева. Должно вернуть true");
    }

    @Test
    void TestSize2() {

        String value = "test";
        set.add(value);
        set.add(value);

        assertEquals(1, set.size(), "Проверка размера дерева. Должно вернуть true");
    }

    @Test
    void TestSize3() {
        int size = 100;
        for (int i = 0; i < size; i++) {
            set.add(String.valueOf(i));
        }
        assertEquals(size, set.size());
    }

    @Test
    void TestSize4() {
        set.add("test1");
        set.add("test2");
        set.add("test3");
        set.add("test4");
        set.add("test5");
        set.remove("test3");
        assertEquals(4, set.size(), "Проверка размера дерева. Должно вернуть true");
    }


    @Test
    void TestGetHeightTree1() {
        String value = "test";
        set.add(value);
        assertEquals(1, set.getHeightTree(), "Проверка высоты дерева. Должно вернуть true");
    }

    @Test
    void TestGetHeightTree2() {
        String value = "test";
        set.add(value);
        set.add(value);
        assertEquals(1, set.getHeightTree(), "Проверка высоты дерева. Должно вернуть true");
    }

    @Test
    void TestGetHeightTree3() {
        set.add("test4");
        set.add("test3");
        set.add("test5");
        set.add("test1");

        assertEquals(3, set.getHeightTree(), "Проверка высоты дерева. Должно вернуть true");
    }

    private void addValueForTestHeight() {
        set.add("test1");
        set.add("test2");
        set.add("test3");
        set.add("test4");
        set.add("test5");
        set.add("test6");
        set.add("test7");
        set.add("test8");
    }

    @Test
    void TestGetHeightTree4() {
        addValueForTestHeight();

        assertEquals(4, set.getHeightTree(), "Проверка высоты дерева. Должно вернуть true");
    }


    @Test
    void TestGetHeightTree5() {
        addValueForTestHeight();
        set.remove("test4");

        assertEquals(4, set.getHeightTree(), "Проверка высоты дерева. Должно вернуть true");
    }

    @Test
    void TestGetHeightTree6() {
        addValueForTestHeight();
        set.remove("test7");

        assertEquals(3, set.getHeightTree(), "Проверка высоты дерева. Должно вернуть true");
    }

}