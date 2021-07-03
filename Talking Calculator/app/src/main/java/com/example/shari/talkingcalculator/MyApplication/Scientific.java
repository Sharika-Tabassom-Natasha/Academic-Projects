package com.example.shari.talkingcalculator.MyApplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shari.talkingcalculator.MyApplication.Database.DatabaseHandler;
import com.example.shari.talkingcalculator.MyApplication.Model.DatabaseHistory;
import com.example.shari.talkingcalculator.MyApplication.Model.ExtendedDoubleEvaluator;
import com.example.shari.talkingcalculator.R;
import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.util.Locale;

public class Scientific extends AppCompatActivity {

    private TextView e1,e2;
    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private Button btnMultiply, btnMinus, btnPlus, btnDivide,btnDecimal,btnopen,btnclose;
    private Button btnmod,btn_ln,btnE,btnroot,btnsqr,btnsin,btncos,btntan;
    private Button btnclear,btnallclear,btnEqual;

    private int count=0;
    private String expression="";
    private String text="";
    private Double result=0.0;
    private TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        setupUIViews();

        final DatabaseHandler db=new DatabaseHandler(this);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(Locale.getDefault());
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Language not suppoeted");
                    }

                }else {
                    Log.e("TTS","iNITIALIZATION FAILED");
                }

            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("0");
                e2.setText(e2.getText()+"0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("1");
                e2.setText(e2.getText()+"1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("2");
                e2.setText(e2.getText()+"2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("3");
                e2.setText(e2.getText()+"3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("4");
                e2.setText(e2.getText()+"4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("5");
                e2.setText(e2.getText()+"5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("6");
                e2.setText(e2.getText()+"6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("7");
                e2.setText(e2.getText()+"7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("8");
                e2.setText(e2.getText()+"8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("9");
                e2.setText(e2.getText()+"9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("plus");
                operationClicked("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("minus");
                operationClicked("-");

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("in to");
                operationClicked("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("divide");
                operationClicked("/");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("dot");
                if(count==0 && e2.length()!=0)
                {
                    e2.setText(e2.getText()+".");
                    count++;
                }
            }
        });

        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("open bracket");
                e1.setText(e1.getText()+"(");
            }
        });
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("close bracket");
                e1.setText(e1.getText()+")");

            }
        });

        btnsqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("square");
                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    e2.setText("("+text+")^2");
                }
            }
        });

        btnroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("root");
                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    e2.setText("sqrt(" + text + ")");
                }
            }
        });

        btn_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("log");
                if(e2.length()!=0) {
                    text = e2.getText().toString();
                    e2.setText("Ln(" + text + ")");
                }
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("exponential");
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("E(" + text + ")");
                }
            }
        });

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("module");
                operationClicked("%");
            }
        });

        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("sin");
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("Sin("+ text + ")");
                }
            }
        });

        btncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("cos");
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("Cos("+ text + ")");
                }
            }
        });

        btntan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("tan");
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("Tan("+ text + ")");
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    expression=e1.getText().toString()+text;
                }
                e1.setText("");
                if(expression.length()==0)
                    expression="0.0";

                DoubleEvaluator evaluator = new DoubleEvaluator();
                try
                {
                    result=new ExtendedDoubleEvaluator().evaluate(expression);
                    if(!expression.equals("0.0")) {
                        e2.setText(result + "");
                        addToHistoryTable(db);
                    }
                }
                catch (Exception e)
                {
                    e2.setText("Invalid Expression");
                    e1.setText("");
                    expression="";
                    e.printStackTrace();
                }

                speak("equal to "+e2.getText().toString());
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("clear");
                text=e2.getText().toString();
                if(text.length()>0)
                {
                    if(text.endsWith("."))
                    {
                        count=0;
                    }
                    String newText=text.substring(0,text.length()-1);

                    if(text.endsWith(")"))
                    {
                        char []a=text.toCharArray();
                        int pos=a.length-2;
                        int counter=1;

                        for(int i=a.length-2;i>=0;i--)
                        {
                            if(a[i]==')')
                            {
                                counter++;
                            }
                            else if(a[i]=='(')
                            {
                                counter--;
                            }

                            else if(a[i]=='.')
                            {
                                count=0;
                            }

                            if(counter==0)
                            {
                                pos=i;
                                break;
                            }
                        }
                        newText=text.substring(0,pos);
                    }

                    if(newText.equals("-")||newText.endsWith("sqrt"))
                    {
                        newText="";
                    }

                    else if(newText.endsWith("^"))
                        newText=newText.substring(0,newText.length()-1);

                    e2.setText(newText);
                }
            }

        });

        btnallclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("all clear");
                e1.setText("");
                e2.setText("");
                count=0;
                expression="";
            }
        });

    }


    private void setupUIViews() {

        e1=(TextView) findViewById(R.id.output);
        e2=(TextView) findViewById(R.id.input);
        btnOne =  (Button)findViewById(R.id.button_1);
        btnTwo =  (Button)findViewById(R.id.button_2);
        btnThree =(Button) findViewById(R.id.button_3);
        btnFour = (Button) findViewById(R.id.button_4);
        btnFive = (Button) findViewById(R.id.button_5);
        btnSix = (Button)findViewById(R.id.button_6);
        btnSeven = (Button) findViewById(R.id.button_7);
        btnEight = (Button) findViewById(R.id.button_8);
        btnNine = (Button) findViewById(R.id.button_9);
        btnZero =  (Button)findViewById(R.id.button_0);
        btnmod=(Button)findViewById(R.id.button_14);
        btn_ln=(Button)findViewById(R.id.button_15);
        btnE=(Button)findViewById(R.id.button_16);
        btnsqr=(Button)findViewById(R.id.button_17);
        btnroot=(Button)findViewById(R.id.button_18);
        btnsin=(Button)findViewById(R.id.button_19);
        btncos=(Button)findViewById(R.id.button_20);
        btntan=(Button)findViewById(R.id.button_21);
        btnMultiply =  (Button)findViewById(R.id.button_24);
        btnMinus =  (Button)findViewById(R.id.button_23);
        btnPlus = (Button) findViewById(R.id.button_22);
        btnDivide = (Button) findViewById(R.id.button_25);
        btnDecimal = (Button)findViewById(R.id.button_27);
        btnopen= (Button)findViewById(R.id.button_12);
        btnclose =(Button)findViewById(R.id.button_13);
        btnclear=(Button)findViewById(R.id.button_26);
        btnallclear=(Button)findViewById(R.id.button_11);
        btnEqual=(Button)findViewById(R.id.button_28);;
    }

    private void operationClicked(String op)
    {
        if(e2.length()!=0)
        {
            String text=e2.getText().toString();
            e1.setText(e1.getText() + text+op);
            e2.setText("");
            count=0;
        }
        else
        {
            String text=e1.getText().toString();
            if(text.length()>0)
            {
                String newText=text.substring(0,text.length()-1)+op;
                e1.setText(newText);
            }
        }
    }

    void addToHistoryTable(DatabaseHandler db){
        String result= e2.getText().toString();
        if(expression.equals("") || result.equals(""))
        {
            Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
        }
        else{
            db.addHistory(new DatabaseHistory(expression,result));
           // Toast.makeText (getApplicationContext(),"Added.",Toast.LENGTH_SHORT).show();
        }

    }

    private  void speak(String t){
        mTTS.speak(t, TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onDestroy() {

        if(mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    public void gotoMenu(View view) {
        speak("back");
        finish();
    }
}
