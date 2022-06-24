package com.qaprosoft.carina.demo.api.apiSourceClasses;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetBirdFactMethod extends AbstractApiMethodV2 {

    public GetBirdFactMethod() {
    super(null, "api/get/birdFacts/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
