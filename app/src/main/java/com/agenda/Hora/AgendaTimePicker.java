package com.agenda.Hora;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class AgendaTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    public static class OnAgendaTimeSet {
        public void onTimeSet(Hora hora) {}
    }


    private AgendaTimePicker.OnAgendaTimeSet mOnAgendaTimeSet;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minuto = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hora, minuto, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Hora hora = new Hora(hourOfDay, minute);
        mOnAgendaTimeSet.onTimeSet(hora);
    }

    public void setOnAgendaTimeSet(OnAgendaTimeSet onAgendaTimeSet) {
        this.mOnAgendaTimeSet = onAgendaTimeSet;
    }
}
