package com.example.algorithms2;

import com.example.algorithms2.Service.IntegerListImp;

import static com.example.algorithms2.Service.IntegerListImp.generateRandomArray;

public class Main {
    public static void main(String[] args) {
        // Генерация массива из 100000 случайных элементов
        Integer[] array = generateRandomArray(10000);

        // Создание трех копий массива для сравнения времени сортировки
        Integer[] arrayBubble = array.clone();
        Integer[] arraySelection = array.clone();
        Integer[] arrayInsertion = array.clone();

        // Замер времени сортировки для каждого метода

        long startTime, endTime, elapsedTime;

        // Сортировка пузырьком
        startTime = System.currentTimeMillis();
        IntegerListImp.sortBubble(arrayBubble);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Время сортировки пузырьком: " + elapsedTime + " мс");

        // Сортировка выбором
        startTime = System.currentTimeMillis();
        IntegerListImp.sortSelection(arraySelection);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Время сортировки выбором: " + elapsedTime + " мс");

        // Сортировка вставкой
        startTime = System.currentTimeMillis();
        IntegerListImp.sortInsertion(arrayInsertion);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Время сортировки вставкой: " + elapsedTime + " мс");

        System.out.println("Самый быстрой метод из рассмотренных сортировок - сортировка выбором.");
    }

}
