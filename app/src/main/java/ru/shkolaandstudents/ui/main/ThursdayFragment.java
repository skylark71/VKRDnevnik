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

public class ThursdayFragment extends Fragment implements OnBackPressedListener {

    TextView tvTh1, tvTh2, tvTh3, tvTh4, tvTh5, tvTh6, tvTh7, tvTh8, tvTimeTh11, tvTimeTh12, tvTimeTh13, tvTimeTh14, tvTimeTh15, tvTimeTh16, tvTimeTh17, tvTimeTh21, tvTimeTh22, tvTimeTh23, tvTimeTh24, tvTimeTh25, tvTimeTh26, tvTimeTh27, tvTimeTh31, tvTimeTh32, tvTimeTh33, tvTimeTh34, tvTimeTh35, tvTimeTh36, tvTimeTh37, tvTimeTh41, tvTimeTh42, tvTimeTh43, tvTimeTh44, tvTimeTh45, tvTimeTh46, tvTimeTh47, tvTimeTh51, tvTimeTh52, tvTimeTh53, tvTimeTh54, tvTimeTh55, tvTimeTh56, tvTimeTh57, tvTimeTh61, tvTimeTh62, tvTimeTh63, tvTimeTh64, tvTimeTh65, tvTimeTh66, tvTimeTh67, tvTimeTh71, tvTimeTh72, tvTimeTh73, tvTimeTh74, tvTimeTh75, tvTimeTh76, tvTimeTh77, tvTimeTh81, tvTimeTh82, tvTimeTh83, tvTimeTh84, tvTimeTh85, tvTimeTh86, tvTimeTh87, tvTh11, tvTh22, tvTh33, tvTh44, tvTh55, tvTh66, tvTh77, tvTh88;
    EditText etTh1DZ, etTh2DZ, etTh3DZ, etTh4DZ, etTh5DZ, etTh6DZ, etTh7DZ, etTh8DZ;
    Button btnHelp;
    TextView tvOcenkaTh1, tvOcenkaTh2, tvOcenkaTh3, tvOcenkaTh4, tvOcenkaTh5, tvOcenkaTh6, tvOcenkaTh7, tvOcenkaTh8;
    String Th1, Th2, Th3, Th4, Th5, Th6, Th7, Th8;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_thursday, container, false);

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
                                TapTarget.forView(v.findViewById(R.id.tvTh11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etTh1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaTh1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
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

        tvOcenkaTh1 = v.findViewById(R.id.tvOcenkaTh1);
        tvOcenkaTh2 = v.findViewById(R.id.tvOcenkaTh2);
        tvOcenkaTh3 = v.findViewById(R.id.tvOcenkaTh3);
        tvOcenkaTh4 = v.findViewById(R.id.tvOcenkaTh4);
        tvOcenkaTh5 = v.findViewById(R.id.tvOcenkaTh5);
        tvOcenkaTh6 = v.findViewById(R.id.tvOcenkaTh6);
        tvOcenkaTh7 = v.findViewById(R.id.tvOcenkaTh7);
        tvOcenkaTh8 = v.findViewById(R.id.tvOcenkaTh8);

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
        tvTh11 = v.findViewById(R.id.tvTh11);
        tvTh22 = v.findViewById(R.id.tvTh22);
        tvTh33 = v.findViewById(R.id.tvTh33);
        tvTh44 = v.findViewById(R.id.tvTh44);
        tvTh55 = v.findViewById(R.id.tvTh55);
        tvTh66 = v.findViewById(R.id.tvTh66);
        tvTh77 = v.findViewById(R.id.tvTh77);
        tvTh88 = v.findViewById(R.id.tvTh88);
        etTh1DZ = v.findViewById(R.id.etTh1DZ);
        etTh2DZ = v.findViewById(R.id.etTh2DZ);
        etTh3DZ = v.findViewById(R.id.etTh3DZ);
        etTh4DZ = v.findViewById(R.id.etTh4DZ);
        etTh5DZ = v.findViewById(R.id.etTh5DZ);
        etTh6DZ = v.findViewById(R.id.etTh6DZ);
        etTh7DZ = v.findViewById(R.id.etTh7DZ);
        etTh8DZ = v.findViewById(R.id.etTh8DZ);

        final String[] arr_sub1 = new String[8];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /**
                 * Get value subjects from database
                 */
                Th1 = String.valueOf(snapshot.child("SubTh1").getValue());
                Th2 = String.valueOf(snapshot.child("SubTh2").getValue());
                Th3 = String.valueOf(snapshot.child("SubTh3").getValue());
                Th4 = String.valueOf(snapshot.child("SubTh4").getValue());
                Th5 = String.valueOf(snapshot.child("SubTh5").getValue());
                Th6 = String.valueOf(snapshot.child("SubTh6").getValue());
                Th7 = String.valueOf(snapshot.child("SubTh7").getValue());
                Th8 = String.valueOf(snapshot.child("SubTh8").getValue());

                final String[] arr_sub = new String[8];
                final String[] arr_set = new String[8];
                arr_sub[0] = Th1;
                arr_sub[1] = Th2;
                arr_sub[2] = Th3;
                arr_sub[3] = Th4;
                arr_sub[4] = Th5;
                arr_sub[5] = Th6;
                arr_sub[6] = Th7;
                arr_sub[7] = Th8;
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
                                    final String view_ocenka = "tvOcenkaTh" + (i + 1);
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
                if (snapshot.child("SubTh1").exists()) {
                    tvTh11.setText(Th1);
                } else {
                    tvTh11.setText("");
                }

                if (snapshot.child("SubTh2").exists()) {
                    tvTh22.setText(Th2);
                } else {
                    tvTh22.setText("");
                }

                if (snapshot.child("SubTh3").exists()) {
                    tvTh33.setText(Th3);
                } else {
                    tvTh33.setText("");
                }

                if (snapshot.child("SubTh4").exists()) {
                    tvTh44.setText(Th4);
                } else {
                    tvTh44.setText("");
                }

                if (snapshot.child("SubTh5").exists()) {
                    tvTh55.setText(Th5);
                } else {
                    tvTh55.setText("");
                }

                if (snapshot.child("SubTh6").exists()) {
                    tvTh66.setText(Th6);
                } else {
                    tvTh66.setText("");
                }

                if (snapshot.child("SubTh7").exists()) {
                    tvTh77.setText(Th7);
                } else {
                    tvTh77.setText("");
                }

                if (snapshot.child("SubTh8").exists()) {
                    tvTh88.setText(Th8);
                } else {
                    tvTh88.setText("");
                }

                /**
                 * Get value time from db
                 */
                String sTh11 = String.valueOf(snapshot.child("T11").getValue());
                String sTh12 = String.valueOf(snapshot.child("T12").getValue());
                String sTh13 = String.valueOf(snapshot.child("T13").getValue());
                String sTh14 = String.valueOf(snapshot.child("T14").getValue());

                String sTh21 = String.valueOf(snapshot.child("T21").getValue());
                String sTh22 = String.valueOf(snapshot.child("T22").getValue());
                String sTh23 = String.valueOf(snapshot.child("T23").getValue());
                String sTh24 = String.valueOf(snapshot.child("T24").getValue());

                String sTh31 = String.valueOf(snapshot.child("T31").getValue());
                String sTh32 = String.valueOf(snapshot.child("T32").getValue());
                String sTh33 = String.valueOf(snapshot.child("T33").getValue());
                String sTh34 = String.valueOf(snapshot.child("T34").getValue());

                String sTh41 = String.valueOf(snapshot.child("T41").getValue());
                String sTh42 = String.valueOf(snapshot.child("T42").getValue());
                String sTh43 = String.valueOf(snapshot.child("T43").getValue());
                String sTh44 = String.valueOf(snapshot.child("T44").getValue());

                String sTh51 = String.valueOf(snapshot.child("T51").getValue());
                String sTh52 = String.valueOf(snapshot.child("T52").getValue());
                String sTh53 = String.valueOf(snapshot.child("T53").getValue());
                String sTh54 = String.valueOf(snapshot.child("T54").getValue());

                String sTh61 = String.valueOf(snapshot.child("T61").getValue());
                String sTh62 = String.valueOf(snapshot.child("T62").getValue());
                String sTh63 = String.valueOf(snapshot.child("T63").getValue());
                String sTh64 = String.valueOf(snapshot.child("T64").getValue());

                String sTh71 = String.valueOf(snapshot.child("T71").getValue());
                String sTh72 = String.valueOf(snapshot.child("T72").getValue());
                String sTh73 = String.valueOf(snapshot.child("T73").getValue());
                String sTh74 = String.valueOf(snapshot.child("T74").getValue());

                String sTh81 = String.valueOf(snapshot.child("T81").getValue());
                String sTh82 = String.valueOf(snapshot.child("T82").getValue());
                String sTh83 = String.valueOf(snapshot.child("T83").getValue());
                String sTh84 = String.valueOf(snapshot.child("T84").getValue());

                /**
                 * Set value time from db
                 */
                //////////////////
                tvTimeTh11.setText(sTh11);
                tvTimeTh13.setText(sTh12);
                tvTimeTh15.setText(sTh13);
                tvTimeTh17.setText(sTh14);
                //////////////////
                tvTimeTh21.setText(sTh21);
                tvTimeTh23.setText(sTh22);
                tvTimeTh25.setText(sTh23);
                tvTimeTh27.setText(sTh24);
                /////////////////////
                tvTimeTh31.setText(sTh31);
                tvTimeTh33.setText(sTh32);
                tvTimeTh35.setText(sTh33);
                tvTimeTh37.setText(sTh34);
                ////////////////////////
                tvTimeTh41.setText(sTh41);
                tvTimeTh43.setText(sTh42);
                tvTimeTh45.setText(sTh43);
                tvTimeTh47.setText(sTh44);
                //////////////////////
                tvTimeTh51.setText(sTh51);
                tvTimeTh53.setText(sTh52);
                tvTimeTh55.setText(sTh53);
                tvTimeTh57.setText(sTh54);
                //////////////////////
                tvTimeTh61.setText(sTh61);
                tvTimeTh63.setText(sTh62);
                tvTimeTh65.setText(sTh63);
                tvTimeTh67.setText(sTh64);
                //////////////////////
                tvTimeTh71.setText(sTh71);
                tvTimeTh73.setText(sTh72);
                tvTimeTh75.setText(sTh73);
                tvTimeTh77.setText(sTh74);
                ///////////////////////
                tvTimeTh81.setText(sTh81);
                tvTimeTh83.setText(sTh82);
                tvTimeTh85.setText(sTh83);
                tvTimeTh87.setText(sTh84);

                /**
                 * Check value time for ui
                 */
                if (sTh11.equals("null")) {
                    tvTimeTh11.setVisibility(View.GONE);
                    tvTimeTh12.setVisibility(View.GONE);
                    tvTimeTh13.setVisibility(View.GONE);
                    tvTimeTh14.setVisibility(View.GONE);
                    tvTimeTh15.setVisibility(View.GONE);
                    tvTimeTh16.setVisibility(View.GONE);
                    tvTimeTh17.setVisibility(View.GONE);
                } else {
                    tvTimeTh12.setVisibility(View.VISIBLE);
                    tvTimeTh14.setVisibility(View.VISIBLE);
                    tvTimeTh16.setVisibility(View.VISIBLE);
                }

                if (sTh21.equals("null")) {
                    tvTimeTh21.setVisibility(View.GONE);
                    tvTimeTh22.setVisibility(View.GONE);
                    tvTimeTh23.setVisibility(View.GONE);
                    tvTimeTh24.setVisibility(View.GONE);
                    tvTimeTh25.setVisibility(View.GONE);
                    tvTimeTh26.setVisibility(View.GONE);
                    tvTimeTh27.setVisibility(View.GONE);
                } else {
                    tvTimeTh22.setVisibility(View.VISIBLE);
                    tvTimeTh24.setVisibility(View.VISIBLE);
                    tvTimeTh26.setVisibility(View.VISIBLE);
                }

                if (sTh31.equals("null")) {
                    tvTimeTh31.setVisibility(View.GONE);
                    tvTimeTh32.setVisibility(View.GONE);
                    tvTimeTh33.setVisibility(View.GONE);
                    tvTimeTh34.setVisibility(View.GONE);
                    tvTimeTh35.setVisibility(View.GONE);
                    tvTimeTh36.setVisibility(View.GONE);
                    tvTimeTh37.setVisibility(View.GONE);
                } else {
                    tvTimeTh32.setVisibility(View.VISIBLE);
                    tvTimeTh34.setVisibility(View.VISIBLE);
                    tvTimeTh36.setVisibility(View.VISIBLE);
                }

                if (sTh41.equals("null")) {
                    tvTimeTh41.setVisibility(View.GONE);
                    tvTimeTh42.setVisibility(View.GONE);
                    tvTimeTh43.setVisibility(View.GONE);
                    tvTimeTh44.setVisibility(View.GONE);
                    tvTimeTh45.setVisibility(View.GONE);
                    tvTimeTh46.setVisibility(View.GONE);
                    tvTimeTh47.setVisibility(View.GONE);
                } else {
                    tvTimeTh42.setVisibility(View.VISIBLE);
                    tvTimeTh44.setVisibility(View.VISIBLE);
                    tvTimeTh46.setVisibility(View.VISIBLE);
                }

                if (sTh51.equals("null")) {
                    tvTimeTh51.setVisibility(View.GONE);
                    tvTimeTh52.setVisibility(View.GONE);
                    tvTimeTh53.setVisibility(View.GONE);
                    tvTimeTh54.setVisibility(View.GONE);
                    tvTimeTh55.setVisibility(View.GONE);
                    tvTimeTh56.setVisibility(View.GONE);
                    tvTimeTh57.setVisibility(View.GONE);
                } else {
                    tvTimeTh52.setVisibility(View.VISIBLE);
                    tvTimeTh54.setVisibility(View.VISIBLE);
                    tvTimeTh56.setVisibility(View.VISIBLE);
                }

                if (sTh61.equals("null")) {
                    tvTimeTh61.setVisibility(View.GONE);
                    tvTimeTh62.setVisibility(View.GONE);
                    tvTimeTh63.setVisibility(View.GONE);
                    tvTimeTh64.setVisibility(View.GONE);
                    tvTimeTh65.setVisibility(View.GONE);
                    tvTimeTh66.setVisibility(View.GONE);
                    tvTimeTh67.setVisibility(View.GONE);
                } else {
                    tvTimeTh62.setVisibility(View.VISIBLE);
                    tvTimeTh64.setVisibility(View.VISIBLE);
                    tvTimeTh66.setVisibility(View.VISIBLE);
                }

                if (sTh71.equals("null")) {
                    tvTimeTh71.setVisibility(View.GONE);
                    tvTimeTh72.setVisibility(View.GONE);
                    tvTimeTh73.setVisibility(View.GONE);
                    tvTimeTh74.setVisibility(View.GONE);
                    tvTimeTh75.setVisibility(View.GONE);
                    tvTimeTh76.setVisibility(View.GONE);
                    tvTimeTh77.setVisibility(View.GONE);
                } else {
                    tvTimeTh72.setVisibility(View.VISIBLE);
                    tvTimeTh74.setVisibility(View.VISIBLE);
                    tvTimeTh76.setVisibility(View.VISIBLE);
                }

                if (sTh81.equals("null")) {
                    tvTimeTh81.setVisibility(View.GONE);
                    tvTimeTh82.setVisibility(View.GONE);
                    tvTimeTh83.setVisibility(View.GONE);
                    tvTimeTh84.setVisibility(View.GONE);
                    tvTimeTh85.setVisibility(View.GONE);
                    tvTimeTh86.setVisibility(View.GONE);
                    tvTimeTh87.setVisibility(View.GONE);
                } else {
                    tvTimeTh82.setVisibility(View.VISIBLE);
                    tvTimeTh84.setVisibility(View.VISIBLE);
                    tvTimeTh86.setVisibility(View.VISIBLE);
                }

                if (!Th1.equals("null") && Th1.length() > 7) {
                    tvTh11.setPadding(0, 0, 0, 8);
                }

                if (!Th2.equals("null") && Th2.length() > 7) {
                    tvTh22.setPadding(0, 0, 0, 8);
                }

                if (!Th3.equals("null") && Th3.length() > 7) {
                    tvTh33.setPadding(0, 0, 0, 8);
                }

                if (!Th4.equals("null") && Th4.length() > 7) {
                    tvTh44.setPadding(0, 0, 0, 8);
                }

                if (!Th5.equals("null") && Th5.length() > 7) {
                    tvTh55.setPadding(0, 0, 0, 8);
                }

                if (!Th6.equals("null") && Th6.length() > 7) {
                    tvTh66.setPadding(0, 0, 0, 8);
                }

                if (!Th7.equals("null") && Th7.length() > 7) {
                    tvTh77.setPadding(0, 0, 0, 8);
                }

                if (!Th8.equals("null") && Th8.length() > 7) {
                    tvTh88.setPadding(0, 0, 0, 8);
                }

                /**
                 * Check value subject from ui
                 */
                LinearLayout ll_row1 = v.findViewById(R.id.studentTh_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.studentTh_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.studentTh_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.studentTh_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.studentTh_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.studentTh_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.studentTh_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.studentTh_row8);

                //1 СТРОКА
                if (Th1.equals("null")) {
                    ll_row1.setVisibility(View.GONE);
                } else {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (Th2.equals("null")) {
                    ll_row2.setVisibility(View.GONE);
                } else {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (Th3.equals("null")) {
                    ll_row3.setVisibility(View.GONE);
                } else {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (Th4.equals("null")) {
                    ll_row4.setVisibility(View.GONE);
                } else {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (Th5.equals("null")) {
                    ll_row5.setVisibility(View.GONE);
                } else {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (Th6.equals("null")) {
                    ll_row6.setVisibility(View.GONE);
                } else {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (Th7.equals("null")) {
                    ll_row7.setVisibility(View.GONE);
                } else {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (Th8.equals("null")) {
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
        String sTh1Dz = etTh1DZ.getText().toString();
        String sTh2Dz = etTh2DZ.getText().toString();
        String sTh3Dz = etTh3DZ.getText().toString();
        String sTh4Dz = etTh4DZ.getText().toString();
        String sTh5Dz = etTh5DZ.getText().toString();
        String sTh6Dz = etTh6DZ.getText().toString();
        String sTh7Dz = etTh7DZ.getText().toString();
        String sTh8Dz = etTh8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        if (sTh1Dz.length() != 0) {
            reff.child("Th1Dz").setValue(sTh1Dz);
        } else {
            reff.child("Th1Dz").removeValue();
        }

        if (sTh2Dz.length() != 0) {
            reff.child("Th2Dz").setValue(sTh2Dz);
        } else {
            reff.child("Th2Dz").removeValue();
        }

        if (sTh3Dz.length() != 0) {
            reff.child("Th3Dz").setValue(sTh3Dz);
        } else {
            reff.child("Th3Dz").removeValue();
        }

        if (sTh4Dz.length() != 0) {
            reff.child("Th4Dz").setValue(sTh4Dz);
        } else {
            reff.child("Th4Dz").removeValue();
        }

        if (sTh5Dz.length() != 0) {
            reff.child("Th5Dz").setValue(sTh5Dz);
        } else {
            reff.child("Th5Dz").removeValue();
        }

        if (sTh6Dz.length() != 0) {
            reff.child("Th6Dz").setValue(sTh6Dz);
        } else {
            reff.child("Th6Dz").removeValue();
        }

        if (sTh7Dz.length() != 0) {
            reff.child("Th7Dz").setValue(sTh7Dz);
        } else {
            reff.child("Th7Dz").removeValue();
        }

        if (sTh8Dz.length() != 0) {
            reff.child("Th8Dz").setValue(sTh8Dz);
        } else {
            reff.child("Th8Dz").removeValue();
        }
    }


    private void loadText() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sTh1DZ = String.valueOf(snapshot.child("Th1Dz").getValue());
                String sTh2DZ = String.valueOf(snapshot.child("Th2Dz").getValue());
                String sTh3DZ = String.valueOf(snapshot.child("Th3Dz").getValue());
                String sTh4DZ = String.valueOf(snapshot.child("Th4Dz").getValue());
                String sTh5DZ = String.valueOf(snapshot.child("Th5Dz").getValue());
                String sTh6DZ = String.valueOf(snapshot.child("Th6Dz").getValue());
                String sTh7DZ = String.valueOf(snapshot.child("Th7Dz").getValue());
                String sTh8DZ = String.valueOf(snapshot.child("Th8Dz").getValue());

                if (snapshot.child("Th1Dz").exists()) {
                    etTh1DZ.setText(sTh1DZ);
                } else {
                    etTh1DZ.setText("");
                }

                if (snapshot.child("Th2Dz").exists()) {
                    etTh2DZ.setText(sTh2DZ);
                } else {
                    etTh2DZ.setText("");
                }

                if (snapshot.child("Th3Dz").exists()) {
                    etTh3DZ.setText(sTh3DZ);
                } else {
                    etTh3DZ.setText("");
                }

                if (snapshot.child("Th4Dz").exists()) {
                    etTh4DZ.setText(sTh4DZ);
                } else {
                    etTh4DZ.setText("");
                }

                if (snapshot.child("Th5Dz").exists()) {
                    etTh5DZ.setText(sTh5DZ);
                } else {
                    etTh5DZ.setText("");
                }

                if (snapshot.child("Th6Dz").exists()) {
                    etTh6DZ.setText(sTh6DZ);
                } else {
                    etTh6DZ.setText("");
                }

                if (snapshot.child("Th7Dz").exists()) {
                    etTh7DZ.setText(sTh7DZ);
                } else {
                    etTh7DZ.setText("");
                }

                if (snapshot.child("Th8Dz").exists()) {
                    etTh8DZ.setText(sTh8DZ);
                } else {
                    etTh8DZ.setText("");
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