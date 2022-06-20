package com.qaprosoft.carina.demo;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weatherApi.GetCurrentWeather;
import com.qaprosoft.carina.demo.api.weatherApi.GetWeatherByGeoCoordinates;
import com.qaprosoft.carina.demo.api.weatherApi.GetWeatherById;
import com.qaprosoft.carina.demo.api.weatherApi.GetWeatherByZipCode;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ApiWeather {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "taras")
    public void testGetCurrentWeather() {
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        getCurrentWeather.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCurrentWeather.callAPI();
        getCurrentWeather.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCurrentWeather.validateResponseAgainstSchema("api/get/currentWeather/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "taras")
    public void testGetWeatherById() {
        GetWeatherById getWeatherById = new GetWeatherById();
        getWeatherById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherById.callAPI();
        getWeatherById.validateResponseAgainstSchema("api/get/byId/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "taras")
    public void testGetWeatherByGeoCoordinates() {
        GetWeatherByGeoCoordinates getWeatherByGeoCoordinates = new GetWeatherByGeoCoordinates();
        getWeatherByGeoCoordinates.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByGeoCoordinates.callAPI();
        getWeatherByGeoCoordinates.validateResponseAgainstSchema("api/get/byGeoCoordinates/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "taras")
    public void testGetWeatherByZipCode() {
        GetWeatherByZipCode getWeatherByZipCode = new GetWeatherByZipCode();
        getWeatherByZipCode.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByZipCode.callAPI();
        getWeatherByZipCode.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByZipCode.validateResponseAgainstSchema("api/get/byZipCode/rs.schema");
    }
}
