package ru.shkolaandstudents.Teacher;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.RecyclerViewTeacher.ExampleItem;
import ru.shkolaandstudents.Utilities;

import static android.content.Context.MODE_PRIVATE;

public class TeacherFragmentSetTuesday extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());

    Button btnWend,btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    ArrayList<ExampleItem> mExampleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_tuesday, container, false);

        btnHelp = v.findViewById(R.id.btnTHelp);
        btnWend = v.findViewById(R.id.btnTAccess);

        /***/
        final TextView tvSetT1Sub = v.findViewById(R.id.tvSetT1Sub);
        final TextView tvSetT2Sub = v.findViewById(R.id.tvSetT2Sub);
        final TextView tvSetT3Sub = v.findViewById(R.id.tvSetT3Sub);
        final TextView tvSetT4Sub = v.findViewById(R.id.tvSetT4Sub);
        final TextView tvSetT5Sub = v.findViewById(R.id.tvSetT5Sub);
        final TextView tvSetT6Sub = v.findViewById(R.id.tvSetT6Sub);
        final TextView tvSetT7Sub = v.findViewById(R.id.tvSetT7Sub);
        final TextView tvSetT8Sub = v.findViewById(R.id.tvSetT8Sub);

        final TextView tvSetT1Class = v.findViewById(R.id.tvSetT1Class);
        final TextView tvSetT2Class = v.findViewById(R.id.tvSetT2Class);
        final TextView tvSetT3Class = v.findViewById(R.id.tvSetT3Class);
        final TextView tvSetT4Class = v.findViewById(R.id.tvSetT4Class);
        final TextView tvSetT5Class = v.findViewById(R.id.tvSetT5Class);
        final TextView tvSetT6Class = v.findViewById(R.id.tvSetT6Class);
        final TextView tvSetT7Class = v.findViewById(R.id.tvSetT7Class);
        final TextView tvSetT8Class = v.findViewById(R.id.tvSetT8Class);

        /***/
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String T1Sub = sp.getString("T1Sub", null);
        String T2Sub = sp.getString("T2Sub", null);
        String T3Sub = sp.getString("T3Sub", null);
        String T4Sub = sp.getString("T4Sub", null);
        String T5Sub = sp.getString("T5Sub", null);
        String T6Sub = sp.getString("T6Sub", null);
        String T7Sub = sp.getString("T7Sub", null);
        String T8Sub = sp.getString("T8Sub", null);

        String T1Class = sp.getString("T1Class", null);
        String T2Class = sp.getString("T2Class", null);
        String T3Class = sp.getString("T3Class", null);
        String T4Class = sp.getString("T4Class", null);
        String T5Class = sp.getString("T5Class", null);
        String T6Class = sp.getString("T6Class", null);
        String T7Class = sp.getString("T7Class", null);
        String T8Class = sp.getString("T8Class", null);

        if(T1Sub == null)
        {
            tvSetT1Sub.setText(R.string.SetSub1);
        }
        else
        {
            tvSetT1Sub.setText(T1Sub);
        }

        if(T2Sub == null)
        {
            tvSetT2Sub.setText(R.string.SetSub2);
        }
        else
        {
            tvSetT2Sub.setText(T2Sub);
        }

        if(T3Sub == null)
        {
            tvSetT3Sub.setText(R.string.SetSub3);
        }
        else
        {
            tvSetT3Sub.setText(T3Sub);
        }

        if(T4Sub == null)
        {
            tvSetT4Sub.setText(R.string.SetSub4);
        }
        else
        {
            tvSetT4Sub.setText(T4Sub);
        }

        if(T5Sub == null)
        {
            tvSetT5Sub.setText(R.string.SetSub5);
        }
        else
        {
            tvSetT5Sub.setText(T5Sub);
        }

        if(T6Sub == null)
        {
            tvSetT6Sub.setText(R.string.SetSub6);
        }
        else
        {
            tvSetT6Sub.setText(T6Sub);
        }

        if(T7Sub == null)
        {
            tvSetT7Sub.setText(R.string.SetSub7);
        }
        else
        {
            tvSetT7Sub.setText(T7Sub);
        }

        if(T8Sub == null)
        {
            tvSetT8Sub.setText(R.string.SetSub8);
        }
        else
        {
            tvSetT8Sub.setText(T8Sub);
        }

        /**
         * Проверка классов на пустоту 
         * */

        if(T1Class == null)
        {
            tvSetT1Class.setText(R.string.SetClass1);
        }
        else
        {
            tvSetT1Class.setText(T1Class);
        }

        if(T2Class == null)
        {
            tvSetT2Class.setText(R.string.SetClass2);
        }
        else
        {
            tvSetT2Class.setText(T2Class);
        }

        if(T3Class == null)
        {
            tvSetT3Class.setText(R.string.SetClass3);
        }
        else
        {
            tvSetT3Class.setText(T3Class);
        }

        if(T4Class == null)
        {
            tvSetT4Class.setText(R.string.SetClass4);
        }
        else
        {
            tvSetT4Class.setText(T4Class);
        }

        if(T5Class == null)
        {
            tvSetT5Class.setText(R.string.SetClass5);
        }
        else
        {
            tvSetT5Class.setText(T5Class);
        }

        if(T6Class == null)
        {
            tvSetT6Class.setText(R.string.SetClass6);
        }
        else
        {
            tvSetT6Class.setText(T6Class);
        }

        if(T7Class == null)
        {
            tvSetT7Class.setText(R.string.SetClass7);
        }
        else
        {
            tvSetT7Class.setText(T7Class);
        }

        if(T8Class == null)
        {
            tvSetT8Class.setText(R.string.SetClass8);
        }
        else
        {
            tvSetT8Class.setText(T8Class);
        }
        /***/
        ImageView delSetT1Sub = v.findViewById(R.id.delSetT1Sub);
        delSetT1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T1Sub");
                editor.remove("T1Class");
                editor.apply();
                tvSetT1Sub.setText(R.string.SetSub1);
                tvSetT1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetT2Sub = v.findViewById(R.id.delSetT2Sub);
        delSetT2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T2Sub");
                editor.remove("T2Class");
                editor.apply();
                tvSetT2Sub.setText(R.string.SetSub2);
                tvSetT2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetT3Sub = v.findViewById(R.id.delSetT3Sub);
        delSetT3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T3Sub");
                editor.remove("T3Class");
                editor.apply();
                tvSetT3Sub.setText(R.string.SetSub3);
                tvSetT3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetT4Sub = v.findViewById(R.id.delSetT4Sub);
        delSetT4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T4Sub");
                editor.remove("T4Class");
                editor.apply();
                tvSetT4Sub.setText(R.string.SetSub4);
                tvSetT4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetT5Sub = v.findViewById(R.id.delSetT5Sub);
        delSetT5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T5Sub");
                editor.remove("T5Class");
                editor.apply();
                tvSetT5Sub.setText(R.string.SetSub5);
                tvSetT5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetT6Sub = v.findViewById(R.id.delSetT6Sub);
        delSetT6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T6Sub");
                editor.remove("T6Class");
                editor.apply();
                tvSetT6Sub.setText(R.string.SetSub6);
                tvSetT6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetT7Sub = v.findViewById(R.id.delSetT7Sub);
        delSetT7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T7Sub");
                editor.remove("T7Class");
                editor.apply();
                tvSetT7Sub.setText(R.string.SetSub7);
                tvSetT7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetT8Sub = v.findViewById(R.id.delSetT8Sub);
        delSetT8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("T8Sub");
                editor.remove("T8Class");
                editor.apply();
                tvSetT8Sub.setText(R.string.SetSub8);
                tvSetT8Class.setText(R.string.SetClass8);
            }
        });
        /***/

        title = v.findViewById(R.id.tvTRasp);
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ExampleItem>>() {}.getType();
        mExampleList = gson.fromJson(json, type);
        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }

        String Fulltext = sharedPreferences.getString("task list", null);
        String s1 = "mLine1";
        String[] split = Fulltext.split(s1);
        int count = split.length - 1;

        ExampleItem currentItem, crt;
        String it1, it2;
        final String[] strSub = new String[count+1];
        final String[] strClass = new String[count+1];

        strSub[0]= "Предмет";
        strClass[0]= "Класс";
        for (int i = 0; i < count; i++)
        {
            currentItem = mExampleList.get(i);
            it1 = currentItem.getLine1();
            strSub[i+1] = it1;
        }

        for (int j = 0; j < count; j++)
        {
            crt = mExampleList.get(j);
            it2 = crt.getLine2();
            strClass[j+1] = it2;
        }

        final ArrayAdapter arrayAdapterSub = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,strSub);
        final ArrayAdapter arrayAdapterClass = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,strClass);

        /**
         * Инициализация предметов
         * */
        tvSetT1Sub.setOnClickListener(new View.OnClickListener() {
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
                        tvSetT1Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T1Sub", str);
                        editor.apply();
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
                        tvSetT2Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T2Sub", str);
                        editor.apply();
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
                        tvSetT3Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T3Sub", str);
                        editor.apply();
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
                        tvSetT4Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T4Sub", str);
                        editor.apply();
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
                        tvSetT5Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T5Sub", str);
                        editor.apply();
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
                        tvSetT6Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T6Sub", str);
                        editor.apply();
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
                        tvSetT7Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T7Sub", str);
                        editor.apply();
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
                        tvSetT8Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T8Sub", str);
                        editor.apply();
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        /**
         *
         * */

        /**
         * Инициализация классов
         * */
        tvSetT1Class.setOnClickListener(new View.OnClickListener() {
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
                        tvSetT1Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T1Class", str);
                        editor.apply();
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
                        tvSetT2Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T2Class", str);
                        editor.apply();
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
                        tvSetT3Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T3Class", str);
                        editor.apply();
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
                        tvSetT4Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T4Class", str);
                        editor.apply();
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
                        tvSetT5Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T5Class", str);
                        editor.apply();
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
                        tvSetT6Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T6Class", str);
                        editor.apply();
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
                        tvSetT7Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T7Class", str);
                        editor.apply();
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
                        tvSetT8Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("T8Class", str);
                        editor.apply();
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        /**
         * */

        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String T1Sub = etT1Sub.getText().toString();
                String T1Class = etT1Class.getText().toString();
                SPEditor.putString("T1Sub",T1Sub);
                SPEditor.putString("T1Class",T1Class);
                SPEditor.apply();

                String T2Sub = etT2Sub.getText().toString();
                String T2Class = etT2Class.getText().toString();
                SPEditor.putString("T2Sub",T2Sub);
                SPEditor.putString("T2Class",T2Class);
                SPEditor.apply();

                String T3Sub = etT3Sub.getText().toString();
                String T3Class = etT3Class.getText().toString();
                SPEditor.putString("T3Sub",T3Sub);
                SPEditor.putString("T3Class",T3Class);
                SPEditor.apply();

                String T4Sub = etT4Sub.getText().toString();
                String T4Class = etT4Class.getText().toString();
                SPEditor.putString("T4Sub",T4Sub);
                SPEditor.putString("T4Class",T4Class);
                SPEditor.apply();

                String T5Sub = etT5Sub.getText().toString();
                String T5Class = etT5Class.getText().toString();
                SPEditor.putString("T5Sub",T5Sub);
                SPEditor.putString("T5Class",T5Class);
                SPEditor.apply();

                String T6Sub = etT6Sub.getText().toString();
                String T6Class = etT6Class.getText().toString();
                SPEditor.putString("T6Sub",T6Sub);
                SPEditor.putString("T6Class",T6Class);
                SPEditor.apply();

                String T7Sub = etT7Sub.getText().toString();
                String T7Class = etT7Class.getText().toString();
                SPEditor.putString("T7Sub",T7Sub);
                SPEditor.putString("T7Class",T7Class);
                SPEditor.apply();

                String T8Sub = etT8Sub.getText().toString();
                String T8Class = etT8Class.getText().toString();
                SPEditor.putString("T8Sub",T8Sub);
                SPEditor.putString("T8Class",T8Class);
                SPEditor.apply();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new TeacherFragmentSetWend());
                transaction.commit();*/
                utils.switchFragment(getActivity(), new TeacherFragmentSettingStudy());


            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etT1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnTAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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