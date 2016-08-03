package hua.mydictresolver;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by caihua2300 on 03/08/2016.
 */
public class MyAdapter extends CursorAdapter {
    private Context mContext;
    public MyAdapter(Context context, Cursor c, int flags) {


        super(context, c, flags);
        mContext=context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
