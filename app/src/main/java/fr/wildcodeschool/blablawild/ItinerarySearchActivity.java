package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        final Button validate = findViewById(R.id.button);
        final EditText departure = findViewById(R.id.depInput);
        final EditText destination = findViewById(R.id.destInput);
        final Calendar myCalendar = Calendar.getInstance();
        final EditText edittext= (EditText) findViewById(R.id.dateInput);



        validate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                if(TextUtils.isEmpty(departure.getText().toString()) || TextUtils.isEmpty(destination.getText().toString())){
                    Toast.makeText(context, R.string.toast, duration).show();
                }else{
                    Intent i = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    i.putExtra(getString(R.string.departure),departure.getText().toString());
                    i.putExtra(getString(R.string.destination), destination.getText().toString());
                    startActivity(i);
                }
        };
    });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {


            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                edittext.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

}