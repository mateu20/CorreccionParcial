package edu.eci.arsw.exams.moneylaunderingapi.service;
import edu.eci.arsw.exams.moneylaunderingapi.model.LaunderingException;
import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service("lavadoDeActivos")
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {

    private List<SuspectAccount> cs = new CopyOnWriteArrayList<>();

    public MoneyLaunderingServiceStub() {
        cs.add(new SuspectAccount("7", 2));
    }

    @Override
    public void updateAccountStatus(SuspectAccount suspectAccount) throws LaunderingException {

        SuspectAccount n = null;
        for (SuspectAccount cuenta : cs) {
            if (cuenta.getAccountId().equals(suspectAccount.getAccountId())) {
                n = cuenta;
            }
        }
        if (n == null) {
            throw new LaunderingException("Cuenta invalida");
        }
        n.setAmountOfSmallTransactions(suspectAccount.getAmountOfSmallTransactions());
        }

    @Override
    public SuspectAccount getAccountStatus(String accountId) throws LaunderingException {
        for (SuspectAccount suspectAccount : cs) {
            if (suspectAccount.getAccountId().equals(accountId)) {
                return suspectAccount;
            }
        }
        throw new LaunderingException("Cuenta invalida");

    }

    @Override
    public List<SuspectAccount> getSuspectAccounts() {
        return cs;
    }

    @Override
    public void addFraudulentAcounts(SuspectAccount cuenta) throws LaunderingException {

        for (int i = 0; i < cs.size(); i++) {
            if (cuenta.getAmountOfSmallTransactions() == cs.get(i).getAmountOfSmallTransactions()) {
                throw new LaunderingException("Cuenta invalida");
            }
        }
        cs.add(cuenta);

    }


}