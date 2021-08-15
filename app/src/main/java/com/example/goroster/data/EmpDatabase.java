package com.example.goroster.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.goroster.emp.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmpDatabase extends SQLiteOpenHelper {

    private Context context;

    private final String TAG ="empDatabase";
    //create database constants
    private static final String DATABASE_NAME ="empDB";
    private static final String TABLE_NAME ="empTB";
    private static final Integer VERSION = 1;

    private static final String COL_EMPNAME ="empName";
    private static final String COL_EMAIL ="email";
    private static final String COL_PASSWORD ="password";
    private static final String COL_PHONE ="phone";
    private static final String COL_ID ="id";
    private static final String COL_MON ="mon";
    private static final String COL_TUE="tue";
    private static final String COL_WED ="wed";
    private static final String COL_THU ="thu";
    private static final String COL_FRI ="fri";
    private static final String COL_SAT ="sat";
    private static final String COL_SUN ="sun";

    // sqlQuery create table
    private String CREATE_TABLE ="CREATE TABLE "+TABLE_NAME+" ("+
            COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_EMPNAME+" TEXT, "+
            COL_EMAIL+" TEXT, "+
            COL_PASSWORD+" TEXT, "+
            COL_PHONE+" TEXT, "+
            COL_MON+ " TEXT, "+
            COL_TUE+ " TEXT, "+
            COL_WED+ " TEXT, "+
            COL_THU+ " TEXT, "+
            COL_FRI+ " TEXT, "+
            COL_SAT+ " TEXT, "+
            COL_SUN+ " TEXT) ";




    public EmpDatabase(@Nullable Context context) {
        super(context, TABLE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG,"Employee Database: ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d(TAG,"OnCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//     Testing database with Toast to see if the database is working
//    public void testData(){
//        Toast.makeText(context,"Data in",Toast.LENGTH_SHORT).show();
//    }


// add new employee when signUp new account
    public void addEmp(Employee employee){
        // call the db out with writable
        SQLiteDatabase db = this.getWritableDatabase();
        // using values as a bridge to insert value to the table.
        ContentValues values = new ContentValues();
        values.put(COL_EMPNAME,employee.getName());
        values.put(COL_EMAIL,employee.getEmail());
        values.put(COL_PASSWORD,employee.getPassword());
        values.put(COL_PHONE,employee.getPhone());
        values.put(COL_MON,employee.getMonAvailable());
        values.put(COL_TUE,employee.getTueAvailable());
        values.put(COL_WED,employee.getWebAvailable());
        values.put(COL_THU,employee.getThuAvailable());
        values.put(COL_FRI,employee.getFriAvailable());
        values.put(COL_SAT,employee.getSatAvailable());
        values.put(COL_SUN,employee.getSunAvailable());


       long user = db.insert(TABLE_NAME,null,values);
       if(user != -1){
           Log.d(TAG,"Add employee Successful ! ");
       } else {
           Toast.makeText(context,"Error in Add Employee",Toast.LENGTH_SHORT).show();
       }
        db.close();

    }

    public boolean verifyUser(String email){
        //create an instance of SQLITE database
        SQLiteDatabase db = this.getWritableDatabase();
        // find email and return value to boolean
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE "+COL_EMAIL+ "=?",new String[] {email});
        if(cursor.getCount() > 0){
            return true;
        }else
            return false;
    }

    public boolean verifyLogin(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE "+COL_EMAIL+ "=?" + " AND "+COL_PASSWORD+ "=?",new String[] {email,password});
        if(cursor.getCount() > 0){
            return true;
        }else
            return false;
    }
    public boolean updateTimetable(String email,String mon, String tue, String wed, String thu, String fri, String sat, String sun){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE "+COL_EMAIL+ "=?",new String[] {email});
        if(cursor.getCount() > 0){
            ContentValues values = new ContentValues();
            values.put(COL_EMAIL,email);
            values.put(COL_MON,mon);
            values.put(COL_TUE,tue);
            values.put(COL_WED,wed);
            values.put(COL_THU,thu);
            values.put(COL_FRI,fri);
            values.put(COL_SAT,sat);
            values.put(COL_SUN,sun);
            // using email instead of id
            db.update(TABLE_NAME,values,COL_EMAIL+" = ?", new String[]{email});
            return true;
        }else
            return false;



    }

    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null); // Null - No condition request, get all.
        if(cursor.moveToFirst()){
            do{
                //Initialization an employee to get the data
                Employee emp = new Employee();

                emp.setId(cursor.getString(0));
                emp.setName(cursor.getString(1));
                emp.setMonAvailable(cursor.getString(5));
                emp.setTueAvailable(cursor.getString(6));
                emp.setWebAvailable(cursor.getString(7));
                emp.setThuAvailable(cursor.getString(8));
                emp.setFriAvailable(cursor.getString(9));
                emp.setSatAvailable(cursor.getString(10));
                emp.setSunAvailable(cursor.getString(11));

                employeeList.add(emp);

            }while(cursor.moveToNext());

        }
        db.close();
        return employeeList;
    }

    public String getDbEmpName(String email){
        Employee emp = new Employee();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE "+COL_EMAIL+ "=?",new String[] {email});

        if(cursor.moveToFirst()) {
            do {
                //Initialization an employee to get the data

                emp.setName(cursor.getString(1));


            }while(cursor.moveToNext());
        }
        db.close();
        return emp.getName();
    }

}
