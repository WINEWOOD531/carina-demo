package com.qaprosoft.carina.demo.api.apiSourceClasses;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostRegisterUser extends AbstractApiMethodV2 {
    public PostRegisterUser() {
        super("api/myUser/postForRegisterUser/rq.json", "api/myUser/postForRegisterUser/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
