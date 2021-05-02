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

public class SaturdayFragment extends Fragment implements OnBackPressedListener {

    TextView tvSat1,tvSat2,tvSat3,tvSat4,tvSat5,tvSat6,tvSat7,tvSat8,tvTimeSat11,tvTimeSat12,tvTimeSat13,tvTimeSat14,tvTimeSat15,tvTimeSat16,tvTimeSat17,tvTimeSat21,tvTimeSat22,tvTimeSat23,tvTimeSat24,tvTimeSat25,tvTimeSat26,tvTimeSat27,tvTimeSat31,tvTimeSat32,tvTimeSat33,tvTimeSat34,tvTimeSat35,tvTimeSat36,tvTimeSat37,tvTimeSat41,tvTimeSat42,tvTimeSat43,tvTimeSat44,tvTimeSat45,tvTimeSat46,tvTimeSat47,tvTimeSat51,tvTimeSat52,tvTimeSat53,tvTimeSat54,tvTimeSat55,tvTimeSat56,tvTimeSat57,tvTimeSat61,tvTimeSat62,tvTimeSat63,tvTimeSat64,tvTimeSat65,tvTimeSat66,tvTimeSat67,tvTimeSat71,tvTimeSat72,tvTimeSat73,tvTimeSat74,tvTimeSat75,tvTimeSat76,tvTimeSat77,tvTimeSat81,tvTimeSat82,tvTimeSat83,tvTimeSat84,tvTimeSat85,tvTimeSat86,tvTimeSat87,tvSat11,tvSat22,tvSat33,tvSat44,tvSat55,tvSat66,tvSat77,tvSat88;
    EditText etSat1DZ,etSat2DZ,etSat3DZ,etSat4DZ,etSat5DZ,etSat6DZ,etSat7DZ,etSat8DZ;
    Button btnHelp;
    TextView tvOcenkaSat1, tvOcenkaSat2, tvOcenkaSat3, tvOcenkaSat4, tvOcenkaSat5, tvOcenkaSat6, tvOcenkaSat7, tvOcenkaSat8;
    String Sat1,Sat2,Sat3,Sat4,Sat5,Sat6,Sat7,Sat8;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_saturday, container, false);

        btnHelp = v.findViewById(R.id.btnSunHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvSat1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeSat12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeSat16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvSat11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etSat1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaSat1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
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

        tvOcenkaSat1 = v.findViewById(R.id.tvOcenkaSat1);
        tvOcenkaSat2 = v.findViewById(R.id.tvOcenkaSat2);
        tvOcenkaSat3 = v.findViewById(R.id.tvOcenkaSat3);
        tvOcenkaSat4 = v.findViewById(R.id.tvOcenkaSat4);
        tvOcenkaSat5 = v.findViewById(R.id.tvOcenkaSat5);
        tvOcenkaSat6 = v.findViewById(R.id.tvOcenkaSat6);
        tvOcenkaSat7 = v.findViewById(R.id.tvOcenkaSat7);
        tvOcenkaSat8 = v.findViewById(R.id.tvOcenkaSat8);

        tvSat1 = v.findViewById(R.id.tvSat1);
        tvSat2 = v.findViewById(R.id.tvSat2);
        tvSat3 = v.findViewById(R.id.tvSat3);
        tvSat4 = v.findViewById(R.id.tvSat4);
        tvSat5 = v.findViewById(R.id.tvSat5);
        tvSat6 = v.findViewById(R.id.tvSat6);
        tvSat7 = v.findViewById(R.id.tvSat7);
        tvSat8 = v.findViewById(R.id.tvSat8);

        tvTimeSat11 = v.findViewById(R.id.tvTimeSat11);
        tvTimeSat12 = v.findViewById(R.id.tvTimeSat12);
        tvTimeSat13 = v.findViewById(R.id.tvTimeSat13);
        tvTimeSat14 = v.findViewById(R.id.tvTimeSat14);
        tvTimeSat15 = v.findViewById(R.id.tvTimeSat15);
        tvTimeSat16 = v.findViewById(R.id.tvTimeSat16);
        tvTimeSat17 = v.findViewById(R.id.tvTimeSat17);
        tvTimeSat21 = v.findViewById(R.id.tvTimeSat21);
        tvTimeSat22 = v.findViewById(R.id.tvTimeSat22);
        tvTimeSat23 = v.findViewById(R.id.tvTimeSat23);
        tvTimeSat24 = v.findViewById(R.id.tvTimeSat24);
        tvTimeSat25 = v.findViewById(R.id.tvTimeSat25);
        tvTimeSat26 = v.findViewById(R.id.tvTimeSat26);
        tvTimeSat27 = v.findViewById(R.id.tvTimeSat27);
        tvTimeSat31 = v.findViewById(R.id.tvTimeSat31);
        tvTimeSat32 = v.findViewById(R.id.tvTimeSat32);
        tvTimeSat33 = v.findViewById(R.id.tvTimeSat33);
        tvTimeSat34 = v.findViewById(R.id.tvTimeSat34);
        tvTimeSat35 = v.findViewById(R.id.tvTimeSat35);
        tvTimeSat36 = v.findViewById(R.id.tvTimeSat36);
        tvTimeSat37 = v.findViewById(R.id.tvTimeSat37);
        tvTimeSat41 = v.findViewById(R.id.tvTimeSat41);
        tvTimeSat42 = v.findViewById(R.id.tvTimeSat42);
        tvTimeSat43 = v.findViewById(R.id.tvTimeSat43);
        tvTimeSat44 = v.findViewById(R.id.tvTimeSat44);
        tvTimeSat45 = v.findViewById(R.id.tvTimeSat45);
        tvTimeSat46 = v.findViewById(R.id.tvTimeSat46);
        tvTimeSat47 = v.findViewById(R.id.tvTimeSat47);
        tvTimeSat51 = v.findViewById(R.id.tvTimeSat51);
        tvTimeSat52 = v.findViewById(R.id.tvTimeSat52);
        tvTimeSat53 = v.findViewById(R.id.tvTimeSat53);
        tvTimeSat54 = v.findViewById(R.id.tvTimeSat54);
        tvTimeSat55 = v.findViewById(R.id.tvTimeSat55);
        tvTimeSat56 = v.findViewById(R.id.tvTimeSat56);
        tvTimeSat57 = v.findViewById(R.id.tvTimeSat57);
        tvTimeSat61 = v.findViewById(R.id.tvTimeSat61);
        tvTimeSat62 = v.findViewById(R.id.tvTimeSat62);
        tvTimeSat63 = v.findViewById(R.id.tvTimeSat63);
        tvTimeSat64 = v.findViewById(R.id.tvTimeSat64);
        tvTimeSat65 = v.findViewById(R.id.tvTimeSat65);
        tvTimeSat66 = v.findViewById(R.id.tvTimeSat66);
        tvTimeSat67 = v.findViewById(R.id.tvTimeSat67);
        tvTimeSat71 = v.findViewById(R.id.tvTimeSat71);
        tvTimeSat72 = v.findViewById(R.id.tvTimeSat72);
        tvTimeSat73 = v.findViewById(R.id.tvTimeSat73);
        tvTimeSat74 = v.findViewById(R.id.tvTimeSat74);
        tvTimeSat75 = v.findViewById(R.id.tvTimeSat75);
        tvTimeSat76 = v.findViewById(R.id.tvTimeSat76);
        tvTimeSat77 = v.findViewById(R.id.tvTimeSat77);
        tvTimeSat81 = v.findViewById(R.id.tvTimeSat81);
        tvTimeSat82 = v.findViewById(R.id.tvTimeSat82);
        tvTimeSat83 = v.findViewById(R.id.tvTimeSat83);
        tvTimeSat84 = v.findViewById(R.id.tvTimeSat84);
        tvTimeSat85 = v.findViewById(R.id.tvTimeSat85);
        tvTimeSat86 = v.findViewById(R.id.tvTimeSat86);
        tvTimeSat87 = v.findViewById(R.id.tvTimeSat87);
        tvSat11 = v.findViewById(R.id.tvSat11);
        tvSat22 = v.findViewById(R.id.tvSat22);
        tvSat33 = v.findViewById(R.id.tvSat33);
        tvSat44 = v.findViewById(R.id.tvSat44);
        tvSat55 = v.findViewById(R.id.tvSat55);
        tvSat66 = v.findViewById(R.id.tvSat66);
        tvSat77 = v.findViewById(R.id.tvSat77);
        tvSat88 = v.findViewById(R.id.tvSat88);
        etSat1DZ = v.findViewById(R.id.etSat1DZ);
        etSat2DZ = v.findViewById(R.id.etSat2DZ);
        etSat3DZ = v.findViewById(R.id.etSat3DZ);
        etSat4DZ = v.findViewById(R.id.etSat4DZ);
        etSat5DZ = v.findViewById(R.id.etSat5DZ);
        etSat6DZ = v.findViewById(R.id.etSat6DZ);
        etSat7DZ = v.findViewById(R.id.etSat7DZ);
        etSat8DZ = v.findViewById(R.id.etSat8DZ);

        final String[] arr_sub1 = new String[8];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /**
                 * Get value subjects from database
                 */
                Sat1 = String.valueOf(snapshot.child("SubSat1").getValue());
                Sat2 = String.valueOf(snapshot.child("SubSat2").getValue());
                Sat3 = String.valueOf(snapshot.child("SubSat3").getValue());
                Sat4 = String.valueOf(snapshot.child("SubSat4").getValue());
                Sat5 = String.valueOf(snapshot.child("SubSat5").getValue());
                Sat6 = String.valueOf(snapshot.child("SubSat6").getValue());
                Sat7 = String.valueOf(snapshot.child("SubSat7").getValue());
                Sat8 = String.valueOf(snapshot.child("SubSat8").getValue());

                final String[] arr_sub = new String[8];
                final String[] arr_set = new String[8];
                arr_sub[0] = Sat1;
                arr_sub[1] = Sat2;
                arr_sub[2] = Sat3;
                arr_sub[3] = Sat4;
                arr_sub[4] = Sat5;
                arr_sub[5] = Sat6;
                arr_sub[6] = Sat7;
                arr_sub[7] = Sat8;
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
                                    final String view_ocenka = "tvOcenkaM" + (i + 1);
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
                            /**
                             * ПОПРОБУЙ ARRAY РЕФЕРНСОВ
                             */
                            final int count = ii;
                            reff2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot ds : snapshot.getChildren()) {
                                        Calendar now = Calendar.getInstance();
                                        //String monday = now.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
                                        int weekday1 = now.get(Calendar.DAY_OF_WEEK);
                                        int days1 = ((Calendar.SATURDAY - weekday1 + 2) % 7)-7;
                                        now.add(Calendar.DAY_OF_YEAR, days1);
                                        Date date1 = now.getTime();
                                        String dayStr = new SimpleDateFormat("EEE").format(date1);

                                        int Mn = 2;
                                        Calendar now1 = Calendar.getInstance();
                                        int weekday = now1.get(Calendar.DAY_OF_WEEK);
                                        int days = ((Calendar.SATURDAY - weekday + Mn) % 7)-7;
                                        now1.add(Calendar.DAY_OF_YEAR, days);
                                        Date date = now1.getTime();
                                        String dateStr = new SimpleDateFormat("dd/MM/yyyy").format(date);

                                        String str_date = String.valueOf(ds.child("Дата").getValue());
                                        if(str_date.equals(dateStr))
                                        {
                                            System.out.println("Test");
                                        }
                                        String str_day = String.valueOf(ds.child("День").getValue());
                                        if(dayStr.equals(str_day)) {
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
                if (snapshot.child("SubSat1").exists()) {
                    tvSat11.setText(Sat1);
                }
                else
                {
                    tvSat11.setText("");
                }

                if (snapshot.child("SubSat2").exists()) {
                    tvSat22.setText(Sat2);
                }
                else
                {
                    tvSat22.setText("");
                }

                if (snapshot.child("SubSat3").exists()) {
                    tvSat33.setText(Sat3);
                }
                else
                {
                    tvSat33.setText("");
                }

                if (snapshot.child("SubSat4").exists()) {
                    tvSat44.setText(Sat4);
                }
                else
                {
                    tvSat44.setText("");
                }

                if (snapshot.child("SubSat5").exists()) {
                    tvSat55.setText(Sat5);
                }
                else
                {
                    tvSat55.setText("");
                }

                if (snapshot.child("SubSat6").exists()) {
                    tvSat66.setText(Sat6);
                }
                else
                {
                    tvSat66.setText("");
                }

                if (snapshot.child("SubSat7").exists()) {
                    tvSat77.setText(Sat7);
                }
                else
                {
                    tvSat77.setText("");
                }

                if (snapshot.child("SubSat8").exists()) {
                    tvSat88.setText(Sat8);
                }
                else
                {
                    tvSat88.setText("");
                }

                /**
                 * Get value time from db
                 */
                String sSat11 = String.valueOf(snapshot.child("T11").getValue());
                String sSat12 = String.valueOf(snapshot.child("T12").getValue());
                String sSat13 = String.valueOf(snapshot.child("T13").getValue());
                String sSat14 = String.valueOf(snapshot.child("T14").getValue());

                String sSat21 = String.valueOf(snapshot.child("T21").getValue());
                String sSat22 = String.valueOf(snapshot.child("T22").getValue());
                String sSat23 = String.valueOf(snapshot.child("T23").getValue());
                String sSat24 = String.valueOf(snapshot.child("T24").getValue());

                String sSat31 = String.valueOf(snapshot.child("T31").getValue());
                String sSat32 = String.valueOf(snapshot.child("T32").getValue());
                String sSat33 = String.valueOf(snapshot.child("T33").getValue());
                String sSat34 = String.valueOf(snapshot.child("T34").getValue());

                String sSat41 = String.valueOf(snapshot.child("T41").getValue());
                String sSat42 = String.valueOf(snapshot.child("T42").getValue());
                String sSat43 = String.valueOf(snapshot.child("T43").getValue());
                String sSat44 = String.valueOf(snapshot.child("T44").getValue());

                String sSat51 = String.valueOf(snapshot.child("T51").getValue());
                String sSat52 = String.valueOf(snapshot.child("T52").getValue());
                String sSat53 = String.valueOf(snapshot.child("T53").getValue());
                String sSat54 = String.valueOf(snapshot.child("T54").getValue());

                String sSat61 = String.valueOf(snapshot.child("T61").getValue());
                String sSat62 = String.valueOf(snapshot.child("T62").getValue());
                String sSat63 = String.valueOf(snapshot.child("T63").getValue());
                String sSat64 = String.valueOf(snapshot.child("T64").getValue());

                String sSat71 = String.valueOf(snapshot.child("T71").getValue());
                String sSat72 = String.valueOf(snapshot.child("T72").getValue());
                String sSat73 = String.valueOf(snapshot.child("T73").getValue());
                String sSat74 = String.valueOf(snapshot.child("T74").getValue());

                String sSat81 = String.valueOf(snapshot.child("T81").getValue());
                String sSat82 = String.valueOf(snapshot.child("T82").getValue());
                String sSat83 = String.valueOf(snapshot.child("T83").getValue());
                String sSat84 = String.valueOf(snapshot.child("T84").getValue());

                /**
                 * Set value time from db
                 */
                //////////////////
                tvTimeSat11.setText(sSat11);
                tvTimeSat13.setText(sSat12);
                tvTimeSat15.setText(sSat13);
                tvTimeSat17.setText(sSat14);
                //////////////////
                tvTimeSat21.setText(sSat21);
                tvTimeSat23.setText(sSat22);
                tvTimeSat25.setText(sSat23);
                tvTimeSat27.setText(sSat24);
                /////////////////////
                tvTimeSat31.setText(sSat31);
                tvTimeSat33.setText(sSat32);
                tvTimeSat35.setText(sSat33);
                tvTimeSat37.setText(sSat34);
                ////////////////////////
                tvTimeSat41.setText(sSat41);
                tvTimeSat43.setText(sSat42);
                tvTimeSat45.setText(sSat43);
                tvTimeSat47.setText(sSat44);
                //////////////////////
                tvTimeSat51.setText(sSat51);
                tvTimeSat53.setText(sSat52);
                tvTimeSat55.setText(sSat53);
                tvTimeSat57.setText(sSat54);
                //////////////////////
                tvTimeSat61.setText(sSat61);
                tvTimeSat63.setText(sSat62);
                tvTimeSat65.setText(sSat63);
                tvTimeSat67.setText(sSat64);
                //////////////////////
                tvTimeSat71.setText(sSat71);
                tvTimeSat73.setText(sSat72);
                tvTimeSat75.setText(sSat73);
                tvTimeSat77.setText(sSat74);
                ///////////////////////
                tvTimeSat81.setText(sSat81);
                tvTimeSat83.setText(sSat82);
                tvTimeSat85.setText(sSat83);
                tvTimeSat87.setText(sSat84);

                /**
                 * Check value time for ui
                 */
                if(sSat11.equals("null"))
                {
                    tvTimeSat11.setVisibility(View.GONE);
                    tvTimeSat12.setVisibility(View.GONE);
                    tvTimeSat13.setVisibility(View.GONE);
                    tvTimeSat14.setVisibility(View.GONE);
                    tvTimeSat15.setVisibility(View.GONE);
                    tvTimeSat16.setVisibility(View.GONE);
                    tvTimeSat17.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat12.setVisibility(View.VISIBLE);
                    tvTimeSat14.setVisibility(View.VISIBLE);
                    tvTimeSat16.setVisibility(View.VISIBLE);
                }

                if(sSat21.equals("null"))
                {
                    tvTimeSat21.setVisibility(View.GONE);
                    tvTimeSat22.setVisibility(View.GONE);
                    tvTimeSat23.setVisibility(View.GONE);
                    tvTimeSat24.setVisibility(View.GONE);
                    tvTimeSat25.setVisibility(View.GONE);
                    tvTimeSat26.setVisibility(View.GONE);
                    tvTimeSat27.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat22.setVisibility(View.VISIBLE);
                    tvTimeSat24.setVisibility(View.VISIBLE);
                    tvTimeSat26.setVisibility(View.VISIBLE);
                }

                if(sSat31.equals("null"))
                {
                    tvTimeSat31.setVisibility(View.GONE);
                    tvTimeSat32.setVisibility(View.GONE);
                    tvTimeSat33.setVisibility(View.GONE);
                    tvTimeSat34.setVisibility(View.GONE);
                    tvTimeSat35.setVisibility(View.GONE);
                    tvTimeSat36.setVisibility(View.GONE);
                    tvTimeSat37.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat32.setVisibility(View.VISIBLE);
                    tvTimeSat34.setVisibility(View.VISIBLE);
                    tvTimeSat36.setVisibility(View.VISIBLE);
                }

                if(sSat41.equals("null"))
                {
                    tvTimeSat41.setVisibility(View.GONE);
                    tvTimeSat42.setVisibility(View.GONE);
                    tvTimeSat43.setVisibility(View.GONE);
                    tvTimeSat44.setVisibility(View.GONE);
                    tvTimeSat45.setVisibility(View.GONE);
                    tvTimeSat46.setVisibility(View.GONE);
                    tvTimeSat47.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat42.setVisibility(View.VISIBLE);
                    tvTimeSat44.setVisibility(View.VISIBLE);
                    tvTimeSat46.setVisibility(View.VISIBLE);
                }

                if(sSat51.equals("null"))
                {
                    tvTimeSat51.setVisibility(View.GONE);
                    tvTimeSat52.setVisibility(View.GONE);
                    tvTimeSat53.setVisibility(View.GONE);
                    tvTimeSat54.setVisibility(View.GONE);
                    tvTimeSat55.setVisibility(View.GONE);
                    tvTimeSat56.setVisibility(View.GONE);
                    tvTimeSat57.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat52.setVisibility(View.VISIBLE);
                    tvTimeSat54.setVisibility(View.VISIBLE);
                    tvTimeSat56.setVisibility(View.VISIBLE);
                }

                if(sSat61.equals("null"))
                {
                    tvTimeSat61.setVisibility(View.GONE);
                    tvTimeSat62.setVisibility(View.GONE);
                    tvTimeSat63.setVisibility(View.GONE);
                    tvTimeSat64.setVisibility(View.GONE);
                    tvTimeSat65.setVisibility(View.GONE);
                    tvTimeSat66.setVisibility(View.GONE);
                    tvTimeSat67.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat62.setVisibility(View.VISIBLE);
                    tvTimeSat64.setVisibility(View.VISIBLE);
                    tvTimeSat66.setVisibility(View.VISIBLE);
                }

                if(sSat71.equals("null"))
                {
                    tvTimeSat71.setVisibility(View.GONE);
                    tvTimeSat72.setVisibility(View.GONE);
                    tvTimeSat73.setVisibility(View.GONE);
                    tvTimeSat74.setVisibility(View.GONE);
                    tvTimeSat75.setVisibility(View.GONE);
                    tvTimeSat76.setVisibility(View.GONE);
                    tvTimeSat77.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat72.setVisibility(View.VISIBLE);
                    tvTimeSat74.setVisibility(View.VISIBLE);
                    tvTimeSat76.setVisibility(View.VISIBLE);
                }

                if(sSat81.equals("null"))
                {
                    tvTimeSat81.setVisibility(View.GONE);
                    tvTimeSat82.setVisibility(View.GONE);
                    tvTimeSat83.setVisibility(View.GONE);
                    tvTimeSat84.setVisibility(View.GONE);
                    tvTimeSat85.setVisibility(View.GONE);
                    tvTimeSat86.setVisibility(View.GONE);
                    tvTimeSat87.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat82.setVisibility(View.VISIBLE);
                    tvTimeSat84.setVisibility(View.VISIBLE);
                    tvTimeSat86.setVisibility(View.VISIBLE);
                }

                if (!Sat1.equals("null") && Sat1.length()>7) {
                    tvSat11.setPadding(0, 0, 0, 8);
                }

                if (!Sat2.equals("null") && Sat2.length()>7) {
                    tvSat22.setPadding(0, 0, 0, 8);
                }

                if (!Sat3.equals("null") && Sat3.length()>7) {
                    tvSat33.setPadding(0, 0, 0, 8);
                }

                if (!Sat4.equals("null") && Sat4.length()>7) {
                    tvSat44.setPadding(0, 0, 0, 8);
                }

                if (!Sat5.equals("null") && Sat5.length()>7) {
                    tvSat55.setPadding(0, 0, 0, 8);
                }

                if (!Sat6.equals("null") && Sat6.length()>7) {
                    tvSat66.setPadding(0, 0, 0, 8);
                }

                if (!Sat7.equals("null") && Sat7.length()>7) {
                    tvSat77.setPadding(0, 0, 0, 8);
                }

                if (!Sat8.equals("null") && Sat8.length()>7) {
                    tvSat88.setPadding(0, 0, 0, 8);
                }

                /**
                 * Check value subject Sat ui
                 */
                LinearLayout ll_row1 = v.findViewById(R.id.studentSat_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.studentSat_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.studentSat_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.studentSat_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.studentSat_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.studentSat_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.studentSat_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.studentSat_row8);

                //1 СТРОКА
                if (Sat1.equals("null"))
                {
                    ll_row1.setVisibility(View.GONE);
                }
                else
                {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (Sat2.equals("null"))
                {
                    ll_row2.setVisibility(View.GONE);
                }
                else
                {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (Sat3.equals("null"))
                {
                    ll_row3.setVisibility(View.GONE);
                }
                else
                {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (Sat4.equals("null"))
                {
                    ll_row4.setVisibility(View.GONE);
                }
                else
                {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (Sat5.equals("null"))
                {
                    ll_row5.setVisibility(View.GONE);
                }
                else
                {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (Sat6.equals("null"))
                {
                    ll_row6.setVisibility(View.GONE);
                }
                else
                {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (Sat7.equals("null"))
                {
                    ll_row7.setVisibility(View.GONE);
                }
                else
                {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (Sat8.equals("null"))
                {
                    ll_row8.setVisibility(View.GONE);
                }
                else
                {
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
        String sSat1Dz = etSat1DZ.getText().toString();
        String sSat2Dz = etSat2DZ.getText().toString();
        String sSat3Dz = etSat3DZ.getText().toString();
        String sSat4Dz = etSat4DZ.getText().toString();
        String sSat5Dz = etSat5DZ.getText().toString();
        String sSat6Dz = etSat6DZ.getText().toString();
        String sSat7Dz = etSat7DZ.getText().toString();
        String sSat8Dz = etSat8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        if(sSat1Dz.length()!=0) {
            reff.child("Sat1Dz").setValue(sSat1Dz);
        }
        else
        {
            reff.child("Sat1Dz").removeValue();
        }

        if(sSat2Dz.length()!=0) {
            reff.child("Sat2Dz").setValue(sSat2Dz);
        }
        else
        {
            reff.child("Sat2Dz").removeValue();
        }

        if(sSat3Dz.length()!=0) {
            reff.child("Sat3Dz").setValue(sSat3Dz);
        }
        else
        {
            reff.child("Sat3Dz").removeValue();
        }

        if(sSat4Dz.length()!=0) {
            reff.child("Sat4Dz").setValue(sSat4Dz);
        }
        else
        {
            reff.child("Sat4Dz").removeValue();
        }

        if(sSat5Dz.length()!=0) {
            reff.child("Sat5Dz").setValue(sSat5Dz);
        }
        else
        {
            reff.child("Sat5Dz").removeValue();
        }

        if(sSat6Dz.length()!=0) {
            reff.child("Sat6Dz").setValue(sSat6Dz);
        }
        else
        {
            reff.child("Sat6Dz").removeValue();
        }

        if(sSat7Dz.length()!=0) {
            reff.child("Sat7Dz").setValue(sSat7Dz);
        }
        else
        {
            reff.child("Sat7Dz").removeValue();
        }

        if(sSat8Dz.length()!=0) {
            reff.child("Sat8Dz").setValue(sSat8Dz);
        }
        else
        {
            reff.child("Sat8Dz").removeValue();
        }
    }

    private void loadText() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sSat1DZ = String.valueOf(snapshot.child("Sat1Dz").getValue());
                String sSat2DZ = String.valueOf(snapshot.child("Sat2Dz").getValue());
                String sSat3DZ = String.valueOf(snapshot.child("Sat3Dz").getValue());
                String sSat4DZ = String.valueOf(snapshot.child("Sat4Dz").getValue());
                String sSat5DZ = String.valueOf(snapshot.child("Sat5Dz").getValue());
                String sSat6DZ = String.valueOf(snapshot.child("Sat6Dz").getValue());
                String sSat7DZ = String.valueOf(snapshot.child("Sat7Dz").getValue());
                String sSat8DZ = String.valueOf(snapshot.child("Sat8Dz").getValue());

                if (snapshot.child("Sat1Dz").exists()) {
                    etSat1DZ.setText(sSat1DZ);
                }
                else
                {
                    etSat1DZ.setText("");
                }

                if (snapshot.child("Sat2Dz").exists()) {
                    etSat2DZ.setText(sSat2DZ);
                }
                else
                {
                    etSat2DZ.setText("");
                }

                if (snapshot.child("Sat3Dz").exists()) {
                    etSat3DZ.setText(sSat3DZ);
                }
                else
                {
                    etSat3DZ.setText("");
                }

                if (snapshot.child("Sat4Dz").exists()) {
                    etSat4DZ.setText(sSat4DZ);
                }
                else
                {
                    etSat4DZ.setText("");
                }

                if (snapshot.child("Sat5Dz").exists()) {
                    etSat5DZ.setText(sSat5DZ);
                }
                else
                {
                    etSat5DZ.setText("");
                }

                if (snapshot.child("Sat6Dz").exists()) {
                    etSat6DZ.setText(sSat6DZ);
                }
                else
                {
                    etSat6DZ.setText("");
                }

                if (snapshot.child("Sat7Dz").exists()) {
                    etSat7DZ.setText(sSat7DZ);
                }
                else
                {
                    etSat7DZ.setText("");
                }

                if (snapshot.child("Sat8Dz").exists()) {
                    etSat8DZ.setText(sSat8DZ);
                }
                else
                {
                    etSat8DZ.setText("");
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