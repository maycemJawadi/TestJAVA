package test;

import java.util.logging.Logger;

public class TimeDuration {
	private int secondsNumber;
public TimeDuration(int secondsNumber ) {
	if(secondsNumber<0) {try {
		throw new BadBadValueException();}
	catch(BadBadValueException ex) {
		System.err.println(ex.getMessage());
	}
	}
	else
		this.secondsNumber=secondsNumber;
}

	
@Override
public String toString() {
	int hoursnumber = secondsNumber/3600;
    int Minutesnumber = (secondsNumber-hoursnumber*3600)/60;
    int leftSeconds = secondsNumber-hoursnumber*3600-Minutesnumber*60;
    String hours = hoursnumber==0?"":hoursnumber+"h ";
    String minutes =Minutesnumber==0?hoursnumber==0?"":"0m ":Minutesnumber+"m ";
    String seconds = leftSeconds==0?"0s":leftSeconds+"s";
    return hours+""+minutes+""+seconds;
}
public void setNbSeconds(int secondsNumber) {
    this.secondsNumber = secondsNumber;
}

public int getNbSeconds() {
    return secondsNumber;
}

public boolean equals(TimeDuration t) {
	return getNbSeconds()==t.getNbSeconds();
}
}
