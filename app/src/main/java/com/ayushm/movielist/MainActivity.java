package com.ayushm.movielist;

import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ayushm.movielist.RequestManager.APIClient;
import com.ayushm.movielist.RequestManager.APIInterface;
import com.ayushm.movielist.model.MoviesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.setTessst);
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
                          List<MoviesList> moviesLists = response.body();
                            for (MoviesList moviesList : moviesLists){
                                  String strmovieLists = "";
                                  strmovieLists += "num" + moviesList.getNum() + "\n" ;
                                  strmovieLists += "name" + moviesList.getName() + "\n" ;
                                 responseText.append(strmovieLists);

                      }
//                String displayResponse = "";
//
//                MoviesList resource = response.body();
//                Integer text = resource.getNum();
//                Integer total = resource.getRating();
//                Integer totalPages = resource.getStreamId();
//                List<MoviesList> datumList = resource.data;
//
//                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";
//
//                for (MultipleResource.Datum datum : datumList) {
//                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
//                }
//
//                responseText.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<List<MoviesList>> call, Throwable t) {
                call.cancel();
            }
        });

//        /**
//         Create new user
//         **/
//        User user = new User("morpheus", "leader");
//        Call<User> call1 = apiInterface.createUser(user);
//        call1.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user1 = response.body();
//
//                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//        /**
//         GET List Users
//         **/
//        Call<UserList> call2 = apiInterface.doGetUserList("2");
//        call2.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//
//        /**
//         POST name and job Url encoded.
//         **/
//        Call<UserList> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
//        call3.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });


    }

}