class Solution {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    //modulo way -- O(log(max(tx,ty)))
    while (tx >= sx && ty >= sy) {
        if (tx == sx && ty == sy)
            return true;
        if (tx > ty) {
            if (ty > sy) {
                tx = tx % ty;
            } else {
                //this means ty == sy, hence we can directly return result
                int diff = tx - sx;
                return (diff % ty == 0);
            }
        } else {
            if (tx > sx) {
                ty = ty % tx;
            } else {
                //this means tx == sx, hence we can directly return result
                int diff = ty - sy;
                return (diff % tx == 0);
            }
        }
    }
    return (tx == sx && ty == sy);
  }
}
