package fr.ecoleNum.VehiculeRental.controller;

import fr.ecoleNum.VehiculeRental.service.ClientService;
import fr.ecoleNum.VehiculeRental.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private VehiculeService vehiculeService;
}
