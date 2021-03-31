package ru.shkolaandstudents.Teacher;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.util.Locale;

import ru.shkolaandstudents.Notifications.ActivityNotification;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.RecyclerViewTeacher.TeacherActivityCreateClassAndSubList;
import ru.shkolaandstudents.RecyclerViewTeacher.TeacherActivitySetClassList;
import ru.shkolaandstudents.Utilities;
import ru.shkolaandstudents.ui.main.SetTimeFragment;

import static android.content.Context.MODE_PRIVATE;


public class TeacherFragmentSettings extends Fragment {

    private Utilities utils = new Utilities(getContext());

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.teacher_fragment_settings, container, false);
        Button clearCache = v.findViewById(R.id.clearCache_teacher);


        clearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View progressDialogView = inflater.inflate(R.layout.progress_dialog, null);
                AlertDialog.Builder progressDialogBuilder = new AlertDialog.Builder(getActivity());
                progressDialogBuilder.setView(progressDialogView);
                progressDialogBuilder.setCancelable(false);
                final AlertDialog progressDialog = progressDialogBuilder.create();
                progressDialog.show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (utils.deleteDir(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "OCR"))) {
                            progressDialog.dismiss();
                            utils.createOCRFolder();
                            utils.copyAssets("rus.traineddata");
                            utils.copyAssets("eng.traineddata");
                            utils.showSnackBar(getView(), getResources().getString(R.string.cleanup_success));
                        } else {
                            utils.showSnackBar(getView(), getResources().getString(R.string.cleanup_error));
                        }
                    }
                }, 1500);

            }
        });

        Button btnSettingsStudy = v.findViewById(R.id.btnSettingsTeacher);
        btnSettingsStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.switchFragment(getActivity(), new TeacherFragmentSettingStudy());
            }
        });

        Button btnSettingNotification = v.findViewById(R.id.btnSettingNotif_teacher);
        btnSettingNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, new SettingNotificationFragment());
//                transaction.commit();

                Intent intent = new Intent(getActivity(), ActivityNotification.class);
                startActivity(intent);
            }
        });

        Button btnSetClassList = v.findViewById(R.id.btnSetClassList_teacher);
        btnSetClassList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TeacherActivitySetClassList.class);
                startActivity(intent);
            }
        });

        Button btnCreateClassAndSubList = v.findViewById(R.id.btnSetClassAndSubList_teacher);
        btnCreateClassAndSubList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TeacherActivityCreateClassAndSubList.class);
                startActivity(intent);
            }
        });

        Button btnSetTime = v.findViewById(R.id.btnSetTime_teacher);
        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new TeacherFragmentSetTime());
                transaction.commit();
            }
        });

        Button btnChangeLang = v.findViewById(R.id.ChangeLang_teacher);
        btnChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });

        return v;
    }

    /**
     * 3 Метода ниже служат
     * для изменения языка в программе
     **/

    private void showChangeLanguageDialog() {
        final String[] listItems = {"Azərbaycan", "Deutsche", "English", "Español", "Eestlane", "français", "հայերեն", "ქართული", "Қазақ", "Кыргызча", "Lietuvis", "Latvietis", "Română", "Русский", "Точик", "Український", "O'zbek"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setTitle(R.string.select_lang);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("az");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 1) {
                    setLocale("de");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 2) {
                    setLocale("en");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 3) {
                    setLocale("es");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 4) {
                    setLocale("et");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 5) {
                    setLocale("fr");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 6) {
                    setLocale("hy");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 7) {
                    setLocale("ka");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 8) {
                    setLocale("kk");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 9) {
                    setLocale("ky");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 10) {
                    setLocale("lt");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 11) {
                    setLocale("lv");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 12) {
                    setLocale("ro");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 13) {
                    setLocale("ru");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 14) {
                    setLocale("tg");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 15) {
                    setLocale("uk");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                } else if (i == 16) {
                    setLocale("uz");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(TeacherFragmentSettings.this)
                            .attach(TeacherFragmentSettings.this)
                            .commit();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getActivity().getBaseContext().getResources().updateConfiguration(config, this.getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = this.getActivity().getSharedPreferences("123", MODE_PRIVATE).edit();
        editor.putString("1", lang);
        editor.apply();
    }

    private void loadLocale() {
        SharedPreferences prefs = this.getActivity().getSharedPreferences("123", MODE_PRIVATE);
        String language = prefs.getString("1", "");
        setLocale(language);
    }
}