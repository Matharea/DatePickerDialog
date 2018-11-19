package fr.wildcodeschool.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list_activiy);
        Bundle extras = getIntent().getExtras();
        String title = extras.getString(getString(R.string.departure)) + " -> " + extras.getString(getString(R.string.destination));
        setTitle(title);
    }
}
