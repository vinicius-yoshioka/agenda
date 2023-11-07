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
import android.widget.TextView;
import com.agenda.Date.AgendaDatePicker;
import com.agenda.Date.Data;

public class CompromissosRegistrados extends Fragment {


    Button botao_compromissos_hoje;
    Button botao_compromissos_outraData;
    TextView texto_compromissosCadastrados;


    public CompromissosRegistrados() {}


    public static CompromissosRegistrados newInstance() {
        CompromissosRegistrados fragment = new CompromissosRegistrados();
        return fragment;
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

        botao_compromissos_hoje = view.findViewById(R.id.botao_compromissos_hoje);
        botao_compromissos_outraData = view.findViewById(R.id.botao_compromissos_outraData);
        texto_compromissosCadastrados = view.findViewById(R.id.texto_compromissosCadastrados);

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
                Log.d("onDateSet", data.toString());
            }
        });
        agendaDatePicker.show(getChildFragmentManager(), "datePicker");
    }
}
