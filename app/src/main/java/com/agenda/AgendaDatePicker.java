package com.agenda;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class AgendaDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(requireContext(), this, ano, mes, dia);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Log.d("DataHora", "Ano: " + String.valueOf(year));
        Log.d("DataHora", "Mês: " + String.valueOf(month + 1));
        Log.d("DataHora", "Dia: " + String.valueOf(day));
    }
}
