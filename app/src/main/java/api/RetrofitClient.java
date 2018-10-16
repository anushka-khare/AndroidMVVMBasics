package api;

import java.util.concurrent.TimeUnit;

import com.example.daffodil_43.learningproject.common.AppConstant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {

    private static Retrofit sRetrofit;
    private static ApiService sApiService;

    /**
     * Initialize retrofit client with base url
     *
     * @return Instance if retrofit
     */
    private static Retrofit getRetrofit() {
        if (sRetrofit == null) {

            final String baseUrl = AppConstant.BASE_URL;

            final OkHttpClient client = new OkHttpClient.Builder()
                    .followRedirects(true)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();

            sRetrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }

        return sRetrofit;
    }


    /**
     * Get api retrofit object
     *
     * @return Instance of api service
     */
    public static ApiService getApiService() {
        if (sApiService == null) {
            sApiService = getRetrofit().create(ApiService.class);
        }

        return sApiService;
    }

}
