package day7;

/* Command Pattern
 * Carrying out a task which involves multiple objects increases complexity
 * To overcome the complexity, we bring in transparency or a layer of indirection to hide the complexity
 */

public class CommandPattern {
	public static void main(String[] args) {
		Television sony = new Television();
		VGame vgame = new VGame();
		SetTopBox tata = new SetTopBox();
		SoundSystem dolby = new SoundSystem();
		
		Command fatherNewsCommand = new NewsChannelCommand(sony, tata, vgame, dolby);
		Command motherHistoryCommand = new HistoryChannelCommand(sony, tata, vgame, dolby);
		Command fatherTennisCommand = new PlayTennisCommand(sony, tata, vgame, dolby);
	
		UniversalRemote remote = new UniversalRemote();
		remote.setCommand(fatherTennisCommand, 0);
		remote.setCommand(fatherNewsCommand, 1);
		remote.setCommand(motherHistoryCommand, 2);
		
		remote.executeCommand(0);
	}
}

class UniversalRemote {
	Command command[] = new Command[5];
	public UniversalRemote() {
		for(int i = 0; i < 5; i++) {
			command[i] = new DummyCommand();
		}
	}
	
	public void executeCommand(int slot) {
		command[slot].execute();
	}
	
	public void setCommand(Command c, int slot) {
		command[slot] = c;
	}
	
	class DummyCommand extends Command {
		@Override
		public void execute() {
			System.out.println("Dummy command - Yet to be operational.");
		}
	}
}

abstract class Command {
	Television sony;
	SetTopBox tata;
	VGame vgame;
	SoundSystem dolby;
	public Command() {
		
	}
	public Command(Television sony, SetTopBox tata, VGame vgame, SoundSystem dolby) {
		this.sony = sony;
		this.tata = tata;
		this.vgame = vgame;
		this.dolby = dolby;
	}
	public abstract void execute();
}

class NewsChannelCommand extends Command {
	public NewsChannelCommand(Television sony, SetTopBox tata, VGame vgame, SoundSystem dolby) {
		super(sony, tata, vgame, dolby);
	}
	@Override
	public void execute() {
		System.out.println("News channel process has begun...");
		sony.switchOn();
		sony.av1Mode();
		dolby.highSound();
		tata.newsChannel();
		System.out.println("Process over... Enjoy watching the news.");
	}
}

class PlayTennisCommand extends Command {
	public PlayTennisCommand(Television sony, SetTopBox tata, VGame vgame, SoundSystem dolby) {
		super(sony, tata, vgame, dolby);
	}
	@Override
	public void execute() {
		System.out.println("Wii Tennis process has begun...");
		sony.switchOn();
		sony.av1Mode();
		dolby.highSound();
		vgame.playTennis();
		System.out.println("Process over... Enjoy playing Wii Tennis.");
	}
}

class HistoryChannelCommand extends Command {
	public HistoryChannelCommand(Television sony, SetTopBox tata, VGame vgame, SoundSystem dolby) {
		super(sony, tata, vgame, dolby);
	}
	@Override
	public void execute() {
		System.out.println("The History Channel process has begun...");
		sony.switchOn();
		sony.av1Mode();
		tata.historyChannel();
		dolby.lowSound();
		System.out.println("Process over... Enjoy watching the History Channel.");
	}
}

class Television {
	public void switchOn() {
		System.out.println("The TV has been switched on.");
	}
	public void av1Mode() {
		System.out.println("AV1 Mode is on.");
	}
}

class SetTopBox {
	public void newsChannel() {
		System.out.println("News channel is on.");
	}
	public void historyChannel() {
		System.out.println("History channel is on.");
	}
}

class SoundSystem {
	public void lowSound() {
		System.out.println("Sound is low.");
	}
	public void highSound() {
		System.out.println("Sound is high.");
	}
}

class VGame {
	public void playTennis() {
		System.out.println("Play tennis.");
	}
}