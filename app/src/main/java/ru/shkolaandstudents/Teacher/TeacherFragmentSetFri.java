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

public class TeacherFragmentSetFri extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());


    Button btnSat,btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    ArrayList<ExampleItem> mExampleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_fri, container, false);

        btnHelp = v.findViewById(R.id.btnFrHelp);
        btnSat = v.findViewById(R.id.btnFrAccess);

        /***/
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

        /***/
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String Fr1Sub = sp.getString("Fr1Sub", null);
        String Fr2Sub = sp.getString("Fr2Sub", null);
        String Fr3Sub = sp.getString("Fr3Sub", null);
        String Fr4Sub = sp.getString("Fr4Sub", null);
        String Fr5Sub = sp.getString("Fr5Sub", null);
        String Fr6Sub = sp.getString("Fr6Sub", null);
        String Fr7Sub = sp.getString("Fr7Sub", null);
        String Fr8Sub = sp.getString("Fr8Sub", null);

        String Fr1Class = sp.getString("Fr1Class", null);
        String Fr2Class = sp.getString("Fr2Class", null);
        String Fr3Class = sp.getString("Fr3Class", null);
        String Fr4Class = sp.getString("Fr4Class", null);
        String Fr5Class = sp.getString("Fr5Class", null);
        String Fr6Class = sp.getString("Fr6Class", null);
        String Fr7Class = sp.getString("Fr7Class", null);
        String Fr8Class = sp.getString("Fr8Class", null);

        if(Fr1Sub == null)
        {
            tvSetFr1Sub.setText(R.string.SetSub1);
        }
        else
        {
            tvSetFr1Sub.setText(Fr1Sub);
        }

        if(Fr2Sub == null)
        {
            tvSetFr2Sub.setText(R.string.SetSub2);
        }
        else
        {
            tvSetFr2Sub.setText(Fr2Sub);
        }

        if(Fr3Sub == null)
        {
            tvSetFr3Sub.setText(R.string.SetSub3);
        }
        else
        {
            tvSetFr3Sub.setText(Fr3Sub);
        }

        if(Fr4Sub == null)
        {
            tvSetFr4Sub.setText(R.string.SetSub4);
        }
        else
        {
            tvSetFr4Sub.setText(Fr4Sub);
        }

        if(Fr5Sub == null)
        {
            tvSetFr5Sub.setText(R.string.SetSub5);
        }
        else
        {
            tvSetFr5Sub.setText(Fr5Sub);
        }

        if(Fr6Sub == null)
        {
            tvSetFr6Sub.setText(R.string.SetSub6);
        }
        else
        {
            tvSetFr6Sub.setText(Fr6Sub);
        }

        if(Fr7Sub == null)
        {
            tvSetFr7Sub.setText(R.string.SetSub7);
        }
        else
        {
            tvSetFr7Sub.setText(Fr7Sub);
        }

        if(Fr8Sub == null)
        {
            tvSetFr8Sub.setText(R.string.SetSub8);
        }
        else
        {
            tvSetFr8Sub.setText(Fr8Sub);
        }

        /**
         * Проверка классов на пустоту 
         * */

        if(Fr1Class == null)
        {
            tvSetFr1Class.setText(R.string.SetClass1);
        }
        else
        {
            tvSetFr1Class.setText(Fr1Class);
        }

        if(Fr2Class == null)
        {
            tvSetFr2Class.setText(R.string.SetClass2);
        }
        else
        {
            tvSetFr2Class.setText(Fr2Class);
        }

        if(Fr3Class == null)
        {
            tvSetFr3Class.setText(R.string.SetClass3);
        }
        else
        {
            tvSetFr3Class.setText(Fr3Class);
        }

        if(Fr4Class == null)
        {
            tvSetFr4Class.setText(R.string.SetClass4);
        }
        else
        {
            tvSetFr4Class.setText(Fr4Class);
        }

        if(Fr5Class == null)
        {
            tvSetFr5Class.setText(R.string.SetClass5);
        }
        else
        {
            tvSetFr5Class.setText(Fr5Class);
        }

        if(Fr6Class == null)
        {
            tvSetFr6Class.setText(R.string.SetClass6);
        }
        else
        {
            tvSetFr6Class.setText(Fr6Class);
        }

        if(Fr7Class == null)
        {
            tvSetFr7Class.setText(R.string.SetClass7);
        }
        else
        {
            tvSetFr7Class.setText(Fr7Class);
        }

        if(Fr8Class == null)
        {
            tvSetFr8Class.setText(R.string.SetClass8);
        }
        else
        {
            tvSetFr8Class.setText(Fr8Class);
        }
        /***/
        ImageView delSetFr1Sub = v.findViewById(R.id.delSetFr1Sub);
        delSetFr1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr1Sub");
                editor.remove("Fr1Class");
                editor.apply();
                tvSetFr1Sub.setText(R.string.SetSub1);
                tvSetFr1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetFr2Sub = v.findViewById(R.id.delSetFr2Sub);
        delSetFr2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr2Sub");
                editor.remove("Fr2Class");
                editor.apply();
                tvSetFr2Sub.setText(R.string.SetSub2);
                tvSetFr2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetFr3Sub = v.findViewById(R.id.delSetFr3Sub);
        delSetFr3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr3Sub");
                editor.remove("Fr3Class");
                editor.apply();
                tvSetFr3Sub.setText(R.string.SetSub3);
                tvSetFr3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetFr4Sub = v.findViewById(R.id.delSetFr4Sub);
        delSetFr4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr4Sub");
                editor.remove("Fr4Class");
                editor.apply();
                tvSetFr4Sub.setText(R.string.SetSub4);
                tvSetFr4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetFr5Sub = v.findViewById(R.id.delSetFr5Sub);
        delSetFr5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr5Sub");
                editor.remove("Fr5Class");
                editor.apply();
                tvSetFr5Sub.setText(R.string.SetSub5);
                tvSetFr5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetFr6Sub = v.findViewById(R.id.delSetFr6Sub);
        delSetFr6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr6Sub");
                editor.remove("Fr6Class");
                editor.apply();
                tvSetFr6Sub.setText(R.string.SetSub6);
                tvSetFr6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetFr7Sub = v.findViewById(R.id.delSetFr7Sub);
        delSetFr7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr7Sub");
                editor.remove("Fr7Class");
                editor.apply();
                tvSetFr7Sub.setText(R.string.SetSub7);
                tvSetFr7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetFr8Sub = v.findViewById(R.id.delSetFr8Sub);
        delSetFr8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Fr8Sub");
                editor.remove("Fr8Class");
                editor.apply();
                tvSetFr8Sub.setText(R.string.SetSub8);
                tvSetFr8Class.setText(R.string.SetClass8);
            }
        });
        /***/

        title = v.findViewById(R.id.tvFrRasp);
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
        tvSetFr1Sub.setOnClickListener(new View.OnClickListener() {
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
                        tvSetFr1Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr1Sub", str);
                        editor.apply();
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
                        tvSetFr2Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr2Sub", str);
                        editor.apply();
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
                        tvSetFr3Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr3Sub", str);
                        editor.apply();
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
                        tvSetFr4Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr4Sub", str);
                        editor.apply();
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
                        tvSetFr5Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr5Sub", str);
                        editor.apply();
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
                        tvSetFr6Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr6Sub", str);
                        editor.apply();
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
                        tvSetFr7Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr7Sub", str);
                        editor.apply();
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
                        tvSetFr8Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr8Sub", str);
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
        tvSetFr1Class.setOnClickListener(new View.OnClickListener() {
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
                        tvSetFr1Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr1Class", str);
                        editor.apply();
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
                        tvSetFr2Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr2Class", str);
                        editor.apply();
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
                        tvSetFr3Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr3Class", str);
                        editor.apply();
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
                        tvSetFr4Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr4Class", str);
                        editor.apply();
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
                        tvSetFr5Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr5Class", str);
                        editor.apply();
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
                        tvSetFr6Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr6Class", str);
                        editor.apply();
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
                        tvSetFr7Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr7Class", str);
                        editor.apply();
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
                        tvSetFr8Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Fr8Class", str);
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

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String Fr1Sub = etFr1Sub.getText().toString();
                String Fr1Class = etFr1Class.getText().toString();
                SPEditor.putString("Fr1Sub",Fr1Sub);
                SPEditor.putString("Fr1Class",Fr1Class);
                SPEditor.apply();

                String Fr2Sub = etFr2Sub.getText().toString();
                String Fr2Class = etFr2Class.getText().toString();
                SPEditor.putString("Fr2Sub",Fr2Sub);
                SPEditor.putString("Fr2Class",Fr2Class);
                SPEditor.apply();

                String Fr3Sub = etFr3Sub.getText().toString();
                String Fr3Class = etFr3Class.getText().toString();
                SPEditor.putString("Fr3Sub",Fr3Sub);
                SPEditor.putString("Fr3Class",Fr3Class);
                SPEditor.apply();

                String Fr4Sub = etFr4Sub.getText().toString();
                String Fr4Class = etFr4Class.getText().toString();
                SPEditor.putString("Fr4Sub",Fr4Sub);
                SPEditor.putString("Fr4Class",Fr4Class);
                SPEditor.apply();

                String Fr5Sub = etFr5Sub.getText().toString();
                String Fr5Class = etFr5Class.getText().toString();
                SPEditor.putString("Fr5Sub",Fr5Sub);
                SPEditor.putString("Fr5Class",Fr5Class);
                SPEditor.apply();

                String Fr6Sub = etFr6Sub.getText().toString();
                String Fr6Class = etFr6Class.getText().toString();
                SPEditor.putString("Fr6Sub",Fr6Sub);
                SPEditor.putString("Fr6Class",Fr6Class);
                SPEditor.apply();

                String Fr7Sub = etFr7Sub.getText().toString();
                String Fr7Class = etFr7Class.getText().toString();
                SPEditor.putString("Fr7Sub",Fr7Sub);
                SPEditor.putString("Fr7Class",Fr7Class);
                SPEditor.apply();

                String Fr8Sub = etFr8Sub.getText().toString();
                String Fr8Class = etFr8Class.getText().toString();
                SPEditor.putString("Fr8Sub",Fr8Sub);
                SPEditor.putString("Fr8Class",Fr8Class);
                SPEditor.apply();*/

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