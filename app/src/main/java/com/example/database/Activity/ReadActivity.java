package com.example.database.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.DataBase.DBHelper;
import com.example.database.R;
import com.example.database.model.Employees;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    TextView textViewRead;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        init();
    }

    private void init() {
        dbHelper = new DBHelper(this);
        textViewRead = findViewById(R.id.text_view);
        ArrayList<Employees> list = dbHelper.readEmployee();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append("ID is :" + list.get(i).getId() + " ,Name is :" + list.get(i).getName() +
                    " ,department is :"+list.get(i).getDepartment()+" ,salary is :"+list.get(i).getSalary()+"\n");
            textViewRead.setText(builder.toString());

            Toast.makeText(this, "" + list.size(), Toast.LENGTH_SHORT).show();
        }
    }
}

