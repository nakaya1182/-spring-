package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControlerTest {
	private MockMvc mockMvc;
	@Autowired
	UserControler userControler;
	@Before
	  public void setup() {
		//MockitoAnnotations.initMocks(this);
	    mockMvc = MockMvcBuilders
	    		.standaloneSetup(userControler)
	    		.build();
	  }

	@Test
	public void testSetId() throws Exception {
		mockMvc.perform(get("setId"))
		.andExpect(status().isFound())
		.andExpect(view().name("ListDisplay"));
	}

	@Test
	public void testSetAdd() throws Exception {
		mockMvc.perform(get("setAdd"))
		.andExpect(status().isFound())
		.andExpect(view().name("ListDisplay"));
	}

	@Test
	public void testSetTel() throws Exception {
		mockMvc.perform(get("setTel"))
		.andExpect(status().isFound())
		.andExpect(view().name("ListDisplay"));
	}

	@Test
	public void testSetSearch() throws Exception {
		mockMvc.perform(get("/setSearch"))
		.andExpect(status().isFound())
		.andExpect(view().name("ListDisplay"));
	}

	@Test
	public void testSignUp() throws Exception {
		mockMvc.perform(get("/signUp"))
		.andExpect(status().isOk())
		.andExpect(view().name("SignUp"));
	}

	@Test
	public void testSignUpConfirmation() throws Exception {
		mockMvc.perform(get("/signUpConfirmation"))
		.andExpect(status().isFound())
		.andExpect(view().name("SignUpConfirmation"));
	}

	@Test
	public void testInsert() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSignUpReturn() throws Exception {
		mockMvc.perform(post("/signUpReturn"))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:signUp"));
	}

	@Test
	public void testEdit() throws Exception {
		mockMvc.perform(post("/edit"))
		.andExpect(status().isFound())
		.andExpect(view().name("Edit"));
	}

	@Test
	public void testEditConfirmation() throws Exception {
		mockMvc.perform(post("/editConfirmation"))
		.andExpect(status().isFound())
		.andExpect(view().name("EditConfirmation"));
	}

	@Test
	public void testDelete() {
		fail("まだ実装されていません");
	}

	@Test
	public void testBack() throws Exception {
		mockMvc.perform(post("/back"))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:setId"));
	}

}
