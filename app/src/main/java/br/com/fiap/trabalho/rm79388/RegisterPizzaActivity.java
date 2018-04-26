package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.view.Menu;

public class RegisterPizzaActivity extends AppCompatActivity {
    EditText name;
    EditText price;
    EditText points;
    EditText calories;
    EditText observations;
    PizzaMenuService pizzaMenuService;

    public static final int PICK_IMAGE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.addPizza));
        setContentView(R.layout.activity_register_menu);

        LogService log = new LogService(this);
        log.insert(this.getClass().getSimpleName());

        this.pizzaMenuService = new PizzaMenuService(this);
        this.name = findViewById(R.id.name);
        this.price = findViewById(R.id.price);
        this.points = findViewById(R.id.points);
        this.calories = findViewById(R.id.calories);
        this.observations = findViewById(R.id.observations);
    }

    public void save(View view) {
        String name = this.name.getText().toString();
        String price = this.price.getText().toString();
        String points = this.points.getText().toString();
        String calories = this.calories.getText().toString();
        String observations = this.observations.getText().toString();

        PizzaMenu menu = new PizzaMenu();
        menu.setName(name);
        menu.setPrice(Integer.parseInt(price));
        menu.setPoints(Integer.parseInt(points));
        menu.setCalories(Integer.parseInt(calories));
        menu.setObservations(observations);

        this.pizzaMenuService.insert(menu);

        finish();
    }

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(getString(R.string.image_type));
        startActivityForResult(intent, PICK_IMAGE);
    }

    public void close(View view) {
        finish();
    }
}
