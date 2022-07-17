package br.com.anisberto.dsmeta.service;

import br.com.anisberto.dsmeta.entities.Sale;
import br.com.anisberto.dsmeta.repository.SalerRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SalerRepository salerRepository;

    public void sendSms() {
        Twilio.init(twilioSid, twilioKey);
        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
        Message message = Message.creator(to, from, "SDS - ANISBERTO - TESTE").create();
        System.out.println(message.getSid());
    }

    public void sendSms(Integer id) {
        Sale sale = salerRepository.findById(id.longValue()).get();
        Twilio.init(twilioSid, twilioKey);
        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
        Message message = Message.creator(to, from, contruirMensagem(sale)).create();
        System.out.println(message.getSid());
    }

    public String contruirMensagem(Sale sale){
        StringBuffer db = new StringBuffer();
        db.append("O vendedor: ");
        db.append(sale.getSellerName());
        db.append(" e de ID: " + sale.getId());
        db.append("\nTotal Visited: " + sale.getVisited());
        db.append(String.format("\nSomou um total de R$: %.2f" ,sale.getAmount()) +
                ", Foi destaque em: " + sale.getDate());
        return db.toString();
    }
}
