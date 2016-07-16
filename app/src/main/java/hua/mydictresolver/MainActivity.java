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

public class MainActivity extends AppCompatActivity {
    ContentResolver contentResolver;
    Button insert;
    Button search;
    String Struri="content://"+"hua.mydictapplication.dictProvider"+"/words";

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

    }
}
