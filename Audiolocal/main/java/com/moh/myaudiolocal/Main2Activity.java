package com.moh.myaudiolocal;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<listItem> listItems = new ArrayList<>();
    int[] photos = {R.drawable.richar, R.drawable.rol, R.drawable.rol};
    String[] Titles = {"first", "second", "third"};
    int[] Sounds = {R.raw.trac, R.raw.track, R.raw.tra};

    ListView listView;
    MediaPlayer mediaPlayer = new MediaPlayer();
    SeekBar seekBar;
    Button btnPlay, btnPause, btnStop;
    TextView title, curTime, TotalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.list);
        seekBar = findViewById(R.id.seekBar);
        btnPlay = findViewById(R.id.play);
        btnPause = findViewById(R.id.pause);
        btnStop = findViewById(R.id.stop);
        title = findViewById(R.id.title);
        curTime = findViewById(R.id.curTime);
        TotalTime = findViewById(R.id.totalTime);

        //add to array list
        for (int i = 0; i < photos.length; i++) {
            listItems.add(new listItem(Titles[i], photos[i], Sounds[i]));
        }

        MyAdapter myAdapter = new MyAdapter(listItems);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(Main2Activity.this, listItems.get(position).sound);
                title.setText(listItems.get(position).getTitle());
                SoundTime();
            }
        });

        mediaPlayer = MediaPlayer.create(Main2Activity.this, Sounds[0]);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    Thread thread;
                    thread = new Thread() {
                        @Override
                        public void run() {
                            int duration = mediaPlayer.getDuration();
                            int curPosition = 0;
                            seekBar.setMax(duration);

                            while (curPosition < duration) {
                                try {
                                    sleep(200);
                                    curPosition = mediaPlayer.getCurrentPosition();
                                    seekBar.setProgress(curPosition);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    };
                    mediaPlayer.start();
                    thread.start();
                }

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
                SoundTime();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void SoundTime() {
        seekBar.setMax(mediaPlayer.getDuration());
        int timeinseconds = seekBar.getMax() / 1000;
        int minute = timeinseconds / 60;
        int second = timeinseconds % 60;

        int timeinseconds0 = seekBar.getProgress() / 1000;
        int minute0 = timeinseconds0 / 60;
        int second0 = timeinseconds0 % 60;

        TotalTime.setText(second + " : " + minute);
        curTime.setText(second0 + " : " + minute0);

    }

    class MyAdapter extends BaseAdapter {
        ArrayList<listItem> list = new ArrayList<>();

        //constructor
        public MyAdapter(ArrayList<listItem> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            final View view = layoutInflater.inflate(R.layout.rowitem, null);
            final ImageView imageView = view.findViewById(R.id.img);
            TextView textView = view.findViewById(R.id.item_title);

            textView.setText(list.get(position).getTitle());
            Picasso.get().load(list.get(position).getImg()).into(imageView);

            return view;
        }
    }
}
