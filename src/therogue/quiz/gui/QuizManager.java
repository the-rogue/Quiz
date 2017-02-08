/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import therogue.quiz.Main;
import therogue.quiz.config.ConfigManager;
import therogue.quiz.constants.Questions;

/**
 * @author The Rogue
 *
 */
public class QuizManager
{
	private WindowManager guiDisplay;
	private int QuestionNumber = 1;
	private int QuestionTimer = 0;
	private ArrayList<String> questions = new ArrayList<String>();
	public final ArrayList<String> correctQuestions = new ArrayList<String>();
	public final ArrayList<String> incorrectQuestions = new ArrayList<String>();
	
	public QuizManager(WindowManager guiDisplay)
	{
		this.guiDisplay = guiDisplay;
	}
	
	public void start()
	{
		setup();
		WindowStates.NEXTQUESION.setState(Main.theWindowManager);
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
		timer.scheduleAtFixedRate(new QuizUpdateTask(), 0, 1000, TimeUnit.MILLISECONDS);
	}
	
	public void resetQuestionTimer(int questionNumber)
	{
		if (questionNumber > 0 && questionNumber <= Questions.QUESTIONLIST.value.size())
		{
			this.QuestionNumber = questionNumber;
		}
		int timing = Questions.QUESTIONTIMERS.value.get(questions.get(QuestionNumber));
		if (timing > 4 || timing == 0)
		{
			QuestionTimer = timing;
		}
		
	}
	
	public WindowManager getGuiDisplay()
	{
		return guiDisplay;
	}
	
	public int getQuestionNumber()
	{
		return QuestionNumber;
	}
	
	public String getCurrentQuestion()
	{
		return getQuestion(QuestionNumber);
	}
	
	public String getQuestion(int number)
	{
		if (number > questions.size() || number - 1 < 0)
		{
			return "";
		}
		else
		{
			return questions.get(number - 1);
		}
	}
	
	public int maxQuestions() {
		return questions.size();
	}
	
	public boolean isCorrectAnswer(String attempt)
	{
		if (Questions.QUESTIONLIST.value.get(getCurrentQuestion()) != null) {
			String answer = Questions.QUESTIONLIST.value.get(getCurrentQuestion()).toLowerCase().trim();
			attempt = attempt.toLowerCase().trim();
			if (attempt.contains(answer)) return true;
			else return false;
		}
		return false;
	}
	
	public void nextQuestion() {
		if (QuestionNumber < questions.size())
		{
			++QuestionNumber;
		}
	}
	public boolean hasNextQuestion() {
		if (QuestionNumber < questions.size())
		{
			return true;
		}
		return false;
	}
	
	public void setup()
	{
		questions.addAll(Questions.QUESTIONLIST.value.keySet());
		questions.remove(ConfigManager.SAMPLEVALUE);
	}
	
	public class QuizUpdateTask implements Runnable
	{
		
		@Override
		public void run()
		{
			if (QuestionTimer > -1)
			{
				--QuestionTimer;
			}
			if (QuestionTimer == 0)
			{
				// WindowStates.TIMEUP.setState(Main.theWindowManager);
			}
			
		}
		
	}
}
