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

public class ActivityStartSetWenesday extends AppCompatActivity {

    Button btnThurs,btnHelp;
    EditText etW1,etW2,etW3,etW4,etW5,etW6,etW7,etW8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wenesday);

        btnHelp = findViewById(R.id.btnWHelp);
        btnThurs = findViewById(R.id.btnWAccess);
        etW1 = findViewById(R.id.etW1);
        etW2 = findViewById(R.id.etW2);
        etW3 = findViewById(R.id.etW3);
        etW4 = findViewById(R.id.etW4);
        etW5 = findViewById(R.id.etW5);
        etW6 = findViewById(R.id.etW6);
        etW7 = findViewById(R.id.etW7);
        etW8 = findViewById(R.id.etW8);

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TapTargetSequence(ActivityStartSetWenesday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etW1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnWAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnThurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String W1 = etW1.getText().toString();
                SPEditor.putString("W1",W1);
                SPEditor.commit();
                String W2 = etW2.getText().toString();
                SPEditor.putString("W2",W2);
                SPEditor.commit();
                String W3 = etW3.getText().toString();
                SPEditor.putString("W3",W3);
                SPEditor.commit();
                String W4 = etW4.getText().toString();
                SPEditor.putString("W4",W4);
                SPEditor.commit();
                String W5 = etW5.getText().toString();
                SPEditor.putString("W5",W5);
                SPEditor.commit();
                String W6 = etW6.getText().toString();
                SPEditor.putString("W6",W6);
                SPEditor.commit();
                String W7 = etW7.getText().toString();
                SPEditor.putString("W7",W7);
                SPEditor.commit();
                String W8 = etW8.getText().toString();
                SPEditor.putString("W8",W8);
                SPEditor.commit();

                Intent intent = new Intent(ActivityStartSetWenesday.this, ActivityStartSetThursday.class);
                startActivity(intent);
            }
        });
    }
}