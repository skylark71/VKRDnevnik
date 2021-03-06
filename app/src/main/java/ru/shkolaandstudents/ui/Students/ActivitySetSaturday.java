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

public class ActivitySetSaturday extends AppCompatActivity {

    Button btnSM,btnHelp;
    TextView etSat1,etSat2,etSat3,etSat4,etSat5,etSat6,etSat7,etSat8;
    TextView title;
    DatabaseReference reff;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_saturday);

        btnHelp = findViewById(R.id.btnSatHelp);
        btnSM = findViewById(R.id.btnSatAccess);
        etSat1 = findViewById(R.id.etSat1);
        etSat2 = findViewById(R.id.etSat2);
        etSat3 = findViewById(R.id.etSat3);
        etSat4 = findViewById(R.id.etSat4);
        etSat5 = findViewById(R.id.etSat5);
        etSat6 = findViewById(R.id.etSat6);
        etSat7 = findViewById(R.id.etSat7);
        etSat8 = findViewById(R.id.etSat8);
        title = findViewById(R.id.tvSatRasp);
        title.setText(getResources().getString(R.string.change_rasp_s));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sSat1 = String.valueOf(snapshot.child("SubSat1").getValue());
                String sSat2 = String.valueOf(snapshot.child("SubSat2").getValue());
                String sSat3 = String.valueOf(snapshot.child("SubSat3").getValue());
                String sSat4 = String.valueOf(snapshot.child("SubSat4").getValue());
                String sSat5 = String.valueOf(snapshot.child("SubSat5").getValue());
                String sSat6 = String.valueOf(snapshot.child("SubSat6").getValue());
                String sSat7 = String.valueOf(snapshot.child("SubSat7").getValue());
                String sSat8 = String.valueOf(snapshot.child("SubSat8").getValue());

                if (snapshot.child("SubSat1").exists()) {
                    etSat1.setText(sSat1);
                }
                else
                {
                    etSat1.setText(R.string.SetSub1);
                }

                if (snapshot.child("SubSat2").exists()) {
                    etSat2.setText(sSat2);
                }
                else
                {
                    etSat2.setText(R.string.SetSub2);
                }

                if (snapshot.child("SubSat3").exists()) {
                    etSat3.setText(sSat3);
                }
                else
                {
                    etSat3.setText(R.string.SetSub3);
                }

                if (snapshot.child("SubSat4").exists()) {
                    etSat4.setText(sSat4);
                }
                else
                {
                    etSat4.setText(R.string.SetSub4);
                }

                if (snapshot.child("SubSat5").exists()) {
                    etSat5.setText(sSat5);
                }
                else
                {
                    etSat5.setText(R.string.SetSub5);
                }

                if (snapshot.child("SubSat6").exists()) {
                    etSat6.setText(sSat6);
                }
                else
                {
                    etSat6.setText(R.string.SetSub6);
                }

                if (snapshot.child("SubSat7").exists()) {
                    etSat7.setText(sSat7);
                }
                else
                {
                    etSat7.setText(R.string.SetSub7);
                }

                if (snapshot.child("SubSat8").exists()) {
                    etSat8.setText(sSat8);
                }
                else
                {
                    etSat8.setText(R.string.SetSub8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        etSat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 1 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat1.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etSat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 2 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat2.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etSat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 3 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat3.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etSat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 4 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat4.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etSat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 5 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat5.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etSat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 6 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat6.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        etSat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 7 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat7.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        etSat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySetSaturday.this,R.style.AlertDialogTheme);
                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                builder.setTitle("???????????????? 8 ??????????????");
                builder.setView(view);
                final Spinner spinner = view.findViewById(R.id.spinner1);

                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivitySetSaturday.this
                        ,android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.School_subject));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivitySetSaturday.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        etSat8.setText(spinner.getSelectedItem().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ImageView delSat1Sub = findViewById(R.id.delSat1Sub);
        delSat1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat1").removeValue();
                etSat1.setText(R.string.SetSub1);
            }
        });

        ImageView delSat2Sub = findViewById(R.id.delSat2Sub);
        delSat2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat2").removeValue();
                etSat2.setText(R.string.SetSub2);
            }
        });

        ImageView delSat3Sub = findViewById(R.id.delSat3Sub);
        delSat3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat3").removeValue();
                etSat3.setText(R.string.SetSub3);
            }
        });

        ImageView delSat4Sub = findViewById(R.id.delSat4Sub);
        delSat4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat4").removeValue();
                etSat4.setText(R.string.SetSub4);
            }
        });

        ImageView delSat5Sub = findViewById(R.id.delSat5Sub);
        delSat5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat5").removeValue();
                etSat5.setText(R.string.SetSub5);
            }
        });

        ImageView delSat6Sub = findViewById(R.id.delSat6Sub);
        delSat6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat6").removeValue();
                etSat6.setText(R.string.SetSub6);
            }
        });

        ImageView delSat7Sub = findViewById(R.id.delSat7Sub);
        delSat7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat7").removeValue();
                etSat7.setText(R.string.SetSub7);
            }
        });

        ImageView delSat8Sub = findViewById(R.id.delSat8Sub);
        delSat8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff.child("SubSat8").removeValue();
                etSat8.setText(R.string.SetSub8);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(ActivitySetSaturday.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etSat1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnSatAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sat1 = etSat1.getText().toString();
                String Sat2 = etSat2.getText().toString();
                String Sat3 = etSat3.getText().toString();
                String Sat4 = etSat4.getText().toString();
                String Sat5 = etSat5.getText().toString();
                String Sat6 = etSat6.getText().toString();
                String Sat7 = etSat7.getText().toString();
                String Sat8 = etSat8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
                if(Sat1.equals("???????????????? ??????????????") || Sat1.equals("1. ???????????????? ??????????????")) {
                    reff.child("SubSat1").removeValue();
                }
                else
                {
                    reff.child("SubSat1").setValue(Sat1);
                }

                if(Sat2.equals("???????????????? ??????????????") || Sat2.equals("2. ???????????????? ??????????????")) {
                    reff.child("SubSat2").removeValue();
                }
                else
                {
                    reff.child("SubSat2").setValue(Sat2);
                }

                if(Sat3.equals("???????????????? ??????????????") || Sat3.equals("3. ???????????????? ??????????????")) {
                    reff.child("SubSat3").removeValue();
                }
                else
                {
                    reff.child("SubSat3").setValue(Sat3);
                }

                if(Sat4.equals("???????????????? ??????????????") || Sat4.equals("4. ???????????????? ??????????????")) {
                    reff.child("SubSat4").removeValue();
                }
                else
                {
                    reff.child("SubSat4").setValue(Sat4);
                }

                if(Sat5.equals("???????????????? ??????????????") || Sat5.equals("5. ???????????????? ??????????????")) {
                    reff.child("SubSat5").removeValue();
                }
                else
                {
                    reff.child("SubSat5").setValue(Sat5);
                }

                if(Sat6.equals("???????????????? ??????????????") || Sat6.equals("6. ???????????????? ??????????????")) {
                    reff.child("SubSat6").removeValue();
                }
                else
                {
                    reff.child("SubSat6").setValue(Sat6);
                }

                if(Sat7.equals("???????????????? ??????????????") || Sat7.equals("7. ???????????????? ??????????????")) {
                    reff.child("SubSat7").removeValue();
                }
                else
                {
                    reff.child("SubSat7").setValue(Sat7);
                }

                if(Sat8.equals("???????????????? ??????????????") || Sat8.equals("8. ???????????????? ??????????????")) {
                    reff.child("SubSat8").removeValue();
                }
                else
                {
                    reff.child("SubSat8").setValue(Sat8);
                }

                Intent intent = new Intent(ActivitySetSaturday.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
