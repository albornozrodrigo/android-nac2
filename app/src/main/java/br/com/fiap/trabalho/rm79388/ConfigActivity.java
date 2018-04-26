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

        LogService log = new LogService(this);
        log.insert(this.getClass().getSimpleName());

        this.storage = getSharedPreferences(String.valueOf(R.string.app_name), MODE_PRIVATE);
        this.splashScreenTime = findViewById(R.id.splashScreenTime);
        int time = Integer.parseInt(this.storage.getString(getString(R.string.splashScreenTimeKey), "4")) / 1000;
        this.splashScreenTime.setText(String.valueOf(time));
    }

    public void save(View view) {
        SharedPreferences.Editor e = this.storage.edit();

        int splashTime = Integer.parseInt(this.splashScreenTime.getText().toString());

        if(splashTime < 3 || splashTime > 30) {
            Toast.makeText(this, R.string.splashWarningText, Toast.LENGTH_LONG).show();
        } else {
            String time = String.valueOf(splashTime * 1000);

            e.putString(getString(R.string.splashScreenTimeKey), time);

            e.commit();

            Toast.makeText(this, R.string.splashScreenSuccessText, Toast.LENGTH_SHORT).show();

            finish();
        }
    }

    public void close(View view) {
        finish();
    }
}
