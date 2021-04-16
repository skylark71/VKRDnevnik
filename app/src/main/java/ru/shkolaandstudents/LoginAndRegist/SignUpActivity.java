package ru.shkolaandstudents.LoginAndRegist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Teacher.TeacherActivitySignUpSchool;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEt, passwordEt1, passwordEt2, etLastName, etFirstName, etOtchest;
    private Button SignUpButton;
    private TextView SignInTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private SwitchCompat switchCompat;
    private TextView tvviewschool, tvviewschool1;
    private TextView tvViewClass, tvViewClass1;
    private EditText etCreateClass;
    private RelativeLayout rl_ViewCreateClass;
    private LinearLayout ll_viewclass;
    boolean teacher = false;
    DatabaseReference ref;

    String email ;
    String password1 ;
    String password2;
    String lastname;
    String firstname ;
    String otchest ;
    String str_class1 ;
    String str_class2 ;
    String str_class;
    String uid ;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firebaseAuth = FirebaseAuth.getInstance();

        emailEt = findViewById(R.id.email);
        passwordEt1 = findViewById(R.id.password1);
        passwordEt2 = findViewById(R.id.password2);
        SignUpButton = findViewById(R.id.register);
        etLastName = findViewById(R.id.etLastName);
        etFirstName = findViewById(R.id.etFirstName);
        etOtchest = findViewById(R.id.edOtchest);
        progressDialog = new ProgressDialog(this);
        SignInTv = findViewById(R.id.signInTv);
        tvviewschool = findViewById(R.id.tvviewschool);
        tvviewschool1 = findViewById(R.id.tvviewschool_1);
        ll_viewclass = findViewById(R.id.ll_classview);
        tvViewClass = findViewById(R.id.tvViewClass);
        tvViewClass1 = findViewById(R.id.tvViewClass1);
        rl_ViewCreateClass = findViewById(R.id.rlViewCreateClass);
        etCreateClass = findViewById(R.id.etCreateClass);

        rl_ViewCreateClass.setVisibility(View.GONE);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

        SignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        switchCompat = findViewById(R.id.switchbutton);
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchCompat.isChecked()) {
                    teacher = true;
                    ll_viewclass.setVisibility(View.GONE);
                    rl_ViewCreateClass.setVisibility(View.GONE);
                } else {
                    teacher = false;
                    ll_viewclass.setVisibility(View.VISIBLE);
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this, R.style.AlertDialogTheme);
        View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
        builder.setTitle("Выберите 1 предмет");
        builder.setView(view);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
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

                final ArrayAdapter arrayAdapterSchool = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_spinner_item, strSchoolandCity);

                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this, R.style.AlertDialogTheme);
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
                        Toast.makeText(SignUpActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        String str = strSchool[index];
                        if (str.equals("Выберите школу")) {
                            str = "неизвестно";
                        }
                        tvviewschool1.setText(str);
                        tvviewschool.setText("Школа");
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Вашей школы нет? Жми сюда", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SignUpActivity.this, TeacherActivitySignUpSchool.class);
                        startActivity(intent);
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();

                tvviewschool1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vw) {

                        tvViewClass1.setText("неизвестно");

                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this, R.style.AlertDialogTheme);
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
                                Toast.makeText(SignUpActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                String str = strSchool[index];
                                if (str.equals("Выберите школу")) {
                                    str = "неизвестно";
                                }
                                tvviewschool1.setText(str);
                                tvviewschool.setText("Школа");
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setNegativeButton("Вашей школы нет? Жми сюда", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SignUpActivity.this, TeacherActivitySignUpSchool.class);
                                startActivity(intent);
                                dialogInterface.dismiss();
                            }
                        });


                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        tvViewClass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = true;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    String School = tvviewschool1.getText().toString();
                    ref = database.getReference(School);
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

                            final ArrayAdapter arrayAdapterSchool = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_spinner_item, strClass);
                            if (flag) {
                                flag = false;
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this, R.style.AlertDialogTheme);
                                View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub, null);
                                builder.setTitle("Выберите класс");
                                builder.setView(view);
                                final Spinner spinner = view.findViewById(R.id.spinner1);

                                arrayAdapterSchool.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                                spinner.setAdapter(arrayAdapterSchool);
                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(SignUpActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                        String str = spinner.getSelectedItem().toString();
                                        if (str.equals("Выберите класс")) {
                                            str = "неизвестно";
                                        }
                                        tvViewClass.setText("Класс:");
                                        tvViewClass1.setText(str);
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setNegativeButton("Не нашёл свой класс? Создай его", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                        rl_ViewCreateClass.setVisibility(View.VISIBLE);
                                        ll_viewclass.setVisibility(View.GONE);
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

        });

    }


    private void Register() {

        email = emailEt.getText().toString();
        password1 = passwordEt1.getText().toString();
        lastname = etLastName.getText().toString();
        firstname = etFirstName.getText().toString();
        otchest = etOtchest.getText().toString();
        password2 = passwordEt2.getText().toString();
        String str_class11 = "Класс ";
        str_class1 =  str_class11 + etCreateClass.getText().toString();
        final String result = str_class1.replaceAll("^\"+|\"+$", "");
        str_class2 = tvViewClass1.getText().toString();
        final String School = tvviewschool1.getText().toString();

        if(result.equals("Класс "))
        {
            str_class = str_class2;
        }
        else
        {
            str_class = result;
        }



        if(teacher)
        {
            if (TextUtils.isEmpty(email)) {
                emailEt.setError("Введите почту");
                return;
            } else if (TextUtils.isEmpty(password1)) {
                passwordEt1.setError("Введите пароль");
                return;
            } else if (TextUtils.isEmpty(password2)) {
                passwordEt2.setError("Подтвердите пароль");
                return;
            } else if (!password1.equals(password2)) {
                passwordEt2.setError("Пароли не совпадают");
                return;
            } else if (password1.length() < 4) {
                passwordEt1.setError("Пароль больше 4 символов");
                return;
            } else if (!isValidEmail(email)) {
                emailEt.setError("Некорректная почта");
                return;
            } else if (School.equals("неизвестно") || School.equals("сюда")) {
                emailEt.setError("Укажите школу");
                return;
            }
        }
        else {

            if (TextUtils.isEmpty(email)) {
                emailEt.setError("Введите почту");
                return;
            } else if (TextUtils.isEmpty(password1)) {
                passwordEt1.setError("Введите пароль");
                return;
            } else if (TextUtils.isEmpty(password2)) {
                passwordEt2.setError("Подтвердите пароль");
                return;
            } else if (!password1.equals(password2)) {
                passwordEt2.setError("Пароли не совпадают");
                return;
            } else if (password1.length() < 4) {
                passwordEt1.setError("Пароль больше 4 символов");
                return;
            } else if (!isValidEmail(email)) {
                emailEt.setError("Некорректная почта");
                return;
            } else if (School.equals("неизвестно") || School.equals("сюда")) {
                emailEt.setError("Укажите школу");
                return;
            } else if (str_class.equals("сюда")) {
                emailEt.setError("Укажите класс в школе");
                return;
            }
        }

        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            if(teacher)
                            {
                                str_class = School;
                                User user = new User(lastname, firstname, otchest, email, teacher, str_class);

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .child("Account")
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignUpActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(SignUpActivity.this, "Sign up fail!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else {
                                User user = new User(lastname, firstname, otchest, email, teacher, str_class);

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .child("Account")
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                            String str_class11 = "Класс ";
                                            str_class1 =  str_class11 + etCreateClass.getText().toString();
                                            final String result = str_class1.replaceAll("^\"+|\"+$", "");
                                            str_class2 = tvViewClass1.getText().toString();
                                            if(result.equals("Класс "))
                                            {
                                                str_class = str_class2;
                                            }
                                            else
                                            {
                                                str_class = result;
                                            }
                                            String School = tvviewschool1.getText().toString();
                                            ref = FirebaseDatabase.getInstance().getReference(School).child(str_class);
                                            String key = ref.push().getKey();
                                            assert key != null;
                                            ref.child(key).child("LastName").setValue(lastname);
                                            ref.child(key).child("FirstName").setValue(firstname);
                                            ref.child(key).child("Otchestvo").setValue(otchest);
                                            ref.child(key).child("Uid").setValue(uid);
                                            Toast.makeText(SignUpActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(SignUpActivity.this, "Sign up fail!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this, "Sign up fail!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private Boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}