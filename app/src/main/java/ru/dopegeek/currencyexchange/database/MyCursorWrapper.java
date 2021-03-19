package ru.dopegeek.currencyexchange.database;

import android.database.Cursor;


import ru.dopegeek.currencyexchange.Currency;
import ru.dopegeek.currencyexchange.Valute;

public class MyCursorWrapper extends android.database.CursorWrapper {

    public MyCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Currency getData() {

        String charCode = getString(getColumnIndex(DbSchema.CurrencyTable.Cols.CHARCODE));
        String nominal = getString(getColumnIndex(DbSchema.CurrencyTable.Cols.NOMINAL));
        String name = getString(getColumnIndex(DbSchema.CurrencyTable.Cols.NAME));
        String value = getString(getColumnIndex(DbSchema.CurrencyTable.Cols.VALUE));

        Currency currency = new Currency();
        currency.setCharCode(charCode);
        currency.setNominal(Integer.parseInt(nominal));
        currency.setName(name);
        currency.setValue(Float.parseFloat(value));
        return currency;
    }

}
