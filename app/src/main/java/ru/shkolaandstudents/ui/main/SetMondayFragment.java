package ru.shkolaandstudents.ui.main;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
import ru.shkolaandstudents.RecyclerViewTeacher.TeacherActivityCreateClassAndSubList;


public class SetMondayFragment extends Fragment implements OnBackPressedListener {

    Button btnTuesday,btnHelp;
    TextView etM1,etM2,etM3,etM4,etM5,etM6,etM7,etM8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_monday, container, false);
        btnTuesday = v.findViewById(R.id.btnMAccess);
        btnHelp = v.findViewById(R.id.btnMHelp);
        etM1 = v.findViewById(R.id.etM1);
        etM2 = v.findViewById(R.id.etM2);
        etM3 = v.findViewById(R.id.etM3);
        etM4 = v.findViewById(R.id.etM4);
        etM5 = v.findViewById(R.id.etM5);
        etM6 = v.findViewById(R.id.etM6);
        etM7 = v.findViewById(R.id.etM7);
        etM8 = v.findViewById(R.id.etM8);
        title = v.findViewById(R.id.tvMRasp);
        title.setText(getResources().getString(R.string.change_rasp_m));
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sM1 = String.valueOf(snapshot.child("SubM1").getValue());
                String sM2 = String.valueOf(snapshot.child("SubM2").getValue());
                String sM3 = String.valueOf(snapshot.child("SubM3").getValue());
                String sM4 = String.valueOf(snapshot.child("SubM4").getValue());
                String sM5 = String.valueOf(snapshot.child("SubM5").getValue());
                String sM6 = String.valueOf(snapshot.child("SubM6").getValue());
                String sM7 = String.valueOf(snapshot.child("SubM7").getValue());
                String sM8 = String.valueOf(snapshot.child("SubM8").getValue());

                if (snapshot.child("SubM1").exists()) {
                    etM1.setText(sM1);
                }
                else
                {
                    etM1.setText(R.string.SetSub1);
                }

                if (snapshot.child("SubM2").exists()) {
                    etM2.setText(sM2);
                }
                else
                {
                    etM2.setText(R.string.SetSub2);
                }

                if (snapshot.child("SubM3").exists()) {
                    etM3.setText(sM3);
                }
                else
                {
                    etM3.setText(R.string.SetSub3);
                }

                if (snapshot.child("SubM4").exists()) {
                    etM4.setText(sM4);
                }
                else
                {
                    etM4.setText(R.string.SetSub4);
                }

                if (snapshot.child("SubM5").exists()) {
                    etM5.setText(sM5);
                }
                else
                {
                    etM5.setText(R.string.SetSub5);
                }

                if (snapshot.child("SubM6").exists()) {
                    etM6.setText(sM6);
                }
                else
                {
                    etM6.setText(R.string.SetSub6);
                }

                if (snapshot.child("SubM7").exists()) {
                    etM7.setText(sM7);
                }
                else
                {
                    etM7.setText(R.string.SetSub7);
                }
                
                if (snapshot.child("SubM8").exists()) {
                    etM8.setText(sM8);
                }
                else
                {
                    etM8.setText(R.string.SetSub8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etM1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnMAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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


        etM1.setOnClickListener(new View.OnClickListener() {
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
                        etM1.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etM2.setOnClickListener(new View.OnClickListener() {
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
                        etM2.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etM3.setOnClickListener(new View.OnClickListener() {
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
                        etM3.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etM4.setOnClickListener(new View.OnClickListener() {
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
                        etM4.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etM5.setOnClickListener(new View.OnClickListener() {
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
                        etM5.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etM6.setOnClickListener(new View.OnClickListener() {
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
                        etM6.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etM7.setOnClickListener(new View.OnClickListener() {
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
                        etM7.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        etM8.setOnClickListener(new View.OnClickListener() {
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
                        etM8.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("M7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ImageView delM1Sub = v.findViewById(R.id.delM1Sub);
        delM1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM1").removeValue();
                etM1.setText(R.string.SetSub1);
            }
        });

        ImageView delM2Sub = v.findViewById(R.id.delM2Sub);
        delM2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM2").removeValue();
                etM2.setText(R.string.SetSub2);
            }
        });

        ImageView delM3Sub = v.findViewById(R.id.delM3Sub);
        delM3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM3").removeValue();
                etM3.setText(R.string.SetSub3);
            }
        });

        ImageView delM4Sub = v.findViewById(R.id.delM4Sub);
        delM4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM4").removeValue();
                etM4.setText(R.string.SetSub4);
            }
        });

        ImageView delM5Sub = v.findViewById(R.id.delM5Sub);
        delM5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM5").removeValue();
                etM5.setText(R.string.SetSub5);
            }
        });

        ImageView delM6Sub = v.findViewById(R.id.delM6Sub);
        delM6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM6").removeValue();
                etM6.setText(R.string.SetSub6);
            }
        });

        ImageView delM7Sub = v.findViewById(R.id.delM7Sub);
        delM7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM7").removeValue();
                etM7.setText(R.string.SetSub7);
            }
        });

        ImageView delM8Sub = v.findViewById(R.id.delM8Sub);
        delM8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubM8").removeValue();
                etM8.setText(R.string.SetSub8);
            }
        });


        btnTuesday.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String M1 = etM1.getText().toString();
                String M2 = etM2.getText().toString();
                String M3 = etM3.getText().toString();
                String M4 = etM4.getText().toString();
                String M5 = etM5.getText().toString();
                String M6 = etM6.getText().toString();
                String M7 = etM7.getText().toString();
                String M8 = etM8.getText().toString();


                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
                if(M1.equals("Выберите предмет") || M1.equals("1. Выберите предмет")) {
                    reff.child("SubM1").removeValue();
                }
                else
                {
                    reff.child("SubM1").setValue(M1);
                }

                if(M2.equals("Выберите предмет") || M2.equals("2. Выберите предмет")) {
                    reff.child("SubM2").removeValue();
                }
                else
                {
                    reff.child("SubM2").setValue(M2);
                }

                if(M3.equals("Выберите предмет") || M3.equals("3. Выберите предмет")) {
                    reff.child("SubM3").removeValue();
                }
                else
                {
                    reff.child("SubM3").setValue(M3);
                }

                if(M4.equals("Выберите предмет") || M4.equals("4. Выберите предмет")) {
                    reff.child("SubM4").removeValue();
                }
                else
                {
                    reff.child("SubM4").setValue(M4);
                }

                if(M5.equals("Выберите предмет") || M5.equals("5. Выберите предмет")) {
                    reff.child("SubM5").removeValue();
                }
                else
                {
                    reff.child("SubM5").setValue(M5);
                }

                if(M6.equals("Выберите предмет") || M6.equals("6. Выберите предмет")) {
                    reff.child("SubM6").removeValue();
                }
                else
                {
                    reff.child("SubM6").setValue(M6);
                }

                if(M7.equals("Выберите предмет") || M7.equals("7. Выберите предмет")) {
                    reff.child("SubM7").removeValue();
                }
                else
                {
                    reff.child("SubM7").setValue(M7);
                }

                if(M8.equals("Выберите предмет") || M8.equals("8. Выберите предмет")) {
                    reff.child("SubM8").removeValue();
                }
                else
                {
                    reff.child("SubM8").setValue(M8);
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