package com.mutito.victor.changingcolors;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    boolean bGIsRed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button but = (Button) findViewById(R.id.butt);

        final TabLayout bG = (TabLayout) findViewById(R.id.fisk);

        final SeekBar minBar = (SeekBar) findViewById(R.id.minSeekBar);
        final SeekBar maxBar = (SeekBar) findViewById(R.id.maxSeekBar);

        final TextView minTxt = (TextView) findViewById(R.id.textView2);
        final TextView maxTxt = (TextView) findViewById(R.id.textView3);

        int minV = minBar.getProgress()*20/100;
        int maxV = maxBar.getProgress()*20/100;
        String minVS = Integer.toString(minV);
        String maxVS = Integer.toString(maxV);


        minTxt.setText("Min time: " + minVS);
        maxTxt.setText("Max. time: " + maxVS);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double maxVal = maxBar.getProgress() /100.0 *20000;
                double minVal = minBar.getProgress() /100.0 *20000;

                if(minVal < 3000)
                    minVal = 3000;

                if(maxVal < minVal) {
                    maxVal = minVal;

                }

               long oldTime = Calendar.getInstance().getTimeInMillis();
                int delay =(int) (minVal + (Math.random()*(maxVal- minVal)));
                long nowTime = Calendar.getInstance().getTimeInMillis();
                System.out.println(delay/1000);
                while (nowTime < oldTime + delay){
                   nowTime = Calendar.getInstance().getTimeInMillis();

                }
                if(!bGIsRed) {
                    bG.setBackgroundColor(Color.RED);
                    bGIsRed = true;
                }else {
                    bG.setBackgroundColor(Color.MAGENTA);
                    bGIsRed = false;
                }
            }
        });

        minBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                int minV2 = (int) (3 + (minBar.getProgress()/100.0)*(20-3)) ;
                String minVS2 = Integer.toString(minV2);

                minTxt.setText("Min. time: " + minVS2);

                if(minBar.getProgress() > maxBar.getProgress()){
                    maxBar.setProgress(minBar.getProgress());
                }

            }
        });

        maxBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                int minV2 = (int) (3 + (maxBar.getProgress()/100.0)*(20-3)) ;
                String minVS2 = Integer.toString(minV2);

                maxTxt.setText("Max. time: " + minVS2);
                if(minBar.getProgress() > maxBar.getProgress()){
                    minBar.setProgress(maxBar.getProgress());
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
