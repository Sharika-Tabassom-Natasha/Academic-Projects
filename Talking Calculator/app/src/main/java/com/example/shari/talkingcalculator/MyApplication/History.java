package com.example.shari.talkingcalculator.MyApplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import com.example.shari.talkingcalculator.MyApplication.Database.DatabaseHandler;
import com.example.shari.talkingcalculator.MyApplication.Model.DatabaseHistory;
import com.example.shari.talkingcalculator.R;

public class History extends AppCompatActivity {

    Button delete;
    TextView show;
    private TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        final DatabaseHandler db=new DatabaseHandler(this);


        delete = (Button)findViewById(R.id.delete);
        show = (TextView)findViewById(R.id.historyTable);
        show.setMovementMethod(new ScrollingMovementMethod());
        showTable(db);

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

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("delete all");
                db.deleteHistory();
                showTable(db);

            }
        });

    }


    void showTable(DatabaseHandler db){
        List<DatabaseHistory> myHistoryList=db.getAllHistory();
        String result = "";
        for(DatabaseHistory myHistory : myHistoryList)
        {
            result +=myHistory.getId()+".\nEquation: "+myHistory.getEquation()+" \nResult: "+ myHistory.getResult();
            result +="\n";
            Log.d("Result",result);
        }
        if(myHistoryList.size()  == 0)
        {
            result = "No content to display.";
        }
        show.setText(result);
    }


    private  void speak(String t){
        mTTS.speak(t,TextToSpeech.QUEUE_FLUSH,null);
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
        speak("Back");
        finish();
    }
}
