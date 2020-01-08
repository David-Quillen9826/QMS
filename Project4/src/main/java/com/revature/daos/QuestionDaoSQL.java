package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Question;
import com.revature.util.ConnectionUtil;

public class QuestionDaoSQL implements QuestionDao {

	private Question extract(ResultSet rs) throws SQLException {
		return new Question(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	}

	@Override
	public int save(Question q) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO question (question_id, question_desc, correct, answer_1, answer_2, answer_3) "
					+ " VALUES (question_seq.nextval ,?,?,?,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, q.getQuestion());
			ps.setString(2, q.getCorrect());
			ps.setString(3, q.getWrong1());
			ps.setString(4, q.getWrong2());
			ps.setString(5, q.getWrong3());

			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Question> findAll() {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM question";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<Question> questions = new ArrayList<Question>();
			while (rs.next()) {
				questions.add(extract(rs));
			}

			return questions;

			// TODO Auto-generated catch block
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Question findById(int id) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM question" + " WHERE question_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extract(rs);
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
