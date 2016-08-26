package com.starter.service.impl;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.starter.service.MailService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailServiceImpl implements MailService {

	private final String	TEMPLATE_PATH	= "/templates/email";

	@Autowired
	private JavaMailSender	javaMailSender;

	@Autowired
	Configuration			configuration;

	@Override
	public void send(String to, String from, String subject, String text) throws MessagingException {
		MimeMessage mail = this.javaMailSender.createMimeMessage();
		mail.setContent(text, "text/html");

		MimeMessageHelper helper = new MimeMessageHelper(mail, false, "utf-8");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);

		this.javaMailSender.send(mail);
	}

	@Override
	public void send(String to, String from, String subject, String file, Map<String, String> data) {

		this.configuration.setClassForTemplateLoading(this.getClass(), this.TEMPLATE_PATH);

		try {

			Template template = this.configuration.getTemplate(file);
			String readyParsedTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
			this.send(to, from, subject, readyParsedTemplate);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

}
