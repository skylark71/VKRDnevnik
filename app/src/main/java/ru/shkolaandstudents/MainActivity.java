package ru.shkolaandstudents;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;

import ru.shkolaandstudents.ui.main.AboutFragment;
import ru.shkolaandstudents.ui.main.HomeFragment;
import ru.shkolaandstudents.ui.main.SettingsFragment;
import ru.shkolaandstudents.ui.main.StudyFragment;

/**
 * Главное активити приложения.
 */
public class MainActivity extends AppCompatActivity {

    private final static int THEME_LIGHT = 1;
    private final static int THEME_DARK = 2;

    ReviewManager manager;
    ReviewInfo reviewInfo;

    /**
     * Объект класса Utilities.
     */
    private Utilities utils = new Utilities(this);

    /**
     * Элемент интерфейса - Toolbar.
     */
    private Toolbar toolbar;

    /**
     * Элемент интерфейса - DrawerLayout.
     */
    private DrawerLayout mDrawer;

    /**
     * Элемент интерфейса - ActionBarDrawerToggle.
     */
    private ActionBarDrawerToggle drawerToggle;

    /**
     * Элемент интерфейса - NavigationView.
     */
    private NavigationView nvDrawer;

    /**
     * Метод установки цветовой схемы приложения (темы).
     */
    public void updateTheme() {
        Menu drawerMenu = nvDrawer.getMenu();
        drawerMenu.findItem(R.id.study_menu).setChecked(true);

        drawerMenu.findItem(R.id.teacher_class).setVisible(false);
        drawerMenu.findItem(R.id.teacher_journal).setVisible(false);

        if (utils.getTheme(getApplicationContext()) == THEME_LIGHT) {
            setTheme(R.style.AppTheme_Light);

            drawerMenu.findItem(R.id.study_menu).setIcon(R.drawable.w_table);
            drawerMenu.findItem(R.id.homepage).setIcon(R.drawable.ocr_homelogo);
            drawerMenu.findItem(R.id.settingspage).setIcon(R.drawable.settingspage_icon_black);
            drawerMenu.findItem(R.id.aboutpage).setIcon(R.drawable.aboutpage_icon_black);
            drawerMenu.findItem(R.id.exitpage).setIcon(R.drawable.exitpage_icon_black);
            drawerMenu.findItem(R.id.connectpage).setIcon(R.drawable.connectpage_icon_black);

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        } else if (utils.getTheme(getApplicationContext()) == THEME_DARK) {
            setTheme(R.style.AppTheme_Dark);

            nvDrawer.setBackgroundColor(Color.parseColor("#2d2d2d"));
            nvDrawer.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
            drawerMenu.findItem(R.id.homepage).setIcon(R.drawable.homepage_icon_white);
            drawerMenu.findItem(R.id.settingspage).setIcon(R.drawable.settingspage_icon_white);
            drawerMenu.findItem(R.id.aboutpage).setIcon(R.drawable.aboutpage_icon_white);
            drawerMenu.findItem(R.id.exitpage).setIcon(R.drawable.exitpage_icon_white);
            drawerMenu.findItem(R.id.connectpage).setIcon(R.drawable.connectpage_icon_white);

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    /**
     * Метод, вызываемый при инициализации активити.
     * В процессе его работы настраиваем интерфейс (Navigation Drawer, ActionBar), устанавливаем цветовую схему приложения
     * и запускаем HomeFragment.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //ПЕРВЫЙ ЗАПУСК
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            startActivity(new Intent(MainActivity.this, ActivitySchoolManMenu.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nvDrawer = findViewById(R.id.nvView);
        mDrawer = findViewById(R.id.drawer_layout);

        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        mDrawer.addDrawerListener(drawerToggle);
        nvDrawer.setItemIconTintList(null);

        setupDrawerContent(nvDrawer);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, StudyFragment.newInstance())
                    .commitNow();
        }

        final SharedPreferences BD = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (BD.contains("OCR_APP_THEME")) {
            updateTheme();
        } else {
            BD.edit().putInt(getApplicationContext().getString(R.string.prefs_theme_key), THEME_LIGHT).apply();
            SharedPreferences.Editor BDEditor = BD.edit();
            BDEditor.putString("OCR_APP_THEME", "ID_184154");
            BDEditor.apply();
            updateTheme();
        }
    }

    /**
     * Метод, вызываемый при двойном нажатии на кнопку назад.
     * При двойном нажатии кнопки назад открывается\закрывается боковое меню.
     */
    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else {
            drawer.openDrawer(GravityCompat.START);
        }
        /*
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        */
        FragmentManager fm = getSupportFragmentManager();
        OnBackPressedListener backPressedListener = null;
        for (Fragment fragment: fm.getFragments()) {
            if (fragment instanceof  OnBackPressedListener) {
                backPressedListener = (OnBackPressedListener) fragment;
                break;
            }
        }

        if (backPressedListener != null) {
            backPressedListener.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Метод, вызываемый после onCreate().
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    /**
     * Метод, вызываемый при изменении конфигураии устройства (например, ориентации дисплея).
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Метод, реализующий инициализацию кнопки в ActionBar-е,
     * предназначенной для открытия бокового меню.
     */
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    /**
     * Метод, вызываемый для обработки нажатий пунктов меню.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Метод, вызываемый для настройки бокового меню.
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    /**
     * Метод, предназначенный для предопределения действий при нажатии на определенные пункты бокового меню.
     * При нажатии на пункт бокового меню - запускается соответствующий фрагмент или выполняется определенное действие.
     */
    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;
        int moveAction;
        Class fragmentClass;

        Menu menu = nvDrawer.getMenu();
        menu.findItem(R.id.study_menu).setChecked(false);

        switch (menuItem.getItemId()) {
            case R.id.study_menu:
                moveAction = 1;
                fragmentClass = StudyFragment.class;
                break;
            case R.id.homepage:
                moveAction = 1;
                fragmentClass = HomeFragment.class;
                break;
            case R.id.settingspage:
                moveAction = 1;
                fragmentClass = SettingsFragment.class;
                break;
            case R.id.aboutpage:
                moveAction = 1;
                fragmentClass = AboutFragment.class;
                break;
            case R.id.exitpage:
                moveAction = 0;
                fragmentClass = null;
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
                    View view = LayoutInflater.from(MainActivity.this).inflate(
                            R.layout.layout_exit,
                            (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
                    );
                    builder.setView(view);
                    ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.exit));
                    ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.exit_title));
                    ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_warning_white);
                    final AlertDialog alertDialog = builder.create();
                    view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(Intent.ACTION_MAIN);
                            i.addCategory(Intent.CATEGORY_HOME);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        }
                    });

                    view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });

                    if(alertDialog.getWindow()!=null)
                    {
                        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    }
                    alertDialog.show();
                }
                else
                {
                    new AlertDialog.Builder(this)
                            .setTitle(R.string.exit_question)
                            .setMessage(R.string.exit_q_conf)
                            .setNegativeButton(android.R.string.no, null)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {
                                    moveTaskToBack(true);
                                    MainActivity.super.onBackPressed();
                                }
                            }).create().show();
                }
                break;
            case R.id.connectpage:
                moveAction = 0;
                fragmentClass = null;
                manager = ReviewManagerFactory.create(MainActivity.this);
                Task<ReviewInfo> request = manager.requestReviewFlow();
                request.addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
                    @Override
                    public void onComplete(@NonNull Task<ReviewInfo> task) {
                        if(task.isSuccessful())
                        {
                            reviewInfo = task.getResult();
                            StartActivity(MainActivity.this, reviewInfo);

                        }
                        else
                        {
                            //СООБЩЕНИЕ ДЛЯ ТЕСТА
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();;
                        }
                    }
                });
                break;

            case R.id.add_person:
                moveAction = 1;
                fragmentClass = AddPersonFragment.class;
                break;
            case R.id.open_person:
                moveAction = 1;
                fragmentClass = AccountFragment.class;
                break;
            default:
                moveAction = 0;
                fragmentClass = HomeFragment.class;
        }

        if (moveAction == 1) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                utils.switchFragment(this, fragment);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        menuItem.setChecked(true);

        mDrawer.closeDrawers();
    }

    private void StartActivity(MainActivity mainActivity, ReviewInfo reviewInfo) {
        Task<Void> flow = manager.launchReviewFlow(MainActivity.this,reviewInfo);
        flow.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void result) {

            }
        });
    }
}
