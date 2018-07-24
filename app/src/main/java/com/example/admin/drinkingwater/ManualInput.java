package com.example.admin.drinkingwater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ManualInput extends AppCompatActivity {

    private String ph = "1";
    private String hardness="10";
    private String chlorine="0";
    private String iron="0";
    private String alkaline="0";
    private String lead= "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_input);

        SeekBar seekPh = findViewById(R.id.seekPh);
        SeekBar seekHardness = findViewById(R.id.seekHardness);
        SeekBar seekChlorine = findViewById(R.id.seekTotalChlorine);
        SeekBar seekIron = findViewById(R.id.seekIron);
        SeekBar seekAlkalinity = findViewById(R.id.seekAlkalinity);
        SeekBar seekLead = findViewById(R.id.seekLead);


        //For PH value
        final TextView vPh = findViewById(R.id.valuePh);
        seekPh.setMax(12);
        seekPh.setProgress(0);

        seekPh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                ph = String.valueOf(progress + 1 );
                vPh.setText(ph);



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For hardness value
        final TextView vHardness = findViewById(R.id.valueHardness);
        seekHardness.setMax(200);
        seekHardness.setProgress(0);

        seekHardness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                hardness = String.valueOf(progress + 10 );
                vHardness.setText(hardness);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For chlorine value
        final TextView vChlorine = findViewById(R.id.valueChlorine);
        seekChlorine.setMax(5);
        seekChlorine.setProgress(0);

        seekChlorine.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                chlorine = String.valueOf((progress + 1));
                vChlorine.setText(chlorine);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For iron value
        final TextView vIron = findViewById(R.id.valueIron);
        seekIron.setMax(3);
        seekIron.setProgress(0);

        seekIron.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                iron = String.valueOf(progress + 1) ;
                vIron.setText(iron);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For  value
        final TextView vAlkaline = findViewById(R.id.valueAlkaline);
        seekAlkalinity.setMax(9);
        seekAlkalinity.setProgress(0);

        seekAlkalinity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                alkaline = String.valueOf(progress + 1 );
                vAlkaline.setText(alkaline);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For lead value
        final TextView vLead = findViewById(R.id.valueLead);
        seekLead.setMax(9);
        seekLead.setProgress(0);

        seekLead.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                lead = String.valueOf(progress + 1 );
                vLead.setText(lead);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For button value
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(ph)>=7 && Integer.parseInt(ph)<=9 &&
                        Integer.parseInt(chlorine) >=1 && Integer.parseInt(chlorine) <=2 &&
                        Integer.parseInt(iron) <= 1 &&
                        Integer.parseInt(alkaline)>=6 && Integer.parseInt(alkaline)<=7 &&
                        Integer.parseInt(lead)>=1 && Integer.parseInt(lead)<=3)
                {
                    startActivity(new Intent(ManualInput.this, Drinkable.class));
                    finish();
                }
                else if (Integer.parseInt(ph)<=6) {
                    String message = "Its a strong Acidic Water.";
                    String messageUse = "It can be used for following things:\n\ni. Sanitary purposes.\nii. Cleaning cuts and scrapes.\niii. Dabbing on clod sores, pimples/skin.";

                    Intent intNotDrinkable = new Intent(getApplicationContext(), notDrinkable.class);
                    intNotDrinkable.putExtra("m1", message.toString());
                    intNotDrinkable.putExtra("m2", messageUse.toString());

                    startActivity(intNotDrinkable);
                    finish();
                }else if (Integer.parseInt(ph)>=10) {
                    String message = "It is a strong Alkaline Water.";
                    String messageUse = "It can be used to do the following things:\n\ni. Watering plants.\nii. Dish and clothes washing.\niii. Soaking fruits and vegetables in clean deeper and revitalize ";
                    Intent intNotDrinkable = new Intent(getApplicationContext(), notDrinkable.class);
                    intNotDrinkable.putExtra("m1", message.toString());
                    intNotDrinkable.putExtra("m2", messageUse.toString());
                    startActivity(intNotDrinkable);
                    finish();
                }else {
                    String message = "It is impure water.";
                    String messageUse = "It can be purified for the following methods.\n\ni. Boiling.\nii. Sedemantation and Decantation.\niii. Chlorination.\niv. Filtaration";
                    Intent intNotDrinkable = new Intent(getApplicationContext(), notDrinkable.class);
                    intNotDrinkable.putExtra("m1", message.toString());
                    intNotDrinkable.putExtra("m2", messageUse.toString());
                    startActivity(intNotDrinkable);
                    finish();
                }
            }
        });
    }
}
