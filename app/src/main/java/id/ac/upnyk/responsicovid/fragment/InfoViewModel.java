package id.ac.upnyk.responsicovid.fragment;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.upnyk.responsicovid.ApiMain;
import id.ac.upnyk.responsicovid.Info.InfoContentItem;
import id.ac.upnyk.responsicovid.Info.InfoResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoViewModel extends ViewModel {
    private static final String TAG = "InfoViewModel";
    private MutableLiveData<ArrayList<InfoContentItem>> infoContentItems;

    public InfoViewModel() {
        infoContentItems = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<InfoContentItem>> getInfoContentItems(){
        return infoContentItems;
    }

    public void loadInfo(){
        ApiMain apiMain = new ApiMain();
        apiMain.getAPI().getCases().enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                infoContentItems.setValue(response.body().getData().getContent());
            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: FAil");

            }
        });
    }

}
