package ru.shkolaandstudents.Notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import ru.shkolaandstudents.R;

public class ActivityNotification extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button btnHelp;
    private TextView notifText;
    String text;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnHelp = findViewById(R.id.btnNotifHelp);
        SharedPreferences prefs = getSharedPreferences("notifcheck", MODE_PRIVATE);
        boolean firstSTart = prefs.getBoolean("notifcheck1", true);
        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();
        if(firstSTart) {
            showStartDialog();
        }
        notifText = findViewById(R.id.NotifSet);
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(this);
        String M1 = SP.getString("Notif123", "");
        notifText.setText(M1);
        Button btn1 = findViewById(R.id.btnNotifSet);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                showStartDialog1();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnDel = findViewById(R.id.btnDelNotif);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });

    }

    private void showStartDialog() {
        new TapTargetSequence(ActivityNotification.this)
                .targets(
                        TapTarget.forView(findViewById(R.id.btnNotifSet), getResources().getString(R.string.setnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(50)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday),
                        TapTarget.forView(findViewById(R.id.btnDelNotif), getResources().getString(R.string.delnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(50)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday))
                .listener(new TapTargetSequence.Listener() {
                    // This listener will tell us when interesting(tm) events happen in regards
                    // to the sequence
                    @Override
                    public void onSequenceFinish() {
                        SharedPreferences prefs = getSharedPreferences("notifcheck",MODE_PRIVATE);
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

    private void showStartDialog1() {
        new TapTargetSequence(ActivityNotification.this)
                .targets(
                        TapTarget.forView(findViewById(R.id.btnNotifSet), getResources().getString(R.string.setnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(50)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday),
                        TapTarget.forView(findViewById(R.id.btnDelNotif), getResources().getString(R.string.delnotif_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(50)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday))
                .listener(new TapTargetSequence.Listener() {
                    // This listener will tell us when interesting(tm) events happen in regards
                    // to the sequence
                    @Override
                    public void onSequenceFinish() {
                        // Yay
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
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        // alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) alarmManager.set(AlarmManager.RTC_WAKEUP, AlarmManager.INTERVAL_DAY, pendingIntent);;
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
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