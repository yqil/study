package com.yql.test.web.controller.tuser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yql.test.common.service.tuser.TUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class TUserControllerTest {

	@Mock
	private TUserService tUserService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(tUserService.saveTUser(null)).thenReturn("ok");
	}

	@Test
	public void testSaveTUser() {
		/*TUserChildrenVO user = new TUserChildrenVO();
		user.setName("测试44");
		String result = tUserService.saveTUser(user);
		LogBackUtil.getLogger().debug("结果：{}", JSON.toJSONString(result));
		Assert.assertEquals("ok", result);*/
	}
}
