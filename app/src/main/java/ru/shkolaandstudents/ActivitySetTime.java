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

public class ActivitySetTime extends AppCompatActivity {

    EditText etTime11,etTime12,etTime13,etTime14,etTime21,etTime22,etTime23,etTime24,etTime31,etTime32,etTime33,etTime34,etTime41,etTime42,etTime43,etTime44,etTime51,etTime52,etTime53,etTime54,etTime61,etTime62,etTime63,etTime64,etTime71,etTime72,etTime73,etTime74,etTime81,etTime82,etTime83,etTime84;
    Button btnNext, btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        etTime11 = findViewById(R.id.etTime11); etTime21 = findViewById(R.id.etTime21); etTime31 = findViewById(R.id.etTime31); etTime41 = findViewById(R.id.etTime41); etTime51 = findViewById(R.id.etTime51); etTime61 = findViewById(R.id.etTime61); etTime71 = findViewById(R.id.etTime71); etTime81 = findViewById(R.id.etTime81);
        etTime12 = findViewById(R.id.etTime12); etTime22 = findViewById(R.id.etTime22); etTime32 = findViewById(R.id.etTime32); etTime42 = findViewById(R.id.etTime42); etTime52 = findViewById(R.id.etTime52); etTime62 = findViewById(R.id.etTime62); etTime72 = findViewById(R.id.etTime72); etTime82 = findViewById(R.id.etTime82);
        etTime13 = findViewById(R.id.etTime13); etTime23 = findViewById(R.id.etTime23); etTime33 = findViewById(R.id.etTime33); etTime43 = findViewById(R.id.etTime43); etTime53 = findViewById(R.id.etTime53); etTime63 = findViewById(R.id.etTime63); etTime73 = findViewById(R.id.etTime73); etTime83 = findViewById(R.id.etTime83);
        etTime14 = findViewById(R.id.etTime14); etTime24 = findViewById(R.id.etTime24); etTime34 = findViewById(R.id.etTime34); etTime44 = findViewById(R.id.etTime44); etTime54 = findViewById(R.id.etTime54); etTime64 = findViewById(R.id.etTime64); etTime74 = findViewById(R.id.etTime74); etTime84 = findViewById(R.id.etTime84);
        btnNext = findViewById(R.id.btnNext);
        btnHelp = findViewById(R.id.btnTimeHelp);

        SharedPreferences prefs1 = getSharedPreferences("prefs11", MODE_PRIVATE);
        boolean firstStart = prefs1.getBoolean("firstStart11", true);

        if(firstStart) {
            showStartDialog();
        }


        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartDialog1();
            }
        });

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SPEditor = SP.edit();

        String sT11 = SP.getString("T11","");
        etTime11.setText(sT11);
        String sT12 = SP.getString("T12","");
        etTime12.setText(sT12);
        String sT13 = SP.getString("T13","");
        etTime13.setText(sT13);
        String sT14 = SP.getString("T14","");
        etTime14.setText(sT14);

        String sT21 = SP.getString("T21","");
        etTime21.setText(sT21);
        String sT22 = SP.getString("T22","");
        etTime22.setText(sT22);
        String sT23 = SP.getString("T23","");
        etTime23.setText(sT23);
        String sT24 = SP.getString("T24","");
        etTime24.setText(sT24);

        String sT31 = SP.getString("T31","");
        etTime31.setText(sT31);
        String sT32 = SP.getString("T32","");
        etTime32.setText(sT32);
        String sT33 = SP.getString("T33","");
        etTime33.setText(sT33);
        String sT34 = SP.getString("T34","");
        etTime34.setText(sT34);

        String sT41 = SP.getString("T41","");
        etTime41.setText(sT41);
        String sT42 = SP.getString("T42","");
        etTime42.setText(sT42);
        String sT43 = SP.getString("T43","");
        etTime43.setText(sT43);
        String sT44 = SP.getString("T44","");
        etTime44.setText(sT44);

        String sT51 = SP.getString("T51","");
        etTime51.setText(sT51);
        String sT52 = SP.getString("T52","");
        etTime52.setText(sT52);
        String sT53 = SP.getString("T53","");
        etTime53.setText(sT53);
        String sT54 = SP.getString("T54","");
        etTime54.setText(sT54);

        String sT61 = SP.getString("T61","");
        etTime61.setText(sT61);
        String sT62 = SP.getString("T62","");
        etTime62.setText(sT62);
        String sT63 = SP.getString("T63","");
        etTime63.setText(sT63);
        String sT64 = SP.getString("T64","");
        etTime64.setText(sT64);

        String sT71 = SP.getString("T71","");
        etTime71.setText(sT71);
        String sT72 = SP.getString("T72","");
        etTime72.setText(sT72);
        String sT73 = SP.getString("T73","");
        etTime73.setText(sT73);
        String sT74 = SP.getString("T74","");
        etTime74.setText(sT74);

        String sT81 = SP.getString("T81","");
        etTime81.setText(sT81);
        String sT82 = SP.getString("T82","");
        etTime82.setText(sT82);
        String sT83 = SP.getString("T83","");
        etTime83.setText(sT83);
        String sT84 = SP.getString("T84","");
        etTime84.setText(sT84);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String T11 = etTime11.getText().toString();
                String T12 = etTime12.getText().toString();
                String T13 = etTime13.getText().toString();
                String T14 = etTime14.getText().toString();
                String T21 = etTime21.getText().toString();
                String T22 = etTime22.getText().toString();
                String T23 = etTime23.getText().toString();
                String T24 = etTime24.getText().toString();
                String T31 = etTime31.getText().toString();
                String T32 = etTime32.getText().toString();
                String T33 = etTime33.getText().toString();
                String T34 = etTime34.getText().toString();
                String T41 = etTime41.getText().toString();
                String T42 = etTime42.getText().toString();
                String T43 = etTime43.getText().toString();
                String T44 = etTime44.getText().toString();
                String T51 = etTime51.getText().toString();
                String T52 = etTime52.getText().toString();
                String T53 = etTime53.getText().toString();
                String T54 = etTime54.getText().toString();
                String T61 = etTime61.getText().toString();
                String T62 = etTime62.getText().toString();
                String T63 = etTime63.getText().toString();
                String T64 = etTime64.getText().toString();
                String T71 = etTime71.getText().toString();
                String T72 = etTime72.getText().toString();
                String T73 = etTime73.getText().toString();
                String T74 = etTime74.getText().toString();
                String T81 = etTime81.getText().toString();
                String T82 = etTime82.getText().toString();
                String T83 = etTime83.getText().toString();
                String T84 = etTime84.getText().toString();

                SPEditor.putString("T11", T11);
                SPEditor.apply();
                SPEditor.putString("T12", T12);
                SPEditor.apply();
                SPEditor.putString("T13", T13);
                SPEditor.apply();
                SPEditor.putString("T14", T14);
                SPEditor.apply();
                SPEditor.putString("T21", T21);
                SPEditor.apply();
                SPEditor.putString("T22", T22);
                SPEditor.apply();
                SPEditor.putString("T23", T23);
                SPEditor.apply();
                SPEditor.putString("T24", T24);
                SPEditor.apply();
                SPEditor.putString("T31", T31);
                SPEditor.apply();
                SPEditor.putString("T32", T32);
                SPEditor.apply();
                SPEditor.putString("T33", T33);
                SPEditor.apply();
                SPEditor.putString("T34", T34);
                SPEditor.apply();
                SPEditor.putString("T41", T41);
                SPEditor.apply();
                SPEditor.putString("T42", T42);
                SPEditor.apply();
                SPEditor.putString("T43", T43);
                SPEditor.apply();
                SPEditor.putString("T44", T44);
                SPEditor.apply();
                SPEditor.putString("T51", T51);
                SPEditor.apply();
                SPEditor.putString("T52", T52);
                SPEditor.apply();
                SPEditor.putString("T53", T53);
                SPEditor.apply();
                SPEditor.putString("T54", T54);
                SPEditor.apply();
                SPEditor.putString("T61", T61);
                SPEditor.apply();
                SPEditor.putString("T62", T62);
                SPEditor.apply();
                SPEditor.putString("T63", T63);
                SPEditor.apply();
                SPEditor.putString("T64", T64);
                SPEditor.apply();
                SPEditor.putString("T71", T71);
                SPEditor.apply();
                SPEditor.putString("T72", T72);
                SPEditor.apply();
                SPEditor.putString("T73", T73);
                SPEditor.apply();
                SPEditor.putString("T74", T74);
                SPEditor.apply();
                SPEditor.putString("T81", T81);
                SPEditor.apply();
                SPEditor.putString("T82", T82);
                SPEditor.apply();
                SPEditor.putString("T83", T83);
                SPEditor.apply();
                SPEditor.putString("T84", T84);
                SPEditor.apply();

                Intent intent = new Intent(ActivitySetTime.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void showStartDialog()
    {
        new TapTargetSequence(ActivitySetTime.this)
                .targets(
                        TapTarget.forView(findViewById(R.id.tv11),getResources().getString(R.string.setStartTime_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(70)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday),
                        TapTarget.forView(findViewById(R.id.tv13), getResources().getString(R.string.setEndTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(70)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday),
                        TapTarget.forView(findViewById(R.id.btnNext), getResources().getString(R.string.setTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
                        SharedPreferences prefs = getSharedPreferences("prefs11",MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("firstStart11", false);
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
        new TapTargetSequence(ActivitySetTime.this)
                .targets(
                        TapTarget.forView(findViewById(R.id.tv11),getResources().getString(R.string.setStartTime_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(80)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday),
                        TapTarget.forView(findViewById(R.id.tv13), getResources().getString(R.string.setEndTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                .titleTextSize(20)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextColor(R.color.colorWhite)
                                .cancelable(false)
                                .tintTarget(false)
                                .targetRadius(80)
                                .transparentTarget(true)
                                .outerCircleColor(R.color.colorTuesday),
                        TapTarget.forView(findViewById(R.id.btnNext), getResources().getString(R.string.setTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
}