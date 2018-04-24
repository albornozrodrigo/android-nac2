package br.com.fiap.trabalho.rm79388;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RegisterMenuActivity extends AppCompatActivity {
    EditText name;
    EditText price;
    EditText points;
    EditText calories;
    EditText observations;
    MenuService menuService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu);

        this.menuService = new MenuService(this);
        this.name = findViewById(R.id.name);
        this.price = findViewById(R.id.price);
        this.points = findViewById(R.id.points);
        this.calories = findViewById(R.id.calories);
        this.observations = findViewById(R.id.observations);
    }

    public void salvar(View view) {
        String name = this.name.getText().toString();
        String price = this.price.getText().toString();
        String points = this.points.getText().toString();
        String calories = this.calories.getText().toString();
        String observations = this.observations.getText().toString();

        Menu menu = new Menu();
        menu.setName(name);
        menu.setPrice(Integer.parseInt(price));
        menu.setPoints(Integer.parseInt(points));
        menu.setCalories(Integer.parseInt(calories));
        menu.setObservations(observations);

        this.menuService.insert(menu);

        finish();
    }
}
