package ru.shkolaandstudents.Teacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Utilities;
import ru.shkolaandstudents.ui.main.StudyFragment;

public class TeacherFragmentRasp extends Fragment {

    Button btnMonday, btnTuesday, btnWend, btnTh, btnFr, btnSat;

    Utilities utils = new Utilities(getActivity());

    public static TeacherFragmentRasp newInstance() {
        return new TeacherFragmentRasp();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp, container, false);

        final SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btnMonday = v.findViewById(R.id.btnTeacherMonday);
        btnMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                if (M1Sub.length()==0 & M2Sub.length()==0 & M3Sub.length()==0 & M4Sub.length()==0 & M5Sub.length()==0 & M6Sub.length()==0 & M7Sub.length()==0 & M8Sub.length()==0 & M1Class.length()==0& M2Class.length()==0& M3Class.length()==0& M4Class.length()==0& M5Class.length()==0& M6Class.length()==0& M7Class.length()==0& M8Class.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp1), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    utils.switchFragment(getActivity(), new TeacherFragmentRaspMond());
                    /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TeacherFragmentRaspMond());
                    transaction.commit();*/
                }

            }
        });

        btnTuesday = v.findViewById(R.id.btnTeacherTuesday);
        btnTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                if (T1Sub.length()==0 & T2Sub.length()==0 & T3Sub.length()==0 & T4Sub.length()==0 & T5Sub.length()==0 & T6Sub.length()==0 & T7Sub.length()==0 & T8Sub.length()==0 & T1Class.length()==0& T2Class.length()==0& T3Class.length()==0& T4Class.length()==0& T5Class.length()==0& T6Class.length()==0& T7Class.length()==0& T8Class.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp2), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    utils.switchFragment(getActivity(), new TeacherFragmentRaspTue());
                    /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TeacherFragmentRaspTue());
                    transaction.commit();*/
                }
            }
        });

        btnWend = v.findViewById(R.id.btnTeacherWendsday);
        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                if (W1Sub.length()==0 & W2Sub.length()==0 & W3Sub.length()==0 & W4Sub.length()==0 & W5Sub.length()==0 & W6Sub.length()==0 & W7Sub.length()==0 & W8Sub.length()==0 & W1Class.length()==0& W2Class.length()==0& W3Class.length()==0& W4Class.length()==0& W5Class.length()==0& W6Class.length()==0& W7Class.length()==0& W8Class.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp3), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    utils.switchFragment(getActivity(), new TeacherFragmentRaspWend());
                    /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TeacherFragmentRaspWend());
                    transaction.commit();*/
                }

            }
        });

        btnTh = v.findViewById(R.id.btnTeacherThursday);
        btnTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                if (Th1Sub.length()==0 & Th2Sub.length()==0 & Th3Sub.length()==0 & Th4Sub.length()==0 & Th5Sub.length()==0 & Th6Sub.length()==0 & Th7Sub.length()==0 & Th8Sub.length()==0 & Th1Class.length()==0& Th2Class.length()==0& Th3Class.length()==0& Th4Class.length()==0& Th5Class.length()==0& Th6Class.length()==0& Th7Class.length()==0& Th8Class.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp4), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    utils.switchFragment(getActivity(), new TeacherFragmentRaspThu());
                    /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TeacherFragmentRaspThu());
                    transaction.commit();*/
                }

            }
        });

        btnFr = v.findViewById(R.id.btnTeacherFriday);
        btnFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                if (Fr1Sub.length()==0 & Fr2Sub.length()==0 & Fr3Sub.length()==0 & Fr4Sub.length()==0 & Fr5Sub.length()==0 & Fr6Sub.length()==0 & Fr7Sub.length()==0 & Fr8Sub.length()==0 & Fr1Class.length()==0& Fr2Class.length()==0& Fr3Class.length()==0& Fr4Class.length()==0& Fr5Class.length()==0& Fr6Class.length()==0& Fr7Class.length()==0& Fr8Class.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp5), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    utils.switchFragment(getActivity(), new TeacherFragmentRaspFri());
                    /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TeacherFragmentRaspFri());
                    transaction.commit();*/
                }

            }
        });

        btnSat = v.findViewById(R.id.btnTeacherSat);
        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Sat1Sub = SP.getString("Sat1Sub", "");
                String Sat2Sub = SP.getString("Sat2Sub", "");
                String Sat3Sub = SP.getString("Sat3Sub", "");
                String Sat4Sub = SP.getString("Sat4Sub", "");
                String Sat5Sub = SP.getString("Sat5Sub", "");
                String Sat6Sub = SP.getString("Sat6Sub", "");
                String Sat7Sub = SP.getString("Sat7Sub", "");
                String Sat8Sub = SP.getString("Sat8Sub", "");

                String Sat1Class = SP.getString("Sat1Class", "");
                String Sat2Class = SP.getString("Sat2Class", "");
                String Sat3Class = SP.getString("Sat3Class", "");
                String Sat4Class = SP.getString("Sat4Class", "");
                String Sat5Class = SP.getString("Sat5Class", "");
                String Sat6Class = SP.getString("Sat6Class", "");
                String Sat7Class = SP.getString("Sat7Class", "");
                String Sat8Class = SP.getString("Sat8Class", "");

                if (Sat1Sub.length()==0 & Sat2Sub.length()==0 & Sat3Sub.length()==0 & Sat4Sub.length()==0 & Sat5Sub.length()==0 & Sat6Sub.length()==0 & Sat7Sub.length()==0 & Sat8Sub.length()==0 & Sat1Class.length()==0& Sat2Class.length()==0& Sat3Class.length()==0& Sat4Class.length()==0& Sat5Class.length()==0& Sat6Class.length()==0& Sat7Class.length()==0& Sat8Class.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp6), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    utils.switchFragment(getActivity(), new TeacherFragmentRaspSat());
                    /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TeacherFragmentRaspSat());
                    transaction.commit();*/
                }

            }
        });

        /*Button btnSwap = v.findViewById(R.id.btnTeacher);
        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TeacherMainActivity.class);
                startActivity(intent);
            }
        });*/

        /*final SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs2", MODE_PRIVATE);
        boolean firstSTart = prefs.getBoolean("firstStart2", true);
        if(firstSTart) {
            new TapTargetSequence(getActivity())
                    .targets(
                            TapTarget.forView(v.findViewById(R.id.btnMonday),getResources().getString(R.string.Menu1_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                    .titleTextSize(20)
                                    .titleTextColor(R.color.colorWhite)
                                    .descriptionTextColor(R.color.colorWhite)
                                    .cancelable(false)
                                    .tintTarget(false)
                                    .targetRadius(50)
                                    .transparentTarget(true)
                                    .outerCircleColor(R.color.colorTuesday))
                    .listener(new TapTargetSequence.Listener() {
                        @Override
                        public void onSequenceFinish() {
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart2", false);
                            editor.apply();
                        }

                        @Override
                        public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                        }

                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {
                        }
                    }).start();
        }*/
        return v;
    }
}