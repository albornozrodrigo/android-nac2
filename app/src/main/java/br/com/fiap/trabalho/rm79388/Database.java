package br.com.fiap.trabalho.rm79388;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final String DB = String.valueOf(R.string.db_name);
    public static final int VERSION = 1;

    public Database(Context context) {
        super(context, DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String menu = "CREATE TABLE menu (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `img` TEXT, `price` INTEGER, `points` INTEGER, `calories` INTEGER, `observations` TEXT);";
        String log = "CREATE TABLE log (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `description` TEXT, `date` INTEGER);";
        db.execSQL(log);
        db.execSQL(menu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
