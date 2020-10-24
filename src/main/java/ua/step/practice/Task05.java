package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;


/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество повторяющихся значений.
 * Вывести на консоль только повторяющиеся элементы (больше одного повторения)
 * и количество повторений.
 * <p>
 * Пример:
 * 0 – 5 раз
 * 2 – 3 раза
 * 7 – 2 раза
 */
public class Task05 {
    public static void main(String[] args) {
        
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        Random rnd = new Random(seed);

        int mas[] = new int[10];
        Arrays.setAll(mas, i -> rnd.nextInt((6 + 5)) - 5);
        var res = Arrays.stream(mas).sorted().toArray();

        int count = 1;
        for (int i = 8; i >= 0; i--) {
            if (res[i] == res[i + 1]) {
                ++count;
            } else {
                if (count > 1) {
                    System.out.printf(count > 1 && count < 5 ? "%d - %d раза\n" : "%d - %d раз\n", res[i + 1], count);
                }
                count = 1;
            }

        }
        if (count > 1) {
            System.out.printf(count > 1 && count < 5 ? "%d - %d раза\n" : "%d - %d раз\n", res[0], count);
        }
    }
}
