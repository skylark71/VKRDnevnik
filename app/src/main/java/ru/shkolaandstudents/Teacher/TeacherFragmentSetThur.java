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

public class TeacherFragmentSetThur extends Fragment implements OnBackPressedListener
{
    Utilities utils = new Utilities(getActivity());

    Button btnFri,btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;

    ArrayList<ExampleItem> mExampleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_set_thur, container, false);

        btnHelp = v.findViewById(R.id.btnThHelp);
        btnFri = v.findViewById(R.id.btnThAccess);

        /***/
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

        /***/
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String Th1Sub = sp.getString("Th1Sub", null);
        String Th2Sub = sp.getString("Th2Sub", null);
        String Th3Sub = sp.getString("Th3Sub", null);
        String Th4Sub = sp.getString("Th4Sub", null);
        String Th5Sub = sp.getString("Th5Sub", null);
        String Th6Sub = sp.getString("Th6Sub", null);
        String Th7Sub = sp.getString("Th7Sub", null);
        String Th8Sub = sp.getString("Th8Sub", null);

        String Th1Class = sp.getString("Th1Class", null);
        String Th2Class = sp.getString("Th2Class", null);
        String Th3Class = sp.getString("Th3Class", null);
        String Th4Class = sp.getString("Th4Class", null);
        String Th5Class = sp.getString("Th5Class", null);
        String Th6Class = sp.getString("Th6Class", null);
        String Th7Class = sp.getString("Th7Class", null);
        String Th8Class = sp.getString("Th8Class", null);

        if(Th1Sub == null)
        {
            tvSetTh1Sub.setText(R.string.SetSub1);
        }
        else
        {
            tvSetTh1Sub.setText(Th1Sub);
        }

        if(Th2Sub == null)
        {
            tvSetTh2Sub.setText(R.string.SetSub2);
        }
        else
        {
            tvSetTh2Sub.setText(Th2Sub);
        }

        if(Th3Sub == null)
        {
            tvSetTh3Sub.setText(R.string.SetSub3);
        }
        else
        {
            tvSetTh3Sub.setText(Th3Sub);
        }

        if(Th4Sub == null)
        {
            tvSetTh4Sub.setText(R.string.SetSub4);
        }
        else
        {
            tvSetTh4Sub.setText(Th4Sub);
        }

        if(Th5Sub == null)
        {
            tvSetTh5Sub.setText(R.string.SetSub5);
        }
        else
        {
            tvSetTh5Sub.setText(Th5Sub);
        }

        if(Th6Sub == null)
        {
            tvSetTh6Sub.setText(R.string.SetSub6);
        }
        else
        {
            tvSetTh6Sub.setText(Th6Sub);
        }

        if(Th7Sub == null)
        {
            tvSetTh7Sub.setText(R.string.SetSub7);
        }
        else
        {
            tvSetTh7Sub.setText(Th7Sub);
        }

        if(Th8Sub == null)
        {
            tvSetTh8Sub.setText(R.string.SetSub8);
        }
        else
        {
            tvSetTh8Sub.setText(Th8Sub);
        }

        /**
         * Проверка классов на пустоту 
         * */

        if(Th1Class == null)
        {
            tvSetTh1Class.setText(R.string.SetClass1);
        }
        else
        {
            tvSetTh1Class.setText(Th1Class);
        }

        if(Th2Class == null)
        {
            tvSetTh2Class.setText(R.string.SetClass2);
        }
        else
        {
            tvSetTh2Class.setText(Th2Class);
        }

        if(Th3Class == null)
        {
            tvSetTh3Class.setText(R.string.SetClass3);
        }
        else
        {
            tvSetTh3Class.setText(Th3Class);
        }

        if(Th4Class == null)
        {
            tvSetTh4Class.setText(R.string.SetClass4);
        }
        else
        {
            tvSetTh4Class.setText(Th4Class);
        }

        if(Th5Class == null)
        {
            tvSetTh5Class.setText(R.string.SetClass5);
        }
        else
        {
            tvSetTh5Class.setText(Th5Class);
        }

        if(Th6Class == null)
        {
            tvSetTh6Class.setText(R.string.SetClass6);
        }
        else
        {
            tvSetTh6Class.setText(Th6Class);
        }

        if(Th7Class == null)
        {
            tvSetTh7Class.setText(R.string.SetClass7);
        }
        else
        {
            tvSetTh7Class.setText(Th7Class);
        }

        if(Th8Class == null)
        {
            tvSetTh8Class.setText(R.string.SetClass8);
        }
        else
        {
            tvSetTh8Class.setText(Th8Class);
        }
        /***/
        ImageView delSetTh1Sub = v.findViewById(R.id.delSetTh1Sub);
        delSetTh1Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th1Sub");
                editor.remove("Th1Class");
                editor.apply();
                tvSetTh1Sub.setText(R.string.SetSub1);
                tvSetTh1Class.setText(R.string.SetClass1);
            }
        });

        ImageView delSetTh2Sub = v.findViewById(R.id.delSetTh2Sub);
        delSetTh2Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th2Sub");
                editor.remove("Th2Class");
                editor.apply();
                tvSetTh2Sub.setText(R.string.SetSub2);
                tvSetTh2Class.setText(R.string.SetClass2);
            }
        });

        ImageView delSetTh3Sub = v.findViewById(R.id.delSetTh3Sub);
        delSetTh3Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th3Sub");
                editor.remove("Th3Class");
                editor.apply();
                tvSetTh3Sub.setText(R.string.SetSub3);
                tvSetTh3Class.setText(R.string.SetClass3);
            }
        });

        ImageView delSetTh4Sub = v.findViewById(R.id.delSetTh4Sub);
        delSetTh4Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th4Sub");
                editor.remove("Th4Class");
                editor.apply();
                tvSetTh4Sub.setText(R.string.SetSub4);
                tvSetTh4Class.setText(R.string.SetClass4);
            }
        });

        ImageView delSetTh5Sub = v.findViewById(R.id.delSetTh5Sub);
        delSetTh5Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th5Sub");
                editor.remove("Th5Class");
                editor.apply();
                tvSetTh5Sub.setText(R.string.SetSub5);
                tvSetTh5Class.setText(R.string.SetClass5);
            }
        });

        ImageView delSetTh6Sub = v.findViewById(R.id.delSetTh6Sub);
        delSetTh6Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th6Sub");
                editor.remove("Th6Class");
                editor.apply();
                tvSetTh6Sub.setText(R.string.SetSub6);
                tvSetTh6Class.setText(R.string.SetClass6);
            }
        });

        ImageView delSetTh7Sub = v.findViewById(R.id.delSetTh7Sub);
        delSetTh7Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th7Sub");
                editor.remove("Th7Class");
                editor.apply();
                tvSetTh7Sub.setText(R.string.SetSub7);
                tvSetTh7Class.setText(R.string.SetClass7);
            }
        });

        ImageView delSetTh8Sub = v.findViewById(R.id.delSetTh8Sub);
        delSetTh8Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Th8Sub");
                editor.remove("Th8Class");
                editor.apply();
                tvSetTh8Sub.setText(R.string.SetSub8);
                tvSetTh8Class.setText(R.string.SetClass8);
            }
        });
        /***/

        title = v.findViewById(R.id.tvThRasp);
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th1Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th2Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th3Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th4Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th5Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th6Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th7Sub", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th8Sub", str);
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th1Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th2Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th3Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th4Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th5Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th6Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th7Class", str);
                        editor.apply();
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String str = spinner.getSelectedItem().toString();
                        editor.putString("Th8Class", str);
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


        btnFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String Th1Sub = etTh1Sub.getText().toString();
                String Th1Class = etTh1Class.getText().toString();
                SPEditor.putString("Th1Sub",Th1Sub);
                SPEditor.putString("Th1Class",Th1Class);
                SPEditor.apply();

                String Th2Sub = etTh2Sub.getText().toString();
                String Th2Class = etTh2Class.getText().toString();
                SPEditor.putString("Th2Sub",Th2Sub);
                SPEditor.putString("Th2Class",Th2Class);
                SPEditor.apply();

                String Th3Sub = etTh3Sub.getText().toString();
                String Th3Class = etTh3Class.getText().toString();
                SPEditor.putString("Th3Sub",Th3Sub);
                SPEditor.putString("Th3Class",Th3Class);
                SPEditor.apply();

                String Th4Sub = etTh4Sub.getText().toString();
                String Th4Class = etTh4Class.getText().toString();
                SPEditor.putString("Th4Sub",Th4Sub);
                SPEditor.putString("Th4Class",Th4Class);
                SPEditor.apply();

                String Th5Sub = etTh5Sub.getText().toString();
                String Th5Class = etTh5Class.getText().toString();
                SPEditor.putString("Th5Sub",Th5Sub);
                SPEditor.putString("Th5Class",Th5Class);
                SPEditor.apply();

                String Th6Sub = etTh6Sub.getText().toString();
                String Th6Class = etTh6Class.getText().toString();
                SPEditor.putString("Th6Sub",Th6Sub);
                SPEditor.putString("Th6Class",Th6Class);
                SPEditor.apply();

                String Th7Sub = etTh7Sub.getText().toString();
                String Th7Class = etTh7Class.getText().toString();
                SPEditor.putString("Th7Sub",Th7Sub);
                SPEditor.putString("Th7Class",Th7Class);
                SPEditor.apply();

                String Th8Sub = etTh8Sub.getText().toString();
                String Th8Class = etTh8Class.getText().toString();
                SPEditor.putString("Th8Sub",Th8Sub);
                SPEditor.putString("Th8Class",Th8Class);
                SPEditor.apply();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new TeacherFragmentSetFri());
                transaction.commit();*/
                
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