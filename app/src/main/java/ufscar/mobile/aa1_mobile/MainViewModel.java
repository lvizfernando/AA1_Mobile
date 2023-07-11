package ufscar.mobile.aa1_mobile;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ufscar.mobile.aa1_mobile.service.Profissional;
import ufscar.mobile.aa1_mobile.service.ProfissionalRepository;

import java.util.List;


public class MainViewModel extends ViewModel {
    final MutableLiveData<Boolean> showLoading = new MutableLiveData<>(false);
    final MutableLiveData<Profissional> profissional = new MutableLiveData<>();
    final MutableLiveData<List<Profissional>> profissionais = new MutableLiveData<>();

    public MutableLiveData<Boolean> getShowLoading() {
        return showLoading;
    }

    public MutableLiveData<Profissional> getProfissional() {
        return profissional;
    }

    public MutableLiveData<List<Profissional>> getProfissionais() {
        return profissionais;
    }

    public void pullProfissional(int id) {
        showLoading.setValue(true);
        ProfissionalRepository.getProfissional(id, new ProfissionalRepository.ProfissionalCallback() {
            @Override
            public void onSuccess(Profissional curProfissional) {
                showLoading.setValue(false);
                profissional.setValue(curProfissional);
                Log.d("Pull Success", "TRUE");
                Log.d("Pull ID", String.valueOf(id));
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("Error PullProfissional", errorMessage);
            }
        });
    }

    public void pullProfissionais() {
        showLoading.setValue(true);
        ProfissionalRepository.getProfissionais(new ProfissionalRepository.ProfissionaisCallback() {
            @Override
            public void onSuccess(List<Profissional> queryProfissionais) {
                showLoading.setValue(false);
                profissionais.setValue(queryProfissionais);
                Log.d("Pull Success", "TRUE");
                Log.d("Pull ID", "ALL");
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("Error PullProfissionais", errorMessage);
            }
        });
    }
}