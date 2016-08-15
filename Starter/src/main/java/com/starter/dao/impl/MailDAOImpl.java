package com.starter.dao.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.starter.dao.MailDAO;

public class MailDAOImpl implements MailDAO {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void send(String to, String from, String subject, String text) throws MessagingException {
		MimeMessage mail = this.javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text);

		this.javaMailSender.send(mail);
	}

}
