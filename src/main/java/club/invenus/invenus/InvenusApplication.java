package club.invenus.invenus;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

//@SpringBootApplication
public class InvenusApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(InvenusApplication.class, args);

		Email from = new Email("test@example.com");
		String subject = "Sending with SendGrid is Fun";
		Email to = new Email("test@example.com");
		Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(System.getenv("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"));
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}

}
