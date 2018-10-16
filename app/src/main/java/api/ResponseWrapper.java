package api;

import retrofit2.Callback;

public class ResponseWrapper<T> implements Callback<T> {

    ResponseCallBack responseCallBack;

    public ResponseWrapper(ResponseCallBack<T> responseCallback) {
        this.responseCallBack = responseCallback;
    }


    @Override
    public void onResponse(retrofit2.Call<T> call, retrofit2.Response<T> response) {
        if(response.isSuccessful())
        {
            responseCallBack.onSuccess(response.body());
        }
        else
        {
            responseCallBack.onFailure(response.message());
        }
    }

    @Override
    public void onFailure(retrofit2.Call<T> call, Throwable t) {
        responseCallBack.onFailure(t.getMessage());

    }
}
