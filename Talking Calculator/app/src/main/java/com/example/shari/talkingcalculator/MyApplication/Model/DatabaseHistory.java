package com.example.shari.talkingcalculator.MyApplication.Model;

public class DatabaseHistory {

    int _id;
    String _equation;
    String _result;

    public DatabaseHistory()
    {

    }
    public DatabaseHistory(int Id, String Equation , String Result)
    {

        this._id=Id;
        this._equation=Equation;
        this._result=Result;

    }

    public DatabaseHistory(String Equation , String Result)
    {
        this._equation=Equation;
        this._result=Result;

    }

    public int getId()
    {
        return this._id;
    }
    public void setId(int Id)
    {
        this._id=Id;
    }

    public String getEquation()
    {
        return this._equation;
    }
    public void setEquation(String Equation)
    {
        this._equation=Equation;
    }

    public String getResult()
    {
        return this._result;
    }
    public void setResult(String Result)
    {
        this._result=Result;
    }

}
