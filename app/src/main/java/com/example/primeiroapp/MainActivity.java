package com.example.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // variaveis recebendo valor da tela
    private String user, senha, nome, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando a classe botao global
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(logar());
    }

    //evento do botao logar
    private View.OnClickListener logar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtUser = (TextView) findViewById(R.id.inputUser);
                user = txtUser.getText().toString();
                TextView txtSenha = (TextView) findViewById(R.id.inputSenha);
                senha = txtSenha.getText().toString();

                //verificação se user existe...
                if ("leonardo".equals(user) && "1234".equals(senha)) {
                    //...sera direcionado para tela info
                    Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                    startActivityForResult(intent, 2);

                    Bundle params = new Bundle();
                    params.putString("nome", "Leonardo Balitski");
                    params.putString("email", "leobalitski20@gmail.com");
                    params.putString("user", user);
                    params.putString("senha", senha);

                    intent.putExtras(params);
                    startActivity(intent);
                }
                //...sera direcionado para tela criar
                else {
                    Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                    startActivityForResult(intent, 2);

                    Bundle params = new Bundle();
                    params.putString("nome", nome);
                    params.putString("email", email);
                    params.putString("user", user);
                    params.putString("senha", senha);

                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        };
    }
}