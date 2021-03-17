package ru.dopegeek.currencyexchange.database;

import android.database.Cursor;

import ru.dopegeek.currencyexchange.Currency;

public class MyCursorWrapper extends android.database.CursorWrapper {

    public MyCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Currency getData() {

        String id = getString(getColumnIndex(DbSchema.ImgTable.Cols.ID));
        String charCode = getString(getColumnIndex(DbSchema.ImgTable.Cols.CHARCODE));
        String nominal = getString(getColumnIndex(DbSchema.ImgTable.Cols.NOMINAL));
        String name = getString(getColumnIndex(DbSchema.ImgTable.Cols.NAME));
        String value = getString(getColumnIndex(DbSchema.ImgTable.Cols.VALUE));

        Currency currency = new Currency();
        currency.setId(id);
        currency.setCharCode(charCode);
        currency.setNominal(nominal);
        currency.setName(name);
        currency.setValue(value);
        return currency;
    }

}
