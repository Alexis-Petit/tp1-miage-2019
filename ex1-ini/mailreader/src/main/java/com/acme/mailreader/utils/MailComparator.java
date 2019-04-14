package com.acme.mailreader.domain;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {
	
	public static final int LESS_IMPORTANT = 1;
	public static final int EQUALLY_IMPORTANT = 0;
	public static final int MORE_IMPORTANT = -1;

	public int compare(Mail mail1, Mail mail2) {
		
		if (isNull(mail1, mail2)) {
			return EQUALLY_IMPORTANT;
		}
		if (isImportanceDifferent(mail1, mail2)) {
			return orderByImportance(mail1, mail2);
		}
		if (isStatusDifferent(mail1, mail2)) {
			return orderImportanceByStatus(mail1, mail2);
		}
		if (isSujetDifferent(mail1, mail2)) {
			return orderImportanceBySujet(mail1, mail2);
		}
		return sameDate(mail1, mail2);
	}
	
	private int orderImportanceByStatus(Mail mail1, Mail mail2) {

		int comp = mail1.getStatut().ordinal() - mail2.getStatut().ordinal();
		return comp > 0 ? LESS_IMPORTANT : MORE_IMPORTANT;
	}

	private int orderImportanceBySujet(Mail mail1, Mail mail2) {

		return mail2.getSujet().compareTo(mail1.getSujet());
	}

	private boolean isNull(Mail mail1, Mail mail2) {

		return mail1 == null || mail2 == null;
	}

	private int sameDate(Mail mail1, Mail mail2) {

		return mail2.getDate().compareTo(mail1.getDate());
	}

	private boolean isSujetDifferent(Mail mail1, Mail mail2) {

		return mail1.getSujet() != mail2.getSujet();
	}

	private boolean isStatusDifferent(Mail mail1, Mail mail2) {

		return mail1.getStatut() != mail2.getStatut();
	}

	private boolean isImportanceDifferent(Mail mail1, Mail mail2) {

		return mail1.isImportant() != mail2.isImportant();
	}

	private int orderByImportance(Mail mail1, Mail mail2) {

		if (mail1.isImportant() && !mail2.isImportant()) {
			return MORE_IMPORTANT;
		} else {
			return LESS_IMPORTANT;
		}
	}
}