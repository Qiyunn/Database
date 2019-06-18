package com.example.database.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.database.model.Employees;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="employeedb";
    private static final int DATABASE_VERSION=2;
    Context mContext;
    SQLiteDatabase database;

    private static final String TABLE_NAME="employee";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_DRPARTMENT="department";;
    private static final String COLUMN_SALARY="salary";


    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
        Log.i("hi","database created");
        this.mContext=context;
        database=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         try {
             String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                     COLUMN_ID + " INTEGER Primary key Autoincrement," +
                     COLUMN_NAME + " TEXT," +
                     COLUMN_DRPARTMENT + " TEXT," +
                     COLUMN_SALARY + " TEXT )";
                    db.execSQL(CREATE_TABLE);
                    Log.i("hi","table created");
         }catch(SQLException e){
             Log.i("hi",e.getMessage());
         }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE="DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void insertEmployee(Employees employee){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,employee.getName());
        values.put(COLUMN_DRPARTMENT,employee.getDepartment());
        values.put(COLUMN_SALARY,employee.getSalary());
        long id=database.insert(TABLE_NAME,null,values);
//        database.insert(TABLE_NAME, null, values);
        Log.i("hi","inserted "+id);
    }

    public void updateEmployee(Employees employees){
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,employees.getName());
        values.put(COLUMN_DRPARTMENT,employees.getDepartment());
        values.put(COLUMN_SALARY,employees.getSalary());
        database.update(TABLE_NAME,values,COLUMN_ID+"=?",new String[]{String.valueOf(employees.getId())});
        Toast.makeText(mContext, "updated successfully", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<Employees> readEmployee(){
        Log.i("hi","read");
        ArrayList<Employees> employeesList=new ArrayList<>();
        String[] colums={COLUMN_ID,COLUMN_NAME,COLUMN_DRPARTMENT,COLUMN_SALARY};
        Cursor cursor=database.query(TABLE_NAME,colums,null,null,null,null,null,null);
        Log.i("hi","cursor"+cursor);
        if(cursor!=null && cursor.moveToFirst()) {
            do {
                Employees employees=new Employees();
                employees.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
                employees.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                employees.setDepartment(cursor.getString(cursor.getColumnIndex(COLUMN_DRPARTMENT)));
                employees.setSalary(cursor.getString(cursor.getColumnIndex(COLUMN_SALARY)));
                employeesList.add(employees);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return employeesList;
    }

}
