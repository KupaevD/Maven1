import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    // Проверка минимального граничного значения
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimited() {
        BonusService service = new BonusService();

        long amount = 10;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    // Работа программы с ложным значением "registered"
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimited() {
        BonusService service = new BonusService();

        long amount = 5_000;
        boolean registered = false;
        long expected = 50;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    // Работа программы с ложным значением "registered" и максимальным допустимым результатом
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 60_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    // Работа программы с ложным значением "registered" и минимальным допустимым результатом
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimitMinimal() {
        BonusService service = new BonusService();

        long amount = 50;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}
