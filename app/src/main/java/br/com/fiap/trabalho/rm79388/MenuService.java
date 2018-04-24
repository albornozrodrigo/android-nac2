package br.com.fiap.trabalho.rm79388;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MenuService extends Database {
    public static final String TABLE = "menu";

    public MenuService(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE + " (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `img` TEXT, `price` INTEGER, `points` INTEGER, `calories` INTEGER, `observations` TEXT);";
        db.execSQL(sql);
    }

    public List<Menu> list() {
        List<Menu> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[]{"id","name","img","price","points","calories","observations"}, null, null, null, null, "id");

        while(cursor.moveToNext()) {
            Menu menu = new Menu();
            menu.setId(cursor.getInt(0));
            menu.setName(cursor.getString(1));
            menu.setImg(cursor.getInt(2));
            menu.setPrice(cursor.getInt(3));
            menu.setPoints(cursor.getInt(4));
            menu.setCalories(cursor.getInt(5));
            menu.setObservations(cursor.getString(6));

            list.add(menu);
        }

        return list;
    }

    public void insert(Menu menu) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", menu.getName());
        cv.put("price", menu.getPrice());
        cv.put("img", menu.getImg());
        cv.put("points", menu.getPoints());
        cv.put("calories", menu.getCalories());
        cv.put("observations", menu.getObservations());
        db.insert(TABLE, null, cv);
    }

}
