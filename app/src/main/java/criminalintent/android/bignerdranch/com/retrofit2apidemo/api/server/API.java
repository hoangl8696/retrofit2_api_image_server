package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.server;

import java.util.List;

import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.AuthResponse;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.Credentials;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.File;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.FileSummary;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.ImageUrl;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.UpdateUser;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.User;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public interface API {
    @POST("/auth/signin")
    Call<AuthResponse> login (@Header("key") String key ,@Body Credentials credentials);

    @POST("/auth/signup")
    Call<AuthResponse> signup (@Header("key") String key, @Body Credentials credentials);

    @GET("/api/user")
    Call<User> getCurrentUser (@Header("token") String JWT);

    @PUT("/api/user")
    Call<User> updateCurrentUser (@Header("token") String JWT, @Body UpdateUser updateUser);

    @DELETE("/api/user")
    Call<User> deleteCurrentUser (@Header("token") String JWT);

    @Multipart
    @POST("/api/uploads")
    Call<File> uploadAvatar (@Header("token") String JWT, @Part MultipartBody.Part file);

    @GET("/api/uploads")
    Call<List<FileSummary>> getAvatars (@Header("token") String JWT);

    @Streaming
    @GET("/api/uploads/{id}")
    Call<ResponseBody> getAvatar (@Header("token") String JWT, @Path("id") String id);

    @DELETE("/api/uploads/{id}")
    Call<FileSummary> deleteAvatar (@Header("token") String JWT, @Path("id") String id);

    @Streaming
    @POST("/api/contentful/stream/image")
    Call<ResponseBody> getImage (@Header("token") String JWT, @Body ImageUrl url);
}
