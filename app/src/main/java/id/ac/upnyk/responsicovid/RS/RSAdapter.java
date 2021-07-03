package id.ac.upnyk.responsicovid.RS;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.upnyk.responsicovid.R;

public class RSAdapter extends RecyclerView.Adapter<RSAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DataItem> dataItems;

    public RSAdapter(Context context, ArrayList<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    public void setDataItems(ArrayList<DataItem> dataItems) {
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_rs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private TextView Name, Address;
        private Button btnMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.tv_list_name);
            Address = itemView.findViewById(R.id.tv_list_address);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }

        public void bind(int position) {
            Name.setText(dataItems.get(position).getNama());
            Address.setText(dataItems.get(position).getAlamat());
            btnMaps.setOnClickListener(v -> {
                String address = String.format("geo: 0, 0?q= %s", dataItems.get(position).getNama());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            });
        }
    }
}
