package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class RaceResults {
private HashMap<String, TimeDuration> myresult= new HashMap<String, TimeDuration>();

	   public static void main(String args[]) {
	        RaceResults raceRes = new RaceResults();
	        raceRes.onNewResult("participent1", new TimeDuration(-1));
	        raceRes.onNewResult("participent2", new TimeDuration(800));
	        raceRes.onNewResult("participent3", new TimeDuration(800));
	        raceRes.onNewResult("participent4", new TimeDuration(950));
	        raceRes.printResults();
	    }

	    public void onNewResult(String tagNumber, TimeDuration resultTime){
	    	myresult.put(tagNumber, resultTime);
	    }

	    public void printResults(){
	    	TimeDuration  minTime =
	    			Collections.min(myresult.values(), (a, b)->a.getNbSeconds()-b.getNbSeconds());        	
	    	int nbWinners = (int)myresult.entrySet()
	                                        .stream()	
	                                        .filter(a->a.getValue().equals(minTime))
	                                        .count();

	        String affichage = nbWinners>1?" the winnerNumberis "+nbWinners+" winners :\n":"The winner is ";
	        System.out.print(affichage);
	        for (Entry<String, TimeDuration> entry : myresult.entrySet()) {

	            if (entry.getValue().equals(minTime)) {
	                System.out.println(entry.getKey()+" with a result of "+entry.getValue());
	            }
	        }
	        System.out.println("The results of other participants : ");
	        myresult.entrySet()
	                .stream()
	                .filter(a->!a.getValue().equals(minTime))
	                .sorted((t1, t2)->t1.getValue().getNbSeconds()-t2.getValue().getNbSeconds())
	                .forEach(System.out::println);
	    }
	    // nous pouvons inserré un nombre négative pour le nombre de seconde, un message d'erreur s'affiche mais le programme tourne et donne un mauvais résultat
	    
	    
}
