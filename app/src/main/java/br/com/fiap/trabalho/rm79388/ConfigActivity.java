package br.com.fiap.trabalho.rm79388;

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

        this.splashScreenTime = findViewById(R.id.splashScreenTime);
    }

    public void salvar(View view) {
        SharedPreferences.Editor e = this.storage.edit();

        String time = this.splashScreenTime.getText().toString();

        e.putString("splashScreenTime", time);

        e.commit();

        Toast.makeText(this, "Configuração salva com sucesso", Toast.LENGTH_SHORT).show();
    }
}
