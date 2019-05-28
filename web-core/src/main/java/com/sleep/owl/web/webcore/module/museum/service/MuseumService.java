package com.sleep.owl.web.webcore.module.museum.service;

import com.sleep.owl.web.webcore.base.BaseService;
import com.sleep.owl.web.webcore.module.museum.model.Museum;

import java.util.List;

public interface MuseumService extends BaseService<Museum, String> {

    List<Museum> eachMuseum();

    Museum findRoot();

    void emptyParent(List<Museum> museums);
}
