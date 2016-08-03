package hua.mydictresolver;

import android.content.ContentResolver;
import android.content.ContentValues;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int URL_LOADER = 0;
    ContentResolver contentResolver;
    Button insert;
    Button search;
    String Struri="content://"+"hua.mydictapplication.dictProvider"+"/words";
    CursorAdapter cursorAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        getSupportLoaderManager().initLoader(URL_LOADER,null,this);
        //simpleCursorAdapter=new SimpleCursorAdapter(this,R.layout.list_item,null,new String[]{"word","detail"},new int[]{R.id.text1,R.id.text2},0);
        listView=(ListView) findViewById(R.id.listView);
        //listView.setAdapter(simpleCursorAdapter);

        listView.setAdapter(cursorAdapter);



    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri=Uri.parse(Struri);
        return new CursorLoader(this,uri,null,null,null,null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in.  (The framework will take care of closing the
        // old cursor once we return.)
        cursorAdapter=new MyAdapter(this, data, 0);
        //cursorAdapter.changeCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);

    }
}
