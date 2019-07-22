package br.com.digitalhouse.postapp.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import br.com.digitalhouse.postapp.model.Post;
import br.com.digitalhouse.postapp.repository.PostRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends AndroidViewModel {

    private MutableLiveData<List<Post>> postsLiveData = new MutableLiveData<>();

    private PostRepository repository = new PostRepository();

    private CompositeDisposable disposable = new CompositeDisposable();

    public PostViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Post>> getPostLiveData(){
        return postsLiveData;
    }

    public void atualizarPosts(){
        disposable.add(repository.buscarListaPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(listaDePosts -> postsLiveData.setValue(listaDePosts))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
