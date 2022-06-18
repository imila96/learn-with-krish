package sound;

import java. util. *;

public class CareTaker{

	Stack<SoundProgress.ProgressMemento>  soundHistory = new Stack<>();
	
	//save  state to the stack
	public void saveProgress(SoundProgress soundProgress){
		soundHistory.push(soundProgress.saveProgress());
	}

	//undo state
	public void undoProgress(SoundProgress soundProgress){
		if(!soundHistory.isEmpty())
			soundProgress.undoProgress(soundHistory.pop());
		else
			System.out.println("undo didnt sucess");
	}
}


