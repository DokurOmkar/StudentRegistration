package com.omkar.bestbuyapi.studentregistration;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.omkar.bestbuyapi.model.Student;
import java.net.ConnectException;
import java.util.ArrayList;

/**
 * Created by omkardokur on 12/19/15.
 */

public class DetailsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Student> studentData;
    LayoutInflater layoutInflater;


    public DetailsAdapter(Context context, ArrayList<Student> studentData) {
        this.mContext =context;
        this.studentData = studentData;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return studentData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View  view= layoutInflater.inflate(R.layout.item_student,null);
        TextView name=(TextView)view.findViewById(R.id.textView4);
        TextView marks = (TextView) view.findViewById(R.id.textView5);
        TextView sclass = (TextView) view.findViewById(R.id.textView6);
        Button deleteRow = (Button) view.findViewById(R.id.delete);
        Button updateRow = (Button) view.findViewById(R.id.btnUpdate);

        name.setText(studentData.get(position).getStudentName());
        marks.setText(studentData.get(position).getStudentMarks());
        sclass.setText(studentData.get(position).getStudentClass());
        deleteRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new SqliteHelper(mContext)).deleteTheStudent(studentData.get(position).getStudentId());
                ((DetailsActivity) mContext).updateAdapter();

            }
        });

        updateRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( mContext, UpdateActivity.class);
                intent.putExtra("id",  studentData.get(position));
                mContext.startActivity(intent);
            }
        });

        return view;
    }
}
