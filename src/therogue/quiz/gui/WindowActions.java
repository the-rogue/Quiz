/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

/**
 * @author The Rogue
 *
 */
public enum WindowActions
{
	ANSWER {
		@Override
		public void onAction(WindowManager manager)
		{
			if (manager.getAppRunner().isCorrectAnswer(manager.answerbox.getText()))
			{
				manager.getAppRunner().correctQuestions.add(manager.getAppRunner().getCurrentQuestion());
				WindowStates.CORRECT.setState(manager);
			}
			else
			{
				manager.getAppRunner().incorrectQuestions.add(manager.getAppRunner().getCurrentQuestion());
				WindowStates.INCORRECT.setState(manager);
			}
		}
	},
	NEXTQ {
		@Override
		public void onAction(WindowManager manager)
		{
			if (manager.getAppRunner().hasNextQuestion()){
				manager.getAppRunner().nextQuestion();
				WindowStates.NEXTQUESION.setState(manager);
			} else {
				WindowStates.FINISHED.setState(manager);
			}
			
		}
	},
	EXIT {
		@Override
		public void onAction(WindowManager manager)
		{
			System.exit(0);
		}
	};
	
	public void onAction(WindowManager manager)
	{
		
	}
}
