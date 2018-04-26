package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogService log = new LogService(this);
        log.insert(this.getClass().getSimpleName());

        this.storage = getSharedPreferences(String.valueOf(R.string.app_name), MODE_PRIVATE);
        int time = Integer.parseInt(this.storage.getString(getString(R.string.splashScreenTimeKey), "4000"));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(it);
                finish();
            }
        }, time);
    }
}
