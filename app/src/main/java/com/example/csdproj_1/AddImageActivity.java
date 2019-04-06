package com.example.csdproj_1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddImageActivity extends AppCompatActivity {

    private Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
        save_button = findViewById(R.id.save_button);
        final Activity activity;
        activity = this;

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEditText = findViewById(R.id.add_title);
                EditText descEditText = findViewById(R.id.add_description);

                Intent intent = new Intent(activity,MainActivity.class);
                startActivity(intent);

                SharedPreferences sharedPreferences = getSharedPreferences("AlbumData", MODE_PRIVATE);
                int count = sharedPreferences.getInt("counter", 0);
                SharedPreferences.Editor editor =  sharedPreferences.edit();


                editor.putString("title" + Integer.toString(count),titleEditText.getText().toString());
                editor.putString("description" + Integer.toString(count), descEditText.getText().toString());
                editor.commit();
            }
        });
    }
}
