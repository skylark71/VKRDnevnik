package ru.shkolaandstudents.ui.Students;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import ru.shkolaandstudents.Notifications.ActivityNotification;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Utilities;

import java.io.File;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

/**
 * Фрагмент "Настройки программы".
 * Предназначен для предоставления пользователю возможностей изменения насттроек приложения (смена цветовой схемы, очистка кеша).
 */
public class SettingsFragment extends Fragment {

    private final static int THEME_LIGHT = 1;
    private final static int THEME_DARK = 2;

    /**
     * Объект класса Utilities.
     */
    private Utilities utils = new Utilities(getContext());

    /**
     * Метод диначеского создания нового экземпляра данного фрагмента.
     */
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    /**
     * Метод перезапуска активити (применяется для корректного изменения цветовой схемы приложения).
     */
    private void recreateActivity() {
        Intent intent = getActivity().getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
    }

    /**
     * Основной метод фрагмента.
     * В нем реализуется инициализация интерфейса, находятся обработчики кнопок и т.д.
     */
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.settings_fragment, container, false);

        ConstraintLayout home_layout = rootView.findViewById(R.id.settings_layout);
        Button clearCache = rootView.findViewById(R.id.clearCache);


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

        Button btnSettingsStudy = rootView.findViewById(R.id.btnSettingsStudy);
        btnSettingsStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SettingsStudyMenuFragment());
                transaction.commit();
            }
        });

        Button btnSettingNotification = rootView.findViewById(R.id.btnSettingNotif);
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

        Button btnSetTime = rootView.findViewById(R.id.btnSetTime);
        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivitySetTime.class);
                startActivity(intent);
            }
        });

        Button btnChangeLang = rootView.findViewById(R.id.ChangeLang);
        btnChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });

        return rootView;
    }
    /**
     * 3 Метода ниже служат
     * для изменения языка в программе
     **/

    private void showChangeLanguageDialog()
    {
        final String[] listItems = {"Azərbaycan","Deutsche","English","Español","Eestlane","français","հայերեն","ქართული","Қазақ","Кыргызча","Lietuvis","Latvietis","Română","Русский","Точик","Український","O'zbek"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setTitle(R.string.select_lang);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)
                {
                    setLocale("az");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==1)
                {
                    setLocale("de");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==2)
                {
                    setLocale("en");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==3)
                {
                    setLocale("es");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==4)
                {
                    setLocale("et");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==5)
                {
                    setLocale("fr");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==6)
                {
                    setLocale("hy");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==7)
                {
                    setLocale("ka");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==8)
                {
                    setLocale("kk");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==9)
                {
                    setLocale("ky");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==10)
                {
                    setLocale("lt");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==11)
                {
                    setLocale("lv");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==12)
                {
                    setLocale("ro");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==13)
                {
                    setLocale("ru");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==14)
                {
                    setLocale("tg");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==15)
                {
                    setLocale("uk");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
                            .commit();
                }
                else if(i==16)
                {
                    setLocale("uz");
                    getFragmentManager()
                            .beginTransaction()
                            .detach(SettingsFragment.this)
                            .attach(SettingsFragment.this)
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
        this.getActivity().getBaseContext().getResources().updateConfiguration(config,this.getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = this.getActivity().getSharedPreferences("123",MODE_PRIVATE).edit();
        editor.putString("1", lang);
        editor.apply();
    }

    private void loadLocale()
    {
        SharedPreferences prefs = this.getActivity().getSharedPreferences("123", MODE_PRIVATE);
        String language = prefs.getString("1", "");
        setLocale(language);
    }
}
