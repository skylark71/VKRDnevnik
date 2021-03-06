package ru.shkolaandstudents.Teacher;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Utilities;

public class TeacherActivitySetTue extends AppCompatActivity {

    Utilities utils = new Utilities(TeacherActivitySetTue.this);

    Button btnWend, btnHelp;
    DatabaseReference ref;
    DatabaseReference ref_save;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_set_tuesday);

        btnHelp = findViewById(R.id.btnTHelp);
        btnWend = findViewById(R.id.btnTAccess);

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String school = sharedPreferences.getString("school", "");

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final TextView tvSetT1Sub = findViewById(R.id.tvSetT1Sub);
        final TextView tvSetT2Sub = findViewById(R.id.tvSetT2Sub);
        final TextView tvSetT3Sub = findViewById(R.id.tvSetT3Sub);
        final TextView tvSetT4Sub = findViewById(R.id.tvSetT4Sub);
        final TextView tvSetT5Sub = findViewById(R.id.tvSetT5Sub);
        final TextView tvSetT6Sub = findViewById(R.id.tvSetT6Sub);
        final TextView tvSetT7Sub = findViewById(R.id.tvSetT7Sub);
        final TextView tvSetT8Sub = findViewById(R.id.tvSetT8Sub);

        final TextView tvSetT1Class = findViewById(R.id.tvSetT1Class);
        final TextView tvSetT2Class = findViewById(R.id.tvSetT2Class);
        final TextView tvSetT3Class = findViewById(R.id.tvSetT3Class);
        final TextView tvSetT4Class = findViewById(R.id.tvSetT4Class);
        final TextView tvSetT5Class = findViewById(R.id.tvSetT5Class);
        final TextView tvSetT6Class = findViewById(R.id.tvSetT6Class);
        final TextView tvSetT7Class = findViewById(R.id.tvSetT7Class);
        final TextView tvSetT8Class = findViewById(R.id.tvSetT8Class);

        ImageView delSetT1Sub = findViewById(R.id.delSetT1Sub);
        delSetT1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T1Sub").removeValue();
                ref_save.child("T1Class").removeValue();
                tvSetT1Sub.setText(R.string.SetSub1);
                tvSetT1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetT2Sub = findViewById(R.id.delSetT2Sub);
        delSetT2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T2Sub").removeValue();
                ref_save.child("T2Class").removeValue();
                tvSetT2Sub.setText(R.string.SetSub2);
                tvSetT2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetT3Sub = findViewById(R.id.delSetT3Sub);
        delSetT3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T3Sub").removeValue();
                ref_save.child("T3Class").removeValue();
                tvSetT3Sub.setText(R.string.SetSub3);
                tvSetT3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetT4Sub = findViewById(R.id.delSetT4Sub);
        delSetT4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T4Sub").removeValue();
                ref_save.child("T4Class").removeValue();
                tvSetT4Sub.setText(R.string.SetSub4);
                tvSetT4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetT5Sub = findViewById(R.id.delSetT5Sub);
        delSetT5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T5Sub").removeValue();
                ref_save.child("T5Class").removeValue();
                tvSetT5Sub.setText(R.string.SetSub5);
                tvSetT5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetT6Sub = findViewById(R.id.delSetT6Sub);
        delSetT6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T6Sub").removeValue();
                ref_save.child("T6Class").removeValue();
                tvSetT6Sub.setText(R.string.SetSub6);
                tvSetT6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetT7Sub = findViewById(R.id.delSetT7Sub);
        delSetT7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T7Sub").removeValue();
                ref_save.child("T7Class").removeValue();
                tvSetT7Sub.setText(R.string.SetSub7);
                tvSetT7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetT8Sub = findViewById(R.id.delSetT8Sub);
        delSetT8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("T8Sub").removeValue();
                ref_save.child("T8Class").removeValue();
                tvSetT8Sub.setText(R.string.SetSub8);
                tvSetT8Class.setText(R.string.SetClass8);
            }
        });

        ref_save = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        ref_save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String T1Sub = String.valueOf(snapshot.child("T1Sub").getValue());
                String T2Sub = String.valueOf(snapshot.child("T2Sub").getValue());
                String T3Sub = String.valueOf(snapshot.child("T3Sub").getValue());
                String T4Sub = String.valueOf(snapshot.child("T4Sub").getValue());
                String T5Sub = String.valueOf(snapshot.child("T5Sub").getValue());
                String T6Sub = String.valueOf(snapshot.child("T6Sub").getValue());
                String T7Sub = String.valueOf(snapshot.child("T7Sub").getValue());
                String T8Sub = String.valueOf(snapshot.child("T8Sub").getValue());

                String T1Class = String.valueOf(snapshot.child("T1Class").getValue());
                String T2Class = String.valueOf(snapshot.child("T2Class").getValue());
                String T3Class = String.valueOf(snapshot.child("T3Class").getValue());
                String T4Class = String.valueOf(snapshot.child("T4Class").getValue());
                String T5Class = String.valueOf(snapshot.child("T5Class").getValue());
                String T6Class = String.valueOf(snapshot.child("T6Class").getValue());
                String T7Class = String.valueOf(snapshot.child("T7Class").getValue());
                String T8Class = String.valueOf(snapshot.child("T8Class").getValue());

                if (!snapshot.child("T1Sub").exists()) {
                    tvSetT1Sub.setText(R.string.SetSub1);
                } else {
                    tvSetT1Sub.setText(T1Sub);
                }

                if (!snapshot.child("T2Sub").exists()) {
                    tvSetT2Sub.setText(R.string.SetSub2);
                } else {
                    tvSetT2Sub.setText(T2Sub);
                }

                if (!snapshot.child("T3Sub").exists()) {
                    tvSetT3Sub.setText(R.string.SetSub3);
                } else {
                    tvSetT3Sub.setText(T3Sub);
                }

                if (!snapshot.child("T4Sub").exists()) {
                    tvSetT4Sub.setText(R.string.SetSub4);
                } else {
                    tvSetT4Sub.setText(T4Sub);
                }

                if (!snapshot.child("T5Sub").exists()) {
                    tvSetT5Sub.setText(R.string.SetSub5);
                } else {
                    tvSetT5Sub.setText(T5Sub);
                }

                if (!snapshot.child("T6Sub").exists()) {
                    tvSetT6Sub.setText(R.string.SetSub6);
                } else {
                    tvSetT6Sub.setText(T6Sub);
                }

                if (!snapshot.child("T7Sub").exists()) {
                    tvSetT7Sub.setText(R.string.SetSub7);
                } else {
                    tvSetT7Sub.setText(T7Sub);
                }

                if (!snapshot.child("T8Sub").exists()) {
                    tvSetT8Sub.setText(R.string.SetSub8);
                } else {
                    tvSetT8Sub.setText(T8Sub);
                }

                if (!snapshot.child("T1Class").exists()) {
                    tvSetT1Class.setText(R.string.SetClass1);
                } else {
                    tvSetT1Class.setText(T1Class);
                }

                if (!snapshot.child("T2Class").exists()) {
                    tvSetT2Class.setText(R.string.SetClass2);
                } else {
                    tvSetT2Class.setText(T2Class);
                }

                if (!snapshot.child("T3Class").exists()) {
                    tvSetT3Class.setText(R.string.SetClass3);
                } else {
                    tvSetT3Class.setText(T3Class);
                }

                if (!snapshot.child("T4Class").exists()) {
                    tvSetT4Class.setText(R.string.SetClass4);
                } else {
                    tvSetT4Class.setText(T4Class);
                }

                if (!snapshot.child("T5Class").exists()) {
                    tvSetT5Class.setText(R.string.SetClass5);
                } else {
                    tvSetT5Class.setText(T5Class);
                }

                if (!snapshot.child("T6Class").exists()) {
                    tvSetT6Class.setText(R.string.SetClass6);
                } else {
                    tvSetT6Class.setText(T6Class);
                }

                if (!snapshot.child("T7Class").exists()) {
                    tvSetT7Class.setText(R.string.SetClass7);
                } else {
                    tvSetT7Class.setText(T7Class);
                }

                if (!snapshot.child("T8Class").exists()) {
                    tvSetT8Class.setText(R.string.SetClass8);
                } else {
                    tvSetT8Class.setText(T8Class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference ref1 = database.getReference(school);
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int j = 0;
                int i = 0;
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String name_school = ds.getKey();
                    j++;
                }

                final String[] strClass = new String[j];
                //strClass[0] = "??????????";
                for (DataSnapshot ds1 : snapshot.getChildren()) {
                    String name_school = ds1.getKey();
                    strClass[i] = name_school;
                    i++;
                }

                final ArrayAdapter arrayAdapterClass = new ArrayAdapter(TeacherActivitySetTue.this, android.R.layout.simple_spinner_item, strClass);

                {
                    /**
                     * ?????????????????????????? ??????????????
                     * */
                    tvSetT1Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 1 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT1Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T1Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT2Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 2 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT2Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T2Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT3Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 3 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT3Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T3Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT4Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 4 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT4Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T4Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT5Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 5 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT5Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T5Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT6Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 6 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT6Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T6Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT7Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 7 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT7Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T7Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetT8Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("???????????????? 8 ??????????");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetT8Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("T8Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Value");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int ii = 0;
                int jj = 0;

                for (DataSnapshot ds : snapshot.getChildren()) {
                    String str_sub = ds.child("Sub").getValue(String.class);
                    jj++;
                }

                String[] strSub = new String[jj];
                //strSub[0]= "??????????????";

                for (DataSnapshot ds : snapshot.getChildren()) {
                    String str_sub = ds.child("Sub").getValue(String.class);
                    //strSub[i+1] = str_sub;
                    strSub[ii] = str_sub;
                    ii++;
                }

                int n = strSub.length;
                for (int i = 0, m = 0; i != n; i++, n = m) {
                    for (int j = m = i + 1; j != n; j++) {
                        if (!strSub[j].equals(strSub[i])) {
                            if (m != j) strSub[m] = strSub[j];
                            m++;
                        }
                    }
                }

                Arrays.sort(strSub);

                if (n != strSub.length) {
                    String[] b = new String[n];
                    for (int i = 0; i < n; i++) b[i] = strSub[i];

                    strSub = b;
                }

                final ArrayAdapter arrayAdapterSub = new ArrayAdapter(TeacherActivitySetTue.this, android.R.layout.simple_spinner_item, strSub);

                /**
                 * ?????????????????????????? ??????????????????
                 * */
                tvSetT1Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 1 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT1Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T1Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT2Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 2 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT2Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T2Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT3Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 3 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT3Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T3Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT4Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 4 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT4Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T4Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT5Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 5 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT5Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T5Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT6Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 6 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT6Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T6Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT7Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 7 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT7Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T7Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetT8Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetTue.this, R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("???????????????? 8 ??????????????");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetTue.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetT8Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("T8Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //utils.switchFragment(TeacherActivitySetTue.this, new TeacherFragmentSettingStudy());
                Intent intent = new Intent(TeacherActivitySetTue.this, TeacherMainActivity.class);
                startActivity(intent);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new TapTargetSequence(TeacherActivitySetTue.this)
                        .targets(
                                TapTarget.forView(findViewById(R.id.etT1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(findViewById(R.id.btnTAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
                        }).start();*/
            }
        });
    }
}
