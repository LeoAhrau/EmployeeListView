package com.example.employeelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {


    public UserAdapter(Context context, List<User> users) {super(context, 0, users); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_member, parent, false);
        }

        User currentUser = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.tv_name);
        nameTextView.setText(currentUser.toString());


        return listItemView;
    }
}
