package ru.shkolaandstudents.Teacher;


import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import ru.shkolaandstudents.R;

public class TeacherFragmentRaspFri extends Fragment {

    TextView tvFr1,tvFr2,tvFr3,tvFr4,tvFr5,tvFr6,tvFr7,tvFr8,tvTimeFr11,tvTimeFr12,tvTimeFr13,tvTimeFr14,tvTimeFr15,tvTimeFr16,tvTimeFr17,tvTimeFr21,tvTimeFr22,tvTimeFr23,tvTimeFr24,tvTimeFr25,tvTimeFr26,tvTimeFr27,tvTimeFr31,tvTimeFr32,tvTimeFr33,tvTimeFr34,tvTimeFr35,tvTimeFr36,tvTimeFr37,tvTimeFr41,tvTimeFr42,tvTimeFr43,tvTimeFr44,tvTimeFr45,tvTimeFr46,tvTimeFr47,tvTimeFr51,tvTimeFr52,tvTimeFr53,tvTimeFr54,tvTimeFr55,tvTimeFr56,tvTimeFr57,tvTimeFr61,tvTimeFr62,tvTimeFr63,tvTimeFr64,tvTimeFr65,tvTimeFr66,tvTimeFr67,tvTimeFr71,tvTimeFr72,tvTimeFr73,tvTimeFr74,tvTimeFr75,tvTimeFr76,tvTimeFr77,tvTimeFr81,tvTimeFr82,tvTimeFr83,tvTimeFr84,tvTimeFr85,tvTimeFr86,tvTimeFr87;
    TextView tvFrClass11,tvFrClass22,tvFrClass33,tvFrClass44,tvFrClass55,tvFrClass66,tvFrClass77,tvFrClass88;
    TextView tvFrSub11,tvFrSub22,tvFrSub33,tvFrSub44,tvFrSub55,tvFrSub66,tvFrSub77,tvFrSub88;
    Button btnHelp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_fri, container, false);

        btnHelp = v.findViewById(R.id.btnFriHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvFr1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeFr12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeFr16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvFrSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvFrClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
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

        tvFr1 = v.findViewById(R.id.tvFr1);
        tvFr2 = v.findViewById(R.id.tvFr2);
        tvFr3 = v.findViewById(R.id.tvFr3);
        tvFr4 = v.findViewById(R.id.tvFr4);
        tvFr5 = v.findViewById(R.id.tvFr5);
        tvFr6 = v.findViewById(R.id.tvFr6);
        tvFr7 = v.findViewById(R.id.tvFr7);
        tvFr8 = v.findViewById(R.id.tvFr8);

        tvTimeFr11 = v.findViewById(R.id.tvTimeFr11);
        tvTimeFr12 = v.findViewById(R.id.tvTimeFr12);
        tvTimeFr13 = v.findViewById(R.id.tvTimeFr13);
        tvTimeFr14 = v.findViewById(R.id.tvTimeFr14);
        tvTimeFr15 = v.findViewById(R.id.tvTimeFr15);
        tvTimeFr16 = v.findViewById(R.id.tvTimeFr16);
        tvTimeFr17 = v.findViewById(R.id.tvTimeFr17);
        tvTimeFr21 = v.findViewById(R.id.tvTimeFr21);
        tvTimeFr22 = v.findViewById(R.id.tvTimeFr22);
        tvTimeFr23 = v.findViewById(R.id.tvTimeFr23);
        tvTimeFr24 = v.findViewById(R.id.tvTimeFr24);
        tvTimeFr25 = v.findViewById(R.id.tvTimeFr25);
        tvTimeFr26 = v.findViewById(R.id.tvTimeFr26);
        tvTimeFr27 = v.findViewById(R.id.tvTimeFr27);
        tvTimeFr31 = v.findViewById(R.id.tvTimeFr31);
        tvTimeFr32 = v.findViewById(R.id.tvTimeFr32);
        tvTimeFr33 = v.findViewById(R.id.tvTimeFr33);
        tvTimeFr34 = v.findViewById(R.id.tvTimeFr34);
        tvTimeFr35 = v.findViewById(R.id.tvTimeFr35);
        tvTimeFr36 = v.findViewById(R.id.tvTimeFr36);
        tvTimeFr37 = v.findViewById(R.id.tvTimeFr37);
        tvTimeFr41 = v.findViewById(R.id.tvTimeFr41);
        tvTimeFr42 = v.findViewById(R.id.tvTimeFr42);
        tvTimeFr43 = v.findViewById(R.id.tvTimeFr43);
        tvTimeFr44 = v.findViewById(R.id.tvTimeFr44);
        tvTimeFr45 = v.findViewById(R.id.tvTimeFr45);
        tvTimeFr46 = v.findViewById(R.id.tvTimeFr46);
        tvTimeFr47 = v.findViewById(R.id.tvTimeFr47);
        tvTimeFr51 = v.findViewById(R.id.tvTimeFr51);
        tvTimeFr52 = v.findViewById(R.id.tvTimeFr52);
        tvTimeFr53 = v.findViewById(R.id.tvTimeFr53);
        tvTimeFr54 = v.findViewById(R.id.tvTimeFr54);
        tvTimeFr55 = v.findViewById(R.id.tvTimeFr55);
        tvTimeFr56 = v.findViewById(R.id.tvTimeFr56);
        tvTimeFr57 = v.findViewById(R.id.tvTimeFr57);
        tvTimeFr61 = v.findViewById(R.id.tvTimeFr61);
        tvTimeFr62 = v.findViewById(R.id.tvTimeFr62);
        tvTimeFr63 = v.findViewById(R.id.tvTimeFr63);
        tvTimeFr64 = v.findViewById(R.id.tvTimeFr64);
        tvTimeFr65 = v.findViewById(R.id.tvTimeFr65);
        tvTimeFr66 = v.findViewById(R.id.tvTimeFr66);
        tvTimeFr67 = v.findViewById(R.id.tvTimeFr67);
        tvTimeFr71 = v.findViewById(R.id.tvTimeFr71);
        tvTimeFr72 = v.findViewById(R.id.tvTimeFr72);
        tvTimeFr73 = v.findViewById(R.id.tvTimeFr73);
        tvTimeFr74 = v.findViewById(R.id.tvTimeFr74);
        tvTimeFr75 = v.findViewById(R.id.tvTimeFr75);
        tvTimeFr76 = v.findViewById(R.id.tvTimeFr76);
        tvTimeFr77 = v.findViewById(R.id.tvTimeFr77);
        tvTimeFr81 = v.findViewById(R.id.tvTimeFr81);
        tvTimeFr82 = v.findViewById(R.id.tvTimeFr82);
        tvTimeFr83 = v.findViewById(R.id.tvTimeFr83);
        tvTimeFr84 = v.findViewById(R.id.tvTimeFr84);
        tvTimeFr85 = v.findViewById(R.id.tvTimeFr85);
        tvTimeFr86 = v.findViewById(R.id.tvTimeFr86);
        tvTimeFr87 = v.findViewById(R.id.tvTimeFr87);
        
        tvFrSub11 = v.findViewById(R.id.tvFrSub11);
        tvFrSub22 = v.findViewById(R.id.tvFrSub22);
        tvFrSub33 = v.findViewById(R.id.tvFrSub33);
        tvFrSub44 = v.findViewById(R.id.tvFrSub44);
        tvFrSub55 = v.findViewById(R.id.tvFrSub55);
        tvFrSub66 = v.findViewById(R.id.tvFrSub66);
        tvFrSub77 = v.findViewById(R.id.tvFrSub77);
        tvFrSub88 = v.findViewById(R.id.tvFrSub88);
        
        tvFrClass11 = v.findViewById(R.id.tvFrClass11);
        tvFrClass22 = v.findViewById(R.id.tvFrClass22);
        tvFrClass33 = v.findViewById(R.id.tvFrClass33);
        tvFrClass44 = v.findViewById(R.id.tvFrClass44);
        tvFrClass55 = v.findViewById(R.id.tvFrClass55);
        tvFrClass66 = v.findViewById(R.id.tvFrClass66);
        tvFrClass77 = v.findViewById(R.id.tvFrClass77);
        tvFrClass88 = v.findViewById(R.id.tvFrClass88);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String Fr1Sub = SP.getString("Fr1Sub", "");
        String Fr2Sub = SP.getString("Fr2Sub", "");
        String Fr3Sub = SP.getString("Fr3Sub", "");
        String Fr4Sub = SP.getString("Fr4Sub", "");
        String Fr5Sub = SP.getString("Fr5Sub", "");
        String Fr6Sub = SP.getString("Fr6Sub", "");
        String Fr7Sub = SP.getString("Fr7Sub", "");
        String Fr8Sub = SP.getString("Fr8Sub", "");

        String Fr1Class = SP.getString("Fr1Class", "");
        String Fr2Class = SP.getString("Fr2Class", "");
        String Fr3Class = SP.getString("Fr3Class", "");
        String Fr4Class = SP.getString("Fr4Class", "");
        String Fr5Class = SP.getString("Fr5Class", "");
        String Fr6Class = SP.getString("Fr6Class", "");
        String Fr7Class = SP.getString("Fr7Class", "");
        String Fr8Class = SP.getString("Fr8Class", "");

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

        tvFrSub11.setText(Fr1Sub);
        tvFrSub22.setText(Fr2Sub);
        tvFrSub33.setText(Fr3Sub);
        tvFrSub44.setText(Fr4Sub);
        tvFrSub55.setText(Fr5Sub);
        tvFrSub66.setText(Fr6Sub);
        tvFrSub77.setText(Fr7Sub);
        tvFrSub88.setText(Fr8Sub);
        //////////////////
        tvFrClass11.setText(Fr1Class);
        tvFrClass22.setText(Fr2Class);
        tvFrClass33.setText(Fr3Class);
        tvFrClass44.setText(Fr4Class);
        tvFrClass55.setText(Fr5Class);
        tvFrClass66.setText(Fr6Class);
        tvFrClass77.setText(Fr7Class);
        tvFrClass88.setText(Fr8Class);
        //////////////////
        tvTimeFr11.setText(T11);
        tvTimeFr13.setText(T12);
        tvTimeFr15.setText(T13);
        tvTimeFr17.setText(T14);
        //////////////////
        tvTimeFr21.setText(T21);
        tvTimeFr23.setText(T22);
        tvTimeFr25.setText(T23);
        tvTimeFr27.setText(T24);
        /////////////////////
        tvTimeFr31.setText(T31);
        tvTimeFr33.setText(T32);
        tvTimeFr35.setText(T33);
        tvTimeFr37.setText(T34);
        ////////////////////////
        tvTimeFr41.setText(T41);
        tvTimeFr43.setText(T42);
        tvTimeFr45.setText(T43);
        tvTimeFr47.setText(T44);
        //////////////////////
        tvTimeFr51.setText(T51);
        tvTimeFr53.setText(T52);
        tvTimeFr55.setText(T53);
        tvTimeFr57.setText(T54);
        //////////////////////
        tvTimeFr61.setText(T61);
        tvTimeFr63.setText(T62);
        tvTimeFr65.setText(T63);
        tvTimeFr67.setText(T64);
        //////////////////////
        tvTimeFr71.setText(T71);
        tvTimeFr73.setText(T72);
        tvTimeFr75.setText(T73);
        tvTimeFr77.setText(T74);
        ///////////////////////
        tvTimeFr81.setText(T81);
        tvTimeFr83.setText(T82);
        tvTimeFr85.setText(T83);
        tvTimeFr87.setText(T84);

        if (Fr1Sub.length()>11)
        {
            tvFrSub11.setPadding(0,0,0,8);
        }

        if (Fr2Sub.length()>11)
        {
            tvFrSub22.setPadding(0,0,0,8);
        }

        if (Fr3Sub.length()>11)
        {
            tvFrSub33.setPadding(0,0,0,8);
        }

        if (Fr4Sub.length()>11)
        {
            tvFrSub44.setPadding(0,0,0,8);
        }

        if (Fr5Sub.length()>11)
        {
            tvFrSub55.setPadding(0,0,0,8);
        }

        if (Fr6Sub.length()>11)
        {
            tvFrSub66.setPadding(0,0,0,8);
        }

        if (Fr7Sub.length()>11)
        {
            tvFrSub77.setPadding(0,0,0,8);
        }

        if (Fr8Sub.length()>11)
        {
            tvFrSub88.setPadding(0,0,0,8);
        }

        if(T11.length()==0)
        {
            tvTimeFr12.setVisibility(View.GONE);
            tvTimeFr14.setVisibility(View.GONE);
            tvTimeFr16.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr12.setVisibility(View.VISIBLE);
            tvTimeFr14.setVisibility(View.VISIBLE);
            tvTimeFr16.setVisibility(View.VISIBLE);
        }

        if(T21.length()==0)
        {
            tvTimeFr22.setVisibility(View.GONE);
            tvTimeFr24.setVisibility(View.GONE);
            tvTimeFr26.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr22.setVisibility(View.VISIBLE);
            tvTimeFr24.setVisibility(View.VISIBLE);
            tvTimeFr26.setVisibility(View.VISIBLE);
        }

        if(T31.length()==0)
        {
            tvTimeFr32.setVisibility(View.GONE);
            tvTimeFr34.setVisibility(View.GONE);
            tvTimeFr36.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr32.setVisibility(View.VISIBLE);
            tvTimeFr34.setVisibility(View.VISIBLE);
            tvTimeFr36.setVisibility(View.VISIBLE);
        }

        if(T41.length()==0)
        {
            tvTimeFr42.setVisibility(View.GONE);
            tvTimeFr44.setVisibility(View.GONE);
            tvTimeFr46.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr42.setVisibility(View.VISIBLE);
            tvTimeFr44.setVisibility(View.VISIBLE);
            tvTimeFr46.setVisibility(View.VISIBLE);
        }

        if(T51.length()==0)
        {
            tvTimeFr52.setVisibility(View.GONE);
            tvTimeFr54.setVisibility(View.GONE);
            tvTimeFr56.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr52.setVisibility(View.VISIBLE);
            tvTimeFr54.setVisibility(View.VISIBLE);
            tvTimeFr56.setVisibility(View.VISIBLE);
        }

        if(T61.length()==0)
        {
            tvTimeFr62.setVisibility(View.GONE);
            tvTimeFr64.setVisibility(View.GONE);
            tvTimeFr66.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr62.setVisibility(View.VISIBLE);
            tvTimeFr64.setVisibility(View.VISIBLE);
            tvTimeFr66.setVisibility(View.VISIBLE);
        }

        if(T71.length()==0)
        {
            tvTimeFr72.setVisibility(View.GONE);
            tvTimeFr74.setVisibility(View.GONE);
            tvTimeFr76.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr72.setVisibility(View.VISIBLE);
            tvTimeFr74.setVisibility(View.VISIBLE);
            tvTimeFr76.setVisibility(View.VISIBLE);
        }

        if(T81.length()==0)
        {
            tvTimeFr82.setVisibility(View.GONE);
            tvTimeFr84.setVisibility(View.GONE);
            tvTimeFr86.setVisibility(View.GONE);
        }
        else
        {
            tvTimeFr82.setVisibility(View.VISIBLE);
            tvTimeFr84.setVisibility(View.VISIBLE);
            tvTimeFr86.setVisibility(View.VISIBLE);
        }

        if (tvFrSub11.getText().toString().isEmpty()) {
            tvFrSub11.setVisibility(View.GONE);
            tvTimeFr11.setVisibility(View.GONE);
            tvTimeFr12.setVisibility(View.GONE);
            tvTimeFr13.setVisibility(View.GONE);
            tvTimeFr14.setVisibility(View.GONE);
            tvTimeFr15.setVisibility(View.GONE);
            tvTimeFr16.setVisibility(View.GONE);
            tvTimeFr17.setVisibility(View.GONE);
            tvFr1.setVisibility(View.GONE);
            tvFrClass11.setVisibility(View.GONE);
        } else {
            tvFrSub11.setVisibility(View.VISIBLE);
            tvTimeFr11.setVisibility(View.VISIBLE);
            tvTimeFr13.setVisibility(View.VISIBLE);
            tvTimeFr15.setVisibility(View.VISIBLE);
            tvTimeFr17.setVisibility(View.VISIBLE);
            tvFr1.setVisibility(View.VISIBLE);
            tvFrClass11.setVisibility(View.VISIBLE);
        }

        //2 строка
        if (tvFrSub22.getText().toString().isEmpty()) {
            tvFrSub22.setVisibility(View.GONE);
            tvTimeFr21.setVisibility(View.GONE);
            tvTimeFr22.setVisibility(View.GONE);
            tvTimeFr23.setVisibility(View.GONE);
            tvTimeFr24.setVisibility(View.GONE);
            tvTimeFr25.setVisibility(View.GONE);
            tvTimeFr26.setVisibility(View.GONE);
            tvTimeFr27.setVisibility(View.GONE);
            tvFr2.setVisibility(View.GONE);
            tvFrClass22.setVisibility(View.GONE);
        } else {
            tvFrSub22.setVisibility(View.VISIBLE);
            tvTimeFr21.setVisibility(View.VISIBLE);
            tvTimeFr23.setVisibility(View.VISIBLE);
            tvTimeFr25.setVisibility(View.VISIBLE);
            tvTimeFr27.setVisibility(View.VISIBLE);
            tvFr2.setVisibility(View.VISIBLE);
            tvFrClass22.setVisibility(View.VISIBLE);
        }

        //3 строка
        if (tvFrSub33.getText().toString().isEmpty()) {
            tvFrSub33.setVisibility(View.GONE);
            tvTimeFr31.setVisibility(View.GONE);
            tvTimeFr32.setVisibility(View.GONE);
            tvTimeFr33.setVisibility(View.GONE);
            tvTimeFr34.setVisibility(View.GONE);
            tvTimeFr35.setVisibility(View.GONE);
            tvTimeFr36.setVisibility(View.GONE);
            tvTimeFr37.setVisibility(View.GONE);
            tvFr3.setVisibility(View.GONE);
            tvFrClass33.setVisibility(View.GONE);
        } else {
            tvFrSub33.setVisibility(View.VISIBLE);
            tvTimeFr31.setVisibility(View.VISIBLE);
            tvTimeFr33.setVisibility(View.VISIBLE);
            tvTimeFr35.setVisibility(View.VISIBLE);
            tvTimeFr37.setVisibility(View.VISIBLE);
            tvFr3.setVisibility(View.VISIBLE);
            tvFrClass33.setVisibility(View.VISIBLE);
        }

        //4 строка
        if (tvFrSub44.getText().toString().isEmpty()) {
            tvFrSub44.setVisibility(View.GONE);
            tvTimeFr41.setVisibility(View.GONE);
            tvTimeFr42.setVisibility(View.GONE);
            tvTimeFr43.setVisibility(View.GONE);
            tvTimeFr44.setVisibility(View.GONE);
            tvTimeFr45.setVisibility(View.GONE);
            tvTimeFr46.setVisibility(View.GONE);
            tvTimeFr47.setVisibility(View.GONE);
            tvFr4.setVisibility(View.GONE);
            tvFrClass44.setVisibility(View.GONE);
        } else {
            tvFrSub44.setVisibility(View.VISIBLE);
            tvTimeFr41.setVisibility(View.VISIBLE);
            tvTimeFr43.setVisibility(View.VISIBLE);
            tvTimeFr45.setVisibility(View.VISIBLE);
            tvTimeFr47.setVisibility(View.VISIBLE);
            tvFr4.setVisibility(View.VISIBLE);
            tvFrClass44.setVisibility(View.VISIBLE);
        }

        //5 строка
        if (tvFrSub55.getText().toString().isEmpty()) {
            tvFrSub55.setVisibility(View.GONE);
            tvTimeFr51.setVisibility(View.GONE);
            tvTimeFr52.setVisibility(View.GONE);
            tvTimeFr53.setVisibility(View.GONE);
            tvTimeFr54.setVisibility(View.GONE);
            tvTimeFr55.setVisibility(View.GONE);
            tvTimeFr56.setVisibility(View.GONE);
            tvTimeFr57.setVisibility(View.GONE);
            tvFr5.setVisibility(View.GONE);
            tvFrClass55.setVisibility(View.GONE);
        } else {
            tvFrSub55.setVisibility(View.VISIBLE);
            tvTimeFr51.setVisibility(View.VISIBLE);
            tvTimeFr53.setVisibility(View.VISIBLE);
            tvTimeFr55.setVisibility(View.VISIBLE);
            tvTimeFr57.setVisibility(View.VISIBLE);
            tvFr5.setVisibility(View.VISIBLE);
            tvFrClass55.setVisibility(View.VISIBLE);
        }

        //6 строка
        if (tvFrSub66.getText().toString().isEmpty()) {
            tvFr6.setVisibility(View.GONE);
            tvTimeFr61.setVisibility(View.GONE);
            tvTimeFr62.setVisibility(View.GONE);
            tvTimeFr63.setVisibility(View.GONE);
            tvTimeFr64.setVisibility(View.GONE);
            tvTimeFr65.setVisibility(View.GONE);
            tvTimeFr66.setVisibility(View.GONE);
            tvTimeFr67.setVisibility(View.GONE);
            tvFr6.setVisibility(View.GONE);
            tvFrClass66.setVisibility(View.GONE);
        } else {
            tvFrSub66.setVisibility(View.VISIBLE);
            tvTimeFr61.setVisibility(View.VISIBLE);
            tvTimeFr63.setVisibility(View.VISIBLE);
            tvTimeFr65.setVisibility(View.VISIBLE);
            tvTimeFr67.setVisibility(View.VISIBLE);
            tvFr6.setVisibility(View.VISIBLE);
            tvFrClass66.setVisibility(View.VISIBLE);
        }

        //7 строка
        if (tvFrSub77.getText().toString().isEmpty()) {
            tvFrSub77.setVisibility(View.GONE);
            tvTimeFr71.setVisibility(View.GONE);
            tvTimeFr72.setVisibility(View.GONE);
            tvTimeFr73.setVisibility(View.GONE);
            tvTimeFr74.setVisibility(View.GONE);
            tvTimeFr75.setVisibility(View.GONE);
            tvTimeFr76.setVisibility(View.GONE);
            tvTimeFr77.setVisibility(View.GONE);
            tvFr7.setVisibility(View.GONE);
            tvFrClass77.setVisibility(View.GONE);
        } else {
            tvFrSub77.setVisibility(View.VISIBLE);
            tvTimeFr71.setVisibility(View.VISIBLE);
            tvTimeFr73.setVisibility(View.VISIBLE);
            tvTimeFr75.setVisibility(View.VISIBLE);
            tvTimeFr77.setVisibility(View.VISIBLE);
            tvFr7.setVisibility(View.VISIBLE);
            tvFrClass77.setVisibility(View.VISIBLE);
        }

        //8 строка
        if (tvFrSub88.getText().toString().isEmpty()) {
            tvFrSub88.setVisibility(View.GONE);
            tvTimeFr81.setVisibility(View.GONE);
            tvTimeFr82.setVisibility(View.GONE);
            tvTimeFr83.setVisibility(View.GONE);
            tvTimeFr84.setVisibility(View.GONE);
            tvTimeFr85.setVisibility(View.GONE);
            tvTimeFr86.setVisibility(View.GONE);
            tvTimeFr87.setVisibility(View.GONE);
            tvFr8.setVisibility(View.GONE);
            tvFrClass88.setVisibility(View.GONE);
        } else {
            tvFrSub88.setVisibility(View.VISIBLE);
            tvTimeFr81.setVisibility(View.VISIBLE);
            tvTimeFr83.setVisibility(View.VISIBLE);
            tvTimeFr85.setVisibility(View.VISIBLE);
            tvTimeFr87.setVisibility(View.VISIBLE);
            tvFr8.setVisibility(View.VISIBLE);
            tvFrClass88.setVisibility(View.VISIBLE);
        }

        return v;
    }
}