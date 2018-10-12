package com.example.nogahblum.carrotmonster;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.squareup.picasso.Picasso;


public class SlideAdapter  extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.fenratarir0,//todo change name of images to this name (type0)
            R.drawable.hiakango0 // type 1
//            R.drawable.image_3,
//            R.drawable.image_4
    };
    // list of titles
    public String[] lst_title = {
            "fenratarir",
            "hiakango"
//            "GALAXY",
//            "ROCKET"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "I am fenratarir",
            "I am hiakango"
//            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
//            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85)
//            Color.rgb(110,49,89),
//            Color.rgb(1,188,212)
    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
//        int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);

//        imgslide.setImageDrawable(R.drawable.image_1);
        // todo: use picasso with scale down
        // todo: change targetWidth/Height to math image resolution
        Picasso.get().load(lst_images[position])
                .resize(2048, 2048)
                .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                .into(imgslide);

        txttitle.setText(lst_title[position]);

//        Button button= (Button) findViewById(R.id.createMe);
        Button button = (Button) view.findViewById(R.id.createMe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity(position);
            }
        });
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
    private void startNextActivity(int p) {
        Intent it = new Intent(context, ChooseFoodActivity.class);
        String p2 = String.valueOf(p);
        it.putExtra("KEY_StringName",p2);
        context.startActivity(it);
    }

}

