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

public class ActivityStartSetSaturday extends AppCompatActivity {

    Button btnSM,btnHelp;
    EditText etSat1,etSat2,etSat3,etSat4,etSat5,etSat6,etSat7,etSat8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_saturday);

        btnHelp = findViewById(R.id.btnSatHelp);
        btnSM = findViewById(R.id.btnSatAccess);
        etSat1 = findViewById(R.id.etSat1);
        etSat2 = findViewById(R.id.etSat2);
        etSat3 = findViewById(R.id.etSat3);
        etSat4 = findViewById(R.id.etSat4);
        etSat5 = findViewById(R.id.etSat5);
        etSat6 = findViewById(R.id.etSat6);
        etSat7 = findViewById(R.id.etSat7);
        etSat8 = findViewById(R.id.etSat8);

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TapTargetSequence(ActivityStartSetSaturday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etSat1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnSatAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sat1 = etSat1.getText().toString();
                SPEditor.putString("Sat1",Sat1);
                SPEditor.commit();
                String Sat2 = etSat2.getText().toString();
                SPEditor.putString("Sat2",Sat2);
                SPEditor.commit();
                String Sat3 = etSat3.getText().toString();
                SPEditor.putString("Sat3",Sat3);
                SPEditor.commit();
                String Sat4 = etSat4.getText().toString();
                SPEditor.putString("Sat4",Sat4);
                SPEditor.commit();
                String Sat5 = etSat5.getText().toString();
                SPEditor.putString("Sat5",Sat5);
                SPEditor.commit();
                String Sat6 = etSat6.getText().toString();
                SPEditor.putString("Sat6",Sat6);
                SPEditor.commit();
                String Sat7 = etSat7.getText().toString();
                SPEditor.putString("Sat7",Sat7);
                SPEditor.commit();
                String Sat8 = etSat8.getText().toString();
                SPEditor.putString("Sat8",Sat8);
                SPEditor.commit();

                Intent intent = new Intent(ActivityStartSetSaturday.this, ActivityStartSetTime.class);
                startActivity(intent);
            }

        });
    }
}