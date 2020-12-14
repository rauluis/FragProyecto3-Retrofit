package mx.com.softwell.fragmentos.api.apiservices;

import com.google.gson.JsonObject;

import java.util.List;

import mx.com.softwell.fragmentos.model.Juego;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JuegoService {
    @GET("juegos/top")
    Call<JsonObject> getTop();
    @GET("juegos/rank")
    Call<JsonObject>  getRank();
    @GET("juegos/oldSchool")
    Call<JsonObject> getOldSchool();
    @GET("juegos/freetoplay")
    Call<JsonObject>  getFreToPlay();


}
