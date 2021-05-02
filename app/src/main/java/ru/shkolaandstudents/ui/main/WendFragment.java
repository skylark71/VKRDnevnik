package ru.shkolaandstudents.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;

public class WendFragment extends Fragment implements OnBackPressedListener {

    TextView tvW1, tvW2, tvW3, tvW4, tvW5, tvW6, tvW7, tvW8, tvTimeW11, tvTimeW12, tvTimeW13, tvTimeW14, tvTimeW15, tvTimeW16, tvTimeW17, tvTimeW21, tvTimeW22, tvTimeW23, tvTimeW24, tvTimeW25, tvTimeW26, tvTimeW27, tvTimeW31, tvTimeW32, tvTimeW33, tvTimeW34, tvTimeW35, tvTimeW36, tvTimeW37, tvTimeW41, tvTimeW42, tvTimeW43, tvTimeW44, tvTimeW45, tvTimeW46, tvTimeW47, tvTimeW51, tvTimeW52, tvTimeW53, tvTimeW54, tvTimeW55, tvTimeW56, tvTimeW57, tvTimeW61, tvTimeW62, tvTimeW63, tvTimeW64, tvTimeW65, tvTimeW66, tvTimeW67, tvTimeW71, tvTimeW72, tvTimeW73, tvTimeW74, tvTimeW75, tvTimeW76, tvTimeW77, tvTimeW81, tvTimeW82, tvTimeW83, tvTimeW84, tvTimeW85, tvTimeW86, tvTimeW87, tvW11, tvW22, tvW33, tvW44, tvW55, tvW66, tvW77, tvW88;
    EditText etW1DZ, etW2DZ, etW3DZ, etW4DZ, etW5DZ, etW6DZ, etW7DZ, etW8DZ;
    Button btnHelp;
    TextView tvOcenkaW1, tvOcenkaW2, tvOcenkaW3, tvOcenkaW4, tvOcenkaW5, tvOcenkaW6, tvOcenkaW7, tvOcenkaW8;
    String W1, W2, W3, W4, W5, W6, W7, W8;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_wend, container, false);

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
                                TapTarget.forView(v.findViewById(R.id.tvW11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etW1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaW1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
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

        tvOcenkaW1 = v.findViewById(R.id.tvOcenkaW1);
        tvOcenkaW2 = v.findViewById(R.id.tvOcenkaW2);
        tvOcenkaW3 = v.findViewById(R.id.tvOcenkaW3);
        tvOcenkaW4 = v.findViewById(R.id.tvOcenkaW4);
        tvOcenkaW5 = v.findViewById(R.id.tvOcenkaW5);
        tvOcenkaW6 = v.findViewById(R.id.tvOcenkaW6);
        tvOcenkaW7 = v.findViewById(R.id.tvOcenkaW7);
        tvOcenkaW8 = v.findViewById(R.id.tvOcenkaW8);

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
        tvW11 = v.findViewById(R.id.tvW11);
        tvW22 = v.findViewById(R.id.tvW22);
        tvW33 = v.findViewById(R.id.tvW33);
        tvW44 = v.findViewById(R.id.tvW44);
        tvW55 = v.findViewById(R.id.tvW55);
        tvW66 = v.findViewById(R.id.tvW66);
        tvW77 = v.findViewById(R.id.tvW77);
        tvW88 = v.findViewById(R.id.tvW88);
        etW1DZ = v.findViewById(R.id.etW1DZ);
        etW2DZ = v.findViewById(R.id.etW2DZ);
        etW3DZ = v.findViewById(R.id.etW3DZ);
        etW4DZ = v.findViewById(R.id.etW4DZ);
        etW5DZ = v.findViewById(R.id.etW5DZ);
        etW6DZ = v.findViewById(R.id.etW6DZ);
        etW7DZ = v.findViewById(R.id.etW7DZ);
        etW8DZ = v.findViewById(R.id.etW8DZ);

        final String[] arr_sub1 = new String[8];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /**
                 * Get value subjects from database
                 */
                W1 = String.valueOf(snapshot.child("SubW1").getValue());
                W2 = String.valueOf(snapshot.child("SubW2").getValue());
                W3 = String.valueOf(snapshot.child("SubW3").getValue());
                W4 = String.valueOf(snapshot.child("SubW4").getValue());
                W5 = String.valueOf(snapshot.child("SubW5").getValue());
                W6 = String.valueOf(snapshot.child("SubW6").getValue());
                W7 = String.valueOf(snapshot.child("SubW7").getValue());
                W8 = String.valueOf(snapshot.child("SubW8").getValue());

                final String[] arr_sub = new String[8];
                final String[] arr_set = new String[8];
                arr_sub[0] = W1;
                arr_sub[1] = W2;
                arr_sub[2] = W3;
                arr_sub[3] = W4;
                arr_sub[4] = W5;
                arr_sub[5] = W6;
                arr_sub[6] = W7;
                arr_sub[7] = W8;
                final TextView[] arr = new TextView[8];

                /**
                 * СОЗДАНИЕ МАССИВОВ VALUE
                 * */
                DatabaseReference reff1 = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Оценки");
                reff1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int i = 0;
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            final String str_sub = ds.getKey();
                            for (int j = 0; j < 8; j++) {
                                if (str_sub.equals(arr_sub[j])) {
                                    final String view_ocenka = "tvOcenkaW" + (i + 1);
                                    arr_set[i] = view_ocenka;
                                    arr_sub1[i] = str_sub;
                                    i++;
                                    break;
                                }
                            }
                        }

                        /**
                         * ПОПЫТКА VALUE SET НА ТЕКСТЫ
                         * */
                        for (int ii = 0; ii < i; ii++) {
                            DatabaseReference reff2 = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Оценки").child(arr_sub1[ii]);
                            final int count = ii;
                            reff2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot ds : snapshot.getChildren()) {
                                        Calendar now = Calendar.getInstance();
                                        //String monday = now.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
                                        int weekday1 = now.get(Calendar.DAY_OF_WEEK);
                                        int days1 = ((Calendar.SATURDAY - weekday1 + 2) % 7) - 7;
                                        now.add(Calendar.DAY_OF_YEAR, days1);
                                        Date date1 = now.getTime();
                                        String dayStr = new SimpleDateFormat("EEE").format(date1);

                                        int Mn = 2;
                                        Calendar now1 = Calendar.getInstance();
                                        int weekday = now1.get(Calendar.DAY_OF_WEEK);
                                        int days = ((Calendar.SATURDAY - weekday + Mn) % 7) - 7;
                                        now1.add(Calendar.DAY_OF_YEAR, days);
                                        Date date = now1.getTime();
                                        String dateStr = new SimpleDateFormat("dd/MM/yyyy").format(date);

                                        String str_date = String.valueOf(ds.child("Дата").getValue());
                                        if (str_date.equals(dateStr)) {
                                            System.out.println("Test");
                                        }
                                        String str_day = String.valueOf(ds.child("День").getValue());
                                        if (dayStr.equals(str_day)) {
                                            String str_ocenka = String.valueOf(ds.child("Оценка").getValue());
                                            int resIDdate = getResources().getIdentifier(arr_set[count], "id", getActivity().getPackageName());
                                            arr[count] = ((TextView) v.findViewById(resIDdate));
                                            arr[count].setText(str_ocenka);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                /**
                 * Check exist value subject
                 */
                if (snapshot.child("SubW1").exists()) {
                    tvW11.setText(W1);
                } else {
                    tvW11.setText("");
                }

                if (snapshot.child("SubW2").exists()) {
                    tvW22.setText(W2);
                } else {
                    tvW22.setText("");
                }

                if (snapshot.child("SubW3").exists()) {
                    tvW33.setText(W3);
                } else {
                    tvW33.setText("");
                }

                if (snapshot.child("SubW4").exists()) {
                    tvW44.setText(W4);
                } else {
                    tvW44.setText("");
                }

                if (snapshot.child("SubW5").exists()) {
                    tvW55.setText(W5);
                } else {
                    tvW55.setText("");
                }

                if (snapshot.child("SubW6").exists()) {
                    tvW66.setText(W6);
                } else {
                    tvW66.setText("");
                }

                if (snapshot.child("SubW7").exists()) {
                    tvW77.setText(W7);
                } else {
                    tvW77.setText("");
                }

                if (snapshot.child("SubW8").exists()) {
                    tvW88.setText(W8);
                } else {
                    tvW88.setText("");
                }

                /**
                 * Get value time from db
                 */
                String sW11 = String.valueOf(snapshot.child("T11").getValue());
                String sW12 = String.valueOf(snapshot.child("T12").getValue());
                String sW13 = String.valueOf(snapshot.child("T13").getValue());
                String sW14 = String.valueOf(snapshot.child("T14").getValue());

                String sW21 = String.valueOf(snapshot.child("T21").getValue());
                String sW22 = String.valueOf(snapshot.child("T22").getValue());
                String sW23 = String.valueOf(snapshot.child("T23").getValue());
                String sW24 = String.valueOf(snapshot.child("T24").getValue());

                String sW31 = String.valueOf(snapshot.child("T31").getValue());
                String sW32 = String.valueOf(snapshot.child("T32").getValue());
                String sW33 = String.valueOf(snapshot.child("T33").getValue());
                String sW34 = String.valueOf(snapshot.child("T34").getValue());

                String sW41 = String.valueOf(snapshot.child("T41").getValue());
                String sW42 = String.valueOf(snapshot.child("T42").getValue());
                String sW43 = String.valueOf(snapshot.child("T43").getValue());
                String sW44 = String.valueOf(snapshot.child("T44").getValue());

                String sW51 = String.valueOf(snapshot.child("T51").getValue());
                String sW52 = String.valueOf(snapshot.child("T52").getValue());
                String sW53 = String.valueOf(snapshot.child("T53").getValue());
                String sW54 = String.valueOf(snapshot.child("T54").getValue());

                String sW61 = String.valueOf(snapshot.child("T61").getValue());
                String sW62 = String.valueOf(snapshot.child("T62").getValue());
                String sW63 = String.valueOf(snapshot.child("T63").getValue());
                String sW64 = String.valueOf(snapshot.child("T64").getValue());

                String sW71 = String.valueOf(snapshot.child("T71").getValue());
                String sW72 = String.valueOf(snapshot.child("T72").getValue());
                String sW73 = String.valueOf(snapshot.child("T73").getValue());
                String sW74 = String.valueOf(snapshot.child("T74").getValue());

                String sW81 = String.valueOf(snapshot.child("T81").getValue());
                String sW82 = String.valueOf(snapshot.child("T82").getValue());
                String sW83 = String.valueOf(snapshot.child("T83").getValue());
                String sW84 = String.valueOf(snapshot.child("T84").getValue());

                /**
                 * Set value time from db
                 */
                //////////////////
                tvTimeW11.setText(sW11);
                tvTimeW13.setText(sW12);
                tvTimeW15.setText(sW13);
                tvTimeW17.setText(sW14);
                //////////////////
                tvTimeW21.setText(sW21);
                tvTimeW23.setText(sW22);
                tvTimeW25.setText(sW23);
                tvTimeW27.setText(sW24);
                /////////////////////
                tvTimeW31.setText(sW31);
                tvTimeW33.setText(sW32);
                tvTimeW35.setText(sW33);
                tvTimeW37.setText(sW34);
                ////////////////////////
                tvTimeW41.setText(sW41);
                tvTimeW43.setText(sW42);
                tvTimeW45.setText(sW43);
                tvTimeW47.setText(sW44);
                //////////////////////
                tvTimeW51.setText(sW51);
                tvTimeW53.setText(sW52);
                tvTimeW55.setText(sW53);
                tvTimeW57.setText(sW54);
                //////////////////////
                tvTimeW61.setText(sW61);
                tvTimeW63.setText(sW62);
                tvTimeW65.setText(sW63);
                tvTimeW67.setText(sW64);
                //////////////////////
                tvTimeW71.setText(sW71);
                tvTimeW73.setText(sW72);
                tvTimeW75.setText(sW73);
                tvTimeW77.setText(sW74);
                ///////////////////////
                tvTimeW81.setText(sW81);
                tvTimeW83.setText(sW82);
                tvTimeW85.setText(sW83);
                tvTimeW87.setText(sW84);

                /**
                 * Check value time for ui
                 */
                if (sW11.equals("null")) {
                    tvTimeW11.setVisibility(View.GONE);
                    tvTimeW12.setVisibility(View.GONE);
                    tvTimeW13.setVisibility(View.GONE);
                    tvTimeW14.setVisibility(View.GONE);
                    tvTimeW15.setVisibility(View.GONE);
                    tvTimeW16.setVisibility(View.GONE);
                    tvTimeW17.setVisibility(View.GONE);
                } else {
                    tvTimeW12.setVisibility(View.VISIBLE);
                    tvTimeW14.setVisibility(View.VISIBLE);
                    tvTimeW16.setVisibility(View.VISIBLE);
                }

                if (sW21.equals("null")) {
                    tvTimeW21.setVisibility(View.GONE);
                    tvTimeW22.setVisibility(View.GONE);
                    tvTimeW23.setVisibility(View.GONE);
                    tvTimeW24.setVisibility(View.GONE);
                    tvTimeW25.setVisibility(View.GONE);
                    tvTimeW26.setVisibility(View.GONE);
                    tvTimeW27.setVisibility(View.GONE);
                } else {
                    tvTimeW22.setVisibility(View.VISIBLE);
                    tvTimeW24.setVisibility(View.VISIBLE);
                    tvTimeW26.setVisibility(View.VISIBLE);
                }

                if (sW31.equals("null")) {
                    tvTimeW31.setVisibility(View.GONE);
                    tvTimeW32.setVisibility(View.GONE);
                    tvTimeW33.setVisibility(View.GONE);
                    tvTimeW34.setVisibility(View.GONE);
                    tvTimeW35.setVisibility(View.GONE);
                    tvTimeW36.setVisibility(View.GONE);
                    tvTimeW37.setVisibility(View.GONE);
                } else {
                    tvTimeW32.setVisibility(View.VISIBLE);
                    tvTimeW34.setVisibility(View.VISIBLE);
                    tvTimeW36.setVisibility(View.VISIBLE);
                }

                if (sW41.equals("null")) {
                    tvTimeW41.setVisibility(View.GONE);
                    tvTimeW42.setVisibility(View.GONE);
                    tvTimeW43.setVisibility(View.GONE);
                    tvTimeW44.setVisibility(View.GONE);
                    tvTimeW45.setVisibility(View.GONE);
                    tvTimeW46.setVisibility(View.GONE);
                    tvTimeW47.setVisibility(View.GONE);
                } else {
                    tvTimeW42.setVisibility(View.VISIBLE);
                    tvTimeW44.setVisibility(View.VISIBLE);
                    tvTimeW46.setVisibility(View.VISIBLE);
                }

                if (sW51.equals("null")) {
                    tvTimeW51.setVisibility(View.GONE);
                    tvTimeW52.setVisibility(View.GONE);
                    tvTimeW53.setVisibility(View.GONE);
                    tvTimeW54.setVisibility(View.GONE);
                    tvTimeW55.setVisibility(View.GONE);
                    tvTimeW56.setVisibility(View.GONE);
                    tvTimeW57.setVisibility(View.GONE);
                } else {
                    tvTimeW52.setVisibility(View.VISIBLE);
                    tvTimeW54.setVisibility(View.VISIBLE);
                    tvTimeW56.setVisibility(View.VISIBLE);
                }

                if (sW61.equals("null")) {
                    tvTimeW61.setVisibility(View.GONE);
                    tvTimeW62.setVisibility(View.GONE);
                    tvTimeW63.setVisibility(View.GONE);
                    tvTimeW64.setVisibility(View.GONE);
                    tvTimeW65.setVisibility(View.GONE);
                    tvTimeW66.setVisibility(View.GONE);
                    tvTimeW67.setVisibility(View.GONE);
                } else {
                    tvTimeW62.setVisibility(View.VISIBLE);
                    tvTimeW64.setVisibility(View.VISIBLE);
                    tvTimeW66.setVisibility(View.VISIBLE);
                }

                if (sW71.equals("null")) {
                    tvTimeW71.setVisibility(View.GONE);
                    tvTimeW72.setVisibility(View.GONE);
                    tvTimeW73.setVisibility(View.GONE);
                    tvTimeW74.setVisibility(View.GONE);
                    tvTimeW75.setVisibility(View.GONE);
                    tvTimeW76.setVisibility(View.GONE);
                    tvTimeW77.setVisibility(View.GONE);
                } else {
                    tvTimeW72.setVisibility(View.VISIBLE);
                    tvTimeW74.setVisibility(View.VISIBLE);
                    tvTimeW76.setVisibility(View.VISIBLE);
                }

                if (sW81.equals("null")) {
                    tvTimeW81.setVisibility(View.GONE);
                    tvTimeW82.setVisibility(View.GONE);
                    tvTimeW83.setVisibility(View.GONE);
                    tvTimeW84.setVisibility(View.GONE);
                    tvTimeW85.setVisibility(View.GONE);
                    tvTimeW86.setVisibility(View.GONE);
                    tvTimeW87.setVisibility(View.GONE);
                } else {
                    tvTimeW82.setVisibility(View.VISIBLE);
                    tvTimeW84.setVisibility(View.VISIBLE);
                    tvTimeW86.setVisibility(View.VISIBLE);
                }

                /**
                 * Отступ снизу для видимости TextView
                 * */
                if (!W1.equals("null") && W1.length() > 7) {
                    tvW11.setPadding(0, 0, 0, 8);
                }

                if (!W2.equals("null") && W2.length() > 7) {
                    tvW22.setPadding(0, 0, 0, 8);
                }

                if (!W3.equals("null") && W3.length() > 7) {
                    tvW33.setPadding(0, 0, 0, 8);
                }

                if (!W4.equals("null") && W4.length() > 7) {
                    tvW44.setPadding(0, 0, 0, 8);
                }

                if (!W5.equals("null") && W5.length() > 7) {
                    tvW55.setPadding(0, 0, 0, 8);
                }

                if (!W6.equals("null") && W6.length() > 7) {
                    tvW66.setPadding(0, 0, 0, 8);
                }

                if (!W7.equals("null") && W7.length() > 7) {
                    tvW77.setPadding(0, 0, 0, 8);
                }

                if (!W8.equals("null") && W8.length() > 7) {
                    tvW88.setPadding(0, 0, 0, 8);
                }

                /**
                 * Check value subject from ui
                 */
                LinearLayout ll_row1 = v.findViewById(R.id.studentW_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.studentW_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.studentW_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.studentW_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.studentW_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.studentW_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.studentW_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.studentW_row8);

                //1 СТРОКА
                if (W1.equals("null")) {
                    ll_row1.setVisibility(View.GONE);
                } else {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (W2.equals("null")) {
                    ll_row2.setVisibility(View.GONE);
                } else {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (W3.equals("null")) {
                    ll_row3.setVisibility(View.GONE);
                } else {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (W4.equals("null")) {
                    ll_row4.setVisibility(View.GONE);
                } else {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (W5.equals("null")) {
                    ll_row5.setVisibility(View.GONE);
                } else {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (W6.equals("null")) {
                    ll_row6.setVisibility(View.GONE);
                } else {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (W7.equals("null")) {
                    ll_row7.setVisibility(View.GONE);
                } else {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (W8.equals("null")) {
                    ll_row8.setVisibility(View.GONE);
                } else {
                    ll_row8.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        loadText();

        return v;
    }

    private void saveText() {
        String sW1Dz = etW1DZ.getText().toString();
        String sW2Dz = etW2DZ.getText().toString();
        String sW3Dz = etW3DZ.getText().toString();
        String sW4Dz = etW4DZ.getText().toString();
        String sW5Dz = etW5DZ.getText().toString();
        String sW6Dz = etW6DZ.getText().toString();
        String sW7Dz = etW7DZ.getText().toString();
        String sW8Dz = etW8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        if (sW1Dz.length() != 0) {
            reff.child("W1Dz").setValue(sW1Dz);
        } else {
            reff.child("W1Dz").removeValue();
        }

        if (sW2Dz.length() != 0) {
            reff.child("W2Dz").setValue(sW2Dz);
        } else {
            reff.child("W2Dz").removeValue();
        }

        if (sW3Dz.length() != 0) {
            reff.child("W3Dz").setValue(sW3Dz);
        } else {
            reff.child("W3Dz").removeValue();
        }

        if (sW4Dz.length() != 0) {
            reff.child("W4Dz").setValue(sW4Dz);
        } else {
            reff.child("W4Dz").removeValue();
        }

        if (sW5Dz.length() != 0) {
            reff.child("W5Dz").setValue(sW5Dz);
        } else {
            reff.child("W5Dz").removeValue();
        }

        if (sW6Dz.length() != 0) {
            reff.child("W6Dz").setValue(sW6Dz);
        } else {
            reff.child("W6Dz").removeValue();
        }

        if (sW7Dz.length() != 0) {
            reff.child("W7Dz").setValue(sW7Dz);
        } else {
            reff.child("W7Dz").removeValue();
        }

        if (sW8Dz.length() != 0) {
            reff.child("W8Dz").setValue(sW8Dz);
        } else {
            reff.child("W8Dz").removeValue();
        }
    }

    private void loadText() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sW1DZ = String.valueOf(snapshot.child("W1Dz").getValue());
                String sW2DZ = String.valueOf(snapshot.child("W2Dz").getValue());
                String sW3DZ = String.valueOf(snapshot.child("W3Dz").getValue());
                String sW4DZ = String.valueOf(snapshot.child("W4Dz").getValue());
                String sW5DZ = String.valueOf(snapshot.child("W5Dz").getValue());
                String sW6DZ = String.valueOf(snapshot.child("W6Dz").getValue());
                String sW7DZ = String.valueOf(snapshot.child("W7Dz").getValue());
                String sW8DZ = String.valueOf(snapshot.child("W8Dz").getValue());

                if (snapshot.child("W1Dz").exists()) {
                    etW1DZ.setText(sW1DZ);
                } else {
                    etW1DZ.setText("");
                }

                if (snapshot.child("W2Dz").exists()) {
                    etW2DZ.setText(sW2DZ);
                } else {
                    etW2DZ.setText("");
                }

                if (snapshot.child("W3Dz").exists()) {
                    etW3DZ.setText(sW3DZ);
                } else {
                    etW3DZ.setText("");
                }

                if (snapshot.child("W4Dz").exists()) {
                    etW4DZ.setText(sW4DZ);
                } else {
                    etW4DZ.setText("");
                }

                if (snapshot.child("W5Dz").exists()) {
                    etW5DZ.setText(sW5DZ);
                } else {
                    etW5DZ.setText("");
                }

                if (snapshot.child("W6Dz").exists()) {
                    etW6DZ.setText(sW6DZ);
                } else {
                    etW6DZ.setText("");
                }

                if (snapshot.child("W7Dz").exists()) {
                    etW7DZ.setText(sW7DZ);
                } else {
                    etW7DZ.setText("");
                }

                if (snapshot.child("W8Dz").exists()) {
                    etW8DZ.setText(sW8DZ);
                } else {
                    etW8DZ.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
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