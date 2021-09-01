package ru.shkolaandstudents.ui.Students;

import android.content.res.Configuration;
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


public class FragmentRaspMonday extends Fragment implements OnBackPressedListener {

    TextView tvM11, tvM22, tvM33, tvM44, tvM55, tvM66, tvM77, tvM88, tvM1, tvM2, tvM3, tvM4, tvM5, tvM6, tvM7, tvM8, tvTimeM1, tvTimeM2, tvTimeM3, tvTimeM4, tvTimeM5, tvTimeM6, tvTimeM7, tvTimeM8, tvTimeM9, tvTimeM10, tvTimeM111, tvTimeM12, tvTimeM13, tvTimeM14, tvTimeM15, tvTimeM16, tvTimeM17, tvTimeM18, tvTimeM19, tvTimeM20, tvTimeM21, tvTimeM222, tvTimeM23, tvTimeM24, tvTimeM25, tvTimeM26, tvTimeM27, tvTimeM28, tvTimeM29, tvTimeM30, tvTimeM31, tvTimeM32;
    EditText etM1DZ, etM2DZ, etM3DZ, etM4DZ, etM5DZ, etM6DZ, etM7DZ, etM8DZ;
    TextView tvTimeM11, tvTimeM22, tvTimeM33, tvTimeM51, tvTimeM61, tvTimeM71, tvTimeM91, tvTimeM101, tvTimeM112, tvTimeM131, tvTimeM141, tvTimeM151, tvTimeM171, tvTimeM181, tvTimeM191, tvTimeM211, tvTimeM221, tvTimeM231, tvTimeM251, tvTimeM261, tvTimeM271, tvTimeM291, tvTimeM301, tvTimeM311;
    TextView tvOcenkaM1, tvOcenkaM2, tvOcenkaM3, tvOcenkaM4, tvOcenkaM5, tvOcenkaM6, tvOcenkaM7, tvOcenkaM8;
    Button btnHelp;
    String M1, M2, M3, M4, M5, M6, M7, M8;
    DatabaseReference reff;

    String user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_monday, container, false);

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
                                TapTarget.forView(v.findViewById(R.id.tvM11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etM1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaM1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
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

        tvOcenkaM1 = v.findViewById(R.id.tvOcenkaM1);
        tvOcenkaM2 = v.findViewById(R.id.tvOcenkaM2);
        tvOcenkaM3 = v.findViewById(R.id.tvOcenkaM3);
        tvOcenkaM4 = v.findViewById(R.id.tvOcenkaM4);
        tvOcenkaM5 = v.findViewById(R.id.tvOcenkaM5);
        tvOcenkaM6 = v.findViewById(R.id.tvOcenkaM6);
        tvOcenkaM7 = v.findViewById(R.id.tvOcenkaM7);
        tvOcenkaM8 = v.findViewById(R.id.tvOcenkaM8);

        tvM11 = v.findViewById(R.id.tvM11);
        etM2DZ = v.findViewById(R.id.etM2DZ);
        tvM22 = v.findViewById(R.id.tvM22);
        etM1DZ = v.findViewById(R.id.etM1DZ);
        tvM33 = v.findViewById(R.id.tvM33);
        etM3DZ = v.findViewById(R.id.etM3DZ);
        tvM44 = v.findViewById(R.id.tvM44);
        etM6DZ = v.findViewById(R.id.etM6DZ);
        tvM55 = v.findViewById(R.id.tvM55);
        etM4DZ = v.findViewById(R.id.etM4DZ);
        tvM66 = v.findViewById(R.id.tvM66);
        etM7DZ = v.findViewById(R.id.etM7DZ);
        tvM77 = v.findViewById(R.id.tvM77);
        etM5DZ = v.findViewById(R.id.etM5DZ);
        tvM88 = v.findViewById(R.id.tvM88);
        etM8DZ = v.findViewById(R.id.etM8DZ);

        tvM1 = v.findViewById(R.id.tvM1);
        tvM2 = v.findViewById(R.id.tvM2);
        tvM3 = v.findViewById(R.id.tvM3);
        tvM4 = v.findViewById(R.id.tvM4);
        tvM5 = v.findViewById(R.id.tvM5);
        tvM6 = v.findViewById(R.id.tvM6);
        tvM7 = v.findViewById(R.id.tvM7);
        tvM8 = v.findViewById(R.id.tvM8);

        tvTimeM1 = v.findViewById(R.id.tvTimeM1);
        tvTimeM9 = v.findViewById(R.id.tvTimeM9);
        tvTimeM17 = v.findViewById(R.id.tvTimeM17);
        tvTimeM25 = v.findViewById(R.id.tvTimeM25);
        tvTimeM2 = v.findViewById(R.id.tvTimeM2);
        tvTimeM10 = v.findViewById(R.id.tvTimeM10);
        tvTimeM18 = v.findViewById(R.id.tvTimeM18);
        tvTimeM26 = v.findViewById(R.id.tvTimeM26);
        tvTimeM3 = v.findViewById(R.id.tvTimeM3);
        tvTimeM111 = v.findViewById(R.id.tvTimeM111);
        tvTimeM19 = v.findViewById(R.id.tvTimeM19);
        tvTimeM27 = v.findViewById(R.id.tvTimeM27);
        tvTimeM4 = v.findViewById(R.id.tvTimeM4);
        tvTimeM12 = v.findViewById(R.id.tvTimeM12);
        tvTimeM20 = v.findViewById(R.id.tvTimeM20);
        tvTimeM28 = v.findViewById(R.id.tvTimeM28);
        tvTimeM5 = v.findViewById(R.id.tvTimeM5);
        tvTimeM13 = v.findViewById(R.id.tvTimeM13);
        tvTimeM21 = v.findViewById(R.id.tvTimeM21);
        tvTimeM29 = v.findViewById(R.id.tvTimeM29);
        tvTimeM6 = v.findViewById(R.id.tvTimeM6);
        tvTimeM14 = v.findViewById(R.id.tvTimeM14);
        tvTimeM222 = v.findViewById(R.id.tvTimeM222);
        tvTimeM30 = v.findViewById(R.id.tvTimeM30);
        tvTimeM7 = v.findViewById(R.id.tvTimeM7);
        tvTimeM15 = v.findViewById(R.id.tvTimeM15);
        tvTimeM23 = v.findViewById(R.id.tvTimeM23);
        tvTimeM31 = v.findViewById(R.id.tvTimeM31);
        tvTimeM8 = v.findViewById(R.id.tvTimeM8);
        tvTimeM16 = v.findViewById(R.id.tvTimeM16);
        tvTimeM24 = v.findViewById(R.id.tvTimeM24);
        tvTimeM32 = v.findViewById(R.id.tvTimeM32);

        tvTimeM11 = v.findViewById(R.id.tvTimeM11);
        tvTimeM61 = v.findViewById(R.id.tvTimeM61);
        tvTimeM112 = v.findViewById(R.id.tvTimeM112);
        tvTimeM171 = v.findViewById(R.id.tvTimeM171);
        tvTimeM22 = v.findViewById(R.id.tvTimeM22);
        tvTimeM71 = v.findViewById(R.id.tvTimeM71);
        tvTimeM131 = v.findViewById(R.id.tvTimeM131);
        tvTimeM181 = v.findViewById(R.id.tvTimeM181);
        tvTimeM33 = v.findViewById(R.id.tvTimeM33);
        tvTimeM91 = v.findViewById(R.id.tvTimeM91);
        tvTimeM141 = v.findViewById(R.id.tvTimeM141);
        tvTimeM191 = v.findViewById(R.id.tvTimeM191);
        tvTimeM51 = v.findViewById(R.id.tvTimeM51);
        tvTimeM101 = v.findViewById(R.id.tvTimeM101);
        tvTimeM151 = v.findViewById(R.id.tvTimeM151);
        tvTimeM211 = v.findViewById(R.id.tvTimeM211);

        tvTimeM211 = v.findViewById(R.id.tvTimeM211);
        tvTimeM251 = v.findViewById(R.id.tvTimeM251);
        tvTimeM291 = v.findViewById(R.id.tvTimeM291);
        tvTimeM221 = v.findViewById(R.id.tvTimeM221);
        tvTimeM261 = v.findViewById(R.id.tvTimeM261);
        tvTimeM301 = v.findViewById(R.id.tvTimeM301);
        tvTimeM231 = v.findViewById(R.id.tvTimeM231);
        tvTimeM271 = v.findViewById(R.id.tvTimeM271);
        tvTimeM311 = v.findViewById(R.id.tvTimeM311);
        etM1DZ = v.findViewById(R.id.etM1DZ);
        etM2DZ = v.findViewById(R.id.etM2DZ);
        etM3DZ = v.findViewById(R.id.etM3DZ);
        etM4DZ = v.findViewById(R.id.etM4DZ);
        etM5DZ = v.findViewById(R.id.etM5DZ);
        etM6DZ = v.findViewById(R.id.etM6DZ);
        etM7DZ = v.findViewById(R.id.etM7DZ);
        etM8DZ = v.findViewById(R.id.etM8DZ);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /**
                 * Get value subjects from database
                 */
                M1 = String.valueOf(snapshot.child("SubM1").getValue());
                M2 = String.valueOf(snapshot.child("SubM2").getValue());
                M3 = String.valueOf(snapshot.child("SubM3").getValue());
                M4 = String.valueOf(snapshot.child("SubM4").getValue());
                M5 = String.valueOf(snapshot.child("SubM5").getValue());
                M6 = String.valueOf(snapshot.child("SubM6").getValue());
                M7 = String.valueOf(snapshot.child("SubM7").getValue());
                M8 = String.valueOf(snapshot.child("SubM8").getValue());

                final String[] arr_sub = new String[8];
                final String[] arr_set = new String[8];
                arr_sub[0] = M1;
                arr_sub[1] = M2;
                arr_sub[2] = M3;
                arr_sub[3] = M4;
                arr_sub[4] = M5;
                arr_sub[5] = M6;
                arr_sub[6] = M7;
                arr_sub[7] = M8;
                final TextView[] arr = new TextView[8];

                /**
                 * СОЗДАНИЕ МАССИВОВ VALUE
                 * */
                DatabaseReference reff1 = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Оценки");
                reff1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        final String[] arr_sub1 = new String[8];
                        int i = 0;
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            final String str_sub = ds.getKey();
                            for (int j = 0; j < 8; j++) {
                                if (str_sub.equals(arr_sub[j])) {
                                    final String view_ocenka = "tvOcenkaM" + (j + 1);
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

                                        int Mn = 2;
                                        Calendar now = Calendar.getInstance();
                                        int weekday = now.get(Calendar.DAY_OF_WEEK);
                                        int days = (Calendar.SATURDAY - weekday + Mn) % 7;
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
                                            int Mn1 = 2;
                                            Calendar now1 = Calendar.getInstance();
                                            int weekday1 = now1.get(Calendar.DAY_OF_WEEK);
                                            int days1 = ((Calendar.SATURDAY - weekday1 + Mn1) % 7) - 7;
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
                if (snapshot.child("SubM1").exists()) {
                    tvM11.setText(M1);
                } else {
                    tvM11.setText("");
                }

                if (snapshot.child("SubM2").exists()) {
                    tvM22.setText(M2);
                } else {
                    tvM22.setText("");
                }

                if (snapshot.child("SubM3").exists()) {
                    tvM33.setText(M3);
                } else {
                    tvM33.setText("");
                }

                if (snapshot.child("SubM4").exists()) {
                    tvM44.setText(M4);
                } else {
                    tvM44.setText("");
                }

                if (snapshot.child("SubM5").exists()) {
                    tvM55.setText(M5);
                } else {
                    tvM55.setText("");
                }

                if (snapshot.child("SubM6").exists()) {
                    tvM66.setText(M6);
                } else {
                    tvM66.setText("");
                }

                if (snapshot.child("SubM7").exists()) {
                    tvM77.setText(M7);
                } else {
                    tvM77.setText("");
                }

                if (snapshot.child("SubM8").exists()) {
                    tvM88.setText(M8);
                } else {
                    tvM88.setText("");
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
                tvTimeM1.setText(sT11);
                tvTimeM2.setText(sT12);
                tvTimeM3.setText(sT13);
                tvTimeM4.setText(sT14);
                //////////////////
                tvTimeM5.setText(sT21);
                tvTimeM6.setText(sT22);
                tvTimeM7.setText(sT23);
                tvTimeM8.setText(sT24);
                /////////////////////
                tvTimeM9.setText(sT31);
                tvTimeM10.setText(sT32);
                tvTimeM111.setText(sT33);
                tvTimeM12.setText(sT34);
                ////////////////////////
                tvTimeM13.setText(sT41);
                tvTimeM14.setText(sT42);
                tvTimeM15.setText(sT43);
                tvTimeM16.setText(sT44);
                //////////////////////
                tvTimeM17.setText(sT51);
                tvTimeM18.setText(sT52);
                tvTimeM19.setText(sT53);
                tvTimeM20.setText(sT54);
                //////////////////////
                tvTimeM21.setText(sT61);
                tvTimeM222.setText(sT62);
                tvTimeM23.setText(sT63);
                tvTimeM24.setText(sT64);
                //////////////////////
                tvTimeM25.setText(sT71);
                tvTimeM26.setText(sT72);
                tvTimeM27.setText(sT73);
                tvTimeM28.setText(sT74);
                ///////////////////////
                tvTimeM29.setText(sT81);
                tvTimeM30.setText(sT82);
                tvTimeM31.setText(sT83);
                tvTimeM32.setText(sT84);
                ///////////////////////

                /**
                 * Check value time for ui
                 */
                if (sT11.equals("null")) {
                    tvTimeM11.setVisibility(View.GONE);
                    tvTimeM22.setVisibility(View.GONE);
                    tvTimeM33.setVisibility(View.GONE);
                    tvTimeM1.setVisibility(View.GONE);
                    tvTimeM2.setVisibility(View.GONE);
                    tvTimeM3.setVisibility(View.GONE);
                    tvTimeM4.setVisibility(View.GONE);
                } else {
                    tvTimeM11.setVisibility(View.VISIBLE);
                    tvTimeM22.setVisibility(View.VISIBLE);
                    tvTimeM33.setVisibility(View.VISIBLE);
                }

                if (sT21.equals("null")) {
                    tvTimeM51.setVisibility(View.GONE);
                    tvTimeM61.setVisibility(View.GONE);
                    tvTimeM71.setVisibility(View.GONE);
                    tvTimeM5.setVisibility(View.GONE);
                    tvTimeM6.setVisibility(View.GONE);
                    tvTimeM7.setVisibility(View.GONE);
                    tvTimeM8.setVisibility(View.GONE);
                } else {
                    tvTimeM51.setVisibility(View.VISIBLE);
                    tvTimeM61.setVisibility(View.VISIBLE);
                    tvTimeM71.setVisibility(View.VISIBLE);
                }

                if (sT31.equals("null")) {
                    tvTimeM91.setVisibility(View.GONE);
                    tvTimeM101.setVisibility(View.GONE);
                    tvTimeM112.setVisibility(View.GONE);
                    tvTimeM9.setVisibility(View.GONE);
                    tvTimeM10.setVisibility(View.GONE);
                    tvTimeM111.setVisibility(View.GONE);
                    tvTimeM12.setVisibility(View.GONE);
                } else {
                    tvTimeM91.setVisibility(View.VISIBLE);
                    tvTimeM101.setVisibility(View.VISIBLE);
                    tvTimeM112.setVisibility(View.VISIBLE);
                }

                if (sT41.equals("null")) {
                    tvTimeM131.setVisibility(View.GONE);
                    tvTimeM141.setVisibility(View.GONE);
                    tvTimeM151.setVisibility(View.GONE);
                    tvTimeM13.setVisibility(View.GONE);
                    tvTimeM14.setVisibility(View.GONE);
                    tvTimeM15.setVisibility(View.GONE);
                    tvTimeM16.setVisibility(View.GONE);
                } else {
                    tvTimeM131.setVisibility(View.VISIBLE);
                    tvTimeM141.setVisibility(View.VISIBLE);
                    tvTimeM151.setVisibility(View.VISIBLE);
                }

                if (sT51.equals("null")) {
                    tvTimeM171.setVisibility(View.GONE);
                    tvTimeM181.setVisibility(View.GONE);
                    tvTimeM191.setVisibility(View.GONE);
                    tvTimeM17.setVisibility(View.GONE);
                    tvTimeM18.setVisibility(View.GONE);
                    tvTimeM19.setVisibility(View.GONE);
                    tvTimeM20.setVisibility(View.GONE);
                } else {
                    tvTimeM171.setVisibility(View.VISIBLE);
                    tvTimeM181.setVisibility(View.VISIBLE);
                    tvTimeM191.setVisibility(View.VISIBLE);
                }

                if (sT61.equals("null")) {
                    tvTimeM211.setVisibility(View.GONE);
                    tvTimeM231.setVisibility(View.GONE);
                    tvTimeM221.setVisibility(View.GONE);
                    tvTimeM21.setVisibility(View.GONE);
                    tvTimeM222.setVisibility(View.GONE);
                    tvTimeM23.setVisibility(View.GONE);
                    tvTimeM24.setVisibility(View.GONE);
                } else {
                    tvTimeM211.setVisibility(View.VISIBLE);
                    tvTimeM231.setVisibility(View.VISIBLE);
                    tvTimeM221.setVisibility(View.VISIBLE);
                }

                if (sT71.equals("null")) {
                    tvTimeM251.setVisibility(View.GONE);
                    tvTimeM261.setVisibility(View.GONE);
                    tvTimeM271.setVisibility(View.GONE);
                    tvTimeM25.setVisibility(View.GONE);
                    tvTimeM26.setVisibility(View.GONE);
                    tvTimeM27.setVisibility(View.GONE);
                    tvTimeM28.setVisibility(View.GONE);
                } else {
                    tvTimeM251.setVisibility(View.VISIBLE);
                    tvTimeM261.setVisibility(View.VISIBLE);
                    tvTimeM271.setVisibility(View.VISIBLE);
                }

                if (sT81.equals("null")) {
                    tvTimeM291.setVisibility(View.GONE);
                    tvTimeM301.setVisibility(View.GONE);
                    tvTimeM311.setVisibility(View.GONE);
                    tvTimeM29.setVisibility(View.GONE);
                    tvTimeM30.setVisibility(View.GONE);
                    tvTimeM31.setVisibility(View.GONE);
                    tvTimeM32.setVisibility(View.GONE);
                } else {
                    tvTimeM291.setVisibility(View.VISIBLE);
                    tvTimeM301.setVisibility(View.VISIBLE);
                    tvTimeM311.setVisibility(View.VISIBLE);
                }

                /**
                 * Отступ снизу для видимости TextView
                 * */
                if (!M1.equals("null") && M1.length() > 11) {
                    tvM11.setPadding(0, 0, 0, 8);
                }
                /*else if(!M1.equals("null") && M1.length() > 22)
                {
                    tvM11.setPadding(0, 0, 0, 16);
                }
                else if(!M1.equals("null") && M1.length() > 33)
                {
                    tvM11.setPadding(0, 0, 0, 24);
                }
                else if(!M1.equals("null") && M1.length() > 44)
                {
                    tvM11.setPadding(0, 0, 0, 32);
                }*/

                if (!M2.equals("null") && M2.length() > 11) {
                    tvM22.setPadding(0, 0, 0, 8);
                }
                /*else if(!M2.equals("null") && M2.length() > 22)
                {
                    tvM22.setPadding(0, 0, 0, 16);
                }
                else if(!M2.equals("null") && M2.length() > 33)
                {
                    tvM22.setPadding(0, 0, 0, 24);
                }
                else if(!M2.equals("null") && M2.length() > 44)
                {
                    tvM22.setPadding(0, 0, 0, 32);
                }*/

                if (!M3.equals("null") && M3.length() > 11) {
                    tvM33.setPadding(0, 0, 0, 8);
                }
                /*else if(!M3.equals("null") && M3.length() > 22)
                {
                    tvM33.setPadding(0, 0, 0, 16);
                }
                else if(!M3.equals("null") && M3.length() > 33)
                {
                    tvM33.setPadding(0, 0, 0, 24);
                }
                else if(!M3.equals("null") && M3.length() > 44)
                {
                    tvM33.setPadding(0, 0, 0, 32);
                }*/

                if (!M4.equals("null") && M4.length() > 11) {
                    tvM44.setPadding(0, 0, 0, 8);
                }
                /*else if(!M4.equals("null") && M4.length() > 22)
                {
                    tvM44.setPadding(0, 0, 0, 16);
                }
                else if(!M4.equals("null") && M4.length() > 33)
                {
                    tvM44.setPadding(0, 0, 0, 24);
                }
                else if(!M4.equals("null") && M4.length() > 44)
                {
                    tvM44.setPadding(0, 0, 0, 32);
                }*/

                if (!M5.equals("null") && M5.length() > 11) {
                    tvM55.setPadding(0, 0, 0, 8);
                }
                /*else if(!M5.equals("null") && M5.length() > 22)
                {
                    tvM55.setPadding(0, 0, 0, 16);
                }
                else if(!M5.equals("null") && M5.length() > 33)
                {
                    tvM55.setPadding(0, 0, 0, 24);
                }
                else if(!M5.equals("null") && M5.length() > 44)
                {
                    tvM55.setPadding(0, 0, 0, 32);
                }*/

                if (!M6.equals("null") && M6.length() > 11) {
                    tvM66.setPadding(0, 0, 0, 8);
                }
                /*else if(!M6.equals("null") && M6.length() > 22)
                {
                    tvM66.setPadding(0, 0, 0, 16);
                }
                else if(!M6.equals("null") && M6.length() > 33)
                {
                    tvM66.setPadding(0, 0, 0, 24);
                }
                else if(!M6.equals("null") && M6.length() > 44)
                {
                    tvM66.setPadding(0, 0, 0, 32);
                }*/

                if (!M7.equals("null") && M7.length() > 11) {
                    tvM77.setPadding(0, 0, 0, 8);
                }
                /*else if(!M7.equals("null") && M7.length() > 22)
                {
                    tvM77.setPadding(0, 0, 0, 16);
                }
                else if(!M7.equals("null") && M7.length() > 33)
                {
                    tvM77.setPadding(0, 0, 0, 24);
                }
                else if(!M7.equals("null") && M7.length() > 44)
                {
                    tvM77.setPadding(0, 0, 0, 32);
                }*/

                if (!M8.equals("null") && M8.length() > 11) {
                    tvM88.setPadding(0, 0, 0, 8);
                }
                /*else if(!M8.equals("null") && M8.length() > 22)
                {
                    tvM88.setPadding(0, 0, 0, 16);
                }
                else if(!M8.equals("null") && M8.length() > 33)
                {
                    tvM88.setPadding(0, 0, 0, 24);
                }
                else if(!M8.equals("null") && M8.length() > 44)
                {
                    tvM88.setPadding(0, 0, 0, 32);
                }*/

                /**
                 * Check value subject from ui
                 */
                LinearLayout ll_row1 = v.findViewById(R.id.studentM_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.studentM_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.studentM_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.studentM_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.studentM_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.studentM_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.studentM_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.studentM_row8);

                //1 СТРОКА
                if (M1.equals("null")) {
                    ll_row1.setVisibility(View.GONE);
                } else {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (M2.equals("null")) {
                    ll_row2.setVisibility(View.GONE);
                } else {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (M3.equals("null")) {
                    ll_row3.setVisibility(View.GONE);
                } else {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (M4.equals("null")) {
                    ll_row4.setVisibility(View.GONE);
                } else {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (M5.equals("null")) {
                    ll_row5.setVisibility(View.GONE);
                } else {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (M6.equals("null")) {
                    ll_row6.setVisibility(View.GONE);
                } else {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (M7.equals("null")) {
                    ll_row7.setVisibility(View.GONE);
                } else {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (M8.equals("null")) {
                    ll_row8.setVisibility(View.GONE);
                } else {
                    ll_row8.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            etM1DZ.setMaxWidth(500);
        } else {
            etM1DZ.setWidth(120);
        }

        loadText();

        return v;
    }

    private void saveText() {

        String sM1Dz = etM1DZ.getText().toString();
        String sM2Dz = etM2DZ.getText().toString();
        String sM3Dz = etM3DZ.getText().toString();
        String sM4Dz = etM4DZ.getText().toString();
        String sM5Dz = etM5DZ.getText().toString();
        String sM6Dz = etM6DZ.getText().toString();
        String sM7Dz = etM7DZ.getText().toString();
        String sM8Dz = etM8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(user).child("Schedule");
        if (sM1Dz.length() != 0) {
            reff.child("M1Dz").setValue(sM1Dz);
        } else {
            reff.child("M1Dz").removeValue();
        }

        if (sM2Dz.length() != 0) {
            reff.child("M2Dz").setValue(sM2Dz);
        } else {
            reff.child("M2Dz").removeValue();
        }

        if (sM3Dz.length() != 0) {
            reff.child("M3Dz").setValue(sM3Dz);
        } else {
            reff.child("M3Dz").removeValue();
        }

        if (sM4Dz.length() != 0) {
            reff.child("M4Dz").setValue(sM4Dz);
        } else {
            reff.child("M4Dz").removeValue();
        }

        if (sM5Dz.length() != 0) {
            reff.child("M5Dz").setValue(sM5Dz);
        } else {
            reff.child("M5Dz").removeValue();
        }

        if (sM6Dz.length() != 0) {
            reff.child("M6Dz").setValue(sM6Dz);
        } else {
            reff.child("M6Dz").removeValue();
        }

        if (sM7Dz.length() != 0) {
            reff.child("M7Dz").setValue(sM7Dz);
        } else {
            reff.child("M7Dz").removeValue();
        }

        if (sM8Dz.length() != 0) {
            reff.child("M8Dz").setValue(sM8Dz);
        } else {
            reff.child("M8Dz").removeValue();
        }
    }


    private void loadText() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sM1DZ = String.valueOf(snapshot.child("M1Dz").getValue());
                String sM2DZ = String.valueOf(snapshot.child("M2Dz").getValue());
                String sM3DZ = String.valueOf(snapshot.child("M3Dz").getValue());
                String sM4DZ = String.valueOf(snapshot.child("M4Dz").getValue());
                String sM5DZ = String.valueOf(snapshot.child("M5Dz").getValue());
                String sM6DZ = String.valueOf(snapshot.child("M6Dz").getValue());
                String sM7DZ = String.valueOf(snapshot.child("M7Dz").getValue());
                String sM8DZ = String.valueOf(snapshot.child("M8Dz").getValue());

                if (snapshot.child("M1Dz").exists()) {
                    etM1DZ.setText(sM1DZ);
                } else {
                    etM1DZ.setText("");
                }

                if (snapshot.child("M2Dz").exists()) {
                    etM2DZ.setText(sM2DZ);
                } else {
                    etM2DZ.setText("");
                }

                if (snapshot.child("M3Dz").exists()) {
                    etM3DZ.setText(sM3DZ);
                } else {
                    etM3DZ.setText("");
                }

                if (snapshot.child("M4Dz").exists()) {
                    etM4DZ.setText(sM4DZ);
                } else {
                    etM4DZ.setText("");
                }

                if (snapshot.child("M5Dz").exists()) {
                    etM5DZ.setText(sM5DZ);
                } else {
                    etM5DZ.setText("");
                }

                if (snapshot.child("M6Dz").exists()) {
                    etM6DZ.setText(sM6DZ);
                } else {
                    etM6DZ.setText("");
                }

                if (snapshot.child("M7Dz").exists()) {
                    etM7DZ.setText(sM7DZ);
                } else {
                    etM7DZ.setText("");
                }

                if (snapshot.child("M8Dz").exists()) {
                    etM8DZ.setText(sM8DZ);
                } else {
                    etM8DZ.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveText();
    }

    @Override
    public void onBackPressed() {
        saveText();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new StudyFragment());
        transaction.commit();
    }
}