package com.example.imageswitcher;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton prev, next;
    ImageSwitcher imageSwitcher;
    int images[] = {R.drawable.gate, R.drawable.cgpit, R.drawable.lab, R.drawable.ws, R.drawable.c};
    int count = images.length;
    int currentindex = -1;
    private Button b1;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prev = (ImageButton) findViewById(R.id.i1);
        next = (ImageButton) findViewById(R.id.i2);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.is1);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }

        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentindex++;
                //  Check If index reaches maximum then reset it
                if (currentindex == count)
                    currentindex = 0;
                imageSwitcher.setImageResource(images[currentindex]); // set the image in ImageSwitcher
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --currentindex;
                if (currentindex < 0)
                    currentindex = images.length - 1;
                imageSwitcher.setImageResource(images[currentindex]);
            }
        });

                // initiate rating bar and a button
                ratingBar = (RatingBar) findViewById(R.id.ratingbar);
                b1 = (Button) findViewById(R.id.b1);
                // perform click event on button
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get values and then displayed in a toast
                        String totalStars = "Total Stars:: " + ratingBar.getNumStars();
                        String rating = "Rating :: " + ratingBar.getRating();
                        Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
                    }
                });
            }


        }




