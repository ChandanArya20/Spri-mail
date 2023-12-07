package in.ineuron.service;

import javax.mail.MessagingException;

public interface IPurchaseOrder {
	public String purchase(String[] items,Double [] prices,String[] toEmails) throws MessagingException;
	
}
