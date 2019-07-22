package br.com.digitalhouse.postapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.postapp.R;
import br.com.digitalhouse.postapp.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> listaDePosts = new ArrayList<>();

    public void updateListaDePosts(List<Post> listaDePosts){
        this.listaDePosts = listaDePosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_celula, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = listaDePosts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return listaDePosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView postImageView;
        private TextView tituloTextView;
        private TextView descricaoTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postImageView = itemView.findViewById(R.id.post_image_image_view);
            tituloTextView = itemView.findViewById(R.id.post_titulo_text_view);
            descricaoTextView = itemView.findViewById(R.id.post_descricao_text_view);
        }

        public void bind(Post post) {
            tituloTextView.setText(post.getTitulo());
            descricaoTextView.setText(post.getDescricao());
        }
    }
}
