package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class AppActivity extends AppCompatActivity {
    Menu menu;
    MenuService menuService;
    ListView list;
    List<Menu> menuList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        this.menu = new Menu();
        this.menuList = menuService.list();

        ArrayAdapter<Menu> adapter = new ArrayAdapter<Menu>(this, android.R.layout.simple_expandable_list_item_1, this.menuList);
        this.list = findViewById(R.id.menuList);
        this.list.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.menuList = menuService.list();

        ArrayAdapter<Menu> adapter = new ArrayAdapter<Menu>(this, android.R.layout.simple_list_item_1, menuList);

        this.list.setAdapter(adapter);
    }

    public void insert(View view) {
        Intent it = new Intent(this, RegisterMenuActivity.class);
        startActivity(it);
    }

}
