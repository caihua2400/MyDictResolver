package hua.mydictresolver;

import android.content.ContentResolver;
import android.content.ContentValues;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int URL_LOADER = 0;
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
        getLoaderManager().initLoader(URL_LOADER,null,this);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri=Uri.parse(Struri);
        return new CursorLoader(this,uri,null,null,null,null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
