package com.moh.myviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    int[] pics = {R.drawable.audemars, R.drawable.patek, R.drawable.richar, R.drawable.rol,};
    String[] names = {"Audemars Piguet", "Patek Philippe", "Richard Mille", "Rolex Submariner",};
    ArrayList<item> imgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        for (int i = 0; i < pics.length; i++) {
            imgs.add(new item(names[i], pics[i]));
        }

        SwipeItem swipeItem = new SwipeItem(this, imgs);
        viewPager.setAdapter(swipeItem);
    }

    class SwipeItem extends PagerAdapter {
        LayoutInflater layoutInflater;
        Context context;
        ArrayList<item> items = new ArrayList<>();

        public SwipeItem(Context context, ArrayList<item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.my_items, container, false);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.textView);

            imageView.setImageResource(items.get(position).getAnInt());
            textView.setText(items.get(position).getString());
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
        }
    }
}
