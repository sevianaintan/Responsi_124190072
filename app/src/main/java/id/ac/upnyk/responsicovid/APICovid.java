package id.ac.upnyk.responsicovid;

import id.ac.upnyk.responsicovid.Info.InfoResponse;
import id.ac.upnyk.responsicovid.RS.RSResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APICovid {

    @GET("rekapitulasi_v2/jabar/harian")
    Call<InfoResponse> getCases();

    @GET("sebaran_v2/jabar/faskes")
    Call<RSResponse> getHospital();
}
