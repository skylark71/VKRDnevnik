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

public class SetWednesdayFragment extends Fragment implements OnBackPressedListener {

    Button btnThurs,btnHelp;
    TextView etW1,etW2,etW3,etW4,etW5,etW6,etW7,etW8;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_wednesday, container, false);

        btnHelp = v.findViewById(R.id.btnWHelp);
        btnThurs = v.findViewById(R.id.btnWAccess);
        etW1 = v.findViewById(R.id.etW1);
        etW2 = v.findViewById(R.id.etW2);
        etW3 = v.findViewById(R.id.etW3);
        etW4 = v.findViewById(R.id.etW4);
        etW5 = v.findViewById(R.id.etW5);
        etW6 = v.findViewById(R.id.etW6);
        etW7 = v.findViewById(R.id.etW7);
        etW8 = v.findViewById(R.id.etW8);
        title = v.findViewById(R.id.tvWRasp);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sW1 = String.valueOf(snapshot.child("SubW1").getValue());
                String sW2 = String.valueOf(snapshot.child("SubW2").getValue());
                String sW3 = String.valueOf(snapshot.child("SubW3").getValue());
                String sW4 = String.valueOf(snapshot.child("SubW4").getValue());
                String sW5 = String.valueOf(snapshot.child("SubW5").getValue());
                String sW6 = String.valueOf(snapshot.child("SubW6").getValue());
                String sW7 = String.valueOf(snapshot.child("SubW7").getValue());
                String sW8 = String.valueOf(snapshot.child("SubW8").getValue());

                if (snapshot.child("SubW1").exists()) {
                    etW1.setText(sW1);
                }
                else
                {
                    etW1.setText(R.string.SetSub1);
                }

                if (snapshot.child("SubW2").exists()) {
                    etW2.setText(sW2);
                }
                else
                {
                    etW2.setText(R.string.SetSub2);
                }

                if (snapshot.child("SubW3").exists()) {
                    etW3.setText(sW3);
                }
                else
                {
                    etW3.setText(R.string.SetSub3);
                }

                if (snapshot.child("SubW4").exists()) {
                    etW4.setText(sW4);
                }
                else
                {
                    etW4.setText(R.string.SetSub4);
                }

                if (snapshot.child("SubW5").exists()) {
                    etW5.setText(sW5);
                }
                else
                {
                    etW5.setText(R.string.SetSub5);
                }

                if (snapshot.child("SubW6").exists()) {
                    etW6.setText(sW6);
                }
                else
                {
                    etW6.setText(R.string.SetSub6);
                }

                if (snapshot.child("SubW7").exists()) {
                    etW7.setText(sW7);
                }
                else
                {
                    etW7.setText(R.string.SetSub7);
                }

                if (snapshot.child("SubW8").exists()) {
                    etW8.setText(sW8);
                }
                else
                {
                    etW8.setText(R.string.SetSub8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        etW1.setOnClickListener(new View.OnClickListener() {
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
                        etW1.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etW2.setOnClickListener(new View.OnClickListener() {
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
                        etW2.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etW3.setOnClickListener(new View.OnClickListener() {
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
                        etW3.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etW4.setOnClickListener(new View.OnClickListener() {
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
                        etW4.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etW5.setOnClickListener(new View.OnClickListener() {
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
                        etW5.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etW6.setOnClickListener(new View.OnClickListener() {
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
                        etW6.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etW7.setOnClickListener(new View.OnClickListener() {
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
                        etW7.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        etW8.setOnClickListener(new View.OnClickListener() {
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
                        etW8.setText(spinner.getSelectedItem().toString());
                        /*String str = spinner.getSelectedItem().toString();
                        ref_save.child("W7Sub").setValue(str);*/
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ImageView delW1Sub = v.findViewById(R.id.delW1Sub);
        delW1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW1").removeValue();
                etW1.setText(R.string.SetSub1);
            }
        });

        ImageView delW2Sub = v.findViewById(R.id.delW2Sub);
        delW2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW2").removeValue();
                etW2.setText(R.string.SetSub2);
            }
        });

        ImageView delW3Sub = v.findViewById(R.id.delW3Sub);
        delW3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW3").removeValue();
                etW3.setText(R.string.SetSub3);
            }
        });

        ImageView delW4Sub = v.findViewById(R.id.delW4Sub);
        delW4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW4").removeValue();
                etW4.setText(R.string.SetSub4);
            }
        });

        ImageView delW5Sub = v.findViewById(R.id.delW5Sub);
        delW5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW5").removeValue();
                etW5.setText(R.string.SetSub5);
            }
        });

        ImageView delW6Sub = v.findViewById(R.id.delW6Sub);
        delW6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW6").removeValue();
                etW6.setText(R.string.SetSub6);
            }
        });

        ImageView delW7Sub = v.findViewById(R.id.delW7Sub);
        delW7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW7").removeValue();
                etW7.setText(R.string.SetSub7);
            }
        });

        ImageView delW8Sub = v.findViewById(R.id.delW8Sub);
        delW8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.child("SubW8").removeValue();
                etW8.setText(R.string.SetSub8);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etW1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnWAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnThurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String W1 = etW1.getText().toString();
                String W2 = etW2.getText().toString();
                String W3 = etW3.getText().toString();
                String W4 = etW4.getText().toString();
                String W5 = etW5.getText().toString();
                String W6 = etW6.getText().toString();
                String W7 = etW7.getText().toString();
                String W8 = etW8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
                if(W1.equals("Выберите предмет") || W1.equals("1. Выберите предмет")) {
                    reff.child("SubW1").removeValue();
                }
                else
                {
                    reff.child("SubW1").setValue(W1);
                }

                if(W2.equals("Выберите предмет") || W2.equals("2. Выберите предмет")) {
                    reff.child("SubW2").removeValue();
                }
                else
                {
                    reff.child("SubW2").setValue(W2);
                }

                if(W3.equals("Выберите предмет") || W3.equals("3. Выберите предмет")) {
                    reff.child("SubW3").removeValue();
                }
                else
                {
                    reff.child("SubW3").setValue(W3);
                }

                if(W4.equals("Выберите предмет") || W4.equals("4. Выберите предмет")) {
                    reff.child("SubW4").removeValue();
                }
                else
                {
                    reff.child("SubW4").setValue(W4);
                }

                if(W5.equals("Выберите предмет") || W5.equals("5. Выберите предмет")) {
                    reff.child("SubW5").removeValue();
                }
                else
                {
                    reff.child("SubW5").setValue(W5);
                }

                if(W6.equals("Выберите предмет") || W6.equals("6. Выберите предмет")) {
                    reff.child("SubW6").removeValue();
                }
                else
                {
                    reff.child("SubW6").setValue(W6);
                }

                if(W7.equals("Выберите предмет") || W7.equals("7. Выберите предмет")) {
                    reff.child("SubW7").removeValue();
                }
                else
                {
                    reff.child("SubW7").setValue(W7);
                }

                if(W8.equals("Выберите предмет") || W8.equals("8. Выберите предмет")) {
                    reff.child("SubW8").removeValue();
                }
                else
                {
                    reff.child("SubW8").setValue(W8);
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