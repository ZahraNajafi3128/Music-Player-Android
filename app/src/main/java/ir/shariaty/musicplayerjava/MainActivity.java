package ir.shariaty.musicplayerjava;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import ir.shariaty.musicplayer.R;

public class MainActivity extends AppCompatActivity {
  ImageView play,prev,next;
  TextView songTitle;
  SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        mSeekBarTime = findViewById(R.id.seekbarTime);
        mSeekBarVol = findViewById(R.id.seekbarVolume);
        songTitle = findViewById(R.id.songTitle);


        ArrayList<Integer> songs = new ArrayList<>();
        songs.add(0 , R.raw.indafe);
        songs.add(1 , R.raw.son);


        mMediaPlayer = android.media.MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play_arrow_24);
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}