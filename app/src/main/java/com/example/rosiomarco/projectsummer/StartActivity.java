package com.example.rosiomarco.projectsummer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void submitTest(View view)
    {
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MenuActivity.class));
    }

}
