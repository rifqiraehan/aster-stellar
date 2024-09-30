package com.project.belajarapistar.ui;

import androidx.lifecycle.MutableLiveData;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.project.belajarapistar.api.RetrofitClient;
import com.project.belajarapistar.BuildConfig;
import com.project.belajarapistar.data.model.StarItem;
import com.project.belajarapistar.data.model.StarResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<StarItem>> listStar = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    public MutableLiveData<ArrayList<StarItem>> getListStar() {
        return listStar;
    }
    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setSearchStar(String query) {
        String apiKey = BuildConfig.API_KEY;
        listStar.setValue(new ArrayList<>());
        isLoading.setValue(true);
        RetrofitClient.getApiService()
                .getStar(query, apiKey)
                .enqueue(new Callback<StarResponse>() {
                    @Override
                    public void onResponse(Call<StarResponse> call, Response<StarResponse> response) {
                        isLoading.setValue(false);
                        if (response.isSuccessful() && response.body() != null && response.body() != null) {
                            listStar.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<StarResponse> call, Throwable t) {
                        Log.e("API Call", "Failure: " + t.getMessage());
                        isLoading.setValue(false);
                    }
        });
    }
}
