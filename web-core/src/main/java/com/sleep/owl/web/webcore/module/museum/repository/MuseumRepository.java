package com.sleep.owl.web.webcore.module.museum.repository;

import com.sleep.owl.web.webcore.base.BaseRepository;
import com.sleep.owl.web.webcore.module.museum.model.Museum;

public interface MuseumRepository extends BaseRepository<Museum, String> {

    Museum findByRootNode(boolean rootNode);
}
