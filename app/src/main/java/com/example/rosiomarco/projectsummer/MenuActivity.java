package com.example.rosiomarco.projectsummer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class MenuActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
    }
    private void setSingleEvent(final GridLayout mainGrid){

        for (int i = 0; i <mainGrid.getChildCount(); i++){
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0)
                    {
                        Intent intent = new Intent(MenuActivity.this,RestaurantActivity.class );
                        startActivity(intent);


                    }
                    else if (finalI == 1)
                    {
                        Intent intent = new Intent(MenuActivity.this,BarActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 2)
                    {
                        Intent intent = new Intent(MenuActivity.this,StoreActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 3)
                    {
                        Intent intent = new Intent(MenuActivity.this,GasActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 4)
                    {
                        Intent intent = new Intent(MenuActivity.this,CafeActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 5)
                    {
                        Intent intent = new Intent(MenuActivity.this,BankActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

}
