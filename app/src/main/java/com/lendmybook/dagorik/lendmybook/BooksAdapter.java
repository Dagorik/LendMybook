package com.lendmybook.dagorik.lendmybook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lendmybook.dagorik.lendmybook.models.BookArray;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Dagorik on 17/10/2016.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<BookArray> bookArrayList;
    private Context context;

    public BooksAdapter(List<BookArray> bookArrayList) {
        Log.i("myLog", "jaja");
        this.bookArrayList = bookArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_books, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BookArray bookArray = bookArrayList.get(position);
        Log.e("MyLogView", "Holi estoy dentro del ");
        holder.bindTrack(bookArray);

    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBooks;

        public ViewHolder(View itemView) {

            super(itemView);

            imgBooks = (ImageView) itemView.findViewById(R.id.img_book);
            Log.e("MyLogView", "Holi estoy dentro del ViewHolder");

        }


        public void bindTrack(final BookArray bookArray) {

            String imgUrl = bookArray.getImageUrl();
            Log.e("MyLogBind", "Holi estoy dentro del bindTrack");
            Glide.with(context).load(imgUrl).into(imgBooks);

            imgBooks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context, "LE DISTE CLICK A ESTE LIBRO: " + bookArray.getTitle().toString(), Toast.LENGTH_SHORT).show();


                    //Guardando los datos en un shared para pasarlos a LibroActivity
                    SharedPreferences preferences = context.getSharedPreferences("DatosJson", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("img_url", bookArray.getImageUrl());
                    editor.putString("descripcion", bookArray.getDescription());
                    editor.putString("autor", bookArray.getAuthor());
                    editor.putString("titulo", bookArray.getTitle());

                    editor.commit();


                    Intent intent = new Intent(context, LibroActivity.class);

                    context.startActivity(intent);


                }
            });


        }


    }

}
