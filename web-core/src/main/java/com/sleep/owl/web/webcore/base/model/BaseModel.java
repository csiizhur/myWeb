package com.sleep.owl.web.webcore.base.model;

import java.io.Serializable;

public interface BaseModel<ID extends Serializable> extends Serializable {
    ID getId();
}
