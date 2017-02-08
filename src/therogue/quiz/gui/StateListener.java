/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author The Rogue
 *
 */
public class StateListener implements ActionListener
{
	private final WindowActions state;
	private final WindowManager manager;

	public StateListener(WindowManager manager, WindowActions state)
	{
		this.state = state;
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		state.onAction(manager);
	}
	
}
