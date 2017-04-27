package com.ehappy.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        /*建立一個新的HashMap物件,Integer和Class為鍵值的類別*/
        HashMap<Integer, Class<?>> implementations = new HashMap<>();
        implementations.put( R.id.show_image, LargeImageTileViewActivity.class );/*放入鍵值*/
        /*implementations.put( R.id.show_plans, BuildingPlansTileViewActivity.class );
        implementations.put( R.id.show_fiction, FictionalMapTileViewActivity.class );
        implementations.put( R.id.show_map, RealMapTileViewActivity.class );
        implementations.put( R.id.show_internet, RealMapInternetTileViewActivity.class );*/

        for (Map.Entry<Integer, Class<?>> entry : implementations.entrySet()) {
            TextView label = (TextView) findViewById( entry.getKey() );
            label.setTag( entry.getValue() );
            label.setOnClickListener( labelClickListener );
        }

    }

    private View.OnClickListener labelClickListener = new View.OnClickListener() {
        @Override
        public void onClick( View v ) {
            Class<?> activity = (Class<?>) v.getTag();
            Intent intent = new Intent( MainActivity.this, activity );
            startActivity( intent );
        }
    };
}



