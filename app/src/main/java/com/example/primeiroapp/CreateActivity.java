package com.example.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    private String nome, email, user, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //variavel recebendo valor do data
        Bundle args = getIntent().getExtras();
        nome = args.getString("nome");
        email = args.getString("email");
        user = args.getString("user");
        senha = args.getString("senha");

        //Criando a classe e setando um texto dentro do componente
        TextView createNome = (TextView) findViewById(R.id.createNome);
        createNome.setText(nome);
        TextView createEmail = (TextView) findViewById(R.id.createEmail);
        createEmail.setText(email);
        TextView createUser = (TextView) findViewById(R.id.createUser);
        createUser.setText(user);
        TextView createSenha = (TextView) findViewById(R.id.createSenha);
        createSenha.setText(senha);

        Button btnConfirm = (Button) findViewById(R.id.btnCriar);
        btnConfirm.setOnClickListener(criar());
    }

    private View.OnClickListener criar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView createNome = (TextView) findViewById(R.id.createNome);
                nome = createNome.getText().toString();
                TextView createEmail = (TextView) findViewById(R.id.createEmail);
                email = createEmail.getText().toString();
                TextView createUser = (TextView) findViewById(R.id.createUser);
                user = createUser.getText().toString();
                TextView createSenha = (TextView) findViewById(R.id.createSenha);
                senha = createSenha.getText().toString();

                Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
                btnVoltar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View args0) {
                        Intent intent = new Intent();
                        setResult(3, intent);
                        finish();
                    }
                });

                Intent intent = new Intent(CreateActivity.this, InfoActivity.class);
                startActivityForResult(intent, 3);

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
//a