package ru.shkolaandstudents.Notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import ru.shkolaandstudents.R;

import static android.content.Context.MODE_PRIVATE;

public class SettingNotificationFragment extends Fragment implements TimePickerDialog.OnTimeSetListener
{
    
    Button btnHelp;
    private TextView notifText;
    String text;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.setting_notification_fragment, container, false);

        btnHelp = v.findViewById(R.id.btnNotifHelp);
        final SharedPreferences prefs = this.getActivity().getSharedPreferences("notifcheck", MODE_PRIVATE);
        boolean firstSTart = prefs.getBoolean("notifcheck1", true);
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();
        if(firstSTart) {
            new TapTargetSequence(getActivity())
                    .targets(
                            TapTarget.forView(v.findViewById(R.id.btnNotifSet), getResources().getString(R.string.setnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                    .titleTextSize(20)
                                    .titleTextColor(R.color.colorWhite)
                                    .descriptionTextColor(R.color.colorWhite)
                                    .cancelable(false)
                                    .tintTarget(false)
                                    .targetRadius(50)
                                    .transparentTarget(true)
                                    .outerCircleColor(R.color.colorTuesday),
                            TapTarget.forView(v.findViewById(R.id.btnDelNotif), getResources().getString(R.string.delnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                    .titleTextSize(20)
                                    .titleTextColor(R.color.colorWhite)
                                    .descriptionTextColor(R.color.colorWhite)
                                    .cancelable(false)
                                    .tintTarget(false)
                                    .targetRadius(50)
                                    .transparentTarget(true)
                                    .outerCircleColor(R.color.colorTuesday))
                    .listener(new TapTargetSequence.Listener() {

                        @Override
                        public void onSequenceFinish() {
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("notifcheck1", false);
                            editor.apply();
                        }

                        @Override
                        public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                        }

                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {
                            // Boo
                        }
                    }).start();
        }

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.btnNotifSet), getResources().getString(R.string.setnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(50)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnDelNotif), getResources().getString(R.string.delnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(50)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday))
                        .listener(new TapTargetSequence.Listener() {

                            @Override
                            public void onSequenceFinish() {
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("notifcheck1", false);
                                editor.apply();
                            }

                            @Override
                            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                            }

                            @Override
                            public void onSequenceCanceled(TapTarget lastTarget) {
                                // Boo
                            }
                        }).start();
            }
        });


        notifText = v.findViewById(R.id.NotifSet);
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String M1 = SP.getString("Notif123", "");
        notifText.setText(M1);
        Button btn1 = v.findViewById(R.id.btnNotifSet);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getActivity().getSupportFragmentManager(),"time picker");
            }
        });


        Button btnDel = v.findViewById(R.id.btnDelNotif);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });

        return v;
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        updateTimeText(c);
        startAlarm(c);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        Intent intent = new Intent(getActivity(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);
        alarmManager.cancel(pendingIntent);
        text = getResources().getString(R.string.NotifSetDef);
        SPEditor.putString("Notif123",text);
        SPEditor.commit();
        notifText.setText(text);
    }

    private void updateTimeText(Calendar c)
    {
        String timeText = getString(R.string.NotifSetTime);
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        text = timeText;
        SPEditor.putString("Notif123",text);
        SPEditor.commit();
        notifText.setText(timeText);
    }
}

