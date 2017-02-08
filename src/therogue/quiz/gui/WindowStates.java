/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import therogue.quiz.constants.General;
import therogue.quiz.util.GeneralUtils;



/**
 * @author The Rogue
 *
 */
public enum WindowStates
{	
	TIMEUP{
		@Override
		public void setState(WindowManager windowManager) {
			super.setState(windowManager);
			windowManager.answerbox.setVisible(false);
			windowManager.label2.setVisible(false);
			windowManager.label1.setVisible(false);
			windowManager.vlholder.setVisible(false);
			windowManager.button1.setVisible(false);
		}
	},
	MAINMENU{
		@Override
		public void setState(WindowManager windowManager) {
			super.setState(windowManager);
			windowManager.answerbox.setVisible(false);
			windowManager.label2.setVisible(false);
			windowManager.label1.setVisible(false);
			windowManager.vlholder.setVisible(false);
			windowManager.button1.setVisible(false);
		}
	},
	FINISHED{
		@Override
		public void setState(WindowManager windowManager) {
			super.setState(windowManager);
			windowManager.answerbox.setVisible(false);
			windowManager.label2.setVisible(false);
			windowManager.label1.setVisible(false);
			windowManager.vlholder.setVisible(false);
			windowManager.vl2holder.setVisible(false);
			windowManager.button1.setVisible(false);
			windowManager.label1.setFont(WindowManager.getFontFancy());
			windowManager.label1.setText("You got " + windowManager.getAppRunner().correctQuestions.size() + "/" + windowManager.getAppRunner().maxQuestions() + " Correct");
			windowManager.label1.setBounds(50, 20, 900, 45);
			windowManager.label1.setHorizontalAlignment(SwingConstants.CENTER);
			windowManager.label1.setForeground(Color.BLUE.brighter());
			windowManager.label1.setVisible(true);
			windowManager.variableLabel.setFont(WindowManager.getFontFancy().deriveFont(Font.PLAIN, 28));
			windowManager.variableLabel.setText("Questions you got Right:\n" + GeneralUtils.getListText(windowManager.getAppRunner().correctQuestions));
			windowManager.vlholder.setBounds(50, 85, 400, 320);
			windowManager.vlholder.setBorder(BorderFactory.createLineBorder(Color.black));
			windowManager.variableLabel.setBounds(0, 0, 400, 320);
			windowManager.variableLabel.setVisible(true);
			windowManager.vlholder.setVisible(true);
			windowManager.variableLabel2.setFont(WindowManager.getFontFancy().deriveFont(Font.PLAIN, 28));
			windowManager.variableLabel2.setText("Questions you got Wrong:\n" + GeneralUtils.getListText(windowManager.getAppRunner().incorrectQuestions));
			windowManager.vl2holder.setBounds(550, 85, 400, 320);
			windowManager.vl2holder.setBorder(BorderFactory.createLineBorder(Color.black));
			windowManager.variableLabel2.setBounds(0, 0, 400, 320);
			windowManager.variableLabel2.setVisible(true);
			windowManager.vl2holder.setVisible(true);
			windowManager.button1.setText("Exit");
			windowManager.button1.setBackground(new Color(0, 89, 255));
			windowManager.button1.setBackground2(new Color(0, 190, 255));
			windowManager.button1.addActionListener(new StateListener(windowManager, WindowActions.EXIT));
			windowManager.button1.setVisible(true);
		}
	},
	NEXTQUESION{
		@Override
		public void setState(WindowManager windowManager) {
			super.setState(windowManager);
			windowManager.answerbox.setVisible(false);
			windowManager.label2.setVisible(false);
			windowManager.label1.setVisible(false);
			windowManager.vlholder.setVisible(false);
			windowManager.vl2holder.setVisible(false);
			windowManager.button1.setVisible(false);
			windowManager.answerbox.setBounds(197, 250, 753, 45);
			windowManager.answerbox.setVisible(true);
			windowManager.label2.setBounds(50, 250, 147, 45);
			windowManager.label2.setFont(WindowManager.getFontFancy());
			windowManager.label2.setText("Answer: ");
			windowManager.label2.setForeground(Color.BLUE.brighter());
			windowManager.label2.setVisible(true);
			windowManager.label1.setFont(WindowManager.getFontFancy());
			windowManager.label1.setText("Question " + windowManager.getAppRunner().getQuestionNumber() + ":");
			windowManager.label1.setBounds(50, 50, 210, 45);
			windowManager.label1.setForeground(Color.BLUE.brighter());
			windowManager.label1.setVisible(true);
			windowManager.variableLabel.setFont(WindowManager.getFontFancy());
			windowManager.variableLabel.setText(windowManager.getAppRunner().getCurrentQuestion());
			windowManager.vlholder.setBounds(260, 40, 690, 180);
			windowManager.vlholder.setBorder(null);
			windowManager.vlholder.getViewport().setBorder(null);
			windowManager.variableLabel.setBounds(0, 0, 690, 180);
			windowManager.variableLabel.setVisible(true);
			windowManager.button1.setText("Submit");
			windowManager.button1.setBackground(Color.GREEN.darker());
			windowManager.button1.setBackground2(General.BACKGROUND_COLOR);
			windowManager.button1.addActionListener(new StateListener(windowManager, WindowActions.ANSWER));
			windowManager.answerbox.setVisible(true);
			windowManager.label2.setVisible(true);
			windowManager.label1.setVisible(true);
			windowManager.vlholder.setVisible(true);
			windowManager.button1.setVisible(true);
		}
	},
	CORRECT{
		@Override
		public void setState(WindowManager windowManager) {
			super.setState(windowManager);
			windowManager.answerbox.setVisible(false);
			windowManager.label2.setVisible(false);
			windowManager.label1.setVisible(false);
			windowManager.vlholder.setVisible(false);
			windowManager.vl2holder.setVisible(false);
			windowManager.button1.setVisible(false);
			windowManager.label1.setFont(WindowManager.getFontFancy().deriveFont(Font.BOLD, 72));
			windowManager.label1.setText("CORRECT!!");
			windowManager.label1.setBounds(100, 50, 800, 300);
			windowManager.label1.setHorizontalAlignment(SwingConstants.CENTER);
			windowManager.label1.setForeground(Color.GREEN);
			windowManager.label1.setVisible(true);
			windowManager.button1.setText("Next Question");
			windowManager.button1.setBackground(new Color(0, 89, 255));
			windowManager.button1.setBackground2(new Color(0, 190, 255));
			windowManager.button1.addActionListener(new StateListener(windowManager, WindowActions.NEXTQ));
			windowManager.button1.setVisible(true);
		}
	},
	INCORRECT{
		@Override
		public void setState(WindowManager windowManager) {
			super.setState(windowManager);
			windowManager.answerbox.setVisible(false);
			windowManager.label2.setVisible(false);
			windowManager.label1.setVisible(false);
			windowManager.vlholder.setVisible(false);
			windowManager.vl2holder.setVisible(false);
			windowManager.button1.setVisible(false);
			windowManager.label1.setFont(WindowManager.getFontFancy().deriveFont(Font.BOLD, 72));
			windowManager.label1.setText("INCORRECT :(");
			windowManager.label1.setBounds(100, 50, 800, 300);
			windowManager.label1.setHorizontalAlignment(SwingConstants.CENTER);
			windowManager.label1.setForeground(Color.RED);
			windowManager.label1.setVisible(true);
			windowManager.button1.setText("Next Question");
			windowManager.button1.setBackground(new Color(0, 89, 255));
			windowManager.button1.setBackground2(new Color(0, 190, 255));
			windowManager.button1.addActionListener(new StateListener(windowManager, WindowActions.NEXTQ));
			windowManager.button1.setVisible(true);
		}
	};
	
	public void setState(WindowManager windowManager) {
		removeAllActionLiteners(windowManager.button1);
	}
	
	private static void removeAllActionLiteners(JButton button) {
		for(ActionListener act : button.getActionListeners()) {
			button.removeActionListener(act);
		}
	}

}
