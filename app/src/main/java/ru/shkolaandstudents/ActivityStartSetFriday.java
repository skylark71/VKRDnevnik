package ru.shkolaandstudents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

public class ActivityStartSetFriday extends AppCompatActivity {

    Button btnSat,btnHelp;
    EditText etFr1,etFr2,etFr3,etFr4,etFr5,etFr6,etFr7,etFr8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_friday);

        btnHelp = findViewById(R.id.btnFrHelp);
        btnSat = findViewById(R.id.btnFrAccess);
        etFr1 = findViewById(R.id.etFr1);
        etFr2 = findViewById(R.id.etFr2);
        etFr3 = findViewById(R.id.etFr3);
        etFr4 = findViewById(R.id.etFr4);
        etFr5 = findViewById(R.id.etFr5);
        etFr6 = findViewById(R.id.etFr6);
        etFr7 = findViewById(R.id.etFr7);
        etFr8 = findViewById(R.id.etFr8);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TapTargetSequence(ActivityStartSetFriday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etFr1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnFrAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
                //showStartDialog1();
            }
        });

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Fr1 = etFr1.getText().toString();
                SPEditor.putString("Fr1",Fr1);
                SPEditor.commit();
                String Fr2 = etFr2.getText().toString();
                SPEditor.putString("Fr2",Fr2);
                SPEditor.commit();
                String Fr3 = etFr3.getText().toString();
                SPEditor.putString("Fr3",Fr3);
                SPEditor.commit();
                String Fr4 = etFr4.getText().toString();
                SPEditor.putString("Fr4",Fr4);
                SPEditor.commit();
                String Fr5 = etFr5.getText().toString();
                SPEditor.putString("Fr5",Fr5);
                SPEditor.commit();
                String Fr6 = etFr6.getText().toString();
                SPEditor.putString("Fr6",Fr6);
                SPEditor.commit();
                String Fr7 = etFr7.getText().toString();
                SPEditor.putString("Fr7",Fr7);
                SPEditor.commit();
                String Fr8 = etFr8.getText().toString();
                SPEditor.putString("Fr8",Fr8);
                SPEditor.commit();

                Intent intent = new Intent(ActivityStartSetFriday.this, ActivityStartSetSaturday.class);
                startActivity(intent);
            }
        });
    }
}