package com.qaprosoft.carina.demo.api.weatherApi;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByGeoCoordinates extends AbstractApiMethodV2 {
    public GetWeatherByGeoCoordinates() {
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
