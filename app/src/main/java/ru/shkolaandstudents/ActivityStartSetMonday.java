package ru.shkolaandstudents;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

public class ActivityStartSetMonday extends AppCompatActivity {

    Button btnTuesday,btnHelp;
    EditText etM1,etM2,etM3,etM4,etM5,etM6,etM7,etM8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    private int appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_monday);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstSTart = prefs.getBoolean("firstStart", true);

        if(firstSTart) {
            new TapTargetSequence(this)
                    .targets(
                            TapTarget.forView(findViewById(R.id.etM1),getResources().getString(R.string.first_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                    .titleTextSize(20)
                                    .titleTextColor(R.color.colorWhite)
                                    .descriptionTextColor(R.color.colorWhite)
                                    .cancelable(false)
                                    .tintTarget(false)
                                    .targetRadius(30)
                                    .transparentTarget(true)
                                    .outerCircleColor(R.color.colorTuesday),
                            TapTarget.forView(findViewById(R.id.btnMAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
            //showStartDialog();
        }
        btnTuesday = findViewById(R.id.btnMAccess);
        btnHelp = findViewById(R.id.btnMHelp);
        etM1 = findViewById(R.id.etM1);
        etM2 = findViewById(R.id.etM2);
        etM3 = findViewById(R.id.etM3);
        etM4 = findViewById(R.id.etM4);
        etM5 = findViewById(R.id.etM5);
        etM6 = findViewById(R.id.etM6);
        etM7 = findViewById(R.id.etM7);
        etM8 = findViewById(R.id.etM8);

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TapTargetSequence(ActivityStartSetMonday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etM1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnMAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
                                SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("firstStart", false);
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
                //showStartDialog1();
            }
        });

        btnTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String M1 = etM1.getText().toString();
                SPEditor.putString("M1",M1);
                SPEditor.apply();
                String M2 = etM2.getText().toString();
                SPEditor.putString("M2",M2);
                SPEditor.commit();
                String M3 = etM3.getText().toString();
                SPEditor.putString("M3",M3);
                SPEditor.commit();
                String M4 = etM4.getText().toString();
                SPEditor.putString("M4",M4);
                SPEditor.commit();
                String M5 = etM5.getText().toString();
                SPEditor.putString("M5",M5);
                SPEditor.commit();
                String M6 = etM6.getText().toString();
                SPEditor.putString("M6",M6);
                SPEditor.commit();
                String M7 = etM7.getText().toString();
                SPEditor.putString("M7",M7);
                SPEditor.commit();
                String M8 = etM8.getText().toString();
                SPEditor.putString("M8",M8);
                SPEditor.commit();

                Intent intent = new Intent(ActivityStartSetMonday.this, ActivityStartSetTuesday.class);
                startActivity(intent);

            }

        });
    }
}