package com.example.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private String nome, email, user, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle args = getIntent().getExtras();
        nome = args.getString("nome");
        email = args.getString("email");
        user = args.getString("user");
        senha = args.getString("senha");

        TextView dataNome = (TextView) findViewById(R.id.dataNome);
        dataNome.setText("Nome: " + nome);
        TextView dataEmail = (TextView) findViewById(R.id.dataEmail);
        dataEmail.setText("Email: " + email);
        TextView dataUser = (TextView) findViewById(R.id.dataUser);
        dataUser.setText("Usuario: " + user);
        TextView dataSenha = (TextView) findViewById(R.id.dataSenha);
        dataSenha.setText("Senha: " + senha);

        Button btnAlterar = (Button)findViewById(R.id.btnAlterar);
        btnAlterar.setOnClickListener(alterar());
    }

    private View.OnClickListener alterar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, CreateActivity.class);
                startActivityForResult(intent, 2);

                Bundle params = new Bundle();
                params.putString("nome", nome);
                params.putString("email", email);
                params.putString("user", user);
                params.putString("senha", senha);

                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }
}