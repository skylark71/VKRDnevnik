package ru.shkolaandstudents.ui.main;

import android.content.Intent;
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
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import ru.shkolaandstudents.LoginAndRegist.DashboardActivity;
import ru.shkolaandstudents.MainActivity;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Teacher.TeacherMainActivity;

import static android.content.Context.MODE_PRIVATE;


public class StudyFragment extends Fragment {

    Button btnMonday, btnTuesday, btnWend, btnTh, btnFr, btnSat;
    TextView title;

    public static StudyFragment newInstance() {
        return new StudyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.study_fragment, container, false);

        final SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btnMonday = v.findViewById(R.id.btnMonday);
        btnMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new MondayFragment());
                transaction.commit();

                /*String M1 = SP.getString("M1", "");
                String M2 = SP.getString("M2", "");
                String M3 = SP.getString("M3", "");
                String M4 = SP.getString("M4", "");
                String M5 = SP.getString("M5", "");
                String M6 = SP.getString("M6", "");
                String M7 = SP.getString("M7", "");
                String M8 = SP.getString("M8", "");

                if (M1.length()==0 & M2.length()==0 & M3.length()==0 & M4.length()==0 & M5.length()==0 & M6.length()==0 & M7.length()==0 & M8.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp1), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new MondayFragment());
                    transaction.commit();
                }*/

            }
        });

        btnTuesday = v.findViewById(R.id.btnTuesday);
        btnTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new TuesdayFragment());
                transaction.commit();

                /*String T1 = SP.getString("T1", "");
                String T2 = SP.getString("T2", "");
                String T3 = SP.getString("T3", "");
                String T4 = SP.getString("T4", "");
                String T5 = SP.getString("T5", "");
                String T6 = SP.getString("T6", "");
                String T7 = SP.getString("T7", "");
                String T8 = SP.getString("T8", "");
                if (T1.length()==0 & T2.length()==0 & T3.length()==0 & T4.length()==0 & T5.length()==0 & T6.length()==0 & T7.length()==0 & T8.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp2), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TuesdayFragment());
                    transaction.commit();
                }*/
            }
        });

        btnWend = v.findViewById(R.id.btnWendsday);
        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new WendFragment());
                transaction.commit();

                /*String W1 = SP.getString("W1", "");
                String W2 = SP.getString("W2", "");
                String W3 = SP.getString("W3", "");
                String W4 = SP.getString("W4", "");
                String W5 = SP.getString("W5", "");
                String W6 = SP.getString("W6", "");
                String W7 = SP.getString("W7", "");
                String W8 = SP.getString("W8", "");
                if (W1.length()==0 & W2.length()==0 & W3.length()==0 & W4.length()==0 & W5.length()==0 & W6.length()==0 & W7.length()==0 & W8.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp3), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new WendFragment());
                    transaction.commit();
                }*/

            }
        });

        btnTh = v.findViewById(R.id.btnThursday);
        btnTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new ThursdayFragment());
                transaction.commit();

                /*String Th1 = SP.getString("Th1", "");
                String Th2 = SP.getString("Th2", "");
                String Th3 = SP.getString("Th3", "");
                String Th4 = SP.getString("Th4", "");
                String Th5 = SP.getString("Th5", "");
                String Th6 = SP.getString("Th6", "");
                String Th7 = SP.getString("Th7", "");
                String Th8 = SP.getString("Th8", "");

                if (Th1.length()==0 & Th2.length()==0 & Th3.length()==0 & Th4.length()==0 & Th5.length()==0 & Th6.length()==0 & Th7.length()==0 & Th8.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp4), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new ThursdayFragment());
                    transaction.commit();
                }*/

            }
        });

        btnFr = v.findViewById(R.id.btnFriday);
        btnFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new FridayFragment());
                transaction.commit();

                /*String Fr1 = SP.getString("Fr1", "");
                String Fr2 = SP.getString("Fr2", "");
                String Fr3 = SP.getString("Fr3", "");
                String Fr4 = SP.getString("Fr4", "");
                String Fr5 = SP.getString("Fr5", "");
                String Fr6 = SP.getString("Fr6", "");
                String Fr7 = SP.getString("Fr7", "");
                String Fr8 = SP.getString("Fr8", "");
                if (Fr1.length()==0 & Fr2.length()==0 & Fr3.length()==0 & Fr4.length()==0 & Fr5.length()==0 & Fr6.length()==0 & Fr7.length()==0 & Fr8.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp5), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new FridayFragment());
                    transaction.commit();
                }*/

            }
        });

        btnSat = v.findViewById(R.id.btnSat);
        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SaturdayFragment());
                transaction.commit();

                /*String Sat1 = SP.getString("Sat1", "");
                String Sat2 = SP.getString("Sat2", "");
                String Sat3 = SP.getString("Sat3", "");
                String Sat4 = SP.getString("Sat4", "");
                String Sat5 = SP.getString("Sat5", "");
                String Sat6 = SP.getString("Sat6", "");
                String Sat7 = SP.getString("Sat7", "");
                String Sat8 = SP.getString("Sat8", "");
                if (Sat1.length()==0 & Sat2.length()==0 & Sat3.length()==0 & Sat4.length()==0 & Sat5.length()==0 & Sat6.length()==0 & Sat7.length()==0 & Sat8.length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.Rasp6), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new SaturdayFragment());
                    transaction.commit();
                }*/

            }
        });

        title = v.findViewById(R.id.tvPaspisanie);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(getActivity(), TeacherMainActivity.class);
                startActivity(intent);
            }
        });
        /*Button btnSwap = v.findViewById(R.id.btnTeacher);
        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        final SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs2", MODE_PRIVATE);
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
        }
        return v;
    }

    public StudyFragment()
    {

    }


}