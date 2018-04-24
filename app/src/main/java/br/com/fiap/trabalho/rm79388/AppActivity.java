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
    ListView menuListView;
    List<Menu> menuList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        this.menuService = new MenuService(this);
        this.menuListView = findViewById(R.id.menuListView);
        this.loadList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.loadList();
    }

    public void insert(View view) {
        Intent it = new Intent(this, RegisterMenuActivity.class);
        startActivity(it);
    }

    private void loadList() {
        this.menuList = this.menuService.list();

        MenuAdapter adapter = new MenuAdapter(this, this.menuList);
        this.menuListView.setAdapter(adapter);
    }

}
