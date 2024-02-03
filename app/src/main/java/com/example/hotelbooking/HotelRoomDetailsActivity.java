package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelRoomDetailsActivity extends AppCompatActivity {
    private  String[][] doctor_details1={
            {"Room No: 2001", "Address: UK", "Room Type:Double Bed", "Room Condition:AC", "600"},
            {"Room No: 2002", "Address: UK", "Room Type:Single Bed", "Room Condition:AC", "600"},
            {"Room No: 2007", "Address: UK", "Room Type:Double Bed", "Room Condition:Non AC", "600"},
            {"Room No: 2003", "Address: UK", "Room Type:Single Bed", "Room Condition:AC", "600"},
            {"Room No: 2004", "Address: UK", "Room Type:Double Bed", "Room Condition:AC", "600"},
    };
    private  String[][] doctor_details2={
            {"Room No: 2001", "Address: USA", "Room Type:Single Bed", "Room Condition:Non AC", "600"},
            {"Room No: 2003", "Address: USA", "Room Type:Single Bed", "Room Condition:Non AC", "600"},
            {"Room No: 2004", "Address: USA", "Room Type:Single Bed", "Room Condition:AC", "600"},
            {"Room No: 2005", "Address: USA", "Room Type:Single Bed", "Room Condition:AC", "600"},
            {"Room No: 2006", "Address: USA", "Room Type:Single Bed", "Room Condition:AC", "600"},
    };
    private  String[][] doctor_details3={
            {"Room No: 2007", "Address: Bangladesh", "Room Type:Single Bed", "Room Condition:Non AC", "600"},
            {"Room No: 2008", "Address: Bangladesh", "Room Type:Double Bed", "Room Condition:AC", "600"},
            {"Room No: 2009", "Address: Bangladesh", "Room Type:Single Bed", "Room Condition:AC", "600"},
            {"Room No: 2000", "Address: Bangladesh", "Room Type:Double Bed", "Room Condition:Non AC", "600"},
            {"Room No: 2007", "Address: Bangladesh", "Room Type:Single Bed", "Room Condition:AC", "600"},
    };
    private  String[][] doctor_details4={
            {"Hotel Name: 20013", "Address: India", "Room Type:Single Bed", "Room Condition:Non AC", "600"},
            {"Hotel Name: 20016", "Address: India", "Room Type:Single Bed", "Room Condition:AC", "600"},
            {"Hotel Name: 2001", "Address: India", "Room Type:Double Bed", "Room Condition:AC", "600"},
            {"Hotel Name: 2001", "Address: India", "Room Type:Double Bed", "Room Condition:Non AC", "600"},
            {"Hotel Name: 20012", "Address: India", "Room Type:Single Bed", "Room Condition:AC", "600"},
    };
    String[][] doctor_details={};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_room_details);
        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        findViewById(R.id.textViewDDTitle);
        Intent it =getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Four Seasons")==0)
            doctor_details=doctor_details1;
        else
        if (title.compareTo("The Ritz-Carlton")==0)
            doctor_details=doctor_details2;
        else
        if (title.compareTo("Mandarin Oriental")==0)
            doctor_details=doctor_details3;
        else
            doctor_details=doctor_details3;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotelRoomDetailsActivity.this,HotelBookActivity.class));
            }
        });
        list=new ArrayList();
        for(int i=0; i<doctor_details.length;i++){
            item=new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Price:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list, R.layout.list, new String[]{"line1", "line2", "line3", "line4", "line5"}, new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent it=new Intent(HotelRoomDetailsActivity.this,HotelBookActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);


            }
        });
    }
}