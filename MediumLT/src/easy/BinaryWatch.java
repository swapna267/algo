package easy;

import java.util.ArrayList;
import java.util.List;

/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
8,4,2,1
32,16,8,4,2,1

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 */
public class BinaryWatch {


  public List<String> readBinaryWatch(int hour , int minute, int num, int index) {
    List<String> stringVals = new ArrayList<>();

    if(num == 0) {
      if (hour < 12 && minute <60)
        stringVals.add(String.format("%d:%02d",hour,minute));
      return stringVals;
    }

    if (num > 0 && index==10) {
      return stringVals;
    }

    if (hour > 11) {
      return stringVals;
    }

    stringVals.addAll(readBinaryWatch(hour, minute, num, index+1));

      if (index < 4) {
        hour += Math.pow(2,index);
      } else {
        minute += Math.pow(2,index);
      }
    stringVals.addAll(readBinaryWatch(hour, minute, num-1, index+1));

    return stringVals;
  }

}
