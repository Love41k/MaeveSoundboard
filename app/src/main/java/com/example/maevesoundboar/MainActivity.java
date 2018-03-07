package com.example.maevesoundboar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
public class Main extends ListActivity {
    private ArrayList<Sound> mSounds = null;
    private SoundAdapter mAdapter = null;
    static MediaPlayer mMediaPlayer = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//create a simple list
        mSounds = new ArrayList<Sound>();
        Sound s = new Sound();
        s.setDescription("Elephant");
        s.setIconResourceId(R.drawable.elephant);
        s.setSoundResourceId(R.raw.elephant);
        mSounds.add(s);
        s = new Sound();
        s.setDescription("Rooster");
        s.setIconResourceId(R.drawable.rooster);
        s.setSoundResourceId(R.raw.rooster);
        mSounds.add(s);
        s = new Sound();
        s.setDescription("Kitten");
        s.setIconResourceId(R.drawable.kitten);
        s.setSoundResourceId(R.raw.kitten);
        mSounds.add(s);
        mAdapter = new SoundAdapter(this, R.layout.list_row, mSounds);
        setListAdapter(mAdapter);
    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
        Sound s = (Sound) mSounds.get(position);
        MediaPlayer mp = MediaPlayer.create(this, s.getSoundResourceId());
        mp.start();
    }
}
