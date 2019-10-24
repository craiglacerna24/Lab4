package com.lacerna.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] Name, androidVersion, API, Date,shortMessage;
    ListView list;
    int[] androidLogo = {R.drawable.android1,R.drawable.android2, R.drawable.android3,
            R.drawable.android4,R.drawable.android5,R.drawable.android6,
            R.drawable.android7,R.drawable.android8,R.drawable.android9,
            R.drawable.android10,R.drawable.android11,R.drawable.android12,
            R.drawable.android13,R.drawable.android14, R.drawable.android15};
    ArrayList<Android> androidList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = getResources().getStringArray(R.array.androidTitle);
        androidVersion = getResources().getStringArray(R.array.androidVersion);
        API = getResources().getStringArray(R.array.APILevel);
        Date = getResources().getStringArray(R.array.releaseDate);
        shortMessage = getResources().getStringArray(R.array.androidMessage);
        list = findViewById(R.id.lvVersions);
        for (int i = 0; i<Name.length;i++){
            androidList.add(new Android(androidLogo[i],Name[i],"Ver. "+ androidVersion[i],"API Level " + API[i],
                    "Released "+Date[i],shortMessage[i]));
        }
        Adapter adapter = new Adapter(this, R.layout.list_display,androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getName());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage(androidList.get(i).getShortMessage());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create().show();
    }
}
