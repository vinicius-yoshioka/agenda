package com.agenda;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.agenda.Date.AgendaDatePicker;
import com.agenda.Date.Data;
import com.agenda.Hora.AgendaTimePicker;
import com.agenda.Hora.Hora;
import com.agenda.compromisso.Compromisso;

public class NovoCompromisso extends Fragment {


    private Compromisso novoCompromissoModel;
    private Button botao_novoCompromisso_data;
    private Button botao_novoCompromisso_hora;
    private EditText texto_novoCompromisso_descricao;
    private Button botao_novoCompromisso_ok;


    public NovoCompromisso() {}


    public static NovoCompromisso newInstance() {
        return new NovoCompromisso();
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

        novoCompromissoModel = new Compromisso();
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

        botao_novoCompromisso_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCompromisso();
            }
        });
    }


    public void abrirDatePicker(View v) {
        AgendaDatePicker agendaDatePicker = new AgendaDatePicker();
        agendaDatePicker.setOnAgendaDateSet(new AgendaDatePicker.OnAgendaDateSet() {
            @Override
            public void onDateSet(Data data) {
                novoCompromissoModel.setData(data);
                botao_novoCompromisso_data.setText(data.toString());
            }
        });
        agendaDatePicker.show(getChildFragmentManager(), "datePicker");
    }

    public void abrirTimePicker(View v) {
        AgendaTimePicker agendaTimePicker = new AgendaTimePicker();
        agendaTimePicker.setOnAgendaTimeSet(new AgendaTimePicker.OnAgendaTimeSet() {
            @Override
            public void onTimeSet(Hora hora) {
                novoCompromissoModel.setHora(hora);
                botao_novoCompromisso_hora.setText(hora.toString());
            }
        });
        agendaTimePicker.show(getChildFragmentManager(), "timePicker");
    }

    public void addCompromisso() {
        String descricao = texto_novoCompromisso_descricao.getText().toString();
        novoCompromissoModel.setDescricao(descricao);

        Toast.makeText(getContext(), novoCompromissoModel.toString(), Toast.LENGTH_LONG).show();
        Log.d("NovoCompromisso", novoCompromissoModel.toString());
    }
}
