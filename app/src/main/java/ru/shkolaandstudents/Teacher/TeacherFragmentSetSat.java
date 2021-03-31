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

public class TeacherFragmentSetSat extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());


    Button btnSM,btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    ArrayList<ExampleItem> mExampleList;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.teacher_fragment_set_sat, container, false);

        btnHelp = v.findViewById(R.id.btnSatHelp);
        btnSM = v.findViewById(R.id.btnSatAccess);

        /***/
        final TextView tvSetSat1Sub = v.findViewById(R.id.tvSetSat1Sub);
        final TextView tvSetSat2Sub = v.findViewById(R.id.tvSetSat2Sub);
        final TextView tvSetSat3Sub = v.findViewById(R.id.tvSetSat3Sub);
        final TextView tvSetSat4Sub = v.findViewById(R.id.tvSetSat4Sub);
        final TextView tvSetSat5Sub = v.findViewById(R.id.tvSetSat5Sub);
        final TextView tvSetSat6Sub = v.findViewById(R.id.tvSetSat6Sub);
        final TextView tvSetSat7Sub = v.findViewById(R.id.tvSetSat7Sub);
        final TextView tvSetSat8Sub = v.findViewById(R.id.tvSetSat8Sub);

        final TextView tvSetSat1Class = v.findViewById(R.id.tvSetSat1Class);
        final TextView tvSetSat2Class = v.findViewById(R.id.tvSetSat2Class);
        final TextView tvSetSat3Class = v.findViewById(R.id.tvSetSat3Class);
        final TextView tvSetSat4Class = v.findViewById(R.id.tvSetSat4Class);
        final TextView tvSetSat5Class = v.findViewById(R.id.tvSetSat5Class);
        final TextView tvSetSat6Class = v.findViewById(R.id.tvSetSat6Class);
        final TextView tvSetSat7Class = v.findViewById(R.id.tvSetSat7Class);
        final TextView tvSetSat8Class = v.findViewById(R.id.tvSetSat8Class);

        /***/
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String Sat1Sub = sp.getString("Sat1Sub", null);
        String Sat2Sub = sp.getString("Sat2Sub", null);
        String Sat3Sub = sp.getString("Sat3Sub", null);
        String Sat4Sub = sp.getString("Sat4Sub", null);
        String Sat5Sub = sp.getString("Sat5Sub", null);
        String Sat6Sub = sp.getString("Sat6Sub", null);
        String Sat7Sub = sp.getString("Sat7Sub", null);
        String Sat8Sub = sp.getString("Sat8Sub", null);

        String Sat1Class = sp.getString("Sat1Class", null);
        String Sat2Class = sp.getString("Sat2Class", null);
        String Sat3Class = sp.getString("Sat3Class", null);
        String Sat4Class = sp.getString("Sat4Class", null);
        String Sat5Class = sp.getString("Sat5Class", null);
        String Sat6Class = sp.getString("Sat6Class", null);
        String Sat7Class = sp.getString("Sat7Class", null);
        String Sat8Class = sp.getString("Sat8Class", null);

        if(Sat1Sub == null)
        {
            tvSetSat1Sub.setText(R.string.SetSub1);
        }
        else
        {
            tvSetSat1Sub.setText(Sat1Sub);
        }

        if(Sat2Sub == null)
        {
            tvSetSat2Sub.setText(R.string.SetSub2);
        }
        else
        {
            tvSetSat2Sub.setText(Sat2Sub);
        }

        if(Sat3Sub == null)
        {
            tvSetSat3Sub.setText(R.string.SetSub3);
        }
        else
        {
            tvSetSat3Sub.setText(Sat3Sub);
        }

        if(Sat4Sub == null)
        {
            tvSetSat4Sub.setText(R.string.SetSub4);
        }
        else
        {
            tvSetSat4Sub.setText(Sat4Sub);
        }

        if(Sat5Sub == null)
        {
            tvSetSat5Sub.setText(R.string.SetSub5);
        }
        else
        {
            tvSetSat5Sub.setText(Sat5Sub);
        }

        if(Sat6Sub == null)
        {
            tvSetSat6Sub.setText(R.string.SetSub6);
        }
        else
        {
            tvSetSat6Sub.setText(Sat6Sub);
        }

        if(Sat7Sub == null)
        {
            tvSetSat7Sub.setText(R.string.SetSub7);
        }
        else
        {
            tvSetSat7Sub.setText(Sat7Sub);
        }

        if(Sat8Sub == null)
        {
            tvSetSat8Sub.setText(R.string.SetSub8);
        }
        else
        {
            tvSetSat8Sub.setText(Sat8Sub);
        }

        /**
         * Проверка классов на пустоту 
         * */

        if(Sat1Class == null)
        {
            tvSetSat1Class.setText(R.string.SetClass1);
        }
        else
        {
            tvSetSat1Class.setText(Sat1Class);
        }

        if(Sat2Class == null)
        {
            tvSetSat2Class.setText(R.string.SetClass2);
        }
        else
        {
            tvSetSat2Class.setText(Sat2Class);
        }

        if(Sat3Class == null)
        {
            tvSetSat3Class.setText(R.string.SetClass3);
        }
        else
        {
            tvSetSat3Class.setText(Sat3Class);
        }

        if(Sat4Class == null)
        {
            tvSetSat4Class.setText(R.string.SetClass4);
        }
        else
        {
            tvSetSat4Class.setText(Sat4Class);
        }

        if(Sat5Class == null)
        {
            tvSetSat5Class.setText(R.string.SetClass5);
        }
        else
        {
            tvSetSat5Class.setText(Sat5Class);
        }

        if(Sat6Class == null)
        {
            tvSetSat6Class.setText(R.string.SetClass6);
        }
        else
        {
            tvSetSat6Class.setText(Sat6Class);
        }

        if(Sat7Class == null)
        {
            tvSetSat7Class.setText(R.string.SetClass7);
        }
        else
        {
            tvSetSat7Class.setText(Sat7Class);
        }

        if(Sat8Class == null)
        {
            tvSetSat8Class.setText(R.string.SetClass8);
        }
        else
        {
            tvSetSat8Class.setText(Sat8Class);
        }
        /***/
        ImageView delSetSat1Sub = v.findViewById(R.id.delSetSat1Sub);
        delSetSat1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat1Sub");
                editor.remove("Sat1Class");
                editor.apply();
                tvSetSat1Sub.setText(R.string.SetSub1);
                tvSetSat1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetSat2Sub = v.findViewById(R.id.delSetSat2Sub);
        delSetSat2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat2Sub");
                editor.remove("Sat2Class");
                editor.apply();
                tvSetSat2Sub.setText(R.string.SetSub2);
                tvSetSat2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetSat3Sub = v.findViewById(R.id.delSetSat3Sub);
        delSetSat3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat3Sub");
                editor.remove("Sat3Class");
                editor.apply();
                tvSetSat3Sub.setText(R.string.SetSub3);
                tvSetSat3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetSat4Sub = v.findViewById(R.id.delSetSat4Sub);
        delSetSat4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat4Sub");
                editor.remove("Sat4Class");
                editor.apply();
                tvSetSat4Sub.setText(R.string.SetSub4);
                tvSetSat4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetSat5Sub = v.findViewById(R.id.delSetSat5Sub);
        delSetSat5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat5Sub");
                editor.remove("Sat5Class");
                editor.apply();
                tvSetSat5Sub.setText(R.string.SetSub5);
                tvSetSat5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetSat6Sub = v.findViewById(R.id.delSetSat6Sub);
        delSetSat6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat6Sub");
                editor.remove("Sat6Class");
                editor.apply();
                tvSetSat6Sub.setText(R.string.SetSub6);
                tvSetSat6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetSat7Sub = v.findViewById(R.id.delSetSat7Sub);
        delSetSat7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat7Sub");
                editor.remove("Sat7Class");
                editor.apply();
                tvSetSat7Sub.setText(R.string.SetSub7);
                tvSetSat7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetSat8Sub = v.findViewById(R.id.delSetSat8Sub);
        delSetSat8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Sat8Sub");
                editor.remove("Sat8Class");
                editor.apply();
                tvSetSat8Sub.setText(R.string.SetSub8);
                tvSetSat8Class.setText(R.string.SetClass8);
            }
        });
        /***/
        
        title = v.findViewById(R.id.tvSatRasp);
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
        tvSetSat1Sub.setOnClickListener(new View.OnClickListener() {
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
                        tvSetSat1Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat1Sub", str);
                        editor.apply();
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
                        tvSetSat2Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat2Sub", str);
                        editor.apply();
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
                        tvSetSat3Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat3Sub", str);
                        editor.apply();
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
                        tvSetSat4Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat4Sub", str);
                        editor.apply();
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
                        tvSetSat5Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat5Sub", str);
                        editor.apply();
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
                        tvSetSat6Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat6Sub", str);
                        editor.apply();
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
                        tvSetSat7Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat7Sub", str);
                        editor.apply();
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
                        tvSetSat8Sub.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat8Sub", str);
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
        tvSetSat1Class.setOnClickListener(new View.OnClickListener() {
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
                        tvSetSat1Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat1Class", str);
                        editor.apply();
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
                        tvSetSat2Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat2Class", str);
                        editor.apply();
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
                        tvSetSat3Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat3Class", str);
                        editor.apply();
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
                        tvSetSat4Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat4Class", str);
                        editor.apply();
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
                        tvSetSat5Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat5Class", str);
                        editor.apply();
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
                        tvSetSat6Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat6Class", str);
                        editor.apply();
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
                        tvSetSat7Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat7Class", str);
                        editor.apply();
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
                        tvSetSat8Class.setText(spinner.getSelectedItem().toString());
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Sat8Class", str);
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

        btnSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String Sat1Sub = etSat1Sub.getText().toString();
                String Sat1Class = etSat1Class.getText().toString();
                SPEditor.putString("Sat1Sub",Sat1Sub);
                SPEditor.putString("Sat1Class",Sat1Class);
                SPEditor.apply();

                String Sat2Sub = etSat2Sub.getText().toString();
                String Sat2Class = etSat2Class.getText().toString();
                SPEditor.putString("Sat2Sub",Sat2Sub);
                SPEditor.putString("Sat2Class",Sat2Class);
                SPEditor.apply();

                String Sat3Sub = etSat3Sub.getText().toString();
                String Sat3Class = etSat3Class.getText().toString();
                SPEditor.putString("Sat3Sub",Sat3Sub);
                SPEditor.putString("Sat3Class",Sat3Class);
                SPEditor.apply();

                String Sat4Sub = etSat4Sub.getText().toString();
                String Sat4Class = etSat4Class.getText().toString();
                SPEditor.putString("Sat4Sub",Sat4Sub);
                SPEditor.putString("Sat4Class",Sat4Class);
                SPEditor.apply();

                String Sat5Sub = etSat5Sub.getText().toString();
                String Sat5Class = etSat5Class.getText().toString();
                SPEditor.putString("Sat5Sub",Sat5Sub);
                SPEditor.putString("Sat5Class",Sat5Class);
                SPEditor.apply();

                String Sat6Sub = etSat6Sub.getText().toString();
                String Sat6Class = etSat6Class.getText().toString();
                SPEditor.putString("Sat6Sub",Sat6Sub);
                SPEditor.putString("Sat6Class",Sat6Class);
                SPEditor.apply();

                String Sat7Sub = etSat7Sub.getText().toString();
                String Sat7Class = etSat7Class.getText().toString();
                SPEditor.putString("Sat7Sub",Sat7Sub);
                SPEditor.putString("Sat7Class",Sat7Class);
                SPEditor.apply();

                String Sat8Sub = etSat8Sub.getText().toString();
                String Sat8Class = etSat8Class.getText().toString();
                SPEditor.putString("Sat8Sub",Sat8Sub);
                SPEditor.putString("Sat8Class",Sat8Class);
                SPEditor.apply();*/

                utils.switchFragment(getActivity(), new TeacherFragmentSettingStudy());
            }

        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etSat1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnSatAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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