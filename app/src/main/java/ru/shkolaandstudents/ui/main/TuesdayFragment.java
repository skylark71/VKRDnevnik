package ru.shkolaandstudents.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import java.util.Locale;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;

public class TuesdayFragment extends Fragment implements OnBackPressedListener {

    TextView tvT11, tvTimeT12, tvTimeT13, tvTimeT14, tvTimeT15, tvTimeT16, tvTimeT17, tvTimeT18, tvT19, tvT2, tvT22, tvTimeT21, tvTimeT22, tvTimeT23, tvTimeT24, tvTimeT25, tvTimeT26, tvTimeT27, tvT3, tvT33, tvTimeT31, tvTimeT32, tvTimeT33, tvTimeT34, tvTimeT35, tvTimeT36, tvTimeT37, tvT4, tvT44, tvTimeT41, tvTimeT42, tvTimeT43, tvTimeT44, tvTimeT45, tvTimeT46, tvTimeT47, tvT5, tvT55, tvTimeT51, tvTimeT52, tvTimeT53, tvTimeT54, tvTimeT55, tvTimeT56, tvTimeT57, tvT6, tvT66, tvTimeT61, tvTimeT62, tvTimeT63, tvTimeT64, tvTimeT65, tvTimeT66, tvTimeT67, tvT7, tvT77, tvTimeT71, tvTimeT72, tvTimeT73, tvTimeT74, tvTimeT75, tvTimeT76, tvTimeT77, tvT8, tvT88, tvTimeT81, tvTimeT82, tvTimeT83, tvTimeT84, tvTimeT85, tvTimeT86, tvTimeT87;
    EditText etT1DZ, etT2DZ, etT3DZ, etT4DZ, etT5DZ, etT6DZ, etT7DZ, etT8DZ;
    Button btnHelp;
    TextView tvOcenkaT1, tvOcenkaT2, tvOcenkaT3, tvOcenkaT4, tvOcenkaT5, tvOcenkaT6, tvOcenkaT7, tvOcenkaT8;
    String T1, T2, T3, T4, T5, T6, T7, T8;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_tuesday, container, false);

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
                                TapTarget.forView(v.findViewById(R.id.tvT19), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etT1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaT1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
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

        tvOcenkaT1 = v.findViewById(R.id.tvOcenkaT1);
        tvOcenkaT2 = v.findViewById(R.id.tvOcenkaT2);
        tvOcenkaT3 = v.findViewById(R.id.tvOcenkaT3);
        tvOcenkaT4 = v.findViewById(R.id.tvOcenkaT4);
        tvOcenkaT5 = v.findViewById(R.id.tvOcenkaT5);
        tvOcenkaT6 = v.findViewById(R.id.tvOcenkaT6);
        tvOcenkaT7 = v.findViewById(R.id.tvOcenkaT7);
        tvOcenkaT8 = v.findViewById(R.id.tvOcenkaT8);

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
        tvT19 = v.findViewById(R.id.tvT19);
        tvT22 = v.findViewById(R.id.tvT22);
        tvT33 = v.findViewById(R.id.tvT33);
        tvT44 = v.findViewById(R.id.tvT44);
        tvT55 = v.findViewById(R.id.tvT55);
        tvT66 = v.findViewById(R.id.tvT66);
        tvT77 = v.findViewById(R.id.tvT77);
        tvT88 = v.findViewById(R.id.tvT88);
        etT1DZ = v.findViewById(R.id.etT1DZ);
        etT2DZ = v.findViewById(R.id.etT2DZ);
        etT3DZ = v.findViewById(R.id.etT3DZ);
        etT4DZ = v.findViewById(R.id.etT4DZ);
        etT5DZ = v.findViewById(R.id.etT5DZ);
        etT6DZ = v.findViewById(R.id.etT6DZ);
        etT7DZ = v.findViewById(R.id.etT7DZ);
        etT8DZ = v.findViewById(R.id.etT8DZ);

        final String[] arr_sub1 = new String[8];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /**
                 * Get value subjects from database
                 */
                T1 = String.valueOf(snapshot.child("SubT1").getValue());
                T2 = String.valueOf(snapshot.child("SubT2").getValue());
                T3 = String.valueOf(snapshot.child("SubT3").getValue());
                T4 = String.valueOf(snapshot.child("SubT4").getValue());
                T5 = String.valueOf(snapshot.child("SubT5").getValue());
                T6 = String.valueOf(snapshot.child("SubT6").getValue());
                T7 = String.valueOf(snapshot.child("SubT7").getValue());
                T8 = String.valueOf(snapshot.child("SubT8").getValue());

                final String[] arr_sub = new String[8];
                final String[] arr_set = new String[8];
                arr_sub[0] = T1;
                arr_sub[1] = T2;
                arr_sub[2] = T3;
                arr_sub[3] = T4;
                arr_sub[4] = T5;
                arr_sub[5] = T6;
                arr_sub[6] = T7;
                arr_sub[7] = T8;
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
                                    final String view_ocenka = "tvOcenkaT" + (j + 1);
                                    arr_set[j] = view_ocenka;
                                    arr_sub1[j] = str_sub;
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

                                        int Day = 3;
                                        Calendar now = Calendar.getInstance();
                                        int weekday = now.get(Calendar.DAY_OF_WEEK);
                                        int days = (Calendar.SATURDAY - weekday + Day) % 7;
                                        now.add(Calendar.DAY_OF_YEAR, days);
                                        Date date = now.getTime();
                                        String data = new SimpleDateFormat("dd/MM/yyyy").format(date);
                                        String day_of_week = new SimpleDateFormat("EEE").format(date);

                                        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

                                        if(data.equals(currentDate))
                                        {
                                            String data_bd = String.valueOf(ds.child("Дата").getValue());
                                            String day_of_week_bd = String.valueOf(ds.child("День").getValue());

                                            if (day_of_week_bd.equals(day_of_week) && (data.equals(data_bd))) {
                                                String str_ocenka = String.valueOf(ds.child("Оценка").getValue());
                                                int resIDdate = getResources().getIdentifier(arr_set[count], "id", getActivity().getPackageName());
                                                arr[count] = ((TextView) v.findViewById(resIDdate));
                                                arr[count].setText(str_ocenka);
                                            }
                                        }
                                        else
                                        {
                                            int Day1 = 3;
                                            Calendar now1 = Calendar.getInstance();
                                            int weekday1 = now1.get(Calendar.DAY_OF_WEEK);
                                            int days1 = ((Calendar.SATURDAY - weekday1 + Day1) % 7) - 7;
                                            now1.add(Calendar.DAY_OF_YEAR, days1);
                                            Date date1 = now1.getTime();
                                            String data1 = new SimpleDateFormat("dd/MM/yyyy").format(date1);
                                            String day_of_week1 = new SimpleDateFormat("EEE").format(date1);

                                            String data_bd1 = String.valueOf(ds.child("Дата").getValue());
                                            String day_of_week_bd1 = String.valueOf(ds.child("День").getValue());

                                            if (day_of_week_bd1.equals(day_of_week1) && (data1.equals(data_bd1))) {
                                                String str_ocenka = String.valueOf(ds.child("Оценка").getValue());
                                                int resIDdate = getResources().getIdentifier(arr_set[count], "id", getActivity().getPackageName());
                                                arr[count] = ((TextView) v.findViewById(resIDdate));
                                                arr[count].setText(str_ocenka);
                                            }
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
                if (snapshot.child("SubT1").exists()) {
                    tvT19.setText(T1);
                } else {
                    tvT19.setText("");
                }

                if (snapshot.child("SubT2").exists()) {
                    tvT22.setText(T2);
                } else {
                    tvT22.setText("");
                }

                if (snapshot.child("SubT3").exists()) {
                    tvT33.setText(T3);
                } else {
                    tvT33.setText("");
                }

                if (snapshot.child("SubT4").exists()) {
                    tvT44.setText(T4);
                } else {
                    tvT44.setText("");
                }

                if (snapshot.child("SubT5").exists()) {
                    tvT55.setText(T5);
                } else {
                    tvT55.setText("");
                }

                if (snapshot.child("SubT6").exists()) {
                    tvT66.setText(T6);
                } else {
                    tvT66.setText("");
                }

                if (snapshot.child("SubT7").exists()) {
                    tvT77.setText(T7);
                } else {
                    tvT77.setText("");
                }

                if (snapshot.child("SubT8").exists()) {
                    tvT88.setText(T8);
                } else {
                    tvT88.setText("");
                }

                /**
                 * Get value time from db
                 */
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

                /**
                 * Set value time from db
                 */
                //////////////////
                tvTimeT12.setText(sT11);
                tvTimeT14.setText(sT12);
                tvTimeT16.setText(sT13);
                tvTimeT18.setText(sT14);
                //////////////////
                tvTimeT21.setText(sT21);
                tvTimeT23.setText(sT22);
                tvTimeT25.setText(sT23);
                tvTimeT27.setText(sT24);
                /////////////////////
                tvTimeT31.setText(sT31);
                tvTimeT33.setText(sT32);
                tvTimeT35.setText(sT33);
                tvTimeT37.setText(sT34);
                ////////////////////////
                tvTimeT41.setText(sT41);
                tvTimeT43.setText(sT42);
                tvTimeT45.setText(sT43);
                tvTimeT47.setText(sT44);
                //////////////////////
                tvTimeT51.setText(sT51);
                tvTimeT53.setText(sT52);
                tvTimeT55.setText(sT53);
                tvTimeT57.setText(sT54);
                //////////////////////
                tvTimeT61.setText(sT61);
                tvTimeT63.setText(sT62);
                tvTimeT65.setText(sT63);
                tvTimeT67.setText(sT64);
                //////////////////////
                tvTimeT71.setText(sT71);
                tvTimeT73.setText(sT72);
                tvTimeT75.setText(sT73);
                tvTimeT77.setText(sT74);
                ///////////////////////
                tvTimeT81.setText(sT81);
                tvTimeT83.setText(sT82);
                tvTimeT85.setText(sT83);
                tvTimeT87.setText(sT84);

                /**
                 * Check value time for ui
                 */
                if (sT11.equals("null")) {
                    tvTimeT12.setVisibility(View.GONE);
                    tvTimeT13.setVisibility(View.GONE);
                    tvTimeT14.setVisibility(View.GONE);
                    tvTimeT15.setVisibility(View.GONE);
                    tvTimeT16.setVisibility(View.GONE);
                    tvTimeT17.setVisibility(View.GONE);
                    tvTimeT18.setVisibility(View.GONE);
                } else {
                    tvTimeT13.setVisibility(View.VISIBLE);
                    tvTimeT15.setVisibility(View.VISIBLE);
                    tvTimeT17.setVisibility(View.VISIBLE);
                }

                if (sT21.equals("null")) {
                    tvTimeT21.setVisibility(View.GONE);
                    tvTimeT22.setVisibility(View.GONE);
                    tvTimeT23.setVisibility(View.GONE);
                    tvTimeT24.setVisibility(View.GONE);
                    tvTimeT25.setVisibility(View.GONE);
                    tvTimeT26.setVisibility(View.GONE);
                    tvTimeT27.setVisibility(View.GONE);
                } else {
                    tvTimeT22.setVisibility(View.VISIBLE);
                    tvTimeT24.setVisibility(View.VISIBLE);
                    tvTimeT26.setVisibility(View.VISIBLE);
                }

                if (sT31.equals("null")) {
                    tvTimeT31.setVisibility(View.GONE);
                    tvTimeT32.setVisibility(View.GONE);
                    tvTimeT33.setVisibility(View.GONE);
                    tvTimeT34.setVisibility(View.GONE);
                    tvTimeT35.setVisibility(View.GONE);
                    tvTimeT36.setVisibility(View.GONE);
                    tvTimeT37.setVisibility(View.GONE);
                } else {
                    tvTimeT32.setVisibility(View.VISIBLE);
                    tvTimeT34.setVisibility(View.VISIBLE);
                    tvTimeT36.setVisibility(View.VISIBLE);
                }

                if (sT41.equals("null")) {
                    tvTimeT41.setVisibility(View.GONE);
                    tvTimeT42.setVisibility(View.GONE);
                    tvTimeT43.setVisibility(View.GONE);
                    tvTimeT44.setVisibility(View.GONE);
                    tvTimeT45.setVisibility(View.GONE);
                    tvTimeT46.setVisibility(View.GONE);
                    tvTimeT47.setVisibility(View.GONE);
                } else {
                    tvTimeT42.setVisibility(View.VISIBLE);
                    tvTimeT44.setVisibility(View.VISIBLE);
                    tvTimeT46.setVisibility(View.VISIBLE);
                }

                if (sT51.equals("null")) {
                    tvTimeT51.setVisibility(View.GONE);
                    tvTimeT52.setVisibility(View.GONE);
                    tvTimeT53.setVisibility(View.GONE);
                    tvTimeT54.setVisibility(View.GONE);
                    tvTimeT55.setVisibility(View.GONE);
                    tvTimeT56.setVisibility(View.GONE);
                    tvTimeT57.setVisibility(View.GONE);
                } else {
                    tvTimeT52.setVisibility(View.VISIBLE);
                    tvTimeT54.setVisibility(View.VISIBLE);
                    tvTimeT56.setVisibility(View.VISIBLE);
                }

                if (sT61.equals("null")) {
                    tvTimeT61.setVisibility(View.GONE);
                    tvTimeT62.setVisibility(View.GONE);
                    tvTimeT63.setVisibility(View.GONE);
                    tvTimeT64.setVisibility(View.GONE);
                    tvTimeT65.setVisibility(View.GONE);
                    tvTimeT66.setVisibility(View.GONE);
                    tvTimeT67.setVisibility(View.GONE);
                } else {
                    tvTimeT62.setVisibility(View.VISIBLE);
                    tvTimeT64.setVisibility(View.VISIBLE);
                    tvTimeT66.setVisibility(View.VISIBLE);
                }

                if (sT71.equals("null")) {
                    tvTimeT71.setVisibility(View.GONE);
                    tvTimeT72.setVisibility(View.GONE);
                    tvTimeT73.setVisibility(View.GONE);
                    tvTimeT74.setVisibility(View.GONE);
                    tvTimeT75.setVisibility(View.GONE);
                    tvTimeT76.setVisibility(View.GONE);
                    tvTimeT77.setVisibility(View.GONE);
                } else {
                    tvTimeT72.setVisibility(View.VISIBLE);
                    tvTimeT74.setVisibility(View.VISIBLE);
                    tvTimeT76.setVisibility(View.VISIBLE);
                }

                if (sT81.equals("null")) {
                    tvTimeT81.setVisibility(View.GONE);
                    tvTimeT82.setVisibility(View.GONE);
                    tvTimeT83.setVisibility(View.GONE);
                    tvTimeT84.setVisibility(View.GONE);
                    tvTimeT85.setVisibility(View.GONE);
                    tvTimeT86.setVisibility(View.GONE);
                    tvTimeT87.setVisibility(View.GONE);
                } else {
                    tvTimeT82.setVisibility(View.VISIBLE);
                    tvTimeT84.setVisibility(View.VISIBLE);
                    tvTimeT86.setVisibility(View.VISIBLE);
                }

                /**
                 * Отступ снизу для видимости TextView
                 * */
                if (!T1.equals("null") && T1.length() > 7) {
                    tvT19.setPadding(0, 0, 0, 8);
                }

                if (!T2.equals("null") && T2.length() > 7) {
                    tvT22.setPadding(0, 0, 0, 8);
                }

                if (!T3.equals("null") && T3.length() > 7) {
                    tvT33.setPadding(0, 0, 0, 8);
                }

                if (!T4.equals("null") && T4.length() > 7) {
                    tvT44.setPadding(0, 0, 0, 8);
                }

                if (!T5.equals("null") && T5.length() > 7) {
                    tvT55.setPadding(0, 0, 0, 8);
                }

                if (!T6.equals("null") && T6.length() > 7) {
                    tvT66.setPadding(0, 0, 0, 8);
                }

                if (!T7.equals("null") && T7.length() > 7) {
                    tvT77.setPadding(0, 0, 0, 8);
                }

                if (!T8.equals("null") && T8.length() > 7) {
                    tvT88.setPadding(0, 0, 0, 8);
                }

                /**
                 * Check value subject from ui
                 */
                LinearLayout ll_row1 = v.findViewById(R.id.studentT_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.studentT_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.studentT_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.studentT_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.studentT_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.studentT_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.studentT_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.studentT_row8);

                //1 СТРОКА
                if (T1.equals("null")) {
                    ll_row1.setVisibility(View.GONE);
                } else {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (T2.equals("null")) {
                    ll_row2.setVisibility(View.GONE);
                } else {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (T3.equals("null")) {
                    ll_row3.setVisibility(View.GONE);
                } else {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (T4.equals("null")) {
                    ll_row4.setVisibility(View.GONE);
                } else {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (T5.equals("null")) {
                    ll_row5.setVisibility(View.GONE);
                } else {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (T6.equals("null")) {
                    ll_row6.setVisibility(View.GONE);
                } else {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (T7.equals("null")) {
                    ll_row7.setVisibility(View.GONE);
                } else {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (T8.equals("null")) {
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
        String sT1Dz = etT1DZ.getText().toString();
        String sT2Dz = etT2DZ.getText().toString();
        String sT3Dz = etT3DZ.getText().toString();
        String sT4Dz = etT4DZ.getText().toString();
        String sT5Dz = etT5DZ.getText().toString();
        String sT6Dz = etT6DZ.getText().toString();
        String sT7Dz = etT7DZ.getText().toString();
        String sT8Dz = etT8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        if (sT1Dz.length() != 0) {
            reff.child("T1Dz").setValue(sT1Dz);
        } else {
            reff.child("T1Dz").removeValue();
        }

        if (sT2Dz.length() != 0) {
            reff.child("T2Dz").setValue(sT2Dz);
        } else {
            reff.child("T2Dz").removeValue();
        }

        if (sT3Dz.length() != 0) {
            reff.child("T3Dz").setValue(sT3Dz);
        } else {
            reff.child("T3Dz").removeValue();
        }

        if (sT4Dz.length() != 0) {
            reff.child("T4Dz").setValue(sT4Dz);
        } else {
            reff.child("T4Dz").removeValue();
        }

        if (sT5Dz.length() != 0) {
            reff.child("T5Dz").setValue(sT5Dz);
        } else {
            reff.child("T5Dz").removeValue();
        }

        if (sT6Dz.length() != 0) {
            reff.child("T6Dz").setValue(sT6Dz);
        } else {
            reff.child("T6Dz").removeValue();
        }

        if (sT7Dz.length() != 0) {
            reff.child("T7Dz").setValue(sT7Dz);
        } else {
            reff.child("T7Dz").removeValue();
        }

        if (sT8Dz.length() != 0) {
            reff.child("T8Dz").setValue(sT8Dz);
        } else {
            reff.child("T8Dz").removeValue();
        }
    }

    private void loadText() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sT1DZ = String.valueOf(snapshot.child("T1Dz").getValue());
                String sT2DZ = String.valueOf(snapshot.child("T2Dz").getValue());
                String sT3DZ = String.valueOf(snapshot.child("T3Dz").getValue());
                String sT4DZ = String.valueOf(snapshot.child("T4Dz").getValue());
                String sT5DZ = String.valueOf(snapshot.child("T5Dz").getValue());
                String sT6DZ = String.valueOf(snapshot.child("T6Dz").getValue());
                String sT7DZ = String.valueOf(snapshot.child("T7Dz").getValue());
                String sT8DZ = String.valueOf(snapshot.child("T8Dz").getValue());

                if (snapshot.child("T1Dz").exists()) {
                    etT1DZ.setText(sT1DZ);
                } else {
                    etT1DZ.setText("");
                }

                if (snapshot.child("T2Dz").exists()) {
                    etT2DZ.setText(sT2DZ);
                } else {
                    etT2DZ.setText("");
                }

                if (snapshot.child("T3Dz").exists()) {
                    etT3DZ.setText(sT3DZ);
                } else {
                    etT3DZ.setText("");
                }

                if (snapshot.child("T4Dz").exists()) {
                    etT4DZ.setText(sT4DZ);
                } else {
                    etT4DZ.setText("");
                }

                if (snapshot.child("T5Dz").exists()) {
                    etT5DZ.setText(sT5DZ);
                } else {
                    etT5DZ.setText("");
                }

                if (snapshot.child("T6Dz").exists()) {
                    etT6DZ.setText(sT6DZ);
                } else {
                    etT6DZ.setText("");
                }

                if (snapshot.child("T7Dz").exists()) {
                    etT7DZ.setText(sT7DZ);
                } else {
                    etT7DZ.setText("");
                }

                if (snapshot.child("T8Dz").exists()) {
                    etT8DZ.setText(sT8DZ);
                } else {
                    etT8DZ.setText("");
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