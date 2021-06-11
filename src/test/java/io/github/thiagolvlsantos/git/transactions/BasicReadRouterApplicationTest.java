package io.github.thiagolvlsantos.git.transactions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import io.github.thiagolvlsantos.git.transactions.config.GittConfig;

@ContextConfiguration(classes = GittConfig.class)
@SpringBootTest
@ComponentScan("io.github.thiagolvlsantos")
@Import(BasicReadRouter.class)
class BasicReadRouterApplicationTest {

	@Test
	void testReaderRouter(@Autowired ApplicationContext ctx) throws Exception {
		BasicReadRouter s = ctx.getBean(BasicReadRouter.class);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		assertThat(s.read("proj1").contains("odd ids")).isTrue();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		assertThat(s.read("proj2").contains("even ids")).isTrue();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
}