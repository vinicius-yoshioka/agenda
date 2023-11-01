package com.agenda;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {


    private NovoCompromissoModel novoCompromissoModel;
    private CompromissosRegistradosModel compromissosRegistradosModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        novoCompromissoModel = new NovoCompromissoModel();
        novoCompromissoModel.addObserver(this);

        compromissosRegistradosModel = new CompromissosRegistradosModel();
        compromissosRegistradosModel.addObserver(this);

        // TODO pegar os componentes da tela
    }


    @Override
    public void update(Observable o, Object arg) {
        // TODO atualizar dados na tela quando os dados do model mudar
    }
}
