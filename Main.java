// 1) Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.
// 2) Подсчитать количество вхождения каждого слова
// Пример:
// Россия идет вперед всей планеты. Планета — это не Россия.
// toLoverCase().
// (Усложнение - игнорировать пунктуацию)*




import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        //Создаем список сотрудников 
        String[] emloyees = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        // Создаем HashMap для хранения пар "имя - количество повторений"
        Map<String, Integer> counts = new HashMap<>();

             // Считаем количество повторений для каждого имени
        for (String employee: emloyees){
            // Если имя уже встречалось , увеличиваем счетчик на 1
            if (counts.containsKey(employee)){
                counts.put(employee, counts.get(employee) + 1 );
            }
            // Если имя встречается впервые , добавляем его в HashMap с счетчиком 1 
        else {
            counts.put(employee, 1);
            }
        }
        // Создаем TreeMap для сортировки пар "имя - количество повторений" по убыванию.
        Map<String, Integer>sortedCounts = new TreeMap<>((e1, e2) -> counts.get(e2).compareTo(counts.get(e1)));

        // Копируем все пары из HashMap в TreeMap
        sortedCounts.putAll(counts);

        // Выводим повторяющиеся имена с количеством повторений 
        for (Map.Entry<String, Integer>entry : sortedCounts.entrySet()){
            String name = entry.getKey();
            int count = entry.getValue();
            if (count > 1 ){
                System.out.println(name + ":" + count);
            }
        }
    }
} 