package br.com.fiap.trabalho.rm79388;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PizzaMenuService extends Database {
    public static final String TABLE = "menu";

    public PizzaMenuService(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE + " (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `img` TEXT, `price` INTEGER, `points` INTEGER, `calories` INTEGER, `observations` TEXT);";
        db.execSQL(sql);
    }

    public List<PizzaMenu> list() {
        List<PizzaMenu> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[]{"id","name","img","price","points","calories","observations"}, null, null, null, null, "id");

        while(cursor.moveToNext()) {
            PizzaMenu pizzaMenu = new PizzaMenu();
            pizzaMenu.setId(cursor.getInt(0));
            pizzaMenu.setName(cursor.getString(1));
            pizzaMenu.setImg(cursor.getInt(2));
            pizzaMenu.setPrice(cursor.getInt(3));
            pizzaMenu.setPoints(cursor.getInt(4));
            pizzaMenu.setCalories(cursor.getInt(5));
            pizzaMenu.setObservations(cursor.getString(6));

            list.add(pizzaMenu);
        }

        PizzaMenu p1 = new PizzaMenu("Pizza Chilena", R.drawable.pizza, 40, 10, 800, "Pizza vegana");
        PizzaMenu p2 = new PizzaMenu("Mix de Cogumelos", R.drawable.pizza, 35, 10, 600, "Pizza vegana");
        PizzaMenu p3 = new PizzaMenu("Chandler Bing", R.drawable.pizza, 38, 10, 690, "Pizza vegana");
        PizzaMenu p4 = new PizzaMenu("Ross Geller", R.drawable.pizza, 46, 10, 598, "Pizza vegana");
        PizzaMenu p5 = new PizzaMenu("Barney Stinson", R.drawable.pizza, 29, 10, 780, "Pizza vegana");
        PizzaMenu p6 = new PizzaMenu("Joey Tribbiany", R.drawable.pizza, 43, 10, 650, "Pizza vegana");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        return list;
    }

    public void insert(PizzaMenu pizzaMenu) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", pizzaMenu.getName());
        cv.put("price", pizzaMenu.getPrice());
        cv.put("img", pizzaMenu.getImg());
        cv.put("points", pizzaMenu.getPoints());
        cv.put("calories", pizzaMenu.getCalories());
        cv.put("observations", pizzaMenu.getObservations());
        db.insert(TABLE, null, cv);
    }

}
