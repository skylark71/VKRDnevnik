package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ru.shkolaandstudents.R;

public class TeacherSetClassList extends AppCompatActivity {
    public int numberOfLines = 1;
    String class_name;
    String save_edit;
    List<EditText> allEds = new ArrayList<EditText>();
    Button btn_save_value;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_set_class_list);

        //EditText et;

        /** */
        Bundle arguments = getIntent().getExtras();
        class_name = arguments.get("finalIt").toString() + "-1";
        save_edit = arguments.get("finalIt").toString();
        TextView txt = findViewById(R.id.extras);
        txt.setText(class_name);
        /** */

        SharedPreferences mSharedPreferences = getSharedPreferences(class_name, Activity.MODE_PRIVATE);
        numberOfLines = mSharedPreferences.getInt(class_name, 1);

        /*final String[] strings1 = new String[numberOfLines+1];
        SharedPreferences mBtnSharedPreferences = getSharedPreferences(save_edit, Activity.MODE_PRIVATE);*/

        /****/
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(save_edit);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                int k=0;
                EditText et;
                allEds.clear();
                LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayoutDecisions);
                ll.removeAllViews();
                for (DataSnapshot ds1 : snapshot.getChildren()){
                    String line1 = ds1.getValue(String.class);
                    i++;
                }
                numberOfLines = i;
                String[] strings1 = new String[i];
                //ll.removeAllViews();
                for (DataSnapshot ds : snapshot.getChildren()){
                    et = new EditText(TeacherSetClassList.this);
                    allEds.add(et);
                    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    et.setLayoutParams(p);
                    et.setId(k);
                    et.setHint(k + " ФИ учащегося");
                    ll.addView(et);
                    //strings1[i] = mBtnSharedPreferences.getString("Class"+ i, null);
                    String line1 = ds.getValue(String.class);
                    strings1[k] = line1;
                    et.setText(strings1[k]);
                    k++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /****/

        /*for(int i = 0; i <= numberOfLines; i++)
        {
            LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayoutDecisions);
            et = new EditText(this);
            allEds.add(et);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            et.setLayoutParams(p);
            et.setId(i);
            et.setHint(i + " ФИ учащегося");
            ll.addView(et);
            //strings1[i] = mBtnSharedPreferences.getString("Class"+ i, null);
            et.setText(strings1[i]);
        }*/

        final Button Add_button = (Button) findViewById(R.id.add_button);
        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Line();
            }
        });

        final Button Remove_button = (Button) findViewById(R.id.remove_button);
        Remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Remove_Line();
            }
        });

        btn_save_value = findViewById(R.id.btn_save_value);
        btn_save_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences mBtnSharedPreferences = getSharedPreferences(save_edit, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mBtnSharedPreferences.edit();*/
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(save_edit);
                String[] strings = new String[allEds.size()];
                for(int i=0; i < allEds.size(); i++){
                    strings[i] = allEds.get(i).getText().toString();
                    ref.child(save_edit + i).setValue(strings[i]);
                    /*editor.putString("Class"+ i, strings[i]);
                    editor.apply();*/
                    System.out.println("Save " + strings[i] + " " + i);
                }

                /*String[] strings1 = new String[allEds.size()];
                for(int i=0; i < allEds.size(); i++){
                    strings1[i] = mBtnSharedPreferences.getString("Class"+ i, null);
                    System.out.println("Read "+ strings1[i] + " " + i);
                }*/
            }
        });
    }

    private void Remove_Line() {
        /** ТЕСТОВАЯ СТРОЧКА **/
        /*btn_save_value.performClick();

        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayoutDecisions);
        ll.removeAllViews();
        //allEds.clear();

        SharedPreferences mBtnSharedPreferences = getSharedPreferences(save_edit, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = mBtnSharedPreferences.edit();

        String[] strings1 = new String[allEds.size()];
        String[] strings2 = new String[allEds.size()];

        for(int i = 0; i <= numberOfLines; i++)
        {
            strings1[i] = mBtnSharedPreferences.getString("Class"+ i, null);
        }*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(save_edit).child(save_edit + (numberOfLines-1));
        ref.removeValue();

        numberOfLines--;
        allEds.remove(numberOfLines);

        /*mBtnSharedPreferences.edit().clear().apply();
        for(int i = 0; i <= numberOfLines; i++)
        {
            strings2[i] = strings1[i];
            editor1.putString("Class"+ i, strings2[i]);
            editor1.apply();
            //System.out.println(strings2[i] + " " + i);
        }

        for(int i = 0; i <= numberOfLines; i++)
        {
            EditText et = new EditText(this);
            //strings1[i] = mBtnSharedPreferences.getString("Class"+ i, null);
            //allEds.add(et);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            et.setLayoutParams(p);
            et.setId(i);
            ll.addView(et);
            strings2[i] = mBtnSharedPreferences.getString("Class"+ i, null);
            System.out.println(strings2[i] + " " + i);
            et.setText(strings2[i]);
        }




        SharedPreferences sp = getSharedPreferences(class_name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(class_name, numberOfLines);
        editor.apply();*/

        //КЛИК ПО КНОПКЕ +
        //btn_save_value.performClick();
    }



    public void Add_Line() {
        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayoutDecisions);
        EditText et = new EditText(this);
        allEds.add(et);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(p);
        et.setId(numberOfLines+1);
        int id = et.getId();
        et.setHint(id + " ФИ учащегося");
        ll.addView(et);
        numberOfLines++;

        SharedPreferences sp = getSharedPreferences(class_name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(class_name, numberOfLines);
        editor.apply();

        //КЛИК ПО КНОПКЕ +
        btn_save_value.performClick();

    }
}