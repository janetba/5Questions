package stem.client;

import stem.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class _0Questions implements EntryPoint {
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button newGameButton = new Button("Start New Game");
		
		// We can add style names to widgets
		newGameButton.addStyleName("newGameButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("startNewGameContainer").add(newGameButton);
		startNewGame(newGameButton);// Add a handler to close the DialogBox
	
	}

	public void startNewGame(Button newGameButton)
	{
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("Is this person female?");
		final Label errorLabel = new Label();
		
		newGameButton.addDomHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootPanel.get("nameFieldContainer").setVisible(true);
				RootPanel.get("sendButtonContainer").setVisible(true);
				RootPanel.get("errorLabelContainer").setVisible(true);
				RootPanel.get("boxHeaderContainer").setVisible(true);
				greetingService.restart(new AsyncCallback<String>(){
							public void onFailure(Throwable caught) {}
							public void onSuccess(String result) {
								nameField.setText(result);
							}
							});
			}}, ClickEvent.getType());
		
		// Initially hide everything will unhide with the click to new game
		RootPanel.get("nameFieldContainer").setVisible(false);
		RootPanel.get("sendButtonContainer").setVisible(false);
		RootPanel.get("errorLabelContainer").setVisible(false);
		RootPanel.get("boxHeaderContainer").setVisible(false);
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter a yes or no");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				
				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						nameField.setText(SERVER_ERROR);
					}

					public void onSuccess(String result) {
						nameField.setText(result);
						sendButton.setEnabled(true);
						
						if(!result.contains("?"))
						{
							sendButton.setEnabled(false);
							GameEnd(result);
						}
					}
				});
			}
			
			public void GameEnd(String result)
			{
				Button newGameButton = new Button();
				newGameButton.setText("New Game");
				
				final PopupPanel dialogBox = new PopupPanel();
				final Label nameField = new Label();
				nameField.setText(result);
				
				HorizontalPanel hp = new HorizontalPanel();
				hp.add(newGameButton);
				hp.add(nameField);
				
				dialogBox.setWidget(hp);
			    dialogBox.setGlassEnabled(true);
			    dialogBox.setAnimationEnabled(true);
			   
				newGameButton.addDomHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						RootPanel.get("nameFieldContainer").setVisible(true);
						RootPanel.get("sendButtonContainer").setVisible(true);
						RootPanel.get("errorLabelContainer").setVisible(true);
						RootPanel.get("boxHeaderContainer").setVisible(true);
						greetingService.restart(new AsyncCallback<String>(){
									public void onFailure(Throwable caught) {}
									public void onSuccess(String result) {
										nameField.setText(result);
										dialogBox.hide();
									}
									});
					}}, ClickEvent.getType());
				
			    dialogBox.center();
	            dialogBox.show();
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}

}
