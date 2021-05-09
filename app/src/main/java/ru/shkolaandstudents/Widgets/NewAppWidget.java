package ru.shkolaandstudents.Widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RemoteViews;

import ru.shkolaandstudents.R;
import ru.shkolaandstudents.ui.Students.FragmentRaspFriday;
import ru.shkolaandstudents.ui.Students.FragmentRaspMonday;
import ru.shkolaandstudents.ui.Students.FragmentRaspSaturday;
import ru.shkolaandstudents.ui.Students.FragmentRaspThursday;
import ru.shkolaandstudents.ui.Students.FragmentRaspTuesday;
import ru.shkolaandstudents.ui.Students.FragmentRaspWend;

import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        //views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(context);

            views.setTextViewText(R.id.tvBNTitle, context.getString(R.string.notif_dz_ss));
            views.setTextViewText(R.id.tvBN, context.getString(R.string.widget_caption));

            String M1 = SP.getString("M1", "");
            String M2 = SP.getString("M2", "");
            String M3 = SP.getString("M3", "");
            String M4 = SP.getString("M4", "");
            String M5 = SP.getString("M5", "");
            String M6 = SP.getString("M6", "");
            String M7 = SP.getString("M7", "");
            String M8 = SP.getString("M8", "");

            String M1Dz = SP.getString("M1Dz", "");
            String M2Dz = SP.getString("M2Dz", "");
            String M3Dz = SP.getString("M3Dz", "");
            String M4Dz = SP.getString("M4Dz", "");
            String M5Dz = SP.getString("M5Dz", "");
            String M6Dz = SP.getString("M6Dz", "");
            String M7Dz = SP.getString("M7Dz", "");
            String M8Dz = SP.getString("M8Dz", "");

            String T1 = SP.getString("T1", "");
            String T2 = SP.getString("T2", "");
            String T3 = SP.getString("T3", "");
            String T4 = SP.getString("T4", "");
            String T5 = SP.getString("T5", "");
            String T6 = SP.getString("T6", "");
            String T7 = SP.getString("T7", "");
            String T8 = SP.getString("T8", "");

            String T1Dz = SP.getString("T1Dz", "");
            String T2Dz = SP.getString("T2Dz", "");
            String T3Dz = SP.getString("T3Dz", "");
            String T4Dz = SP.getString("T4Dz", "");
            String T5Dz = SP.getString("T5Dz", "");
            String T6Dz = SP.getString("T6Dz", "");
            String T7Dz = SP.getString("T7Dz", "");
            String T8Dz = SP.getString("T8Dz", "");

            String W1 = SP.getString("W1", "");
            String W2 = SP.getString("W2", "");
            String W3 = SP.getString("W3", "");
            String W4 = SP.getString("W4", "");
            String W5 = SP.getString("W5", "");
            String W6 = SP.getString("W6", "");
            String W7 = SP.getString("W7", "");
            String W8 = SP.getString("W8", "");

            String W1Dz = SP.getString("W1Dz", "");
            String W2Dz = SP.getString("W2Dz", "");
            String W3Dz = SP.getString("W3Dz", "");
            String W4Dz = SP.getString("W4Dz", "");
            String W5Dz = SP.getString("W5Dz", "");
            String W6Dz = SP.getString("W6Dz", "");
            String W7Dz = SP.getString("W7Dz", "");
            String W8Dz = SP.getString("W8Dz", "");

            String Th1 = SP.getString("Th1", "");
            String Th2 = SP.getString("Th2", "");
            String Th3 = SP.getString("Th3", "");
            String Th4 = SP.getString("Th4", "");
            String Th5 = SP.getString("Th5", "");
            String Th6 = SP.getString("Th6", "");
            String Th7 = SP.getString("Th7", "");
            String Th8 = SP.getString("Th8", "");

            String Th1Dz = SP.getString("Th1Dz", "");
            String Th2Dz = SP.getString("Th2Dz", "");
            String Th3Dz = SP.getString("Th3Dz", "");
            String Th4Dz = SP.getString("Th4Dz", "");
            String Th5Dz = SP.getString("Th5Dz", "");
            String Th6Dz = SP.getString("Th6Dz", "");
            String Th7Dz = SP.getString("Th7Dz", "");
            String Th8Dz = SP.getString("Th8Dz", "");

            String Fr1 = SP.getString("Fr1", "");
            String Fr2 = SP.getString("Fr2", "");
            String Fr3 = SP.getString("Fr3", "");
            String Fr4 = SP.getString("Fr4", "");
            String Fr5 = SP.getString("Fr5", "");
            String Fr6 = SP.getString("Fr6", "");
            String Fr7 = SP.getString("Fr7", "");
            String Fr8 = SP.getString("Fr8", "");

            String Fr1Dz = SP.getString("Fr1Dz", "");
            String Fr2Dz = SP.getString("Fr2Dz", "");
            String Fr3Dz = SP.getString("Fr3Dz", "");
            String Fr4Dz = SP.getString("Fr4Dz", "");
            String Fr5Dz = SP.getString("Fr5Dz", "");
            String Fr6Dz = SP.getString("Fr6Dz", "");
            String Fr7Dz = SP.getString("Fr7Dz", "");
            String Fr8Dz = SP.getString("Fr8Dz", "");

            String Sat1 = SP.getString("Sat1", "");
            String Sat2 = SP.getString("Sat2", "");
            String Sat3 = SP.getString("Sat3", "");
            String Sat4 = SP.getString("Sat4", "");
            String Sat5 = SP.getString("Sat5", "");
            String Sat6 = SP.getString("Sat6", "");
            String Sat7 = SP.getString("Sat7", "");
            String Sat8 = SP.getString("Sat8", "");

            String Sat1Dz = SP.getString("Sat1Dz", "");
            String Sat2Dz = SP.getString("Sat2Dz", "");
            String Sat3Dz = SP.getString("Sat3Dz", "");
            String Sat4Dz = SP.getString("Sat4Dz", "");
            String Sat5Dz = SP.getString("Sat5Dz", "");
            String Sat6Dz = SP.getString("Sat6Dz", "");
            String Sat7Dz = SP.getString("Sat7Dz", "");
            String Sat8Dz = SP.getString("Sat8Dz", "");

            Calendar calendar = Calendar.getInstance();

            int day = calendar.get(Calendar.DAY_OF_WEEK);
            //String c_day = String.valueOf(day);
            if (day == 1) {
                Intent configIntent = new Intent(context, FragmentRaspMonday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                views.setOnClickPendingIntent(R.id.tvBNDay, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNSub1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub8, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNDz1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz8, configPendingIntent);
                //appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Monday));
                views.setTextViewText(R.id.tvNSub1, M1);
                views.setTextViewText(R.id.tvNSub2, M2);
                views.setTextViewText(R.id.tvNSub3, M3);
                views.setTextViewText(R.id.tvNSub4, M4);
                views.setTextViewText(R.id.tvNSub5, M5);
                views.setTextViewText(R.id.tvNSub6, M6);
                views.setTextViewText(R.id.tvNSub7, M7);
                views.setTextViewText(R.id.tvNSub8, M8);

                views.setTextViewText(R.id.tvNDz1, M1Dz);
                views.setTextViewText(R.id.tvNDz2, M2Dz);
                views.setTextViewText(R.id.tvNDz3, M3Dz);
                views.setTextViewText(R.id.tvNDz4, M4Dz);
                views.setTextViewText(R.id.tvNDz5, M5Dz);
                views.setTextViewText(R.id.tvNDz6, M6Dz);
                views.setTextViewText(R.id.tvNDz7, M7Dz);
                views.setTextViewText(R.id.tvNDz8, M8Dz);


                if (M1.length() == 0) {
                    views.setViewVisibility(R.id.tvNW1, View.GONE);
                    views.setViewVisibility(R.id.tvNSub1, View.GONE);
                    views.setViewVisibility(R.id.tvNDz1, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz1, View.VISIBLE);
                }

                if (M2.length() == 0) {
                    views.setViewVisibility(R.id.tvNW2, View.GONE);
                    views.setViewVisibility(R.id.tvNSub2, View.GONE);
                    views.setViewVisibility(R.id.tvNDz2, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz2, View.VISIBLE);
                }

                if (M3.length() == 0) {
                    views.setViewVisibility(R.id.tvNW3, View.GONE);
                    views.setViewVisibility(R.id.tvNSub3, View.GONE);
                    views.setViewVisibility(R.id.tvNDz3, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz3, View.VISIBLE);
                }

                if (M4.length() == 0) {
                    views.setViewVisibility(R.id.tvNW4, View.GONE);
                    views.setViewVisibility(R.id.tvNSub4, View.GONE);
                    views.setViewVisibility(R.id.tvNDz4, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz4, View.VISIBLE);
                }

                if (M5.length() == 0) {
                    views.setViewVisibility(R.id.tvNW5, View.GONE);
                    views.setViewVisibility(R.id.tvNSub5, View.GONE);
                    views.setViewVisibility(R.id.tvNDz5, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz5, View.VISIBLE);
                }

                if (M6.length() == 0) {
                    views.setViewVisibility(R.id.tvNW6, View.GONE);
                    views.setViewVisibility(R.id.tvNSub6, View.GONE);
                    views.setViewVisibility(R.id.tvNDz6, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz6, View.VISIBLE);
                }

                if (M7.length() == 0) {
                    views.setViewVisibility(R.id.tvNW7, View.GONE);
                    views.setViewVisibility(R.id.tvNSub7, View.GONE);
                    views.setViewVisibility(R.id.tvNDz7, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz7, View.VISIBLE);
                }

                if (M8.length() == 0) {
                    views.setViewVisibility(R.id.tvNW8, View.GONE);
                    views.setViewVisibility(R.id.tvNSub8, View.GONE);
                    views.setViewVisibility(R.id.tvNDz8, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz8, View.VISIBLE);
                }
            }
            //ПОНЕДЕЛЬНИК
            if (day == 2) {
                Intent configIntent = new Intent(context, FragmentRaspTuesday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                views.setOnClickPendingIntent(R.id.tvBNDay, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNSub1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub8, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNDz1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz8, configPendingIntent);
                //appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Tuesday));
                views.setTextViewText(R.id.tvNSub1, T1);
                views.setTextViewText(R.id.tvNSub2, T2);
                views.setTextViewText(R.id.tvNSub3, T3);
                views.setTextViewText(R.id.tvNSub4, T4);
                views.setTextViewText(R.id.tvNSub5, T5);
                views.setTextViewText(R.id.tvNSub6, T6);
                views.setTextViewText(R.id.tvNSub7, T7);
                views.setTextViewText(R.id.tvNSub8, T8);

                views.setTextViewText(R.id.tvNDz1, T1Dz);
                views.setTextViewText(R.id.tvNDz2, T2Dz);
                views.setTextViewText(R.id.tvNDz3, T3Dz);
                views.setTextViewText(R.id.tvNDz4, T4Dz);
                views.setTextViewText(R.id.tvNDz5, T5Dz);
                views.setTextViewText(R.id.tvNDz6, T6Dz);
                views.setTextViewText(R.id.tvNDz7, T7Dz);
                views.setTextViewText(R.id.tvNDz8, T8Dz);


                if (T1.length() == 0) {
                    views.setViewVisibility(R.id.tvNW1, View.GONE);
                    views.setViewVisibility(R.id.tvNSub1, View.GONE);
                    views.setViewVisibility(R.id.tvNDz1, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz1, View.VISIBLE);
                }

                if (T2.length() == 0) {
                    views.setViewVisibility(R.id.tvNW2, View.GONE);
                    views.setViewVisibility(R.id.tvNSub2, View.GONE);
                    views.setViewVisibility(R.id.tvNDz2, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz2, View.VISIBLE);
                }

                if (T3.length() == 0) {
                    views.setViewVisibility(R.id.tvNW3, View.GONE);
                    views.setViewVisibility(R.id.tvNSub3, View.GONE);
                    views.setViewVisibility(R.id.tvNDz3, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz3, View.VISIBLE);
                }

                if (T4.length() == 0) {
                    views.setViewVisibility(R.id.tvNW4, View.GONE);
                    views.setViewVisibility(R.id.tvNSub4, View.GONE);
                    views.setViewVisibility(R.id.tvNDz4, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz4, View.VISIBLE);
                }

                if (T5.length() == 0) {
                    views.setViewVisibility(R.id.tvNW5, View.GONE);
                    views.setViewVisibility(R.id.tvNSub5, View.GONE);
                    views.setViewVisibility(R.id.tvNDz5, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz5, View.VISIBLE);
                }

                if (T6.length() == 0) {
                    views.setViewVisibility(R.id.tvNW6, View.GONE);
                    views.setViewVisibility(R.id.tvNSub6, View.GONE);
                    views.setViewVisibility(R.id.tvNDz6, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz6, View.VISIBLE);
                }

                if (T7.length() == 0) {
                    views.setViewVisibility(R.id.tvNW7, View.GONE);
                    views.setViewVisibility(R.id.tvNSub7, View.GONE);
                    views.setViewVisibility(R.id.tvNDz7, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz7, View.VISIBLE);
                }

                if (T8.length() == 0) {
                    views.setViewVisibility(R.id.tvNW8, View.GONE);
                    views.setViewVisibility(R.id.tvNSub8, View.GONE);
                    views.setViewVisibility(R.id.tvNDz8, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz8, View.VISIBLE);
                }
            }
            //Вторник
            if (day == 3) {
                Intent configIntent = new Intent(context, FragmentRaspWend.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                views.setOnClickPendingIntent(R.id.tvBNDay, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNSub1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub8, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNDz1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz8, configPendingIntent);
                //appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Wend));
                views.setTextViewText(R.id.tvNSub1, W1);
                views.setTextViewText(R.id.tvNSub2, W2);
                views.setTextViewText(R.id.tvNSub3, W3);
                views.setTextViewText(R.id.tvNSub4, W4);
                views.setTextViewText(R.id.tvNSub5, W5);
                views.setTextViewText(R.id.tvNSub6, W6);
                views.setTextViewText(R.id.tvNSub7, W7);
                views.setTextViewText(R.id.tvNSub8, W8);

                views.setTextViewText(R.id.tvNDz1, W1Dz);
                views.setTextViewText(R.id.tvNDz2, W2Dz);
                views.setTextViewText(R.id.tvNDz3, W3Dz);
                views.setTextViewText(R.id.tvNDz4, W4Dz);
                views.setTextViewText(R.id.tvNDz5, W5Dz);
                views.setTextViewText(R.id.tvNDz6, W6Dz);
                views.setTextViewText(R.id.tvNDz7, W7Dz);
                views.setTextViewText(R.id.tvNDz8, W8Dz);


                if (W1.length() == 0) {
                    views.setViewVisibility(R.id.tvNW1, View.GONE);
                    views.setViewVisibility(R.id.tvNSub1, View.GONE);
                    views.setViewVisibility(R.id.tvNDz1, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz1, View.VISIBLE);
                }

                if (W2.length() == 0) {
                    views.setViewVisibility(R.id.tvNW2, View.GONE);
                    views.setViewVisibility(R.id.tvNSub2, View.GONE);
                    views.setViewVisibility(R.id.tvNDz2, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz2, View.VISIBLE);
                }

                if (W3.length() == 0) {
                    views.setViewVisibility(R.id.tvNW3, View.GONE);
                    views.setViewVisibility(R.id.tvNSub3, View.GONE);
                    views.setViewVisibility(R.id.tvNDz3, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz3, View.VISIBLE);
                }

                if (W4.length() == 0) {
                    views.setViewVisibility(R.id.tvNW4, View.GONE);
                    views.setViewVisibility(R.id.tvNSub4, View.GONE);
                    views.setViewVisibility(R.id.tvNDz4, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz4, View.VISIBLE);
                }

                if (W5.length() == 0) {
                    views.setViewVisibility(R.id.tvNW5, View.GONE);
                    views.setViewVisibility(R.id.tvNSub5, View.GONE);
                    views.setViewVisibility(R.id.tvNDz5, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz5, View.VISIBLE);
                }

                if (W6.length() == 0) {
                    views.setViewVisibility(R.id.tvNW6, View.GONE);
                    views.setViewVisibility(R.id.tvNSub6, View.GONE);
                    views.setViewVisibility(R.id.tvNDz6, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz6, View.VISIBLE);
                }

                if (W7.length() == 0) {
                    views.setViewVisibility(R.id.tvNW7, View.GONE);
                    views.setViewVisibility(R.id.tvNSub7, View.GONE);
                    views.setViewVisibility(R.id.tvNDz7, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz7, View.VISIBLE);
                }

                if (W8.length() == 0) {
                    views.setViewVisibility(R.id.tvNW8, View.GONE);
                    views.setViewVisibility(R.id.tvNSub8, View.GONE);
                    views.setViewVisibility(R.id.tvNDz8, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz8, View.VISIBLE);
                }
            }
            //Среда
            if(day == 4) {
                Intent configIntent = new Intent(context, FragmentRaspThursday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                views.setOnClickPendingIntent(R.id.tvBNDay, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNSub1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub8, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNDz1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz8, configPendingIntent);
                //appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Thr));
                views.setTextViewText(R.id.tvNSub1, Th1);
                views.setTextViewText(R.id.tvNSub2, Th2);
                views.setTextViewText(R.id.tvNSub3, Th3);
                views.setTextViewText(R.id.tvNSub4, Th4);
                views.setTextViewText(R.id.tvNSub5, Th5);
                views.setTextViewText(R.id.tvNSub6, Th6);
                views.setTextViewText(R.id.tvNSub7, Th7);
                views.setTextViewText(R.id.tvNSub8, Th8);

                views.setTextViewText(R.id.tvNDz1, Th1Dz);
                views.setTextViewText(R.id.tvNDz2, Th2Dz);
                views.setTextViewText(R.id.tvNDz3, Th3Dz);
                views.setTextViewText(R.id.tvNDz4, Th4Dz);
                views.setTextViewText(R.id.tvNDz5, Th5Dz);
                views.setTextViewText(R.id.tvNDz6, Th6Dz);
                views.setTextViewText(R.id.tvNDz7, Th7Dz);
                views.setTextViewText(R.id.tvNDz8, Th8Dz);


                if (Th1.length() == 0) {
                    views.setViewVisibility(R.id.tvNW1, View.GONE);
                    views.setViewVisibility(R.id.tvNSub1, View.GONE);
                    views.setViewVisibility(R.id.tvNDz1, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz1, View.VISIBLE);
                }

                if (Th2.length() == 0) {
                    views.setViewVisibility(R.id.tvNW2, View.GONE);
                    views.setViewVisibility(R.id.tvNSub2, View.GONE);
                    views.setViewVisibility(R.id.tvNDz2, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz2, View.VISIBLE);
                }

                if (Th3.length() == 0) {
                    views.setViewVisibility(R.id.tvNW3, View.GONE);
                    views.setViewVisibility(R.id.tvNSub3, View.GONE);
                    views.setViewVisibility(R.id.tvNDz3, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz3, View.VISIBLE);
                }

                if (Th4.length() == 0) {
                    views.setViewVisibility(R.id.tvNW4, View.GONE);
                    views.setViewVisibility(R.id.tvNSub4, View.GONE);
                    views.setViewVisibility(R.id.tvNDz4, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz4, View.VISIBLE);
                }

                if (Th5.length() == 0) {
                    views.setViewVisibility(R.id.tvNW5, View.GONE);
                    views.setViewVisibility(R.id.tvNSub5, View.GONE);
                    views.setViewVisibility(R.id.tvNDz5, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz5, View.VISIBLE);
                }

                if (Th6.length() == 0) {
                    views.setViewVisibility(R.id.tvNW6, View.GONE);
                    views.setViewVisibility(R.id.tvNSub6, View.GONE);
                    views.setViewVisibility(R.id.tvNDz6, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz6, View.VISIBLE);
                }

                if (Th7.length() == 0) {
                    views.setViewVisibility(R.id.tvNW7, View.GONE);
                    views.setViewVisibility(R.id.tvNSub7, View.GONE);
                    views.setViewVisibility(R.id.tvNDz7, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz7, View.VISIBLE);
                }

                if (Th8.length() == 0) {
                    views.setViewVisibility(R.id.tvNW8, View.GONE);
                    views.setViewVisibility(R.id.tvNSub8, View.GONE);
                    views.setViewVisibility(R.id.tvNDz8, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz8, View.VISIBLE);
                }
            }
            //Четверг
            if(day == 5) {
                Intent configIntent = new Intent(context, FragmentRaspFriday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                views.setOnClickPendingIntent(R.id.tvBNDay, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNSub1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub8, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNDz1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz8, configPendingIntent);
                //appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Friady));
                views.setTextViewText(R.id.tvNSub1, Fr1);
                views.setTextViewText(R.id.tvNSub2, Fr2);
                views.setTextViewText(R.id.tvNSub3, Fr3);
                views.setTextViewText(R.id.tvNSub4, Fr4);
                views.setTextViewText(R.id.tvNSub5, Fr5);
                views.setTextViewText(R.id.tvNSub6, Fr6);
                views.setTextViewText(R.id.tvNSub7, Fr7);
                views.setTextViewText(R.id.tvNSub8, Fr8);

                views.setTextViewText(R.id.tvNDz1, Fr1Dz);
                views.setTextViewText(R.id.tvNDz2, Fr2Dz);
                views.setTextViewText(R.id.tvNDz3, Fr3Dz);
                views.setTextViewText(R.id.tvNDz4, Fr4Dz);
                views.setTextViewText(R.id.tvNDz5, Fr5Dz);
                views.setTextViewText(R.id.tvNDz6, Fr6Dz);
                views.setTextViewText(R.id.tvNDz7, Fr7Dz);
                views.setTextViewText(R.id.tvNDz8, Fr8Dz);

                if (Fr1.length() == 0) {
                    views.setViewVisibility(R.id.tvNW1, View.GONE);
                    views.setViewVisibility(R.id.tvNSub1, View.GONE);
                    views.setViewVisibility(R.id.tvNDz1, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz1, View.VISIBLE);
                }

                if (Fr2.length() == 0) {
                    views.setViewVisibility(R.id.tvNW2, View.GONE);
                    views.setViewVisibility(R.id.tvNSub2, View.GONE);
                    views.setViewVisibility(R.id.tvNDz2, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz2, View.VISIBLE);
                }

                if (Fr3.length() == 0) {
                    views.setViewVisibility(R.id.tvNW3, View.GONE);
                    views.setViewVisibility(R.id.tvNSub3, View.GONE);
                    views.setViewVisibility(R.id.tvNDz3, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz3, View.VISIBLE);
                }

                if (Fr4.length() == 0) {
                    views.setViewVisibility(R.id.tvNW4, View.GONE);
                    views.setViewVisibility(R.id.tvNSub4, View.GONE);
                    views.setViewVisibility(R.id.tvNDz4, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz4, View.VISIBLE);
                }

                if (Fr5.length() == 0) {
                    views.setViewVisibility(R.id.tvNW5, View.GONE);
                    views.setViewVisibility(R.id.tvNSub5, View.GONE);
                    views.setViewVisibility(R.id.tvNDz5, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz5, View.VISIBLE);
                }

                if (Fr6.length() == 0) {
                    views.setViewVisibility(R.id.tvNW6, View.GONE);
                    views.setViewVisibility(R.id.tvNSub6, View.GONE);
                    views.setViewVisibility(R.id.tvNDz6, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz6, View.VISIBLE);
                }

                if (Fr7.length() == 0) {
                    views.setViewVisibility(R.id.tvNW7, View.GONE);
                    views.setViewVisibility(R.id.tvNSub7, View.GONE);
                    views.setViewVisibility(R.id.tvNDz7, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz7, View.VISIBLE);
                }

                if (Fr8.length() == 0) {
                    views.setViewVisibility(R.id.tvNW8, View.GONE);
                    views.setViewVisibility(R.id.tvNSub8, View.GONE);
                    views.setViewVisibility(R.id.tvNDz8, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz8, View.VISIBLE);
                }
            }
            //Пятница
            if(day == 6) {
                Intent configIntent = new Intent(context, FragmentRaspSaturday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                views.setOnClickPendingIntent(R.id.tvBNDay, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNSub1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNSub8, configPendingIntent);

                views.setOnClickPendingIntent(R.id.tvNDz1, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz2, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz3, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz4, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz5, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz6, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz7, configPendingIntent);
                views.setOnClickPendingIntent(R.id.tvNDz8, configPendingIntent);
                //appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Sat));
                views.setTextViewText(R.id.tvNSub1, Sat1);
                views.setTextViewText(R.id.tvNSub2, Sat2);
                views.setTextViewText(R.id.tvNSub3, Sat3);
                views.setTextViewText(R.id.tvNSub4, Sat4);
                views.setTextViewText(R.id.tvNSub5, Sat5);
                views.setTextViewText(R.id.tvNSub6, Sat6);
                views.setTextViewText(R.id.tvNSub7, Sat7);
                views.setTextViewText(R.id.tvNSub8, Sat8);

                views.setTextViewText(R.id.tvNDz1, Sat1Dz);
                views.setTextViewText(R.id.tvNDz2, Sat2Dz);
                views.setTextViewText(R.id.tvNDz3, Sat3Dz);
                views.setTextViewText(R.id.tvNDz4, Sat4Dz);
                views.setTextViewText(R.id.tvNDz5, Sat5Dz);
                views.setTextViewText(R.id.tvNDz6, Sat6Dz);
                views.setTextViewText(R.id.tvNDz7, Sat7Dz);
                views.setTextViewText(R.id.tvNDz8, Sat8Dz);

                if (Sat1.length() == 0) {
                    views.setViewVisibility(R.id.tvNW1, View.GONE);
                    views.setViewVisibility(R.id.tvNSub1, View.GONE);
                    views.setViewVisibility(R.id.tvNDz1, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz1, View.VISIBLE);
                }

                if (Sat2.length() == 0) {
                    views.setViewVisibility(R.id.tvNW2, View.GONE);
                    views.setViewVisibility(R.id.tvNSub2, View.GONE);
                    views.setViewVisibility(R.id.tvNDz2, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz2, View.VISIBLE);
                }

                if (Sat3.length() == 0) {
                    views.setViewVisibility(R.id.tvNW3, View.GONE);
                    views.setViewVisibility(R.id.tvNSub3, View.GONE);
                    views.setViewVisibility(R.id.tvNDz3, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz3, View.VISIBLE);
                }

                if (Sat4.length() == 0) {
                    views.setViewVisibility(R.id.tvNW4, View.GONE);
                    views.setViewVisibility(R.id.tvNSub4, View.GONE);
                    views.setViewVisibility(R.id.tvNDz4, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz4, View.VISIBLE);
                }

                if (Sat5.length() == 0) {
                    views.setViewVisibility(R.id.tvNW5, View.GONE);
                    views.setViewVisibility(R.id.tvNSub5, View.GONE);
                    views.setViewVisibility(R.id.tvNDz5, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz5, View.VISIBLE);
                }

                if (Sat6.length() == 0) {
                    views.setViewVisibility(R.id.tvNW6, View.GONE);
                    views.setViewVisibility(R.id.tvNSub6, View.GONE);
                    views.setViewVisibility(R.id.tvNDz6, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz6, View.VISIBLE);
                }

                if (Sat7.length() == 0) {
                    views.setViewVisibility(R.id.tvNW7, View.GONE);
                    views.setViewVisibility(R.id.tvNSub7, View.GONE);
                    views.setViewVisibility(R.id.tvNDz7, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz7, View.VISIBLE);
                }

                if (Sat8.length() == 0) {
                    views.setViewVisibility(R.id.tvNW8, View.GONE);
                    views.setViewVisibility(R.id.tvNSub8, View.GONE);
                    views.setViewVisibility(R.id.tvNDz8, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvNW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNSub8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvNDz8, View.VISIBLE);
                }
            }
            //Суббота
            if(day == 7) {

                views.setTextViewText(R.id.tvBNDay, context.getString(R.string.Voskr));
                views.setTextViewText(R.id.tvNSub1, context.getString(R.string.notif_dz_net_title));
                views.setTextViewText(R.id.tvNDz1, context.getString(R.string.notif_dz_net_text));

                views.setViewVisibility(R.id.tvNW1, View.GONE);

                views.setViewVisibility(R.id.tvNW2, View.GONE);
                views.setViewVisibility(R.id.tvNSub2, View.GONE);
                views.setViewVisibility(R.id.tvNDz2, View.GONE);

                views.setViewVisibility(R.id.tvNW3, View.GONE);
                views.setViewVisibility(R.id.tvNSub3, View.GONE);
                views.setViewVisibility(R.id.tvNDz3, View.GONE);

                views.setViewVisibility(R.id.tvNW4, View.GONE);
                views.setViewVisibility(R.id.tvNSub4, View.GONE);
                views.setViewVisibility(R.id.tvNDz4, View.GONE);

                views.setViewVisibility(R.id.tvNW5, View.GONE);
                views.setViewVisibility(R.id.tvNSub5, View.GONE);
                views.setViewVisibility(R.id.tvNDz5, View.GONE);

                views.setViewVisibility(R.id.tvNW6, View.GONE);
                views.setViewVisibility(R.id.tvNSub6, View.GONE);
                views.setViewVisibility(R.id.tvNDz6, View.GONE);

                views.setViewVisibility(R.id.tvNW7, View.GONE);
                views.setViewVisibility(R.id.tvNSub7, View.GONE);
                views.setViewVisibility(R.id.tvNDz7, View.GONE);

                views.setViewVisibility(R.id.tvNW8, View.GONE);
                views.setViewVisibility(R.id.tvNSub8, View.GONE);
                views.setViewVisibility(R.id.tvNDz8, View.GONE);
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

