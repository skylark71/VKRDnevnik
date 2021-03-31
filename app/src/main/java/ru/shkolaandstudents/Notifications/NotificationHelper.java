package ru.shkolaandstudents.Notifications;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;

import androidx.core.app.NotificationCompat;

import ru.shkolaandstudents.ui.main.FridayFragment;
import ru.shkolaandstudents.ui.main.MondayFragment;
import ru.shkolaandstudents.ui.main.SaturdayFragment;
import ru.shkolaandstudents.ui.main.ThursdayFragment;
import ru.shkolaandstudents.ui.main.TuesdayFragment;
import ru.shkolaandstudents.ui.main.WendFragment;

import java.util.Calendar;

import ru.shkolaandstudents.R;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    //String channelname = getResources().getString(R.string.channelname);
    public final String channelName = getResources().getString(R.string.channelname);
    private NotificationManager mManager;
    SharedPreferences sPref;
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        //channel.setDescription("Уведомления");
        getManager().createNotificationChannel(channel);
    }
    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(this);
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        //понедельник
        String M1 = SP.getString("M1", "");
        String M2 = SP.getString("M2", "");
        String M3 = SP.getString("M3", "");
        String M4 = SP.getString("M4", "");
        String M5 = SP.getString("M5", "");
        String M6 = SP.getString("M6", "");
        String M7 = SP.getString("M7", "");
        String M8 = SP.getString("M8", "");
        String M1Dz = sPref.getString("M1Dz", "");
        String M2Dz = sPref.getString("M2Dz", "");
        String M3Dz = sPref.getString("M3Dz", "");
        String M4Dz = sPref.getString("M4Dz", "");
        String M5Dz = sPref.getString("M5Dz", "");
        String M6Dz = sPref.getString("M6Dz", "");
        String M7Dz = sPref.getString("M7Dz", "");
        String M8Dz = sPref.getString("M8Dz", "");
        //вторник
        String T1 = SP.getString("T1", "");
        String T2 = SP.getString("T2", "");
        String T3 = SP.getString("T3", "");
        String T4 = SP.getString("T4", "");
        String T5 = SP.getString("T5", "");
        String T6 = SP.getString("T6", "");
        String T7 = SP.getString("T7", "");
        String T8 = SP.getString("T8", "");
        String T1Dz = sPref.getString("T1Dz", "");
        String T2Dz = sPref.getString("T2Dz", "");
        String T3Dz = sPref.getString("T3Dz", "");
        String T4Dz = sPref.getString("T4Dz", "");
        String T5Dz = sPref.getString("T5Dz", "");
        String T6Dz = sPref.getString("T6Dz", "");
        String T7Dz = sPref.getString("T7Dz", "");
        String T8Dz = sPref.getString("T8Dz", "");
        //среда
        String W1 = SP.getString("W1", "");
        String W2 = SP.getString("W2", "");
        String W3 = SP.getString("W3", "");
        String W4 = SP.getString("W4", "");
        String W5 = SP.getString("W5", "");
        String W6 = SP.getString("W6", "");
        String W7 = SP.getString("W7", "");
        String W8 = SP.getString("W8", "");
        String W1Dz = sPref.getString("W1Dz", "");
        String W2Dz = sPref.getString("W2Dz", "");
        String W3Dz = sPref.getString("W3Dz", "");
        String W4Dz = sPref.getString("W4Dz", "");
        String W5Dz = sPref.getString("W5Dz", "");
        String W6Dz = sPref.getString("W6Dz", "");
        String W7Dz = sPref.getString("W7Dz", "");
        String W8Dz = sPref.getString("W8Dz", "");
        //четверг
        String Th1 = SP.getString("Th1", "");
        String Th2 = SP.getString("Th2", "");
        String Th3 = SP.getString("Th3", "");
        String Th4 = SP.getString("Th4", "");
        String Th5 = SP.getString("Th5", "");
        String Th6 = SP.getString("Th6", "");
        String Th7 = SP.getString("Th7", "");
        String Th8 = SP.getString("Th8", "");
        String Th1Dz = sPref.getString("Th1Dz", "");
        String Th2Dz = sPref.getString("Th2Dz", "");
        String Th3Dz = sPref.getString("Th3Dz", "");
        String Th4Dz = sPref.getString("Th4Dz", "");
        String Th5Dz = sPref.getString("Th5Dz", "");
        String Th6Dz = sPref.getString("Th6Dz", "");
        String Th7Dz = sPref.getString("Th7Dz", "");
        String Th8Dz = sPref.getString("Th8Dz", "");
        //пятница
        String Fr1 = SP.getString("Fr1", "");
        String Fr2 = SP.getString("Fr2", "");
        String Fr3 = SP.getString("Fr3", "");
        String Fr4 = SP.getString("Fr4", "");
        String Fr5 = SP.getString("Fr5", "");
        String Fr6 = SP.getString("Fr6", "");
        String Fr7 = SP.getString("Fr7", "");
        String Fr8 = SP.getString("Fr8", "");
        String Fr1Dz = sPref.getString("Fr1Dz", "");
        String Fr2Dz = sPref.getString("Fr2Dz", "");
        String Fr3Dz = sPref.getString("Fr3Dz", "");
        String Fr4Dz = sPref.getString("Fr4Dz", "");
        String Fr5Dz = sPref.getString("Fr5Dz", "");
        String Fr6Dz = sPref.getString("Fr6Dz", "");
        String Fr7Dz = sPref.getString("Fr7Dz", "");
        String Fr8Dz = sPref.getString("Fr8Dz", "");
        //суббота
        String Sat1 = SP.getString("Sat1", "");
        String Sat2 = SP.getString("Sat2", "");
        String Sat3 = SP.getString("Sat3", "");
        String Sat4 = SP.getString("Sat4", "");
        String Sat5 = SP.getString("Sat5", "");
        String Sat6 = SP.getString("Sat6", "");
        String Sat7 = SP.getString("Sat7", "");
        String Sat8 = SP.getString("Sat8", "");
        String Sat1Dz = sPref.getString("Sat1Dz", "");
        String Sat2Dz = sPref.getString("Sat2Dz", "");
        String Sat3Dz = sPref.getString("Sat3Dz", "");
        String Sat4Dz = sPref.getString("Sat4Dz", "");
        String Sat5Dz = sPref.getString("Sat5Dz", "");
        String Sat6Dz = sPref.getString("Sat6Dz", "");
        String Sat7Dz = sPref.getString("Sat7Dz", "");
        String Sat8Dz = sPref.getString("Sat8Dz", "");
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                Intent IntentM = new Intent(this, MondayFragment.class);
                PendingIntent resultPendingIntentM = PendingIntent.getActivity(this, 0, IntentM,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                if (M1Dz.length()==0)
                {
                    M1="";
                }
                if (M2Dz.length()==0)
                {
                    M2="";
                }
                if (M3Dz.length()==0)
                {
                    M3="";
                }
                if (M4Dz.length()==0) {
                    M4 = "";
                }
                if (M5Dz.length()==0)
                {
                    M5="";
                }
                if (M6Dz.length()==0)
                {
                    M6="";
                }
                if (M7Dz.length()==0)
                {
                    M7="";
                }
                if (M8Dz.length()==0)
                {
                    M8="";
                }
                if (M1.length()==0 & M2.length()==0 & M3.length()==0 & M4.length()==0 & M5.length()==0 & M6.length()==0 & M7.length()==0 & M8.length()==0)
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                            .setContentText(getResources().getString(R.string.notif_dz_net_text))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentM)
                            .setOnlyAlertOnce(true);
                }
                else
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_mond_title))
                            .setContentText(getResources().getString(R.string.notif_dz_mond_text))
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(M1 +" "+ M2 +" "+ M3 +" "+ M4 +" "+ M5 +" "+ M6 +" "+ M7 +" "+ M8)
                                    .setSummaryText(getResources().getString(R.string.notif_dz_ss)))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentM)
                            .setOnlyAlertOnce(true);
                }
            case Calendar.MONDAY:
                Intent IntentT = new Intent(this, TuesdayFragment.class);
                PendingIntent resultPendingIntentT = PendingIntent.getActivity(this, 0, IntentT,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                if (T1Dz.length()==0)
                {
                    T1="";
                }
                if (T2Dz.length()==0)
                {
                    T2="";
                }
                if (T3Dz.length()==0)
                {
                    T3="";
                }
                if (T4Dz.length()==0) {
                    T4 = "";
                }
                if (T5Dz.length()==0)
                {
                    T5="";
                }
                if (T6Dz.length()==0)
                {
                    T6="";
                }
                if (T7Dz.length()==0)
                {
                    T7="";
                }
                if (T8Dz.length()==0)
                {
                    T8="";
                }
                if (T1.length()==0 & T2.length()==0 & T3.length()==0 & T4.length()==0 & T5.length()==0 & T6.length()==0 & T7.length()==0 & T8.length()==0)
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                            .setContentText(getResources().getString(R.string.notif_dz_net_text))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentT)
                            .setOnlyAlertOnce(true);
                }
                else
                {

                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_tue_title))
                            .setContentText(getResources().getString(R.string.notif_dz_tue_text))
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(T1 +" "+ T2 +" "+ T3 +" "+ T4 +" "+ T5 +" "+ T6 +" "+ T7 +" "+ T8)
                                    .setSummaryText(getResources().getString(R.string.notif_dz_ss)))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setContentIntent(resultPendingIntentT)
                            .setAutoCancel(true)
                            .setOnlyAlertOnce(true);
                }

            case Calendar.TUESDAY:
                Intent IntentW = new Intent(this, WendFragment.class);
                PendingIntent resultPendingIntentW = PendingIntent.getActivity(this, 0, IntentW,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                if (W1Dz.length()==0)
                {
                    W1="";
                }
                if (W2Dz.length()==0)
                {
                    W2="";
                }
                if (W3Dz.length()==0)
                {
                    W3="";
                }
                if (W4Dz.length()==0) {
                    W4 = "";
                }
                if (W5Dz.length()==0)
                {
                    W5="";
                }
                if (W6Dz.length()==0)
                {
                    W6="";
                }
                if (W7Dz.length()==0)
                {
                    W7="";
                }
                if (W8Dz.length()==0)
                {
                    W8="";
                }
                if (W1.length()==0 & W2.length()==0 & W3.length()==0 & W4.length()==0 & W5.length()==0 & W6.length()==0 & W7.length()==0 & W8.length()==0)
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                            .setContentText(getResources().getString(R.string.notif_dz_net_text))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentW)
                            .setOnlyAlertOnce(true);
                }
                else
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_wen_title))
                            .setContentText(getResources().getString(R.string.notif_dz_wen_text))
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(W1 +" "+ W2 +" "+ W3 +" "+ W4 +" "+ W5 +" "+ W6 +" "+ W7 +" "+ W8)
                                    .setSummaryText(getResources().getString(R.string.notif_dz_ss)))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentW)
                            .setOnlyAlertOnce(true);
                }

            case Calendar.WEDNESDAY:
                Intent IntentTh = new Intent(this, ThursdayFragment.class);
                PendingIntent resultPendingIntentTh = PendingIntent.getActivity(this, 0, IntentTh,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                if (Th1Dz.length()==0)
                {
                    Th1="";
                }
                if (Th2Dz.length()==0)
                {
                    Th2="";
                }
                if (Th3Dz.length()==0)
                {
                    Th3="";
                }
                if (Th4Dz.length()==0) {
                    Th4 = "";
                }
                if (Th5Dz.length()==0)
                {
                    Th5="";
                }
                if (Th6Dz.length()==0)
                {
                    Th6="";
                }
                if (Th7Dz.length()==0)
                {
                    Th7="";
                }
                if (Th8Dz.length()==0)
                {
                    Th8="";
                }
                if (Th1.length()==0 & Th2.length()==0 & Th3.length()==0 & Th4.length()==0 & Th5.length()==0 & Th6.length()==0 & Th7.length()==0 & Th8.length()==0)
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                            .setContentText(getResources().getString(R.string.notif_dz_net_text))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setContentIntent(resultPendingIntentTh)
                            .setAutoCancel(true)
                            .setOnlyAlertOnce(true);
                }
                else
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_thu_title))
                            .setContentText(getResources().getString(R.string.notif_dz_thu_text))
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(Th1 +" "+ Th2 +" "+ Th3 +" "+ Th4 +" "+ Th5 +" "+ Th6 +" "+ Th7 +" "+ Th8)
                                    .setSummaryText(getResources().getString(R.string.notif_dz_ss)))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setContentIntent(resultPendingIntentTh)
                            .setAutoCancel(true)
                            .setOnlyAlertOnce(true);
                }

            case Calendar.THURSDAY:
                Intent IntentF = new Intent(this, FridayFragment.class);
                PendingIntent resultPendingIntentF = PendingIntent.getActivity(this, 0, IntentF,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                if (Fr1Dz.length()==0)
                {
                    Fr1="";
                }
                if (Fr2Dz.length()==0)
                {
                    Fr2="";
                }
                if (Fr3Dz.length()==0)
                {
                    Fr3="";
                }
                if (Fr4Dz.length()==0) {
                    Fr4 = "";
                }
                if (Fr5Dz.length()==0)
                {
                    Fr5="";
                }
                if (Fr6Dz.length()==0)
                {
                    Fr6="";
                }
                if (Fr7Dz.length()==0)
                {
                    Fr7="";
                }
                if (Fr8Dz.length()==0)
                {
                    Fr8="";
                }
                if (Fr1.length()==0 & Fr2.length()==0 & Fr3.length()==0 & Fr4.length()==0 & Fr5.length()==0 & Fr6.length()==0 & Fr7.length()==0 & Fr8.length()==0)
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                            .setContentText(getResources().getString(R.string.notif_dz_net_text))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentF)
                            .setOnlyAlertOnce(true);
                }
                else
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_fri_title))
                            .setContentText(getResources().getString(R.string.notif_dz_fri_text))
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(Fr1 +" "+ Fr2 +" "+ Fr3 +" "+ Fr4 +" "+ Fr5 +" "+ Fr6 +" "+ Fr7 +" "+ Fr8)
                                    .setSummaryText(getResources().getString(R.string.notif_dz_ss)))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentF)
                            .setOnlyAlertOnce(true);
                }

            case Calendar.FRIDAY:
                Intent IntentS = new Intent(this, SaturdayFragment.class);
                PendingIntent resultPendingIntentS = PendingIntent.getActivity(this, 0, IntentS,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                if (Sat1Dz.length()==0)
                {
                    Sat1="";
                }
                if (Sat2Dz.length()==0)
                {
                    Sat2="";
                }
                if (Sat3Dz.length()==0)
                {
                    Sat3="";
                }
                if (Sat4Dz.length()==0) {
                    Sat4 = "";
                }
                if (Sat5Dz.length()==0)
                {
                    Sat5="";
                }
                if (Sat6Dz.length()==0)
                {
                    Sat6="";
                }
                if (Sat7Dz.length()==0)
                {
                    Sat7="";
                }
                if (Sat8Dz.length()==0)
                {
                    Sat8="";
                }
                if (Sat1.length()==0 & Sat2.length()==0 & Sat3.length()==0 & Sat4.length()==0 & Sat5.length()==0 & Sat6.length()==0 & Sat7.length()==0 & Sat8.length()==0)
                {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                            .setContentText(getResources().getString(R.string.notif_dz_net_text))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentS)
                            .setOnlyAlertOnce(true);
                }
                else {
                    return new NotificationCompat.Builder(getApplicationContext(), channelID)
                            .setSmallIcon(R.drawable.dz)
                            .setContentTitle(getResources().getString(R.string.notif_dz_sun_title))
                            .setContentText(getResources().getString(R.string.notif_dz_sun_text))
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(Sat1 +" "+ Sat2 +" "+ Sat3 +" "+ Sat4 +" "+ Sat5 +" "+ Sat6 +" "+ Sat7 +" "+ Sat8)
                                    .setSummaryText(getResources().getString(R.string.notif_dz_ss)))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setColor(Color.GREEN)
                            .setAutoCancel(true)
                            .setContentIntent(resultPendingIntentS)
                            .setOnlyAlertOnce(true);
                }

        }
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setSmallIcon(R.drawable.dz)
                .setContentTitle(getResources().getString(R.string.notif_dz_net_title))
                .setContentText(getResources().getString(R.string.notif_dz_net_text))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.GREEN)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true);
    }
}
