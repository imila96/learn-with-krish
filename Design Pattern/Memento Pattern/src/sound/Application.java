package sound;

public class Application{

	public static void main(String[] args){
		
		CareTaker caretaker = new CareTaker();
		
		SoundProgress soundProgress = new SoundProgress();

		soundProgress.addLevel( new SoundLevel("sound level 3"));
		caretaker.saveProgress(soundProgress);
		System.out.println(soundProgress);

		soundProgress.addLevel( new SoundLevel("sound level 10"));
		caretaker.saveProgress(soundProgress);
		System.out.println(soundProgress);

		caretaker.undoProgress(soundProgress);
		caretaker.undoProgress(soundProgress);
		System.out.println(soundProgress);
		
		soundProgress.addLevel( new SoundLevel("sound level 7"));
		caretaker.saveProgress(soundProgress);
		System.out.println(soundProgress);
		
		soundProgress.addLevel( new SoundLevel("sound level 8"));
		caretaker.saveProgress(soundProgress);
		System.out.println(soundProgress);
		
		caretaker.undoProgress(soundProgress);
		caretaker.undoProgress(soundProgress);
		System.out.println(soundProgress);
	}
}