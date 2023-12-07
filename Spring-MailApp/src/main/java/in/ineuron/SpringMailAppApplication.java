package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IPurchaseOrder;
import in.ineuron.service.PurchaseOrderImpl;

@SpringBootApplication
public class SpringMailAppApplication {

	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringMailAppApplication.class, args);
		
		IPurchaseOrder order = context.getBean(IPurchaseOrder.class);
		
		try {
			String msg = order.purchase(new String[] { "Fossil-Chronography", "USPOLO-Tshirt", "LouisPhilippe-Shoes" },
			new Double[] { 12000.0, 5000.0, 6000.0 }, new String[] {"chandank1848@gmail.com", "cktechnic91@gmail.com" } );
		
			System.out.println(msg);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
