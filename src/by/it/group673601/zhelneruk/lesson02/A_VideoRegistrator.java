package lesson02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
даны события events
реализуйте метод calcStartTimes, так, чтобы число включений регистратора на
заданный период времени (1) было минимальным, а все события events
были зарегистрированы.

Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration){
        //events - события которые нужно зарегистрировать
        //timeWorkDuration время работы видеокамеры после старта
        List<Double> result;
        result = new ArrayList<>();
        List<Double> listcache = new ArrayList<>();
        //i - это индекс события events[i]
        //комментарии от проверочного решения сохранены для подсказки, но вы можете их удалить.
                                              //подготовка к жадному поглощению массива событий
                                              //hint: сортировка Arrays.sort обеспечит скорость алгоритма
                                              //C*(n log n) + C1*n = O(n log n)

                                              //пока есть незарегистрированные события
                                                //получим одно событие по левому краю
                                                //и запомним время старта видеокамеры
                                                //вычислим момент окончания работы видеокамеры
                                                //и теперь пропустим все покрываемые события
                                                //за время до конца работы, увеличивая индекс
        int i, count = 0;
        for (i = 0; i < events.length; i++) {
            result.add(events[i]);
        }
        Collections.sort(result);
        i = 0;
        listcache.add(result.get(0));
        while (i != result.size() - 1) {
            for (int j = 0; j < result.size(); j++) {
                if (result.get(i) + workDuration >= result.get(j)) {
                    count++;
                }

            }
            if (count == result.size()) { break; }
            i = count;
            count = 0;
            listcache.add(result.get(i));
        }
        return listcache;                       //вернем итог
    }
}
