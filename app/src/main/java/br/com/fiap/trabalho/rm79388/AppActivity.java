package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class AppActivity extends AppCompatActivity {
    PizzaMenu pizzaMenu;
    PizzaMenuService pizzaMenuService;
    ListView menuListView;
    List<PizzaMenu> pizzaMenuList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        this.pizzaMenuService = new PizzaMenuService(this);
        this.menuListView = findViewById(R.id.menuListView);
        this.loadList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.loadList();
    }

    public void insert(View view) {
        Intent it = new Intent(this, RegisterPizzaActivity.class);
        startActivity(it);
    }

    private void loadList() {
        this.pizzaMenuList = this.pizzaMenuService.list();

        PizzaAdapter adapter = new PizzaAdapter(this, this.pizzaMenuList);
        this.menuListView.setAdapter(adapter);
    }

    public void goToConfig(MenuItem item) {
        Intent it = new Intent(this, ConfigActivity.class);
        startActivity(it);
    }
}
