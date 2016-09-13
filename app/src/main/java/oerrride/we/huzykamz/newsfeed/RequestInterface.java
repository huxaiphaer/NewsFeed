package oerrride.we.huzykamz.newsfeed;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.Call;
        import retrofit2.http.GET;
/**
 * Created by HUZY_KAMZ on 9/13/2016.
 */
public interface RequestInterface {
    @GET("UgandaMedicalAccess/HealthCentreNews/fecth.php")
    Call<JSONResponse> getJSON();

}
