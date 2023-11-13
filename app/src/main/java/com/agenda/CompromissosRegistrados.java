package com.agenda;

import android.icu.util.Calendar;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.agenda.Data.AgendaDatePicker;
import com.agenda.Data.Data;
import java.util.Observable;
import java.util.Observer;

public class CompromissosRegistrados extends Fragment implements Observer {


    private CompromissosRegistradosModel compromissosRegistradosModel;
    private Button botao_compromissos_hoje;
    private Button botao_compromissos_outraData;
    private TextView texto_compromissosCadastrados;
    private Data dataSelecionada;


    public CompromissosRegistrados() {}


    public static CompromissosRegistrados newInstance() {
        return new CompromissosRegistrados();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compromissos_registrados, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        compromissosRegistradosModel = new CompromissosRegistradosModel();
        compromissosRegistradosModel.addObserver(this);

        botao_compromissos_hoje = view.findViewById(R.id.botao_compromissos_hoje);
        botao_compromissos_outraData = view.findViewById(R.id.botao_compromissos_outraData);
        texto_compromissosCadastrados = view.findViewById(R.id.texto_compromissosCadastrados);

        botao_compromissos_hoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar today = Calendar.getInstance();
                int ano = today.get(java.util.Calendar.YEAR);
                int mes = today.get(java.util.Calendar.MONTH);
                int dia = today.get(java.util.Calendar.DAY_OF_MONTH);
                dataSelecionada = new Data(ano, mes + 1, dia);
                lerCompromissosRegistradosNaDataSelecionada();
            }
        });

        botao_compromissos_outraData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDatePicker(v);
            }
        });
    }


    @Override
    public void update(Observable o, Object arg) {
        // TODO atualizar dados na tela quando os dados do model mudar
    }

    public void abrirDatePicker(View v) {
        AgendaDatePicker agendaDatePicker = new AgendaDatePicker();
        agendaDatePicker.setOnAgendaDateSet(new AgendaDatePicker.OnAgendaDateSet() {
            @Override
            public void onDateSet(Data data) {
                dataSelecionada = data;
                lerCompromissosRegistradosNaDataSelecionada();
            }
        });
        agendaDatePicker.show(getChildFragmentManager(), "datePicker");
    }

    private void lerCompromissosRegistradosNaDataSelecionada() {
        // TODO ler do banco de dados e mostrar no TextView
        texto_compromissosCadastrados.setText(dataSelecionada.toString());
    }
}
