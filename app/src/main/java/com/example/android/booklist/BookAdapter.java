package com.example.android.booklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Booklist> {


    public BookAdapter(Context context, List<Booklist> bookLists) {
        super(context, 0, bookLists);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_books, parent, false);

        }

        Booklist currentBooklist = getItem(position);

        TextView bookName = listItemView.findViewById(R.id.book_name);
        bookName.setText(currentBooklist.getBookName());

        TextView authorName = listItemView.findViewById(R.id.author_name);
        authorName.setText(currentBooklist.getAuthorName());

        TextView priceView = listItemView.findViewById(R.id.price);
        priceView.setText(currentBooklist.getPrice());

        TextView currencyText = listItemView.findViewById(R.id.currency_code);
        currencyText.setText(currentBooklist.getCurency());

        TextView writerNmae = listItemView.findViewById(R.id.writer_name);
        writerNmae.setText(currentBooklist.getWriterName());

        ImageView coverImage = listItemView.findViewById(R.id.cover_image);
        Picasso.get().load(currentBooklist.getImageUrl()).placeholder(R.mipmap.book_icon).error(R.mipmap.book_icon).into(coverImage);

        return listItemView;
    }
}
