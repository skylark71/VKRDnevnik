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

public class TeacherActivitySetSat extends AppCompatActivity {
    
    Button btnSM,btnHelp;
    DatabaseReference ref;
    DatabaseReference ref_save;

    Utilities utils = new Utilities(TeacherActivitySetSat.this);
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_set_saturday);

        btnHelp = findViewById(R.id.btnSatHelp);
        btnSM = findViewById(R.id.btnSatAccess);

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String school = sharedPreferences.getString("school", "");

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final TextView tvSetSat1Sub = findViewById(R.id.tvSetSat1Sub);
        final TextView tvSetSat2Sub = findViewById(R.id.tvSetSat2Sub);
        final TextView tvSetSat3Sub = findViewById(R.id.tvSetSat3Sub);
        final TextView tvSetSat4Sub = findViewById(R.id.tvSetSat4Sub);
        final TextView tvSetSat5Sub = findViewById(R.id.tvSetSat5Sub);
        final TextView tvSetSat6Sub = findViewById(R.id.tvSetSat6Sub);
        final TextView tvSetSat7Sub = findViewById(R.id.tvSetSat7Sub);
        final TextView tvSetSat8Sub = findViewById(R.id.tvSetSat8Sub);

        final TextView tvSetSat1Class = findViewById(R.id.tvSetSat1Class);
        final TextView tvSetSat2Class = findViewById(R.id.tvSetSat2Class);
        final TextView tvSetSat3Class = findViewById(R.id.tvSetSat3Class);
        final TextView tvSetSat4Class = findViewById(R.id.tvSetSat4Class);
        final TextView tvSetSat5Class = findViewById(R.id.tvSetSat5Class);
        final TextView tvSetSat6Class = findViewById(R.id.tvSetSat6Class);
        final TextView tvSetSat7Class = findViewById(R.id.tvSetSat7Class);
        final TextView tvSetSat8Class = findViewById(R.id.tvSetSat8Class);

        ImageView delSetSat1Sub = findViewById(R.id.delSetSat1Sub);
        delSetSat1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat1Sub").removeValue();
                ref_save.child("Sat1Class").removeValue();
                tvSetSat1Sub.setText(R.string.SetSub1);
                tvSetSat1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetSat2Sub = findViewById(R.id.delSetSat2Sub);
        delSetSat2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat2Sub").removeValue();
                ref_save.child("Sat2Class").removeValue();
                tvSetSat2Sub.setText(R.string.SetSub2);
                tvSetSat2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetSat3Sub = findViewById(R.id.delSetSat3Sub);
        delSetSat3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat3Sub").removeValue();
                ref_save.child("Sat3Class").removeValue();
                tvSetSat3Sub.setText(R.string.SetSub3);
                tvSetSat3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetSat4Sub = findViewById(R.id.delSetSat4Sub);
        delSetSat4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat4Sub").removeValue();
                ref_save.child("Sat4Class").removeValue();
                tvSetSat4Sub.setText(R.string.SetSub4);
                tvSetSat4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetSat5Sub = findViewById(R.id.delSetSat5Sub);
        delSetSat5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat5Sub").removeValue();
                ref_save.child("Sat5Class").removeValue();
                tvSetSat5Sub.setText(R.string.SetSub5);
                tvSetSat5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetSat6Sub = findViewById(R.id.delSetSat6Sub);
        delSetSat6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat6Sub").removeValue();
                ref_save.child("Sat6Class").removeValue();
                tvSetSat6Sub.setText(R.string.SetSub6);
                tvSetSat6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetSat7Sub = findViewById(R.id.delSetSat7Sub);
        delSetSat7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat7Sub").removeValue();
                ref_save.child("Sat7Class").removeValue();
                tvSetSat7Sub.setText(R.string.SetSub7);
                tvSetSat7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetSat8Sub = findViewById(R.id.delSetSat8Sub);
        delSetSat8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Sat8Sub").removeValue();
                ref_save.child("Sat8Class").removeValue();
                tvSetSat8Sub.setText(R.string.SetSub8);
                tvSetSat8Class.setText(R.string.SetClass8);
            }
        });

        ref_save = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");
        ref_save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Sat1Sub = String.valueOf(snapshot.child("Sat1Sub").getValue());
                String Sat2Sub = String.valueOf(snapshot.child("Sat2Sub").getValue());
                String Sat3Sub = String.valueOf(snapshot.child("Sat3Sub").getValue());
                String Sat4Sub = String.valueOf(snapshot.child("Sat4Sub").getValue());
                String Sat5Sub = String.valueOf(snapshot.child("Sat5Sub").getValue());
                String Sat6Sub = String.valueOf(snapshot.child("Sat6Sub").getValue());
                String Sat7Sub = String.valueOf(snapshot.child("Sat7Sub").getValue());
                String Sat8Sub = String.valueOf(snapshot.child("Sat8Sub").getValue());

                String Sat1Class = String.valueOf(snapshot.child("Sat1Class").getValue());
                String Sat2Class = String.valueOf(snapshot.child("Sat2Class").getValue());
                String Sat3Class = String.valueOf(snapshot.child("Sat3Class").getValue());
                String Sat4Class = String.valueOf(snapshot.child("Sat4Class").getValue());
                String Sat5Class = String.valueOf(snapshot.child("Sat5Class").getValue());
                String Sat6Class = String.valueOf(snapshot.child("Sat6Class").getValue());
                String Sat7Class = String.valueOf(snapshot.child("Sat7Class").getValue());
                String Sat8Class = String.valueOf(snapshot.child("Sat8Class").getValue());

                if(!snapshot.child("Sat1Sub").exists())
                {
                    tvSetSat1Sub.setText(R.string.SetSub1);
                }
                else
                {
                    tvSetSat1Sub.setText(Sat1Sub);
                }

                if(!snapshot.child("Sat2Sub").exists())
                {
                    tvSetSat2Sub.setText(R.string.SetSub2);
                }
                else
                {
                    tvSetSat2Sub.setText(Sat2Sub);
                }

                if(!snapshot.child("Sat3Sub").exists())
                {
                    tvSetSat3Sub.setText(R.string.SetSub3);
                }
                else
                {
                    tvSetSat3Sub.setText(Sat3Sub);
                }

                if(!snapshot.child("Sat4Sub").exists())
                {
                    tvSetSat4Sub.setText(R.string.SetSub4);
                }
                else
                {
                    tvSetSat4Sub.setText(Sat4Sub);
                }

                if(!snapshot.child("Sat5Sub").exists())
                {
                    tvSetSat5Sub.setText(R.string.SetSub5);
                }
                else
                {
                    tvSetSat5Sub.setText(Sat5Sub);
                }

                if(!snapshot.child("Sat6Sub").exists())
                {
                    tvSetSat6Sub.setText(R.string.SetSub6);
                }
                else
                {
                    tvSetSat6Sub.setText(Sat6Sub);
                }

                if(!snapshot.child("Sat7Sub").exists())
                {
                    tvSetSat7Sub.setText(R.string.SetSub7);
                }
                else
                {
                    tvSetSat7Sub.setText(Sat7Sub);
                }

                if(!snapshot.child("Sat8Sub").exists())
                {
                    tvSetSat8Sub.setText(R.string.SetSub8);
                }
                else
                {
                    tvSetSat8Sub.setText(Sat8Sub);
                }

                if(!snapshot.child("Sat1Class").exists())
                {
                    tvSetSat1Class.setText(R.string.SetClass1);
                }
                else
                {
                    tvSetSat1Class.setText(Sat1Class);
                }

                if(!snapshot.child("Sat2Class").exists())
                {
                    tvSetSat2Class.setText(R.string.SetClass2);
                }
                else
                {
                    tvSetSat2Class.setText(Sat2Class);
                }

                if(!snapshot.child("Sat3Class").exists())
                {
                    tvSetSat3Class.setText(R.string.SetClass3);
                }
                else
                {
                    tvSetSat3Class.setText(Sat3Class);
                }

                if(!snapshot.child("Sat4Class").exists())
                {
                    tvSetSat4Class.setText(R.string.SetClass4);
                }
                else
                {
                    tvSetSat4Class.setText(Sat4Class);
                }

                if(!snapshot.child("Sat5Class").exists())
                {
                    tvSetSat5Class.setText(R.string.SetClass5);
                }
                else
                {
                    tvSetSat5Class.setText(Sat5Class);
                }

                if(!snapshot.child("Sat6Class").exists())
                {
                    tvSetSat6Class.setText(R.string.SetClass6);
                }
                else
                {
                    tvSetSat6Class.setText(Sat6Class);
                }

                if(!snapshot.child("Sat7Class").exists())
                {
                    tvSetSat7Class.setText(R.string.SetClass7);
                }
                else
                {
                    tvSetSat7Class.setText(Sat7Class);
                }

                if(!snapshot.child("Sat8Class").exists())
                {
                    tvSetSat8Class.setText(R.string.SetClass8);
                }
                else
                {
                    tvSetSat8Class.setText(Sat8Class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference reff1 = database.getReference(school);
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int j = 0;
                int i = 0;
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String name_school = ds.getKey();
                    j++;
                }

                final String[] strClass = new String[j];
                //strClass[0] = "Класс";
                for (DataSnapshot ds1 : snapshot.getChildren()) {
                    String name_school = ds1.getKey();
                    strClass[i] = name_school;
                    i++;
                }

                final ArrayAdapter arrayAdapterClass = new ArrayAdapter(TeacherActivitySetSat.this, android.R.layout.simple_spinner_item, strClass);

                {
                    /**
                     * Инициализация классов
                     * */
                    tvSetSat1Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 1 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat1Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat1Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat2Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 2 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat2Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat2Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat3Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 3 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat3Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat3Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat4Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 4 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat4Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat4Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat5Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 5 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat5Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat5Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat6Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 6 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat6Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat6Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat7Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 7 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat7Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat7Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetSat8Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                            builder.setTitle("Выберите 8 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetSat8Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Sat8Class").setValue(str);
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
                //strSub[0]= "Предмет";

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

                final ArrayAdapter arrayAdapterSub = new ArrayAdapter(TeacherActivitySetSat.this, android.R.layout.simple_spinner_item, strSub);

                /**
                 * Инициализация предметов
                 * */
                tvSetSat1Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 1 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat1Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat1Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat2Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 2 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat2Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat2Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat3Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 3 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat3Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat3Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat4Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 4 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat4Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat4Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat5Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 5 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat5Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat5Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat6Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 6 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat6Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat6Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat7Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 7 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat7Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat7Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetSat8Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivitySetSat.this,R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 8 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(TeacherActivitySetSat.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetSat8Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Sat8Sub").setValue(str);
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

        btnSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //utils.switchFragment(TeacherActivitySetSat.this, new TeacherFragmentSettingStudy());
                Intent intent = new Intent(TeacherActivitySetSat.this, TeacherMainActivity.class);
                startActivity(intent);

            }

        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new TapTargetSequence(TeacherActivitySetSat.this)
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
                        }).start();*/
            }
        });
    }
}
