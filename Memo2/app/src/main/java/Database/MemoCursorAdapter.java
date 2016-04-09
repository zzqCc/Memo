package Database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.lx.memo.R;

/**
 * Created by lx on 2016/4/7.
 */
public class MemoCursorAdapter extends CursorAdapter {
    public MemoCursorAdapter(Context context, Cursor cursor, int flags){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.memo_item,parent,false);
    }

    @Override
    public void bindView(View view,Context context, Cursor cursor){
        TextView title = (TextView) view.findViewById(R.id.memo_title);
        TextView day = (TextView) view.findViewById(R.id.memo_day); // to be modified
        TextView content  =(TextView) view.findViewById(R.id.memo_content);
        // time can be added
        String d_day = cursor.getString(cursor.getColumnIndexOrThrow("d_day"));///!!!>/
        String sqltitle = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String sqlcontent = cursor.getString(cursor.getColumnIndexOrThrow("content"));

        title.setText(sqltitle);
        day.setText(d_day);
        content.setText(sqlcontent);
    }
}
