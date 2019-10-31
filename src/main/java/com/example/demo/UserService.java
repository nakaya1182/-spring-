package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {
	@Autowired
	UserRepository userrepository;
	public Page<User> getList(Pageable pageable) {
		Page<User> page;
			page = userrepository.findAll(pageable);
			//System.out.println(pageable);
		return page;
    }

	public Page<User> getSearch(Pageable pageable,String searchWord) {
		Page<User> page;
		if("".equals(searchWord)) {
			page = userrepository.findAll(pageable);

		}else {
			//System.out.println(searchWord);
			page = userrepository.findByAddContaining(pageable,searchWord);
			System.out.println(page);
		}
		System.out.println(page);
		return page;
    }

	//新規登録　保存
	public void insert(User user) {
		System.out.println(user);
		userrepository.save(user);
		System.out.println("page");

	}
	//編集　取得
	public User update(Integer id) {
	    return userrepository.findById(id);
	}
}

