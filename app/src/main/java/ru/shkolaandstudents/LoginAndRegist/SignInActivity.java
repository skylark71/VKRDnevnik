package ru.shkolaandstudents.LoginAndRegist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.MainActivity;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Teacher.TeacherMainActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText emailEt, passwordEt;
    private Button SignInButton;
    private TextView SignUpTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        SignInButton = findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);
        SignUpTv = findViewById(R.id.signUpTv);

        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void Login()
    {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            emailEt.setError("Enter your email");
            return;
        }
        else if (TextUtils.isEmpty(password))
        {
            passwordEt.setError("Enter your password");
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                boolean isNewUser = task.getResult().getAdditionalUserInfo().isNewUser();
                if (isNewUser) {
                    Toast.makeText(SignInActivity.this,"Is New User!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignInActivity.this,"Is Old User!",Toast.LENGTH_SHORT).show();
                }

                if(task.isSuccessful())
                {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final boolean[] flag = new boolean[1];
                    reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Account");
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            flag[0] = (Boolean) snapshot.child("teacher").getValue();
                            Intent intent;
                            if(flag[0])
                            {
                                intent = new Intent(SignInActivity.this, TeacherMainActivity.class);
                            }
                            else
                            {
                                intent = new Intent(SignInActivity.this, MainActivity.class);
                            }
                            startActivity(intent);
                            //Toast.makeText(SignInActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();


                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
                else
                {
                    Toast.makeText(SignInActivity.this,"Sign In fail!",Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();
            }
        });


    }

    private Boolean isValidEmail(CharSequence target)
    {
        return  (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
