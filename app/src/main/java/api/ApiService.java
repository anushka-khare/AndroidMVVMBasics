package api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import com.example.daffodil_43.learningproject.create.model.CreateUserRequest;
import com.example.daffodil_43.learningproject.create.model.CreateUserResponse;

public interface ApiService {


    @POST("/api/users")
    Call<CreateUserResponse> createUser(@Body CreateUserRequest request);
}
