package com.qaprosoft.carina.demo.api.apiSourceClasses;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;


public class PostUser extends AbstractApiMethodV2 {
    public PostUser() {
        super("api/myUser/post/rq.json", "api/myUser/post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
