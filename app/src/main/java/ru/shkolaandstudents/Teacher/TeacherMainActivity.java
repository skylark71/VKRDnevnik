package ru.shkolaandstudents.Teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import ru.shkolaandstudents.LoginAndRegist.SignInActivity;
import ru.shkolaandstudents.LoginAndRegist.User_nh_ui;
import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.RecyclerViewTeacher.TeacherFragmentJournalList;
import ru.shkolaandstudents.Utilities;
import ru.shkolaandstudents.OCR.HomeFragment;

public class TeacherMainActivity extends AppCompatActivity {

    private final static int THEME_LIGHT = 1;
    private final static int THEME_DARK = 2;

    ReviewManager manager;
    ReviewInfo reviewInfo;

    /**
     * ???????????? ???????????? Utilities.
     */
    private Utilities utils = new Utilities(this);

    /**
     * ?????????????? ???????????????????? - Toolbar.
     */
    private Toolbar toolbar;

    /**
     * ?????????????? ???????????????????? - DrawerLayout.
     */
    private DrawerLayout teacher_mDrawer;

    /**
     * ?????????????? ???????????????????? - ActionBarDrawerToggle.
     */
    private ActionBarDrawerToggle teacher_drawerToggle;

    /**
     * ?????????????? ???????????????????? - NavigationView.
     */
    private NavigationView teacher_nvDrawer;

    /**
     * ?????????? ?????????????????? ???????????????? ?????????? ???????????????????? (????????).
     */
    public void updateTheme() {
        Menu drawerMenu = teacher_nvDrawer.getMenu();
        drawerMenu.findItem(R.id.study_menu).setChecked(true);

        /*drawerMenu.findItem(R.id.teacher_class).setVisible(true);
        drawerMenu.findItem(R.id.teacher_class).setTitle("??????????????");
        drawerMenu.findItem(R.id.teacher_class).setTitle("????????");*/
        drawerMenu.findItem(R.id.teacher_journal).setVisible(true);

        if (utils.getTheme(getApplicationContext()) == THEME_LIGHT) {
            setTheme(R.style.AppTheme_Light);

            drawerMenu.findItem(R.id.study_menu).setIcon(R.drawable.schedule50);
            drawerMenu.findItem(R.id.teacher_journal).setIcon(R.drawable.w_table);
            drawerMenu.findItem(R.id.homepage).setIcon(R.drawable.ocr_homelogo);
            drawerMenu.findItem(R.id.settingspage).setIcon(R.drawable.settings50);
            drawerMenu.findItem(R.id.aboutpage).setIcon(R.drawable.about50);
            drawerMenu.findItem(R.id.exitpage).setIcon(R.drawable.exit50);
            drawerMenu.findItem(R.id.connectpage).setIcon(R.drawable.feedback50);

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        }
    }

    /**
     * ??????????, ???????????????????? ?????? ?????????????????????????? ????????????????.
     * ?? ???????????????? ?????? ???????????? ?????????????????????? ?????????????????? (Navigation Drawer, ActionBar), ?????????????????????????? ???????????????? ?????????? ????????????????????
     * ?? ?????????????????? HomeFragment.
     */
    String lastname;
    String firstname;
    String school;
    Boolean teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reff1 = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Account");

        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                school = String.valueOf(snapshot.child("str_class").getValue());
                firstname = String.valueOf(snapshot.child("FirstName").getValue());
                lastname = String.valueOf(snapshot.child("LastName").getValue());
                teacher = (Boolean) snapshot.child("teacher").getValue();
                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("school", school);
                editor.apply();

                View headView = teacher_nvDrawer.getHeaderView(0);
                TextView tv_nh_lastname = headView.findViewById(R.id.tv_nh_lastname);
                TextView tv_nh_firstname = headView.findViewById(R.id.tv_nh_firstname);
                tv_nh_lastname.setText(lastname);
                tv_nh_firstname.setText(firstname);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("??????????????");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        teacher_nvDrawer = findViewById(R.id.nvView);
        teacher_mDrawer = findViewById(R.id.drawer_layout);

        teacher_drawerToggle = setupDrawerToggle();
        teacher_drawerToggle.setDrawerIndicatorEnabled(true);
        teacher_drawerToggle.syncState();

        teacher_mDrawer.addDrawerListener(teacher_drawerToggle);
        teacher_nvDrawer.setItemIconTintList(null);

        View headView = teacher_nvDrawer.getHeaderView(0);
        ImageView imageView = headView.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_nh_ui.class);
                intent.putExtra("school", school);
                intent.putExtra("teacher", teacher);
                startActivity(intent);
            }
        });

        setupDrawerContent(teacher_nvDrawer);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TeacherFragmentRasp.newInstance())
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
     * ??????????, ???????????????????? ?????? ?????????????? ?????????????? ???? ???????????? ??????????.
     * ?????? ?????????????? ?????????????? ???????????? ?????????? ??????????????????????\?????????????????????? ?????????????? ????????.
     */

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else {
            drawer.openDrawer(GravityCompat.START);
        }*/

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
     * ??????????, ???????????????????? ?????????? onCreate().
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        teacher_drawerToggle.syncState();
    }

    /**
     * ??????????, ???????????????????? ?????? ?????????????????? ?????????????????????? ???????????????????? (????????????????, ???????????????????? ??????????????).
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        teacher_drawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * ??????????, ?????????????????????? ?????????????????????????? ???????????? ?? ActionBar-??,
     * ?????????????????????????????? ?????? ???????????????? ???????????????? ????????.
     */
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, teacher_mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    /**
     * ??????????, ???????????????????? ?????? ?????????????????? ?????????????? ?????????????? ????????.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (teacher_drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ??????????, ???????????????????? ?????? ?????????????????? ???????????????? ????????.
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
     * ??????????, ?????????????????????????????? ?????? ?????????????????????????????? ???????????????? ?????? ?????????????? ???? ???????????????????????? ???????????? ???????????????? ????????.
     * ?????? ?????????????? ???? ?????????? ???????????????? ???????? - ?????????????????????? ?????????????????????????????? ???????????????? ?????? ?????????????????????? ???????????????????????? ????????????????.
     */
    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment;
        int moveAction;
        Class fragmentClass = null;

        Menu menu = teacher_nvDrawer.getMenu();
        menu.findItem(R.id.study_menu).setChecked(false);

        switch (menuItem.getItemId()) {
            case R.id.study_menu:
                moveAction = 1;
                /**fragmentClass = TeacherFragmentRasp.class;**/
                fragmentClass = TeacherFragmentRasp.class;
                break;
            /*case R.id.teacher_class:
                moveAction = 1;
                *//**fragmentClass = TeacherFragmentSetTuesday.class;**//*
                *//*moveAction = 1;
                fragmentClass = TeacherFragmentSetMonday.class;*//*
                Intent intent = new Intent(this, TeacherActivityCreateClassAndSubList.class);
                startActivity(intent);
                break;*/
            case R.id.teacher_journal:
                moveAction = 1;
                fragmentClass = TeacherFragmentJournalList.class;
                break;
            case R.id.homepage:
                moveAction = 1;
                fragmentClass = HomeFragment.class;
                break;
            case R.id.settingspage:
                moveAction = 1;
                fragmentClass = TeacherFragmentSettings.class;
                break;
            case R.id.aboutpage:
                moveAction = 1;
                //fragmentClass = AboutFragment.class;
                break;
            case R.id.exitpage:
                moveAction = 0;
                fragmentClass = null;
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TeacherMainActivity.this,R.style.AlertDialogTheme);
                    View view = LayoutInflater.from(TeacherMainActivity.this).inflate(
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
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(TeacherMainActivity.this, SignInActivity.class));
                            finish();
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
                                    TeacherMainActivity.super.onBackPressed();
                                }
                            }).create().show();
                }
                break;
            case R.id.connectpage:
                moveAction = 0;
                fragmentClass = null;
                manager = ReviewManagerFactory.create(TeacherMainActivity.this);
                Task<ReviewInfo> request = manager.requestReviewFlow();
                request.addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
                    @Override
                    public void onComplete(@NonNull Task<ReviewInfo> task) {
                        if(task.isSuccessful())
                        {
                            reviewInfo = task.getResult();
                            StartActivity(TeacherMainActivity.this, reviewInfo);

                        }
                        else
                        {
                            //?????????????????? ?????? ??????????
                            Toast.makeText(TeacherMainActivity.this, "Error", Toast.LENGTH_SHORT).show();;
                        }
                    }
                });
                break;

            /*case R.id.add_person:
                moveAction = 1;
                fragmentClass = AddPersonFragment.class;
                break;*/
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

        teacher_mDrawer.closeDrawers();
    }

    private void StartActivity(TeacherMainActivity TeacherMainActivity, ReviewInfo reviewInfo) {
        Task<Void> flow = manager.launchReviewFlow(TeacherMainActivity.this,reviewInfo);
        flow.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void result) {

            }
        });
    }
}