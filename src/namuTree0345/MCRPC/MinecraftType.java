package namuTree0345.MCRPC;

public enum MinecraftType {
	
	VANILLA(0), VANILLA_LEGACY(1);
	
	final private int num;
	
	MinecraftType(int i) {
		this.num = i;
	}

	public int getNum() {
		return num;
	}

}
