package com.acme.mailreader.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.acme.mailreader.model.Mail;
import com.acme.mailreader.service.MailService;

import com.acme.mailreader.common.MailInvalideException;

public class InterpreteurLigneCommande {
	
	private MailService serviceMail;
	
	public InterpreteurLigneCommande() {

		super();
	}
	
	public void nouveauMail(String[] args){

		String sujet = args[1];
		Mail mail = new Mail.Builder(sujet).build();

		try {
			serviceMail.envoyerMail(mail);
		} catch (MailInvalideException e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
		}
	}
}