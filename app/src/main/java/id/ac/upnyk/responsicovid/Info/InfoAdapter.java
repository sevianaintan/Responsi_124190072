package id.ac.upnyk.responsicovid.Info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.upnyk.responsicovid.R;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private ArrayList<InfoContentItem> infoContentItems;
    private Context context;

    public InfoAdapter(Context context, ArrayList<InfoContentItem> infoContentItems) {
        this.context = context;
        this.infoContentItems = infoContentItems;
    }

    public void setInfoContentItems(ArrayList<InfoContentItem> infoContentItems){
        this.infoContentItems = infoContentItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.ViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return infoContentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tanggal, confirm, recover, died;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tanggal = itemView.findViewById(R.id.tv_list_item_date);
            confirm = itemView.findViewById(R.id.tv_list_item_confirmed);
            recover = itemView.findViewById(R.id.tv_list_item_recover);
            died = itemView.findViewById(R.id.tv_list_item_died);

        }

        public void bind(int position) {
            tanggal.setText(infoContentItems.get(position).getTanggal());
            confirm.setText(String.valueOf(infoContentItems.get(position).getConfirmationDiisolasi()));
            recover.setText(String.valueOf(infoContentItems.get(position).getConfirmationSelesai()));
            died.setText(String.valueOf(infoContentItems.get(position).getConfirmationMeninggal()));
        }
    }
}
