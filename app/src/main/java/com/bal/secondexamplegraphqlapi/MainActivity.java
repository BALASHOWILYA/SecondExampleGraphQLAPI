package com.bal.secondexamplegraphqlapi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.rx2.Rx2Apollo;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private  static  final  String TAG = "MainActivity";
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<GetCharactersQuery.Result> characterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CharacterAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CharacterAdapter(this, characterList);
        recyclerView.setAdapter(adapter);



        fetchCharacters();

    }

    private void fetchCharacters() {
        GetCharactersQuery query = new GetCharactersQuery();
        Disposable disposable = Rx2Apollo.from(GraphQLClient.getApolloClientInstance().query(query))
                .subscribe(
                        this::handleResponse,
                        this::handleError

                );


    }

    private void handleError(Throwable throwable) {
    }

    private void handleResponse(ApolloResponse<Query.Data> dataApolloResponse) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}