package com.qaprosoft.carina.demo.api.apiSourceClasses;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PatchUser extends AbstractApiMethodV2 {
    public PatchUser() {
        super("api/myUser/patch/rq.json", "api/myUser/patch/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
