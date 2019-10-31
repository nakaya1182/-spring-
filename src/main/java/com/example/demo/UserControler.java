package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserControler {
	@Autowired
	UserService userservice;
	//一覧表示
	@GetMapping("setId")
	public String setId(Model model, @PageableDefault(page = 0, size = 10,sort= {"id"})Pageable pageable,String searchWord) {
		Page<User> page=userservice.getList(pageable);
		model.addAttribute("page", page);

	    return "ListDisplay";
	}

	//ソート
	@GetMapping("setAdd")
	public String setAdd(Model model, @PageableDefault(page = 0, size = 10,sort= {"add"})Pageable pageable,String searchWord) {
		Page<User> page=userservice.getList(pageable);
		model.addAttribute("page", page);

	    return "ListDisplay";
	}
	//ソート
		@GetMapping("setTel")
		public String setTel(Model model, @PageableDefault(page = 0, size = 10,sort= {"tel"})Pageable pageable,String searchWord) {
			Page<User> page=userservice.getList(pageable);
			model.addAttribute("page", page);

		    return "ListDisplay";
		}

	//検索
	@GetMapping("/setSearch")
	public String setSearch(Model model,@PageableDefault( page = 0,size =10 ,sort= {"id"})Pageable pageable,String searchWord) {
		//System.out.println(searchWord);
		Page<User> page=userservice.getSearch(pageable, searchWord);
		model.addAttribute("page", page);
		model.addAttribute("searchWord",searchWord);
	    return "ListDisplay";
	}

	//新規登録画面を表示
	@GetMapping("/signUp")
	public String signUp(Model model) {
		return "SignUp";
	}
	//新規登録からの入力受け取り、確認へ送る
	@PostMapping("/signUpConfirmation")
	public String signUpConfirmation(@ModelAttribute @Validated User user,Model model) {
		return "SignUpConfirmation";
	}
	//確認からの値をインサート
	@PostMapping("/Insert")
	public String Insert(Model model,@Validated User user) {
		userservice.insert(user);
		return "redirect:setId";
	}
	//新規確認から一つ戻る
	@RequestMapping("/signUpReturn")
	public String signUpReturn(Model model) {
		return "redirect:signUp";
	}
	//編集画面に移動
	 @GetMapping("/edit/{id}")
	  public String edit(@PathVariable Integer id, Model model) {
	    User user = userservice.update(id);
	    model.addAttribute("user", user);
	    return "Edit";
	  }
	 //編集確認
	 @PostMapping("/editConfirmation")
		public String editConfirmation(@ModelAttribute User user,Model model) {
			return "EditConfirmation";
		}
	//削除画面に移動
	 @GetMapping("/delete/{id}")
	  public String delete(@PathVariable Integer id, Model model) {
	    User user = userservice.update(id);
	    model.addAttribute("user", user);
	 return "Delete";
	}

	//一覧に戻るボタン
	@RequestMapping("/back")
	public String back(Model model) {
		return "redirect:setId";
	}
}
