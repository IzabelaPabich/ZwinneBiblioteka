package pl.zmzp.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zmzp.biblioteka.dto.MenuItem;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;


@RestController
public class MenuController {

    @Autowired
    private BibliotekaService bibliotekaServiceImpl;

    @RequestMapping(method = RequestMethod.GET, value = "/menu")
    private @ResponseBody
    List<MenuItem> getMenuItems() {
        return bibliotekaServiceImpl.getMenuItems();
    }
}
