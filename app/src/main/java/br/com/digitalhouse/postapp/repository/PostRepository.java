package br.com.digitalhouse.postapp.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.digitalhouse.postapp.model.Post;
import io.reactivex.Observable;

public class PostRepository {

    public Observable<List<Post>> buscarListaPosts(){
        return Observable.create(emitter -> {
            List<Post> listaDePost = new ArrayList<>();
            Post post = new Post();
            post.setTitulo("Novos cursos no segundo semestre");
            post.setDescricao("A Digital House já começou os cursos do segundo semestre");
            listaDePost.add(post);

            Post post2 = new Post();
            post2.setTitulo("Digital Summit foi um sucesso");
            post2.setDescricao("muitas palestras no Digital House Summit 2019");
            listaDePost.add(post2);

            Post post3 = new Post();
            post3.setTitulo("Mais mulheres na programação");
            post3.setDescricao("A Digital House disponibiliza 100 cursos para mulheres nos cursos de programação");
            listaDePost.add(post3);

            emitter.onNext(listaDePost);
            emitter.onComplete();
        });
    }

    public Observable<List<Post>> buscarListaDePostJson(Context context){
        return Observable.create(emitter -> {
            //Criar um stream para ler o arquivo JSON.
            AssetManager manager = context.getAssets();
            InputStream postsJson = manager.open("posts.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(postsJson));

//Criar um objeto da classe Gson que permita analisar o JSON de forma simples.
            Gson gson = new Gson();

//Utilizando o objeto gson e o método fromJson, fazer a análise do arquivo que temos no bufferReaderIn, usando como “molde” a classe News.
            Post[] post = gson.fromJson(bufferReaderIn, Post[].class);

            List<Post> listaDePosts = Arrays.asList(post);

            emitter.onNext(listaDePosts);
            emitter.onComplete();
        });
    }
}
