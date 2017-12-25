package demo.com.serviceexam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MyService.class);
    }

    public void onStart(View v) {
        MyService.isStop = false;
        startService(intent);
    }
    public void onPause(View v) {
        MyService.isStop = true;
        startService(intent);
    }
    public void onStop(View v) {
        stopService(intent);
    }

}
