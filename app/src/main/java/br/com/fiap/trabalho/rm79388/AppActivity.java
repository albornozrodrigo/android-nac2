package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AppActivity extends AppCompatActivity {
    PizzaMenuService pizzaMenuService;
    ListView menuListView;
    List<PizzaMenu> pizzaMenuList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        LogService log = new LogService(this);
        log.insert(this.getClass().getSimpleName());

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

        this.menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PizzaMenu p = pizzaMenuList.get(position);
                openAlert(p);
            }
        });
    }

    public void openAlert(PizzaMenu p) {
        View pizzaView = getLayoutInflater().inflate(R.layout.pizza_dialog, null);
        PizzaDialogAdapter adapter = new PizzaDialogAdapter(pizzaView.getContext(), p);

        AlertDialog dialog = new AlertDialog.Builder(AppActivity.this)
                .setTitle(p.getName())
                .setView(adapter.getView(0, null,null))
                .setNegativeButton(R.string.close, null).create();

        dialog.show();
    }


    public void goToConfig(MenuItem item) {
        Intent it = new Intent(this, ConfigActivity.class);
        startActivity(it);
    }
}
