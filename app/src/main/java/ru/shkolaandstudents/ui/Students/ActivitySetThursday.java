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

public class ActivitySetThursday extends AppCompatActivity {

    Button btnFri,btnHelp;
    TextView etTh1,etTh2,etTh3,etTh4,etTh5,etTh6,etTh7,etTh8;
    TextView title;
    DatabaseReference reff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_thursday);

        btnHelp = findViewById(R.id.btnThHelp);
        btnFri = findViewById(R.id.btnThAccess);
        etTh1 = findViewById(R.id.etTh1);
        etTh2 = findViewById(R.id.etTh2);
        etTh3 = findViewById(R.id.etTh3);
        etTh4 = findViewById(R.id.etTh4);
        etTh5 = findViewById(R.id.etTh5);
        etTh6 = findViewById(R.id.etTh6);
        etTh7 = findViewById(R.id.etTh7);
        etTh8 = findViewById(R.id.etTh8);
        title = findViewById(R.id.tvThRasp);
        title.setText(getResources().getString(R.string.change_rasp_th));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sTh1 = String.valueOf(snapshot.child("SubTh1").getValue());
                String sTh2 = String.valueOf(snapshot.child("SubTh2").getValue());
                String sTh3 = String.valueOf(snapshot.child("SubTh3").getValue());
                String sTh4 = String.valueOf(snapshot.child("SubTh4").getValue());
                String sTh5 = String.valueOf(snapshot.child("SubTh5").getValue());
                String sTh6 = String.valueOf(snapshot.child("SubTh6").getValue());
                String sTh7 = String.valueOf(snapshot.child("SubTh7").getValue());
                String sTh8 = String.valueOf(snapshot.child("SubTh8").getValue());

                if (snapshot.child("SubTh1").exists()) {
                    etTh1.setText(sTh1);
                }
                else
                {
                    etTh1.setText(R.string.SetSub1);
                }

                if (snapshot.child("SubTh2").exists()) {
                    etTh2.setText(sTh2);
                }
                else
                {
                    etTh2.setText(R.string.SetSub2);
                }

                if (snapshot.child("SubTh3").exists()) {
                    etTh3.setText(sTh3);
                }
                else
                {
                    etTh3.setText(R.string.SetSub3);
                }

                if (snapshot.child("SubTh4").exists()) {
                    etTh4.setText(sTh4);
                }
                else
                {
                    etTh4.setText(R.string.SetSub4);
                }

                if (snapshot.child("SubTh5").exists()) {
                    etTh5.setText(sTh5);
                }
                else
                {
                    etTh5.setText(R.string.SetSub5);
                }

                if (snapshot.child("SubTh6").exists()) {
                    etTh6.setText(sTh6);
                }
                else
                {
                    etTh6.setText(R.string.SetSub6);
                }

                if (snapshot.child("SubTh7").exists()) {
                    etTh7.setText(sTh7);
                }
                else
                {
                    etTh7.setText(R.string.SetSub7);
                }

                if (snapshot.child("SubTh8").exists()) {
                    etTh8.setText(sTh8);
                }
                else
                {
                    etTh8.setText(R.string.SetSub8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(ActivitySetThursday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etTh1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnThAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        etTh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 1 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh1.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etTh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 2 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh2.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etTh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 3 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh3.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etTh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 4 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh4.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etTh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 5 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh5.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etTh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 6 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh6.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etTh7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 7 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh7.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        etTh8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetThursday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("Выберите 8 предмет");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetThursday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetThursday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etTh8.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ImageView delTh1Sub = findViewById(R.id.delTh1Sub);
        delTh1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh1").removeValue();
                etTh1.setText(R.string.SetSub1);
            }
        });

        ImageView delTh2Sub = findViewById(R.id.delTh2Sub);
        delTh2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh2").removeValue();
                etTh2.setText(R.string.SetSub2);
            }
        });

        ImageView delTh3Sub = findViewById(R.id.delTh3Sub);
        delTh3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh3").removeValue();
                etTh3.setText(R.string.SetSub3);
            }
        });

        ImageView delTh4Sub = findViewById(R.id.delTh4Sub);
        delTh4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh4").removeValue();
                etTh4.setText(R.string.SetSub4);
            }
        });

        ImageView delTh5Sub = findViewById(R.id.delTh5Sub);
        delTh5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh5").removeValue();
                etTh5.setText(R.string.SetSub5);
            }
        });

        ImageView delTh6Sub = findViewById(R.id.delTh6Sub);
        delTh6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh6").removeValue();
                etTh6.setText(R.string.SetSub6);
            }
        });

        ImageView delTh7Sub = findViewById(R.id.delTh7Sub);
        delTh7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh7").removeValue();
                etTh7.setText(R.string.SetSub7);
            }
        });

        ImageView delTh8Sub = findViewById(R.id.delTh8Sub);
        delTh8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubTh8").removeValue();
                etTh8.setText(R.string.SetSub8);
            }
        });

        btnFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Th1 = etTh1.getText().toString();
                String Th2 = etTh2.getText().toString();
                String Th3 = etTh3.getText().toString();
                String Th4 = etTh4.getText().toString();
                String Th5 = etTh5.getText().toString();
                String Th6 = etTh6.getText().toString();
                String Th7 = etTh7.getText().toString();
                String Th8 = etTh8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
                if(Th1.equals("Выберите предмет") || Th1.equals("1. Выберите предмет")) {
                    reff.child("SubTh1").removeValue();
                }
                else
                {
                    reff.child("SubTh1").setValue(Th1);
                }

                if(Th2.equals("Выберите предмет") || Th2.equals("2. Выберите предмет")) {
                    reff.child("SubTh2").removeValue();
                }
                else
                {
                    reff.child("SubTh2").setValue(Th2);
                }

                if(Th3.equals("Выберите предмет") || Th3.equals("3. Выберите предмет")) {
                    reff.child("SubTh3").removeValue();
                }
                else
                {
                    reff.child("SubTh3").setValue(Th3);
                }

                if(Th4.equals("Выберите предмет") || Th4.equals("4. Выберите предмет")) {
                    reff.child("SubTh4").removeValue();
                }
                else
                {
                    reff.child("SubTh4").setValue(Th4);
                }

                if(Th5.equals("Выберите предмет") || Th5.equals("5. Выберите предмет")) {
                    reff.child("SubTh5").removeValue();
                }
                else
                {
                    reff.child("SubTh5").setValue(Th5);
                }

                if(Th6.equals("Выберите предмет") || Th6.equals("6. Выберите предмет")) {
                    reff.child("SubTh6").removeValue();
                }
                else
                {
                    reff.child("SubTh6").setValue(Th6);
                }

                if(Th7.equals("Выберите предмет") || Th7.equals("7. Выберите предмет")) {
                    reff.child("SubTh7").removeValue();
                }
                else
                {
                    reff.child("SubTh7").setValue(Th7);
                }

                if(Th8.equals("Выберите предмет") || Th8.equals("8. Выберите предмет")) {
                    reff.child("SubTh8").removeValue();
                }
                else
                {
                    reff.child("SubTh8").setValue(Th8);
                }

                Intent intent = new Intent(ActivitySetThursday.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
