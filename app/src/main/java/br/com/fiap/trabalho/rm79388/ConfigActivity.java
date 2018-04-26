package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigActivity extends AppCompatActivity {
    SharedPreferences storage;
    EditText splashScreenTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        this.storage = getSharedPreferences(String.valueOf(R.string.app_name), MODE_PRIVATE);
        String time = this.storage.getString("splashScreenTime", "4");
        this.splashScreenTime = findViewById(R.id.splashScreenTime);
        this.splashScreenTime.setText(time);
    }

    public void salvar(View view) {
        SharedPreferences.Editor e = this.storage.edit();

        int splashTime = Integer.parseInt(this.splashScreenTime.getText().toString());

        if(splashTime < 3000 || splashTime > 30000) {
            Toast.makeText(this, "O tempo não pode ser menor que 3 segundos e nem maior que 30 segundos", Toast.LENGTH_SHORT).show();
        } else {
            String time = String.valueOf(splashTime * 1000);

            e.putString("splashScreenTime", time);

            e.commit();

            Toast.makeText(this, "Configuração salva com sucesso", Toast.LENGTH_SHORT).show();

            finish();
        }
    }
}
