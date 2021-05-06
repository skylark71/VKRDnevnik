package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ru.shkolaandstudents.LoginAndRegist.User;
import ru.shkolaandstudents.R;

public class TeacherCreateStudies extends AppCompatActivity {

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
    private LinearLayout ll_dolzhost, ll_moredata;
    DatabaseReference ref;
    Boolean teacher = false;
    String email;
    String password1;
    String password2;
    String lastname;
    String firstname;
    String otchest;
    String str_class1;
    String str_class2;
    String str_class;
    String uid;

    String class_name;
    String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Bundle arguments = getIntent().getExtras();
        class_name = arguments.get("class").toString();
        school = arguments.get("school").toString();

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
        ll_dolzhost = findViewById(R.id.ll_dolzhost);
        tvViewClass = findViewById(R.id.tvViewClass);
        tvViewClass1 = findViewById(R.id.tvViewClass1);
        rl_ViewCreateClass = findViewById(R.id.rlViewCreateClass);
        etCreateClass = findViewById(R.id.etCreateClass);
        switchCompat = findViewById(R.id.switchbutton);
        ll_moredata = findViewById(R.id.ll_moredata);

        rl_ViewCreateClass.setVisibility(View.GONE);
        ll_moredata.setVisibility(View.GONE);
        rl_ViewCreateClass.setVisibility(View.GONE);
        switchCompat.setVisibility(View.GONE);
        ll_dolzhost.setVisibility(View.GONE);
        tvviewschool1.setText(school);
        tvviewschool.setText("Школа:");
        tvViewClass.setText("Класс:");
        tvViewClass1.setText(class_name);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }


    private void Register() {

        email = emailEt.getText().toString();
        password1 = passwordEt1.getText().toString();

        lastname = etLastName.getText().toString();
        lastname = lastname.trim();
        lastname = lastname+" ";

        firstname = etFirstName.getText().toString();
        otchest = etOtchest.getText().toString();
        password2 = passwordEt2.getText().toString();
        String str_class11 = "Класс ";
        str_class1 = str_class11 + etCreateClass.getText().toString();
        final String result = str_class1.replaceAll("^\"+|\"+$", "");
        str_class2 = tvViewClass1.getText().toString();
        final String School = tvviewschool1.getText().toString();

        if (result.equals("Класс ")) {
            str_class = str_class2;
        } else {
            str_class = result;
        }

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

        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            User user = new User(lastname, firstname, otchest, email, teacher, str_class, School);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .child("Account")
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                        String str_class11 = "Класс ";
                                        str_class1 = str_class11 + etCreateClass.getText().toString();
                                        final String result = str_class1.replaceAll("^\"+|\"+$", "");
                                        str_class2 = tvViewClass1.getText().toString();
                                        if (result.equals("Класс ")) {
                                            str_class = str_class2;
                                        } else {
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
                                        Toast.makeText(TeacherCreateStudies.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(TeacherCreateStudies.this, "Sign up fail!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(TeacherCreateStudies.this, "Sign up fail!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private Boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
