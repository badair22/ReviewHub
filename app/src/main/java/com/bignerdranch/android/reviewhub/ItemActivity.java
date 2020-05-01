package com.bignerdranch.android.reviewhub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.bignerdranch.android.reviewhub.ui.item.Item;
import com.bignerdranch.android.reviewhub.ui.item.ItemFragment;
import com.bignerdranch.android.reviewhub.ui.review.Review;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private Button save;
    private EditText name, rating, price, type, summary;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item);
        name = (EditText)findViewById(R.id.item_name);
        rating = (EditText)findViewById(R.id.item_rating);
        price = (EditText)findViewById(R.id.item_price);
        type = (EditText)findViewById(R.id.item_type);
        summary = (EditText)findViewById(R.id.item_summary);
        save = (Button)findViewById(R.id.submit_item);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item = new Item(name.getText().toString(), rating.getText().toString(), price.getText().toString(), type.getText().toString(), summary.getText().toString());
                mDatabaseReference.child("items").push().setValue(item);
                finish();
            }
        });
        this.createFragment();
    }

/*    public void submit(View view) {
        finish();
    }

    public void cancel(View view) {
        finish();
    }*/

    protected Fragment createFragment() {
        return new ItemFragment();
    }
}
