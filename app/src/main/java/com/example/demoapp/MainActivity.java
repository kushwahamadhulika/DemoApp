package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText NameEditText, AggEditText;
    Button btn_insert,show_data,second_task;
    public static final String Firebase_Server_URL = "https://demoapp-fb8fa.firebaseio.com/";
    String NameHolder, NumberHolder;
   // Firebase firebase;


    DatabaseReference databaseReference,databaseReference1;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "Student_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NameEditText=findViewById(R.id.name);
        AggEditText=findViewById(R.id.et_age);
        show_data=findViewById(R.id.show_data);
        second_task=findViewById(R.id.show_secondTask);
        btn_insert=findViewById(R.id.insert_data);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference1 =databaseReference.child("Demo");


        second_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I=new Intent(MainActivity.this,SecondTaskActivity.class);
                startActivity(I);
            }
        });
        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I=new Intent(MainActivity.this,ViewDetailsActivity.class);
                startActivity(I);

            }
        });

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String name = NameEditText.getText().toString();
               // String age = AggEditText.getText().toString();

                databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);


               // databaseReference.setValue(name).;
               // Toast.makeText(MainActivity.this, "Insert Data", Toast.LENGTH_SHORT).show();

                StudentDetails studentDetails = new StudentDetails();

                GetDataFromEditText();

                // Adding name into class function object.
                studentDetails.setName(NameHolder);

                // Adding phone number into class function object.
                studentDetails.setAge(NumberHolder);

                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(StudentRecordIDFromServer).setValue(studentDetails);

                // Showing Toast message after successfully data submit.
                Toast.makeText(MainActivity.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();


            }
        });




    }
    public void GetDataFromEditText(){

        NameHolder = NameEditText.getText().toString().trim();

        NumberHolder =AggEditText.getText().toString().trim();

    }
}