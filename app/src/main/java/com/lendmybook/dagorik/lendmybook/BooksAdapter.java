package com.lendmybook.dagorik.lendmybook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lendmybook.dagorik.lendmybook.models.BookArray;

import java.util.List;

/**
 * Created by Dagorik on 17/10/2016.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<BookArray> bookArrayList;
    private Context context;


    public BooksAdapter(List<BookArray> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_books,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BookArray bookArray = bookArrayList.get(position);
        holder.bindTrack(bookArray);

    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBooks;

        public ViewHolder(View itemView) {
            super(itemView);

            imgBooks = (ImageView) itemView.findViewById(R.id.img_book);

        }

        public void bindTrack(final BookArray bookArray){

//            imgBooks.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    //Toast.makeText(contexto, "LE DISTE CLICK A ESTE LIBRO", Toast.LENGTH_SHORT).show();
//                }
//            });


        }

    }

}
