package queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueueTest {
    @Test
    public void isEmpty() {
        Queue<String> queue = new Queue<String>();

        assertTrue(queue.isEmpty());

        queue.enqueue("apple");
        assertTrue(queue.isEmpty() == false);
    }

    @Test
    public void size() {
        int actual; // Результат реальный
        int expended; // Результат ожидаемый
        Queue<String> queue = new Queue<String>();

        actual = queue.size();
        expended = 0;
        assertEquals(expended, actual); // Проверка на эквивалентность

        queue.enqueue("apple");
        actual = queue.size();
        expended = 1;
        assertEquals(expended, actual); // Проверка на эквивалентность

        queue.enqueue("bannana");
        actual = queue.size();
        expended = 2;
        assertEquals(expended, actual); // Проверка на эквивалентность

        queue.dequeue();
        actual = queue.size();
        expended = 1;
        assertEquals(expended, actual); // Проверка на эквивалентность

        queue.dequeue();
        actual = queue.size();
        expended = 0;
        assertEquals(expended, actual); // Проверка на эквивалентность
    }
}