package ru.shkolaandstudents;

import androidx.appcompat.app.AppCompatActivity;

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

public class ActivitySetThursday extends AppCompatActivity {

    Button btnFri,btnHelp;
    EditText etTh1,etTh2,etTh3,etTh4,etTh5,etTh6,etTh7,etTh8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_thursday);

        btnHelp = findViewById(R.id.btnThHelp);
        btnFri = findViewById(R.id.btnThAccess);
        etTh1 = findViewById(R.id.etTh1);
        etTh2 = findViewById(R.id.etTh2);
        etTh3 = findViewById(R.id.etTh3);
        etTh4 = findViewById(R.id.etTh4);
        etTh5 = findViewById(R.id.etTh5);
        etTh6 = findViewById(R.id.etTh6);
        etTh7 = findViewById(R.id.etTh7);
        etTh8 = findViewById(R.id.etTh8);

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TapTargetSequence(ActivitySetThursday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etTh1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnThAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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


        btnFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Th1 = etTh1.getText().toString();
                SPEditor.putString("Th1",Th1);
                SPEditor.commit();
                String Th2 = etTh2.getText().toString();
                SPEditor.putString("Th2",Th2);
                SPEditor.commit();
                String Th3 = etTh3.getText().toString();
                SPEditor.putString("Th3",Th3);
                SPEditor.commit();
                String Th4 = etTh4.getText().toString();
                SPEditor.putString("Th4",Th4);
                SPEditor.commit();
                String Th5 = etTh5.getText().toString();
                SPEditor.putString("Th5",Th5);
                SPEditor.commit();
                String Th6 = etTh6.getText().toString();
                SPEditor.putString("Th6",Th6);
                SPEditor.commit();
                String Th7 = etTh7.getText().toString();
                SPEditor.putString("Th7",Th7);
                SPEditor.commit();
                String Th8 = etTh8.getText().toString();
                SPEditor.putString("Th8",Th8);
                SPEditor.commit();

                Intent intent = new Intent(ActivitySetThursday.this, ActivitySetFriday.class);
                startActivity(intent);
            }
        });
    }
}