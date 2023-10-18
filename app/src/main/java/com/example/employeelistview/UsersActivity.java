package com.example.employeelistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class UsersActivity extends AppCompatActivity {

    ListView userListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        userListView = findViewById(R.id.lv_users);

        //ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataManager.users);
        UserAdapter adapter = new UserAdapter(this, DataManager.users);

        userListView.setAdapter(adapter);

    }


}
