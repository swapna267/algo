package Medium;

import java.util.ArrayList;
import java.util.List;

class OnlineStockSpan {

  List<Integer> dp;
  List<Integer> stockPrice;
  public OnlineStockSpan() {
    dp = new ArrayList();
    stockPrice = new ArrayList();
  }

  public int next(int price) {
    int pointer = dp.size()-1;
    int totalSpan = 1;
    while(pointer >= 0 && price>=stockPrice.get(pointer)) {
      totalSpan+=dp.get(pointer);
      pointer -= dp.get(pointer); //80,70,75, 85
    }
    stockPrice.add(price);
    dp.add(totalSpan);
    return totalSpan;
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
