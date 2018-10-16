package api;

import android.support.annotation.NonNull;

public interface ResponseCallBack<T> {


    void onSuccess(@NonNull T data);

    void onFailure(@NonNull String error);
}
