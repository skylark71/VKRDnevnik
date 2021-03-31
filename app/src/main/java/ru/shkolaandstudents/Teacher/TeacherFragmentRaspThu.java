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

public class TeacherFragmentRaspThu extends Fragment implements OnBackPressedListener {

    TextView tvTh1,tvTh2,tvTh3,tvTh4,tvTh5,tvTh6,tvTh7,tvTh8,tvTimeTh11,tvTimeTh12,tvTimeTh13,tvTimeTh14,tvTimeTh15,tvTimeTh16,tvTimeTh17,tvTimeTh21,tvTimeTh22,tvTimeTh23,tvTimeTh24,tvTimeTh25,tvTimeTh26,tvTimeTh27,tvTimeTh31,tvTimeTh32,tvTimeTh33,tvTimeTh34,tvTimeTh35,tvTimeTh36,tvTimeTh37,tvTimeTh41,tvTimeTh42,tvTimeTh43,tvTimeTh44,tvTimeTh45,tvTimeTh46,tvTimeTh47,tvTimeTh51,tvTimeTh52,tvTimeTh53,tvTimeTh54,tvTimeTh55,tvTimeTh56,tvTimeTh57,tvTimeTh61,tvTimeTh62,tvTimeTh63,tvTimeTh64,tvTimeTh65,tvTimeTh66,tvTimeTh67,tvTimeTh71,tvTimeTh72,tvTimeTh73,tvTimeTh74,tvTimeTh75,tvTimeTh76,tvTimeTh77,tvTimeTh81,tvTimeTh82,tvTimeTh83,tvTimeTh84,tvTimeTh85,tvTimeTh86,tvTimeTh87;
    TextView tvThSub11,tvThSub22,tvThSub33,tvThSub44,tvThSub55,tvThSub66,tvThSub77,tvThSub88;
    TextView tvThClass11,tvThClass22,tvThClass33,tvThClass44,tvThClass55,tvThClass66,tvThClass77,tvThClass88;
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
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_thu, container, false);

        btnHelp = v.findViewById(R.id.btnThuHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvTh1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeTh12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeTh16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvThSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvThClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
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

        tvTh1 = v.findViewById(R.id.tvTh1);
        tvTh2 = v.findViewById(R.id.tvTh2);
        tvTh3 = v.findViewById(R.id.tvTh3);
        tvTh4 = v.findViewById(R.id.tvTh4);
        tvTh5 = v.findViewById(R.id.tvTh5);
        tvTh6 = v.findViewById(R.id.tvTh6);
        tvTh7 = v.findViewById(R.id.tvTh7);
        tvTh8 = v.findViewById(R.id.tvTh8);

        tvTimeTh11 = v.findViewById(R.id.tvTimeTh11);
        tvTimeTh12 = v.findViewById(R.id.tvTimeTh12);
        tvTimeTh13 = v.findViewById(R.id.tvTimeTh13);
        tvTimeTh14 = v.findViewById(R.id.tvTimeTh14);
        tvTimeTh15 = v.findViewById(R.id.tvTimeTh15);
        tvTimeTh16 = v.findViewById(R.id.tvTimeTh16);
        tvTimeTh17 = v.findViewById(R.id.tvTimeTh17);
        tvTimeTh21 = v.findViewById(R.id.tvTimeTh21);
        tvTimeTh22 = v.findViewById(R.id.tvTimeTh22);
        tvTimeTh23 = v.findViewById(R.id.tvTimeTh23);
        tvTimeTh24 = v.findViewById(R.id.tvTimeTh24);
        tvTimeTh25 = v.findViewById(R.id.tvTimeTh25);
        tvTimeTh26 = v.findViewById(R.id.tvTimeTh26);
        tvTimeTh27 = v.findViewById(R.id.tvTimeTh27);
        tvTimeTh31 = v.findViewById(R.id.tvTimeTh31);
        tvTimeTh32 = v.findViewById(R.id.tvTimeTh32);
        tvTimeTh33 = v.findViewById(R.id.tvTimeTh33);
        tvTimeTh34 = v.findViewById(R.id.tvTimeTh34);
        tvTimeTh35 = v.findViewById(R.id.tvTimeTh35);
        tvTimeTh36 = v.findViewById(R.id.tvTimeTh36);
        tvTimeTh37 = v.findViewById(R.id.tvTimeTh37);
        tvTimeTh41 = v.findViewById(R.id.tvTimeTh41);
        tvTimeTh42 = v.findViewById(R.id.tvTimeTh42);
        tvTimeTh43 = v.findViewById(R.id.tvTimeTh43);
        tvTimeTh44 = v.findViewById(R.id.tvTimeTh44);
        tvTimeTh45 = v.findViewById(R.id.tvTimeTh45);
        tvTimeTh46 = v.findViewById(R.id.tvTimeTh46);
        tvTimeTh47 = v.findViewById(R.id.tvTimeTh47);
        tvTimeTh51 = v.findViewById(R.id.tvTimeTh51);
        tvTimeTh52 = v.findViewById(R.id.tvTimeTh52);
        tvTimeTh53 = v.findViewById(R.id.tvTimeTh53);
        tvTimeTh54 = v.findViewById(R.id.tvTimeTh54);
        tvTimeTh55 = v.findViewById(R.id.tvTimeTh55);
        tvTimeTh56 = v.findViewById(R.id.tvTimeTh56);
        tvTimeTh57 = v.findViewById(R.id.tvTimeTh57);
        tvTimeTh61 = v.findViewById(R.id.tvTimeTh61);
        tvTimeTh62 = v.findViewById(R.id.tvTimeTh62);
        tvTimeTh63 = v.findViewById(R.id.tvTimeTh63);
        tvTimeTh64 = v.findViewById(R.id.tvTimeTh64);
        tvTimeTh65 = v.findViewById(R.id.tvTimeTh65);
        tvTimeTh66 = v.findViewById(R.id.tvTimeTh66);
        tvTimeTh67 = v.findViewById(R.id.tvTimeTh67);
        tvTimeTh71 = v.findViewById(R.id.tvTimeTh71);
        tvTimeTh72 = v.findViewById(R.id.tvTimeTh72);
        tvTimeTh73 = v.findViewById(R.id.tvTimeTh73);
        tvTimeTh74 = v.findViewById(R.id.tvTimeTh74);
        tvTimeTh75 = v.findViewById(R.id.tvTimeTh75);
        tvTimeTh76 = v.findViewById(R.id.tvTimeTh76);
        tvTimeTh77 = v.findViewById(R.id.tvTimeTh77);
        tvTimeTh81 = v.findViewById(R.id.tvTimeTh81);
        tvTimeTh82 = v.findViewById(R.id.tvTimeTh82);
        tvTimeTh83 = v.findViewById(R.id.tvTimeTh83);
        tvTimeTh84 = v.findViewById(R.id.tvTimeTh84);
        tvTimeTh85 = v.findViewById(R.id.tvTimeTh85);
        tvTimeTh86 = v.findViewById(R.id.tvTimeTh86);
        tvTimeTh87 = v.findViewById(R.id.tvTimeTh87);
        
        tvThSub11 = v.findViewById(R.id.tvThSub11);
        tvThSub22 = v.findViewById(R.id.tvThSub22);
        tvThSub33 = v.findViewById(R.id.tvThSub33);
        tvThSub44 = v.findViewById(R.id.tvThSub44);
        tvThSub55 = v.findViewById(R.id.tvThSub55);
        tvThSub66 = v.findViewById(R.id.tvThSub66);
        tvThSub77 = v.findViewById(R.id.tvThSub77);
        tvThSub88 = v.findViewById(R.id.tvThSub88);
        
        tvThClass11 = v.findViewById(R.id.tvThClass11);
        tvThClass22 = v.findViewById(R.id.tvThClass22);
        tvThClass33 = v.findViewById(R.id.tvThClass33);
        tvThClass44 = v.findViewById(R.id.tvThClass44);
        tvThClass55 = v.findViewById(R.id.tvThClass55);
        tvThClass66 = v.findViewById(R.id.tvThClass66);
        tvThClass77 = v.findViewById(R.id.tvThClass77);
        tvThClass88 = v.findViewById(R.id.tvThClass88);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String Th1Sub = SP.getString("Th1Sub", "");
        String Th2Sub = SP.getString("Th2Sub", "");
        String Th3Sub = SP.getString("Th3Sub", "");
        String Th4Sub = SP.getString("Th4Sub", "");
        String Th5Sub = SP.getString("Th5Sub", "");
        String Th6Sub = SP.getString("Th6Sub", "");
        String Th7Sub = SP.getString("Th7Sub", "");
        String Th8Sub = SP.getString("Th8Sub", "");

        String Th1Class = SP.getString("Th1Class", "");
        String Th2Class = SP.getString("Th2Class", "");
        String Th3Class = SP.getString("Th3Class", "");
        String Th4Class = SP.getString("Th4Class", "");
        String Th5Class = SP.getString("Th5Class", "");
        String Th6Class = SP.getString("Th6Class", "");
        String Th7Class = SP.getString("Th7Class", "");
        String Th8Class = SP.getString("Th8Class", "");

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

        tvThSub11.setText(Th1Sub);
        tvThSub22.setText(Th2Sub);
        tvThSub33.setText(Th3Sub);
        tvThSub44.setText(Th4Sub);
        tvThSub55.setText(Th5Sub);
        tvThSub66.setText(Th6Sub);
        tvThSub77.setText(Th7Sub);
        tvThSub88.setText(Th8Sub);
        //////////////////
        tvThClass11.setText(Th1Class);
        tvThClass22.setText(Th2Class);
        tvThClass33.setText(Th3Class);
        tvThClass44.setText(Th4Class);
        tvThClass55.setText(Th5Class);
        tvThClass66.setText(Th6Class);
        tvThClass77.setText(Th7Class);
        tvThClass88.setText(Th8Class);
        //////////////////
        tvTimeTh11.setText(T11);
        tvTimeTh13.setText(T12);
        tvTimeTh15.setText(T13);
        tvTimeTh17.setText(T14);
        //////////////////
        tvTimeTh21.setText(T21);
        tvTimeTh23.setText(T22);
        tvTimeTh25.setText(T23);
        tvTimeTh27.setText(T24);
        /////////////////////
        tvTimeTh31.setText(T31);
        tvTimeTh33.setText(T32);
        tvTimeTh35.setText(T33);
        tvTimeTh37.setText(T34);
        ////////////////////////
        tvTimeTh41.setText(T41);
        tvTimeTh43.setText(T42);
        tvTimeTh45.setText(T43);
        tvTimeTh47.setText(T44);
        //////////////////////
        tvTimeTh51.setText(T51);
        tvTimeTh53.setText(T52);
        tvTimeTh55.setText(T53);
        tvTimeTh57.setText(T54);
        //////////////////////
        tvTimeTh61.setText(T61);
        tvTimeTh63.setText(T62);
        tvTimeTh65.setText(T63);
        tvTimeTh67.setText(T64);
        //////////////////////
        tvTimeTh71.setText(T71);
        tvTimeTh73.setText(T72);
        tvTimeTh75.setText(T73);
        tvTimeTh77.setText(T74);
        ///////////////////////
        tvTimeTh81.setText(T81);
        tvTimeTh83.setText(T82);
        tvTimeTh85.setText(T83);
        tvTimeTh87.setText(T84);

        if (Th1Sub.length()>11)
        {
            tvThSub11.setPadding(0,0,0,8);
        }

        if (Th2Sub.length()>11)
        {
            tvThSub22.setPadding(0,0,0,8);
        }

        if (Th3Sub.length()>11)
        {
            tvThSub33.setPadding(0,0,0,8);
        }

        if (Th4Sub.length()>11)
        {
            tvThSub44.setPadding(0,0,0,8);
        }

        if (Th5Sub.length()>11)
        {
            tvThSub55.setPadding(0,0,0,8);
        }

        if (Th6Sub.length()>11)
        {
            tvThSub66.setPadding(0,0,0,8);
        }

        if (Th7Sub.length()>11)
        {
            tvThSub77.setPadding(0,0,0,8);
        }

        if (Th8Sub.length()>11)
        {
            tvThSub88.setPadding(0,0,0,8);
        }

        if(T11.length()==0)
        {
            tvTimeTh12.setVisibility(View.GONE);
            tvTimeTh14.setVisibility(View.GONE);
            tvTimeTh16.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh12.setVisibility(View.VISIBLE);
            tvTimeTh14.setVisibility(View.VISIBLE);
            tvTimeTh16.setVisibility(View.VISIBLE);
        }

        if(T21.length()==0)
        {
            tvTimeTh22.setVisibility(View.GONE);
            tvTimeTh24.setVisibility(View.GONE);
            tvTimeTh26.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh22.setVisibility(View.VISIBLE);
            tvTimeTh24.setVisibility(View.VISIBLE);
            tvTimeTh26.setVisibility(View.VISIBLE);
        }

        if(T31.length()==0)
        {
            tvTimeTh32.setVisibility(View.GONE);
            tvTimeTh34.setVisibility(View.GONE);
            tvTimeTh36.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh32.setVisibility(View.VISIBLE);
            tvTimeTh34.setVisibility(View.VISIBLE);
            tvTimeTh36.setVisibility(View.VISIBLE);
        }

        if(T41.length()==0)
        {
            tvTimeTh42.setVisibility(View.GONE);
            tvTimeTh44.setVisibility(View.GONE);
            tvTimeTh46.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh42.setVisibility(View.VISIBLE);
            tvTimeTh44.setVisibility(View.VISIBLE);
            tvTimeTh46.setVisibility(View.VISIBLE);
        }

        if(T51.length()==0)
        {
            tvTimeTh52.setVisibility(View.GONE);
            tvTimeTh54.setVisibility(View.GONE);
            tvTimeTh56.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh52.setVisibility(View.VISIBLE);
            tvTimeTh54.setVisibility(View.VISIBLE);
            tvTimeTh56.setVisibility(View.VISIBLE);
        }

        if(T61.length()==0)
        {
            tvTimeTh62.setVisibility(View.GONE);
            tvTimeTh64.setVisibility(View.GONE);
            tvTimeTh66.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh62.setVisibility(View.VISIBLE);
            tvTimeTh64.setVisibility(View.VISIBLE);
            tvTimeTh66.setVisibility(View.VISIBLE);
        }

        if(T71.length()==0)
        {
            tvTimeTh72.setVisibility(View.GONE);
            tvTimeTh74.setVisibility(View.GONE);
            tvTimeTh76.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh72.setVisibility(View.VISIBLE);
            tvTimeTh74.setVisibility(View.VISIBLE);
            tvTimeTh76.setVisibility(View.VISIBLE);
        }

        if(T81.length()==0)
        {
            tvTimeTh82.setVisibility(View.GONE);
            tvTimeTh84.setVisibility(View.GONE);
            tvTimeTh86.setVisibility(View.GONE);
        }
        else
        {
            tvTimeTh82.setVisibility(View.VISIBLE);
            tvTimeTh84.setVisibility(View.VISIBLE);
            tvTimeTh86.setVisibility(View.VISIBLE);
        }

        if (tvThSub11.getText().toString().isEmpty()) {
            tvThSub11.setVisibility(View.GONE);
            tvTimeTh11.setVisibility(View.GONE);
            tvTimeTh12.setVisibility(View.GONE);
            tvTimeTh13.setVisibility(View.GONE);
            tvTimeTh14.setVisibility(View.GONE);
            tvTimeTh15.setVisibility(View.GONE);
            tvTimeTh16.setVisibility(View.GONE);
            tvTimeTh17.setVisibility(View.GONE);
            tvTh1.setVisibility(View.GONE);
            tvThClass11.setVisibility(View.GONE);

        } else {
            tvThSub11.setVisibility(View.VISIBLE);
            tvTimeTh11.setVisibility(View.VISIBLE);
            tvTimeTh13.setVisibility(View.VISIBLE);
            tvTimeTh15.setVisibility(View.VISIBLE);
            tvTimeTh17.setVisibility(View.VISIBLE);
            tvTh1.setVisibility(View.VISIBLE);
            tvThClass11.setVisibility(View.VISIBLE);
        }

        //2 строка
        if (tvThSub22.getText().toString().isEmpty()) {
            tvThSub22.setVisibility(View.GONE);
            tvTimeTh21.setVisibility(View.GONE);
            tvTimeTh22.setVisibility(View.GONE);
            tvTimeTh23.setVisibility(View.GONE);
            tvTimeTh24.setVisibility(View.GONE);
            tvTimeTh25.setVisibility(View.GONE);
            tvTimeTh26.setVisibility(View.GONE);
            tvTimeTh27.setVisibility(View.GONE);
            tvTh2.setVisibility(View.GONE);
            tvThClass22.setVisibility(View.GONE);
        } else {
            tvThSub22.setVisibility(View.VISIBLE);
            tvTimeTh21.setVisibility(View.VISIBLE);
            tvTimeTh23.setVisibility(View.VISIBLE);
            tvTimeTh25.setVisibility(View.VISIBLE);
            tvTimeTh27.setVisibility(View.VISIBLE);
            tvTh2.setVisibility(View.VISIBLE);
            tvThClass22.setVisibility(View.VISIBLE);
        }

        //3 строка
        if (tvThSub33.getText().toString().isEmpty()) {
            tvThSub33.setVisibility(View.GONE);
            tvTimeTh31.setVisibility(View.GONE);
            tvTimeTh32.setVisibility(View.GONE);
            tvTimeTh33.setVisibility(View.GONE);
            tvTimeTh34.setVisibility(View.GONE);
            tvTimeTh35.setVisibility(View.GONE);
            tvTimeTh36.setVisibility(View.GONE);
            tvTimeTh37.setVisibility(View.GONE);
            tvTh3.setVisibility(View.GONE);
            tvThClass33.setVisibility(View.GONE);
        } else {
            tvThSub33.setVisibility(View.VISIBLE);
            tvTimeTh31.setVisibility(View.VISIBLE);
            tvTimeTh33.setVisibility(View.VISIBLE);
            tvTimeTh35.setVisibility(View.VISIBLE);
            tvTimeTh37.setVisibility(View.VISIBLE);
            tvTh3.setVisibility(View.VISIBLE);
            tvThClass33.setVisibility(View.VISIBLE);
        }

        //4 строка
        if (tvThSub44.getText().toString().isEmpty()) {
            tvThSub44.setVisibility(View.GONE);
            tvTimeTh41.setVisibility(View.GONE);
            tvTimeTh42.setVisibility(View.GONE);
            tvTimeTh43.setVisibility(View.GONE);
            tvTimeTh44.setVisibility(View.GONE);
            tvTimeTh45.setVisibility(View.GONE);
            tvTimeTh46.setVisibility(View.GONE);
            tvTimeTh47.setVisibility(View.GONE);
            tvTh4.setVisibility(View.GONE);
            tvThClass44.setVisibility(View.GONE);
        } else {
            tvThSub44.setVisibility(View.VISIBLE);
            tvTimeTh41.setVisibility(View.VISIBLE);
            tvTimeTh43.setVisibility(View.VISIBLE);
            tvTimeTh45.setVisibility(View.VISIBLE);
            tvTimeTh47.setVisibility(View.VISIBLE);
            tvTh4.setVisibility(View.VISIBLE);
            tvThClass44.setVisibility(View.VISIBLE);
        }

        //5 строка
        if (tvThSub55.getText().toString().isEmpty()) {
            tvThSub55.setVisibility(View.GONE);
            tvTimeTh51.setVisibility(View.GONE);
            tvTimeTh52.setVisibility(View.GONE);
            tvTimeTh53.setVisibility(View.GONE);
            tvTimeTh54.setVisibility(View.GONE);
            tvTimeTh55.setVisibility(View.GONE);
            tvTimeTh56.setVisibility(View.GONE);
            tvTimeTh57.setVisibility(View.GONE);
            tvTh5.setVisibility(View.GONE);
            tvThClass55.setVisibility(View.GONE);
        } else {
            tvThSub55.setVisibility(View.VISIBLE);
            tvTimeTh51.setVisibility(View.VISIBLE);
            tvTimeTh53.setVisibility(View.VISIBLE);
            tvTimeTh55.setVisibility(View.VISIBLE);
            tvTimeTh57.setVisibility(View.VISIBLE);
            tvTh5.setVisibility(View.VISIBLE);
            tvThClass55.setVisibility(View.VISIBLE);
        }

        //6 строка
        if (tvThSub66.getText().toString().isEmpty()) {
            tvTh6.setVisibility(View.GONE);
            tvTimeTh61.setVisibility(View.GONE);
            tvTimeTh62.setVisibility(View.GONE);
            tvTimeTh63.setVisibility(View.GONE);
            tvTimeTh64.setVisibility(View.GONE);
            tvTimeTh65.setVisibility(View.GONE);
            tvTimeTh66.setVisibility(View.GONE);
            tvTimeTh67.setVisibility(View.GONE);
            tvTh6.setVisibility(View.GONE);
            tvThClass66.setVisibility(View.GONE);
        } else {
            tvThSub66.setVisibility(View.VISIBLE);
            tvTimeTh61.setVisibility(View.VISIBLE);
            tvTimeTh63.setVisibility(View.VISIBLE);
            tvTimeTh65.setVisibility(View.VISIBLE);
            tvTimeTh67.setVisibility(View.VISIBLE);
            tvTh6.setVisibility(View.VISIBLE);
            tvThClass66.setVisibility(View.VISIBLE);
        }

        //7 строка
        if (tvThSub77.getText().toString().isEmpty()) {
            tvThSub77.setVisibility(View.GONE);
            tvTimeTh71.setVisibility(View.GONE);
            tvTimeTh72.setVisibility(View.GONE);
            tvTimeTh73.setVisibility(View.GONE);
            tvTimeTh74.setVisibility(View.GONE);
            tvTimeTh75.setVisibility(View.GONE);
            tvTimeTh76.setVisibility(View.GONE);
            tvTimeTh77.setVisibility(View.GONE);
            tvTh7.setVisibility(View.GONE);
            tvThClass77.setVisibility(View.GONE);
        } else {
            tvThSub77.setVisibility(View.VISIBLE);
            tvTimeTh71.setVisibility(View.VISIBLE);
            tvTimeTh73.setVisibility(View.VISIBLE);
            tvTimeTh75.setVisibility(View.VISIBLE);
            tvTimeTh77.setVisibility(View.VISIBLE);
            tvTh7.setVisibility(View.VISIBLE);
            tvThClass77.setVisibility(View.VISIBLE);
        }

        //8 строка
        if (tvThSub88.getText().toString().isEmpty()) {
            tvThSub88.setVisibility(View.GONE);
            tvTimeTh81.setVisibility(View.GONE);
            tvTimeTh82.setVisibility(View.GONE);
            tvTimeTh83.setVisibility(View.GONE);
            tvTimeTh84.setVisibility(View.GONE);
            tvTimeTh85.setVisibility(View.GONE);
            tvTimeTh86.setVisibility(View.GONE);
            tvTimeTh87.setVisibility(View.GONE);
            tvTh8.setVisibility(View.GONE);
            tvThClass88.setVisibility(View.GONE);
        } else {
            tvThSub88.setVisibility(View.VISIBLE);
            tvTimeTh81.setVisibility(View.VISIBLE);
            tvTimeTh83.setVisibility(View.VISIBLE);
            tvTimeTh85.setVisibility(View.VISIBLE);
            tvTimeTh87.setVisibility(View.VISIBLE);
            tvTh8.setVisibility(View.VISIBLE);
            tvThClass88.setVisibility(View.VISIBLE);
        }
        
        return v;
    }
    
}