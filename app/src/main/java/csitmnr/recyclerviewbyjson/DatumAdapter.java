package csitmnr.recyclerviewbyjson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Manoj Budha Ayer on 9/17/2017.
 */

public class DatumAdapter extends RecyclerView.Adapter<DatumAdapter.MyViewHolder> {
    Context context;
    List<Datum> list;

    public DatumAdapter(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.content_viewer,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Datum data = list.get(position);

        Glide
                .with(holder.imageView.getContext())
                .load(data.getImage())
                .into(holder.imageView);

        holder.title.setText(data.getTitle());
        holder.author.setText(data.getAuthor());
        holder.date_en.setText(data.getDateEn());
        holder.intro.setText(data.getIntro());
        holder.date_np.setText(data.getDateNp());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView title,intro,author,date_en,date_np;
            ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            intro = itemView.findViewById(R.id.intro);
            author = itemView.findViewById(R.id.author);
            date_en = itemView.findViewById(R.id.dateEn);
            date_np = itemView.findViewById(R.id.dateNP);
        }
    }
}
