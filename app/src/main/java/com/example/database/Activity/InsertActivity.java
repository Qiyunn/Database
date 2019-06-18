package com.example.database.Activity;

import android.app.IntentService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.DataBase.DBHelper;
import com.example.database.R;
import com.example.database.model.Employees;

public class InsertActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText editId,editName,editDepartment,editSalary;
    Button buttonInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        editName=findViewById(R.id.edit_text_name);
        editSalary=findViewById(R.id.edit_text_depart);
        editDepartment=findViewById(R.id.edit_text_depart);
        buttonInsert=findViewById(R.id.button_insert);
        dbHelper=new DBHelper(this);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=editName.getText().toString();
                String department=editDepartment.getText().toString();
                String salary=editSalary.getText().toString();
                Employees em=new Employees();
                em.setName(name);
                em.setDepartment(department);
                em.setSalary(salary);

                dbHelper.insertEmployee(em);
                Toast.makeText(InsertActivity.this, "inserted successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
