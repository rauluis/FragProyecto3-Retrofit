package mx.com.softwell.fragmentos.core;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.irozon.alertview.AlertStyle;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import mx.com.softwell.fragmentos.api.API;
import mx.com.softwell.fragmentos.api.apiservices.JuegoService;
import mx.com.softwell.fragmentos.gui.FreeToPlay;
import mx.com.softwell.fragmentos.gui.MainActivity;
import mx.com.softwell.fragmentos.gui.OldSchool;
import mx.com.softwell.fragmentos.gui.Rank;
import mx.com.softwell.fragmentos.gui.TopJuegos;
import mx.com.softwell.fragmentos.model.Juego;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuegoController {
    //Se encarga de hacer la llamada a esa ruta. El rempintado del recicler

    private static JuegoController instance=null;
    private MiscController miscController =MiscController.Instance();
    private boolean status = false;
    private String message ="";
    private String data="";
    private List<Juego> juegos;
    Type juegosType = new TypeToken<List<Juego>>(){}.getType();//sirve para mapear
    private static String TAG= "JuegoController";

    private JuegoController(){}

    public static JuegoController Instance(){//singleton
        if(instance==null)
                instance = new JuegoController();
        return instance;
    }

    public void GetTop(){
        API.getApi().create(JuegoService.class).getTop().enqueue(new Callback<JsonObject>() {//enqueue encolar
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());//el body es el to do el texto de la pag.
                    status = jsonObject.getBoolean("status");//toma un valor y lo pega en status
                    message = jsonObject.getString("message");
                    if (status) {
                        data = jsonObject.getJSONArray("data").toString();//Se tomo to do el data
                        juegos = new Gson().fromJson(data, juegosType);//con esto transformamos el arreglo data en  en una lista de tipo juego.
                        //miscrontroller.CloseWait();
                        Log.e(TAG, data);
                        Log.e(TAG, juegos.toString());
                        //mandar informacion al recycler
                        ((TopJuegos) MainActivity.GLOBALS.get("topJuegosFragment")).actualizar(juegos);
                    } else {
                        miscController.CloseWait();
                        Log.e(TAG, message);
                    }
                } catch (JSONException e){
                        miscController.CloseWait();
                        Log.e(TAG, e.getMessage());
                }
            }
                @Override
                public void onFailure (Call < JsonObject > call, Throwable t){

                    Log.e(TAG, t.getMessage());
                }
            });
        }

    public void GetRank(){
        API.getApi().create(JuegoService.class).getRank().enqueue(new Callback<JsonObject>() {//enqueue encolar
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());//el body es el to do el texto de la pag.
                    status = jsonObject.getBoolean("status");//toma un valor y lo pega en status
                    message = jsonObject.getString("message");
                    if (status) {
                        data = jsonObject.getJSONArray("data").toString();//Se tomo to do el data
                        juegos = new Gson().fromJson(data, juegosType);//con esto transformamos el arreglo data en  en una lista de tipo juego.
                        //miscrontroller.CloseWait();
                        Log.e(TAG, data);
                        Log.e(TAG, juegos.toString());
                        //mandar informacion al recycler
                        ((Rank) MainActivity.GLOBALS.get("rankFragment")).actualizar(juegos);
                    } else {
                        miscController.CloseWait();
                        Log.e(TAG, message);
                    }
                } catch (JSONException e){
                    miscController.CloseWait();
                    Log.e(TAG, e.getMessage());
                }
            }
            @Override
            public void onFailure (Call < JsonObject > call, Throwable t){

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void GetOldShool(){
        API.getApi().create(JuegoService.class).getOldSchool().enqueue(new Callback<JsonObject>() {//enqueue encolar
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());//el body es el to do el texto de la pag.
                    status = jsonObject.getBoolean("status");//toma un valor y lo pega en status
                    message = jsonObject.getString("message");
                    if (status) {
                        data = jsonObject.getJSONArray("data").toString();//Se tomo to do el data
                        juegos = new Gson().fromJson(data, juegosType);//con esto transformamos el arreglo data en  en una lista de tipo juego.
                        //miscrontroller.CloseWait();
                        Log.e(TAG, data);
                        Log.e(TAG, juegos.toString());
                        //mandar informacion al recycler
                        ((OldSchool) MainActivity.GLOBALS.get("oldSchoolFragment")).actualizar(juegos);
                    } else {
                        miscController.CloseWait();
                        Log.e(TAG, message);
                    }
                } catch (JSONException e){
                    miscController.CloseWait();
                    Log.e(TAG, e.getMessage());
                }
            }
            @Override
            public void onFailure (Call < JsonObject > call, Throwable t){

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void GetFreeToPlay(){
        API.getApi().create(JuegoService.class).getFreToPlay().enqueue(new Callback<JsonObject>() {//enqueue encolar
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());//el body es el to do el texto de la pag.
                    status = jsonObject.getBoolean("status");//toma un valor y lo pega en status
                    message = jsonObject.getString("message");
                    if (status) {
                        data = jsonObject.getJSONArray("data").toString();//Se tomo to do el data
                        juegos = new Gson().fromJson(data, juegosType);//con esto transformamos el arreglo data en  en una lista de tipo juego.
                        //miscrontroller.CloseWait();
                        Log.e(TAG, data);
                        Log.e(TAG, juegos.toString());
                        //mandar informacion al recycler
                        ((FreeToPlay) MainActivity.GLOBALS.get("freeToPlayFragment")).actualizar(juegos);
                    } else {
                        miscController.CloseWait();
                        Log.e(TAG, message);
                    }
                } catch (JSONException e){
                    miscController.CloseWait();
                    Log.e(TAG, e.getMessage());
                }
            }
            @Override
            public void onFailure (Call < JsonObject > call, Throwable t){

                Log.e(TAG, t.getMessage());
            }
        });
    }

  /*  public void GetAll(){
        API.getApi().create(JuegoService.class).getAll().enqueue(new Callback<JsonObject>() {//enqueue encolar
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());//el body es el to do el texto de la pag.
                    status = jsonObject.getBoolean("status");//toma un valor y lo pega en status
                    message = jsonObject.getString("message");
                    if (status) {
                        data = jsonObject.getJSONArray("data").toString();//Se tomo to do el data
                        juegos = new Gson().fromJson(data, juegosType);//con esto transformamos el arreglo data en  en una lista de tipo juego.
                        //miscrontroller.CloseWait();
                        Log.e(TAG, data);
                        Log.e(TAG, juegos.toString());
                        //mandar informacion al recycler
                        ((TopJuegos) MainActivity.GLOBALS.get("topJuegosFragment")).actualizar(juegos);
                    } else {
                        miscController.CloseWait();
                        Log.e(TAG, message);
                    }
                } catch (JSONException e){
                    miscController.CloseWait();
                    Log.e(TAG, e.getMessage());
                }
            }
            @Override
            public void onFailure (Call < JsonObject > call, Throwable t){

                Log.e(TAG, t.getMessage());
            }
        });
    }

*/
}
