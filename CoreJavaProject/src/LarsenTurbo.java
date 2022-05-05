
public class LarsenTurbo implements SafetyGuidelines2021{

	@Override
	public void protectHead() {
		System.out.println("Fiber helmets used");
		System.out.println(SafetyGuidelines2021.HELMET_THICKNESS);
	}

	@Override
	public void protectFeet() {
		System.out.println("fiber shoes used");		
	}

}
