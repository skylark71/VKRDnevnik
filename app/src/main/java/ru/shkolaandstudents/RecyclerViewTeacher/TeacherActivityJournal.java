package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;

import ru.shkolaandstudents.R;

public class TeacherActivityJournal extends AppCompatActivity {
    public int numberOfLines = 1;
    String class_name;
    String sub_name;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_journal);

        Bundle arguments = getIntent().getExtras();
        class_name = arguments.get("Class").toString();
        sub_name = arguments.get("Subject").toString();
        TextView txt_class = findViewById(R.id.txt_class);
        TextView txt_sub = findViewById(R.id.txt_sub);

        txt_class.setText(class_name);
        txt_sub.setText(sub_name);

        /*SharedPreferences mSharedPreferences = getSharedPreferences(class_name, Activity.MODE_PRIVATE);
        numberOfLines = mSharedPreferences.getInt(class_name, 1);*/

        /****/
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(class_name);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                int k=0;
                for (DataSnapshot ds1 : snapshot.getChildren()){
                    String line1 = ds1.getValue(String.class);
                    i++;
                }
                numberOfLines = i;
                String[] strings1 = new String[i];
                TextView[]  ar_school_man = new TextView[numberOfLines];
                //ll.removeAllViews();
                for (DataSnapshot ds : snapshot.getChildren()){
                    String line1 = ds.getValue(String.class);
                    strings1[k] = line1;
                    String view_date = "school_man" + (k + 1);
                    int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                    ar_school_man[k] = ((TextView) findViewById(resIDdate));
                    strings1[k] = line1;
                    ar_school_man[k].setText(strings1[k]);
                    k++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /***/

        /*String[] strings1 = new String[numberOfLines+1];
        SharedPreferences mBtnSharedPreferences = getSharedPreferences(sub_name, Activity.MODE_PRIVATE);

        TextView[]  ar_school_man = new TextView[numberOfLines];

        for(int i = 0; i < numberOfLines; i++)
        {
            String view_date = "school_man" + (i + 1);
            int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());

            ar_school_man[i] = ((TextView) findViewById(resIDdate));

            strings1[i] = mBtnSharedPreferences.getString("Class"+ i, null);
            ar_school_man[i].setText(strings1[i]);
        }*/

        long date = System.currentTimeMillis();
        SimpleDateFormat month = new SimpleDateFormat("MM");
        String str_month = month.format(date);
        TextView[]  ar_date = new TextView[31];

        for (int i = 0; i < 31; i++) {
            String view_date = "date" + (i + 1);
            int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());

            ar_date[i] = ((TextView) findViewById(resIDdate));
            ar_date[i].setText((i + 1)+ "/" + str_month);
        }

    }
}