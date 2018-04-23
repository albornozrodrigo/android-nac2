package br.com.fiap.trabalho.rm79388;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final String DB = "RM79388";
    public static final String TABLE = "contato";
    public static final int VERSION = 1;

    public Database(Context context) {
        super(context, DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE + " (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `img` TEXT, `price` INTEGER, `points` INTEGER, `calories` INTEGER, `observations` TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}





}
