package edu.eci.arsw.exams.moneylaunderingapi.model;

public class SuspectAccount {
    public String accountId;
    public int amountOfSmallTransactions;
	public SuspectAccount(String accountId,int amountOfSmallTransactions) {
		// TODO Auto-generated constructor stub
	     this.accountId = accountId;
	     this.amountOfSmallTransactions = amountOfSmallTransactions;
	}
	public Object getAmountOfSmallTransactions() {
		// TODO Auto-generated method stub
		return amountOfSmallTransactions;
	}
	public void setAmountOfSmallTransactions(Object amountOfSmallTransactions2) {
		// TODO Auto-generated method stub
		this.amountOfSmallTransactions = amountOfSmallTransactions;
		
	}
	public String getAccountId() {
		// TODO Auto-generated method stub
		return accountId;
		}
	@Override
    public String toString() {
        return "SuspectAccount{" +
                "accountId='" + accountId + '\'' +
                ", amountOfSmallTransactions=" + amountOfSmallTransactions +
                '}';
    }
	public void setAccountId(String accountId) {
			// TODO Auto-generated method stub
		this.accountId = accountId;
	}
	
}
