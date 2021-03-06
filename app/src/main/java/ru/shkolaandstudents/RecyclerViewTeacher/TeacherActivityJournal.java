package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import ru.shkolaandstudents.R;

public class TeacherActivityJournal extends AppCompatActivity {
    public int numberOfLines = 1;
    String class_name;
    String sub_name;
    String school;
    String[] stringsUid ;
    String current_m;
    DatabaseReference ref;
    int count_students;
    String[] arr_users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_journal);

        Bundle arguments = getIntent().getExtras();
        class_name = arguments.get("Class").toString();
        sub_name = arguments.get("Subject").toString();
        school = arguments.get("School").toString();
        TextView txt_class = findViewById(R.id.txt_class);
        TextView txt_sub = findViewById(R.id.txt_sub);

        txt_class.setText(class_name);
        txt_sub.setText(sub_name);


        /*
         * Получение данных школьников и их UI
         */
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference(school).child(class_name);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                int k=0;
                int l=0;
                for (DataSnapshot ds1 : snapshot.getChildren()){
                    String line1 = ds1.getKey();
                    i++;
                }
                numberOfLines = i;
                String[] strings1 = new String[i];
                String[] stringsFUid = new String[i];
                TextView[]  ar_school_man = new TextView[31];
                arr_users = new String[i];
                for (DataSnapshot ds : snapshot.getChildren()){
                    String LastName = ds.child("LastName").getValue(String.class);
                    String FirstName = ds.child("FirstName").getValue(String.class);
                    String firstFirstName = FirstName.substring(0, 1);
                    String Otchestvo = ds.child("Otchestvo").getValue(String.class);
                    String firstOtchestvo = Otchestvo.substring(0, 1);
                    String Uid = ds.child("Uid").getValue(String.class);

                    String full = LastName + firstFirstName+ "." + firstOtchestvo+ ".";
                    String FUid = LastName + Uid;
                    strings1[k] = full;
                    stringsFUid[k] = FUid;
                    k++;
                    l=k;
                }

                Arrays.sort(strings1);
                Arrays.sort(stringsFUid);

                stringsUid = new String[i];

                /*
                 * Сортировка uid по фамилиям
                 */
                for (int jjj = 0; jjj<stringsFUid.length; jjj++)
                {
                    String str = stringsFUid[jjj];
                    String[] strgs = str.split(" ");
                    stringsUid[jjj] = strgs[1];
                }

                /*
                 * get UID всех пользователей
                 */
                arr_users = stringsUid;

                /*
                 * Установка значений в ячейки
                 */
                for (int jj = 0; jj<strings1.length; jj++)
                {
                    String view_date = "school_man" + (jj + 1);
                    int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                    ar_school_man[jj] = ((TextView) findViewById(resIDdate));
                    ar_school_man[jj].setText(strings1[jj]);
                    ar_school_man[jj].setBackgroundResource(R.drawable.back);
                }

                count_students = strings1.length;

                /*
                 * Удаление рядов оценок (они пустые)
                 * */
                LinearLayout[] row = new LinearLayout[30];
                for (int j = k; j<30; j++)
                {
                    String view_date = "row" + (j + 1);
                    int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                    row[j] = ((LinearLayout) findViewById(resIDdate));
                    row[j].setVisibility(View.GONE);
                }

                /*
                * Удаление пустых оставшихся ячеек
                 * */
                for (int ll = l; l<31; l++)
                {
                    String view_date1 = "school_man" + (ll + 1);
                    int resIDdate1 = getResources().getIdentifier(view_date1, "id", getPackageName());
                    ar_school_man[ll] = ((TextView) findViewById(resIDdate1));
                    ar_school_man[ll].setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*
         * Получение данных журнала
         */
        current_m = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
        final ArrayAdapter ar_adapt_m = new ArrayAdapter(TeacherActivityJournal.this
                ,android.R.layout.simple_spinner_item
                ,getResources().getStringArray(R.array.month_of_year));
        final Spinner spinner = findViewById(R.id.spinner_month);
        ar_adapt_m.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinner.setAdapter(ar_adapt_m);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                if(selectedItemPosition <10)
                {
                    current_m = "0"+String.valueOf(selectedItemPosition);
                }
                else
                {
                    current_m = String.valueOf(selectedItemPosition);
                }

                if(current_m.equals("00"))
                {
                    Toast.makeText(getApplicationContext(),"Выберите месяц",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(class_name + sub_name).child(current_m);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            final TextView[][] tv_value = new TextView[32][32];
                            for (int i = 0; i < 30; i++) {
                                for (int j = 0; j < 31; j++) {
                                    String view_date = "date" + (i + 1) + "00" + (j + 1);
                                    int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                                    tv_value[i][j] = ((TextView) findViewById(resIDdate));
                                    tv_value[i][j].setText("  ");
                                }
                            }

                            int i = 0;
                            for (DataSnapshot ds1 : snapshot.getChildren()) {
                                String name = ds1.getKey();
                                i++;
                            }

                            String[] arr_cur_uid = new String[i];
                            String[] arr_day = new String[i];
                            String[] arr_value = new String[i];

                            int cnt = 0;
                            for (DataSnapshot ds1 : snapshot.getChildren()) {
                                String name = ds1.getKey();
                                String delims = "[ ]+";
                                String[] tokens = name.split(delims);

                                arr_cur_uid[cnt] = tokens[0];
                                arr_day[cnt] = tokens[1];

                                arr_value[cnt] = ds1.getValue(String.class);
                                cnt++;
                            }

                            for (int jj = 0; jj < arr_cur_uid.length; jj++) {
                                String cur_uid = arr_cur_uid[jj];
                                String day = arr_day[jj];
                                int i_day = Integer.parseInt(day) - 1;
                                String value = arr_value[jj];
                                for (int kk = 0; kk < arr_users.length; kk++) {
                                    if (cur_uid.equals(arr_users[kk])) {
                                        tv_value[kk][i_day].setText(value);
                                    }
                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    final TextView[]  ar_date = new TextView[31];

                    int value =Integer.parseInt(current_m);
                    int counter =0;
                    if((value == 1) || (value == 3) || (value == 5) || (value == 7) || (value == 8) || (value == 10) || (value == 12))
                    {
                        counter = 31;
                    }
                    else if((value == 4) || (value == 6) || (value == 9) || (value == 11))
                    {
                        counter = 30;
                    }
                    else if((value == 2))
                    {
                        counter = 29;
                    }

                    final TextView[][] tv_value1 = new TextView[32][32];
                    for (int i=0; i<30; i++) {
                        for (int j = 0; j < 31; j++) {
                            String view_date = "date" + (i + 1) + "00" + (j + 1);
                            int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                            tv_value1[i][j] = ((TextView) findViewById(resIDdate));
                            tv_value1[i][j].setVisibility(View.GONE);
                        }
                    }

                    for (int i = 0; i < 31; i++) {
                        String view_date = "date" + (i + 1);
                        int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                        ar_date[i] = ((TextView) findViewById(resIDdate));
                        ar_date[i].setVisibility(View.GONE);
                    }

                    for (int i = 0; i < counter; i++) {
                        String view_date = "date" + (i + 1);
                        int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());

                        ar_date[i] = ((TextView) findViewById(resIDdate));
                        ar_date[i].setVisibility(View.VISIBLE);
                        ar_date[i].setText((i + 1)+ "/" + current_m);
                    }

                    final ArrayAdapter arrayAdapter = new ArrayAdapter(TeacherActivityJournal.this
                            ,android.R.layout.simple_spinner_item
                            ,getResources().getStringArray(R.array.schoolList));

                    final DatabaseReference ref_save = database.getReference("Users");

                    final TextView[] ar_school_man = new TextView[count_students];
                    final TextView[][] tv_value = new TextView[32][32];

                    for (int i=0; i<count_students; i++)
                    {
                        String view_date1 = "school_man" + (i + 1);
                        int resIDdate1 = getResources().getIdentifier(view_date1, "id", getPackageName());
                        ar_school_man[i] = ((TextView) findViewById(resIDdate1));

                        final int ii = i;
                        for(int j=0; j<counter; j++)
                        {
                            String view_date = "date"+(i+1)+"00"+ (j + 1);
                            int resIDdate = getResources().getIdentifier(view_date, "id", getPackageName());
                            tv_value[i][j] = ((TextView) findViewById(resIDdate));
                            tv_value1[i][j].setVisibility(View.VISIBLE);

                            final int jj=j;
                            tv_value[i][j].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View vw) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivityJournal.this,R.style.AlertDialogTheme);
                                    View view = getLayoutInflater().inflate(R.layout.teacher_dialog_choose_sub,null);
                                    builder.setTitle("Оценка для " + ar_school_man[ii].getText() + "\n" + "за " + (jj+1) + "/" + current_m);
                                    builder.setView(view);
                                    final Spinner spinner = view.findViewById(R.id.spinner1);

                                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                                    spinner.setAdapter(arrayAdapter);
                                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int l) {
                                            Toast.makeText(TeacherActivityJournal.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                            String currentDate;
                                            String currentDatebd;
                                            String currentDayOfWeek = null;
                                            if((jj+1)<10)
                                            {
                                                String day = "0"+(jj+1);
                                                currentDate = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());
                                                currentDatebd = day + " "+ current_m + " " + currentDate;
                                                currentDate = day + "/"+ current_m +  "/" + currentDate;


                                                SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
                                                Date dt1= null;
                                                try {
                                                    dt1 = format1.parse(currentDate);
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEE");
                                                currentDayOfWeek =format2.format(dt1);
                                            }
                                            else
                                            {
                                                currentDate = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());
                                                currentDatebd = (jj+1) + " "+ current_m + " " + currentDate;
                                                currentDate = (jj+1) + "/"+ current_m +  "/" + currentDate;

                                                SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
                                                Date dt1= null;
                                                try {
                                                    dt1 = format1.parse(currentDate);
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEE");
                                                currentDayOfWeek =format2.format(dt1);

                                            }
                                            tv_value[ii][jj].setText(spinner.getSelectedItem().toString());
                                            String str = spinner.getSelectedItem().toString();
                                            ref = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(class_name + sub_name).child(current_m);
                                            ref.child(arr_users[ii]+ " "+ currentDatebd).setValue(str);
                                            String key = ref.push().getKey();
                                            ref_save.child(stringsUid[ii]).child("Оценки").child(sub_name).child(key).child("Оценка").setValue(str);
                                            ref_save.child(stringsUid[ii]).child("Оценки").child(sub_name).child(key).child("Дата").setValue(currentDate);
                                            ref_save.child(stringsUid[ii]).child("Оценки").child(sub_name).child(key).child("День").setValue(currentDayOfWeek);
                                            dialogInterface.dismiss();
                                        }
                                    });
                                    builder.setView(view);
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            });

                        }
                    }
                }/**Конец условия**/
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final int value =Integer.parseInt(current_m);

        spinner.post(new Runnable() {
            @Override
            public void run() {
                spinner.setSelection(value);
            }
        });

    }
}