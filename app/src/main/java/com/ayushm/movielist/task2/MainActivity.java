package com.ayushm.movielist.task2;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ayushm.movielist.R;
import com.ayushm.movielist.task2.RequestManager.APIClient;
import com.ayushm.movielist.task2.RequestManager.APIInterface;
import com.ayushm.movielist.task2.adapter.MovieAdapter;
import com.ayushm.movielist.task2.model.MoviesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView responseText;
    APIInterface apiInterface;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.moviesList_recyclerView);

         listingData();
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
    }

    private void listingData() {
        apiInterface = APIClient.getClient().create(APIInterface.class);


        /**
         GET List Resources
         **/
        Call<List<MoviesList>> call = apiInterface.getMoviesList("test","test1","get_vod_streams");
        call.enqueue(new Callback<List<MoviesList>>() {
            @Override
            public void onResponse(Call<List<MoviesList>> call, Response<List<MoviesList>> response) {

                if(!response.isSuccessful()) {
                    responseText.setText("Code: "+ response.code());
                    return;
                }

                if (response.isSuccessful()){
                    for (int i=0;i<50;i++){
                    MovieAdapter movieAdapter = new MovieAdapter(response.body());
                    recyclerView.setAdapter(movieAdapter);}
              return;
                }



//                List<MoviesList> moviesLists = response.body();
//                for (MoviesList moviesList : moviesLists){
//                    String strmovieLists = "";
//                    strmovieLists += "num" + moviesList.getNum() + "\n" ;
//                    strmovieLists += "name" + moviesList.getName() + "\n" ;
//                    responseText.append(strmovieLists);}

                }



            @Override
            public void onFailure(Call<List<MoviesList>> call, Throwable t) {
                call.cancel();
            }
        });


    }

}