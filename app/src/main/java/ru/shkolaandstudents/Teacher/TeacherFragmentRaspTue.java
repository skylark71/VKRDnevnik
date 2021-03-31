package ru.shkolaandstudents.Teacher;


import android.content.SharedPreferences;
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


public class TeacherFragmentRaspTue extends Fragment implements OnBackPressedListener {

    TextView tvT11, tvTimeT12,tvTimeT13,tvTimeT14,tvTimeT15,tvTimeT16,tvTimeT17,tvTimeT18,tvT2,tvTimeT21,tvTimeT22,tvTimeT23,tvTimeT24,tvTimeT25,tvTimeT26,tvTimeT27,tvT3,tvTimeT31,tvTimeT32,tvTimeT33,tvTimeT34,tvTimeT35,tvTimeT36,tvTimeT37,tvT4,tvTimeT41,tvTimeT42,tvTimeT43,tvTimeT44,tvTimeT45,tvTimeT46,tvTimeT47,tvT5,tvTimeT51,tvTimeT52,tvTimeT53,tvTimeT54,tvTimeT55,tvTimeT56,tvTimeT57,tvT6,tvTimeT61,tvTimeT62,tvTimeT63,tvTimeT64,tvTimeT65,tvTimeT66,tvTimeT67,tvT7,tvTimeT71,tvTimeT72,tvTimeT73,tvTimeT74,tvTimeT75,tvTimeT76,tvTimeT77,tvT8,tvTimeT81,tvTimeT82,tvTimeT83,tvTimeT84,tvTimeT85,tvTimeT86,tvTimeT87;
    TextView tvTSub19,tvTSub22,tvTSub33,tvTSub44,tvTSub55,tvTSub66,tvTSub77,tvTSub88;
    TextView tvTClass19,tvTClass22,tvTClass33,tvTClass44,tvTClass55,tvTClass66,tvTClass77,tvTClass88;
    Button btnHelp;

    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new TeacherFragmentRasp());
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_tue, container, false);


        btnHelp = v.findViewById(R.id.btnTueHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvT11), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeT13), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeT17), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTSub19), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTClass19), "Класс", getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday))
                        .listener(new TapTargetSequence.Listener() {
                            @Override
                            public void onSequenceFinish() {
                            }

                            @Override
                            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                            }

                            @Override
                            public void onSequenceCanceled(TapTarget lastTarget) {
                            }
                        }).start();
            }
        });

        tvT11 = v.findViewById(R.id.tvT11);
        tvT2 = v.findViewById(R.id.tvT2);
        tvT3 = v.findViewById(R.id.tvT3);
        tvT4 = v.findViewById(R.id.tvT4);
        tvT5 = v.findViewById(R.id.tvT5);
        tvT6 = v.findViewById(R.id.tvT6);
        tvT7 = v.findViewById(R.id.tvT7);
        tvT8 = v.findViewById(R.id.tvT8);
        
        tvTimeT12 = v.findViewById(R.id.tvTimeT12);
        tvTimeT21 = v.findViewById(R.id.tvTimeT21);
        tvTimeT31 = v.findViewById(R.id.tvTimeT31);
        tvTimeT41 = v.findViewById(R.id.tvTimeT41);
        tvTimeT51 = v.findViewById(R.id.tvTimeT51);
        tvTimeT61 = v.findViewById(R.id.tvTimeT61);
        tvTimeT71 = v.findViewById(R.id.tvTimeT71);
        tvTimeT81 = v.findViewById(R.id.tvTimeT81);
        tvTimeT13 = v.findViewById(R.id.tvTimeT13);
        tvTimeT22 = v.findViewById(R.id.tvTimeT22);
        tvTimeT32 = v.findViewById(R.id.tvTimeT32);
        tvTimeT42 = v.findViewById(R.id.tvTimeT42);
        tvTimeT52 = v.findViewById(R.id.tvTimeT52);
        tvTimeT62 = v.findViewById(R.id.tvTimeT62);
        tvTimeT72 = v.findViewById(R.id.tvTimeT72);
        tvTimeT82 = v.findViewById(R.id.tvTimeT82);
        tvTimeT14 = v.findViewById(R.id.tvTimeT14);
        tvTimeT23 = v.findViewById(R.id.tvTimeT23);
        tvTimeT33 = v.findViewById(R.id.tvTimeT33);
        tvTimeT43 = v.findViewById(R.id.tvTimeT43);
        tvTimeT53 = v.findViewById(R.id.tvTimeT53);
        tvTimeT63 = v.findViewById(R.id.tvTimeT63);
        tvTimeT73 = v.findViewById(R.id.tvTimeT73);
        tvTimeT83 = v.findViewById(R.id.tvTimeT83);
        tvTimeT15 = v.findViewById(R.id.tvTimeT15);
        tvTimeT24 = v.findViewById(R.id.tvTimeT24);
        tvTimeT34 = v.findViewById(R.id.tvTimeT34);
        tvTimeT44 = v.findViewById(R.id.tvTimeT44);
        tvTimeT54 = v.findViewById(R.id.tvTimeT54);
        tvTimeT64 = v.findViewById(R.id.tvTimeT64);
        tvTimeT74 = v.findViewById(R.id.tvTimeT74);
        tvTimeT84 = v.findViewById(R.id.tvTimeT84);
        tvTimeT16 = v.findViewById(R.id.tvTimeT16);
        tvTimeT25 = v.findViewById(R.id.tvTimeT25);
        tvTimeT35 = v.findViewById(R.id.tvTimeT35);
        tvTimeT45 = v.findViewById(R.id.tvTimeT45);
        tvTimeT55 = v.findViewById(R.id.tvTimeT55);
        tvTimeT65 = v.findViewById(R.id.tvTimeT65);
        tvTimeT75 = v.findViewById(R.id.tvTimeT75);
        tvTimeT85 = v.findViewById(R.id.tvTimeT85);
        tvTimeT17 = v.findViewById(R.id.tvTimeT17);
        tvTimeT26 = v.findViewById(R.id.tvTimeT26);
        tvTimeT36 = v.findViewById(R.id.tvTimeT36);
        tvTimeT46 = v.findViewById(R.id.tvTimeT46);
        tvTimeT56 = v.findViewById(R.id.tvTimeT56);
        tvTimeT66 = v.findViewById(R.id.tvTimeT66);
        tvTimeT76 = v.findViewById(R.id.tvTimeT76);
        tvTimeT86 = v.findViewById(R.id.tvTimeT86);
        tvTimeT18 = v.findViewById(R.id.tvTimeT18);
        tvTimeT27 = v.findViewById(R.id.tvTimeT27);
        tvTimeT37 = v.findViewById(R.id.tvTimeT37);
        tvTimeT47 = v.findViewById(R.id.tvTimeT47);
        tvTimeT57 = v.findViewById(R.id.tvTimeT57);
        tvTimeT67 = v.findViewById(R.id.tvTimeT67);
        tvTimeT77 = v.findViewById(R.id.tvTimeT77);
        tvTimeT87 = v.findViewById(R.id.tvTimeT87);
        tvTSub19 = v.findViewById(R.id.tvTSub19);
        tvTSub22 = v.findViewById(R.id.tvTSub22);
        tvTSub33 = v.findViewById(R.id.tvTSub33);
        tvTSub44 = v.findViewById(R.id.tvTSub44);
        tvTSub55 = v.findViewById(R.id.tvTSub55);
        tvTSub66 = v.findViewById(R.id.tvTSub66);
        tvTSub77 = v.findViewById(R.id.tvTSub77);
        tvTSub88 = v.findViewById(R.id.tvTSub88);
        tvTClass19 = v.findViewById(R.id.tvTClass19);
        tvTClass22 = v.findViewById(R.id.tvTClass22);
        tvTClass33 = v.findViewById(R.id.tvTClass33);
        tvTClass44 = v.findViewById(R.id.tvTClass44);
        tvTClass55 = v.findViewById(R.id.tvTClass55);
        tvTClass66 = v.findViewById(R.id.tvTClass66);
        tvTClass77 = v.findViewById(R.id.tvTClass77);
        tvTClass88 = v.findViewById(R.id.tvTClass88);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String T1Sub = SP.getString("T1Sub", "");
        String T2Sub = SP.getString("T2Sub", "");
        String T3Sub = SP.getString("T3Sub", "");
        String T4Sub = SP.getString("T4Sub", "");
        String T5Sub = SP.getString("T5Sub", "");
        String T6Sub = SP.getString("T6Sub", "");
        String T7Sub = SP.getString("T7Sub", "");
        String T8Sub = SP.getString("T8Sub", "");

        String T1Class = SP.getString("T1Class", "");
        String T2Class = SP.getString("T2Class", "");
        String T3Class = SP.getString("T3Class", "");
        String T4Class = SP.getString("T4Class", "");
        String T5Class = SP.getString("T5Class", "");
        String T6Class = SP.getString("T6Class", "");
        String T7Class = SP.getString("T7Class", "");
        String T8Class = SP.getString("T8Class", "");
        
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

        tvTSub19.setText(T1Sub);
        tvTSub22.setText(T2Sub);
        tvTSub33.setText(T3Sub);
        tvTSub44.setText(T4Sub);
        tvTSub55.setText(T5Sub);
        tvTSub66.setText(T6Sub);
        tvTSub77.setText(T7Sub);
        tvTSub88.setText(T8Sub);
        //////////////////
        tvTClass19.setText(T1Class);
        tvTClass22.setText(T2Class);
        tvTClass33.setText(T3Class);
        tvTClass44.setText(T4Class);
        tvTClass55.setText(T5Class);
        tvTClass66.setText(T6Class);
        tvTClass77.setText(T7Class);
        tvTClass88.setText(T8Class);
        //////////////////
        tvTimeT12.setText(T11);
        tvTimeT14.setText(T12);
        tvTimeT16.setText(T13);
        tvTimeT18.setText(T14);
        //////////////////
        tvTimeT21.setText(T21);
        tvTimeT23.setText(T22);
        tvTimeT25.setText(T23);
        tvTimeT27.setText(T24);
        /////////////////////
        tvTimeT31.setText(T31);
        tvTimeT33.setText(T32);
        tvTimeT35.setText(T33);
        tvTimeT37.setText(T34);
        ////////////////////////
        tvTimeT41.setText(T41);
        tvTimeT43.setText(T42);
        tvTimeT45.setText(T43);
        tvTimeT47.setText(T44);
        //////////////////////
        tvTimeT51.setText(T51);
        tvTimeT53.setText(T52);
        tvTimeT55.setText(T53);
        tvTimeT57.setText(T54);
        //////////////////////
        tvTimeT61.setText(T61);
        tvTimeT63.setText(T62);
        tvTimeT65.setText(T63);
        tvTimeT67.setText(T64);
        //////////////////////
        tvTimeT71.setText(T71);
        tvTimeT73.setText(T72);
        tvTimeT75.setText(T73);
        tvTimeT77.setText(T74);
        ///////////////////////
        tvTimeT81.setText(T81);
        tvTimeT83.setText(T82);
        tvTimeT85.setText(T83);
        tvTimeT87.setText(T84);

        if (T1Sub.length()>11)
        {
            tvTSub19.setPadding(0,0,0,8);
        }

        if (T2Sub.length()>11)
        {
            tvTSub22.setPadding(0,0,0,8);
        }

        if (T3Sub.length()>11)
        {
            tvTSub33.setPadding(0,0,0,8);
        }

        if (T4Sub.length()>11)
        {
            tvTSub44.setPadding(0,0,0,8);
        }

        if (T5Sub.length()>11)
        {
            tvTSub55.setPadding(0,0,0,8);
        }

        if (T6Sub.length()>11)
        {
            tvTSub66.setPadding(0,0,0,8);
        }

        if (T7Sub.length()>11)
        {
            tvTSub77.setPadding(0,0,0,8);
        }

        if (T8Sub.length()>11)
        {
            tvTSub88.setPadding(0,0,0,8);
        }

        if(T11.length()==0)
        {
            tvTimeT13.setVisibility(View.GONE);
            tvTimeT15.setVisibility(View.GONE);
            tvTimeT17.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT13.setVisibility(View.VISIBLE);
            tvTimeT15.setVisibility(View.VISIBLE);
            tvTimeT17.setVisibility(View.VISIBLE);
        }

        if(T21.length()==0)
        {
            tvTimeT22.setVisibility(View.GONE);
            tvTimeT24.setVisibility(View.GONE);
            tvTimeT26.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT22.setVisibility(View.VISIBLE);
            tvTimeT24.setVisibility(View.VISIBLE);
            tvTimeT26.setVisibility(View.VISIBLE);
        }

        if(T31.length()==0)
        {
            tvTimeT32.setVisibility(View.GONE);
            tvTimeT34.setVisibility(View.GONE);
            tvTimeT36.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT32.setVisibility(View.VISIBLE);
            tvTimeT34.setVisibility(View.VISIBLE);
            tvTimeT36.setVisibility(View.VISIBLE);
        }

        if(T41.length()==0)
        {
            tvTimeT42.setVisibility(View.GONE);
            tvTimeT44.setVisibility(View.GONE);
            tvTimeT46.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT42.setVisibility(View.VISIBLE);
            tvTimeT44.setVisibility(View.VISIBLE);
            tvTimeT46.setVisibility(View.VISIBLE);
        }

        if(T51.length()==0)
        {
            tvTimeT52.setVisibility(View.GONE);
            tvTimeT54.setVisibility(View.GONE);
            tvTimeT56.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT52.setVisibility(View.VISIBLE);
            tvTimeT54.setVisibility(View.VISIBLE);
            tvTimeT56.setVisibility(View.VISIBLE);
        }

        if(T61.length()==0)
        {
            tvTimeT62.setVisibility(View.GONE);
            tvTimeT64.setVisibility(View.GONE);
            tvTimeT66.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT62.setVisibility(View.VISIBLE);
            tvTimeT64.setVisibility(View.VISIBLE);
            tvTimeT66.setVisibility(View.VISIBLE);
        }

        if(T71.length()==0)
        {
            tvTimeT72.setVisibility(View.GONE);
            tvTimeT74.setVisibility(View.GONE);
            tvTimeT76.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT72.setVisibility(View.VISIBLE);
            tvTimeT74.setVisibility(View.VISIBLE);
            tvTimeT76.setVisibility(View.VISIBLE);
        }

        if(T81.length()==0)
        {
            tvTimeT82.setVisibility(View.GONE);
            tvTimeT84.setVisibility(View.GONE);
            tvTimeT86.setVisibility(View.GONE);
        }
        else
        {
            tvTimeT82.setVisibility(View.VISIBLE);
            tvTimeT84.setVisibility(View.VISIBLE);
            tvTimeT86.setVisibility(View.VISIBLE);
        }


        if (tvTSub19.getText().toString().isEmpty())
        {
            tvT11.setVisibility(View.GONE);
            tvTimeT12.setVisibility(View.GONE);
            tvTimeT14.setVisibility(View.GONE);
            tvTimeT16.setVisibility(View.GONE);
            tvTimeT18.setVisibility(View.GONE);
            tvTSub19.setVisibility(View.GONE);
            tvTClass19.setVisibility(View.GONE);
            tvTimeT13.setVisibility(View.GONE);
            tvTimeT15.setVisibility(View.GONE);
            tvTimeT17.setVisibility(View.GONE);
        }
        else

        {
            tvT11.setVisibility(View.VISIBLE);
            tvTimeT12.setVisibility(View.VISIBLE);
            tvTimeT14.setVisibility(View.VISIBLE);
            tvTimeT16.setVisibility(View.VISIBLE);
            tvTimeT18.setVisibility(View.VISIBLE);
            tvTSub19.setVisibility(View.VISIBLE);
            tvTClass19.setVisibility(View.VISIBLE);
        }

        //2 строка
        if (tvTSub22.getText().toString().isEmpty())
        {
            tvT2.setVisibility(View.GONE);
            tvTSub22.setVisibility(View.GONE);
            tvTimeT21.setVisibility(View.GONE);
            tvTimeT22.setVisibility(View.GONE);
            tvTimeT23.setVisibility(View.GONE);
            tvTimeT24.setVisibility(View.GONE);
            tvTimeT25.setVisibility(View.GONE);
            tvTimeT26.setVisibility(View.GONE);
            tvTimeT27.setVisibility(View.GONE);
            tvTSub22.setVisibility(View.GONE);
            tvTClass22.setVisibility(View.GONE);
        } else
        {
            tvT2.setVisibility(View.VISIBLE);
            tvTSub22.setVisibility(View.VISIBLE);
            tvTimeT21.setVisibility(View.VISIBLE);
            tvTimeT23.setVisibility(View.VISIBLE);
            tvTimeT25.setVisibility(View.VISIBLE);
            tvTimeT27.setVisibility(View.VISIBLE);
            tvTSub22.setVisibility(View.VISIBLE);
            tvTClass22.setVisibility(View.VISIBLE);
        }

        //3 строка
        if (tvTSub33.getText().toString().isEmpty()) {
            tvTSub33.setVisibility(View.GONE);
            tvTimeT31.setVisibility(View.GONE);
            tvTimeT32.setVisibility(View.GONE);
            tvTimeT33.setVisibility(View.GONE);
            tvTimeT34.setVisibility(View.GONE);
            tvTimeT35.setVisibility(View.GONE);
            tvTimeT36.setVisibility(View.GONE);
            tvTimeT37.setVisibility(View.GONE);
            tvT3.setVisibility(View.GONE);
            tvTClass33.setVisibility(View.GONE);
        } else {
            tvTSub33.setVisibility(View.VISIBLE);
            tvTimeT31.setVisibility(View.VISIBLE);
            tvTimeT33.setVisibility(View.VISIBLE);
            tvTimeT35.setVisibility(View.VISIBLE);
            tvTimeT37.setVisibility(View.VISIBLE);
            tvT3.setVisibility(View.VISIBLE);
            tvTClass33.setVisibility(View.VISIBLE);
        }

        //4 строка
        if (tvTSub44.getText().toString().isEmpty()) {
            tvTSub44.setVisibility(View.GONE);
            tvTimeT41.setVisibility(View.GONE);
            tvTimeT42.setVisibility(View.GONE);
            tvTimeT43.setVisibility(View.GONE);
            tvTimeT44.setVisibility(View.GONE);
            tvTimeT45.setVisibility(View.GONE);
            tvTimeT46.setVisibility(View.GONE);
            tvTimeT47.setVisibility(View.GONE);
            tvT4.setVisibility(View.GONE);
            tvTClass44.setVisibility(View.GONE);
        } else {
            tvTSub44.setVisibility(View.VISIBLE);
            tvTimeT41.setVisibility(View.VISIBLE);
            tvTimeT43.setVisibility(View.VISIBLE);
            tvTimeT45.setVisibility(View.VISIBLE);
            tvTimeT47.setVisibility(View.VISIBLE);
            tvT4.setVisibility(View.VISIBLE);
            tvTClass44.setVisibility(View.VISIBLE);
        }

        //5 строка
        if (tvTSub55.getText().toString().isEmpty()) {
            tvTSub55.setVisibility(View.GONE);
            tvTimeT51.setVisibility(View.GONE);
            tvTimeT52.setVisibility(View.GONE);
            tvTimeT53.setVisibility(View.GONE);
            tvTimeT54.setVisibility(View.GONE);
            tvTimeT55.setVisibility(View.GONE);
            tvTimeT56.setVisibility(View.GONE);
            tvTimeT57.setVisibility(View.GONE);
            tvT5.setVisibility(View.GONE);
            tvTClass55.setVisibility(View.GONE);
        } else {
            tvTSub55.setVisibility(View.VISIBLE);
            tvTimeT51.setVisibility(View.VISIBLE);
            tvTimeT53.setVisibility(View.VISIBLE);
            tvTimeT55.setVisibility(View.VISIBLE);
            tvTimeT57.setVisibility(View.VISIBLE);
            tvT5.setVisibility(View.VISIBLE);
            tvTClass55.setVisibility(View.VISIBLE);
        }

        //6 строка
        if (tvTSub66.getText().toString().isEmpty()) {
            tvTSub66.setVisibility(View.GONE);
            tvTimeT61.setVisibility(View.GONE);
            tvTimeT62.setVisibility(View.GONE);
            tvTimeT63.setVisibility(View.GONE);
            tvTimeT64.setVisibility(View.GONE);
            tvTimeT65.setVisibility(View.GONE);
            tvTimeT66.setVisibility(View.GONE);
            tvTimeT67.setVisibility(View.GONE);
            tvT6.setVisibility(View.GONE);
            tvTClass66.setVisibility(View.GONE);
        } else {
            tvTSub66.setVisibility(View.VISIBLE);
            tvTimeT61.setVisibility(View.VISIBLE);
            tvTimeT63.setVisibility(View.VISIBLE);
            tvTimeT65.setVisibility(View.VISIBLE);
            tvTimeT67.setVisibility(View.VISIBLE);
            tvT6.setVisibility(View.VISIBLE);
            tvTClass66.setVisibility(View.VISIBLE);
        }

        //7 строка
        if (tvTSub77.getText().toString().isEmpty()) {
            tvTSub77.setVisibility(View.GONE);
            tvTimeT71.setVisibility(View.GONE);
            tvTimeT72.setVisibility(View.GONE);
            tvTimeT73.setVisibility(View.GONE);
            tvTimeT74.setVisibility(View.GONE);
            tvTimeT75.setVisibility(View.GONE);
            tvTimeT76.setVisibility(View.GONE);
            tvTimeT77.setVisibility(View.GONE);
            tvT7.setVisibility(View.GONE);
            tvTClass77.setVisibility(View.GONE);
        } else {
            tvTSub77.setVisibility(View.VISIBLE);
            tvTimeT71.setVisibility(View.VISIBLE);
            tvTimeT73.setVisibility(View.VISIBLE);
            tvTimeT75.setVisibility(View.VISIBLE);
            tvTimeT77.setVisibility(View.VISIBLE);
            tvT7.setVisibility(View.VISIBLE);
            tvTClass77.setVisibility(View.VISIBLE);
        }

        //8 строка
        if (tvTSub88.getText().toString().isEmpty()) {
            tvTSub88.setVisibility(View.GONE);
            tvTimeT81.setVisibility(View.GONE);
            tvTimeT82.setVisibility(View.GONE);
            tvTimeT83.setVisibility(View.GONE);
            tvTimeT84.setVisibility(View.GONE);
            tvTimeT85.setVisibility(View.GONE);
            tvTimeT86.setVisibility(View.GONE);
            tvTimeT87.setVisibility(View.GONE);
            tvT8.setVisibility(View.GONE);
            tvTClass88.setVisibility(View.GONE);
        } else {
            tvTSub88.setVisibility(View.VISIBLE);
            tvTimeT81.setVisibility(View.VISIBLE);
            tvTimeT83.setVisibility(View.VISIBLE);
            tvTimeT85.setVisibility(View.VISIBLE);
            tvTimeT87.setVisibility(View.VISIBLE);
            tvT8.setVisibility(View.VISIBLE);
            tvTClass88.setVisibility(View.VISIBLE);
        }

        return v;
    }


}