package hua.mydictresolver;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

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
        View view= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView t1=(TextView) view.findViewById(R.id.text1);
        TextView t2=(TextView) view.findViewById(R.id.text2);

           int row1=cursor.getColumnIndex("word");
            int row2=cursor.getColumnIndex("detail");
            String word=cursor.getString(row1);
            String detail=cursor.getString(row2);
            t1.setText(word);
            t2.setText(detail);





    }
}
