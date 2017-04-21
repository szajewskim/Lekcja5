package com.example.marek.lekcja5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView lv;
    private String[] pho;

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    private Dialog createAlertDialogWithButtons() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Wyjście");
        dialogBuilder.setMessage("Czy na pewno");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("Tak", new Dialog.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton){
                showToast("Wychodzę");
                MainActivity.this.finish();
            }
        });
        dialogBuilder.setNegativeButton("Nie", new Dialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                showToast("Anulowanie");
            }
        });

        return dialogBuilder.create();
    }








    private void initResources() {
        Resources res = getResources();
        pho = res.getStringArray(R.array.phones);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent, View v, int pos, long id){
                if(pos == 0) {
                    Context context;
                    context = getApplicationContext();
                    Intent intent = new Intent(context, iPhone6s.class);
                    startActivity(intent);
                }
                else if(pos == 1){
                    Context context;
                    context = getApplicationContext();
                    Intent intent = new Intent(context, SamsungGalaxyS7.class);
                    startActivity(intent);
                }
                else if(pos == 2){
                    Context context;
                    context = getApplicationContext();
                    Intent intent = new Intent(context, Nokia6310i.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initLanguagesListView(){
        lv.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, pho));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.telefony);
        initResources();
        initLanguagesListView();





    }

}
