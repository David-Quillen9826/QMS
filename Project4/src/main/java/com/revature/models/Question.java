package com.revature.models;

public class Question {
	private String question;
	private String correct;
	private String wrong1;
	private String wrong2;
	private String wrong3;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String question, String correct, String wrong1, String wrong2, String wrong3) {
		super();
		this.question = question;
		this.correct = correct;
		this.wrong1 = wrong1;
		this.wrong2 = wrong2;
		this.wrong3 = wrong3;
	}

	public synchronized String getQuestion() {
		return question;
	}

	public synchronized void setQuestion(String question) {
		this.question = question;
	}

	public synchronized String getCorrect() {
		return correct;
	}

	public synchronized void setCorrect(String correct) {
		this.correct = correct;
	}

	public synchronized String getWrong1() {
		return wrong1;
	}

	public synchronized void setWrong1(String wrong1) {
		this.wrong1 = wrong1;
	}

	public synchronized String getWrong2() {
		return wrong2;
	}

	public synchronized void setWrong2(String wrong2) {
		this.wrong2 = wrong2;
	}

	public synchronized String getWrong3() {
		return wrong3;
	}

	public synchronized void setWrong3(String wrong3) {
		this.wrong3 = wrong3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correct == null) ? 0 : correct.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((wrong1 == null) ? 0 : wrong1.hashCode());
		result = prime * result + ((wrong2 == null) ? 0 : wrong2.hashCode());
		result = prime * result + ((wrong3 == null) ? 0 : wrong3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (correct == null) {
			if (other.correct != null)
				return false;
		} else if (!correct.equals(other.correct))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (wrong1 == null) {
			if (other.wrong1 != null)
				return false;
		} else if (!wrong1.equals(other.wrong1))
			return false;
		if (wrong2 == null) {
			if (other.wrong2 != null)
				return false;
		} else if (!wrong2.equals(other.wrong2))
			return false;
		if (wrong3 == null) {
			if (other.wrong3 != null)
				return false;
		} else if (!wrong3.equals(other.wrong3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + ", correct=" + correct + ", wrong1=" + wrong1 + ", wrong2=" + wrong2
				+ ", wrong3=" + wrong3 + "]";
	}

}
