package ru.shkolaandstudents.Teacher;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.ui.main.StudyFragment;

public class TeacherFragmentRaspMond extends Fragment implements OnBackPressedListener {

    TextView tvMSub11,tvMSub22,tvMSub33,tvMSub44,tvMSub55,tvMSub66,tvMSub77,tvMSub88,tvM1,tvM2,tvM3,tvM4,tvM5,tvM6,tvM7,tvM8,tvTimeM1,tvTimeM2,tvTimeM3,tvTimeM4,tvTimeM5,tvTimeM6,tvTimeM7,tvTimeM8,tvTimeM9,tvTimeM10,tvTimeM111,tvTimeM12,tvTimeM13,tvTimeM14,tvTimeM15,tvTimeM16,tvTimeM17,tvTimeM18,tvTimeM19,tvTimeM20,tvTimeM21,tvTimeM222,tvTimeM23,tvTimeM24,tvTimeM25,tvTimeM26,tvTimeM27,tvTimeM28,tvTimeM29,tvTimeM30,tvTimeM31,tvTimeM32;
    TextView tvMClass11,tvMClass22,tvMClass33,tvMClass44,tvMClass55,tvMClass66,tvMClass77,tvMClass88;
    TextView tvTimeM11,tvTimeM22,tvTimeM33,tvTimeM51,tvTimeM61,tvTimeM71,tvTimeM91,tvTimeM101,tvTimeM112,tvTimeM131,tvTimeM141,tvTimeM151,tvTimeM171,tvTimeM181,tvTimeM191,tvTimeM211,tvTimeM221,tvTimeM231,tvTimeM251,tvTimeM261,tvTimeM271,tvTimeM291,tvTimeM301,tvTimeM311;
    Button btnHelp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.teacher_fragment_rasp_mond, container, false);

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
                                TapTarget.forView(v.findViewById(R.id.tvMSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvMClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
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

        tvMSub11 = v.findViewById(R.id.tvMSub11); tvMClass22 = v.findViewById(R.id.tvMClass22);
        tvMSub22 = v.findViewById(R.id.tvMSub22); tvMClass11 = v.findViewById(R.id.tvMClass11);
        tvMSub33 = v.findViewById(R.id.tvMSub33); tvMClass33 = v.findViewById(R.id.tvMClass33);
        tvMSub44 = v.findViewById(R.id.tvMSub44); tvMClass66 = v.findViewById(R.id.tvMClass66);
        tvMSub55 = v.findViewById(R.id.tvMSub55); tvMClass44 = v.findViewById(R.id.tvMClass44);
        tvMSub66 = v.findViewById(R.id.tvMSub66); tvMClass77 = v.findViewById(R.id.tvMClass77);
        tvMSub77 = v.findViewById(R.id.tvMSub77); tvMClass55 = v.findViewById(R.id.tvMClass55);
        tvMSub88 = v.findViewById(R.id.tvMSub88); tvMClass88 = v.findViewById(R.id.tvMClass88);


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
        tvMClass11 = v.findViewById(R.id.tvMClass11);
        tvMClass22 = v.findViewById(R.id.tvMClass22);
        tvMClass33 = v.findViewById(R.id.tvMClass33);
        tvMClass44 = v.findViewById(R.id.tvMClass44);
        tvMClass55 = v.findViewById(R.id.tvMClass55);
        tvMClass66 = v.findViewById(R.id.tvMClass66);
        tvMClass77 = v.findViewById(R.id.tvMClass77);
        tvMClass88 = v.findViewById(R.id.tvMClass88);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String M1Sub = SP.getString("M1Sub", "");
        String M2Sub = SP.getString("M2Sub", "");
        String M3Sub = SP.getString("M3Sub", "");
        String M4Sub = SP.getString("M4Sub", "");
        String M5Sub = SP.getString("M5Sub", "");
        String M6Sub = SP.getString("M6Sub", "");
        String M7Sub = SP.getString("M7Sub", "");
        String M8Sub = SP.getString("M8Sub", "");
        
        String M1Class = SP.getString("M1Class", "");
        String M2Class = SP.getString("M2Class", "");
        String M3Class = SP.getString("M3Class", "");
        String M4Class = SP.getString("M4Class", "");
        String M5Class = SP.getString("M5Class", "");
        String M6Class = SP.getString("M6Class", "");
        String M7Class = SP.getString("M7Class", "");
        String M8Class = SP.getString("M8Class", "");
        
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

        tvMSub11.setText(M1Sub);
        tvMSub22.setText(M2Sub);
        tvMSub33.setText(M3Sub);
        tvMSub44.setText(M4Sub);
        tvMSub55.setText(M5Sub);
        tvMSub66.setText(M6Sub);
        tvMSub77.setText(M7Sub);
        tvMSub88.setText(M8Sub);
        //////////////////
        tvMClass11.setText(M1Class);
        tvMClass22.setText(M2Class);
        tvMClass33.setText(M3Class);
        tvMClass44.setText(M4Class);
        tvMClass55.setText(M5Class);
        tvMClass66.setText(M6Class);
        tvMClass77.setText(M7Class);
        tvMClass88.setText(M8Class);
        //////////////////
        tvTimeM1.setText(T11);
        tvTimeM2.setText(T12);
        tvTimeM3.setText(T13);
        tvTimeM4.setText(T14);
        //////////////////
        tvTimeM5.setText(T21);
        tvTimeM6.setText(T22);
        tvTimeM7.setText(T23);
        tvTimeM8.setText(T24);
        /////////////////////
        tvTimeM9.setText(T31);
        tvTimeM10.setText(T32);
        tvTimeM111.setText(T33);
        tvTimeM12.setText(T34);
        ////////////////////////
        tvTimeM13.setText(T41);
        tvTimeM14.setText(T42);
        tvTimeM15.setText(T43);
        tvTimeM16.setText(T44);
        //////////////////////
        tvTimeM17.setText(T51);
        tvTimeM18.setText(T52);
        tvTimeM19.setText(T53);
        tvTimeM20.setText(T54);
        //////////////////////
        tvTimeM21.setText(T61);
        tvTimeM222.setText(T62);
        tvTimeM23.setText(T63);
        tvTimeM24.setText(T64);
        //////////////////////
        tvTimeM25.setText(T71);
        tvTimeM26.setText(T72);
        tvTimeM27.setText(T73);
        tvTimeM28.setText(T74);
        ///////////////////////
        tvTimeM29.setText(T81);
        tvTimeM30.setText(T82);
        tvTimeM31.setText(T83);
        tvTimeM32.setText(T84);
        ///////////////////////

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            tvMClass11.setMaxWidth(500);
        }
        else
        {
            tvMClass11.setWidth(120);
        }

        if (M1Sub.length()>7)
        {
            tvMSub11.setPadding(0,0,0,8);
        }

        if (M2Sub.length()>7)
        {
            tvMSub22.setPadding(0,0,0,8);
        }

        if (M3Sub.length()>7)
        {
            tvMSub33.setPadding(0,0,0,8);
        }

        if (M4Sub.length()>7)
        {
            tvMSub44.setPadding(0,0,0,8);
        }

        if (M5Sub.length()>7)
        {
            tvMSub55.setPadding(0,0,0,8);
        }

        if (M6Sub.length()>7)
        {
            tvMSub66.setPadding(0,0,0,8);
        }

        if (M7Sub.length()>7)
        {
            tvMSub77.setPadding(0,0,0,8);
        }

        if (M8Sub.length()>7)
        {
            tvMSub88.setPadding(0,0,0,8);
        }

        if(T11.length()==0)
        {
            tvTimeM11.setVisibility(View.GONE);
            tvTimeM22.setVisibility(View.GONE);
            tvTimeM33.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM11.setVisibility(View.VISIBLE);
            tvTimeM22.setVisibility(View.VISIBLE);
            tvTimeM33.setVisibility(View.VISIBLE);
        }

        if(T21.length()==0)
        {
            tvTimeM51.setVisibility(View.GONE);
            tvTimeM61.setVisibility(View.GONE);
            tvTimeM71.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM51.setVisibility(View.VISIBLE);
            tvTimeM61.setVisibility(View.VISIBLE);
            tvTimeM71.setVisibility(View.VISIBLE);
        }

        if(T31.length()==0)
        {
            tvTimeM91.setVisibility(View.GONE);
            tvTimeM101.setVisibility(View.GONE);
            tvTimeM112.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM91.setVisibility(View.VISIBLE);
            tvTimeM101.setVisibility(View.VISIBLE);
            tvTimeM112.setVisibility(View.VISIBLE);
        }

        if(T41.length()==0)
        {
            tvTimeM131.setVisibility(View.GONE);
            tvTimeM141.setVisibility(View.GONE);
            tvTimeM151.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM131.setVisibility(View.VISIBLE);
            tvTimeM141.setVisibility(View.VISIBLE);
            tvTimeM151.setVisibility(View.VISIBLE);
        }

        if(T51.length()==0)
        {
            tvTimeM171.setVisibility(View.GONE);
            tvTimeM181.setVisibility(View.GONE);
            tvTimeM191.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM171.setVisibility(View.VISIBLE);
            tvTimeM181.setVisibility(View.VISIBLE);
            tvTimeM191.setVisibility(View.VISIBLE);
        }

        if(T61.length()==0)
        {
            tvTimeM211.setVisibility(View.GONE);
            tvTimeM231.setVisibility(View.GONE);
            tvTimeM221.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM211.setVisibility(View.VISIBLE);
            tvTimeM231.setVisibility(View.VISIBLE);
            tvTimeM221.setVisibility(View.VISIBLE);
        }

        if(T71.length()==0)
        {
            tvTimeM251.setVisibility(View.GONE);
            tvTimeM261.setVisibility(View.GONE);
            tvTimeM271.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM251.setVisibility(View.VISIBLE);
            tvTimeM261.setVisibility(View.VISIBLE);
            tvTimeM271.setVisibility(View.VISIBLE);
        }

        if(T81.length()==0)
        {
            tvTimeM291.setVisibility(View.GONE);
            tvTimeM301.setVisibility(View.GONE);
            tvTimeM311.setVisibility(View.GONE);
        }
        else
        {
            tvTimeM291.setVisibility(View.VISIBLE);
            tvTimeM301.setVisibility(View.VISIBLE);
            tvTimeM311.setVisibility(View.VISIBLE);
        }

        //1 СТРОКА
        if (tvMSub11.getText().toString().isEmpty())
        {
            tvM1.setVisibility(View.GONE);
            tvMSub11.setVisibility(View.GONE);
            tvMClass11.setVisibility(View.GONE);
            tvTimeM1.setVisibility(View.GONE);
            tvTimeM2.setVisibility(View.GONE);
            tvTimeM3.setVisibility(View.GONE);
            tvTimeM4.setVisibility(View.GONE);
            tvTimeM11.setVisibility(View.GONE);
            tvTimeM22.setVisibility(View.GONE);
            tvTimeM33.setVisibility(View.GONE);
        }
        else
        {
            tvM1.setVisibility(View.VISIBLE);
            tvMSub11.setVisibility(View.VISIBLE);
            tvMClass11.setVisibility(View.VISIBLE);
            tvTimeM1.setVisibility(View.VISIBLE);
            tvTimeM2.setVisibility(View.VISIBLE);
            tvTimeM3.setVisibility(View.VISIBLE);
            tvTimeM4.setVisibility(View.VISIBLE);
        }

        //2 строка
        if (tvMSub22.getText().toString().isEmpty())
        {
            tvM2.setVisibility(View.GONE);
            tvMSub22.setVisibility(View.GONE);
            tvMClass22.setVisibility(View.GONE);
            tvTimeM5.setVisibility(View.GONE);
            tvTimeM6.setVisibility(View.GONE);
            tvTimeM7.setVisibility(View.GONE);
            tvTimeM8.setVisibility(View.GONE);
            tvTimeM51.setVisibility(View.GONE);
            tvTimeM61.setVisibility(View.GONE);
            tvTimeM71.setVisibility(View.GONE);
        }
        else
        {
            tvM2.setVisibility(View.VISIBLE);
            tvMSub22.setVisibility(View.VISIBLE);
            tvMClass22.setVisibility(View.VISIBLE);
            tvTimeM5.setVisibility(View.VISIBLE);
            tvTimeM6.setVisibility(View.VISIBLE);
            tvTimeM7.setVisibility(View.VISIBLE);
            tvTimeM8.setVisibility(View.VISIBLE);
        }

        //3 строка
        if (tvMSub33.getText().toString().isEmpty())
        {
            tvM3.setVisibility(View.GONE);
            tvMSub33.setVisibility(View.GONE);
            tvMClass33.setVisibility(View.GONE);
            tvTimeM9.setVisibility(View.GONE);
            tvTimeM10.setVisibility(View.GONE);
            tvTimeM111.setVisibility(View.GONE);
            tvTimeM12.setVisibility(View.GONE);
            tvTimeM91.setVisibility(View.GONE);
            tvTimeM101.setVisibility(View.GONE);
            tvTimeM112.setVisibility(View.GONE);
        }
        else
        {
            tvM3.setVisibility(View.VISIBLE);
            tvMSub33.setVisibility(View.VISIBLE);
            tvMClass33.setVisibility(View.VISIBLE);
            tvTimeM9.setVisibility(View.VISIBLE);
            tvTimeM10.setVisibility(View.VISIBLE);
            tvTimeM111.setVisibility(View.VISIBLE);
            tvTimeM12.setVisibility(View.VISIBLE);
        }

        //4 строка
        if (tvMSub44.getText().toString().isEmpty())
        {
            tvM4.setVisibility(View.GONE);
            tvMSub44.setVisibility(View.GONE);
            tvMClass44.setVisibility(View.GONE);
            tvTimeM13.setVisibility(View.GONE);
            tvTimeM14.setVisibility(View.GONE);
            tvTimeM15.setVisibility(View.GONE);
            tvTimeM16.setVisibility(View.GONE);
            tvTimeM131.setVisibility(View.GONE);
            tvTimeM141.setVisibility(View.GONE);
            tvTimeM151.setVisibility(View.GONE);
        }
        else
        {
            tvM4.setVisibility(View.VISIBLE);
            tvMSub44.setVisibility(View.VISIBLE);
            tvMClass44.setVisibility(View.VISIBLE);
            tvTimeM13.setVisibility(View.VISIBLE);
            tvTimeM14.setVisibility(View.VISIBLE);
            tvTimeM15.setVisibility(View.VISIBLE);
            tvTimeM16.setVisibility(View.VISIBLE);
        }

        //5 строка
        if (tvMSub55.getText().toString().isEmpty())
        {
            tvM5.setVisibility(View.GONE);
            tvMSub55.setVisibility(View.GONE);
            tvMClass55.setVisibility(View.GONE);
            tvTimeM17.setVisibility(View.GONE);
            tvTimeM18.setVisibility(View.GONE);
            tvTimeM19.setVisibility(View.GONE);
            tvTimeM20.setVisibility(View.GONE);
            tvTimeM171.setVisibility(View.GONE);
            tvTimeM181.setVisibility(View.GONE);
            tvTimeM191.setVisibility(View.GONE);
        }
        else
        {
            tvM5.setVisibility(View.VISIBLE);
            tvMSub55.setVisibility(View.VISIBLE);
            tvMClass55.setVisibility(View.VISIBLE);
            tvTimeM17.setVisibility(View.VISIBLE);
            tvTimeM18.setVisibility(View.VISIBLE);
            tvTimeM19.setVisibility(View.VISIBLE);
            tvTimeM20.setVisibility(View.VISIBLE);
        }

        //6 строка
        if (tvMSub66.getText().toString().isEmpty())
        {
            tvM6.setVisibility(View.GONE);
            tvMSub66.setVisibility(View.GONE);
            tvMClass66.setVisibility(View.GONE);
            tvTimeM21.setVisibility(View.GONE);
            tvTimeM222.setVisibility(View.GONE);
            tvTimeM23.setVisibility(View.GONE);
            tvTimeM24.setVisibility(View.GONE);
            tvTimeM211.setVisibility(View.GONE);
            tvTimeM231.setVisibility(View.GONE);
            tvTimeM221.setVisibility(View.GONE);
        }
        else
        {
            tvM6.setVisibility(View.VISIBLE);
            tvMSub66.setVisibility(View.VISIBLE);
            tvMClass66.setVisibility(View.VISIBLE);
            tvTimeM21.setVisibility(View.VISIBLE);
            tvTimeM222.setVisibility(View.VISIBLE);
            tvTimeM23.setVisibility(View.VISIBLE);
            tvTimeM24.setVisibility(View.VISIBLE);
        }

        //7 строка
        if (tvMSub77.getText().toString().isEmpty())
        {
            tvM7.setVisibility(View.GONE);
            tvMSub77.setVisibility(View.GONE);
            tvMClass77.setVisibility(View.GONE);
            tvTimeM25.setVisibility(View.GONE);
            tvTimeM26.setVisibility(View.GONE);
            tvTimeM27.setVisibility(View.GONE);
            tvTimeM28.setVisibility(View.GONE);
            tvTimeM251.setVisibility(View.GONE);
            tvTimeM261.setVisibility(View.GONE);
            tvTimeM271.setVisibility(View.GONE);
        }
        else
        {
            tvM7.setVisibility(View.VISIBLE);
            tvMSub77.setVisibility(View.VISIBLE);
            tvMClass77.setVisibility(View.VISIBLE);
            tvTimeM25.setVisibility(View.VISIBLE);
            tvTimeM26.setVisibility(View.VISIBLE);
            tvTimeM27.setVisibility(View.VISIBLE);
            tvTimeM28.setVisibility(View.VISIBLE);
        }

        //8 строка
        if (tvMSub88.getText().toString().isEmpty())
        {
            tvM8.setVisibility(View.GONE);
            tvMSub88.setVisibility(View.GONE);
            tvMClass88.setVisibility(View.GONE);
            tvTimeM29.setVisibility(View.GONE);
            tvTimeM30.setVisibility(View.GONE);
            tvTimeM31.setVisibility(View.GONE);
            tvTimeM32.setVisibility(View.GONE);
            tvTimeM291.setVisibility(View.GONE);
            tvTimeM301.setVisibility(View.GONE);
            tvTimeM311.setVisibility(View.GONE);
        }
        else
        {
            tvM8.setVisibility(View.VISIBLE);
            tvMSub88.setVisibility(View.VISIBLE);
            tvMClass88.setVisibility(View.VISIBLE);
            tvTimeM29.setVisibility(View.VISIBLE);
            tvTimeM30.setVisibility(View.VISIBLE);
            tvTimeM31.setVisibility(View.VISIBLE);
            tvTimeM32.setVisibility(View.VISIBLE);
        }

        return v;
    }


    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new TeacherFragmentRasp());
        transaction.commit();
    }
}