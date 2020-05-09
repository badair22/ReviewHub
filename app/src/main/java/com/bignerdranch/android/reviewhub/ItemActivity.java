package com.bignerdranch.android.reviewhub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    private EditText itemName, itemType, rating, price; //summary;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item);
        itemName = (EditText)findViewById(R.id.item_name);
        itemType = (EditText)findViewById(R.id.item_type);
        rating = (EditText)findViewById(R.id.item_rating);
        price = (EditText)findViewById(R.id.item_price);
        //summary = (EditText)findViewById(R.id.item_summary);
        save = (Button)findViewById(R.id.submit_item);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(itemName.getText().toString()) && !TextUtils.isEmpty(itemType.getText().toString()) && !TextUtils.isEmpty(rating.getText().toString()) && !TextUtils.isEmpty(price.getText().toString())) {
                    Item item = new Item(itemName.getText().toString(), itemType.getText().toString(), Long.parseLong(rating.getText().toString()), Long.parseLong(price.getText().toString())/*, summary.getText().toString()*/);
                    mDatabaseReference.child("items").push().setValue(item);
                    finish();
                }
                else {
                    itemName.setError("Enter an item name");
                    rating.setError("Enter a rating");
                    itemType.setError("Enter a restaurant name");
                    price.setError("Enter an item price");
                }
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

    public void goToDetails(View view) {
        Intent intent = new Intent (this, DetailsActivity.class);
        startActivity(intent);
    }

    protected Fragment createFragment() {
        return new ItemFragment();
    }
}
