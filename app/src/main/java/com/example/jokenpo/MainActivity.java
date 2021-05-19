package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){this.opcaoSelecionada("Pedra"); }
    public void selecionadoPapel(View view){this.opcaoSelecionada("Papel"); }
    public void selecionadoTesoura(View view){this.opcaoSelecionada("Tesoura");}

    public void opcaoSelecionada(String opcaoUsuario){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);
        int numero = new Random().nextInt(3);
        String opcoes[]= {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "Pedra": imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel": imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura": imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ( (opcaoApp == "Tesoura" && opcaoUsuario == "Papel") ||
             (opcaoApp == "Papel" && opcaoUsuario == "Pedra") ||
             (opcaoApp == "Pedra" && opcaoUsuario == "Tesoura")
        ) { //App ganhador
            textoResultado.setText("Você perdeu! :(\n Escolha novamente!");
        }else if( (opcaoUsuario == "Tesoura" && opcaoApp == "Papel") ||
                (opcaoUsuario == "Papel" && opcaoApp == "Pedra") ||
                (opcaoUsuario == "Pedra" && opcaoApp == "Tesoura")) {
            //Usuário ganhador
            textoResultado.setText("Você ganhou! :)\n Escolha novamente!");
        }else { //Empate
            textoResultado.setText("Empatou! :|\n Escolha novamente!");
        }
    }
}








