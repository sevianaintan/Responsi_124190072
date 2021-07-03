package id.ac.upnyk.responsicovid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;
    public String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";

    public APICovid getAPI(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        }
        return retrofit.create(APICovid.class);
    }
}
