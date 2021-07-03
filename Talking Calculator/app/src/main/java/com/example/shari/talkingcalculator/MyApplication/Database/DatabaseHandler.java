package com.example.shari.talkingcalculator.MyApplication.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shari.talkingcalculator.MyApplication.Model.DatabaseHistory;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="historyManager";
    private static final String TABLE_NAME="history";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="equation";
    private static final String KEY_CONTACTNO="result";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE history (ID INTEGER PRIMARY KEY," +
                " equation TEXT" +
                ", result TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void addHistory(DatabaseHistory databaseHistory)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO history(equation,result)" +
                "VALUES('"+ databaseHistory.getEquation()+"','"+ databaseHistory.getResult()+"')";

        db.execSQL(query);
        db.close();

    }


    public List<DatabaseHistory> getAllHistory()
    {
        List<DatabaseHistory> myDatabaseHistoryList =new ArrayList<DatabaseHistory>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                DatabaseHistory databaseHistory = new DatabaseHistory(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                myDatabaseHistoryList.add(databaseHistory);
            }while(cursor.moveToNext());
        }

        return myDatabaseHistoryList;
    }


    public void deleteHistory()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "DELETE from history";
        db.execSQL(query);
        db.close();
    }

}
