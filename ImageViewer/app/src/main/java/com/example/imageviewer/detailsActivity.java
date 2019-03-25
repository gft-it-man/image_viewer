package com.example.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class detailsActivity extends AppCompatActivity {

    ImageView img;
    EditText editName;
    Button fullSize;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        img = findViewById(R.id.img);
        editName = findViewById(R.id.edit_name);
        fullSize = findViewById(R.id.button_full);
        context = this;

        Intent startIntent = getIntent();
        final ImageData image = (ImageData) startIntent.getSerializableExtra(ImageData.TAG);
        img.setImageURI(image.getUri());
        image.setName(editName.toString());

        fullSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullIntent = new Intent(context, FullscreenActivity.class);
                fullIntent.putExtra(ImageData.TAG, image);
                startActivity(fullIntent);
            }
        });






    }
}
