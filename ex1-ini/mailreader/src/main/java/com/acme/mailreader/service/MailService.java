package com.acme.mailreader.service;

import com.acme.mailreader.model.Mail;
import com.acme.mailreader.common.MailInvalideException;
import com.acme.mailreader.common.MailInvalideException.ErreurMail;

public class MailService {
	
	private static final int TAILLE_MAX_S = 20;
	private MailSender sender;
	
	public MailService() {
	}
	
	public void envoyerMail(Mail mail) throws MailInvalideException {
		
		if (mail.getSujet().length() > TAILLE_MAX_S){
			throw new MailInvalideException(ErreurMail.TROP_LONG);
		}
		sender.envoyerMail(mail);

	}
}