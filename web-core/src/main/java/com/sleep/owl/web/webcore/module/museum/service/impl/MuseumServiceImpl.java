package com.sleep.owl.web.webcore.module.museum.service.impl;

import com.sleep.owl.web.webcore.base.BaseRepository;
import com.sleep.owl.web.webcore.base.impl.BaseServiceImpl;
import com.sleep.owl.web.webcore.module.museum.model.Museum;
import com.sleep.owl.web.webcore.module.museum.repository.MuseumRepository;
import com.sleep.owl.web.webcore.module.museum.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MuseumServiceImpl extends BaseServiceImpl<Museum, String> implements MuseumService {


    private final MuseumRepository museumRepository;

    @Autowired
    public MuseumServiceImpl(MuseumRepository museumRepository) {
        this.museumRepository = museumRepository;
    }


    @Override
    public MuseumRepository getDAO() {
        return museumRepository;
    }

    @Override
    public List<Museum> findAll() {
        List<Museum> museums = super.findAll();
        museums.forEach(museum -> museum.setChildren(null));
        return museums;
    }

    @Override
    public List<Museum> eachMuseum() {
        List<Museum> museums = getDAO().findAll();
        emptyParent(museums);
        return museums;
    }

    @Override
    public Museum findRoot() {
        return getDAO().findByRootNode(true);

    }

    @Override
    public void emptyParent(List<Museum> museums) {
        museums.forEach(museum -> {
            museum.setParent(null);
            if (Objects.isNull(museum.getChildren()) || museum.getChildren().isEmpty()) {
                museum.setChildren(null);
            } else {
                emptyParent(museum.getChildren());
            }
        });
    }
}
