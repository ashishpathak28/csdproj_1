package com.example.csdproj_1;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<pic_data> data = new ArrayList<>();
    private RecyclerAdaptor adaptor;
    FloatingActionButton floatingActionAddButton;
    private RecyclerView.LayoutManager layoutManager;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionAddButton = findViewById(R.id.Floating_Button);
        floatingActionAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AddImageActivity.class);
                startActivity(intent);

            }
        });
        data.add(new pic_data(R.drawable.facebook,"First Title","This is sample description 1 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Second Title","This is sample description 2 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Third Title","This is sample description 3 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Fourth Title","This is sample description 4 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Fifth Title","This is sample description 5 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Sixth Title","This is sample description 6 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Seventh Title","This is sample description 7 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Eighth Title","This is sample description 8 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Nineth Title","This is sample description 9 that crosses over in two lines and goes on for a while"));
        data.add(new pic_data(R.drawable.facebook,"Tenth Title","This is sample description 10 that crosses over in two lines and goes on for a while"));
        //get value from sharedPreferences and add here
        //use loop to fetch all the values in that shareHolder again
        SharedPreferences sharedPreferences = getSharedPreferences("AlbumData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        int count = sharedPreferences.getInt("counter", 0);
        for (int i = 0; i <= count; i++ )
        {
            String title = sharedPreferences.getString("title" + Integer.toString(i), "NOT_APPLICABLE");
            String description = sharedPreferences.getString("description" + Integer.toString(i) ,"NOT_APPLICABLE");

            if(description == "NOT_APPLICABLE"  || title == "NOT_APPLICABLE" )
                ;
            else
                data.add(new pic_data(R.drawable.facebook,title,description));
        }
        editor.putInt("counter",++count);
        editor.commit();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adaptor = new RecyclerAdaptor(this,data);
        recyclerView.setAdapter(adaptor);
    }
}