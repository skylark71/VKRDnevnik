package ru.shkolaandstudents.ui.Students;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.MainActivity;
import ru.shkolaandstudents.R;

public class ActivitySetFriday extends AppCompatActivity {

    Button btnSat,btnHelp;
    TextView etFr1,etFr2,etFr3,etFr4,etFr5,etFr6,etFr7,etFr8;
    TextView title;
    DatabaseReference reff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_friday);

        btnHelp = findViewById(R.id.btnFrHelp);
        btnSat = findViewById(R.id.btnFrAccess);
        etFr1 = findViewById(R.id.etFr1);
        etFr2 = findViewById(R.id.etFr2);
        etFr3 = findViewById(R.id.etFr3);
        etFr4 = findViewById(R.id.etFr4);
        etFr5 = findViewById(R.id.etFr5);
        etFr6 = findViewById(R.id.etFr6);
        etFr7 = findViewById(R.id.etFr7);
        etFr8 = findViewById(R.id.etFr8);
        title = findViewById(R.id.tvFrRasp);
        title.setText(getResources().getString(R.string.change_rasp_f));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sFr1 = String.valueOf(snapshot.child("SubFr1").getValue());
                String sFr2 = String.valueOf(snapshot.child("SubFr2").getValue());
                String sFr3 = String.valueOf(snapshot.child("SubFr3").getValue());
                String sFr4 = String.valueOf(snapshot.child("SubFr4").getValue());
                String sFr5 = String.valueOf(snapshot.child("SubFr5").getValue());
                String sFr6 = String.valueOf(snapshot.child("SubFr6").getValue());
                String sFr7 = String.valueOf(snapshot.child("SubFr7").getValue());
                String sFr8 = String.valueOf(snapshot.child("SubFr8").getValue());

                if (snapshot.child("SubFr1").exists()) {
                    etFr1.setText(sFr1);
                }
                else
                {
                    etFr1.setText(R.string.SetSub1);
                }

                if (snapshot.child("SubFr2").exists()) {
                    etFr2.setText(sFr2);
                }
                else
                {
                    etFr2.setText(R.string.SetSub2);
                }

                if (snapshot.child("SubFr3").exists()) {
                    etFr3.setText(sFr3);
                }
                else
                {
                    etFr3.setText(R.string.SetSub3);
                }

                if (snapshot.child("SubFr4").exists()) {
                    etFr4.setText(sFr4);
                }
                else
                {
                    etFr4.setText(R.string.SetSub4);
                }

                if (snapshot.child("SubFr5").exists()) {
                    etFr5.setText(sFr5);
                }
                else
                {
                    etFr5.setText(R.string.SetSub5);
                }

                if (snapshot.child("SubFr6").exists()) {
                    etFr6.setText(sFr6);
                }
                else
                {
                    etFr6.setText(R.string.SetSub6);
                }

                if (snapshot.child("SubFr7").exists()) {
                    etFr7.setText(sFr7);
                }
                else
                {
                    etFr7.setText(R.string.SetSub7);
                }

                if (snapshot.child("SubFr8").exists()) {
                    etFr8.setText(sFr8);
                }
                else
                {
                    etFr8.setText(R.string.SetSub8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(ActivitySetFriday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etFr1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnFrAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        etFr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 1 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr1.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etFr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 2 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr2.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etFr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 3 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr3.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etFr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 4 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr4.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etFr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 5 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr5.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etFr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 6 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr6.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etFr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 7 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr7.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        etFr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetFriday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 8 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetFriday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetFriday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etFr8.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ImageView delFr1Sub = findViewById(R.id.delFr1Sub);
        delFr1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr1").removeValue();
                etFr1.setText(R.string.SetSub1);
            }
        });

        ImageView delFr2Sub = findViewById(R.id.delFr2Sub);
        delFr2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr2").removeValue();
                etFr2.setText(R.string.SetSub2);
            }
        });

        ImageView delFr3Sub = findViewById(R.id.delFr3Sub);
        delFr3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr3").removeValue();
                etFr3.setText(R.string.SetSub3);
            }
        });

        ImageView delFr4Sub = findViewById(R.id.delFr4Sub);
        delFr4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr4").removeValue();
                etFr4.setText(R.string.SetSub4);
            }
        });

        ImageView delFr5Sub = findViewById(R.id.delFr5Sub);
        delFr5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr5").removeValue();
                etFr5.setText(R.string.SetSub5);
            }
        });

        ImageView delFr6Sub = findViewById(R.id.delFr6Sub);
        delFr6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr6").removeValue();
                etFr6.setText(R.string.SetSub6);
            }
        });

        ImageView delFr7Sub = findViewById(R.id.delFr7Sub);
        delFr7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr7").removeValue();
                etFr7.setText(R.string.SetSub7);
            }
        });

        ImageView delFr8Sub = findViewById(R.id.delFr8Sub);
        delFr8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubFr8").removeValue();
                etFr8.setText(R.string.SetSub8);
            }
        });

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Fr1 = etFr1.getText().toString();
                String Fr2 = etFr2.getText().toString();
                String Fr3 = etFr3.getText().toString();
                String Fr4 = etFr4.getText().toString();
                String Fr5 = etFr5.getText().toString();
                String Fr6 = etFr6.getText().toString();
                String Fr7 = etFr7.getText().toString();
                String Fr8 = etFr8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
                if(Fr1.equals("Выберите предмет") || Fr1.equals("1. Выберите предмет")) {
                    reff.child("SubFr1").removeValue();
                }
                else
                {
                    reff.child("SubFr1").setValue(Fr1);
                }

                if(Fr2.equals("Выберите предмет") || Fr2.equals("2. Выберите предмет")) {
                    reff.child("SubFr2").removeValue();
                }
                else
                {
                    reff.child("SubFr2").setValue(Fr2);
                }

                if(Fr3.equals("Выберите предмет") || Fr3.equals("3. Выберите предмет")) {
                    reff.child("SubFr3").removeValue();
                }
                else
                {
                    reff.child("SubFr3").setValue(Fr3);
                }

                if(Fr4.equals("Выберите предмет") || Fr4.equals("4. Выберите предмет")) {
                    reff.child("SubFr4").removeValue();
                }
                else
                {
                    reff.child("SubFr4").setValue(Fr4);
                }

                if(Fr5.equals("Выберите предмет") || Fr5.equals("5. Выберите предмет")) {
                    reff.child("SubFr5").removeValue();
                }
                else
                {
                    reff.child("SubFr5").setValue(Fr5);
                }

                if(Fr6.equals("Выберите предмет") || Fr6.equals("6. Выберите предмет")) {
                    reff.child("SubFr6").removeValue();
                }
                else
                {
                    reff.child("SubFr6").setValue(Fr6);
                }

                if(Fr7.equals("Выберите предмет") || Fr7.equals("7. Выберите предмет")) {
                    reff.child("SubFr7").removeValue();
                }
                else
                {
                    reff.child("SubFr7").setValue(Fr7);
                }

                if(Fr8.equals("Выберите предмет") || Fr8.equals("8. Выберите предмет")) {
                    reff.child("SubFr8").removeValue();
                }
                else
                {
                    reff.child("SubFr8").setValue(Fr8);
                }

                Intent intent = new Intent(ActivitySetFriday.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
