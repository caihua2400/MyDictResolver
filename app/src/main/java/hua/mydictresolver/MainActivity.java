package hua.mydictresolver;

import android.content.ContentResolver;
import android.content.ContentValues;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    ContentResolver contentResolver;
    Button insert;
    Button search;
    String Struri="content://"+"hua.mydictapplication.dictProvider"+"/words";
    Button bulkInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        contentResolver=getContentResolver();
        insert=(Button) findViewById(R.id.insert);
        search=(Button) findViewById(R.id.search);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word=((EditText)findViewById(R.id.word)).getText().toString();
                String detail=((EditText)findViewById(R.id.detail)).getText().toString();
                ContentValues contentValues=new ContentValues();
                contentValues.put("word",word);
                contentValues.put("detail",detail);
                Uri uri=Uri.parse(Struri);
                contentResolver.insert(uri,contentValues);
                Toast.makeText(MainActivity.this,"insert success",Toast.LENGTH_LONG).show();

            }
        });
        bulkInsert=(Button) findViewById(R.id.bulkInsert);
        bulkInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues=new ContentValues();
                contentValues.put("word","love");
                contentValues.put("detail","like some one");
                Vector<ContentValues> cw=new Vector<ContentValues>(5);
                cw.add(contentValues);
                ContentValues[] cvArray=new ContentValues[cw.size()];
                cw.toArray(cvArray);
                Uri uri=Uri.parse(Struri);
                contentResolver.bulkInsert(uri,cvArray);



            }
        });


    }
}
