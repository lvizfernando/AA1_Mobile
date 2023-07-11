package ufscar.mobile.aa1_mobile.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfissionalAPIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/lvizfernando/jsonserver/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
