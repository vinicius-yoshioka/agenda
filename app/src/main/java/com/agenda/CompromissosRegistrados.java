package com.agenda;

import android.annotation.SuppressLint;
import android.database.Cursor;
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
import com.agenda.compromisso.Compromisso;
import com.agenda.compromisso.CompromissosDb;
import com.agenda.compromisso.CompromissosDbSchema;

import java.util.ArrayList;

public class CompromissosRegistrados extends Fragment {


    private CompromissosDb compromissosDb;
    private ArrayList<Compromisso> compromissosRegistradosModel;
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

        compromissosDb = new CompromissosDb(getActivity());

        compromissosRegistradosModel = new ArrayList<>();
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
                botao_compromissos_hoje.setText(dataSelecionada.toString());
                botao_compromissos_outraData.setText("Outra data");
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


    public void abrirDatePicker(View v) {
        AgendaDatePicker agendaDatePicker = new AgendaDatePicker();
        agendaDatePicker.setOnAgendaDateSet(new AgendaDatePicker.OnAgendaDateSet() {
            @Override
            public void onDateSet(Data data) {
                dataSelecionada = data;
                botao_compromissos_hoje.setText("Hoje");
                botao_compromissos_outraData.setText(data.toString());
                lerCompromissosRegistradosNaDataSelecionada();
            }
        });
        agendaDatePicker.show(getChildFragmentManager(), "datePicker");
    }

    private void lerCompromissosRegistradosNaDataSelecionada() {
        Cursor compromissosLidos = compromissosDb.getCompromissos(dataSelecionada);

        if (compromissosLidos.getCount() == 0) {
            texto_compromissosCadastrados.setText("Nenhum compromisso cadastrado nessa data");
            return;
        }

        try {
            texto_compromissosCadastrados.setText("");

            compromissosLidos.moveToFirst();
            while (!compromissosLidos.isAfterLast()) {
                @SuppressLint("Range") int hora = compromissosLidos.getInt(compromissosLidos.getColumnIndex(CompromissosDbSchema.CompromissosRegistrados.Colunas.hora));
                @SuppressLint("Range") int minuto = compromissosLidos.getInt(compromissosLidos.getColumnIndex(CompromissosDbSchema.CompromissosRegistrados.Colunas.minuto));
                @SuppressLint("Range") String descrcao = compromissosLidos.getString(compromissosLidos.getColumnIndex(CompromissosDbSchema.CompromissosRegistrados.Colunas.descricao));

                texto_compromissosCadastrados.append(hora + ":" + minuto + "\n");
                texto_compromissosCadastrados.append(descrcao + "\n\n");

                compromissosLidos.moveToNext();
            }
        } finally {
            compromissosLidos.close();
        }
    }
}
