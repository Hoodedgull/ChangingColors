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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    boolean bGIsRed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final Button but = (Button) findViewById(R.id.butt);

        final TabLayout bG = (TabLayout) findViewById(R.id.fisk);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               long oldTime = Calendar.getInstance().getTimeInMillis();
                int delay = (int)(Math.random()*2000+1000);
                long nowTime = Calendar.getInstance().getTimeInMillis();
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
