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
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;

public class FridayFragment extends Fragment implements OnBackPressedListener {

    TextView tvFr1,tvFr2,tvFr3,tvFr4,tvFr5,tvFr6,tvFr7,tvFr8,tvTimeFr11,tvTimeFr12,tvTimeFr13,tvTimeFr14,tvTimeFr15,tvTimeFr16,tvTimeFr17,tvTimeFr21,tvTimeFr22,tvTimeFr23,tvTimeFr24,tvTimeFr25,tvTimeFr26,tvTimeFr27,tvTimeFr31,tvTimeFr32,tvTimeFr33,tvTimeFr34,tvTimeFr35,tvTimeFr36,tvTimeFr37,tvTimeFr41,tvTimeFr42,tvTimeFr43,tvTimeFr44,tvTimeFr45,tvTimeFr46,tvTimeFr47,tvTimeFr51,tvTimeFr52,tvTimeFr53,tvTimeFr54,tvTimeFr55,tvTimeFr56,tvTimeFr57,tvTimeFr61,tvTimeFr62,tvTimeFr63,tvTimeFr64,tvTimeFr65,tvTimeFr66,tvTimeFr67,tvTimeFr71,tvTimeFr72,tvTimeFr73,tvTimeFr74,tvTimeFr75,tvTimeFr76,tvTimeFr77,tvTimeFr81,tvTimeFr82,tvTimeFr83,tvTimeFr84,tvTimeFr85,tvTimeFr86,tvTimeFr87,tvFr11,tvFr22,tvFr33,tvFr44,tvFr55,tvFr66,tvFr77,tvFr88;
    EditText etFr1DZ,etFr2DZ,etFr3DZ,etFr4DZ,etFr5DZ,etFr6DZ,etFr7DZ,etFr8DZ;
    Button btnHelp;
    TextView tvOcenkaFr1, tvOcenkaFr2, tvOcenkaFr3, tvOcenkaFr4, tvOcenkaFr5, tvOcenkaFr6, tvOcenkaFr7, tvOcenkaFr8;
    String Fr1,Fr2,Fr3,Fr4,Fr5,Fr6,Fr7,Fr8;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_friday, container, false);

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
                                TapTarget.forView(v.findViewById(R.id.tvFr11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.etFr1DZ), getResources().getString(R.string.DZ), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvOcenkaFr1), getResources().getString(R.string.galochka), getResources().getString(R.string.click_TapTargetView))
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


        tvOcenkaFr1 = v.findViewById(R.id.tvOcenkaFr1);
        tvOcenkaFr2 = v.findViewById(R.id.tvOcenkaFr2);
        tvOcenkaFr3 = v.findViewById(R.id.tvOcenkaFr3);
        tvOcenkaFr4 = v.findViewById(R.id.tvOcenkaFr4);
        tvOcenkaFr5 = v.findViewById(R.id.tvOcenkaFr5);
        tvOcenkaFr6 = v.findViewById(R.id.tvOcenkaFr6);
        tvOcenkaFr7 = v.findViewById(R.id.tvOcenkaFr7);
        tvOcenkaFr8 = v.findViewById(R.id.tvOcenkaFr8);

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
        tvFr11 = v.findViewById(R.id.tvFr11);
        tvFr22 = v.findViewById(R.id.tvFr22);
        tvFr33 = v.findViewById(R.id.tvFr33);
        tvFr44 = v.findViewById(R.id.tvFr44);
        tvFr55 = v.findViewById(R.id.tvFr55);
        tvFr66 = v.findViewById(R.id.tvFr66);
        tvFr77 = v.findViewById(R.id.tvFr77);
        tvFr88 = v.findViewById(R.id.tvFr88);
        etFr1DZ = v.findViewById(R.id.etFr1DZ);
        etFr2DZ = v.findViewById(R.id.etFr2DZ);
        etFr3DZ = v.findViewById(R.id.etFr3DZ);
        etFr4DZ = v.findViewById(R.id.etFr4DZ);
        etFr5DZ = v.findViewById(R.id.etFr5DZ);
        etFr6DZ = v.findViewById(R.id.etFr6DZ);
        etFr7DZ = v.findViewById(R.id.etFr7DZ);
        etFr8DZ = v.findViewById(R.id.etFr8DZ);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /**
                 * Get value subjects from database
                 */
                Fr1 = String.valueOf(snapshot.child("SubFr1").getValue());
                Fr2 = String.valueOf(snapshot.child("SubFr2").getValue());
                Fr3 = String.valueOf(snapshot.child("SubFr3").getValue());
                Fr4 = String.valueOf(snapshot.child("SubFr4").getValue());
                Fr5 = String.valueOf(snapshot.child("SubFr5").getValue());
                Fr6 = String.valueOf(snapshot.child("SubFr6").getValue());
                Fr7 = String.valueOf(snapshot.child("SubFr7").getValue());
                Fr8 = String.valueOf(snapshot.child("SubFr8").getValue());
                /**
                 * Check exist value subject
                 */
                if (snapshot.child("SubFr1").exists()) {
                    tvFr11.setText(Fr1);
                }
                else
                {
                    tvFr11.setText("");
                }

                if (snapshot.child("SubFr2").exists()) {
                    tvFr22.setText(Fr2);
                }
                else
                {
                    tvFr22.setText("");
                }

                if (snapshot.child("SubFr3").exists()) {
                    tvFr33.setText(Fr3);
                }
                else
                {
                    tvFr33.setText("");
                }

                if (snapshot.child("SubFr4").exists()) {
                    tvFr44.setText(Fr4);
                }
                else
                {
                    tvFr44.setText("");
                }

                if (snapshot.child("SubFr5").exists()) {
                    tvFr55.setText(Fr5);
                }
                else
                {
                    tvFr55.setText("");
                }

                if (snapshot.child("SubFr6").exists()) {
                    tvFr66.setText(Fr6);
                }
                else
                {
                    tvFr66.setText("");
                }

                if (snapshot.child("SubFr7").exists()) {
                    tvFr77.setText(Fr7);
                }
                else
                {
                    tvFr77.setText("");
                }

                if (snapshot.child("SubFr8").exists()) {
                    tvFr88.setText(Fr8);
                }
                else
                {
                    tvFr88.setText("");
                }

                /**
                 * Get value time from db
                 */
                String sFr11 = String.valueOf(snapshot.child("T11").getValue());
                String sFr12 = String.valueOf(snapshot.child("T12").getValue());
                String sFr13 = String.valueOf(snapshot.child("T13").getValue());
                String sFr14 = String.valueOf(snapshot.child("T14").getValue());

                String sFr21 = String.valueOf(snapshot.child("T21").getValue());
                String sFr22 = String.valueOf(snapshot.child("T22").getValue());
                String sFr23 = String.valueOf(snapshot.child("T23").getValue());
                String sFr24 = String.valueOf(snapshot.child("T24").getValue());

                String sFr31 = String.valueOf(snapshot.child("T31").getValue());
                String sFr32 = String.valueOf(snapshot.child("T32").getValue());
                String sFr33 = String.valueOf(snapshot.child("T33").getValue());
                String sFr34 = String.valueOf(snapshot.child("T34").getValue());

                String sFr41 = String.valueOf(snapshot.child("T41").getValue());
                String sFr42 = String.valueOf(snapshot.child("T42").getValue());
                String sFr43 = String.valueOf(snapshot.child("T43").getValue());
                String sFr44 = String.valueOf(snapshot.child("T44").getValue());

                String sFr51 = String.valueOf(snapshot.child("T51").getValue());
                String sFr52 = String.valueOf(snapshot.child("T52").getValue());
                String sFr53 = String.valueOf(snapshot.child("T53").getValue());
                String sFr54 = String.valueOf(snapshot.child("T54").getValue());

                String sFr61 = String.valueOf(snapshot.child("T61").getValue());
                String sFr62 = String.valueOf(snapshot.child("T62").getValue());
                String sFr63 = String.valueOf(snapshot.child("T63").getValue());
                String sFr64 = String.valueOf(snapshot.child("T64").getValue());

                String sFr71 = String.valueOf(snapshot.child("T71").getValue());
                String sFr72 = String.valueOf(snapshot.child("T72").getValue());
                String sFr73 = String.valueOf(snapshot.child("T73").getValue());
                String sFr74 = String.valueOf(snapshot.child("T74").getValue());

                String sFr81 = String.valueOf(snapshot.child("T81").getValue());
                String sFr82 = String.valueOf(snapshot.child("T82").getValue());
                String sFr83 = String.valueOf(snapshot.child("T83").getValue());
                String sFr84 = String.valueOf(snapshot.child("T84").getValue());

                /**
                 * Check value time for ui
                 */
                if(sFr11.equals("null"))
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

                if(sFr21.equals("null"))
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

                if(sFr31.equals("null"))
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

                if(sFr41.equals("null"))
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

                if(sFr51.equals("null"))
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

                if(sFr61.equals("null"))
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

                if(sFr71.equals("null"))
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

                if(sFr81.equals("null"))
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

                /**
                 * Set value time from db
                 */
                //////////////////
                tvTimeFr11.setText(sFr11);
                tvTimeFr13.setText(sFr12);
                tvTimeFr15.setText(sFr13);
                tvTimeFr17.setText(sFr14);
                //////////////////
                tvTimeFr21.setText(sFr21);
                tvTimeFr23.setText(sFr22);
                tvTimeFr25.setText(sFr23);
                tvTimeFr27.setText(sFr24);
                /////////////////////
                tvTimeFr31.setText(sFr31);
                tvTimeFr33.setText(sFr32);
                tvTimeFr35.setText(sFr33);
                tvTimeFr37.setText(sFr34);
                ////////////////////////
                tvTimeFr41.setText(sFr41);
                tvTimeFr43.setText(sFr42);
                tvTimeFr45.setText(sFr43);
                tvTimeFr47.setText(sFr44);
                //////////////////////
                tvTimeFr51.setText(sFr51);
                tvTimeFr53.setText(sFr52);
                tvTimeFr55.setText(sFr53);
                tvTimeFr57.setText(sFr54);
                //////////////////////
                tvTimeFr61.setText(sFr61);
                tvTimeFr63.setText(sFr62);
                tvTimeFr65.setText(sFr63);
                tvTimeFr67.setText(sFr64);
                //////////////////////
                tvTimeFr71.setText(sFr71);
                tvTimeFr73.setText(sFr72);
                tvTimeFr75.setText(sFr73);
                tvTimeFr77.setText(sFr74);
                ///////////////////////
                tvTimeFr81.setText(sFr81);
                tvTimeFr83.setText(sFr82);
                tvTimeFr85.setText(sFr83);
                tvTimeFr87.setText(sFr84);

                if (!Fr1.equals("null") && Fr1.length()>7) {
                    tvFr11.setPadding(0, 0, 0, 8);
                }

                if (!Fr2.equals("null") && Fr2.length()>7) {
                    tvFr22.setPadding(0, 0, 0, 8);
                }

                if (!Fr3.equals("null") && Fr3.length()>7) {
                    tvFr33.setPadding(0, 0, 0, 8);
                }

                if (!Fr4.equals("null") && Fr4.length()>7) {
                    tvFr44.setPadding(0, 0, 0, 8);
                }

                if (!Fr5.equals("null") && Fr5.length()>7) {
                    tvFr55.setPadding(0, 0, 0, 8);
                }

                if (!Fr6.equals("null") && Fr6.length()>7) {
                    tvFr66.setPadding(0, 0, 0, 8);
                }

                if (!Fr7.equals("null") && Fr7.length()>7) {
                    tvFr77.setPadding(0, 0, 0, 8);
                }

                if (!Fr8.equals("null") && Fr8.length()>7) {
                    tvFr88.setPadding(0, 0, 0, 8);
                }

                /**
                 * Check value subject from ui
                 */
                if (Fr1.equals("null")) {
                    tvFr11.setVisibility(View.GONE);
                    tvTimeFr11.setVisibility(View.GONE);
                    tvTimeFr12.setVisibility(View.GONE);
                    tvTimeFr13.setVisibility(View.GONE);
                    tvTimeFr14.setVisibility(View.GONE);
                    tvTimeFr15.setVisibility(View.GONE);
                    tvTimeFr16.setVisibility(View.GONE);
                    tvTimeFr17.setVisibility(View.GONE);
                    tvFr1.setVisibility(View.GONE);
                    etFr1DZ.setVisibility(View.GONE);
                    tvOcenkaFr1.setVisibility(View.GONE);
                } else {
                    tvFr11.setVisibility(View.VISIBLE);
                    tvTimeFr11.setVisibility(View.VISIBLE);
                    tvTimeFr13.setVisibility(View.VISIBLE);
                    tvTimeFr15.setVisibility(View.VISIBLE);
                    tvTimeFr17.setVisibility(View.VISIBLE);
                    tvFr1.setVisibility(View.VISIBLE);
                    etFr1DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (Fr2.equals("null")) {
                    tvFr22.setVisibility(View.GONE);
                    tvTimeFr21.setVisibility(View.GONE);
                    tvTimeFr22.setVisibility(View.GONE);
                    tvTimeFr23.setVisibility(View.GONE);
                    tvTimeFr24.setVisibility(View.GONE);
                    tvTimeFr25.setVisibility(View.GONE);
                    tvTimeFr26.setVisibility(View.GONE);
                    tvTimeFr27.setVisibility(View.GONE);
                    tvFr2.setVisibility(View.GONE);
                    etFr2DZ.setVisibility(View.GONE);
                    tvOcenkaFr2.setVisibility(View.GONE);
                } else {
                    tvFr22.setVisibility(View.VISIBLE);
                    tvTimeFr21.setVisibility(View.VISIBLE);
                    tvTimeFr23.setVisibility(View.VISIBLE);
                    tvTimeFr25.setVisibility(View.VISIBLE);
                    tvTimeFr27.setVisibility(View.VISIBLE);
                    tvFr2.setVisibility(View.VISIBLE);
                    etFr2DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (Fr3.equals("null")) {
                    tvFr33.setVisibility(View.GONE);
                    tvTimeFr31.setVisibility(View.GONE);
                    tvTimeFr32.setVisibility(View.GONE);
                    tvTimeFr33.setVisibility(View.GONE);
                    tvTimeFr34.setVisibility(View.GONE);
                    tvTimeFr35.setVisibility(View.GONE);
                    tvTimeFr36.setVisibility(View.GONE);
                    tvTimeFr37.setVisibility(View.GONE);
                    tvFr3.setVisibility(View.GONE);
                    etFr3DZ.setVisibility(View.GONE);
                    tvOcenkaFr3.setVisibility(View.GONE);
                } else {
                    tvFr33.setVisibility(View.VISIBLE);
                    tvTimeFr31.setVisibility(View.VISIBLE);
                    tvTimeFr33.setVisibility(View.VISIBLE);
                    tvTimeFr35.setVisibility(View.VISIBLE);
                    tvTimeFr37.setVisibility(View.VISIBLE);
                    tvFr3.setVisibility(View.VISIBLE);
                    etFr3DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr4.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (Fr4.equals("null")) {
                    tvFr44.setVisibility(View.GONE);
                    tvTimeFr41.setVisibility(View.GONE);
                    tvTimeFr42.setVisibility(View.GONE);
                    tvTimeFr43.setVisibility(View.GONE);
                    tvTimeFr44.setVisibility(View.GONE);
                    tvTimeFr45.setVisibility(View.GONE);
                    tvTimeFr46.setVisibility(View.GONE);
                    tvTimeFr47.setVisibility(View.GONE);
                    tvFr4.setVisibility(View.GONE);
                    etFr4DZ.setVisibility(View.GONE);
                    tvOcenkaFr4.setVisibility(View.GONE);
                } else {
                    tvFr44.setVisibility(View.VISIBLE);
                    tvTimeFr41.setVisibility(View.VISIBLE);
                    tvTimeFr43.setVisibility(View.VISIBLE);
                    tvTimeFr45.setVisibility(View.VISIBLE);
                    tvTimeFr47.setVisibility(View.VISIBLE);
                    tvFr4.setVisibility(View.VISIBLE);
                    etFr4DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (Fr5.equals("null")) {
                    tvFr55.setVisibility(View.GONE);
                    tvTimeFr51.setVisibility(View.GONE);
                    tvTimeFr52.setVisibility(View.GONE);
                    tvTimeFr53.setVisibility(View.GONE);
                    tvTimeFr54.setVisibility(View.GONE);
                    tvTimeFr55.setVisibility(View.GONE);
                    tvTimeFr56.setVisibility(View.GONE);
                    tvTimeFr57.setVisibility(View.GONE);
                    tvFr5.setVisibility(View.GONE);
                    etFr5DZ.setVisibility(View.GONE);
                    tvOcenkaFr5.setVisibility(View.GONE);
                } else {
                    tvFr55.setVisibility(View.VISIBLE);
                    tvTimeFr51.setVisibility(View.VISIBLE);
                    tvTimeFr53.setVisibility(View.VISIBLE);
                    tvTimeFr55.setVisibility(View.VISIBLE);
                    tvTimeFr57.setVisibility(View.VISIBLE);
                    tvFr5.setVisibility(View.VISIBLE);
                    etFr5DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (Fr6.equals("null")) {
                    tvFr6.setVisibility(View.GONE);
                    tvTimeFr61.setVisibility(View.GONE);
                    tvTimeFr62.setVisibility(View.GONE);
                    tvTimeFr63.setVisibility(View.GONE);
                    tvTimeFr64.setVisibility(View.GONE);
                    tvTimeFr65.setVisibility(View.GONE);
                    tvTimeFr66.setVisibility(View.GONE);
                    tvTimeFr67.setVisibility(View.GONE);
                    tvFr6.setVisibility(View.GONE);
                    etFr6DZ.setVisibility(View.GONE);
                    tvOcenkaFr6.setVisibility(View.GONE);
                } else {
                    tvFr66.setVisibility(View.VISIBLE);
                    tvTimeFr61.setVisibility(View.VISIBLE);
                    tvTimeFr63.setVisibility(View.VISIBLE);
                    tvTimeFr65.setVisibility(View.VISIBLE);
                    tvTimeFr67.setVisibility(View.VISIBLE);
                    tvFr6.setVisibility(View.VISIBLE);
                    etFr6DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (Fr7.equals("null")) {
                    tvFr77.setVisibility(View.GONE);
                    tvTimeFr71.setVisibility(View.GONE);
                    tvTimeFr72.setVisibility(View.GONE);
                    tvTimeFr73.setVisibility(View.GONE);
                    tvTimeFr74.setVisibility(View.GONE);
                    tvTimeFr75.setVisibility(View.GONE);
                    tvTimeFr76.setVisibility(View.GONE);
                    tvTimeFr77.setVisibility(View.GONE);
                    tvFr7.setVisibility(View.GONE);
                    etFr7DZ.setVisibility(View.GONE);
                    tvOcenkaFr7.setVisibility(View.GONE);
                } else {
                    tvFr77.setVisibility(View.VISIBLE);
                    tvTimeFr71.setVisibility(View.VISIBLE);
                    tvTimeFr73.setVisibility(View.VISIBLE);
                    tvTimeFr75.setVisibility(View.VISIBLE);
                    tvTimeFr77.setVisibility(View.VISIBLE);
                    tvFr7.setVisibility(View.VISIBLE);
                    etFr7DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (Fr8.equals("null")) {
                    tvFr88.setVisibility(View.GONE);
                    tvTimeFr81.setVisibility(View.GONE);
                    tvTimeFr82.setVisibility(View.GONE);
                    tvTimeFr83.setVisibility(View.GONE);
                    tvTimeFr84.setVisibility(View.GONE);
                    tvTimeFr85.setVisibility(View.GONE);
                    tvTimeFr86.setVisibility(View.GONE);
                    tvTimeFr87.setVisibility(View.GONE);
                    tvFr8.setVisibility(View.GONE);
                    etFr8DZ.setVisibility(View.GONE);
                    tvOcenkaFr8.setVisibility(View.GONE);
                } else {
                    tvFr88.setVisibility(View.VISIBLE);
                    tvTimeFr81.setVisibility(View.VISIBLE);
                    tvTimeFr83.setVisibility(View.VISIBLE);
                    tvTimeFr85.setVisibility(View.VISIBLE);
                    tvTimeFr87.setVisibility(View.VISIBLE);
                    tvFr8.setVisibility(View.VISIBLE);
                    etFr8DZ.setVisibility(View.VISIBLE);
                    tvOcenkaFr8.setVisibility(View.VISIBLE);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                tvFr11.setText("");
                tvFr22.setText("");
                tvFr33.setText("");
                tvFr44.setText("");
                tvFr55.setText("");
                tvFr66.setText("");
                tvFr77.setText("");
                tvFr88.setText("");
            }
        });

        loadText();

        return v;
    }

    private void saveText() {
        String sFr1Dz = etFr1DZ.getText().toString();
        String sFr2Dz = etFr2DZ.getText().toString();
        String sFr3Dz = etFr3DZ.getText().toString();
        String sFr4Dz = etFr4DZ.getText().toString();
        String sFr5Dz = etFr5DZ.getText().toString();
        String sFr6Dz = etFr6DZ.getText().toString();
        String sFr7Dz = etFr7DZ.getText().toString();
        String sFr8Dz = etFr8DZ.getText().toString();

        reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        if(sFr1Dz.length()!=0) {
            reff.child("Fr1Dz").setValue(sFr1Dz);
        }
        else
        {
            reff.child("Fr1Dz").removeValue();
        }

        if(sFr2Dz.length()!=0) {
            reff.child("Fr2Dz").setValue(sFr2Dz);
        }
        else
        {
            reff.child("Fr2Dz").removeValue();
        }

        if(sFr3Dz.length()!=0) {
            reff.child("Fr3Dz").setValue(sFr3Dz);
        }
        else
        {
            reff.child("Fr3Dz").removeValue();
        }

        if(sFr4Dz.length()!=0) {
            reff.child("Fr4Dz").setValue(sFr4Dz);
        }
        else
        {
            reff.child("Fr4Dz").removeValue();
        }

        if(sFr5Dz.length()!=0) {
            reff.child("Fr5Dz").setValue(sFr5Dz);
        }
        else
        {
            reff.child("Fr5Dz").removeValue();
        }

        if(sFr6Dz.length()!=0) {
            reff.child("Fr6Dz").setValue(sFr6Dz);
        }
        else
        {
            reff.child("Fr6Dz").removeValue();
        }

        if(sFr7Dz.length()!=0) {
            reff.child("Fr7Dz").setValue(sFr7Dz);
        }
        else
        {
            reff.child("Fr7Dz").removeValue();
        }

        if(sFr8Dz.length()!=0) {
            reff.child("Fr8Dz").setValue(sFr8Dz);
        }
        else
        {
            reff.child("Fr8Dz").removeValue();
        }
    }


    private void loadText() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sFr1DZ = String.valueOf(snapshot.child("Fr1Dz").getValue());
                String sFr2DZ = String.valueOf(snapshot.child("Fr2Dz").getValue());
                String sFr3DZ = String.valueOf(snapshot.child("Fr3Dz").getValue());
                String sFr4DZ = String.valueOf(snapshot.child("Fr4Dz").getValue());
                String sFr5DZ = String.valueOf(snapshot.child("Fr5Dz").getValue());
                String sFr6DZ = String.valueOf(snapshot.child("Fr6Dz").getValue());
                String sFr7DZ = String.valueOf(snapshot.child("Fr7Dz").getValue());
                String sFr8DZ = String.valueOf(snapshot.child("Fr8Dz").getValue());

                if (snapshot.child("Fr1Dz").exists()) {
                    etFr1DZ.setText(sFr1DZ);
                }
                else
                {
                    etFr1DZ.setText("");
                }

                if (snapshot.child("Fr2Dz").exists()) {
                    etFr2DZ.setText(sFr2DZ);
                }
                else
                {
                    etFr2DZ.setText("");
                }

                if (snapshot.child("Fr3Dz").exists()) {
                    etFr3DZ.setText(sFr3DZ);
                }
                else
                {
                    etFr3DZ.setText("");
                }

                if (snapshot.child("Fr4Dz").exists()) {
                    etFr4DZ.setText(sFr4DZ);
                }
                else
                {
                    etFr4DZ.setText("");
                }

                if (snapshot.child("Fr5Dz").exists()) {
                    etFr5DZ.setText(sFr5DZ);
                }
                else
                {
                    etFr5DZ.setText("");
                }

                if (snapshot.child("Fr6Dz").exists()) {
                    etFr6DZ.setText(sFr6DZ);
                }
                else
                {
                    etFr6DZ.setText("");
                }

                if (snapshot.child("Fr7Dz").exists()) {
                    etFr7DZ.setText(sFr7DZ);
                }
                else
                {
                    etFr7DZ.setText("");
                }

                if (snapshot.child("Fr8Dz").exists()) {
                    etFr8DZ.setText(sFr8DZ);
                }
                else
                {
                    etFr8DZ.setText("");
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