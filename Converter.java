package it.itsvita.byte19.ufc9.converters;

public class Converter {
    private static final float MS_PER_KMH = 3.6f;
    private static final float METERS_PER_MILE = 1609.34f;

    public float convertKmhMs(float number) {
        return number / MS_PER_KMH;
    }

    public float convertMsKmh(float number) {
        return number * MS_PER_KMH;
    }
    
	public float convertMtMl(float number) {
		return number / METERS_PER_MILE;
	}
	
	public float convertMlMt(float number) {
		return number * METERS_PER_MILE;
	}
    
    public float getMeters() {
        return MS_PER_KMH;
    }
    
    public float getMiles() {
		return METERS_PER_MILE;
	}
}