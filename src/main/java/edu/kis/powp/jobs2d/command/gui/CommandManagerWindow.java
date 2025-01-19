package edu.kis.powp.jobs2d.command.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.*;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.parser.CommandParserFactory;
import edu.kis.powp.jobs2d.command.parser.CommandParserStrategy;
import edu.kis.powp.jobs2d.command.parser.jackson.JacksonParserFactory;
import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindow extends JFrame implements WindowComponent {

	private DriverCommandManager commandManager;

	private JTextArea currentCommandField;
	private JTextArea userInputField;
	private JTextField newCommandNameField;

	private String observerListString;
	private JTextArea observerListField;

	private static final long serialVersionUID = 9204679248304669948L;

	public CommandManagerWindow(DriverCommandManager commandManager, CommandParserFactory parserFactory) {
		this.setTitle("Command Manager");
		this.setSize(400, 400);
		Container content = this.getContentPane();
		content.setLayout(new GridBagLayout());

		this.commandManager = commandManager;

		GridBagConstraints c = new GridBagConstraints();

		observerListField = new JTextArea("");
		observerListField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 0;
		content.add(observerListField, c);
		updateObserverListField();

		currentCommandField = new JTextArea("");
		currentCommandField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 0;
		content.add(currentCommandField, c);
		updateCurrentCommandField();

		JLabel newCommandNameLabel = new JLabel("New Command name:");
		newCommandNameField = new JTextField();

		JPanel namePanel = new JPanel(new GridBagLayout());
		GridBagConstraints namePanelConstraints = new GridBagConstraints();
		namePanelConstraints.fill = GridBagConstraints.BOTH;
		namePanelConstraints.weightx = 0.5;
		namePanelConstraints.gridx = 0;
		namePanelConstraints.gridy = 0;
		namePanel.add(newCommandNameLabel, namePanelConstraints);

		namePanelConstraints.gridx = 1;
		namePanel.add(newCommandNameField, namePanelConstraints);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 0;
		content.add(namePanel, c);

		userInputField = new JTextArea();
		userInputField.setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 1)
		);
		userInputField.setMinimumSize(new Dimension(200, 200));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(userInputField, c);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints panelConstraints = new GridBagConstraints();
		panelConstraints.fill = GridBagConstraints.BOTH;
		panelConstraints.weightx = 0.5;
		panelConstraints.gridx = 0;
		panelConstraints.gridy = 0;

		JButton btnSetCommand = new JButton("Set command");
		panel.add(btnSetCommand, panelConstraints);

		String[] availableCommands = parserFactory.getAvailableParsers().toArray(new String[0]);
		JComboBox<String> selectType = new JComboBox<>(availableCommands);
		panelConstraints.gridx = 1;
		panel.add(selectType, panelConstraints);

		btnSetCommand.addActionListener((ActionEvent e) -> {
			String chosenCommand = (String) selectType.getSelectedItem();
			String newCommandName = newCommandNameField.getText();
			try {
				List<DriverCommand>  parsedCommand = parserFactory.getParser(chosenCommand).parse(userInputField.getText());
				commandManager.setCurrentCommand(parsedCommand, newCommandName);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex);
			}
			updateCurrentCommandField();
		});

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 0;
		content.add(panel, c);

		JButton btnClearCommand = new JButton("Clear command");
		btnClearCommand.addActionListener((ActionEvent e) -> this.clearCommand());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 0;
		content.add(btnClearCommand, c);

		JButton btnClearObservers = new JButton("Delete observers");
		btnClearObservers.addActionListener((ActionEvent e) -> this.deleteObservers());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 0;
		content.add(btnClearObservers, c);
	}

	private void clearCommand() {
		commandManager.clearCurrentCommand();
		updateCurrentCommandField();
	}

	public void updateCurrentCommandField() {
		currentCommandField.setText(commandManager.getCurrentCommandString());
	}

	public void deleteObservers() {
		commandManager.getChangePublisher().clearObservers();
		this.updateObserverListField();
	}

	private void updateObserverListField() {
		observerListString = "";
		List<Subscriber> commandChangeSubscribers = commandManager.getChangePublisher().getSubscribers();
		for (Subscriber observer : commandChangeSubscribers) {
			observerListString += observer.toString() + System.lineSeparator();
		}
		if (commandChangeSubscribers.isEmpty())
			observerListString = "No observers loaded";

		observerListField.setText(observerListString);
	}

	@Override
	public void HideIfVisibleAndShowIfHidden() {
		updateObserverListField();
		this.setVisible(!this.isVisible());
	}
}
