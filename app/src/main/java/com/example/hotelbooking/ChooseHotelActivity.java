package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseHotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);
        CardView familyphysician=findViewById(R.id.cardFDFamilyPhysicians);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(ChooseHotelActivity.this,HotelRoomDetailsActivity.class);
                it.putExtra("title", "Four Seasons");
                startActivity(it);
            }
        });
        CardView dietician=findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(ChooseHotelActivity.this,HotelRoomDetailsActivity.class);
                it.putExtra("title", "The Ritz-Carlton");
                startActivity(it);
            }
        });
        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(ChooseHotelActivity.this,HotelRoomDetailsActivity.class);
                it.putExtra("title", "Mandarin Oriental");
                startActivity(it);
            }
        });
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(ChooseHotelActivity.this,HotelRoomDetailsActivity.class);
                it.putExtra("title", "St. Regis");
                startActivity(it);
            }
        });
    }
}