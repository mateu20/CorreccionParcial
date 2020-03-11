package edu.eci.arsw.exams.moneylaunderingapi;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;
@RequestMapping( value = "/fraud-bank-accounts")
@RestController
public class MoneyLaunderingController {
    //TODO
    @Autowired
    MoneyLaunderingService ms;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getSuspectAccounts()
    {
        try {
            return new ResponseEntity<>(ms.getSuspectAccounts(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(MoneyLaunderingController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{accountId}",method = RequestMethod.GET)
    public ResponseEntity<?> getAccountByID(@PathVariable String accountId)
    {
        try {
            return new ResponseEntity<>(ms.getAccountStatus(accountId), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(MoneyLaunderingController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarCuenta(@RequestBody SuspectAccount cuenta) {
        try {
            ms.updateAccountStatus(cuenta);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            Logger.getLogger(MoneyLaunderingController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addSuspectAccounts(@RequestBody SuspectAccount cuenta)
    {
        try {
            ms.addFraudulentAcounts(cuenta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            Logger.getLogger(MoneyLaunderingController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


    


   



}
