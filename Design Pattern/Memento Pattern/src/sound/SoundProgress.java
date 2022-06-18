package sound;

import java.util.ArrayList;

public class SoundProgress {
	
	ArrayList<SoundLevel> soundLevel = new ArrayList<>();

	public void addLevel(SoundLevel inputTexts){
		soundLevel.add(inputTexts);

	}

	@Override
	public String toString(){
		return "Sound level:"+soundLevel;
	}

	public ArrayList<SoundLevel> getProgressClone(){
		return (ArrayList)soundLevel.clone();
	}


	
	public ProgressMemento saveProgress(){    //save status
		return new ProgressMemento( getProgressClone());
	}

	
	public void undoProgress(ProgressMemento progressMemento){   //undo status
		soundLevel = progressMemento.getProgress();
	}
	

	static class ProgressMemento{

		ArrayList<SoundLevel> soundLevel = new ArrayList<>();

		public ProgressMemento( ArrayList<SoundLevel> soundLevel){
			this.soundLevel = soundLevel;
		}

		private ArrayList<SoundLevel> getProgress(){
			return soundLevel;
		}
	}
}