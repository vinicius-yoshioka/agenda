package com.agenda;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.agenda.Date.AgendaDatePicker;
import com.agenda.Date.Data;

public class NovoCompromisso extends Fragment {

    private NovoCompromissoModel novoCompromissoModel;
    Button botao_novoCompromisso_data;
    Button botao_novoCompromisso_hora;
    EditText texto_novoCompromisso_descricao;
    Button botao_novoCompromisso_ok;


    public NovoCompromisso() {}


    public static NovoCompromisso newInstance() {
        NovoCompromisso fragment = new NovoCompromisso();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novo_compromisso, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        novoCompromissoModel = new NovoCompromissoModel();
        novoCompromissoModel.addObserver(this);

        botao_novoCompromisso_data = view.findViewById(R.id.botao_novoCompromisso_data);
        botao_novoCompromisso_hora = view.findViewById(R.id.botao_novoCompromisso_hora);
        texto_novoCompromisso_descricao = view.findViewById(R.id.texto_novoCompromisso_descricao);
        botao_novoCompromisso_ok = view.findViewById(R.id.botao_novoCompromisso_ok);

        botao_novoCompromisso_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDatePicker(v);
            }
        });

        botao_novoCompromisso_hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTimePicker(v);
            }
        });
    }


    public void abrirDatePicker(View v) {
        AgendaDatePicker agendaDatePicker = new AgendaDatePicker();
        agendaDatePicker.setOnAgendaDateSet(new AgendaDatePicker.OnAgendaDateSet() {
            @Override
            public void onDateSet(Data data) {
                novoCompromissoModel.setData(data.toString());

            }
        });
        agendaDatePicker.show(getChildFragmentManager(), "datePicker");
    }

    public void abrirTimePicker(View v) {
        DialogFragment newFragment = new AgendaTimePicker();
        newFragment.show(getChildFragmentManager(), "timePicker");
    }
}
