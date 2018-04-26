package br.com.fiap.trabalho.rm79388;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class LogService extends Database {
    public static final String TABLE = "log";

    public LogService(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onCreate(db);
        //String sql = "CREATE TABLE " + TABLE + " (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `description` TEXT, `date` INTEGER);";
        //db.execSQL(sql);
    }

    public void insert(String activity) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("description", activity);
        cv.put("date", System.currentTimeMillis() / 1000);
        db.insert(TABLE, null, cv);
    }
}
