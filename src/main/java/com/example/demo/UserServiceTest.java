package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@MockBean
	private UserRepository userrepository;
	private Pageable pageable;
	@InjectMocks
    private UserService userService;
	@Before
	public void setup() {
		//User user = new User();
		//when(userrepository.findAll()).thenReturn(Optional.of(user));

	    MockitoAnnotations.initMocks(this);
	    Page<User> companies = Mockito.mock(Page.class);
	    String searchWord="東京";
	    Mockito.when(userrepository.findByAddContaining(pageable, searchWord)).thenReturn(companies);

	}

	@Test
	public void testgetList() {
		Page<User> page;
		page = userrepository.findAll(pageable);
		System.out.println(page);
		assertNotNull(page);
	}

	@Test
	public void testgetSearch() {
		Page<User> page;
		String searchWord="東京";
		if("".equals(searchWord)) {
			page = userrepository.findAll(pageable);
		}else {
			page = userrepository.findByAddContaining(pageable,searchWord);
		}
		System.out.println("page");
		System.out.println(page);
		assertNotNull(page);
	}

	@Test
	public void testupdate() {
		Integer id =1;
		User test;
		test = userrepository.findById(id);
		System.out.println(test);
		assertNotNull(test);
	}
}