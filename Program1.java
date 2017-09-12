package co.sachin.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("19:09"));
	}

	public static String solution(String S) {
		String[] currentHrMin = S.split(":");
		int currentMin = (Integer.parseInt(currentHrMin[0])*60)+Integer.parseInt(currentHrMin[1]);
		Set<Integer> inputSet = new HashSet<Integer>();
		for(int i = 0;i<S.length();i++)
		{
			if(Character.isDigit(S.charAt(i)));{
				inputSet.add(Character.getNumericValue(S.charAt(i)));
			}
			
		}
		
		Integer mCount = 0,hCount = 0;
		if(inputSet.contains(0)) {
			mCount = 0;
			hCount = 0;
		}
		else if(inputSet.contains(1)) {
			mCount = 11;
			hCount = 11;			
		}
		else if(inputSet.contains(2)) {
			mCount = 22;
			hCount = 22;
		}
		
		List<Integer> tempAL = new ArrayList<Integer>();
		List<Integer> minList = new ArrayList<Integer>();
		List<Integer> hrList = new ArrayList<Integer>();
		do {
			tempAL.clear();
			int temp = mCount;
			while(temp > 0 && mCount != 0) {
				tempAL.add(temp%10);
				temp/=10;
			}
			if(tempAL.size()>1 && inputSet.contains(tempAL.get(0)) &&inputSet.contains(tempAL.get(1))) {
				minList.add(mCount);
			}
			else if(tempAL.size()==1 && inputSet.contains(tempAL.get(0))) {
				minList.add(mCount);
			}
			mCount++;
		}while(mCount < 60);

		do {
			tempAL.clear();
			int temp = hCount;
			while(temp > 0) {
				tempAL.add(temp%10);
				temp/=10;
			}
			if(tempAL.size() > 1 &&  inputSet.contains(tempAL.get(0)) &&inputSet.contains(tempAL.get(1))) {
				hrList.add(hCount);
			}
			else if(tempAL.size()==1 && inputSet.contains(tempAL.get(0))) {
				hrList.add(hCount);
			}
			else if(tempAL.size() == 0) {
				hrList.add(0);
			}
			hCount++;
		}while(hCount < 24);

		System.out.println(hrList);
		Map<Integer, String> timeMap = new TreeMap<Integer, String>();
		for(int i = 0; i<hrList.size(); i++) {
			for(int j = 0; j < minList.size(); j++) {
				String hrZero = hrList.get(i)<10 ? "0" :""; 
				String minZero = minList.get(j)<10? "0":"";
				timeMap.put((hrList.get(i)*60)+minList.get(j),hrZero + hrList.get(i)+":"+minZero + minList.get(j));
			}
		}

		String output = null;
		boolean first = true;
		String firstValue = "";
		for(Map.Entry<Integer,String> entry : timeMap.entrySet()) {
			  Integer key = entry.getKey();
			  String value = entry.getValue();
			  if(first) {
				  firstValue = value;
				  first = false;
			  }
			  if(key>currentMin) {
				  output = value;
				  break;
			  }
		}
		if(output == null) {
			output = firstValue;
		}
		return output;
	}
	
	
}