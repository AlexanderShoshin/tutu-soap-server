package shoshin.alex.tutusoap.utils;

import shoshin.alex.tutusoap.data.Currency;
import shoshin.alex.tutusoap.data.Price;

public class TicketCalculator {
    public static Price getDefaultPrice() {
        return new Price(100, Currency.RUB);
    }
}