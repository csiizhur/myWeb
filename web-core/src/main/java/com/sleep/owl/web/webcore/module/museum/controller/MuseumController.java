package com.sleep.owl.web.webcore.module.museum.controller;

import com.sleep.owl.web.webcore.base.BaseController;
import com.sleep.owl.web.webcore.module.museum.model.Museum;
import com.sleep.owl.web.webcore.module.museum.model.enums.Type;
import com.sleep.owl.web.webcore.module.museum.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("museum")
public class MuseumController extends BaseController {
    private final MuseumService museumService;
    private static final String MUSEUM_PAGE = "templete :: museum-element";

    @Autowired
    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }


    @GetMapping("page")
    public ModelAndView page() {
        ModelAndView view = new ModelAndView();
        view.setViewName(MUSEUM_PAGE);

        return view;
    }

    @GetMapping("findRoot")
    public Museum findRoot() {
        Museum root = museumService.findRoot();
        Museum museum = new Museum();
        museum.setName("测试菜单");
        museum.setParent(root);
        museum.setType(Type.MUSEUM);
        museum.setRootNode(false);
        museumService.save(museum);

        museumService.emptyParent(root.getChildren());
        return root;
    }

}
