package com.example.database.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.database.DataBase.DBHelper;
import com.example.database.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   Button buttonRead,buttonAdd,buttonUpdate,buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();
    }

    private void init(){
        buttonAdd=findViewById(R.id.button_add);
        buttonUpdate=findViewById(R.id.button_update);
        buttonDelete=findViewById(R.id.button_delete);
        buttonRead=findViewById(R.id.button_read);

        buttonRead.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_add:
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
                break;
            case R.id.button_update:
                startActivity(new Intent(MainActivity.this,UpdateActivity.class));
                break;
            case R.id.button_delete:
                startActivity(new Intent(MainActivity.this,DeleteActivity.class));
                break;
            case R.id.button_read:
                startActivity(new Intent(MainActivity.this,ReadActivity.class));
                break;

        }

    }
}
