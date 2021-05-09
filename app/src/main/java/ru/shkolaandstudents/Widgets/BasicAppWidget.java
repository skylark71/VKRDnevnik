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
public class BasicAppWidget extends AppWidgetProvider {

    SharedPreferences.Editor SPEditor;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(context);

            views.setTextViewText(R.id.tvBWTitle, context.getString(R.string.widget_rasp));
            views.setTextViewText(R.id.tvBW, context.getString(R.string.widget_caption));

            //SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0)
            String M1 = SP.getString("M1", "");
            String M2 = SP.getString("M2", "");
            String M3 = SP.getString("M3", "");
            String M4 = SP.getString("M4", "");
            String M5 = SP.getString("M5", "");
            String M6 = SP.getString("M6", "");
            String M7 = SP.getString("M7", "");
            String M8 = SP.getString("M8", "");

            String T1 = SP.getString("T1", "");
            String T2 = SP.getString("T2", "");
            String T3 = SP.getString("T3", "");
            String T4 = SP.getString("T4", "");
            String T5 = SP.getString("T5", "");
            String T6 = SP.getString("T6", "");
            String T7 = SP.getString("T7", "");
            String T8 = SP.getString("T8", "");

            String W1 = SP.getString("W1", "");
            String W2 = SP.getString("W2", "");
            String W3 = SP.getString("W3", "");
            String W4 = SP.getString("W4", "");
            String W5 = SP.getString("W5", "");
            String W6 = SP.getString("W6", "");
            String W7 = SP.getString("W7", "");
            String W8 = SP.getString("W8", "");

            String Th1 = SP.getString("Th1", "");
            String Th2 = SP.getString("Th2", "");
            String Th3 = SP.getString("Th3", "");
            String Th4 = SP.getString("Th4", "");
            String Th5 = SP.getString("Th5", "");
            String Th6 = SP.getString("Th6", "");
            String Th7 = SP.getString("Th7", "");
            String Th8 = SP.getString("Th8", "");

            String Fr1 = SP.getString("Fr1", "");
            String Fr2 = SP.getString("Fr2", "");
            String Fr3 = SP.getString("Fr3", "");
            String Fr4 = SP.getString("Fr4", "");
            String Fr5 = SP.getString("Fr5", "");
            String Fr6 = SP.getString("Fr6", "");
            String Fr7 = SP.getString("Fr7", "");
            String Fr8 = SP.getString("Fr8", "");

            String Sat1 = SP.getString("Sat1", "");
            String Sat2 = SP.getString("Sat2", "");
            String Sat3 = SP.getString("Sat3", "");
            String Sat4 = SP.getString("Sat4", "");
            String Sat5 = SP.getString("Sat5", "");
            String Sat6 = SP.getString("Sat6", "");
            String Sat7 = SP.getString("Sat7", "");
            String Sat8 = SP.getString("Sat8", "");

            String T11 = SP.getString("T11", "");
            String T12 = SP.getString("T12", "");
            String T13 = SP.getString("T13", "");
            String T14 = SP.getString("T14", "");

            String T21 = SP.getString("T21", "");
            String T22 = SP.getString("T22", "");
            String T23 = SP.getString("T23", "");
            String T24 = SP.getString("T24", "");

            String T31 = SP.getString("T31", "");
            String T32 = SP.getString("T32", "");
            String T33 = SP.getString("T33", "");
            String T34 = SP.getString("T34", "");

            String T41 = SP.getString("T41", "");
            String T42 = SP.getString("T42", "");
            String T43 = SP.getString("T43", "");
            String T44 = SP.getString("T44", "");

            String T51 = SP.getString("T51", "");
            String T52 = SP.getString("T52", "");
            String T53 = SP.getString("T53", "");
            String T54 = SP.getString("T54", "");

            String T61 = SP.getString("T61", "");
            String T62 = SP.getString("T62", "");
            String T63 = SP.getString("T63", "");
            String T64 = SP.getString("T64", "");

            String T71 = SP.getString("T71", "");
            String T72 = SP.getString("T72", "");
            String T73 = SP.getString("T73", "");
            String T74 = SP.getString("T74", "");

            String T81 = SP.getString("T81", "");
            String T82 = SP.getString("T82", "");
            String T83 = SP.getString("T83", "");
            String T84 = SP.getString("T84", "");

            //RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);

            views.setTextViewText(R.id.tvTimeBW1, T11);
            views.setTextViewText(R.id.tvTimeBW2, T12);
            views.setTextViewText(R.id.tvTimeBW3, T13);
            views.setTextViewText(R.id.tvTimeBW4, T14);

            views.setTextViewText(R.id.tvTimeBW5, T21);
            views.setTextViewText(R.id.tvTimeBW6, T22);
            views.setTextViewText(R.id.tvTimeBW7, T23);
            views.setTextViewText(R.id.tvTimeBW8, T24);

            views.setTextViewText(R.id.tvTimeBW9, T31);
            views.setTextViewText(R.id.tvTimeBW10, T32);
            views.setTextViewText(R.id.tvTimeBW111, T33);
            views.setTextViewText(R.id.tvTimeBW12, T34);

            views.setTextViewText(R.id.tvTimeBW13, T41);
            views.setTextViewText(R.id.tvTimeBW14, T42);
            views.setTextViewText(R.id.tvTimeBW15, T43);
            views.setTextViewText(R.id.tvTimeBW16, T44);

            views.setTextViewText(R.id.tvTimeBW17, T51);
            views.setTextViewText(R.id.tvTimeBW18, T52);
            views.setTextViewText(R.id.tvTimeBW19, T53);
            views.setTextViewText(R.id.tvTimeBW20, T54);

            views.setTextViewText(R.id.tvTimeBW21, T61);
            views.setTextViewText(R.id.tvTimeBW222, T62);
            views.setTextViewText(R.id.tvTimeBW23, T63);
            views.setTextViewText(R.id.tvTimeBW24, T64);

            views.setTextViewText(R.id.tvTimeBW25, T71);
            views.setTextViewText(R.id.tvTimeBW26, T72);
            views.setTextViewText(R.id.tvTimeBW27, T73);
            views.setTextViewText(R.id.tvTimeBW28, T74);

            views.setTextViewText(R.id.tvTimeBW29, T81);
            views.setTextViewText(R.id.tvTimeBW30, T82);
            views.setTextViewText(R.id.tvTimeBW31, T83);
            views.setTextViewText(R.id.tvTimeBW32, T84);


             if((T11.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW33, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW11, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW22, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW33, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
            }

            if((T21.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW51, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW61, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW71, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
            }

            if((T31.length()==0) || (T32.length()==0) || (T33.length()==0) || (T34.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW91, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW101, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW112, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
            }

            if((T41.length()==0) || (T42.length()==0) || (T43.length()==0) || (T44.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW131, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW141, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW151, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
            }

            if((T51.length()==0) || (T52.length()==0) || (T53.length()==0) || (T54.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW171, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW181, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW191, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
            }

            if((T61.length()==0) || (T62.length()==0) || (T63.length()==0) || (T64.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW211, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW221, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW231, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
            }

            if((T71.length()==0) || (T72.length()==0) || (T73.length()==0) || (T74.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW251, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW261, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW271, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
            }

            if((T81.length()==0) || (T82.length()==0) || (T83.length()==0) || (T84.length()==0))
            {
                views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
            }
            else
            {
                views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW291, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW301, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW311, View.VISIBLE);
                views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
            }

            Calendar calendar = Calendar.getInstance();

            int day = calendar.get(Calendar.DAY_OF_WEEK);
            //String c_day = String.valueOf(day);
            if (day == 1)
            {
                views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Voskr));
                views.setTextViewText(R.id.tvBW11, context.getString(R.string.notif_dz_net_text));

                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);

                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);

                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);

                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);

                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);

                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                    views.setViewVisibility(R.id.tvBW7, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                    views.setViewVisibility(R.id.tvBW8, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
            }
            //ПОНЕДЕЛЬНИК
            if (day == 2) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
                Intent configIntent = new Intent(context, FragmentRaspMonday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.tvBWDay, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW11, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW22, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW33, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW44, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW55, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW66, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW77, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW88, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Monday));
                views.setTextViewText(R.id.tvBW11, M1);
                views.setTextViewText(R.id.tvBW22, M2);
                views.setTextViewText(R.id.tvBW33, M3);
                views.setTextViewText(R.id.tvBW44, M4);
                views.setTextViewText(R.id.tvBW55, M5);
                views.setTextViewText(R.id.tvBW66, M6);
                views.setTextViewText(R.id.tvBW77, M7);
                views.setTextViewText(R.id.tvBW88, M8);

                if (M1.length() == 0) {
                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
                    views.setViewVisibility(R.id.tvBW11, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);

                } else {
                    views.setViewVisibility(R.id.tvBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW11, View.VISIBLE);
                }

                if (M2.length() == 0) {
                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW22, View.VISIBLE);
                }

                if (M3.length() == 0) {
                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW33, View.VISIBLE);
                }

                if (M4.length() == 0) {
                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW44, View.VISIBLE);
                }

                if (M5.length() == 0) {
                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW55, View.VISIBLE);
                }

                if (M6.length() == 0) {
                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW66, View.VISIBLE);
                }

                if (M7.length() == 0) {
                    views.setViewVisibility(R.id.tvBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW77, View.VISIBLE);
                }

                if (M8.length() == 0) {
                    views.setViewVisibility(R.id.tvBW8, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW88, View.VISIBLE);
                }

            }
            //Вторник
            if (day == 3) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
                Intent configIntent = new Intent(context, FragmentRaspTuesday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.tvBWDay, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW11, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW22, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW33, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW44, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW55, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW66, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW77, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW88, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                 views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Tuesday));
                 views.setTextViewText(R.id.tvBW11, T1);
                 views.setTextViewText(R.id.tvBW22, T2);
                 views.setTextViewText(R.id.tvBW33, T3);
                 views.setTextViewText(R.id.tvBW44, T4);
                 views.setTextViewText(R.id.tvBW55, T5);
                 views.setTextViewText(R.id.tvBW66, T6);
                 views.setTextViewText(R.id.tvBW77, T7);
                 views.setTextViewText(R.id.tvBW88, T8);

                if (T1.length() == 0) {
                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
                    views.setViewVisibility(R.id.tvBW11, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);

                } else {
                    views.setViewVisibility(R.id.tvBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW11, View.VISIBLE);
                }

                if (T2.length() == 0) {
                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW22, View.VISIBLE);
                }

                if (T3.length() == 0) {
                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW33, View.VISIBLE);
                }

                if (T4.length() == 0) {
                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW44, View.VISIBLE);
                }

                if (T5.length() == 0) {
                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW55, View.VISIBLE);
                }

                if (T6.length() == 0) {
                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW66, View.VISIBLE);
                }

                if (T7.length() == 0) {
                    views.setViewVisibility(R.id.tvBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW77, View.VISIBLE);
                }

                if (T8.length() == 0) {
                    views.setViewVisibility(R.id.tvBW8, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW88, View.VISIBLE);
                }
             }
            //Среда
            if(day == 4) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
                Intent configIntent = new Intent(context, FragmentRaspWend.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.tvBWDay, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW11, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW22, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW33, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW44, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW55, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW66, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW77, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW88, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Wend));
                views.setTextViewText(R.id.tvBW11, W1);
                views.setTextViewText(R.id.tvBW22, W2);
                views.setTextViewText(R.id.tvBW33, W3);
                views.setTextViewText(R.id.tvBW44, W4);
                views.setTextViewText(R.id.tvBW55, W5);
                views.setTextViewText(R.id.tvBW66, W6);
                views.setTextViewText(R.id.tvBW77, W7);
                views.setTextViewText(R.id.tvBW88, W8);

                if (W1.length() == 0) {
                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
                    views.setViewVisibility(R.id.tvBW11, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW11, View.VISIBLE);
                }

                if (W2.length() == 0) {
                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW22, View.VISIBLE);
                }

                if (W3.length() == 0) {
                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW33, View.VISIBLE);
                }

                if (W4.length() == 0) {
                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW44, View.VISIBLE);
                }

                if (W5.length() == 0) {
                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW55, View.VISIBLE);
                }

                if (W6.length() == 0) {
                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW66, View.VISIBLE);
                }

                if (W7.length() == 0) {
                    views.setViewVisibility(R.id.tvBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW77, View.VISIBLE);
                }

                if (W8.length() == 0) {
                    views.setViewVisibility(R.id.tvBW8, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW88, View.VISIBLE);
                }
              }
            //Четверг
            if(day == 5) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
                Intent configIntent = new Intent(context, FragmentRaspThursday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.tvBWDay, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW11, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW22, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW33, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW44, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW55, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW66, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW77, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW88, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Thr));
                views.setTextViewText(R.id.tvBW11, Th1);
                views.setTextViewText(R.id.tvBW22, Th2);
                views.setTextViewText(R.id.tvBW33, Th3);
                views.setTextViewText(R.id.tvBW44, Th4);
                views.setTextViewText(R.id.tvBW55, Th5);
                views.setTextViewText(R.id.tvBW66, Th6);
                views.setTextViewText(R.id.tvBW77, Th7);
                views.setTextViewText(R.id.tvBW88, Th8);

                if (Th1.length() == 0) {
                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
                    views.setViewVisibility(R.id.tvBW11, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW11, View.VISIBLE);
                }

                if (Th2.length() == 0) {
                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW22, View.VISIBLE);
                }

                if (Th3.length() == 0) {
                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW33, View.VISIBLE);
                }

                if (Th4.length() == 0) {
                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW44, View.VISIBLE);
                }

                if (Th5.length() == 0) {
                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW55, View.VISIBLE);
                }

                if (Th6.length() == 0) {
                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW66, View.VISIBLE);
                }

                if (Th7.length() == 0) {
                    views.setViewVisibility(R.id.tvBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW77, View.VISIBLE);
                }

                if (Th8.length() == 0) {
                    views.setViewVisibility(R.id.tvBW8, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW88, View.VISIBLE);
                }
              }
            //Пятница
            if(day == 6) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
                Intent configIntent = new Intent(context, FragmentRaspFriday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.tvBWDay, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW11, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW22, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW33, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW44, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW55, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW66, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW77, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW88, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Fri));
                views.setTextViewText(R.id.tvBW11, Fr1);
                views.setTextViewText(R.id.tvBW22, Fr2);
                views.setTextViewText(R.id.tvBW33, Fr3);
                views.setTextViewText(R.id.tvBW44, Fr4);
                views.setTextViewText(R.id.tvBW55, Fr5);
                views.setTextViewText(R.id.tvBW66, Fr6);
                views.setTextViewText(R.id.tvBW77, Fr7);
                views.setTextViewText(R.id.tvBW88, Fr8);

                if (Fr1.length() == 0) {
                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
                    views.setViewVisibility(R.id.tvBW11, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW11, View.VISIBLE);
                }

                if (Fr2.length() == 0) {
                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW22, View.VISIBLE);
                }

                if (Fr3.length() == 0) {
                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW33, View.VISIBLE);
                }

                if (Fr4.length() == 0) {
                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW44, View.VISIBLE);
                }

                if (Fr5.length() == 0) {
                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW55, View.VISIBLE);
                }

                if (Fr6.length() == 0) {
                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW66, View.VISIBLE);
                }

                if (Fr7.length() == 0) {
                    views.setViewVisibility(R.id.tvBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW77, View.VISIBLE);
                }

                if (Fr8.length() == 0) {
                    views.setViewVisibility(R.id.tvBW8, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW88, View.VISIBLE);
                }
            }
            //Суббота
            if(day == 7) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_app_widget);
                Intent configIntent = new Intent(context, FragmentRaspSaturday.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.tvBWDay, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW11, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW22, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW33, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW44, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW55, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW66, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW77, configPendingIntent);
                remoteViews.setOnClickPendingIntent(R.id.tvBW88, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

                views.setTextViewText(R.id.tvBWDay, context.getString(R.string.Sat));
                views.setTextViewText(R.id.tvBW11, Sat1);
                views.setTextViewText(R.id.tvBW22, Sat2);
                views.setTextViewText(R.id.tvBW33, Sat3);
                views.setTextViewText(R.id.tvBW44, Sat4);
                views.setTextViewText(R.id.tvBW55, Sat5);
                views.setTextViewText(R.id.tvBW66, Sat6);
                views.setTextViewText(R.id.tvBW77, Sat7);
                views.setTextViewText(R.id.tvBW88, Sat8);

                if (Sat1.length() == 0) {
                    views.setViewVisibility(R.id.tvBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.GONE);
                    views.setViewVisibility(R.id.tvBW11, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW11, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW22, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW33, View.GONE);

                } else {
                    views.setViewVisibility(R.id.tvBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW1, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW11, View.VISIBLE);
                }

                if (Sat2.length() == 0) {
                    views.setViewVisibility(R.id.tvBW2, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.GONE);
                    views.setViewVisibility(R.id.tvBW22, View.GONE);

                    views.setViewVisibility(R.id.tvTimeBW51, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW61, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW71, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW2, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW22, View.VISIBLE);
                }

                if (Sat3.length() == 0) {
                    views.setViewVisibility(R.id.tvBW3, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW91, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW101, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW112, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.GONE);
                    views.setViewVisibility(R.id.tvBW33, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW3, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW9, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW10, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW111, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW12, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW33, View.VISIBLE);
                }

                if (Sat4.length() == 0) {
                    views.setViewVisibility(R.id.tvBW4, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW131, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW141, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW151, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.GONE);
                    views.setViewVisibility(R.id.tvBW44, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW4, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW13, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW14, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW15, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW16, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW44, View.VISIBLE);
                }

                if (Sat5.length() == 0) {
                    views.setViewVisibility(R.id.tvBW5, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW171, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW181, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW191, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.GONE);
                    views.setViewVisibility(R.id.tvBW55, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW5, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW17, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW18, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW19, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW20, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW55, View.VISIBLE);
                }

                if (Sat6.length() == 0) {
                    views.setViewVisibility(R.id.tvBW6, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW211, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW221, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW231, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.GONE);
                    views.setViewVisibility(R.id.tvBW66, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW6, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW21, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW222, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW23, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW24, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW66, View.VISIBLE);
                }

                if (Sat7.length() == 0) {
                    views.setViewVisibility(R.id.tvBW7, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW251, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW261, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW271, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.GONE);
                    views.setViewVisibility(R.id.tvBW77, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW7, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW25, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW26, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW27, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW28, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW77, View.VISIBLE);
                }

                if (Sat8.length() == 0) {
                    views.setViewVisibility(R.id.tvBW8, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW291, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW301, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW311, View.GONE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.GONE);
                    views.setViewVisibility(R.id.tvBW88, View.GONE);
                } else {
                    views.setViewVisibility(R.id.tvBW8, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW29, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW30, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW31, View.VISIBLE);
                    views.setViewVisibility(R.id.tvTimeBW32, View.VISIBLE);
                    views.setViewVisibility(R.id.tvBW88, View.VISIBLE);
                }
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

