package com.group2.dungeonraider.controller;

/**
 * Created by Rohit on 10/28/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.group2.dungeonraider.R;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.group2.dungeonraider.R;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.group2.dungeonraider.R;
import com.group2.dungeonraider.domain.Player;

/**
 * Created by Rohit on 10/27/2015
 */
public class Store extends Activity {
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Player player = Player.getInstance();


        tv = (TextView) findViewById(R.id.textView_goldvalue);
        tv.setText(String.valueOf(player.getGold()));
    }



    public void backtolevel(View v)
    {
        Store.this.finish();
    }

    public void onBackPressed() {
        Log.d("Store", "onBackPressed Called");

        Store.this.finish();
        return;
    }
    public void purchase_character_items(View v) {
        Intent i = new Intent(this, Purchase_Mutator.class);
        startActivity(i);
    }

    public void equip_character_items(View v) {
        Intent i = new Intent(this, EquipMutator.class);
        startActivity(i);
    }
    public void browsedungeonitems (View v)
    {
        Log.d("Store", "BrowseDungeonItems Called");
        Intent i = new Intent(this, PurchaseDungeonItems.class);
        startActivity(i);
    }
    public void onResume ()
    {
        super.onResume();
        Player player = Player.getInstance();
        tv = (TextView) findViewById(R.id.textView_goldvalue);
        tv.setText(String.valueOf(player.getGold()));
    }

}
