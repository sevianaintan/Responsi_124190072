package id.ac.upnyk.responsicovid.fragment;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.upnyk.responsicovid.ApiMain;
import id.ac.upnyk.responsicovid.RS.DataItem;
import id.ac.upnyk.responsicovid.RS.RSResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RSViewModel extends ViewModel {
    private static final String TAG = "RSViewModel";
    private MutableLiveData<ArrayList<DataItem>> dataItem;

    public RSViewModel() {
        dataItem = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<DataItem>> getDataItem() {
        return dataItem;
    }

    public void loadrs() {
        ApiMain apiMain = new ApiMain();
        apiMain.getAPI().getHospital().enqueue(new Callback<RSResponse>() {
            @Override
            public void onResponse(Call<RSResponse> call, Response<RSResponse> rsresponse) {
                dataItem.setValue(rsresponse.body().getData());
            }

            @Override
            public void onFailure(Call<RSResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: FAil");

            }
        });
    }
}
