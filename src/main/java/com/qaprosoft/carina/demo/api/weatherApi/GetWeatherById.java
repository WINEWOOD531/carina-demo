package com.qaprosoft.carina.demo.api.weatherApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import java.util.Properties;

public class GetWeatherById extends AbstractApiMethodV2 {
    public GetWeatherById() {
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
