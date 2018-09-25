package shadattonmoy.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.test);
    }
    public void play(View view)
    {

        mediaPlayer.start();
    }
    public void pause(View view)
    {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else Toast.makeText(this,"No song is playing",Toast.LENGTH_SHORT).show();
    }

}
