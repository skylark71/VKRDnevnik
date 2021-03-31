package ru.shkolaandstudents.Notifications;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import ru.shkolaandstudents.R;

public class TimePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog yourFragment = new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour, minute, true);
        yourFragment.setButton(DialogInterface.BUTTON_POSITIVE, getResources().getString(R.string.TimePicker_yes), yourFragment);
        yourFragment.setButton(DialogInterface.BUTTON_NEGATIVE, getResources().getString(R.string.TimePicker_no), yourFragment);
        return yourFragment;
    }

}
