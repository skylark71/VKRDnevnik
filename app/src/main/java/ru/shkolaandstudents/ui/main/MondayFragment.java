package ru.shkolaandstudents.ui.main;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;


public class MondayFragment extends Fragment implements OnBackPressedListener {

    TextView tvM11,tvM22,tvM33,tvM44,tvM55,tvM66,tvM77,tvM88,tvM1,tvM2,tvM3,tvM4,tvM5,tvM6,tvM7,tvM8,tvTimeM1,tvTimeM2,tvTimeM3,tvTimeM4,tvTimeM5,tvTimeM6,tvTimeM7,tvTimeM8,tvTimeM9,tvTimeM10,tvTimeM111,tvTimeM12,tvTimeM13,tvTimeM14,tvTimeM15,tvTimeM16,tvTimeM17,tvTimeM18,tvTimeM19,tvTimeM20,tvTimeM21,tvTimeM222,tvTimeM23,tvTimeM24,tvTimeM25,tvTimeM26,tvTimeM27,tvTimeM28,tvTimeM29,tvTimeM30,tvTimeM31,tvTimeM32;
    EditText etM1DZ,etM2DZ,etM3DZ,etM4DZ,etM5DZ,etM6DZ,etM7DZ,etM8DZ;
    TextView tvTimeM11,tvTimeM22,tvTimeM33,tvTimeM51,tvTimeM61,tvTimeM71,tvTimeM91,tvTimeM101,tvTimeM112,tvTimeM131,tvTimeM141,tvTimeM151,tvTimeM171,tvTimeM181,tvTimeM191,tvTimeM211,tvTimeM221,tvTimeM231,tvTimeM251,tvTimeM261,tvTimeM271,tvTimeM291,tvTimeM301,tvTimeM311;
    //CheckBox Mcb1,Mcb2,Mcb3,Mcb4,Mcb5,Mcb6,Mcb7,Mcb8;
    TextView tvOcenkaM1, tvOcenkaM2, tvOcenkaM3, tvOcenkaM4, tvOcenkaM5, tvOcenkaM6, tvOcenkaM7, tvOcenkaM8;
    Button btnHelp;
    String M1,M2,M3,M4,M5,M6,M7,M8;
    SharedPreferences.Editor SPEditor;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_monday, container, false);

        btnHelp = v.findViewById(R.id.btnMonHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvM1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeM11), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeM33), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvM11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etM1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaM1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
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
        });

        tvOcenkaM1 = v.findViewById(R.id.tvOcenkaM1);
        tvOcenkaM2 = v.findViewById(R.id.tvOcenkaM2);
        tvOcenkaM3 = v.findViewById(R.id.tvOcenkaM3);
        tvOcenkaM4 = v.findViewById(R.id.tvOcenkaM4);
        tvOcenkaM5 = v.findViewById(R.id.tvOcenkaM5);
        tvOcenkaM6 = v.findViewById(R.id.tvOcenkaM6);
        tvOcenkaM7 = v.findViewById(R.id.tvOcenkaM7);
        tvOcenkaM8 = v.findViewById(R.id.tvOcenkaM8);

        tvOcenkaM3.setText("3");
        tvOcenkaM4.setText("4");
        tvOcenkaM5.setText("5");


        tvM11 = v.findViewById(R.id.tvM11); etM2DZ = v.findViewById(R.id.etM2DZ);
        tvM22 = v.findViewById(R.id.tvM22); etM1DZ = v.findViewById(R.id.etM1DZ);
        tvM33 = v.findViewById(R.id.tvM33); etM3DZ = v.findViewById(R.id.etM3DZ);
        tvM44 = v.findViewById(R.id.tvM44); etM6DZ = v.findViewById(R.id.etM6DZ);
        tvM55 = v.findViewById(R.id.tvM55); etM4DZ = v.findViewById(R.id.etM4DZ);
        tvM66 = v.findViewById(R.id.tvM66); etM7DZ = v.findViewById(R.id.etM7DZ);
        tvM77 = v.findViewById(R.id.tvM77); etM5DZ = v.findViewById(R.id.etM5DZ);
        tvM88 = v.findViewById(R.id.tvM88); etM8DZ = v.findViewById(R.id.etM8DZ);

        tvM1 = v.findViewById(R.id.tvM1);
        tvM2 = v.findViewById(R.id.tvM2);
        tvM3 = v.findViewById(R.id.tvM3);
        tvM4 = v.findViewById(R.id.tvM4);
        tvM5 = v.findViewById(R.id.tvM5);
        tvM6 = v.findViewById(R.id.tvM6);
        tvM7 = v.findViewById(R.id.tvM7);
        tvM8 = v.findViewById(R.id.tvM8);

        tvTimeM1 = v.findViewById(R.id.tvTimeM1); tvTimeM9 = v.findViewById(R.id.tvTimeM9);     tvTimeM17 = v.findViewById(R.id.tvTimeM17);  tvTimeM25 = v.findViewById(R.id.tvTimeM25);
        tvTimeM2 = v.findViewById(R.id.tvTimeM2); tvTimeM10 = v.findViewById(R.id.tvTimeM10);   tvTimeM18 = v.findViewById(R.id.tvTimeM18);  tvTimeM26 = v.findViewById(R.id.tvTimeM26);
        tvTimeM3 = v.findViewById(R.id.tvTimeM3); tvTimeM111 = v.findViewById(R.id.tvTimeM111); tvTimeM19 = v.findViewById(R.id.tvTimeM19);  tvTimeM27 = v.findViewById(R.id.tvTimeM27);
        tvTimeM4 = v.findViewById(R.id.tvTimeM4); tvTimeM12 = v.findViewById(R.id.tvTimeM12);   tvTimeM20 = v.findViewById(R.id.tvTimeM20);  tvTimeM28 = v.findViewById(R.id.tvTimeM28);
        tvTimeM5 = v.findViewById(R.id.tvTimeM5); tvTimeM13 = v.findViewById(R.id.tvTimeM13);   tvTimeM21 = v.findViewById(R.id.tvTimeM21);  tvTimeM29 = v.findViewById(R.id.tvTimeM29);
        tvTimeM6 = v.findViewById(R.id.tvTimeM6); tvTimeM14 = v.findViewById(R.id.tvTimeM14);   tvTimeM222 = v.findViewById(R.id.tvTimeM222); tvTimeM30 = v.findViewById(R.id.tvTimeM30);
        tvTimeM7 = v.findViewById(R.id.tvTimeM7); tvTimeM15 = v.findViewById(R.id.tvTimeM15);   tvTimeM23 = v.findViewById(R.id.tvTimeM23);  tvTimeM31 = v.findViewById(R.id.tvTimeM31);
        tvTimeM8 = v.findViewById(R.id.tvTimeM8); tvTimeM16 = v.findViewById(R.id.tvTimeM16);   tvTimeM24 = v.findViewById(R.id.tvTimeM24);  tvTimeM32 = v.findViewById(R.id.tvTimeM32);

        tvTimeM11 = v.findViewById(R.id.tvTimeM11); tvTimeM61 = v.findViewById(R.id.tvTimeM61); tvTimeM112 = v.findViewById(R.id.tvTimeM112);  tvTimeM171 = v.findViewById(R.id.tvTimeM171);
        tvTimeM22 = v.findViewById(R.id.tvTimeM22); tvTimeM71 = v.findViewById(R.id.tvTimeM71); tvTimeM131 = v.findViewById(R.id.tvTimeM131);  tvTimeM181 = v.findViewById(R.id.tvTimeM181);
        tvTimeM33 = v.findViewById(R.id.tvTimeM33); tvTimeM91 = v.findViewById(R.id.tvTimeM91); tvTimeM141 = v.findViewById(R.id.tvTimeM141);   tvTimeM191 = v.findViewById(R.id.tvTimeM191);
        tvTimeM51 = v.findViewById(R.id.tvTimeM51); tvTimeM101 = v.findViewById(R.id.tvTimeM101); tvTimeM151 = v.findViewById(R.id.tvTimeM151); tvTimeM211 = v.findViewById(R.id.tvTimeM211);

        tvTimeM211 = v.findViewById(R.id.tvTimeM211); tvTimeM251 = v.findViewById(R.id.tvTimeM251); tvTimeM291 = v.findViewById(R.id.tvTimeM291);
        tvTimeM221 = v.findViewById(R.id.tvTimeM221); tvTimeM261 = v.findViewById(R.id.tvTimeM261); tvTimeM301 = v.findViewById(R.id.tvTimeM301);
        tvTimeM231 = v.findViewById(R.id.tvTimeM231); tvTimeM271 = v.findViewById(R.id.tvTimeM271); tvTimeM311 = v.findViewById(R.id.tvTimeM311);
        etM1DZ = v.findViewById(R.id.etM1DZ);
        etM2DZ = v.findViewById(R.id.etM2DZ);
        etM3DZ = v.findViewById(R.id.etM3DZ);
        etM4DZ = v.findViewById(R.id.etM4DZ);
        etM5DZ = v.findViewById(R.id.etM5DZ);
        etM6DZ = v.findViewById(R.id.etM6DZ);
        etM7DZ = v.findViewById(R.id.etM7DZ);
        etM8DZ = v.findViewById(R.id.etM8DZ);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                M1 = String.valueOf(snapshot.child("SubM1").getValue());
                M2 = String.valueOf(snapshot.child("SubM2").getValue());
                M3 = String.valueOf(snapshot.child("SubM3").getValue());
                M4 = String.valueOf(snapshot.child("SubM4").getValue());
                M5 = String.valueOf(snapshot.child("SubM5").getValue());
                M6 = String.valueOf(snapshot.child("SubM6").getValue());
                M7 = String.valueOf(snapshot.child("SubM7").getValue());
                M8 = String.valueOf(snapshot.child("SubM8").getValue());

                if (snapshot.child("SubM1").exists()) {
                    tvM11.setText(M1);
                }
                else
                {
                    tvM11.setText("");
                }

                if (snapshot.child("SubM2").exists()) {
                    tvM22.setText(M2);
                }
                else
                {
                    tvM22.setText("");
                }

                if (snapshot.child("SubM3").exists()) {
                    tvM33.setText(M3);
                }
                else
                {
                    tvM33.setText("");
                }

                if (snapshot.child("SubM4").exists()) {
                    tvM44.setText(M4);
                }
                else
                {
                    tvM44.setText("");
                }

                if (snapshot.child("SubM5").exists()) {
                    tvM55.setText(M5);
                }
                else
                {
                    tvM55.setText("");
                }

                if (snapshot.child("SubM6").exists()) {
                    tvM66.setText(M6);
                }
                else
                {
                    tvM66.setText("");
                }

                if (snapshot.child("SubM7").exists()) {
                    tvM77.setText(M7);
                }
                else
                {
                    tvM77.setText("");
                }

                if (snapshot.child("SubM8").exists()) {
                    tvM88.setText(M8);
                }
                else
                {
                    tvM88.setText("");
                }

                String sT11 = String.valueOf(snapshot.child("T11").getValue());
                String sT12 = String.valueOf(snapshot.child("T12").getValue());
                String sT13 = String.valueOf(snapshot.child("T13").getValue());
                String sT14 = String.valueOf(snapshot.child("T14").getValue());

                String sT21 = String.valueOf(snapshot.child("T21").getValue());
                String sT22 = String.valueOf(snapshot.child("T22").getValue());
                String sT23 = String.valueOf(snapshot.child("T23").getValue());
                String sT24 = String.valueOf(snapshot.child("T24").getValue());

                String sT31 = String.valueOf(snapshot.child("T31").getValue());
                String sT32 = String.valueOf(snapshot.child("T32").getValue());
                String sT33 = String.valueOf(snapshot.child("T33").getValue());
                String sT34 = String.valueOf(snapshot.child("T34").getValue());

                String sT41 = String.valueOf(snapshot.child("T41").getValue());
                String sT42 = String.valueOf(snapshot.child("T42").getValue());
                String sT43 = String.valueOf(snapshot.child("T43").getValue());
                String sT44 = String.valueOf(snapshot.child("T44").getValue());

                String sT51 = String.valueOf(snapshot.child("T51").getValue());
                String sT52 = String.valueOf(snapshot.child("T52").getValue());
                String sT53 = String.valueOf(snapshot.child("T53").getValue());
                String sT54 = String.valueOf(snapshot.child("T54").getValue());

                String sT61 = String.valueOf(snapshot.child("T61").getValue());
                String sT62 = String.valueOf(snapshot.child("T62").getValue());
                String sT63 = String.valueOf(snapshot.child("T63").getValue());
                String sT64 = String.valueOf(snapshot.child("T64").getValue());

                String sT71 = String.valueOf(snapshot.child("T71").getValue());
                String sT72 = String.valueOf(snapshot.child("T72").getValue());
                String sT73 = String.valueOf(snapshot.child("T73").getValue());
                String sT74 = String.valueOf(snapshot.child("T74").getValue());

                String sT81 = String.valueOf(snapshot.child("T81").getValue());
                String sT82 = String.valueOf(snapshot.child("T82").getValue());
                String sT83 = String.valueOf(snapshot.child("T83").getValue());
                String sT84 = String.valueOf(snapshot.child("T84").getValue());
                
                
                if (sT11.equals("null")) {
                    tvTimeM11.setVisibility(View.GONE);
                    tvTimeM22.setVisibility(View.GONE);
                    tvTimeM33.setVisibility(View.GONE);
                } else {
                    tvTimeM11.setVisibility(View.VISIBLE);
                    tvTimeM22.setVisibility(View.VISIBLE);
                    tvTimeM33.setVisibility(View.VISIBLE);
                }

                if (sT21.equals("null")) {
                    tvTimeM51.setVisibility(View.GONE);
                    tvTimeM61.setVisibility(View.GONE);
                    tvTimeM71.setVisibility(View.GONE);
                } else {
                    tvTimeM51.setVisibility(View.VISIBLE);
                    tvTimeM61.setVisibility(View.VISIBLE);
                    tvTimeM71.setVisibility(View.VISIBLE);
                }

                if (sT31.equals("null")) {
                    tvTimeM91.setVisibility(View.GONE);
                    tvTimeM101.setVisibility(View.GONE);
                    tvTimeM112.setVisibility(View.GONE);
                } else {
                    tvTimeM91.setVisibility(View.VISIBLE);
                    tvTimeM101.setVisibility(View.VISIBLE);
                    tvTimeM112.setVisibility(View.VISIBLE);
                }

                if (sT41.equals("null")) {
                    tvTimeM131.setVisibility(View.GONE);
                    tvTimeM141.setVisibility(View.GONE);
                    tvTimeM151.setVisibility(View.GONE);
                } else {
                    tvTimeM131.setVisibility(View.VISIBLE);
                    tvTimeM141.setVisibility(View.VISIBLE);
                    tvTimeM151.setVisibility(View.VISIBLE);
                }

                if (sT51.equals("null")) {
                    tvTimeM171.setVisibility(View.GONE);
                    tvTimeM181.setVisibility(View.GONE);
                    tvTimeM191.setVisibility(View.GONE);
                } else {
                    tvTimeM171.setVisibility(View.VISIBLE);
                    tvTimeM181.setVisibility(View.VISIBLE);
                    tvTimeM191.setVisibility(View.VISIBLE);
                }

                if (sT61.equals("null")) {
                    tvTimeM211.setVisibility(View.GONE);
                    tvTimeM231.setVisibility(View.GONE);
                    tvTimeM221.setVisibility(View.GONE);
                } else {
                    tvTimeM211.setVisibility(View.VISIBLE);
                    tvTimeM231.setVisibility(View.VISIBLE);
                    tvTimeM221.setVisibility(View.VISIBLE);
                }

                if (sT71.equals("null")) {
                    tvTimeM251.setVisibility(View.GONE);
                    tvTimeM261.setVisibility(View.GONE);
                    tvTimeM271.setVisibility(View.GONE);
                } else {
                    tvTimeM251.setVisibility(View.VISIBLE);
                    tvTimeM261.setVisibility(View.VISIBLE);
                    tvTimeM271.setVisibility(View.VISIBLE);
                }

                if (sT81.equals("null")) {
                    tvTimeM291.setVisibility(View.GONE);
                    tvTimeM301.setVisibility(View.GONE);
                    tvTimeM311.setVisibility(View.GONE);
                } else {
                    tvTimeM291.setVisibility(View.VISIBLE);
                    tvTimeM301.setVisibility(View.VISIBLE);
                    tvTimeM311.setVisibility(View.VISIBLE);
                }

                //////////////////
                tvTimeM1.setText(sT11);
                tvTimeM2.setText(sT12);
                tvTimeM3.setText(sT13);
                tvTimeM4.setText(sT14);
                //////////////////
                tvTimeM5.setText(sT21);
                tvTimeM6.setText(sT22);
                tvTimeM7.setText(sT23);
                tvTimeM8.setText(sT24);
                /////////////////////
                tvTimeM9.setText(sT31);
                tvTimeM10.setText(sT32);
                tvTimeM111.setText(sT33);
                tvTimeM12.setText(sT34);
                ////////////////////////
                tvTimeM13.setText(sT41);
                tvTimeM14.setText(sT42);
                tvTimeM15.setText(sT43);
                tvTimeM16.setText(sT44);
                //////////////////////
                tvTimeM17.setText(sT51);
                tvTimeM18.setText(sT52);
                tvTimeM19.setText(sT53);
                tvTimeM20.setText(sT54);
                //////////////////////
                tvTimeM21.setText(sT61);
                tvTimeM222.setText(sT62);
                tvTimeM23.setText(sT63);
                tvTimeM24.setText(sT64);
                //////////////////////
                tvTimeM25.setText(sT71);
                tvTimeM26.setText(sT72);
                tvTimeM27.setText(sT73);
                tvTimeM28.setText(sT74);
                ///////////////////////
                tvTimeM29.setText(sT81);
                tvTimeM30.setText(sT82);
                tvTimeM31.setText(sT83);
                tvTimeM32.setText(sT84);
                ///////////////////////


                if (!M1.equals("null") && M1.length()>7)
                {
                    tvM11.setPadding(0,0,0,8);
                }

                if (!M2.equals("null") && M2.length()>7)
                {
                    tvM22.setPadding(0,0,0,8);
                }

                if (!M3.equals("null") && M3.length()>7)
                {
                    tvM33.setPadding(0,0,0,8);
                }

                if (!M4.equals("null") && M4.length()>7)
                {
                    tvM44.setPadding(0,0,0,8);
                }

                if (!M5.equals("null") && M5.length()>7)
                {
                    tvM55.setPadding(0,0,0,8);
                }

                if (!M6.equals("null") && M6.length()>7)
                {
                    tvM66.setPadding(0,0,0,8);
                }

                if (!M7.equals("null") && M7.length()>7)
                {
                    tvM77.setPadding(0,0,0,8);
                }

                if (!M8.equals("null") && M8.length()>7)
                {
                    tvM88.setPadding(0,0,0,8);
                }


                //1 СТРОКА
                if (M1.equals("null"))
                {
                    tvM1.setVisibility(View.GONE);
                    tvM11.setVisibility(View.GONE);
                    etM1DZ.setVisibility(View.GONE);
                    tvTimeM1.setVisibility(View.GONE);
                    tvTimeM2.setVisibility(View.GONE);
                    tvTimeM3.setVisibility(View.GONE);
                    tvTimeM4.setVisibility(View.GONE);
                    tvOcenkaM1.setVisibility(View.GONE);
                    tvTimeM11.setVisibility(View.GONE);
                    tvTimeM22.setVisibility(View.GONE);
                    tvTimeM33.setVisibility(View.GONE);
                }
                else
                {
                    tvM1.setVisibility(View.VISIBLE);
                    tvM11.setVisibility(View.VISIBLE);
                    etM1DZ.setVisibility(View.VISIBLE);
                    tvTimeM1.setVisibility(View.VISIBLE);
                    tvTimeM2.setVisibility(View.VISIBLE);
                    tvTimeM3.setVisibility(View.VISIBLE);
                    tvTimeM4.setVisibility(View.VISIBLE);
                    tvOcenkaM1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (M2.equals("null"))
                {
                    tvM2.setVisibility(View.GONE);
                    tvM22.setVisibility(View.GONE);
                    etM2DZ.setVisibility(View.GONE);
                    tvTimeM5.setVisibility(View.GONE);
                    tvTimeM6.setVisibility(View.GONE);
                    tvTimeM7.setVisibility(View.GONE);
                    tvTimeM8.setVisibility(View.GONE);
                    tvOcenkaM2.setVisibility(View.GONE);
                    tvTimeM51.setVisibility(View.GONE);
                    tvTimeM61.setVisibility(View.GONE);
                    tvTimeM71.setVisibility(View.GONE);
                }
                else
                {
                    tvM2.setVisibility(View.VISIBLE);
                    tvM22.setVisibility(View.VISIBLE);
                    etM2DZ.setVisibility(View.VISIBLE);
                    tvTimeM5.setVisibility(View.VISIBLE);
                    tvTimeM6.setVisibility(View.VISIBLE);
                    tvTimeM7.setVisibility(View.VISIBLE);
                    tvTimeM8.setVisibility(View.VISIBLE);
                    tvOcenkaM2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (M3.equals("null"))
                {
                    tvM3.setVisibility(View.GONE);
                    tvM33.setVisibility(View.GONE);
                    etM3DZ.setVisibility(View.GONE);
                    tvTimeM9.setVisibility(View.GONE);
                    tvTimeM10.setVisibility(View.GONE);
                    tvTimeM111.setVisibility(View.GONE);
                    tvTimeM12.setVisibility(View.GONE);
                    tvOcenkaM3.setVisibility(View.GONE);
                    tvTimeM91.setVisibility(View.GONE);
                    tvTimeM101.setVisibility(View.GONE);
                    tvTimeM112.setVisibility(View.GONE);
                }
                else
                {
                    tvM3.setVisibility(View.VISIBLE);
                    tvM33.setVisibility(View.VISIBLE);
                    etM3DZ.setVisibility(View.VISIBLE);
                    tvTimeM9.setVisibility(View.VISIBLE);
                    tvTimeM10.setVisibility(View.VISIBLE);
                    tvTimeM111.setVisibility(View.VISIBLE);
                    tvTimeM12.setVisibility(View.VISIBLE);
                    tvOcenkaM3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (M4.equals("null"))
                {
                    tvM4.setVisibility(View.GONE);
                    tvM44.setVisibility(View.GONE);
                    etM4DZ.setVisibility(View.GONE);
                    tvTimeM13.setVisibility(View.GONE);
                    tvTimeM14.setVisibility(View.GONE);
                    tvTimeM15.setVisibility(View.GONE);
                    tvTimeM16.setVisibility(View.GONE);
                    tvOcenkaM4.setVisibility(View.GONE);
                    tvTimeM131.setVisibility(View.GONE);
                    tvTimeM141.setVisibility(View.GONE);
                    tvTimeM151.setVisibility(View.GONE);
                }
                else
                {
                    tvM4.setVisibility(View.VISIBLE);
                    tvM44.setVisibility(View.VISIBLE);
                    etM4DZ.setVisibility(View.VISIBLE);
                    tvTimeM13.setVisibility(View.VISIBLE);
                    tvTimeM14.setVisibility(View.VISIBLE);
                    tvTimeM15.setVisibility(View.VISIBLE);
                    tvTimeM16.setVisibility(View.VISIBLE);
                    tvOcenkaM4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (M5.equals("null"))
                {
                    tvM5.setVisibility(View.GONE);
                    tvM55.setVisibility(View.GONE);
                    etM5DZ.setVisibility(View.GONE);
                    tvTimeM17.setVisibility(View.GONE);
                    tvTimeM18.setVisibility(View.GONE);
                    tvTimeM19.setVisibility(View.GONE);
                    tvTimeM20.setVisibility(View.GONE);
                    tvOcenkaM5.setVisibility(View.GONE);
                    tvTimeM171.setVisibility(View.GONE);
                    tvTimeM181.setVisibility(View.GONE);
                    tvTimeM191.setVisibility(View.GONE);
                }
                else
                {
                    tvM5.setVisibility(View.VISIBLE);
                    tvM55.setVisibility(View.VISIBLE);
                    etM5DZ.setVisibility(View.VISIBLE);
                    tvTimeM17.setVisibility(View.VISIBLE);
                    tvTimeM18.setVisibility(View.VISIBLE);
                    tvTimeM19.setVisibility(View.VISIBLE);
                    tvTimeM20.setVisibility(View.VISIBLE);
                    tvOcenkaM5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (M6.equals("null"))
                {
                    tvM6.setVisibility(View.GONE);
                    tvM66.setVisibility(View.GONE);
                    etM6DZ.setVisibility(View.GONE);
                    tvTimeM21.setVisibility(View.GONE);
                    tvTimeM222.setVisibility(View.GONE);
                    tvTimeM23.setVisibility(View.GONE);
                    tvTimeM24.setVisibility(View.GONE);
                    tvOcenkaM6.setVisibility(View.GONE);
                    tvTimeM211.setVisibility(View.GONE);
                    tvTimeM231.setVisibility(View.GONE);
                    tvTimeM221.setVisibility(View.GONE);
                }
                else
                {
                    tvM6.setVisibility(View.VISIBLE);
                    tvM66.setVisibility(View.VISIBLE);
                    etM6DZ.setVisibility(View.VISIBLE);
                    tvTimeM21.setVisibility(View.VISIBLE);
                    tvTimeM222.setVisibility(View.VISIBLE);
                    tvTimeM23.setVisibility(View.VISIBLE);
                    tvTimeM24.setVisibility(View.VISIBLE);
                    tvOcenkaM6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (M7.equals("null"))
                {
                    tvM7.setVisibility(View.GONE);
                    tvM77.setVisibility(View.GONE);
                    etM7DZ.setVisibility(View.GONE);
                    tvTimeM25.setVisibility(View.GONE);
                    tvTimeM26.setVisibility(View.GONE);
                    tvTimeM27.setVisibility(View.GONE);
                    tvTimeM28.setVisibility(View.GONE);
                    tvOcenkaM7.setVisibility(View.GONE);
                    tvTimeM251.setVisibility(View.GONE);
                    tvTimeM261.setVisibility(View.GONE);
                    tvTimeM271.setVisibility(View.GONE);
                }
                else
                {
                    tvM7.setVisibility(View.VISIBLE);
                    tvM77.setVisibility(View.VISIBLE);
                    etM7DZ.setVisibility(View.VISIBLE);
                    tvTimeM25.setVisibility(View.VISIBLE);
                    tvTimeM26.setVisibility(View.VISIBLE);
                    tvTimeM27.setVisibility(View.VISIBLE);
                    tvTimeM28.setVisibility(View.VISIBLE);
                    tvOcenkaM7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (M8.equals("null"))
                {
                    tvM8.setVisibility(View.GONE);
                    tvM88.setVisibility(View.GONE);
                    etM8DZ.setVisibility(View.GONE);
                    tvTimeM29.setVisibility(View.GONE);
                    tvTimeM30.setVisibility(View.GONE);
                    tvTimeM31.setVisibility(View.GONE);
                    tvTimeM32.setVisibility(View.GONE);
                    tvOcenkaM8.setVisibility(View.GONE);
                    tvTimeM291.setVisibility(View.GONE);
                    tvTimeM301.setVisibility(View.GONE);
                    tvTimeM311.setVisibility(View.GONE);
                }
                else
                {
                    tvM8.setVisibility(View.VISIBLE);
                    tvM88.setVisibility(View.VISIBLE);
                    etM8DZ.setVisibility(View.VISIBLE);
                    tvTimeM29.setVisibility(View.VISIBLE);
                    tvTimeM30.setVisibility(View.VISIBLE);
                    tvTimeM31.setVisibility(View.VISIBLE);
                    tvTimeM32.setVisibility(View.VISIBLE);
                    tvOcenkaM8.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                tvM1.setText("");
                tvM2.setText("");
                tvM3.setText("");
                tvM4.setText("");
                tvM5.setText("");
                tvM6.setText("");
                tvM7.setText("");
                tvM8.setText("");
            }
        });


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            etM1DZ.setMaxWidth(500);
        }
        else
        {
            etM1DZ.setWidth(120);
        }
        

        /*if(Mcb2.isChecked())
        {
            SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SPEditor = SP.edit();
            SPEditor.putInt("MCheck1",1);
            SPEditor.apply();
        }
        else
        {
            SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SPEditor = SP.edit();
            SPEditor.putInt("MCheck1",0);
            SPEditor.commit();
        }*/

        /*etM1DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb1.setChecked(false);
                SPEditor.putInt("MCheck1",1);
                SPEditor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }



        });

        etM2DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb2.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        etM3DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb3.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etM4DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb4.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etM5DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb5.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etM6DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb6.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etM7DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb7.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etM8DZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Mcb8.setChecked(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/


        loadText();

        return v;
    }

    private void saveText() {

        String sM1Dz = etM1DZ.getText().toString();
        String sM2Dz = etM2DZ.getText().toString();
        String sM3Dz = etM3DZ.getText().toString();
        String sM4Dz = etM4DZ.getText().toString();
        String sM5Dz = etM5DZ.getText().toString();
        String sM6Dz = etM6DZ.getText().toString();
        String sM7Dz = etM7DZ.getText().toString();
        String sM8Dz = etM8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        if(sM1Dz.length()!=0) {
            reff.child("M1Dz").setValue(sM1Dz);
        }
        else
        {
            reff.child("M1Dz").removeValue();
        }

        if(sM2Dz.length()!=0) {
            reff.child("M2Dz").setValue(sM2Dz);
        }
        else
        {
            reff.child("M2Dz").removeValue();
        }

        if(sM3Dz.length()!=0) {
            reff.child("M3Dz").setValue(sM3Dz);
        }
        else
        {
            reff.child("M3Dz").removeValue();
        }

        if(sM4Dz.length()!=0) {
            reff.child("M4Dz").setValue(sM4Dz);
        }
        else
        {
            reff.child("M4Dz").removeValue();
        }

        if(sM5Dz.length()!=0) {
            reff.child("M5Dz").setValue(sM5Dz);
        }
        else
        {
            reff.child("M5Dz").removeValue();
        }

        if(sM6Dz.length()!=0) {
            reff.child("M6Dz").setValue(sM6Dz);
        }
        else
        {
            reff.child("M6Dz").removeValue();
        }

        if(sM7Dz.length()!=0) {
            reff.child("M7Dz").setValue(sM7Dz);
        }
        else
        {
            reff.child("M7Dz").removeValue();
        }

        if(sM8Dz.length()!=0) {
            reff.child("M8Dz").setValue(sM8Dz);
        }
        else
        {
            reff.child("M8Dz").removeValue();
        }
    }


    private void loadText()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sM1DZ = String.valueOf(snapshot.child("M1Dz").getValue());
                String sM2DZ = String.valueOf(snapshot.child("M2Dz").getValue());
                String sM3DZ = String.valueOf(snapshot.child("M3Dz").getValue());
                String sM4DZ = String.valueOf(snapshot.child("M4Dz").getValue());
                String sM5DZ = String.valueOf(snapshot.child("M5Dz").getValue());
                String sM6DZ = String.valueOf(snapshot.child("M6Dz").getValue());
                String sM7DZ = String.valueOf(snapshot.child("M7Dz").getValue());
                String sM8DZ = String.valueOf(snapshot.child("M8Dz").getValue());

                if (snapshot.child("M1Dz").exists()) {
                    etM1DZ.setText(sM1DZ);
                }
                else
                {
                    etM1DZ.setText("");
                }

                if (snapshot.child("M2Dz").exists()) {
                    etM2DZ.setText(sM2DZ);
                }
                else
                {
                    etM2DZ.setText("");
                }

                if (snapshot.child("M3Dz").exists()) {
                    etM3DZ.setText(sM3DZ);
                }
                else
                {
                    etM3DZ.setText("");
                }

                if (snapshot.child("M4Dz").exists()) {
                    etM4DZ.setText(sM4DZ);
                }
                else
                {
                    etM4DZ.setText("");
                }

                if (snapshot.child("M5Dz").exists()) {
                    etM5DZ.setText(sM5DZ);
                }
                else
                {
                    etM5DZ.setText("");
                }

                if (snapshot.child("M6Dz").exists()) {
                    etM6DZ.setText(sM6DZ);
                }
                else
                {
                    etM6DZ.setText("");
                }

                if (snapshot.child("M7Dz").exists()) {
                    etM7DZ.setText(sM7DZ);
                }
                else
                {
                    etM7DZ.setText("");
                }

                if (snapshot.child("M8Dz").exists()) {
                    etM8DZ.setText(sM8DZ);
                }
                else
                {
                    etM8DZ.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    /*private void Ms1(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb1", isChecked);
        editor.apply();
    }

    private boolean Ml1()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb1", false);
    }

    private void Ms2(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb2", isChecked);
        editor.apply();
    }

    private boolean Ml2()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb2", false);
    }

    private void Ms3(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb3", isChecked);
        editor.apply();
    }

    private boolean Ml3()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb3", false);
    }

    private void Ms4(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb4", isChecked);
        editor.apply();
    }

    private boolean Ml4()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb4", false);
    }

    private void Ms5(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb5", isChecked);
        editor.apply();
    }

    private boolean Ml5()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb5", false);
    }

    private void Ms6(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb6", isChecked);
        editor.apply();
    }

    private boolean Ml6()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb6", false);
    }

    private void Ms7(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb7", isChecked);
        editor.apply();
    }

    private boolean Ml7()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb7", false);
    }

    private void Ms8(final boolean isChecked)
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Mcb8", isChecked);
        editor.apply();
    }

    private boolean Ml8()
    {
        SharedPreferences sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Mcb8", false);
    }*/

    @Override
    public void onPause() {
        super.onPause();
        /*Ms1(Mcb1.isChecked());
        Ms2(Mcb2.isChecked());
        Ms3(Mcb3.isChecked());
        Ms4(Mcb4.isChecked());
        Ms5(Mcb5.isChecked());
        Ms6(Mcb6.isChecked());
        Ms7(Mcb7.isChecked());
        Ms8(Mcb8.isChecked());*/
    }

    @Override
    public void onResume() {
        super.onResume();
        /*Mcb1.setChecked(Ml1());
        Mcb2.setChecked(Ml2());
        Mcb3.setChecked(Ml3());
        Mcb4.setChecked(Ml4());
        Mcb5.setChecked(Ml5());
        Mcb6.setChecked(Ml6());
        Mcb7.setChecked(Ml7());
        Mcb8.setChecked(Ml8());*/
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        saveText();

    }

    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new StudyFragment());
        transaction.commit();
    }
}