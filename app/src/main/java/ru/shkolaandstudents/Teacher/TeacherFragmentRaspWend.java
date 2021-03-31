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

public class TeacherFragmentRaspWend extends Fragment implements OnBackPressedListener {

    TextView tvW1,tvW2,tvW3,tvW4,tvW5,tvW6,tvW7,tvW8,tvTimeW11,tvTimeW12,tvTimeW13,tvTimeW14,tvTimeW15,tvTimeW16,tvTimeW17,tvTimeW21,tvTimeW22,tvTimeW23,tvTimeW24,tvTimeW25,tvTimeW26,tvTimeW27,tvTimeW31,tvTimeW32,tvTimeW33,tvTimeW34,tvTimeW35,tvTimeW36,tvTimeW37,tvTimeW41,tvTimeW42,tvTimeW43,tvTimeW44,tvTimeW45,tvTimeW46,tvTimeW47,tvTimeW51,tvTimeW52,tvTimeW53,tvTimeW54,tvTimeW55,tvTimeW56,tvTimeW57,tvTimeW61,tvTimeW62,tvTimeW63,tvTimeW64,tvTimeW65,tvTimeW66,tvTimeW67,tvTimeW71,tvTimeW72,tvTimeW73,tvTimeW74,tvTimeW75,tvTimeW76,tvTimeW77,tvTimeW81,tvTimeW82,tvTimeW83,tvTimeW84,tvTimeW85,tvTimeW86,tvTimeW87;
    TextView tvWSub11,tvWSub22,tvWSub33,tvWSub44,tvWSub55,tvWSub66,tvWSub77,tvWSub88;
    TextView tvWClass11,tvWClass22,tvWClass33,tvWClass44,tvWClass55,tvWClass66,tvWClass77,tvWClass88;
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
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_wend, container, false);

        btnHelp = v.findViewById(R.id.btnWenHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvW1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeW12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeW16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvWSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvWClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
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


        tvW1 = v.findViewById(R.id.tvW1);
        tvW2 = v.findViewById(R.id.tvW2);
        tvW3 = v.findViewById(R.id.tvW3);
        tvW4 = v.findViewById(R.id.tvW4);
        tvW5 = v.findViewById(R.id.tvW5);
        tvW6 = v.findViewById(R.id.tvW6);
        tvW7 = v.findViewById(R.id.tvW7);
        tvW8 = v.findViewById(R.id.tvW8);

        tvTimeW11 = v.findViewById(R.id.tvTimeW11);
        tvTimeW12 = v.findViewById(R.id.tvTimeW12);
        tvTimeW13 = v.findViewById(R.id.tvTimeW13);
        tvTimeW14 = v.findViewById(R.id.tvTimeW14);
        tvTimeW15 = v.findViewById(R.id.tvTimeW15);
        tvTimeW16 = v.findViewById(R.id.tvTimeW16);
        tvTimeW17 = v.findViewById(R.id.tvTimeW17);
        tvTimeW21 = v.findViewById(R.id.tvTimeW21);
        tvTimeW22 = v.findViewById(R.id.tvTimeW22);
        tvTimeW23 = v.findViewById(R.id.tvTimeW23);
        tvTimeW24 = v.findViewById(R.id.tvTimeW24);
        tvTimeW25 = v.findViewById(R.id.tvTimeW25);
        tvTimeW26 = v.findViewById(R.id.tvTimeW26);
        tvTimeW27 = v.findViewById(R.id.tvTimeW27);
        tvTimeW31 = v.findViewById(R.id.tvTimeW31);
        tvTimeW32 = v.findViewById(R.id.tvTimeW32);
        tvTimeW33 = v.findViewById(R.id.tvTimeW33);
        tvTimeW34 = v.findViewById(R.id.tvTimeW34);
        tvTimeW35 = v.findViewById(R.id.tvTimeW35);
        tvTimeW36 = v.findViewById(R.id.tvTimeW36);
        tvTimeW37 = v.findViewById(R.id.tvTimeW37);
        tvTimeW41 = v.findViewById(R.id.tvTimeW41);
        tvTimeW42 = v.findViewById(R.id.tvTimeW42);
        tvTimeW43 = v.findViewById(R.id.tvTimeW43);
        tvTimeW44 = v.findViewById(R.id.tvTimeW44);
        tvTimeW45 = v.findViewById(R.id.tvTimeW45);
        tvTimeW46 = v.findViewById(R.id.tvTimeW46);
        tvTimeW47 = v.findViewById(R.id.tvTimeW47);
        tvTimeW51 = v.findViewById(R.id.tvTimeW51);
        tvTimeW52 = v.findViewById(R.id.tvTimeW52);
        tvTimeW53 = v.findViewById(R.id.tvTimeW53);
        tvTimeW54 = v.findViewById(R.id.tvTimeW54);
        tvTimeW55 = v.findViewById(R.id.tvTimeW55);
        tvTimeW56 = v.findViewById(R.id.tvTimeW56);
        tvTimeW57 = v.findViewById(R.id.tvTimeW57);
        tvTimeW61 = v.findViewById(R.id.tvTimeW61);
        tvTimeW62 = v.findViewById(R.id.tvTimeW62);
        tvTimeW63 = v.findViewById(R.id.tvTimeW63);
        tvTimeW64 = v.findViewById(R.id.tvTimeW64);
        tvTimeW65 = v.findViewById(R.id.tvTimeW65);
        tvTimeW66 = v.findViewById(R.id.tvTimeW66);
        tvTimeW67 = v.findViewById(R.id.tvTimeW67);
        tvTimeW71 = v.findViewById(R.id.tvTimeW71);
        tvTimeW72 = v.findViewById(R.id.tvTimeW72);
        tvTimeW73 = v.findViewById(R.id.tvTimeW73);
        tvTimeW74 = v.findViewById(R.id.tvTimeW74);
        tvTimeW75 = v.findViewById(R.id.tvTimeW75);
        tvTimeW76 = v.findViewById(R.id.tvTimeW76);
        tvTimeW77 = v.findViewById(R.id.tvTimeW77);
        tvTimeW81 = v.findViewById(R.id.tvTimeW81);
        tvTimeW82 = v.findViewById(R.id.tvTimeW82);
        tvTimeW83 = v.findViewById(R.id.tvTimeW83);
        tvTimeW84 = v.findViewById(R.id.tvTimeW84);
        tvTimeW85 = v.findViewById(R.id.tvTimeW85);
        tvTimeW86 = v.findViewById(R.id.tvTimeW86);
        tvTimeW87 = v.findViewById(R.id.tvTimeW87);

        tvWSub11 = v.findViewById(R.id.tvWSub11);
        tvWSub22 = v.findViewById(R.id.tvWSub22);
        tvWSub33 = v.findViewById(R.id.tvWSub33);
        tvWSub44 = v.findViewById(R.id.tvWSub44);
        tvWSub55 = v.findViewById(R.id.tvWSub55);
        tvWSub66 = v.findViewById(R.id.tvWSub66);
        tvWSub77 = v.findViewById(R.id.tvWSub77);
        tvWSub88 = v.findViewById(R.id.tvWSub88);

        tvWClass11 = v.findViewById(R.id.tvWClass11);
        tvWClass22 = v.findViewById(R.id.tvWClass22);
        tvWClass33 = v.findViewById(R.id.tvWClass33);
        tvWClass44 = v.findViewById(R.id.tvWClass44);
        tvWClass55 = v.findViewById(R.id.tvWClass55);
        tvWClass66 = v.findViewById(R.id.tvWClass66);
        tvWClass77 = v.findViewById(R.id.tvWClass77);
        tvWClass88 = v.findViewById(R.id.tvWClass88);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String W1Sub = SP.getString("W1Sub", "");
        String W2Sub = SP.getString("W2Sub", "");
        String W3Sub = SP.getString("W3Sub", "");
        String W4Sub = SP.getString("W4Sub", "");
        String W5Sub = SP.getString("W5Sub", "");
        String W6Sub = SP.getString("W6Sub", "");
        String W7Sub = SP.getString("W7Sub", "");
        String W8Sub = SP.getString("W8Sub", "");

        String W1Class = SP.getString("W1Class", "");
        String W2Class = SP.getString("W2Class", "");
        String W3Class = SP.getString("W3Class", "");
        String W4Class = SP.getString("W4Class", "");
        String W5Class = SP.getString("W5Class", "");
        String W6Class = SP.getString("W6Class", "");
        String W7Class = SP.getString("W7Class", "");
        String W8Class = SP.getString("W8Class", "");
        
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

        tvWSub11.setText(W1Sub);
        tvWSub22.setText(W2Sub);
        tvWSub33.setText(W3Sub);
        tvWSub44.setText(W4Sub);
        tvWSub55.setText(W5Sub);
        tvWSub66.setText(W6Sub);
        tvWSub77.setText(W7Sub);
        tvWSub88.setText(W8Sub);
        //////////////////
        tvWClass11.setText(W1Class);
        tvWClass22.setText(W2Class);
        tvWClass33.setText(W3Class);
        tvWClass44.setText(W4Class);
        tvWClass55.setText(W5Class);
        tvWClass66.setText(W6Class);
        tvWClass77.setText(W7Class);
        tvWClass88.setText(W8Class);
        //////////////////
        tvTimeW11.setText(T11);
        tvTimeW13.setText(T12);
        tvTimeW15.setText(T13);
        tvTimeW17.setText(T14);
        //////////////////
        tvTimeW21.setText(T21);
        tvTimeW23.setText(T22);
        tvTimeW25.setText(T23);
        tvTimeW27.setText(T24);
        /////////////////////
        tvTimeW31.setText(T31);
        tvTimeW33.setText(T32);
        tvTimeW35.setText(T33);
        tvTimeW37.setText(T34);
        ////////////////////////
        tvTimeW41.setText(T41);
        tvTimeW43.setText(T42);
        tvTimeW45.setText(T43);
        tvTimeW47.setText(T44);
        //////////////////////
        tvTimeW51.setText(T51);
        tvTimeW53.setText(T52);
        tvTimeW55.setText(T53);
        tvTimeW57.setText(T54);
        //////////////////////
        tvTimeW61.setText(T61);
        tvTimeW63.setText(T62);
        tvTimeW65.setText(T63);
        tvTimeW67.setText(T64);
        //////////////////////
        tvTimeW71.setText(T71);
        tvTimeW73.setText(T72);
        tvTimeW75.setText(T73);
        tvTimeW77.setText(T74);
        ///////////////////////
        tvTimeW81.setText(T81);
        tvTimeW83.setText(T82);
        tvTimeW85.setText(T83);
        tvTimeW87.setText(T84);

        if (W1Sub.length()>11)
        {
            tvWSub11.setPadding(0,0,0,8);
        }

        if (W2Sub.length()>11)
        {
            tvWSub22.setPadding(0,0,0,8);
        }

        if (W3Sub.length()>11)
        {
            tvWSub33.setPadding(0,0,0,8);
        }

        if (W4Sub.length()>11)
        {
            tvWSub44.setPadding(0,0,0,8);
        }

        if (W5Sub.length()>11)
        {
            tvWSub55.setPadding(0,0,0,8);
        }

        if (W6Sub.length()>11)
        {
            tvWSub66.setPadding(0,0,0,8);
        }

        if (W7Sub.length()>11)
        {
            tvWSub77.setPadding(0,0,0,8);
        }

        if (W8Sub.length()>11)
        {
            tvWSub88.setPadding(0,0,0,8);
        }

        if(T11.length()==0)
        {
            tvTimeW12.setVisibility(View.GONE);
            tvTimeW14.setVisibility(View.GONE);
            tvTimeW16.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW12.setVisibility(View.VISIBLE);
            tvTimeW14.setVisibility(View.VISIBLE);
            tvTimeW16.setVisibility(View.VISIBLE);
        }

        if(T21.length()==0)
        {
            tvTimeW22.setVisibility(View.GONE);
            tvTimeW24.setVisibility(View.GONE);
            tvTimeW26.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW22.setVisibility(View.VISIBLE);
            tvTimeW24.setVisibility(View.VISIBLE);
            tvTimeW26.setVisibility(View.VISIBLE);
        }

        if(T31.length()==0)
        {
            tvTimeW32.setVisibility(View.GONE);
            tvTimeW34.setVisibility(View.GONE);
            tvTimeW36.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW32.setVisibility(View.VISIBLE);
            tvTimeW34.setVisibility(View.VISIBLE);
            tvTimeW36.setVisibility(View.VISIBLE);
        }

        if(T41.length()==0)
        {
            tvTimeW42.setVisibility(View.GONE);
            tvTimeW44.setVisibility(View.GONE);
            tvTimeW46.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW42.setVisibility(View.VISIBLE);
            tvTimeW44.setVisibility(View.VISIBLE);
            tvTimeW46.setVisibility(View.VISIBLE);
        }

        if(T51.length()==0)
        {
            tvTimeW52.setVisibility(View.GONE);
            tvTimeW54.setVisibility(View.GONE);
            tvTimeW56.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW52.setVisibility(View.VISIBLE);
            tvTimeW54.setVisibility(View.VISIBLE);
            tvTimeW56.setVisibility(View.VISIBLE);
        }

        if(T61.length()==0)
        {
            tvTimeW62.setVisibility(View.GONE);
            tvTimeW64.setVisibility(View.GONE);
            tvTimeW66.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW62.setVisibility(View.VISIBLE);
            tvTimeW64.setVisibility(View.VISIBLE);
            tvTimeW66.setVisibility(View.VISIBLE);
        }

        if(T71.length()==0)
        {
            tvTimeW72.setVisibility(View.GONE);
            tvTimeW74.setVisibility(View.GONE);
            tvTimeW76.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW72.setVisibility(View.VISIBLE);
            tvTimeW74.setVisibility(View.VISIBLE);
            tvTimeW76.setVisibility(View.VISIBLE);
        }

        if(T81.length()==0)
        {
            tvTimeW82.setVisibility(View.GONE);
            tvTimeW84.setVisibility(View.GONE);
            tvTimeW86.setVisibility(View.GONE);
        }
        else
        {
            tvTimeW82.setVisibility(View.VISIBLE);
            tvTimeW84.setVisibility(View.VISIBLE);
            tvTimeW86.setVisibility(View.VISIBLE);
        }

        if (tvWSub11.getText().toString().isEmpty()) {
            tvWSub11.setVisibility(View.GONE);
            tvTimeW11.setVisibility(View.GONE);
            tvTimeW12.setVisibility(View.GONE);
            tvTimeW13.setVisibility(View.GONE);
            tvTimeW14.setVisibility(View.GONE);
            tvTimeW15.setVisibility(View.GONE);
            tvTimeW16.setVisibility(View.GONE);
            tvTimeW17.setVisibility(View.GONE);
            tvW1.setVisibility(View.GONE);
            tvWClass11.setVisibility(View.GONE);
        } else {
            tvWSub11.setVisibility(View.VISIBLE);
            tvTimeW11.setVisibility(View.VISIBLE);
            tvTimeW13.setVisibility(View.VISIBLE);
            tvTimeW15.setVisibility(View.VISIBLE);
            tvTimeW17.setVisibility(View.VISIBLE);
            tvW1.setVisibility(View.VISIBLE);
            tvWClass11.setVisibility(View.VISIBLE);
        }

        //2 строка
        if (tvWSub22.getText().toString().isEmpty()) {
            tvWSub22.setVisibility(View.GONE);
            tvTimeW21.setVisibility(View.GONE);
            tvTimeW22.setVisibility(View.GONE);
            tvTimeW23.setVisibility(View.GONE);
            tvTimeW24.setVisibility(View.GONE);
            tvTimeW25.setVisibility(View.GONE);
            tvTimeW26.setVisibility(View.GONE);
            tvTimeW27.setVisibility(View.GONE);
            tvW2.setVisibility(View.GONE);
            tvWClass22.setVisibility(View.GONE);
        } else {
            tvWSub22.setVisibility(View.VISIBLE);
            tvTimeW21.setVisibility(View.VISIBLE);
            tvTimeW23.setVisibility(View.VISIBLE);
            tvTimeW25.setVisibility(View.VISIBLE);
            tvTimeW27.setVisibility(View.VISIBLE);
            tvW2.setVisibility(View.VISIBLE);
            tvWClass22.setVisibility(View.VISIBLE);
        }

        //3 строка
        if (tvWSub33.getText().toString().isEmpty()) {
            tvWSub33.setVisibility(View.GONE);
            tvTimeW31.setVisibility(View.GONE);
            tvTimeW32.setVisibility(View.GONE);
            tvTimeW33.setVisibility(View.GONE);
            tvTimeW34.setVisibility(View.GONE);
            tvTimeW35.setVisibility(View.GONE);
            tvTimeW36.setVisibility(View.GONE);
            tvTimeW37.setVisibility(View.GONE);
            tvW3.setVisibility(View.GONE);
            tvWClass33.setVisibility(View.GONE);
        } else {
            tvWSub33.setVisibility(View.VISIBLE);
            tvTimeW31.setVisibility(View.VISIBLE);
            tvTimeW33.setVisibility(View.VISIBLE);
            tvTimeW35.setVisibility(View.VISIBLE);
            tvTimeW37.setVisibility(View.VISIBLE);
            tvW3.setVisibility(View.VISIBLE);
            tvWClass33.setVisibility(View.VISIBLE);
        }

        //4 строка
        if (tvWSub44.getText().toString().isEmpty()) {
            tvWSub44.setVisibility(View.GONE);
            tvTimeW41.setVisibility(View.GONE);
            tvTimeW42.setVisibility(View.GONE);
            tvTimeW43.setVisibility(View.GONE);
            tvTimeW44.setVisibility(View.GONE);
            tvTimeW45.setVisibility(View.GONE);
            tvTimeW46.setVisibility(View.GONE);
            tvTimeW47.setVisibility(View.GONE);
            tvW4.setVisibility(View.GONE);
            tvWClass44.setVisibility(View.GONE);
        } else {
            tvWSub44.setVisibility(View.VISIBLE);
            tvTimeW41.setVisibility(View.VISIBLE);
            tvTimeW43.setVisibility(View.VISIBLE);
            tvTimeW45.setVisibility(View.VISIBLE);
            tvTimeW47.setVisibility(View.VISIBLE);
            tvW4.setVisibility(View.VISIBLE);
            tvWClass44.setVisibility(View.VISIBLE);
        }

        //5 строка
        if (tvWSub55.getText().toString().isEmpty()) {
            tvWSub55.setVisibility(View.GONE);
            tvTimeW51.setVisibility(View.GONE);
            tvTimeW52.setVisibility(View.GONE);
            tvTimeW53.setVisibility(View.GONE);
            tvTimeW54.setVisibility(View.GONE);
            tvTimeW55.setVisibility(View.GONE);
            tvTimeW56.setVisibility(View.GONE);
            tvTimeW57.setVisibility(View.GONE);
            tvW5.setVisibility(View.GONE);
            tvWClass55.setVisibility(View.GONE);
        } else {
            tvWSub55.setVisibility(View.VISIBLE);
            tvTimeW51.setVisibility(View.VISIBLE);
            tvTimeW53.setVisibility(View.VISIBLE);
            tvTimeW55.setVisibility(View.VISIBLE);
            tvTimeW57.setVisibility(View.VISIBLE);
            tvW5.setVisibility(View.VISIBLE);
            tvWClass55.setVisibility(View.VISIBLE);
        }

        //6 строка
        if (tvWSub66.getText().toString().isEmpty()) {
            tvW6.setVisibility(View.GONE);
            tvTimeW61.setVisibility(View.GONE);
            tvTimeW62.setVisibility(View.GONE);
            tvTimeW63.setVisibility(View.GONE);
            tvTimeW64.setVisibility(View.GONE);
            tvTimeW65.setVisibility(View.GONE);
            tvTimeW66.setVisibility(View.GONE);
            tvTimeW67.setVisibility(View.GONE);
            tvW6.setVisibility(View.GONE);
            tvWClass66.setVisibility(View.GONE);
        } else {
            tvWSub66.setVisibility(View.VISIBLE);
            tvTimeW61.setVisibility(View.VISIBLE);
            tvTimeW63.setVisibility(View.VISIBLE);
            tvTimeW65.setVisibility(View.VISIBLE);
            tvTimeW67.setVisibility(View.VISIBLE);
            tvW6.setVisibility(View.VISIBLE);
            tvWClass66.setVisibility(View.VISIBLE);
        }

        //7 строка
        if (tvWSub77.getText().toString().isEmpty()) {
            tvWSub77.setVisibility(View.GONE);
            tvTimeW71.setVisibility(View.GONE);
            tvTimeW72.setVisibility(View.GONE);
            tvTimeW73.setVisibility(View.GONE);
            tvTimeW74.setVisibility(View.GONE);
            tvTimeW75.setVisibility(View.GONE);
            tvTimeW76.setVisibility(View.GONE);
            tvTimeW77.setVisibility(View.GONE);
            tvW7.setVisibility(View.GONE);
            tvWClass77.setVisibility(View.GONE);
        } else {
            tvWSub77.setVisibility(View.VISIBLE);
            tvTimeW71.setVisibility(View.VISIBLE);
            tvTimeW73.setVisibility(View.VISIBLE);
            tvTimeW75.setVisibility(View.VISIBLE);
            tvTimeW77.setVisibility(View.VISIBLE);
            tvW7.setVisibility(View.VISIBLE);
            tvWClass77.setVisibility(View.VISIBLE);
        }

        //8 строка
        if (tvWSub88.getText().toString().isEmpty()) {
            tvWSub88.setVisibility(View.GONE);
            tvTimeW81.setVisibility(View.GONE);
            tvTimeW82.setVisibility(View.GONE);
            tvTimeW83.setVisibility(View.GONE);
            tvTimeW84.setVisibility(View.GONE);
            tvTimeW85.setVisibility(View.GONE);
            tvTimeW86.setVisibility(View.GONE);
            tvTimeW87.setVisibility(View.GONE);
            tvW8.setVisibility(View.GONE);
            tvWClass88.setVisibility(View.GONE);
        } else {
            tvWSub88.setVisibility(View.VISIBLE);
            tvTimeW81.setVisibility(View.VISIBLE);
            tvTimeW83.setVisibility(View.VISIBLE);
            tvTimeW85.setVisibility(View.VISIBLE);
            tvTimeW87.setVisibility(View.VISIBLE);
            tvW8.setVisibility(View.VISIBLE);
            tvWClass88.setVisibility(View.VISIBLE);
        }

        return v;
    }

}