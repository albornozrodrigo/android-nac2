package br.com.fiap.trabalho.rm79388;

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
        String sql = "CREATE TABLE " + TABLE + " (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `img` TEXT, `price` INTEGER, `points` INTEGER, `calories` INTEGER, `observations` TEXT)";
        db.execSQL(sql);
    }

    public List<Menu> list() {
        List<Menu> menuList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[]{"id","name"}, null, null, null, null, "nome");

        while(cursor.moveToNext()) {
            Menu menu = new Menu();
            menu.setId(cursor.getInt(0));
            menu.setName(cursor.getString(1));

            menuList.add(menu);
        }

        return menuList;
    }
}
