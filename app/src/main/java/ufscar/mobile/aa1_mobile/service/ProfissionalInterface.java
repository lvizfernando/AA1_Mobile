package ufscar.mobile.aa1_mobile.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProfissionalInterface {
    @GET("profissionais")
    public Call<List<Profissional>> getProfissionais();

    @GET("profissionais")
    public Call<Profissional> getProfissional(@Query("id") int id);
}
