package com.qaprosoft.carina.demo.api.apiSourceClasses;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostLoginUser extends AbstractApiMethodV2 {
    public PostLoginUser() {
        super("api/myUser/postForLoginUser/rq.json", "api/myUser/postForLoginUser/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
