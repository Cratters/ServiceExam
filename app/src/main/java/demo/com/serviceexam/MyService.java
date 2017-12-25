package demo.com.serviceexam;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public static boolean isStop = true;
    public static MediaPlayer mp;

    public MyService() {

        Log.d("LogTAG", "MyService");
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d("LogTAG", "onBind");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        isStop = false;
        Log.d("LogTAG", "onCreate");
        mp = MediaPlayer.create(this, R.raw.boss);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("LogTAG", "onStartCommand");
        if (!isStop && !mp.isPlaying()) {
            Log.d("LogTAG", "播放音樂");
            mp.start();
        }
        if (isStop) {
            Log.d("LogTAG", "音樂暫停");
            mp.pause();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("LogTAG", "onDestroy");
        mp.stop();
        mp.release();
        mp = null;
        Log.d("LogTAG", "結束音樂");
        super.onDestroy();
    }

}
