package es.mastermind.views;

import es.mastermind.models.Game;

public class ConsoleView extends View {

	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

	public ConsoleView (Game game) {
		super(game);
		this.startView = new StartView();
		this.proposalView = new ProposalView(game);
		this.resumeView = new ResumeView(game);
	}

	protected void start(){
		this.startView.interact();
	}

	@Override
	protected void play(){
		this.proposalView.interact();
	}

	@Override
	protected boolean isNewGame(){
		return this.resumeView.interact();
	}
	
}
