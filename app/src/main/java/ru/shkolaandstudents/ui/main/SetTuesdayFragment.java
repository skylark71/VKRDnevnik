package ru.shkolaandstudents.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class SetTuesdayFragment extends Fragment implements OnBackPressedListener {

    Button btnWend,btnHelp;
    TextView etT1,etT2,etT3,etT4,etT5,etT6,etT7,etT8;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_tuesday, container, false);

        btnHelp = v.findViewById(R.id.btnTHelp);
        btnWend = v.findViewById(R.id.btnTAccess);
        etT1 = v.findViewById(R.id.etT1);
        etT2 = v.findViewById(R.id.etT2);
        etT3 = v.findViewById(R.id.etT3);
        etT4 = v.findViewById(R.id.etT4);
        etT5 = v.findViewById(R.id.etT5);
        etT6 = v.findViewById(R.id.etT6);
        etT7 = v.findViewById(R.id.etT7);
        etT8 = v.findViewById(R.id.etT8);
        title = v.findViewById(R.id.tvTRasp);
        title.setText(getResources().getString(R.string.change_rasp_t));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sT1 = String.valueOf(snapshot.child("SubT1").getValue());
                String sT2 = String.valueOf(snapshot.child("SubT2").getValue());
                String sT3 = String.valueOf(snapshot.child("SubT3").getValue());
                String sT4 = String.valueOf(snapshot.child("SubT4").getValue());
                String sT5 = String.valueOf(snapshot.child("SubT5").getValue());
                String sT6 = String.valueOf(snapshot.child("SubT6").getValue());
                String sT7 = String.valueOf(snapshot.child("SubT7").getValue());
                String sT8 = String.valueOf(snapshot.child("SubT8").getValue());

                if (snapshot.child("SubT1").exists()) {
                    etT1.setText(sT1);
                }
                else
                {
                    etT1.setText(R.string.SetSub1);
                }

                if (snapshot.child("SubT2").exists()) {
                    etT2.setText(sT2);
                }
                else
                {
                    etT2.setText(R.string.SetSub2);
                }

                if (snapshot.child("SubT3").exists()) {
                    etT3.setText(sT3);
                }
                else
                {
                    etT3.setText(R.string.SetSub3);
                }

                if (snapshot.child("SubT4").exists()) {
                    etT4.setText(sT4);
                }
                else
                {
                    etT4.setText(R.string.SetSub4);
                }

                if (snapshot.child("SubT5").exists()) {
                    etT5.setText(sT5);
                }
                else
                {
                    etT5.setText(R.string.SetSub5);
                }

                if (snapshot.child("SubT6").exists()) {
                    etT6.setText(sT6);
                }
                else
                {
                    etT6.setText(R.string.SetSub6);
                }

                if (snapshot.child("SubT7").exists()) {
                    etT7.setText(sT7);
                }
                else
                {
                    etT7.setText(R.string.SetSub7);
                }

                if (snapshot.child("SubT8").exists()) {
                    etT8.setText(sT8);
                }
                else
                {
                    etT8.setText(R.string.SetSub8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
        etT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 1 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT1.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 2 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT2.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 3 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT3.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 4 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT4.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 5 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT5.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 6 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT6.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etT7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 7 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT7.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        etT8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 8 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity()
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etT8.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("T7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ImageView delT1Sub = v.findViewById(R.id.delT1Sub);
        delT1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT1").removeValue();
                etT1.setText(R.string.SetSub1);
            }
        });

        ImageView delT2Sub = v.findViewById(R.id.delT2Sub);
        delT2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT2").removeValue();
                etT2.setText(R.string.SetSub2);
            }
        });

        ImageView delT3Sub = v.findViewById(R.id.delT3Sub);
        delT3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT3").removeValue();
                etT3.setText(R.string.SetSub3);
            }
        });

        ImageView delT4Sub = v.findViewById(R.id.delT4Sub);
        delT4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT4").removeValue();
                etT4.setText(R.string.SetSub4);
            }
        });

        ImageView delT5Sub = v.findViewById(R.id.delT5Sub);
        delT5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT5").removeValue();
                etT5.setText(R.string.SetSub5);
            }
        });

        ImageView delT6Sub = v.findViewById(R.id.delT6Sub);
        delT6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT6").removeValue();
                etT6.setText(R.string.SetSub6);
            }
        });

        ImageView delT7Sub = v.findViewById(R.id.delT7Sub);
        delT7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT7").removeValue();
                etT7.setText(R.string.SetSub7);
            }
        });

        ImageView delT8Sub = v.findViewById(R.id.delT8Sub);
        delT8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubT8").removeValue();
                etT8.setText(R.string.SetSub8);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etT1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnTAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String T1 = etT1.getText().toString();
                String T2 = etT2.getText().toString();
                String T3 = etT3.getText().toString();
                String T4 = etT4.getText().toString();
                String T5 = etT5.getText().toString();
                String T6 = etT6.getText().toString();
                String T7 = etT7.getText().toString();
                String T8 = etT8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
                if(T1.equals("Выберите предмет") || T1.equals("1. Выберите предмет")) {
                    reff.child("SubT1").removeValue();
                }
                else
                {
                    reff.child("SubT1").setValue(T1);
                }

                if(T2.equals("Выберите предмет") || T2.equals("2. Выберите предмет")) {
                    reff.child("SubT2").removeValue();
                }
                else
                {
                    reff.child("SubT2").setValue(T2);
                }

                if(T3.equals("Выберите предмет") || T3.equals("3. Выберите предмет")) {
                    reff.child("SubT3").removeValue();
                }
                else
                {
                    reff.child("SubT3").setValue(T3);
                }

                if(T4.equals("Выберите предмет") || T4.equals("4. Выберите предмет")) {
                    reff.child("SubT4").removeValue();
                }
                else
                {
                    reff.child("SubT4").setValue(T4);
                }

                if(T5.equals("Выберите предмет") || T5.equals("5. Выберите предмет")) {
                    reff.child("SubT5").removeValue();
                }
                else
                {
                    reff.child("SubT5").setValue(T5);
                }

                if(T6.equals("Выберите предмет") || T6.equals("6. Выберите предмет")) {
                    reff.child("SubT6").removeValue();
                }
                else
                {
                    reff.child("SubT6").setValue(T6);
                }

                if(T7.equals("Выберите предмет") || T7.equals("7. Выберите предмет")) {
                    reff.child("SubT7").removeValue();
                }
                else
                {
                    reff.child("SubT7").setValue(T7);
                }

                if(T8.equals("Выберите предмет") || T8.equals("8. Выберите предмет")) {
                    reff.child("SubT8").removeValue();
                }
                else
                {
                    reff.child("SubT8").setValue(T8);
                }

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SettingsStudyMenuFragment());
                transaction.commit();

            }
        });

        return v;
    }

    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new SettingsStudyMenuFragment());
        transaction.commit();
    }
}