package com.doshare.share.domain;

import com.doshare.share.mvp.models.WeatherResultBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by vaitt on 16/8/26.<br/>
 * To: vaitt_joy@163.com
 */
public interface WeatherApiService {
    /**
     * 查询天气
     */
    @GET("apistore/weatherservice/cityname")
    Observable<WeatherResultBean> queryWeather(@Header("apikey") String apikey, @Query("cityname") String cityname);
}
