package com.example.android.tourism;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private int mcolor;
    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        mcolor = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }
        Word currentWord = getItem(position);

        TextView text1 = (TextView) listItemView.findViewById(R.id.tour_text_view);
        text1.setText(currentWord.getmName());

        ImageView image1 = (ImageView) listItemView.findViewById(R.id.image_main);
        if (currentWord.hasImage()) {
            image1.setImageResource(currentWord.getmImage());
            image1.setVisibility(View.VISIBLE);
        } else {
            image1.setVisibility(View.GONE);
        }
        View textcon = listItemView.findViewById(R.id.main_container);
        int color = ContextCompat.getColor(getContext(), mcolor);
        textcon.setBackgroundColor(color);
        return listItemView;
    }
}
