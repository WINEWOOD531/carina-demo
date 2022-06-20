package com.qaprosoft.carina.demo.api.weatherApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetCurrentWeather extends AbstractApiMethodV2 {
    public GetCurrentWeather() {
        super(null, "api/get/currentWeather/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
