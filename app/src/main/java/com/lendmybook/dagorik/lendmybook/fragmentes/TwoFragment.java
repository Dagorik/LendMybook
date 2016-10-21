package com.lendmybook.dagorik.lendmybook.fragmentes;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.lendmybook.dagorik.lendmybook.BooksAdapter;
import com.lendmybook.dagorik.lendmybook.R;
import com.lendmybook.dagorik.lendmybook.interfaces.LendMyBookServices;
import com.lendmybook.dagorik.lendmybook.models.BookArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;
import static com.facebook.FacebookSdk.getApplicationContext;


public class TwoFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerViewBooks;
    private View view;
    private BooksAdapter booksAdapter;
    private List<BookArray> booksAdapterslist;
    private int i;


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        booksAdapterslist = new ArrayList<>();
        floatingActionButton.setOnClickListener(this);

        //Agregando datos a la lista libros
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());
//        booksAdapterslist.add(new BookArray());

        //Configurando el reciclerView
        recyclerViewBooks = (RecyclerView) view.findViewById(R.id.recycler_books);
        recyclerViewBooks.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        // recyclerViewBooks.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewBooks.setHasFixedSize(true);

        //Inicializando el adaptador de Books,

        //Cargando el metodo para obetener todas las portadas de los libros
        loadAllBooks();


        return view;
    }


    @Override
    public void onClick(View view) {
        Log.i("MylogC", "Holi entre al on click");

        switch (view.getId()) {

            case R.id.fab:

                Log.i("MylogF!", "Holi entre al Floating");

                showDialog();

                break;
        }
    }

//
//    public void setUpRecyclerView(){
//        recyclerViewBooks = (RecyclerView) view.findViewById(R.id.recycler_books);
//        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(TwoFragment.this,LinearLayoutManager.VERTICAL,false));
//        recyclerViewBooks.setHasFixedSize(true);
//    }


    public void showDialog() {


        FragmentManager fm = getActivity().getFragmentManager();
        PublicarDialogFragment dialogFragment = new PublicarDialogFragment();
        dialogFragment.show(fm, "asd");


    }

    public void loadAllBooks() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://lendmybook.mx")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final LendMyBookServices client = retrofit.create(LendMyBookServices.class);

        client.getAllBooks().enqueue(new Callback<List<BookArray>>() {
            @Override
            public void onResponse(Call<List<BookArray>> call, Response<List<BookArray>> response) {

                Log.i("MyLogR", response.body().get(0).getTitle().toString());
                Log.i("MyLogImg", response.body().get(0).getImageUrl().toString());
                Log.e("La Lista es :", "" + response.body().get(0).toString());


                booksAdapterslist = response.body();
                int lista = booksAdapterslist.size();

                Log.e("LISTA= ", "" + lista);



                    settingRecyclerView();

                    booksAdapter.notifyDataSetChanged();






//                /Log.i("MyLogSha", id);

            }

            @Override
            public void onFailure(Call<List<BookArray>> call, Throwable t) {
                Log.d("MyLogError", t.getMessage());
            }
        });

    }

    public void settingRecyclerView() {
        recyclerViewBooks.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerViewBooks.setHasFixedSize(true);
        booksAdapter = new BooksAdapter(booksAdapterslist);
        recyclerViewBooks.setAdapter(booksAdapter);

    }

}
