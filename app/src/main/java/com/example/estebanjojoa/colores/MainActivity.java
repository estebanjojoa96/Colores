package com.example.estebanjojoa.colores;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    int seekR, seekB,seekG,seekA,NumberSeekR;
    SeekBar seekBarRed,seekBarGreen,seekBarBlue,seekBarAlpha;
    View viewColor;
    TextView NumberText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        seekBarRed=(SeekBar) findViewById(R.id.seek_red);
        seekBarBlue=(SeekBar) findViewById(R.id.seek_blue);
        seekBarGreen=(SeekBar) findViewById(R.id.seek_green);
        seekBarAlpha=(SeekBar) findViewById(R.id.seek_Alpha);
        viewColor = (View) findViewById(R.id.view);
        NumberText = (TextView) findViewById(R.id.seekNumber);

        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarAlpha.setOnSeekBarChangeListener(this);

       //registerForContextMenu(textViewName);

    }

    public void UpdateBackground(){

        seekR = seekBarRed.getProgress();
        seekB = seekBarBlue.getProgress();
        seekG = seekBarGreen.getProgress();
        seekA = seekBarAlpha.getProgress();

        int color = Color.argb(seekR,seekG,seekB,seekA);
        viewColor.setBackgroundColor(color);
    }





    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuone, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu:
                Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.item_menu2:
                Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuone, menu);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //Number();
        UpdateBackground();
        NumberSeekR=seekBarRed.getProgress();
        NumberText.setText(String.valueOf(NumberSeekR));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
