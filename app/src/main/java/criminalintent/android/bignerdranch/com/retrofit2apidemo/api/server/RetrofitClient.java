package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class RetrofitClient {
    private static API sRetrofit = null;
    private static final String BASE_URL = "https:/api-image-server.herokuapp.com/";

    public static API getClients () {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(API.class);
        }
        return sRetrofit;
    }

}
