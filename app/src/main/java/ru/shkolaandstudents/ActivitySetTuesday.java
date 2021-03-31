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

public class ActivitySetTuesday extends AppCompatActivity {

    Button btnWend,btnHelp;
    EditText etT1,etT2,etT3,etT4,etT5,etT6,etT7,etT8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_tuesday);

        btnHelp = findViewById(R.id.btnTHelp);
        btnWend = findViewById(R.id.btnTAccess);
        etT1 = findViewById(R.id.etT1);
        etT2 = findViewById(R.id.etT2);
        etT3 = findViewById(R.id.etT3);
        etT4 = findViewById(R.id.etT4);
        etT5 = findViewById(R.id.etT5);
        etT6 = findViewById(R.id.etT6);
        etT7 = findViewById(R.id.etT7);
        etT8 = findViewById(R.id.etT8);

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TapTargetSequence(ActivitySetTuesday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etT1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnTAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String T1 = etT1.getText().toString();
                SPEditor.putString("T1",T1);
                SPEditor.commit();
                String T2 = etT2.getText().toString();
                SPEditor.putString("T2",T2);
                SPEditor.commit();
                String T3 = etT3.getText().toString();
                SPEditor.putString("T3",T3);
                SPEditor.commit();
                String T4 = etT4.getText().toString();
                SPEditor.putString("T4",T4);
                SPEditor.commit();
                String T5 = etT5.getText().toString();
                SPEditor.putString("T5",T5);
                SPEditor.commit();
                String T6 = etT6.getText().toString();
                SPEditor.putString("T6",T6);
                SPEditor.commit();
                String T7 = etT7.getText().toString();
                SPEditor.putString("T7",T7);
                SPEditor.commit();
                String T8 = etT8.getText().toString();
                SPEditor.putString("T8",T8);
                SPEditor.commit();

                Intent intent = new Intent(ActivitySetTuesday.this, ActivitySetWenesday.class);
                startActivity(intent);

            }
        });
    }
}