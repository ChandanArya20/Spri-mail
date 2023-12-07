package in.ineuron.service;

import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("service")
public class PurchaseOrderImpl implements IPurchaseOrder {

	@Autowired
	JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	String fromEmail;
	
	@Override
	public String purchase(String[] items, Double[] prices, String[] toEmails) throws MessagingException {
		
		Double amt=0.0;
		for(Double price:prices) {
			amt=amt+price;
		}
		
		String msg = Arrays.toString(items) + "with price :: " + Arrays.toString(prices)
		+ " are purchase with billamout :: " + amt;
		
		String status = sendMail(msg, toEmails);

		return msg + "---> " + status;
	}
	private String sendMail(String msg, String[] toEmails) throws MessagingException {
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("open to get to know");
		helper.setText(msg);
		helper.addAttachment("mypic.jpg", new ClassPathResource("mypic.jpg"));
		sender.send(message);
		
		return "mail-sent"; 
		
	}
	
}
