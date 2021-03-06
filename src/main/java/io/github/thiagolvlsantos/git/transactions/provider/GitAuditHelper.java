package io.github.thiagolvlsantos.git.transactions.provider;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GitAuditHelper {

	public static IGitAudit audit(ApplicationContext context) {
		IGitAudit audit;
		try {
			audit = context.getBean(IGitAudit.class);
		} catch (NoSuchBeanDefinitionException e) {
			audit = IGitAudit.INSTANCE;
		}
		return audit;
	}
}
