package gunter.tutorials.redditandroiddev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter<ClickListener> extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>  {
    private List<Item> itemsList;
    private ClickListener clickListener;

    RecycleViewAdapter(List<Item> mItemList) {
        this.itemsList = mItemList;
    }

    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.MyViewHolder holder, final int position) {
        final Item item = itemsList.get(position);
        holder.title.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        private LinearLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            itemLayout =  itemView.findViewById(R.id.itemLayout);
        }
    }
}
