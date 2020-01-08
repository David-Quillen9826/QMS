package com.revature.daos;

import java.util.List;

import com.revature.models.Question;

public interface QuestionDao {
	QuestionDao currentImplementation = new QuestionDaoSQL();

	int save(Question q);

	List<Question> findAll();

	Question findById(int id);
}
