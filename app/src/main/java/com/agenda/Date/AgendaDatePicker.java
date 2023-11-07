package com.agenda.Date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class AgendaDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    public static class OnAgendaDateSet {
        public void onDateSet(Data data) {}
    }


    private OnAgendaDateSet mOnAgendaDateSet;


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
        Data data = new Data(year, month, day);
        this.mOnAgendaDateSet.onDateSet(data);
    }

    public void setOnAgendaDateSet(OnAgendaDateSet onAgendaDateSet) {
        this.mOnAgendaDateSet = onAgendaDateSet;
    }
}
