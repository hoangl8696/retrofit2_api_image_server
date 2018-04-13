package criminalintent.android.bignerdranch.com.retrofit2apidemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.AuthResponse;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.Credentials;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.FileSummary;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.ImageUrl;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.UpdateUser;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.User;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.server.API;
import criminalintent.android.bignerdranch.com.retrofit2apidemo.api.server.RetrofitClient;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private API mApi;
    private static final String DEVELOPER_KEY = "developer";
    public static final int UPLOAD_AVATAR = 4;
    public static final int UPLOAD_IMAGE = 5;
    private Button signupBtn, loginBtn, getUserBtn, updateUserBtn,
            deleteUserBtn, uploadAvatarBtn, getAvatarsBtn, getAvatarBtn, deleteAvatarBtn,
            uploadImageBtn, getImageBtn;
    private TextView responseView;
    private ImageView imageView;
    private String JWT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApi = RetrofitClient.getClients();
        responseView = findViewById(R.id.response);
        imageView = findViewById(R.id.image);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Credentials credentials = new Credentials();
                credentials.setEmail("60@string.com");
                credentials.setPassword("string");
                mApi.login(DEVELOPER_KEY, credentials).enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        if (response.isSuccessful()) {
                            responseView.setText(response.body().toString());
                            JWT = response.body().getToken();
                        } else {
                            responseView.setText(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        signupBtn = findViewById(R.id.signup_btn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Credentials credentials = new Credentials();
                Random random = new Random();
                int result = random.nextInt(100);
                credentials.setEmail(Integer.toString(result)+"@string.com");
                credentials.setPassword("string");
                mApi.signup(DEVELOPER_KEY, credentials).enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        if (response.isSuccessful()) {
                            responseView.setText(response.body().toString());
                            JWT = response.body().getToken();
                        } else {
                            responseView.setText(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        getUserBtn = findViewById(R.id.get_user_btn);
        getUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    mApi.getCurrentUser(JWT).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                responseView.setText(response.body().toString());
                            } else {
                                responseView.setText(response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        updateUserBtn = findViewById(R.id.update_user_btn);
        updateUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    UpdateUser update = new UpdateUser();
                    update.setAge(10);
                    update.setDescription("Yo yo");
                    update.setName("testei");
                    mApi.updateCurrentUser(JWT, update).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                responseView.setText(response.body().toString());
                            } else {
                                responseView.setText(response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        deleteUserBtn = findViewById(R.id.delete_user_btn);
        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    mApi.deleteCurrentUser(JWT).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                JWT = "";
                                responseView.setText(response.body().toString());
                            } else {
                                responseView.setText(response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        uploadAvatarBtn = findViewById(R.id.upload_avatar_btn);
        uploadAvatarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    startActivityForResult(new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), UPLOAD_AVATAR);
                }
            }
        });
        getAvatarsBtn = findViewById(R.id.get_all_avatar_btn);
        getAvatarsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    mApi.getAvatars(JWT).enqueue(new Callback<List<FileSummary>>() {
                        @Override
                        public void onResponse(Call<List<FileSummary>> call, Response<List<FileSummary>> response) {
                            if (response.isSuccessful()) {
                                responseView.setText(response.body().toString());
                            } else {
                                responseView.setText(response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<List<FileSummary>> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        getAvatarBtn = findViewById(R.id.get_avatar_btn);
        getAvatarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    mApi.getAvatar(JWT, "5acf4cb5d9ead600041c096f").enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            new RetrieveImage().execute(response.body());
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        deleteAvatarBtn = findViewById(R.id.delete_avatar_btn);
        deleteAvatarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    mApi.deleteAvatar(JWT, "5acf4cb5d9ead600041c096f").enqueue(new Callback<FileSummary>() {
                        @Override
                        public void onResponse(Call<FileSummary> call, Response<FileSummary> response) {
                            if (response.isSuccessful()) {
                                responseView.setText(response.body().toString());
                            } else {
                                responseView.setText(response.message());
                            }
                        }
                        @Override
                        public void onFailure(Call<FileSummary> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        uploadImageBtn = findViewById(R.id.upload_image_btn);
        uploadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    startActivityForResult(new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), UPLOAD_IMAGE);
                }
            }
        });

        getImageBtn = findViewById(R.id.get_image_btn);
        getImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (JWT.isEmpty()) {
                    responseView.setText("signup or signin first to get the JWT");
                } else {
                    ImageUrl url = new ImageUrl();
                    url.setUrl("https://images.ctfassets.net/yadj1kx9rmg0/wtrHxeu3zEoEce2MokCSi/cf6f68efdcf625fdc060607df0f3baef/quwowooybuqbl6ntboz3.jpg");
                    mApi.getImage(JWT, url).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            new RetrieveImage().execute(response.body());
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            uploadFile(selectedImage, requestCode);
        }
    }

    private void uploadFile(Uri fileUri, int code) {
        File file = new File(getRealPathFromURI(fileUri));

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(getContentResolver().getType(fileUri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        switch (code) {
            case UPLOAD_AVATAR:
                // finally, execute the request
                mApi.uploadAvatar(JWT, body).enqueue(new Callback<criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.File>() {
                    @Override
                    public void onResponse(Call<criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.File> call, Response<criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.File> response) {
                        if (response.isSuccessful()) {
                            responseView.setText(response.body().toString());
                        } else {
                            responseView.setText(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model.File> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case UPLOAD_IMAGE:

                break;
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    private class RetrieveImage extends AsyncTask<ResponseBody, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(ResponseBody... responses) {
            ResponseBody response = responses[0];
            Bitmap bitmap;
            try {
                InputStream stream = response.byteStream();
                try {
                    bitmap = BitmapFactory.decodeStream(stream);
                } finally {
                    stream.close();
                }
            } catch (Exception e) {
                return null;
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (null == bitmap) {
                Log.d("err", "err");
            } else {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
