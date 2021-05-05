package ru.shkolaandstudents.Teacher;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.RecyclerViewTeacher.ExampleItem;
import ru.shkolaandstudents.Utilities;

import static android.content.Context.MODE_PRIVATE;

public class TeacherFragmentSetFri extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());

    Button btnSat, btnHelp;
    DatabaseReference ref;
    DatabaseReference ref_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_fri, container, false);

        btnHelp = v.findViewById(R.id.btnFrHelp);
        btnSat = v.findViewById(R.id.btnFrAccess);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        String school = sharedPreferences.getString("school", "");

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final TextView tvSetFr1Sub = v.findViewById(R.id.tvSetFr1Sub);
        final TextView tvSetFr2Sub = v.findViewById(R.id.tvSetFr2Sub);
        final TextView tvSetFr3Sub = v.findViewById(R.id.tvSetFr3Sub);
        final TextView tvSetFr4Sub = v.findViewById(R.id.tvSetFr4Sub);
        final TextView tvSetFr5Sub = v.findViewById(R.id.tvSetFr5Sub);
        final TextView tvSetFr6Sub = v.findViewById(R.id.tvSetFr6Sub);
        final TextView tvSetFr7Sub = v.findViewById(R.id.tvSetFr7Sub);
        final TextView tvSetFr8Sub = v.findViewById(R.id.tvSetFr8Sub);

        final TextView tvSetFr1Class = v.findViewById(R.id.tvSetFr1Class);
        final TextView tvSetFr2Class = v.findViewById(R.id.tvSetFr2Class);
        final TextView tvSetFr3Class = v.findViewById(R.id.tvSetFr3Class);
        final TextView tvSetFr4Class = v.findViewById(R.id.tvSetFr4Class);
        final TextView tvSetFr5Class = v.findViewById(R.id.tvSetFr5Class);
        final TextView tvSetFr6Class = v.findViewById(R.id.tvSetFr6Class);
        final TextView tvSetFr7Class = v.findViewById(R.id.tvSetFr7Class);
        final TextView tvSetFr8Class = v.findViewById(R.id.tvSetFr8Class);

        ImageView delSetFr1Sub = v.findViewById(R.id.delSetFr1Sub);
        delSetFr1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr1Sub").removeValue();
                ref_save.child("Fr1Class").removeValue();
                tvSetFr1Sub.setText(R.string.SetSub1);
                tvSetFr1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetFr2Sub = v.findViewById(R.id.delSetFr2Sub);
        delSetFr2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr2Sub").removeValue();
                ref_save.child("Fr2Class").removeValue();
                tvSetFr2Sub.setText(R.string.SetSub2);
                tvSetFr2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetFr3Sub = v.findViewById(R.id.delSetFr3Sub);
        delSetFr3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr3Sub").removeValue();
                ref_save.child("Fr3Class").removeValue();
                tvSetFr3Sub.setText(R.string.SetSub3);
                tvSetFr3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetFr4Sub = v.findViewById(R.id.delSetFr4Sub);
        delSetFr4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr4Sub").removeValue();
                ref_save.child("Fr4Class").removeValue();
                tvSetFr4Sub.setText(R.string.SetSub4);
                tvSetFr4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetFr5Sub = v.findViewById(R.id.delSetFr5Sub);
        delSetFr5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr5Sub").removeValue();
                ref_save.child("Fr5Class").removeValue();
                tvSetFr5Sub.setText(R.string.SetSub5);
                tvSetFr5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetFr6Sub = v.findViewById(R.id.delSetFr6Sub);
        delSetFr6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr6Sub").removeValue();
                ref_save.child("Fr6Class").removeValue();
                tvSetFr6Sub.setText(R.string.SetSub6);
                tvSetFr6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetFr7Sub = v.findViewById(R.id.delSetFr7Sub);
        delSetFr7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr7Sub").removeValue();
                ref_save.child("Fr7Class").removeValue();
                tvSetFr7Sub.setText(R.string.SetSub7);
                tvSetFr7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetFr8Sub = v.findViewById(R.id.delSetFr8Sub);
        delSetFr8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Fr8Sub").removeValue();
                ref_save.child("Fr8Class").removeValue();
                tvSetFr8Sub.setText(R.string.SetSub8);
                tvSetFr8Class.setText(R.string.SetClass8);
            }
        });

        ref_save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Fr1Sub = String.valueOf(snapshot.child("Fr1Sub").getValue());
                String Fr2Sub = String.valueOf(snapshot.child("Fr2Sub").getValue());
                String Fr3Sub = String.valueOf(snapshot.child("Fr3Sub").getValue());
                String Fr4Sub = String.valueOf(snapshot.child("Fr4Sub").getValue());
                String Fr5Sub = String.valueOf(snapshot.child("Fr5Sub").getValue());
                String Fr6Sub = String.valueOf(snapshot.child("Fr6Sub").getValue());
                String Fr7Sub = String.valueOf(snapshot.child("Fr7Sub").getValue());
                String Fr8Sub = String.valueOf(snapshot.child("Fr8Sub").getValue());

                String Fr1Class = String.valueOf(snapshot.child("Fr1Class").getValue());
                String Fr2Class = String.valueOf(snapshot.child("Fr2Class").getValue());
                String Fr3Class = String.valueOf(snapshot.child("Fr3Class").getValue());
                String Fr4Class = String.valueOf(snapshot.child("Fr4Class").getValue());
                String Fr5Class = String.valueOf(snapshot.child("Fr5Class").getValue());
                String Fr6Class = String.valueOf(snapshot.child("Fr6Class").getValue());
                String Fr7Class = String.valueOf(snapshot.child("Fr7Class").getValue());
                String Fr8Class = String.valueOf(snapshot.child("Fr8Class").getValue());

                if (!snapshot.child("Fr1Sub").exists()) {
                    tvSetFr1Sub.setText(R.string.SetSub1);
                } else {
                    tvSetFr1Sub.setText(Fr1Sub);
                }

                if (!snapshot.child("Fr2Sub").exists()) {
                    tvSetFr2Sub.setText(R.string.SetSub2);
                } else {
                    tvSetFr2Sub.setText(Fr2Sub);
                }

                if (!snapshot.child("Fr3Sub").exists()) {
                    tvSetFr3Sub.setText(R.string.SetSub3);
                } else {
                    tvSetFr3Sub.setText(Fr3Sub);
                }

                if (!snapshot.child("Fr4Sub").exists()) {
                    tvSetFr4Sub.setText(R.string.SetSub4);
                } else {
                    tvSetFr4Sub.setText(Fr4Sub);
                }

                if (!snapshot.child("Fr5Sub").exists()) {
                    tvSetFr5Sub.setText(R.string.SetSub5);
                } else {
                    tvSetFr5Sub.setText(Fr5Sub);
                }

                if (!snapshot.child("Fr6Sub").exists()) {
                    tvSetFr6Sub.setText(R.string.SetSub6);
                } else {
                    tvSetFr6Sub.setText(Fr6Sub);
                }

                if (!snapshot.child("Fr7Sub").exists()) {
                    tvSetFr7Sub.setText(R.string.SetSub7);
                } else {
                    tvSetFr7Sub.setText(Fr7Sub);
                }

                if (!snapshot.child("Fr8Sub").exists()) {
                    tvSetFr8Sub.setText(R.string.SetSub8);
                } else {
                    tvSetFr8Sub.setText(Fr8Sub);
                }

                if (!snapshot.child("Fr1Class").exists()) {
                    tvSetFr1Class.setText(R.string.SetClass1);
                } else {
                    tvSetFr1Class.setText(Fr1Class);
                }

                if (!snapshot.child("Fr2Class").exists()) {
                    tvSetFr2Class.setText(R.string.SetClass2);
                } else {
                    tvSetFr2Class.setText(Fr2Class);
                }

                if (!snapshot.child("Fr3Class").exists()) {
                    tvSetFr3Class.setText(R.string.SetClass3);
                } else {
                    tvSetFr3Class.setText(Fr3Class);
                }

                if (!snapshot.child("Fr4Class").exists()) {
                    tvSetFr4Class.setText(R.string.SetClass4);
                } else {
                    tvSetFr4Class.setText(Fr4Class);
                }

                if (!snapshot.child("Fr5Class").exists()) {
                    tvSetFr5Class.setText(R.string.SetClass5);
                } else {
                    tvSetFr5Class.setText(Fr5Class);
                }

                if (!snapshot.child("Fr6Class").exists()) {
                    tvSetFr6Class.setText(R.string.SetClass6);
                } else {
                    tvSetFr6Class.setText(Fr6Class);
                }

                if (!snapshot.child("Fr7Class").exists()) {
                    tvSetFr7Class.setText(R.string.SetClass7);
                } else {
                    tvSetFr7Class.setText(Fr7Class);
                }

                if (!snapshot.child("Fr8Class").exists()) {
                    tvSetFr8Class.setText(R.string.SetClass8);
                } else {
                    tvSetFr8Class.setText(Fr8Class);
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

                final ArrayAdapter arrayAdapterClass = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strClass);

                {
                    /**
                     * Инициализация классов
                     * */
                    tvSetFr1Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 1 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr1Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr1Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr2Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 2 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr2Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr2Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr3Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 3 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr3Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr3Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr4Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 4 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr4Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr4Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr5Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 5 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr5Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr5Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr6Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 6 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr6Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr6Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr7Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 7 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr7Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr7Class").setValue(str);
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

                    tvSetFr8Class.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vw) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                            View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class, null);
                            builder.setTitle("Выберите 8 класс");
                            builder.setView(view);
                            final Spinner spinner = view.findViewById(R.id.spinner);

                            arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                            spinner.setAdapter(arrayAdapterClass);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                    tvSetFr8Class.setText(spinner.getSelectedItem().toString());
                                    String str = spinner.getSelectedItem().toString();
                                    ref_save.child("Fr8Class").setValue(str);
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

                final ArrayAdapter arrayAdapterSub = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strSub);

                /**
                 * Инициализация предметов
                 * */
                tvSetFr1Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 1 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr1Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr1Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr2Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 2 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr2Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr2Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr3Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 3 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr3Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr3Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr4Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 4 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr4Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr4Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr5Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 5 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr5Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr5Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr6Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 6 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr6Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr6Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr7Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 7 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr7Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr7Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetFr8Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                        builder.setTitle("Выберите 8 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetFr8Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Fr8Sub").setValue(str);
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

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.switchFragment(getActivity(), new TeacherFragmentSettingStudy());
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etFr1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnFrAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        return v;
    }

    @Override
    public void onBackPressed() {
        utils.switchFragment(getActivity(), new TeacherFragmentSettingStudy());
    }
}