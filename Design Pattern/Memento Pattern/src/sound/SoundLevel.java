package sound;

public class SoundLevel{
	
	String levelNumber;

	public SoundLevel(String levelNumber){
		this.levelNumber = levelNumber;
	}

	@Override
	public String toString(){
		return "Sound number :"+levelNumber;
	}
}