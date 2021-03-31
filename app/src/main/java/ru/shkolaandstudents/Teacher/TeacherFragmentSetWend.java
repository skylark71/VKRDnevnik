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

public class TeacherFragmentSetWend extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());

    Button btnThurs,btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    ArrayList<ExampleItem> mExampleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_wend, container, false);

        btnHelp = v.findViewById(R.id.btnWHelp);
        btnThurs = v.findViewById(R.id.btnWAccess);

        /***/
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
        
        /***/
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String W1Sub = sp.getString("W1Sub", null);
        String W2Sub = sp.getString("W2Sub", null);
        String W3Sub = sp.getString("W3Sub", null);
        String W4Sub = sp.getString("W4Sub", null);
        String W5Sub = sp.getString("W5Sub", null);
        String W6Sub = sp.getString("W6Sub", null);
        String W7Sub = sp.getString("W7Sub", null);
        String W8Sub = sp.getString("W8Sub", null);

        String W1Class = sp.getString("W1Class", null);
        String W2Class = sp.getString("W2Class", null);
        String W3Class = sp.getString("W3Class", null);
        String W4Class = sp.getString("W4Class", null);
        String W5Class = sp.getString("W5Class", null);
        String W6Class = sp.getString("W6Class", null);
        String W7Class = sp.getString("W7Class", null);
        String W8Class = sp.getString("W8Class", null);

        if(W1Sub == null)
        {
            tvSetW1Sub.setText(R.string.SetSub1);
        }
        else
        {
            tvSetW1Sub.setText(W1Sub);
        }

        if(W2Sub == null)
        {
            tvSetW2Sub.setText(R.string.SetSub2);
        }
        else
        {
            tvSetW2Sub.setText(W2Sub);
        }

        if(W3Sub == null)
        {
            tvSetW3Sub.setText(R.string.SetSub3);
        }
        else
        {
            tvSetW3Sub.setText(W3Sub);
        }

        if(W4Sub == null)
        {
            tvSetW4Sub.setText(R.string.SetSub4);
        }
        else
        {
            tvSetW4Sub.setText(W4Sub);
        }

        if(W5Sub == null)
        {
            tvSetW5Sub.setText(R.string.SetSub5);
        }
        else
        {
            tvSetW5Sub.setText(W5Sub);
        }

        if(W6Sub == null)
        {
            tvSetW6Sub.setText(R.string.SetSub6);
        }
        else
        {
            tvSetW6Sub.setText(W6Sub);
        }

        if(W7Sub == null)
        {
            tvSetW7Sub.setText(R.string.SetSub7);
        }
        else
        {
            tvSetW7Sub.setText(W7Sub);
        }

        if(W8Sub == null)
        {
            tvSetW8Sub.setText(R.string.SetSub8);
        }
        else
        {
            tvSetW8Sub.setText(W8Sub);
        }

        /**
         * Проверка классов на пустоту 
         * */

        if(W1Class == null)
        {
            tvSetW1Class.setText(R.string.SetClass1);
        }
        else
        {
            tvSetW1Class.setText(W1Class);
        }

        if(W2Class == null)
        {
            tvSetW2Class.setText(R.string.SetClass2);
        }
        else
        {
            tvSetW2Class.setText(W2Class);
        }

        if(W3Class == null)
        {
            tvSetW3Class.setText(R.string.SetClass3);
        }
        else
        {
            tvSetW3Class.setText(W3Class);
        }

        if(W4Class == null)
        {
            tvSetW4Class.setText(R.string.SetClass4);
        }
        else
        {
            tvSetW4Class.setText(W4Class);
        }

        if(W5Class == null)
        {
            tvSetW5Class.setText(R.string.SetClass5);
        }
        else
        {
            tvSetW5Class.setText(W5Class);
        }

        if(W6Class == null)
        {
            tvSetW6Class.setText(R.string.SetClass6);
        }
        else
        {
            tvSetW6Class.setText(W6Class);
        }

        if(W7Class == null)
        {
            tvSetW7Class.setText(R.string.SetClass7);
        }
        else
        {
            tvSetW7Class.setText(W7Class);
        }

        if(W8Class == null)
        {
            tvSetW8Class.setText(R.string.SetClass8);
        }
        else
        {
            tvSetW8Class.setText(W8Class);
        }
        /***/
        ImageView delSetW1Sub = v.findViewById(R.id.delSetW1Sub);
        delSetW1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W1Sub");
                editor.remove("W1Class");
                editor.apply();
                tvSetW1Sub.setText(R.string.SetSub1);
                tvSetW1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetW2Sub = v.findViewById(R.id.delSetW2Sub);
        delSetW2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W2Sub");
                editor.remove("W2Class");
                editor.apply();
                tvSetW2Sub.setText(R.string.SetSub2);
                tvSetW2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetW3Sub = v.findViewById(R.id.delSetW3Sub);
        delSetW3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W3Sub");
                editor.remove("W3Class");
                editor.apply();
                tvSetW3Sub.setText(R.string.SetSub3);
                tvSetW3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetW4Sub = v.findViewById(R.id.delSetW4Sub);
        delSetW4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W4Sub");
                editor.remove("W4Class");
                editor.apply();
                tvSetW4Sub.setText(R.string.SetSub4);
                tvSetW4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetW5Sub = v.findViewById(R.id.delSetW5Sub);
        delSetW5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W5Sub");
                editor.remove("W5Class");
                editor.apply();
                tvSetW5Sub.setText(R.string.SetSub5);
                tvSetW5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetW6Sub = v.findViewById(R.id.delSetW6Sub);
        delSetW6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W6Sub");
                editor.remove("W6Class");
                editor.apply();
                tvSetW6Sub.setText(R.string.SetSub6);
                tvSetW6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetW7Sub = v.findViewById(R.id.delSetW7Sub);
        delSetW7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W7Sub");
                editor.remove("W7Class");
                editor.apply();
                tvSetW7Sub.setText(R.string.SetSub7);
                tvSetW7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetW8Sub = v.findViewById(R.id.delSetW8Sub);
        delSetW8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("W8Sub");
                editor.remove("W8Class");
                editor.apply();
                tvSetW8Sub.setText(R.string.SetSub8);
                tvSetW8Class.setText(R.string.SetClass8);
            }
        });
        /***/

        title = v.findViewById(R.id.tvWRasp);
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W1Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W2Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W3Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W4Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W5Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W6Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W7Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W8Sub", str);
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W1Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W2Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W3Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W4Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W5Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W6Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W7Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("W8Class", str);
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

        btnThurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String W1Sub = etW1Sub.getText().toString();
                String W1Class = etW1Class.getText().toString();
                SPEditor.putString("W1Sub",W1Sub);
                SPEditor.putString("W1Class",W1Class);
                SPEditor.apply();

                String W2Sub = etW2Sub.getText().toString();
                String W2Class = etW2Class.getText().toString();
                SPEditor.putString("W2Sub",W2Sub);
                SPEditor.putString("W2Class",W2Class);
                SPEditor.apply();

                String W3Sub = etW3Sub.getText().toString();
                String W3Class = etW3Class.getText().toString();
                SPEditor.putString("W3Sub",W3Sub);
                SPEditor.putString("W3Class",W3Class);
                SPEditor.apply();

                String W4Sub = etW4Sub.getText().toString();
                String W4Class = etW4Class.getText().toString();
                SPEditor.putString("W4Sub",W4Sub);
                SPEditor.putString("W4Class",W4Class);
                SPEditor.apply();

                String W5Sub = etW5Sub.getText().toString();
                String W5Class = etW5Class.getText().toString();
                SPEditor.putString("W5Sub",W5Sub);
                SPEditor.putString("W5Class",W5Class);
                SPEditor.apply();

                String W6Sub = etW6Sub.getText().toString();
                String W6Class = etW6Class.getText().toString();
                SPEditor.putString("W6Sub",W6Sub);
                SPEditor.putString("W6Class",W6Class);
                SPEditor.apply();

                String W7Sub = etW7Sub.getText().toString();
                String W7Class = etW7Class.getText().toString();
                SPEditor.putString("W7Sub",W7Sub);
                SPEditor.putString("W7Class",W7Class);
                SPEditor.apply();

                String W8Sub = etW8Sub.getText().toString();
                String W8Class = etW8Class.getText().toString();
                SPEditor.putString("W8Sub",W8Sub);
                SPEditor.putString("W8Class",W8Class);
                SPEditor.apply();*/

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