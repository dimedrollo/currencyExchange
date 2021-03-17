package ru.dopegeek.currencyexchange.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "currency.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + DbSchema.ImgTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DbSchema.ImgTable.Cols.ID + ", " +
                DbSchema.ImgTable.Cols.CHARCODE + ", " +
                DbSchema.ImgTable.Cols.NOMINAL+ ", " +
                DbSchema.ImgTable.Cols.NAME + ", " +
                DbSchema.ImgTable.Cols.VALUE + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
