package github.com.simaomenezes.roleapp;

import github.com.simaomenezes.roleapp.infrastructure.config.AppRoleAuthConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppRoleAuthConfig.class)
@SpringBootTest
class AppRoleAuthApplicationTests {

	@Test
	void contextLoads() {
	}

}
