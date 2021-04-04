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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
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

public class TeacherFragmentSetThur extends Fragment implements OnBackPressedListener
{
    Utilities utils = new Utilities(getActivity());

    Button btnFri,btnHelp;
    DatabaseReference ref;
    DatabaseReference ref_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_thur, container, false);

        btnHelp = v.findViewById(R.id.btnThHelp);
        btnFri = v.findViewById(R.id.btnThAccess);

        final TextView tvSetTh1Sub = v.findViewById(R.id.tvSetTh1Sub);
        final TextView tvSetTh2Sub = v.findViewById(R.id.tvSetTh2Sub);
        final TextView tvSetTh3Sub = v.findViewById(R.id.tvSetTh3Sub);
        final TextView tvSetTh4Sub = v.findViewById(R.id.tvSetTh4Sub);
        final TextView tvSetTh5Sub = v.findViewById(R.id.tvSetTh5Sub);
        final TextView tvSetTh6Sub = v.findViewById(R.id.tvSetTh6Sub);
        final TextView tvSetTh7Sub = v.findViewById(R.id.tvSetTh7Sub);
        final TextView tvSetTh8Sub = v.findViewById(R.id.tvSetTh8Sub);

        final TextView tvSetTh1Class = v.findViewById(R.id.tvSetTh1Class);
        final TextView tvSetTh2Class = v.findViewById(R.id.tvSetTh2Class);
        final TextView tvSetTh3Class = v.findViewById(R.id.tvSetTh3Class);
        final TextView tvSetTh4Class = v.findViewById(R.id.tvSetTh4Class);
        final TextView tvSetTh5Class = v.findViewById(R.id.tvSetTh5Class);
        final TextView tvSetTh6Class = v.findViewById(R.id.tvSetTh6Class);
        final TextView tvSetTh7Class = v.findViewById(R.id.tvSetTh7Class);
        final TextView tvSetTh8Class = v.findViewById(R.id.tvSetTh8Class);

        ImageView delSetTh1Sub = v.findViewById(R.id.delSetTh1Sub);
        delSetTh1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th1Sub").removeValue();
                ref_save.child("Schedule").child("Th1Class").removeValue();
                tvSetTh1Sub.setText(R.string.SetSub1);
                tvSetTh1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetTh2Sub = v.findViewById(R.id.delSetTh2Sub);
        delSetTh2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th2Sub").removeValue();
                ref_save.child("Schedule").child("Th2Class").removeValue();
                tvSetTh2Sub.setText(R.string.SetSub2);
                tvSetTh2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetTh3Sub = v.findViewById(R.id.delSetTh3Sub);
        delSetTh3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th3Sub").removeValue();
                ref_save.child("Schedule").child("Th3Class").removeValue();
                tvSetTh3Sub.setText(R.string.SetSub3);
                tvSetTh3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetTh4Sub = v.findViewById(R.id.delSetTh4Sub);
        delSetTh4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th4Sub").removeValue();
                ref_save.child("Schedule").child("Th4Class").removeValue();
                tvSetTh4Sub.setText(R.string.SetSub4);
                tvSetTh4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetTh5Sub = v.findViewById(R.id.delSetTh5Sub);
        delSetTh5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th5Sub").removeValue();
                ref_save.child("Schedule").child("Th5Class").removeValue();
                tvSetTh5Sub.setText(R.string.SetSub5);
                tvSetTh5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetTh6Sub = v.findViewById(R.id.delSetTh6Sub);
        delSetTh6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th6Sub").removeValue();
                ref_save.child("Schedule").child("Th6Class").removeValue();
                tvSetTh6Sub.setText(R.string.SetSub6);
                tvSetTh6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetTh7Sub = v.findViewById(R.id.delSetTh7Sub);
        delSetTh7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th7Sub").removeValue();
                ref_save.child("Schedule").child("Th7Class").removeValue();
                tvSetTh7Sub.setText(R.string.SetSub7);
                tvSetTh7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetTh8Sub = v.findViewById(R.id.delSetTh8Sub);
        delSetTh8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_save.child("Schedule").child("Th8Sub").removeValue();
                ref_save.child("Schedule").child("Th8Class").removeValue();
                tvSetTh8Sub.setText(R.string.SetSub8);
                tvSetTh8Class.setText(R.string.SetClass8);
            }
        });

        ref_save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Th1Sub = String.valueOf(snapshot.child("Schedule").child("Th1Sub").getValue());
                String Th2Sub = String.valueOf(snapshot.child("Schedule").child("Th2Sub").getValue());
                String Th3Sub = String.valueOf(snapshot.child("Schedule").child("Th3Sub").getValue());
                String Th4Sub = String.valueOf(snapshot.child("Schedule").child("Th4Sub").getValue());
                String Th5Sub = String.valueOf(snapshot.child("Schedule").child("Th5Sub").getValue());
                String Th6Sub = String.valueOf(snapshot.child("Schedule").child("Th6Sub").getValue());
                String Th7Sub = String.valueOf(snapshot.child("Schedule").child("Th7Sub").getValue());
                String Th8Sub = String.valueOf(snapshot.child("Schedule").child("Th8Sub").getValue());

                String Th1Class = String.valueOf(snapshot.child("Schedule").child("Th1Class").getValue());
                String Th2Class = String.valueOf(snapshot.child("Schedule").child("Th2Class").getValue());
                String Th3Class = String.valueOf(snapshot.child("Schedule").child("Th3Class").getValue());
                String Th4Class = String.valueOf(snapshot.child("Schedule").child("Th4Class").getValue());
                String Th5Class = String.valueOf(snapshot.child("Schedule").child("Th5Class").getValue());
                String Th6Class = String.valueOf(snapshot.child("Schedule").child("Th6Class").getValue());
                String Th7Class = String.valueOf(snapshot.child("Schedule").child("Th7Class").getValue());
                String Th8Class = String.valueOf(snapshot.child("Schedule").child("Th8Class").getValue());

                if(snapshot.child("Th1Sub").exists())
                {
                    tvSetTh1Sub.setText(R.string.SetSub1);
                }
                else
                {
                    tvSetTh1Sub.setText(Th1Sub);
                }

                if(snapshot.child("Th2Sub").exists())
                {
                    tvSetTh2Sub.setText(R.string.SetSub2);
                }
                else
                {
                    tvSetTh2Sub.setText(Th2Sub);
                }

                if(snapshot.child("Th3Sub").exists())
                {
                    tvSetTh3Sub.setText(R.string.SetSub3);
                }
                else
                {
                    tvSetTh3Sub.setText(Th3Sub);
                }

                if(snapshot.child("Th4Sub").exists())
                {
                    tvSetTh4Sub.setText(R.string.SetSub4);
                }
                else
                {
                    tvSetTh4Sub.setText(Th4Sub);
                }

                if(snapshot.child("Th5Sub").exists())
                {
                    tvSetTh5Sub.setText(R.string.SetSub5);
                }
                else
                {
                    tvSetTh5Sub.setText(Th5Sub);
                }

                if(snapshot.child("Th6Sub").exists())
                {
                    tvSetTh6Sub.setText(R.string.SetSub6);
                }
                else
                {
                    tvSetTh6Sub.setText(Th6Sub);
                }

                if(snapshot.child("Th7Sub").exists())
                {
                    tvSetTh7Sub.setText(R.string.SetSub7);
                }
                else
                {
                    tvSetTh7Sub.setText(Th7Sub);
                }

                if(snapshot.child("Th8Sub").exists())
                {
                    tvSetTh8Sub.setText(R.string.SetSub8);
                }
                else
                {
                    tvSetTh8Sub.setText(Th8Sub);
                }

                if(snapshot.child("Th1Class").exists())
                {
                    tvSetTh1Class.setText(R.string.SetClass1);
                }
                else
                {
                    tvSetTh1Class.setText(Th1Class);
                }

                if(snapshot.child("Th2Class").exists())
                {
                    tvSetTh2Class.setText(R.string.SetClass2);
                }
                else
                {
                    tvSetTh2Class.setText(Th2Class);
                }

                if(snapshot.child("Th3Class").exists())
                {
                    tvSetTh3Class.setText(R.string.SetClass3);
                }
                else
                {
                    tvSetTh3Class.setText(Th3Class);
                }

                if(snapshot.child("Th4Class").exists())
                {
                    tvSetTh4Class.setText(R.string.SetClass4);
                }
                else
                {
                    tvSetTh4Class.setText(Th4Class);
                }

                if(snapshot.child("Th5Class").exists())
                {
                    tvSetTh5Class.setText(R.string.SetClass5);
                }
                else
                {
                    tvSetTh5Class.setText(Th5Class);
                }

                if(snapshot.child("Th6Class").exists())
                {
                    tvSetTh6Class.setText(R.string.SetClass6);
                }
                else
                {
                    tvSetTh6Class.setText(Th6Class);
                }

                if(snapshot.child("Th7Class").exists())
                {
                    tvSetTh7Class.setText(R.string.SetClass7);
                }
                else
                {
                    tvSetTh7Class.setText(Th7Class);
                }

                if(snapshot.child("Th8Class").exists())
                {
                    tvSetTh8Class.setText(R.string.SetClass8);
                }
                else
                {
                    tvSetTh8Class.setText(Th8Class);
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
                tvSetTh1Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh1Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th1Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh2Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh2Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th2Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh3Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh3Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th3Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh4Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh4Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th4Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh5Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh5Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th5Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh6Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh6Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th6Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh7Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh7Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th7Sub").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh8Sub.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh8Sub.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th8Sub").setValue(str);
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
                tvSetTh1Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh1Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th1Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh2Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh2Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th2Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh3Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh3Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th3Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh4Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh4Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th4Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh5Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh5Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th5Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh6Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh6Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th6Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh7Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh7Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th7Class").setValue(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

                tvSetTh8Class.setOnClickListener(new View.OnClickListener() {
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
                                tvSetTh8Class.setText(spinner.getSelectedItem().toString());
                                String str = spinner.getSelectedItem().toString();
                                ref_save.child("Schedule").child("Th8Class").setValue(str);
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


        btnFri.setOnClickListener(new View.OnClickListener() {
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
                                TapTarget.forView(v.findViewById(R.id.etTh1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnThAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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