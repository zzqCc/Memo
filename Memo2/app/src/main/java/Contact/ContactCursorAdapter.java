package Contact;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lx.memo.R;

/**
 * Created by lx on 2016/4/9.
 */
public class ContactCursorAdapter extends CursorAdapter {
    public ContactCursorAdapter(Context context,Cursor cursor,int flags){
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
    }

    @Override
    public void bindView(View view,Context context,Cursor cursor){
        ImageView avatar = (ImageView) view.findViewById(R.id.contact_avatar);
        TextView name = (TextView) view.findViewById(R.id.contact_person_name);
        //image stored in sqlite//problem to be solved
        String sqlname = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        name.setText(sqlname);


    }
}
