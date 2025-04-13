package ru.netology.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    //Тесты на метод compareTo
    @Test
    public void compareTicketByPriceT1LessT2() { //первый меньше второго
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 400, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);

        manager.add(ticket1);
        manager.add(ticket2);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareTicketByPriceT1MoreT2() { //первый больше второго
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 400, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);

        manager.add(ticket1);
        manager.add(ticket2);

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareTicketByPriceT1EqualsT2() { //Первый равен второму
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 400, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 400, 5, 16);

        manager.add(ticket1);
        manager.add(ticket2);

        int expected = 0;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    //Тест метода search
    @Test
    public void comparePriceToTicketAndSortSome() { //сортировка массива по цене несколько элементов
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10); //2
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 800, 3, 11); //5
        Ticket ticket4 = new Ticket("MSK", "SPB", 300, 6, 9); //3
        Ticket ticket5 = new Ticket("KXK", "MSK", 900, 2, 20);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 8, 14); //1
        Ticket ticket7 = new Ticket("KRR", "NSK", 800, 5, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 700, 9, 10);  //4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket6, ticket1, ticket4, ticket8, ticket3};
        Ticket[] actual = manager.search("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePriceToTicketAndSortZero() { //сортировка массива по цене ноль элементов
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 800, 3, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 300, 6, 9);
        Ticket ticket5 = new Ticket("KXK", "MSK", 900, 2, 20);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 8, 14);
        Ticket ticket7 = new Ticket("KRR", "NSK", 800, 5, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 700, 9, 10);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePriceToTicketAndSortOne() { //сортировка массива по цене один элемент
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 800, 3, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 300, 6, 9);
        Ticket ticket5 = new Ticket("KXK", "MSK", 900, 2, 20); //
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 8, 14);
        Ticket ticket7 = new Ticket("KRR", "NSK", 800, 5, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 700, 9, 10);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("KXK", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    // Тесты компаратора
    @Test
    public void comparatorTicketByPriceT1LessT2() { //первый меньше второго по время полета
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 400, 8, 10);  //2
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);   //11

        manager.add(ticket1);
        manager.add(ticket2);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorTicketByPriceT1MoreT2() { //первый больше второго по время полета
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 400, 8, 10); //2
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16); //11

        manager.add(ticket1);
        manager.add(ticket2);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(ticket2, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorTicketByPriceT1EqualsT2() { //Первый равен второму по впемя полета
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 400, 8, 19); //11
        Ticket ticket2 = new Ticket("MSK", "ABA", 400, 5, 16); //11

        manager.add(ticket1);
        manager.add(ticket2);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    //Тесты метода searchAndSortBy
    @Test
    public void sortTicketByComparatorSome() { //сортировка массива по времени полета с компаратором несколько элементов
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10); //2-2
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 800, 3, 11); //8-5
        Ticket ticket4 = new Ticket("MSK", "SPB", 300, 6, 9); //3-3
        Ticket ticket5 = new Ticket("KXK", "MSK", 900, 2, 20);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 8, 14); //6-4
        Ticket ticket7 = new Ticket("KRR", "NSK", 800, 5, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 700, 9, 10);  //1-1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket8, ticket1, ticket4, ticket6, ticket3};
        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketByComparatorZero() { //сортировка массива по времени полета с компаратором ноль элементов
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 800, 3, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 300, 6, 9);
        Ticket ticket5 = new Ticket("KXK", "MSK", 900, 2, 20);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 8, 14);
        Ticket ticket7 = new Ticket("KRR", "NSK", 800, 5, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 700, 9, 10);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketByComparatorOne() { //сортировка массива по времени полета с компаратором один элемент
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "ABA", 900, 5, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 800, 3, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 300, 6, 9);
        Ticket ticket5 = new Ticket("KXK", "MSK", 900, 2, 20); //
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 8, 14);
        Ticket ticket7 = new Ticket("KRR", "NSK", 800, 5, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 700, 9, 10);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchAndSortBy("KXK", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
