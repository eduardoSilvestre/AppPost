package br.com.digitalhouse.postapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.postapp.adapter.PostAdapter;
import br.com.digitalhouse.postapp.viewmodel.PostViewModel;

import android.os.Bundle;

public class PostActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter = new PostAdapter();
    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        recyclerView = findViewById(R.id.post_recycler_view_id);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.atualizarPosts();

        postViewModel.getPostLiveData()
                .observe(this, listaDePost ->{
                    postAdapter.updateListaDePosts(listaDePost);
                });
    }
}
