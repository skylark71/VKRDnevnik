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

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.RecyclerViewTeacher.ExampleItem;
import ru.shkolaandstudents.Utilities;

import static android.content.Context.MODE_PRIVATE;

public class TeacherFragmentSetWend extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());

    Button btnThurs,btnHelp;
    DatabaseReference ref;
    DatabaseReference ref_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_wend, container, false);

        btnHelp = v.findViewById(R.id.btnWHelp);
        btnThurs = v.findViewById(R.id.btnWAccess);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Value");
        ref_save = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Schedule");

        final TextView tvSetW1Sub = v.findViewById(R.id.tvSetW1Sub);
        final TextView tvSetW2Sub = v.findViewById(R.id.tvSetW2Sub);
        final TextView tvSetW3Sub = v.findViewById(R.id.tvSetW3Sub);
        final TextView tvSetW4Sub = v.findViewById(R.id.tvSetW4Sub);
        final TextView tvSetW5Sub = v.findViewById(R.id.tvSetW5Sub);
        final TextView tvSetW6Sub = v.findViewById(R.id.tvSetW6Sub);
        final TextView tvSetW7Sub = v.findViewById(R.id.tvSetW7Sub);
        final TextView tvSetW8Sub = v.findViewById(R.id.tvSetW8Sub);

        final TextView tvSetW1Class = v.findViewById(R.id.tvSetW1Class);
        final TextView tvSetW2Class = v.findViewById(R.id.tvSetW2Class);
        final TextView tvSetW3Class = v.findViewById(R.id.tvSetW3Class);
        final TextView tvSetW4Class = v.findViewById(R.id.tvSetW4Class);
        final TextView tvSetW5Class = v.findViewById(R.id.tvSetW5Class);
        final TextView tvSetW6Class = v.findViewById(R.id.tvSetW6Class);
        final TextView tvSetW7Class = v.findViewById(R.id.tvSetW7Class);
        final TextView tvSetW8Class = v.findViewById(R.id.tvSetW8Class);

        ImageView delSetW1Sub = v.findViewById(R.id.delSetW1Sub);
        delSetW1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W1Sub").removeValue();
                ref_save.child("W1Class").removeValue();
                tvSetW1Sub.setText(R.string.SetSub1);
                tvSetW1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetW2Sub = v.findViewById(R.id.delSetW2Sub);
        delSetW2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W2Sub").removeValue();
                ref_save.child("W2Class").removeValue();
                tvSetW2Sub.setText(R.string.SetSub2);
                tvSetW2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetW3Sub = v.findViewById(R.id.delSetW3Sub);
        delSetW3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W3Sub").removeValue();
                ref_save.child("W3Class").removeValue();
                tvSetW3Sub.setText(R.string.SetSub3);
                tvSetW3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetW4Sub = v.findViewById(R.id.delSetW4Sub);
        delSetW4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W4Sub").removeValue();
                ref_save.child("W4Class").removeValue();
                tvSetW4Sub.setText(R.string.SetSub4);
                tvSetW4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetW5Sub = v.findViewById(R.id.delSetW5Sub);
        delSetW5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W5Sub").removeValue();
                ref_save.child("W5Class").removeValue();
                tvSetW5Sub.setText(R.string.SetSub5);
                tvSetW5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetW6Sub = v.findViewById(R.id.delSetW6Sub);
        delSetW6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W6Sub").removeValue();
                ref_save.child("W6Class").removeValue();
                tvSetW6Sub.setText(R.string.SetSub6);
                tvSetW6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetW7Sub = v.findViewById(R.id.delSetW7Sub);
        delSetW7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W7Sub").removeValue();
                ref_save.child("W7Class").removeValue();
                tvSetW7Sub.setText(R.string.SetSub7);
                tvSetW7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetW8Sub = v.findViewById(R.id.delSetW8Sub);
        delSetW8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("W8Sub").removeValue();
                ref_save.child("W8Class").removeValue();
                tvSetW8Sub.setText(R.string.SetSub8);
                tvSetW8Class.setText(R.string.SetClass8);
            }
        });

        ref_save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String W1Sub = String.valueOf(snapshot.child("W1Sub").getValue());
                String W2Sub = String.valueOf(snapshot.child("W2Sub").getValue());
                String W3Sub = String.valueOf(snapshot.child("W3Sub").getValue());
                String W4Sub = String.valueOf(snapshot.child("W4Sub").getValue());
                String W5Sub = String.valueOf(snapshot.child("W5Sub").getValue());
                String W6Sub = String.valueOf(snapshot.child("W6Sub").getValue());
                String W7Sub = String.valueOf(snapshot.child("W7Sub").getValue());
                String W8Sub = String.valueOf(snapshot.child("W8Sub").getValue());

                String W1Class = String.valueOf(snapshot.child("W1Class").getValue());
                String W2Class = String.valueOf(snapshot.child("W2Class").getValue());
                String W3Class = String.valueOf(snapshot.child("W3Class").getValue());
                String W4Class = String.valueOf(snapshot.child("W4Class").getValue());
                String W5Class = String.valueOf(snapshot.child("W5Class").getValue());
                String W6Class = String.valueOf(snapshot.child("W6Class").getValue());
                String W7Class = String.valueOf(snapshot.child("W7Class").getValue());
                String W8Class = String.valueOf(snapshot.child("W8Class").getValue());

                if(!snapshot.child("W1Sub").exists())
                {
                    tvSetW1Sub.setText(R.string.SetSub1);
                }
                else
                {
                    tvSetW1Sub.setText(W1Sub);
                }

                if(!snapshot.child("W2Sub").exists())
                {
                    tvSetW2Sub.setText(R.string.SetSub2);
                }
                else
                {
                    tvSetW2Sub.setText(W2Sub);
                }

                if(!snapshot.child("W3Sub").exists())
                {
                    tvSetW3Sub.setText(R.string.SetSub3);
                }
                else
                {
                    tvSetW3Sub.setText(W3Sub);
                }

                if(!snapshot.child("W4Sub").exists())
                {
                    tvSetW4Sub.setText(R.string.SetSub4);
                }
                else
                {
                    tvSetW4Sub.setText(W4Sub);
                }

                if(!snapshot.child("W5Sub").exists())
                {
                    tvSetW5Sub.setText(R.string.SetSub5);
                }
                else
                {
                    tvSetW5Sub.setText(W5Sub);
                }

                if(!snapshot.child("W6Sub").exists())
                {
                    tvSetW6Sub.setText(R.string.SetSub6);
                }
                else
                {
                    tvSetW6Sub.setText(W6Sub);
                }

                if(!snapshot.child("W7Sub").exists())
                {
                    tvSetW7Sub.setText(R.string.SetSub7);
                }
                else
                {
                    tvSetW7Sub.setText(W7Sub);
                }

                if(!snapshot.child("W8Sub").exists())
                {
                    tvSetW8Sub.setText(R.string.SetSub8);
                }
                else
                {
                    tvSetW8Sub.setText(W8Sub);
                }

                if(!snapshot.child("W1Class").exists())
                {
                    tvSetW1Class.setText(R.string.SetClass1);
                }
                else
                {
                    tvSetW1Class.setText(W1Class);
                }

                if(!snapshot.child("W2Class").exists())
                {
                    tvSetW2Class.setText(R.string.SetClass2);
                }
                else
                {
                    tvSetW2Class.setText(W2Class);
                }

                if(!snapshot.child("W3Class").exists())
                {
                    tvSetW3Class.setText(R.string.SetClass3);
                }
                else
                {
                    tvSetW3Class.setText(W3Class);
                }

                if(!snapshot.child("W4Class").exists())
                {
                    tvSetW4Class.setText(R.string.SetClass4);
                }
                else
                {
                    tvSetW4Class.setText(W4Class);
                }

                if(!snapshot.child("W5Class").exists())
                {
                    tvSetW5Class.setText(R.string.SetClass5);
                }
                else
                {
                    tvSetW5Class.setText(W5Class);
                }

                if(!snapshot.child("W6Class").exists())
                {
                    tvSetW6Class.setText(R.string.SetClass6);
                }
                else
                {
                    tvSetW6Class.setText(W6Class);
                }

                if(!snapshot.child("W7Class").exists())
                {
                    tvSetW7Class.setText(R.string.SetClass7);
                }
                else
                {
                    tvSetW7Class.setText(W7Class);
                }

                if(!snapshot.child("W8Class").exists())
                {
                    tvSetW8Class.setText(R.string.SetClass8);
                }
                else
                {
                    tvSetW8Class.setText(W8Class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                int j=1;

                for (DataSnapshot ds : snapshot.getChildren()){
                    String str_sub = ds.child("Sub").getValue(String.class);
                    j++;
                }

                final String[] strSub = new String[j];
                final String[] strClass = new String[j];


                strSub[0]= "Предмет";
                strClass[0]= "Класс";
                for (DataSnapshot ds : snapshot.getChildren()){
                    String str_sub = ds.child("Sub").getValue(String.class);
                    strSub[i+1] = str_sub;

                    String str_class = ds.child("Class").getValue(String.class);
                    strClass[i+1] = str_class;
                    i++;
                }

                final ArrayAdapter arrayAdapterSub = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,strSub);
                final ArrayAdapter arrayAdapterClass = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,strClass);

                /**
                 * Инициализация предметов
                 * */
                tvSetW1Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 1 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW1Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W1Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW2Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 2 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW2Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W2Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW3Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 3 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW3Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W3Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW4Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 4 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW4Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W4Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW5Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 5 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW5Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W5Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW6Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 6 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW6Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W6Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW7Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 7 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW7Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W7Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW8Sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                        builder.setTitle("Выберите 8 предмет");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner1);

                        arrayAdapterSub.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterSub);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW8Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W8Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });


                /**
                 * Инициализация классов
                 * */
                tvSetW1Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 1 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW1Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W1Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW2Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 2 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW2Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W2Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW3Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 3 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW3Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W3Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW4Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 4 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW4Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W4Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW5Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 5 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW5Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W5Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW6Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 6 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW6Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W6Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW7Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 7 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW7Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W7Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetW8Class.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme);
                        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_class,null);
                        builder.setTitle("Выберите 8 класс");
                        builder.setView(view);
                        final Spinner spinner = view.findViewById(R.id.spinner);

                        arrayAdapterClass.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                        spinner.setAdapter(arrayAdapterClass);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                tvSetW8Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("W8Class").setValue(str);
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

        btnThurs.setOnClickListener(new View.OnClickListener() {
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