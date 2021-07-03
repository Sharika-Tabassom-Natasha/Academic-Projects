package com.example.shari.talkingcalculator.MyApplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shari.talkingcalculator.R;

import java.util.Locale;

public class Menu extends AppCompatActivity {

    private TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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

    public void gotoGeneral(View view) {
        speak("general calculator");
        Intent i = new Intent(Menu.this,General.class);
        startActivity(i);
    }

    public void gotoScientific(View view) {
        speak("scientific calculator");
        Intent i = new Intent(Menu.this,Scientific.class);
        startActivity(i);
    }

    public void gotoHistory(View view) {
        speak("history");
        Intent i = new Intent(Menu.this,History.class);
        startActivity(i);
    }


}
