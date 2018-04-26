package br.com.fiap.trabalho.rm79388;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText login;
    EditText password;
    String loginPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogService log = new LogService(this);
        log.insert(this.getClass().getSimpleName());

        this.login = findViewById(R.id.login);
        this.password = findViewById(R.id.password);
        this.loginPass = getString(R.string.login_password);
    }

    public void login(View view) {
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();

        if(login.equals(this.loginPass) && password.equals(this.loginPass)) {
            Intent it = new Intent(this, AppActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(this, R.string.login_password_incorrect, Toast.LENGTH_SHORT).show();
        }
    }
}
