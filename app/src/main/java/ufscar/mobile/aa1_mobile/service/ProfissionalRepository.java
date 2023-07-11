package ufscar.mobile.aa1_mobile.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfissionalRepository {
    public static void getProfissional(int id, ProfissionalCallback callback) {
        ProfissionalInterface client = ProfissionalAPIClient.getClient().create(ProfissionalInterface.class);
        Call<Profissional> call = client.getProfissional(id);
        call.enqueue(new Callback<Profissional>() {
            @Override
            public void onResponse(Call<Profissional> call, Response<Profissional> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Profissional> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public static void getProfissionais(ProfissionaisCallback callback) {
        ProfissionalInterface client = ProfissionalAPIClient.getClient().create(ProfissionalInterface.class);
        Call<List<Profissional>> call = client.getProfissionais();
        call.enqueue(new Callback<List<Profissional>>() {
            @Override
            public void onResponse(Call<List<Profissional>> call, Response<List<Profissional>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Profissional>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    // set a generic callback interface
    public interface ProfissionalCallback {
        public void onSuccess(Profissional profissional);

        public void onError(String errorMessage);
    }

    public interface ProfissionaisCallback {
        public void onSuccess(List<Profissional> profissionais);

        public void onError(String errorMessage);
    }
}