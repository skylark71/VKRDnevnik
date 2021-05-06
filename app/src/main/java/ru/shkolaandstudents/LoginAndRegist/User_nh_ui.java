package ru.shkolaandstudents.LoginAndRegist;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ru.shkolaandstudents.R;
import ru.shkolaandstudents.RecyclerViewTeacher.TeacherSetClassList;

public class User_nh_ui extends AppCompatActivity {

    DatabaseReference ref;
    EditText et_set_ui_lastname, et_set_ui_firstname, et_set_ui_otch, et_set_ui_email;
    Button btn_ui_save;
    String lastname;
    String firstname;
    String otchest;
    String email;
    String str_class_old, str_class_new;
    String school;
    String uid;
    TextView tv_set_class, tv_ui_class;
    LinearLayout ll_ui_teacher;
    boolean flag = false;
    Boolean teacher;
    int cnt = 0;
    String[] arr_Sub;
    List<TextView> all_tv = new ArrayList<TextView>();

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ui);

        et_set_ui_lastname = findViewById(R.id.et_set_ui_lastname);
        et_set_ui_firstname = findViewById(R.id.et_set_ui_firstname);
        et_set_ui_otch = findViewById(R.id.et_set_ui_otch);
        et_set_ui_email = findViewById(R.id.et_set_ui_email);
        tv_set_class = findViewById(R.id.tv_set_class);
        ll_ui_teacher = findViewById(R.id.ll_ui_teacher);
        btn_ui_save = findViewById(R.id.btn_ui_save);
        tv_ui_class = findViewById(R.id.tv_ui_class);

        Bundle arguments = getIntent().getExtras();
        school = arguments.get("school").toString();
        teacher = arguments.getBoolean("teacher");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Account");
        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lastname = String.valueOf(snapshot.child("LastName").getValue());
                firstname = String.valueOf(snapshot.child("FirstName").getValue());
                otchest = String.valueOf(snapshot.child("Otchest").getValue());
                email = String.valueOf(snapshot.child("email").getValue());
                str_class_old = String.valueOf(snapshot.child("str_class").getValue());
                teacher = (Boolean) snapshot.child("teacher").getValue();

                if (teacher) {
                    tv_ui_class.setText("Школа");
                } else {
                    tv_ui_class.setText("Класс");
                }

                et_set_ui_lastname.setText(lastname);
                et_set_ui_firstname.setText(firstname);
                et_set_ui_otch.setText(otchest);
                et_set_ui_email.setText(email);
                tv_set_class.setText(str_class_old);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if (!teacher) {
            DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Оценки");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int i = 0;
                    int k = 0;
                    TextView tv;
                    all_tv.clear();
                    LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutRating);
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String line1 = ds.getKey();
                        //arr_Sub[i] = line1;
                        i++;
                    }

                    String[] strings1 = new String[i];
                    //ll.removeAllViews();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        tv = new TextView(User_nh_ui.this);
                        all_tv.add(tv);
                        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        tv.setLayoutParams(p);
                        tv.setId(k);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(18);
                        tv.setPadding(0, 12, 0, 0);
                        ll.addView(tv);
                        String line1 = ds.getKey();
                        strings1[k] = line1;
                        tv.setText(strings1[k]);
                        k++;
                    }

                    for (int ii = 0; ii < i; ii++) {
                        DatabaseReference reff2 = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Оценки").child(strings1[ii]);
                        //final int count = ii;
                        reff2.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                int i = 0;
                                int k = 0;
                                double average = 0;
                                for (DataSnapshot ds : snapshot.getChildren()) {
                                    String value = String.valueOf(ds.child("Оценка").getValue());
                                    if (!value.equals("Н")) {
                                        i++;
                                    }
                                }

                                int[] arr_val = new int[i];
                                for (DataSnapshot ds : snapshot.getChildren()) {
                                    String value = String.valueOf(ds.child("Оценка").getValue());
                                    if (!value.equals("Н")) {
                                        int val = Integer.parseInt(value);
                                        arr_val[k] = val;
                                        k++;
                                    }
                                }

                                for (int ii = 0; ii < i; ii++) {
                                    average = average + arr_val[ii];
                                }
                                average /= i;

                                LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutMarks);
                                TextView tv;
                                tv = new TextView(User_nh_ui.this);
                                all_tv.add(tv);
                                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                tv.setLayoutParams(p);
                                tv.setId(counter);
                                tv.setTextColor(Color.WHITE);
                                tv.setTextSize(20);
                                tv.setPadding(0, 10, 0, 0);
                                tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
                                ll.addView(tv);
                                tv.setText(String.valueOf(average));
                                counter++;
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


        tv_set_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!teacher) {
                    flag = true;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    ref = database.getReference(school);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int i = 0;
                            int j = 1;

                            for (DataSnapshot ds : snapshot.getChildren()) {
                                String str_class = ds.getKey();
                                j++;
                            }

                            final String[] strClass = new String[j];
                            strClass[0] = "Выберите класс";
                            for (DataSnapshot ds : snapshot.getChildren()) {
                                String str_school = ds.getKey();
                                strClass[i + 1] = str_school;
                                i++;
                            }

                            final ArrayAdapter arrayAdapterSchool = new ArrayAdapter(User_nh_ui.this, android.R.layout.simple_spinner_item, strClass);
                            if (flag) {
                                flag = false;
                                AlertDialog.Builder builder = new AlertDialog.Builder(User_nh_ui.this, R.style.AlertDialogTheme);
                                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                                builder.setTitle("Выберите класс");
                                builder.setView(view);
                                final Spinner spinner = view.findViewById(R.id.spinner1);

                                arrayAdapterSchool.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                                spinner.setAdapter(arrayAdapterSchool);
                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(User_nh_ui.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                        str_class_new = spinner.getSelectedItem().toString();
                                        if (str_class_new.equals("Выберите класс")) {
                                            str_class_new = "неизвестно";
                                        }
                                        tv_set_class.setText("Класс:");
                                        tv_set_class.setText(str_class_new);
                                        dialogInterface.dismiss();
                                    }
                                });

                                builder.setView(view);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                } else {
                    flag = true;
                    ref = database.getReference("Schools");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int i = 0;
                            int j = 1;

                            for (DataSnapshot ds : snapshot.getChildren()) {
                                String str_school = ds.child("NameSchool").getValue(String.class);
                                j++;
                            }

                            final String[] strSchool = new String[j];
                            final String[] strSchoolandCity = new String[j];
                            strSchool[0] = "Выберите школу";
                            strSchoolandCity[0] = "Выберите школу";
                            for (DataSnapshot ds : snapshot.getChildren()) {
                                String str_school = ds.child("NameSchool").getValue(String.class);
                                String str_cityschool = ds.child("CitySchool").getValue(String.class);
                                strSchoolandCity[i + 1] = str_school + " " + str_cityschool;
                                strSchool[i + 1] = str_school;
                                i++;
                            }

                            final ArrayAdapter arrayAdapterSchool = new ArrayAdapter(User_nh_ui.this, android.R.layout.simple_spinner_item, strSchoolandCity);

                            if (flag) {
                                flag = false;
                                AlertDialog.Builder builder = new AlertDialog.Builder(User_nh_ui.this, R.style.AlertDialogTheme);
                                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                                builder.setTitle("Выберите свою школу");
                                builder.setView(view);
                                final Spinner spinner = view.findViewById(R.id.spinner1);

                                arrayAdapterSchool.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                                spinner.setAdapter(arrayAdapterSchool);
                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        int index = spinner.getSelectedItemPosition();
                                        //Toast.makeText(SignUpActivity.this, String.valueOf(index), Toast.LENGTH_SHORT).show();
                                        Toast.makeText(User_nh_ui.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                        String str = strSchool[index];
                                        if (str.equals("Выберите школу")) {
                                            str = "неизвестно";
                                        }
                                        tv_set_class.setText(str);
                                        dialogInterface.dismiss();
                                    }
                                });


                                builder.setView(view);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        btn_ui_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lastname = et_set_ui_lastname.getText().toString();
                lastname = lastname.trim();
                lastname = lastname + " ";

                String firstname = et_set_ui_firstname.getText().toString();
                String otchest = et_set_ui_otch.getText().toString();
                String email = et_set_ui_email.getText().toString();
                String str_class = tv_set_class.getText().toString();
                if (!teacher) {

                    if (!isValidEmail(email) || email.isEmpty()) {
                        et_set_ui_email.setError("Некорректная почта");
                        return;
                    } else if (str_class.equals("неизвестно")) {
                        tv_set_class.setError("Укажите класс");
                        Toast.makeText(getApplicationContext(), "Укажите класс", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (lastname.isEmpty()) {
                        et_set_ui_lastname.setError("Укажите фамилию");
                        return;
                    } else if (firstname.isEmpty()) {
                        et_set_ui_firstname.setError("Укажите имя");
                        return;
                    } else if (otchest.isEmpty()) {
                        et_set_ui_otch.setError("Укажите отчество");
                        return;
                    }
                } else {
                    if (!isValidEmail(email) || email.isEmpty()) {
                        et_set_ui_email.setError("Некорректная почта");
                        return;
                    } else if (str_class.equals("неизвестно")) {
                        tv_set_class.setError("Укажите школу");
                        Toast.makeText(getApplicationContext(), "Укажите школу", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (lastname.isEmpty()) {
                        et_set_ui_lastname.setError("Укажите фамилию");
                        return;
                    } else if (firstname.isEmpty()) {
                        et_set_ui_firstname.setError("Укажите имя");
                        return;
                    } else if (otchest.isEmpty()) {
                        et_set_ui_otch.setError("Укажите отчество");
                        return;
                    }
                }

                ref = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Account");
                ref.child("LastName").setValue(lastname);
                ref.child("FirstName").setValue(firstname);
                ref.child("Otchest").setValue(otchest);
                ref.child("email").setValue(email);
                ref.child("str_class").setValue(str_class);

                if (!teacher) {
                    ref = FirebaseDatabase.getInstance().getReference(school).child(str_class);
                    String key = ref.push().getKey();
                    assert key != null;
                    ref.child(key).child("LastName").setValue(lastname);
                    ref.child(key).child("FirstName").setValue(firstname);
                    ref.child(key).child("Otchestvo").setValue(otchest);
                    ref.child(key).child("Uid").setValue(uid);

                    final String[] keyy = new String[1];

                    final String cals_old = str_class_old;

                    DatabaseReference reff = FirebaseDatabase.getInstance().getReference(school).child(cals_old);
                    reff.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot ds : snapshot.getChildren()) {
                                String uid_locale = String.valueOf(ds.child("Uid").getValue());
                                if (uid_locale.equals(uid) && cnt == 0) {
                                    keyy[0] = ds.getKey();
                                    cnt++;
                                }
                            }
                            cnt = 0;

                            DatabaseReference reff1 = FirebaseDatabase.getInstance().getReference(school).child(cals_old).child(keyy[0]);
                            reff1.removeValue();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });


                    Toast.makeText(getApplicationContext(), "Данные сохранены", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private Boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
