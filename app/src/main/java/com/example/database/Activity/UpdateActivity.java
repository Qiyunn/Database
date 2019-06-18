package com.example.database.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.DataBase.DBHelper;
import com.example.database.R;
import com.example.database.model.Employees;

public class UpdateActivity extends AppCompatActivity {
    EditText editTextId,editTextName,editTextDepartment,editTextSalary;
    Button buttonUpdate;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();

    }
    private void init(){
        editTextId=findViewById(R.id.edit_text_id);
        editTextName=findViewById(R.id.edit_text_name);
        editTextDepartment=findViewById(R.id.edit_text_depart);
        editTextSalary=findViewById(R.id.edit_text_salary);
        buttonUpdate=findViewById(R.id.button_update);
        dbHelper=new DBHelper(this);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employees employees=new Employees();
                employees.setName(editTextName.getText().toString());
                employees.setDepartment(editTextDepartment.getText().toString());
                employees.setSalary(editTextSalary.getText().toString());
                employees.setId(Integer.parseInt(editTextId.getText().toString()));
                dbHelper.updateEmployee(employees);
            }
        });

    }
}
