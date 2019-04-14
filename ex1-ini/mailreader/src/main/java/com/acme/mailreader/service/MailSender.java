package com.acme.mailreader.service;

import com.acme.mailreader.model.Mail;

public interface MailSender {
	
	void envoyerMail(Mail mail);

}