package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.LaunderingException;
import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import java.util.List;

public interface MoneyLaunderingService {
    void updateAccountStatus(SuspectAccount suspectAccount) throws LaunderingException;
    SuspectAccount getAccountStatus(String accountId) throws LaunderingException;
    List<SuspectAccount> getSuspectAccounts() throws LaunderingException;
	void addFraudulentAcounts(SuspectAccount cuenta) throws LaunderingException;
}
