package personal.com.sample.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.AdapterItem>{
    private Context context;
    private List<Object> data;      //data set that holds the displaying content

    public MyRecyclerAdapter(Context context, List<Object> data){
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public AdapterItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        //change the given layout below to required one
        view = LayoutInflater.from(context).inflate(android.R.layout.simple_dropdown_item_1line,parent,false);
        return new AdapterItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem holder, int position) {
        Object object = data.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class AdapterItem extends RecyclerView.ViewHolder{
        public AdapterItem(View itemView) {
            super(itemView);
        }
    }
}
